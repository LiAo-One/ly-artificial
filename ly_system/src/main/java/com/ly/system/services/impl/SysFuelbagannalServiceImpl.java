package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysFuelbagannalMapper;
import com.ly.system.entity.SysFuelbagannal;
import com.ly.system.services.SysFuelbagannalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 加油包记录表 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-23
 */
@Service
public class SysFuelbagannalServiceImpl extends ServiceImpl<SysFuelbagannalMapper, SysFuelbagannal> implements SysFuelbagannalService {

    @Autowired
    private SysFuelbagannalMapper sysFuelbagannalMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysFuelbagannal recode) {
        // 分页信息
        IPage<SysFuelbagannal> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysFuelbagannal> queryWrapper = new QueryWrapper<>();

        // 记录idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalId()), "annal_id", recode.getAnnalId());
        // 卡号SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalCardnum()), "annal_cardnum", recode.getAnnalCardnum());
        // ICCIDSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalIccid()), "annal_iccid", recode.getAnnalIccid());
        // 卡状态SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getAnnalState()), "annal_state", recode.getAnnalState());
        // 运营商SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDestOperators()), "dest_operators", recode.getDestOperators());
        // 套餐类型SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getDextRecodeType()), "dext_recode_type", recode.getDextRecodeType());
        // 加油信息SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getRefuelNews()), "refuel_news", recode.getRefuelNews());
        // 单价SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUnitPrice()), "unit_price", recode.getUnitPrice());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());

        // 排序信息
        QueryWrapper<SysFuelbagannal> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysFuelbagannalMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysFuelbagannalMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysFuelbagannalMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysFuelbagannal recode) {
        return R.r(sysFuelbagannalMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysFuelbagannal recode) {
        if (StringUtils.isEmpty(recode.getAnnalId())) {
            throw new MissingParametersException("加油包记录表ID");
        }
        return R.r(sysFuelbagannalMapper.updateById(recode));
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
            throw new MissingParametersException("加油包记录表ID");
        }
        return R.r(sysFuelbagannalMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysFuelbagannalMapper.deleteBatchIds(ids));
    }
}
