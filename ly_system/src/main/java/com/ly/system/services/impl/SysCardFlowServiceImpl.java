package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysCardFlowMapper;
import com.ly.system.entity.SysCardFlow;
import com.ly.system.services.SysCardFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 流量卡表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysCardFlowServiceImpl extends ServiceImpl<SysCardFlowMapper, SysCardFlow> implements SysCardFlowService {

    @Autowired
    private SysCardFlowMapper sysCardFlowMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysCardFlow recode) {
        // 分页信息
        IPage<SysCardFlow> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysCardFlow> queryWrapper = new QueryWrapper<>();

        // 流量卡主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getFlowCardId()), "flow_card_id", recode.getFlowCardId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNum()), "card_num", recode.getCardNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardIccid()), "card_iccid", recode.getCardIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getOperators()), "operators", recode.getOperators());
        // 类别 0：年卡 SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardType()), "card_type", recode.getCardType());
        // 状态 0：正常SysOpenLogServiceImpl.java
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
        // 提醒（0：开启:1：关闭）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardRemind()), "card_remind", recode.getCardRemind());
        // 批次号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardBatchnum()), "card_batchnum", recode.getCardBatchnum());
        // 认证状态（0：需要 1：不需要）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardAuthState()), "card_auth_state", recode.getCardAuthState());
        // 标签SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardLable()), "card_lable", recode.getCardLable());
        // 备注SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNote()), "card_note", recode.getCardNote());
        //  用户idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardUserid()), "card_userid", recode.getCardUserid());
        // 用户姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardUserName()), "card_user_name", recode.getCardUserName());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysCardFlow> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysCardFlowMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysCardFlowMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysCardFlowMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysCardFlow recode) {
        return R.r(sysCardFlowMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysCardFlow recode) {
        if (StringUtils.isEmpty(recode.getFlowCardId())) {
            throw new MissingParametersException("流量卡表ID");
        }
        return R.r(sysCardFlowMapper.updateById(recode));
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
            throw new MissingParametersException("流量卡表ID");
        }
        return R.r(sysCardFlowMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysCardFlowMapper.deleteBatchIds(ids));
    }
}
