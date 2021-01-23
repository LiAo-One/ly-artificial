package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysDeviceMapper;
import com.ly.system.entity.SysDevice;
import com.ly.system.services.SysDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-20
 */
@Service
public class SysDeviceServiceImpl extends ServiceImpl<SysDeviceMapper, SysDevice> implements SysDeviceService {

    @Autowired
    private SysDeviceMapper sysDeviceMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysDevice recode) {
        // 分页信息
        IPage<SysDevice> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysDevice> queryWrapper = new QueryWrapper<>();

        // 设备idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceId()), "device_id", recode.getDeviceId());
        // 设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceName()), "device_name", recode.getDeviceName());
        // SNSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceSn()), "device_sn", recode.getDeviceSn());
        // 所属项目名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceProject()), "device_project", recode.getDeviceProject());
        // 分组SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceGrouping()), "device_grouping", recode.getDeviceGrouping());
        // 地址SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceAddress()), "device_address", recode.getDeviceAddress());
        // 标签SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceLabel()), "device_label", recode.getDeviceLabel());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysDevice> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysDeviceMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysDeviceMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysDeviceMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysDevice recode) {
        return R.r(sysDeviceMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysDevice recode) {
        if (StringUtils.isEmpty(recode.getDeviceId())) {
            throw new MissingParametersException("设备表ID");
        }
        return R.r(sysDeviceMapper.updateById(recode));
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R delete(Long id){
        if (StringUtils.isEmpty(id)) {
            throw new MissingParametersException("设备表ID");
        }
        return R.r(sysDeviceMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysDeviceMapper.deleteBatchIds(ids));
    }
}
