package com.ly.system.controller;


import com.ly.commons.annotation.Log;
import com.ly.commons.constant.UserConstants;
import com.ly.commons.core.R;
import com.ly.commons.core.entity.SysDept;
import com.ly.commons.enums.BusinessType;
import com.ly.commons.utils.StringUtils;
import com.ly.system.services.ISysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


/**
 * <p>
 * 项目信息 拦截层
 * </p>
 *
 * @author LiAo
 * @since 2021/1/20
 */
@RestController
@RequestMapping("/system/dept")
@Api(tags = {"项目信息表"})
public class SysDeptController /*extends BaseController*/
{
    @Autowired
    private ISysDeptService deptService;

    /**
     * 获取项目列表
     */
    @GetMapping("/list")
    @ApiOperation("获取项目列表")
    public R list(SysDept dept)
    {
        List<SysDept> depts = deptService.selectDeptList(dept);
        return R.success(depts);
    }

    /**
     * 查询项目列表（排除节点）
     */
    @GetMapping("/list/exclude/{deptId}")
    @ApiOperation("询项目列表（排除节点）")
    public R excludeChild(@PathVariable(value = "deptId", required = false) Long deptId)
    {
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        Iterator<SysDept> it = depts.iterator();
        while (it.hasNext())
        {
            SysDept d = (SysDept) it.next();
            if (d.getDeptId().intValue() == deptId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), deptId + ""))
            {
                it.remove();
            }
        }
        return R.success(depts);
    }

    /**
     * 根据项目编号获取详细信息
     */
    @GetMapping(value = "/{deptId}")
    @ApiOperation("根据项目编号获取详细信息")
    public R getInfo(@PathVariable Long deptId)
    {
        return R.success(deptService.selectDeptById(deptId));
    }

    /**
     * 获取项目下拉树列表
     */
    @GetMapping("/treeselect")
    @ApiOperation("获取项目下拉树列表")
    public R treeselect(SysDept dept)
    {
        List<SysDept> depts = deptService.selectDeptList(dept);
        return R.success(deptService.buildDeptTreeSelect(depts));
    }

    /**
     * 加载对应角色项目列表树
     */
    /*@GetMapping(value = "/roleDeptTreeselect/{roleId}")
    public R roleDeptTreeselect(@PathVariable("roleId") Long roleId)
    {
        List<SysDept> depts = deptService.selectDeptList(new SysDept());
        R ajax = R.success();
        ajax.put("checkedKeys", deptService.selectDeptListByRoleId(roleId));
        ajax.put("depts", deptService.buildDeptTreeSelect(depts));
        return ajax;
    }*/

    /**
     * 新增项目
     */
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation("新增项目")
    public R add(@Validated @RequestBody SysDept dept)
    {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return R.error("新增项目'" + dept.getDeptName() + "'失败，项目名称已存在");
        }
        /*dept.setCreateBy(SecurityUtils.getUsername());*/
        return R.r(deptService.insertDept(dept));
    }

    /**
     * 修改项目
     */
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改项目")
    public R edit(@Validated @RequestBody SysDept dept)
    {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept)))
        {
            return R.error("修改项目'" + dept.getDeptName() + "'失败，项目名称已存在");
        }
        else if (dept.getParentId().equals(dept.getDeptId()))
        {
            return R.error("修改项目'" + dept.getDeptName() + "'失败，上级项目不能是自己");
        }
        else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus())
                && deptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0)
        {
            return R.error("该项目包含未停用的子项目！");
        }
        return R.r(deptService.updateDept(dept));
    }

    /**
     * 删除项目
     */
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptId}")
    @ApiOperation("删除项目")
    public R remove(@PathVariable Long deptId)
    {
        if (deptService.hasChildByDeptId(deptId))
        {
            return R.error("存在下级项目,不允许删除");
        }
        /*if (deptService.checkDeptExistUser(deptId))
        {
            return R.error("项目存在用户,不允许删除");
        }*/
        return R.r(deptService.deleteDeptById(deptId));
    }
}
