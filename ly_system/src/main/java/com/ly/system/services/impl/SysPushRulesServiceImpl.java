package com.ly.system.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.commons.core.R;
import com.ly.commons.core.page.PageUtils;
import com.ly.commons.exception.check.MissingParametersException;
import com.ly.commons.utils.StringUtils;
import com.ly.system.dao.SysPushRulesMapper;
import com.ly.system.entity.SysPushRules;
import com.ly.system.services.SysPushRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 设备推送规则 服务实现类
 * </p>
 *
 * @author LiAo
 * @since 2021-04-12
 */
@Service
public class SysPushRulesServiceImpl extends ServiceImpl<SysPushRulesMapper, SysPushRules> implements SysPushRulesService {

    @Autowired
    private SysPushRulesMapper sysPushRulesMapper;

    /**
     * 分页查询
     *
     * @param recode 条件
     * @return 结果
     */
    @Override
    public R selPage(SysPushRules recode) {
        // 分页信息
        IPage<SysPushRules> page = PageUtils.startPage();

        // 构造条件
        QueryWrapper<SysPushRules> queryWrapper = new QueryWrapper<>();

        // 推送规则idSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrId()), "pr_id", recode.getPrId());
        // 项目识别码 唯一SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrProjectId()), "pr_project_id", recode.getPrProjectId());
        // 主机地址SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrHost()), "pr_host", recode.getPrHost());
        // 端口号 如80=> :80 冒号不可缺省SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrPort()), "pr_port", recode.getPrPort());
        // 路径地址 如 /test   '/' 不可缺省SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrAddress()), "pr_address", recode.getPrAddress());
        // 推送方式 get post tcpSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrMode()), "pr_mode", recode.getPrMode());
        // 数据格式 k-v  jsonSysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getPrPushRules()), "pr_push_rules", recode.getPrPushRules());
        // 创建时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getCreateTime()), "create_time", recode.getCreateTime());
        // 修改时间SysOpenLogServiceImpl.java
        queryWrapper.eq(StringUtils.isNotNull(recode.getUpdateTime()), "update_time", recode.getUpdateTime());

        // 排序信息
        QueryWrapper<SysPushRules> wrapper = PageUtils.startOrderBy(queryWrapper);

        // 返回结果
        return R.r(sysPushRulesMapper.selectPage(page, wrapper));
    }

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
    @Override
    public R findById(Long id){
        return R.r(sysPushRulesMapper.selectById(id));
    }

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
    @Override
    public R findByIds(List<Long> ids){
        return R.r(sysPushRulesMapper.selectBatchIds(ids));
    }

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
    @Override
    public R add(SysPushRules recode) {
        return R.r(sysPushRulesMapper.insert(recode));
    }

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
    @Override
    public R updById(SysPushRules recode) {
        if (StringUtils.isEmpty(recode.getPrId())) {
            throw new MissingParametersException("设备推送规则ID");
        }
        return R.r(sysPushRulesMapper.updateById(recode));
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
            throw new MissingParametersException("设备推送规则ID");
        }
        return R.r(sysPushRulesMapper.deleteById(id));
    }

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
    @Override
    public R deletes(List<Long> ids){
        return R.r(sysPushRulesMapper.deleteBatchIds(ids));
    }
}
