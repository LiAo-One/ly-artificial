import { service_system } from '@/utils/request'

// 查询用户列表
export function listCardwhitelist(query) {
  return service_system({
    url: 'sys-cardwhitelist/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getCardwhitelist(id) {
  return service_system({
    url: '/sys-cardwhitelist/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateCardwhitelist(data) {
  return service_system({
    url: '/sys-cardwhitelist/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addCardwhitelist(data) {
  return service_system({
    url: 'sys-cardwhitelist/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteCardwhitelist(ids) {
  return service_system({
    url: 'sys-cardwhitelist/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
