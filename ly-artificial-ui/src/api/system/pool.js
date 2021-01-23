import { service_system } from '@/utils/request'

// 查询用户列表
export function listPool(query) {
  return service_system({
    url: 'sys-flow-pool/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getPool(id) {
  return service_system({
    url: '/sys-flow-pool/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updatePool(data) {
  return service_system({
    url: '/sys-flow-pool/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addPool(data) {
  return service_system({
    url: 'sys-flow-pool/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deletePool(ids) {
  return service_system({
    url: 'sys-flow-pool/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
