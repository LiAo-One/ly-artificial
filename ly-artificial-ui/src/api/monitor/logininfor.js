import {service_system} from '@/utils/request'

// 查询登录日志列表
export function list(query) {
  return service_system({
    url: '/sys-logininfor/sel_page',
    method: 'post',
    params: query
  })
}

// 删除登录日志
export function delLogininfor(ids) {
  return service_system({
    url: '/sys-logininfor/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}

// 清空登录日志
export function cleanLogininfor() {
  return service_system({
    url: '/sys-logininfor/clean',
    method: 'delete'
  })
}
