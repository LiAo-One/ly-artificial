package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysFlowPoolMapper;
import com.ly.system.entity.SysFlowPool;
import com.ly.system.services.SysFlowPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 流量池表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysFlowPoolServiceImpl extends ServiceImpl<SysFlowPoolMapper, SysFlowPool> implements SysFlowPoolService {

    @Autowired
    private SysFlowPoolMapper sysFlowPoolMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysFlowPool recode) {
        // 分页信息
        IPage<SysFlowPool> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysFlowPool> queryWrapper = new QueryWrapper<>();

        // SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolId()), "pool_id", recode.getPoolId());
        // 流量池编码SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolCode()), "pool_code", recode.getPoolCode());
        // 套餐信息SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getSetmealInfo()), "setmeal_info", recode.getSetmealInfo());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestOperators()), "dest_operators", recode.getDestOperators());
        // APN 名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestApn()), "dest_apn", recode.getDestApn());
        // 年流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolTitFlow()), "pool_tit_flow", recode.getPoolTitFlow());
        // 已使用SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolUsedFlow()), "pool_used_flow", recode.getPoolUsedFlow());
        // 剩余流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolHaveFlow()), "pool_have_flow", recode.getPoolHaveFlow());
        // 扩容包已用流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolSpreadFlow()), "pool_spread_flow", recode.getPoolSpreadFlow());
        // 是否自动扩容 0否 1是SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPoolAutomatic()), "pool_automatic", recode.getPoolAutomatic());
        // 成员数量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMemberAmount()), "member_amount", recode.getMemberAmount());
        // 更新时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysFlowPool> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysFlowPoolMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysFlowPoolMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysFlowPoolMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysFlowPool recode) {
        return R.r(sysFlowPoolMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysFlowPool recode) {
        if (StringUtils.isEmpty(recode.getPoolId())) {
            throw new MissingParametersException("流量池表ID");
        }
        return R.r(sysFlowPoolMapper.updateById(recode));
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
            throw new MissingParametersException("流量池表ID");
        }
        return R.r(sysFlowPoolMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysFlowPoolMapper.deleteBatchIds(ids));
    }
}
