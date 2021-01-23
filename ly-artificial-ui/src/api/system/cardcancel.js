import { service_system } from '@/utils/request'

// 查询用户列表
export function listCardcancel(query) {
  return service_system({
    url: 'sys-cardcancel/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getCardcancel(id) {
  return service_system({
    url: '/sys-cardcancel/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateCardcancel(data) {
  return service_system({
    url: '/sys-cardcancel/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addCardcancel(data) {
  return service_system({
    url: 'sys-cardcancel/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteCardcancel(ids) {
  return service_system({
    url: 'sys-cardcancel/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
