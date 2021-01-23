package com.ly.system.controller;

import com.ly.commons.annotation.Log;
import com.ly.commons.core.R;
import com.ly.commons.enums.BusinessType;
import com.ly.system.entity.SysDeviceOnline;
import com.ly.system.services.SysDeviceOnlineService;
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
 * 设备上下线记录 前端控制器
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@RestController
@RequestMapping("/sys-device-online")
@Api(tags = {"设备上下线记录"})
public class SysDeviceOnlineController {

    @Autowired
    private SysDeviceOnlineService sysDeviceOnlineService;

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
    @PostMapping("sel_page")
    @ApiOperation("分页、排序、动态条件")
    public R selPage(SysDeviceOnline recode) {
        return sysDeviceOnlineService.selPage(recode);
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
        return sysDeviceOnlineService.findById(id);
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
        return sysDeviceOnlineService.findByIds(ids);
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @PostMapping("add")
    @ApiOperation("添加数据")
    @Log(title = "设备上下线记录",businessType = BusinessType.INSERT)
    public R add(SysDeviceOnline recode) {
        return sysDeviceOnlineService.add(recode);
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @PostMapping("upd_id")
    @ApiOperation("根据id修改")
    @Log(title = "设备上下线记录",businessType = BusinessType.UPDATE)
    public R upd(SysDeviceOnline recode) {
        return sysDeviceOnlineService.updById(recode);
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @PostMapping("del_id")
    @ApiOperation("根据id删除")
    @Log(title = "设备上下线记录", businessType = BusinessType.DELETE)
    public R delete(Long id){
        return sysDeviceOnlineService.delete(id);
    }

    /**
     * 根据ids批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @PostMapping("del_ids")
    @ApiOperation("根据ids批量删除")
    @Log(title = "设备上下线记录", businessType = BusinessType.DELETE)
    public R deletes(@RequestParam("ids") List<Long> ids){
        return sysDeviceOnlineService.deletes(ids);
    }
}
