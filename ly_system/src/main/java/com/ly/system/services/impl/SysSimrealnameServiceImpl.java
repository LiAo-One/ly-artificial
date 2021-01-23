package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysSimrealnameMapper;
import com.ly.system.entity.SysSimrealname;
import com.ly.system.services.SysSimrealnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 解绑卡机表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Service
public class SysSimrealnameServiceImpl extends ServiceImpl<SysSimrealnameMapper, SysSimrealname> implements SysSimrealnameService {

    @Autowired
    private SysSimrealnameMapper sysSimrealnameMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysSimrealname recode) {
        // 分页信息
        IPage<SysSimrealname> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysSimrealname> queryWrapper = new QueryWrapper<>();

        // 实名认证idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getSimrealnameId()), "simrealname_id", recode.getSimrealnameId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalCardnum()), "annal_cardnum", recode.getAnnalCardnum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalIccid()), "annal_iccid", recode.getAnnalIccid());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestOperators()), "dest_operators", recode.getDestOperators());
        // 状态（0: 已实名 1: 未实名）SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getState()), "state", recode.getState());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysSimrealname> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysSimrealnameMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysSimrealnameMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysSimrealnameMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysSimrealname recode) {
        return R.r(sysSimrealnameMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysSimrealname recode) {
        if (StringUtils.isEmpty(recode.getSimrealnameId())) {
            throw new MissingParametersException("解绑卡机表ID");
        }
        return R.r(sysSimrealnameMapper.updateById(recode));
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
            throw new MissingParametersException("解绑卡机表ID");
        }
        return R.r(sysSimrealnameMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysSimrealnameMapper.deleteBatchIds(ids));
    }
}
