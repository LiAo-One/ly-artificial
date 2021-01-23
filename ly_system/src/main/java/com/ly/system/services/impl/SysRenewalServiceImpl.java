package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysRenewalMapper;
import com.ly.system.entity.SysRenewal;
import com.ly.system.services.SysRenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 续期申请表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysRenewalServiceImpl extends ServiceImpl<SysRenewalMapper, SysRenewal> implements SysRenewalService {

    @Autowired
    private SysRenewalMapper sysRenewalMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysRenewal recode) {
        // 分页信息
        IPage<SysRenewal> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysRenewal> queryWrapper = new QueryWrapper<>();

        // 续期申请IdSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewalApplyId()), "renewal_apply_id", recode.getRenewalApplyId());
        // 申请卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewNum()), "renew_num", recode.getRenewNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewIccid()), "renew_iccid", recode.getRenewIccid());
        // 状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewStatue()), "renew_statue", recode.getRenewStatue());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewOperator()), "renew_operator", recode.getRenewOperator());
        // 卡号类别（1--》 流量卡 、 2 ---电信NB卡）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewType()), "renew_type", recode.getRenewType());
        // 当前套餐SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewSetmeal()), "renew_setmeal", recode.getRenewSetmeal());
        // 剩余流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealLastflow()), "meal_lastflow", recode.getMealLastflow());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysRenewal> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysRenewalMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysRenewalMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysRenewalMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysRenewal recode) {
        return R.r(sysRenewalMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysRenewal recode) {
        if (StringUtils.isEmpty(recode.getRenewalApplyId())) {
            throw new MissingParametersException("续期申请表ID");
        }
        return R.r(sysRenewalMapper.updateById(recode));
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
            throw new MissingParametersException("续期申请表ID");
        }
        return R.r(sysRenewalMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysRenewalMapper.deleteBatchIds(ids));
    }
}
