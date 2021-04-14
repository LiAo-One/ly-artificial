package com.ly.system.services;

import com.ly.commons.core.R;
import com.ly.system.entity.SysDevicePushMatrix;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 设备推送矩阵记录 服务类
 * </p>
 *
 * @author LiAo
 * @since 2021-04-12
 */
public interface SysDevicePushMatrixService extends IService<SysDevicePushMatrix> {

    /**
     * 分页查询 排序
     *
     * @param recode 条件
     * @return 结果
     */
     R selPage(SysDevicePushMatrix recode);

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
     R add(SysDevicePushMatrix recode);

    /**
     * 根据id修改
     *
     * @param recode 修改参数
     * @return 结果
     */
     R updById(SysDevicePushMatrix recode);

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
