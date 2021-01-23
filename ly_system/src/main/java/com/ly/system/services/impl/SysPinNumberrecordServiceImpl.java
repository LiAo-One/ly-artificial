package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysPinNumberrecordMapper;
import com.ly.system.entity.SysPinNumberrecord;
import com.ly.system.services.SysPinNumberrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 销卡记录表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysPinNumberrecordServiceImpl extends ServiceImpl<SysPinNumberrecordMapper, SysPinNumberrecord> implements SysPinNumberrecordService {

    @Autowired
    private SysPinNumberrecordMapper sysPinNumberrecordMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysPinNumberrecord recode) {
        // 分页信息
        IPage<SysPinNumberrecord> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysPinNumberrecord> queryWrapper = new QueryWrapper<>();

        // 订单号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPinNumberRecodeId()), "pin_number_recode_id", recode.getPinNumberRecodeId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestCardnum()), "dest_cardnum", recode.getDestCardnum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestIccid()), "dest_iccid", recode.getDestIccid());
        // 卡状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestState()), "dest_state", recode.getDestState());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestOperators()), "dest_operators", recode.getDestOperators());
        // 销号类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDextRecodeType()), "dext_recode_type", recode.getDextRecodeType());
        // 提交时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestRecodeCommitTime()), "dest_recode_commit_time", recode.getDestRecodeCommitTime());
        // 完成时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestRecodeOkTime()), "dest_recode_ok_time", recode.getDestRecodeOkTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysPinNumberrecord> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysPinNumberrecordMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysPinNumberrecordMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysPinNumberrecordMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysPinNumberrecord recode) {
        return R.r(sysPinNumberrecordMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysPinNumberrecord recode) {
        if (StringUtils.isEmpty(recode.getPinNumberRecodeId())) {
            throw new MissingParametersException("销卡记录表ID");
        }
        return R.r(sysPinNumberrecordMapper.updateById(recode));
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
            throw new MissingParametersException("销卡记录表ID");
        }
        return R.r(sysPinNumberrecordMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysPinNumberrecordMapper.deleteBatchIds(ids));
    }
}
