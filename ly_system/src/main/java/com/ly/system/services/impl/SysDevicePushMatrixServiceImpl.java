package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysDevicePushMatrixMapper;
import com.ly.system.entity.SysDevicePushMatrix;
import com.ly.system.services.SysDevicePushMatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 设备推送矩阵记录 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-04-12
 */
@Service
public class SysDevicePushMatrixServiceImpl extends ServiceImpl<SysDevicePushMatrixMapper, SysDevicePushMatrix> implements SysDevicePushMatrixService {

    @Autowired
    private SysDevicePushMatrixMapper sysDevicePushMatrixMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysDevicePushMatrix recode) {
        // 分页信息
        IPage<SysDevicePushMatrix> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysDevicePushMatrix> queryWrapper = new QueryWrapper<>();

        // 设备推送idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmId()), "dpm_id", recode.getDpmId());
        // 设备表idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmDevice()), "dpm_device", recode.getDpmDevice());
        // 网关编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmGate()), "dpm_gate", recode.getDpmGate());
        // 片区编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmArea()), "dpm_area", recode.getDpmArea());
        // 设备编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmDeviceId()), "dpm_device_id", recode.getDpmDeviceId());
        // 设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmDeviceName()), "dpm_device_name", recode.getDpmDeviceName());
        // 项目推送识别码 表示向哪个项目推送数据SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDpmProjectId()), "dpm_project_id", recode.getDpmProjectId());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<SysDevicePushMatrix> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysDevicePushMatrixMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysDevicePushMatrixMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysDevicePushMatrixMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysDevicePushMatrix recode) {
        return R.r(sysDevicePushMatrixMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysDevicePushMatrix recode) {
        if (StringUtils.isEmpty(recode.getDpmId())) {
            throw new MissingParametersException("设备推送矩阵记录ID");
        }
        return R.r(sysDevicePushMatrixMapper.updateById(recode));
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
            throw new MissingParametersException("设备推送矩阵记录ID");
        }
        return R.r(sysDevicePushMatrixMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysDevicePushMatrixMapper.deleteBatchIds(ids));
    }
}
