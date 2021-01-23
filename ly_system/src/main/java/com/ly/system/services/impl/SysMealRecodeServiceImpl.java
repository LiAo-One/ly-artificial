package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysMealRecodeMapper;
import com.ly.system.entity.SysMealRecode;
import com.ly.system.services.SysMealRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 套餐变更记录 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysMealRecodeServiceImpl extends ServiceImpl<SysMealRecodeMapper, SysMealRecode> implements SysMealRecodeService {

    @Autowired
    private SysMealRecodeMapper sysMealRecodeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysMealRecode recode) {
        // 分页信息
        IPage<SysMealRecode> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysMealRecode> queryWrapper = new QueryWrapper<>();

        // 订单号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMealChangeRecodeId()), "meal_change_recode_id", recode.getMealChangeRecodeId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardNum()), "card_num", recode.getCardNum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardIccid()), "card_iccid", recode.getCardIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCardOpear()), "card_opear", recode.getCardOpear());
        // 状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getState()), "state", recode.getState());
        // 老套餐名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getOldMealName()), "old_meal_name", recode.getOldMealName());
        // 新套餐名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNewMealName()), "new_meal_name", recode.getNewMealName());
        // 单价格SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUnitPrice()), "unit_price", recode.getUnitPrice());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysMealRecode> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysMealRecodeMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysMealRecodeMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysMealRecodeMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysMealRecode recode) {
        return R.r(sysMealRecodeMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysMealRecode recode) {
        if (StringUtils.isEmpty(recode.getMealChangeRecodeId())) {
            throw new MissingParametersException("套餐变更记录ID");
        }
        return R.r(sysMealRecodeMapper.updateById(recode));
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
            throw new MissingParametersException("套餐变更记录ID");
        }
        return R.r(sysMealRecodeMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysMealRecodeMapper.deleteBatchIds(ids));
    }
}
