import { service_system } from '@/utils/request'

// 获取路由
export const getRouters = (token) => {
  return service_system({
    url: 'token/token-mes',
    method: 'get',
    params: {
      name: 'menu',
      token
    }
  })
}
