import { service_system } from '@/utils/request'

// 查询用户列表
export function listFlow(query) {
  return service_system({
    url: 'sys-card-flow/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getFlow(id) {
  return service_system({
    url: '/sys-card-flow/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateFlow(data) {
  return service_system({
    url: '/sys-card-flow/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addFlow(data) {
  return service_system({
    url: 'sys-card-flow/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteFlow(ids) {
  return service_system({
    url: 'sys-card-flow/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
