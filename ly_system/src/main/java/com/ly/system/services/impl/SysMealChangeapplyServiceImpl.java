package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysMealChangeapplyMapper;
import com.ly.system.entity.SysMealChangeapply;
import com.ly.system.services.SysMealChangeapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 套餐变更申请 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysMealChangeapplyServiceImpl extends ServiceImpl<SysMealChangeapplyMapper, SysMealChangeapply> implements SysMealChangeapplyService {

    @Autowired
    private SysMealChangeapplyMapper sysMealChangeapplyMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysMealChangeapply recode) {
        // 分页信息
        IPage<SysMealChangeapply> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysMealChangeapply> queryWrapper = new QueryWrapper<>();

        // 变更申请IdSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealChangeApplyId()), "meal_change_apply_id", recode.getMealChangeApplyId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNum()), "card_num", recode.getCardNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardIccid()), "card_iccid", recode.getCardIccid());
        // 状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardState()), "card_state", recode.getCardState());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardOpear()), "card_opear", recode.getCardOpear());
        // 类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardType()), "card_type", recode.getCardType());
        // 当前套餐SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardCurMeal()), "card_cur_meal", recode.getCardCurMeal());
        // 剩余流量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardHaveFlow()), "card_have_flow", recode.getCardHaveFlow());
        // 到期时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardTimeout()), "card_timeout", recode.getCardTimeout());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysMealChangeapply> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysMealChangeapplyMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysMealChangeapplyMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysMealChangeapplyMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysMealChangeapply recode) {
        return R.r(sysMealChangeapplyMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysMealChangeapply recode) {
        if (StringUtils.isEmpty(recode.getMealChangeApplyId())) {
            throw new MissingParametersException("套餐变更申请ID");
        }
        return R.r(sysMealChangeapplyMapper.updateById(recode));
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
            throw new MissingParametersException("套餐变更申请ID");
        }
        return R.r(sysMealChangeapplyMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysMealChangeapplyMapper.deleteBatchIds(ids));
    }
}
