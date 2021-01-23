import { service_system } from '@/utils/request'

// 查询用户列表
export function listChangeapply(query) {
  return service_system({
    url: 'sys-meal-changeapply/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getChangeapply(id) {
  return service_system({
    url: '/sys-meal-changeapply/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateChangeapply(data) {
  return service_system({
    url: '/sys-meal-changeapply/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addChangeapply(data) {
  return service_system({
    url: 'sys-meal-changeapply/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteChangeapply(ids) {
  return service_system({
    url: 'sys-meal-changeapply/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
