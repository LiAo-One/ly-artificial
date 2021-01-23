import { service_system } from '@/utils/request'

// 查询用户列表
export function listRenewal(query) {
  return service_system({
    url: 'sys-renewal/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getRenewal(id) {
  return service_system({
    url: '/sys-renewal/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateRenewal(data) {
  return service_system({
    url: '/sys-renewal/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addRenewal(data) {
  return service_system({
    url: 'sys-renewal/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteRenewal(ids) {
  return service_system({
    url: 'sys-renewal/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
