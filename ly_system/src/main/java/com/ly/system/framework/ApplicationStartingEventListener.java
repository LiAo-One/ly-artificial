package com.ly.system.framework;

import com.ly.system.dao.SysDevicePushMatrixMapper;
import com.ly.system.dao.SysPushRulesMapper;
import com.ly.system.framework.data.DevicePushData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * <p>
 * Spring Boot 启动初始化时间
 * </p>
 *
 * @author LiAo
 * @since 2021/4/14
 */
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    // 推送设备
    @Autowired
    private SysDevicePushMatrixMapper sysDevicePushMatrixMapper;

    // 推送规则
    @Autowired
    private SysPushRulesMapper sysPushRulesMapper;

    /**
     * 初始化加载方法
     *
     * @param applicationStartingEvent 参数
     */
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        // 加载推送规则
        DevicePushData.pushRules = sysPushRulesMapper.selectList(null);
        // 加载推送网关列表
        DevicePushData.devicePushMatrices = sysDevicePushMatrixMapper.selectList(null);
    }
}
