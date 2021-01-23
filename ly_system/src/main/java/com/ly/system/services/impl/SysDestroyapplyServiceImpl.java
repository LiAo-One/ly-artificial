package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysDestroyapplyMapper;
import com.ly.system.entity.SysDestroyapply;
import com.ly.system.services.SysDestroyapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 销卡申请表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysDestroyapplyServiceImpl extends ServiceImpl<SysDestroyapplyMapper, SysDestroyapply> implements SysDestroyapplyService {

    @Autowired
    private SysDestroyapplyMapper sysDestroyapplyMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysDestroyapply recode) {
        // 分页信息
        IPage<SysDestroyapply> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysDestroyapply> queryWrapper = new QueryWrapper<>();

        // 主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestId()), "dest_id", recode.getDestId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestCardnum()), "dest_cardnum", recode.getDestCardnum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestIccid()), "dest_iccid", recode.getDestIccid());
        // 状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestState()), "dest_state", recode.getDestState());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestOperators()), "dest_operators", recode.getDestOperators());
        // 类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestType()), "dest_type", recode.getDestType());
        // 套餐名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestMeal()), "dest_meal", recode.getDestMeal());
        // 激活时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestActivationTime()), "dest_activation_time", recode.getDestActivationTime());
        // 到期时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestTimeout()), "dest_timeout", recode.getDestTimeout());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysDestroyapply> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysDestroyapplyMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysDestroyapplyMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysDestroyapplyMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysDestroyapply recode) {
        return R.r(sysDestroyapplyMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysDestroyapply recode) {
        if (StringUtils.isEmpty(recode.getDestId())) {
            throw new MissingParametersException("销卡申请表ID");
        }
        return R.r(sysDestroyapplyMapper.updateById(recode));
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
            throw new MissingParametersException("销卡申请表ID");
        }
        return R.r(sysDestroyapplyMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysDestroyapplyMapper.deleteBatchIds(ids));
    }
}
