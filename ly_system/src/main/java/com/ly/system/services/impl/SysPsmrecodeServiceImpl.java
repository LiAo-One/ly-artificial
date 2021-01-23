package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysPsmrecodeMapper;
import com.ly.system.entity.SysPsmrecode;
import com.ly.system.services.SysPsmrecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * PSM 转换记录 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Service
public class SysPsmrecodeServiceImpl extends ServiceImpl<SysPsmrecodeMapper, SysPsmrecode> implements SysPsmrecodeService {

    @Autowired
    private SysPsmrecodeMapper sysPsmrecodeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysPsmrecode recode) {
        // 分页信息
        IPage<SysPsmrecode> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysPsmrecode> queryWrapper = new QueryWrapper<>();

        // 记录主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPsmRecodeId()), "psm_recode_id", recode.getPsmRecodeId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalCardnum()), "annal_cardnum", recode.getAnnalCardnum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalIccid()), "annal_iccid", recode.getAnnalIccid());
        // 转换类型 0：转非psm 1：转psmSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getChangeType()), "change_type", recode.getChangeType());
        // 状态（0: 成功 1: 失败）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getState()), "state", recode.getState());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysPsmrecode> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysPsmrecodeMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysPsmrecodeMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysPsmrecodeMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysPsmrecode recode) {
        return R.r(sysPsmrecodeMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysPsmrecode recode) {
        if (StringUtils.isEmpty(recode.getPsmRecodeId())) {
            throw new MissingParametersException("PSM 转换记录ID");
        }
        return R.r(sysPsmrecodeMapper.updateById(recode));
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
            throw new MissingParametersException("PSM 转换记录ID");
        }
        return R.r(sysPsmrecodeMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysPsmrecodeMapper.deleteBatchIds(ids));
    }
}
