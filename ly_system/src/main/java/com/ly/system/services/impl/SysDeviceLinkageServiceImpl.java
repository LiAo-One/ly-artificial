package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysDeviceLinkageMapper;
import com.ly.system.entity.SysDeviceLinkage;
import com.ly.system.services.SysDeviceLinkageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 设备联动记录 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysDeviceLinkageServiceImpl extends ServiceImpl<SysDeviceLinkageMapper, SysDeviceLinkage> implements SysDeviceLinkageService {

    @Autowired
    private SysDeviceLinkageMapper sysDeviceLinkageMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysDeviceLinkage recode) {
        // 分页信息
        IPage<SysDeviceLinkage> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysDeviceLinkage> queryWrapper = new QueryWrapper<>();

        // 联动记录idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLinkageId()), "linkage_id", recode.getLinkageId());
        // 联动名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLinkageName()), "linkage_name", recode.getLinkageName());
        // 联动来源SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLinkageSource()), "linkage_source", recode.getLinkageSource());
        // 联动设备SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLinkageeDevice()), "linkagee_device", recode.getLinkageeDevice());
        // 从机名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getSlaveName()), "slave_name", recode.getSlaveName());
        // 变量名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVariableName()), "variable_name", recode.getVariableName());
        // 触发条件SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getSparkCondition()), "spark_condition", recode.getSparkCondition());
        // 触发设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceName()), "device_name", recode.getDeviceName());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysDeviceLinkage> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysDeviceLinkageMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysDeviceLinkageMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysDeviceLinkageMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysDeviceLinkage recode) {
        return R.r(sysDeviceLinkageMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysDeviceLinkage recode) {
        if (StringUtils.isEmpty(recode.getLinkageId())) {
            throw new MissingParametersException("设备联动记录ID");
        }
        return R.r(sysDeviceLinkageMapper.updateById(recode));
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
            throw new MissingParametersException("设备联动记录ID");
        }
        return R.r(sysDeviceLinkageMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysDeviceLinkageMapper.deleteBatchIds(ids));
    }
}
