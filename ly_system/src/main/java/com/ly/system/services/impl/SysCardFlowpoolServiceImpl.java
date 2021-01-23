package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysCardFlowpoolMapper;
import com.ly.system.entity.SysCardFlowpool;
import com.ly.system.services.SysCardFlowpoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 流量池卡表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysCardFlowpoolServiceImpl extends ServiceImpl<SysCardFlowpoolMapper, SysCardFlowpool> implements SysCardFlowpoolService {

    @Autowired
    private SysCardFlowpoolMapper sysCardFlowpoolMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysCardFlowpool recode) {
        // 分页信息
        IPage<SysCardFlowpool> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysCardFlowpool> queryWrapper = new QueryWrapper<>();

        // 流量池卡主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFlowpoolCardId()), "flowpool_card_id", recode.getFlowpoolCardId());
        // 流量池idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFlowpoolPondId()), "flowpool_pond_id", recode.getFlowpoolPondId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFlowpoolNum()), "flowpool_num", recode.getFlowpoolNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFlowpoolIccid()), "flowpool_iccid", recode.getFlowpoolIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getOperators()), "operators", recode.getOperators());
        // 类别 0：年卡 1：月卡SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardType()), "card_type", recode.getCardType());
        // 状态 0：正常 1：停机SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardState()), "card_state", recode.getCardState());
        // 年流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardTitFlow()), "card_tit_flow", recode.getCardTitFlow());
        // 已使用SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardUsedFlow()), "card_used_flow", recode.getCardUsedFlow());
        // 剩余流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardHaveFlow()), "card_have_flow", recode.getCardHaveFlow());
        // 激活时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardActiDate()), "card_acti_date", recode.getCardActiDate());
        // 过期时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardTimeout()), "card_timeout", recode.getCardTimeout());
        // 批次号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardBatchnum()), "card_batchnum", recode.getCardBatchnum());
        // 用户idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardRelation1()), "card_relation1", recode.getCardRelation1());
        // 用户姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardUserName()), "card_user_name", recode.getCardUserName());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysCardFlowpool> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysCardFlowpoolMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysCardFlowpoolMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysCardFlowpoolMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysCardFlowpool recode) {
        return R.r(sysCardFlowpoolMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysCardFlowpool recode) {
        if (StringUtils.isEmpty(recode.getFlowpoolCardId())) {
            throw new MissingParametersException("流量池卡表ID");
        }
        return R.r(sysCardFlowpoolMapper.updateById(recode));
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
            throw new MissingParametersException("流量池卡表ID");
        }
        return R.r(sysCardFlowpoolMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysCardFlowpoolMapper.deleteBatchIds(ids));
    }
}
