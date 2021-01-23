package com.ly.commons.exception.user;

import com.ly.commons.exception.BusinessException;

/**
 * <p>
 * 角色权限信息异常
 * </p>
 *
 * @author LiAo
 * @since 2020/12/21
 */
public class PermissionException extends BusinessException {

    public PermissionException() {
        super("账户角色权限信息异常，请联系管理员");
    }
}
