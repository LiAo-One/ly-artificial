package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysAlarmRecordMapper;
import com.ly.system.entity.SysAlarmRecord;
import com.ly.system.services.SysAlarmRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 报警记录 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysAlarmRecordServiceImpl extends ServiceImpl<SysAlarmRecordMapper, SysAlarmRecord> implements SysAlarmRecordService {

    @Autowired
    private SysAlarmRecordMapper sysAlarmRecordMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysAlarmRecord recode) {
        // 分页信息
        IPage<SysAlarmRecord> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysAlarmRecord> queryWrapper = new QueryWrapper<>();

        // 设备idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRecordId()), "record_id", recode.getRecordId());
        // 设备名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceName()), "device_name", recode.getDeviceName());
        // 从机名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getSlaveName()), "slave_name", recode.getSlaveName());
        // 变量名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getVariableName()), "variable_name", recode.getVariableName());
        // 当前值SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCurrentValuet()), "current_valuet", recode.getCurrentValuet());
        // 触发条件SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCurrentSpark()), "current_spark", recode.getCurrentSpark());
        // 当前状态 0正常 1异常SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStudent()), "student", recode.getStudent());
        // 是否处理 0处理 1 未处理SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getIsProcess()), "is_process", recode.getIsProcess());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysAlarmRecord> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysAlarmRecordMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysAlarmRecordMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysAlarmRecordMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysAlarmRecord recode) {
        return R.r(sysAlarmRecordMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysAlarmRecord recode) {
        if (StringUtils.isEmpty(recode.getRecordId())) {
            throw new MissingParametersException("报警记录ID");
        }
        return R.r(sysAlarmRecordMapper.updateById(recode));
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
            throw new MissingParametersException("报警记录ID");
        }
        return R.r(sysAlarmRecordMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysAlarmRecordMapper.deleteBatchIds(ids));
    }
}
