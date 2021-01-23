package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysDeviceOnlineMapper;
import com.ly.system.entity.SysDeviceOnline;
import com.ly.system.services.SysDeviceOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 设备上下线记录 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysDeviceOnlineServiceImpl extends ServiceImpl<SysDeviceOnlineMapper, SysDeviceOnline> implements SysDeviceOnlineService {

    @Autowired
    private SysDeviceOnlineMapper sysDeviceOnlineMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysDeviceOnline recode) {
        // 分页信息
        IPage<SysDeviceOnline> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysDeviceOnline> queryWrapper = new QueryWrapper<>();

        // 记录idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getOnlineId()), "online_id", recode.getOnlineId());
        // 通知名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceName()), "device_name", recode.getDeviceName());
        // 设备SNSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceSn()), "device_sn", recode.getDeviceSn());
        // 设备状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getStudent()), "student", recode.getStudent());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysDeviceOnline> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysDeviceOnlineMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysDeviceOnlineMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysDeviceOnlineMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysDeviceOnline recode) {
        return R.r(sysDeviceOnlineMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysDeviceOnline recode) {
        if (StringUtils.isEmpty(recode.getOnlineId())) {
            throw new MissingParametersException("设备上下线记录ID");
        }
        return R.r(sysDeviceOnlineMapper.updateById(recode));
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
            throw new MissingParametersException("设备上下线记录ID");
        }
        return R.r(sysDeviceOnlineMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysDeviceOnlineMapper.deleteBatchIds(ids));
    }
}
