package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysAlarmlogMapper;
import com.ly.system.entity.SysAlarmlog;
import com.ly.system.services.SysAlarmlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 报警日志表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Service
public class SysAlarmlogServiceImpl extends ServiceImpl<SysAlarmlogMapper, SysAlarmlog> implements SysAlarmlogService {

    @Autowired
    private SysAlarmlogMapper sysAlarmlogMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysAlarmlog recode) {
        // 分页信息
        IPage<SysAlarmlog> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysAlarmlog> queryWrapper = new QueryWrapper<>();

        // 日志idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAlarmlogId()), "alarmlog_id", recode.getAlarmlogId());
        // 报警类型（0: 流量池-流量不足预警 1: 套餐到期提醒 2：套餐临期预警）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAlarmlogType()), "alarmlog_type", recode.getAlarmlogType());
        // 报警内容SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAlarmlogContent()), "alarmlog_content", recode.getAlarmlogContent());
        // 警报关联数量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRelationAmount()), "relation_amount", recode.getRelationAmount());
        // 状态（0: 未查看 1: 已查看）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getState()), "state", recode.getState());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysAlarmlog> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysAlarmlogMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysAlarmlogMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysAlarmlogMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysAlarmlog recode) {
        return R.r(sysAlarmlogMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysAlarmlog recode) {
        if (StringUtils.isEmpty(recode.getAlarmlogId())) {
            throw new MissingParametersException("报警日志表ID");
        }
        return R.r(sysAlarmlogMapper.updateById(recode));
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
            throw new MissingParametersException("报警日志表ID");
        }
        return R.r(sysAlarmlogMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysAlarmlogMapper.deleteBatchIds(ids));
    }
}
