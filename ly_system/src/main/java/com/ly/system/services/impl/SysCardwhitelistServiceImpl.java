package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysCardwhitelistMapper;
import com.ly.system.entity.SysCardwhitelist;
import com.ly.system.services.SysCardwhitelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 白名单表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Service
public class SysCardwhitelistServiceImpl extends ServiceImpl<SysCardwhitelistMapper, SysCardwhitelist> implements SysCardwhitelistService {

    @Autowired
    private SysCardwhitelistMapper sysCardwhitelistMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysCardwhitelist recode) {
        // 分页信息
        IPage<SysCardwhitelist> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysCardwhitelist> queryWrapper = new QueryWrapper<>();

        // 白名单idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWhiteId()), "white_id", recode.getWhiteId());
        // 白名单ipSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getWhiteIp()), "white_ip", recode.getWhiteIp());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestOperators()), "dest_operators", recode.getDestOperators());
        // 状态（0: 成功 1: 失败）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getState()), "state", recode.getState());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysCardwhitelist> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysCardwhitelistMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysCardwhitelistMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysCardwhitelistMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysCardwhitelist recode) {
        return R.r(sysCardwhitelistMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysCardwhitelist recode) {
        if (StringUtils.isEmpty(recode.getWhiteId())) {
            throw new MissingParametersException("白名单表ID");
        }
        return R.r(sysCardwhitelistMapper.updateById(recode));
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
            throw new MissingParametersException("白名单表ID");
        }
        return R.r(sysCardwhitelistMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysCardwhitelistMapper.deleteBatchIds(ids));
    }
}
