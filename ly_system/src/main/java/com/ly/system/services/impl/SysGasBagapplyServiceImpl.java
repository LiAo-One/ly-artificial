package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysGasBagapplyMapper;
import com.ly.system.entity.SysGasBagapply;
import com.ly.system.services.SysGasBagapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 加油包申请表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysGasBagapplyServiceImpl extends ServiceImpl<SysGasBagapplyMapper, SysGasBagapply> implements SysGasBagapplyService {

    @Autowired
    private SysGasBagapplyMapper sysGasBagapplyMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysGasBagapply recode) {
        // 分页信息
        IPage<SysGasBagapply> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysGasBagapply> queryWrapper = new QueryWrapper<>();

        // 表申请IdSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getGasBagApplyId()), "gas_bag_apply_id", recode.getGasBagApplyId());
        // 续期申请卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNum()), "card_num", recode.getCardNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardIccid()), "card_iccid", recode.getCardIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardOperator()), "card_operator", recode.getCardOperator());
        // 当前套餐SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewSetmeal()), "renew_setmeal", recode.getRenewSetmeal());
        // 状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStudent()), "student", recode.getStudent());
        // 续期申请套餐类别SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealType()), "meal_type", recode.getMealType());
        // 剩余流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealLastflow()), "meal_lastflow", recode.getMealLastflow());
        // 到期时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getExpireDate()), "expire_date", recode.getExpireDate());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysGasBagapply> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysGasBagapplyMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysGasBagapplyMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysGasBagapplyMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysGasBagapply recode) {
        return R.r(sysGasBagapplyMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysGasBagapply recode) {
        if (StringUtils.isEmpty(recode.getGasBagApplyId())) {
            throw new MissingParametersException("加油包申请表ID");
        }
        return R.r(sysGasBagapplyMapper.updateById(recode));
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
            throw new MissingParametersException("加油包申请表ID");
        }
        return R.r(sysGasBagapplyMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysGasBagapplyMapper.deleteBatchIds(ids));
    }
}
