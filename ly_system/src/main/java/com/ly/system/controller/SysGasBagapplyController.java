package com.ly.system.controller;

import com.ly.commons.annotation.Log;
import com.ly.commons.core.R;
import com.ly.commons.enums.BusinessType;
import com.ly.system.entity.SysGasBagapply;
import com.ly.system.services.SysGasBagapplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 加油包申请表 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@RestController
@RequestMapping("/sys-gas-bagapply")
@Api(tags = {"加油包申请表"})
public class SysGasBagapplyController {

    @Autowired
    private SysGasBagapplyService sysGasBagapplyService;

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(SysGasBagapply recode) {
        return sysGasBagapplyService.selPage(recode);
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("sel_id")
    @ApiOperation("根据id查询数据")
    public R findById(Long id){
        return sysGasBagapplyService.findById(id);
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @PostMapping("sel_ids")
    @ApiOperation("根据ids批量查询")
    public R findByIds(@RequestParam("ids") List<Long> ids){
        return sysGasBagapplyService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    @Log(title = "加油包申请表",businessType = BusinessType.INSERT)
    public R add(SysGasBagapply recode) {
        return sysGasBagapplyService.add(recode);
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    @Log(title = "加油包申请表",businessType = BusinessType.UPDATE)
    public R upd(SysGasBagapply recode) {
        return sysGasBagapplyService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    @Log(title = "加油包申请表", businessType = BusinessType.DELETE)
    public R delete(Long id){
        return sysGasBagapplyService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    @Log(title = "加油包申请表", businessType = BusinessType.DELETE)
    public R deletes(@RequestParam("ids") List<Long> ids){
        return sysGasBagapplyService.deletes(ids);
    }
}
