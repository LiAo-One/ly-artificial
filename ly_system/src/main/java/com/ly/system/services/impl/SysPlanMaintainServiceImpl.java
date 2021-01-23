package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysPlanMaintainMapper;
import com.ly.system.entity.SysPlanMaintain;
import com.ly.system.services.SysPlanMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 维保计划表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysPlanMaintainServiceImpl extends ServiceImpl<SysPlanMaintainMapper, SysPlanMaintain> implements SysPlanMaintainService {

    @Autowired
    private SysPlanMaintainMapper sysPlanMaintainMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysPlanMaintain recode) {
        // 分页信息
        IPage<SysPlanMaintain> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysPlanMaintain> queryWrapper = new QueryWrapper<>();

        // 维保计划idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlanId()), "plan_id", recode.getPlanId());
        // 维保计划名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlanName()), "plan_name", recode.getPlanName());
        // 所属项目SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlanProject()), "plan_project", recode.getPlanProject());
        // 维保设备SNSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlanDeviceSn()), "plan_device_sn", recode.getPlanDeviceSn());
        // 计划状态0 待处理 1 已派单 2 执行中SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlanStudent()), "plan_student", recode.getPlanStudent());
        // 计划状态0 待处理 1 已派单 2 执行中SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPlanType()), "plan_type", recode.getPlanType());
        // 下次维保时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNextTime()), "next_time", recode.getNextTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysPlanMaintain> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysPlanMaintainMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysPlanMaintainMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysPlanMaintainMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysPlanMaintain recode) {
        return R.r(sysPlanMaintainMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysPlanMaintain recode) {
        if (StringUtils.isEmpty(recode.getPlanId())) {
            throw new MissingParametersException("维保计划表ID");
        }
        return R.r(sysPlanMaintainMapper.updateById(recode));
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
            throw new MissingParametersException("维保计划表ID");
        }
        return R.r(sysPlanMaintainMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysPlanMaintainMapper.deleteBatchIds(ids));
    }
}
