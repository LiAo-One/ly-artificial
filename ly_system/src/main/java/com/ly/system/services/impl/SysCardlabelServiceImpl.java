package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysCardlabelMapper;
import com.ly.system.entity.SysCardlabel;
import com.ly.system.services.SysCardlabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 标签表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
@Service
public class SysCardlabelServiceImpl extends ServiceImpl<SysCardlabelMapper, SysCardlabel> implements SysCardlabelService {

    @Autowired
    private SysCardlabelMapper sysCardlabelMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysCardlabel recode) {
        // 分页信息
        IPage<SysCardlabel> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysCardlabel> queryWrapper = new QueryWrapper<>();

        // 主键SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLabelId()), "label_id", recode.getLabelId());
        // 标签名称SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getLabelName()), "label_name", recode.getLabelName());
        // 成员数量SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getMemberAmount()), "member_amount", recode.getMemberAmount());
        // 更新时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysCardlabel> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysCardlabelMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysCardlabelMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysCardlabelMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysCardlabel recode) {
        return R.r(sysCardlabelMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysCardlabel recode) {
        if (StringUtils.isEmpty(recode.getLabelId())) {
            throw new MissingParametersException("标签表ID");
        }
        return R.r(sysCardlabelMapper.updateById(recode));
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
            throw new MissingParametersException("标签表ID");
        }
        return R.r(sysCardlabelMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysCardlabelMapper.deleteBatchIds(ids));
    }
}
