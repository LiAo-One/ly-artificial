package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysCardDealingMapper;
import com.ly.system.entity.SysCardDealing;
import com.ly.system.services.SysCardDealingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 卡分配表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysCardDealingServiceImpl extends ServiceImpl<SysCardDealingMapper, SysCardDealing> implements SysCardDealingService {

    @Autowired
    private SysCardDealingMapper sysCardDealingMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysCardDealing recode) {
        // 分页信息
        IPage<SysCardDealing> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysCardDealing> queryWrapper = new QueryWrapper<>();

        // 卡分配idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDealingId()), "dealing_id", recode.getDealingId());
        // 用户idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDealingUserid()), "dealing_userid", recode.getDealingUserid());
        // 账户SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDealingAccount()), "dealing_account", recode.getDealingAccount());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDealingIccid()), "dealing_iccid", recode.getDealingIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getOperators()), "operators", recode.getOperators());
        // 计费类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getBillingType()), "billing_type", recode.getBillingType());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysCardDealing> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysCardDealingMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysCardDealingMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysCardDealingMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysCardDealing recode) {
        return R.r(sysCardDealingMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysCardDealing recode) {
        if (StringUtils.isEmpty(recode.getDealingId())) {
            throw new MissingParametersException("卡分配表ID");
        }
        return R.r(sysCardDealingMapper.updateById(recode));
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
            throw new MissingParametersException("卡分配表ID");
        }
        return R.r(sysCardDealingMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysCardDealingMapper.deleteBatchIds(ids));
    }
}
