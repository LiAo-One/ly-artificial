import { service_system } from '@/utils/request'

// 查询用户列表
export function listRecode(query) {
  return service_system({
    url: 'sys-meal-recode/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getRecode(id) {
  return service_system({
    url: '/sys-meal-recode/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateRecode(data) {
  return service_system({
    url: '/sys-meal-recode/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addRecode(data) {
  return service_system({
    url: 'sys-meal-recode/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteRecode(ids) {
  return service_system({
    url: 'sys-meal-recode/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
