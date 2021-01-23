package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysMyWorkorderMapper;
import com.ly.system.entity.SysMyWorkorder;
import com.ly.system.services.SysMyWorkorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 我的工单 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysMyWorkorderServiceImpl extends ServiceImpl<SysMyWorkorderMapper, SysMyWorkorder> implements SysMyWorkorderService {

    @Autowired
    private SysMyWorkorderMapper sysMyWorkorderMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysMyWorkorder recode) {
        // 分页信息
        IPage<SysMyWorkorder> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysMyWorkorder> queryWrapper = new QueryWrapper<>();

        // 主键idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderId()), "workorder_id", recode.getWorkorderId());
        // 工单编号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRepairId()), "repair_id", recode.getRepairId());
        // 所属项目SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderProject()), "workorder_project", recode.getWorkorderProject());
        // 维保设备SNSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderDeviceSn()), "workorder_device_sn", recode.getWorkorderDeviceSn());
        // 故障描述SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderDescribe()), "workorder_describe", recode.getWorkorderDescribe());
        // 报修人邮箱SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderEmail()), "workorder_email", recode.getWorkorderEmail());
        // 工单状态 0进行中 1已结单SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderStudent()), "workorder_student", recode.getWorkorderStudent());
        // 工单类型0 常规维保 1 故障维保SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWorkorderType()), "workorder_type", recode.getWorkorderType());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysMyWorkorder> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysMyWorkorderMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysMyWorkorderMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysMyWorkorderMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysMyWorkorder recode) {
        return R.r(sysMyWorkorderMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysMyWorkorder recode) {
        if (StringUtils.isEmpty(recode.getWorkorderId())) {
            throw new MissingParametersException("我的工单ID");
        }
        return R.r(sysMyWorkorderMapper.updateById(recode));
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
            throw new MissingParametersException("我的工单ID");
        }
        return R.r(sysMyWorkorderMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysMyWorkorderMapper.deleteBatchIds(ids));
    }
}
