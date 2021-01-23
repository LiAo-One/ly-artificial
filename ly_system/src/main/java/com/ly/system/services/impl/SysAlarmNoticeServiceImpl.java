package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysAlarmNoticeMapper;
import com.ly.system.entity.SysAlarmNotice;
import com.ly.system.services.SysAlarmNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 报警通知 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysAlarmNoticeServiceImpl extends ServiceImpl<SysAlarmNoticeMapper, SysAlarmNotice> implements SysAlarmNoticeService {

    @Autowired
    private SysAlarmNoticeMapper sysAlarmNoticeMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysAlarmNotice recode) {
        // 分页信息
        IPage<SysAlarmNotice> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysAlarmNotice> queryWrapper = new QueryWrapper<>();

        // 通知idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNoticeId()), "notice_id", recode.getNoticeId());
        // 通知名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNoticeName()), "notice_name", recode.getNoticeName());
        // 设备SNSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDeviceSn()), "device_sn", recode.getDeviceSn());
        // 推送间隔 分钟SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNoticeInterval()), "notice_interval", recode.getNoticeInterval());
        // 推送方式 0：短信 1 微信 2 邮件 3 语音 多个用 “,” 隔开SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNoticeTheway()), "notice_theway", recode.getNoticeTheway());
        // 推送人的id，多个用“,” 隔开SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getNoticePeople()), "notice_people", recode.getNoticePeople());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysAlarmNotice> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysAlarmNoticeMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysAlarmNoticeMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysAlarmNoticeMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysAlarmNotice recode) {
        return R.r(sysAlarmNoticeMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysAlarmNotice recode) {
        if (StringUtils.isEmpty(recode.getNoticeId())) {
            throw new MissingParametersException("报警通知ID");
        }
        return R.r(sysAlarmNoticeMapper.updateById(recode));
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
            throw new MissingParametersException("报警通知ID");
        }
        return R.r(sysAlarmNoticeMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysAlarmNoticeMapper.deleteBatchIds(ids));
    }
}
