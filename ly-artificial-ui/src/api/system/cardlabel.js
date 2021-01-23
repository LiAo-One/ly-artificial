import { service_system } from '@/utils/request'

// 查询用户列表
export function listCardlabel(query) {
  return service_system({
    url: 'sys-cardlabel/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getCardlabel(id) {
  return service_system({
    url: '/sys-cardlabel/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateCardlabel(data) {
  return service_system({
    url: '/sys-cardlabel/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addCardlabel(data) {
  return service_system({
    url: 'sys-cardlabel/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteCardlabel(ids) {
  return service_system({
    url: 'sys-cardlabel/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
