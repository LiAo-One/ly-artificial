package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysAlarmcontactMapper;
import com.ly.system.entity.SysAlarmcontact;
import com.ly.system.services.SysAlarmcontactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 报警联系人 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-21
 */
@Service
public class SysAlarmcontactServiceImpl extends ServiceImpl<SysAlarmcontactMapper, SysAlarmcontact> implements SysAlarmcontactService {

    @Autowired
    private SysAlarmcontactMapper sysAlarmcontactMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysAlarmcontact recode) {
        // 分页信息
        IPage<SysAlarmcontact> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysAlarmcontact> queryWrapper = new QueryWrapper<>();

        // 联系人idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactId()), "contact_id", recode.getContactId());
        // 联系人姓名SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactNaem()), "contact_naem", recode.getContactNaem());
        // 联系人手机SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactPhon()), "contact_phon", recode.getContactPhon());
        // 邮箱SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactEmail()), "contact_email", recode.getContactEmail());
        // 微信SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactWachat()), "contact_wachat", recode.getContactWachat());
        // 所属项目SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getContactProject()), "contact_project", recode.getContactProject());
        // 备注SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRemarks()), "remarks", recode.getRemarks());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<SysAlarmcontact> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysAlarmcontactMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysAlarmcontactMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysAlarmcontactMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysAlarmcontact recode) {
        return R.r(sysAlarmcontactMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysAlarmcontact recode) {
        if (StringUtils.isEmpty(recode.getContactId())) {
            throw new MissingParametersException("报警联系人ID");
        }
        return R.r(sysAlarmcontactMapper.updateById(recode));
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
            throw new MissingParametersException("报警联系人ID");
        }
        return R.r(sysAlarmcontactMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysAlarmcontactMapper.deleteBatchIds(ids));
    }
}
