import { service_system } from '@/utils/request'

// 查询用户列表
export function listNotice(query) {
  return service_system({
    url: 'sys-alarm-notice/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getNotice(id) {
  return service_system({
    url: '/sys-alarm-notice/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateNotice(data) {
  return service_system({
    url: '/sys-alarm-notice/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addNotice(data) {
  return service_system({
    url: 'sys-alarm-notice/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteNotice(ids) {
  return service_system({
    url: 'sys-alarm-notice/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
