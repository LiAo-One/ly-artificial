package com.ly.system.services;

import com.ly.commons.core.R;
import com.ly.system.entity.SysMealChangeapply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 套餐变更申请 服务类
 * </p>
 *
 * @author LiAo
 * @since 2021-01-22
 */
public interface SysMealChangeapplyService extends IService<SysMealChangeapply> {

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
     R selPage(SysMealChangeapply recode);

    /**
     * 根据id查询数据
     *
     * @param id id
     * @return 结果
     */
     R findById(Long id);

    /**
     * 根据ids查询数据
     *
     * @param ids ids
     * @return 结果
     */
     R findByIds(List<Long> ids);

    /**
     * 添加数据
     *
     * @param recode 添加参数
     * @return 结果
     */
     R add(SysMealChangeapply recode);

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
     R updById(SysMealChangeapply recode);

    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果
     */
     R delete(Long id);

    /**
     * 根据id批量删除
     *
     * @param ids id集合
     * @return 结果
     */
     R deletes(List<Long> ids);
}
