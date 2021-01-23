package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysRenewalrecordMapper;
import com.ly.system.entity.SysRenewalrecord;
import com.ly.system.services.SysRenewalrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 续期记录表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysRenewalrecordServiceImpl extends ServiceImpl<SysRenewalrecordMapper, SysRenewalrecord> implements SysRenewalrecordService {

    @Autowired
    private SysRenewalrecordMapper sysRenewalrecordMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysRenewalrecord recode) {
        // 分页信息
        IPage<SysRenewalrecord> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysRenewalrecord> queryWrapper = new QueryWrapper<>();

        // 续期记录idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRenewalrecordId()), "renewalrecord_id", recode.getRenewalrecordId());
        // 续期申请卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNum()), "card_num", recode.getCardNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardIccid()), "card_iccid", recode.getCardIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardOperator()), "card_operator", recode.getCardOperator());
        // 状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStudent()), "student", recode.getStudent());
        // 续期申请套餐类别SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealType()), "meal_type", recode.getMealType());
        // 套餐单价SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealUnitprice()), "meal_unitprice", recode.getMealUnitprice());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysRenewalrecord> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysRenewalrecordMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysRenewalrecordMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysRenewalrecordMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysRenewalrecord recode) {
        return R.r(sysRenewalrecordMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysRenewalrecord recode) {
        if (StringUtils.isEmpty(recode.getRenewalrecordId())) {
            throw new MissingParametersException("续期记录表ID");
        }
        return R.r(sysRenewalrecordMapper.updateById(recode));
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
            throw new MissingParametersException("续期记录表ID");
        }
        return R.r(sysRenewalrecordMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysRenewalrecordMapper.deleteBatchIds(ids));
    }
}
