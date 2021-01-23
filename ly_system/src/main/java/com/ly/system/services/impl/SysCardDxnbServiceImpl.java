package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysCardDxnbMapper;
import com.ly.system.entity.SysCardDxnb;
import com.ly.system.services.SysCardDxnbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 电信NB卡表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysCardDxnbServiceImpl extends ServiceImpl<SysCardDxnbMapper, SysCardDxnb> implements SysCardDxnbService {

    @Autowired
    private SysCardDxnbMapper sysCardDxnbMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysCardDxnb recode) {
        // 分页信息
        IPage<SysCardDxnb> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysCardDxnb> queryWrapper = new QueryWrapper<>();

        // 电信NB卡主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDxnbCardId()), "dxnb_card_id", recode.getDxnbCardId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDxnbNum()), "dxnb_num", recode.getDxnbNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDxnbiccid()), "dxnbiccid", recode.getDxnbiccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDxnbOperators()), "dxnb_operators", recode.getDxnbOperators());
        // 类别 0：年卡 SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardType()), "card_type", recode.getCardType());
        // 状态 0：正常SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardState()), "card_state", recode.getCardState());
        // 激活时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardActiDate()), "card_acti_date", recode.getCardActiDate());
        // 过期时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardTimeout()), "card_timeout", recode.getCardTimeout());
        // 提醒（0：开启:1：关闭）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardRemind()), "card_remind", recode.getCardRemind());
        // pms模式SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardPms()), "card_pms", recode.getCardPms());
        // 批次号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardBatchnum()), "card_batchnum", recode.getCardBatchnum());
        // 标签SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardLable()), "card_lable", recode.getCardLable());
        // 备注SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNote()), "card_note", recode.getCardNote());
        //  关联（用户）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardRelation1()), "card_relation1", recode.getCardRelation1());
        // 用户姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardUserName()), "card_user_name", recode.getCardUserName());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysCardDxnb> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysCardDxnbMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysCardDxnbMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysCardDxnbMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysCardDxnb recode) {
        return R.r(sysCardDxnbMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysCardDxnb recode) {
        if (StringUtils.isEmpty(recode.getDxnbCardId())) {
            throw new MissingParametersException("电信NB卡表ID");
        }
        return R.r(sysCardDxnbMapper.updateById(recode));
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
            throw new MissingParametersException("电信NB卡表ID");
        }
        return R.r(sysCardDxnbMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysCardDxnbMapper.deleteBatchIds(ids));
    }
}
