import { service_system } from '@/utils/request'

// 登录方法
export function login(adminAccount, adminPassword) {
  return service_system({
    url: 'sys-admin/login',
    method: 'post',
    params: {
      adminAccount,
      adminPassword
    }
  })
}

// 获取用户详细信息
export function getInfo(token) {
  return service_system({
    url: '/token/token-mes-all',
    params: {
      token
    },
    method: 'get'
  })
}

// 退出方法
export function logout(token) {
  return service_system({
    url: '/sys-admin/logout',
    method: 'post',
    params: {
      token
    }
  })
}

// 获取验证码
export function getCodeImg() {
  return service_system({
    url: '/captchaImage',
    method: 'get'
  })
}
