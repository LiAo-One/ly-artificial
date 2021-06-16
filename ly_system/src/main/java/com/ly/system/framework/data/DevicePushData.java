package com.ly.system.framework.data;

import com.ly.system.entity.SysDevicePushMatrix;
import com.ly.system.entity.SysPushRules;

import java.util.List;

/**
 * <p>
 * 设备数据推送
 * </p>
 *
 * @author LiAo
 * @since 2021/4/14
 */
public class DevicePushData {

    // 推送网关记录集合
    public static List<SysDevicePushMatrix> devicePushMatrices;

    // 推送规则集合
    public static List<SysPushRules> pushRules;

}
