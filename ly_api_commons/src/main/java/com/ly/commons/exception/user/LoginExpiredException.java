package com.ly.commons.exception.user;

import com.ly.commons.exception.BusinessException;

/**
 * <p>
 * 登录过期
 * </p>
 *
 * @author LiAo
 * @since 2020/12/18
 */
public class LoginExpiredException extends BusinessException {

    public LoginExpiredException() {
        super("登录过期");
    }
}
