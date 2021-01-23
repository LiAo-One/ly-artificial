import { service_system } from '@/utils/request'

// 查询用户列表
export function listFlowpool(query) {
  return service_system({
    url: 'sys-card-flowpool/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getFlowpool(id) {
  return service_system({
    url: '/sys-card-flowpool/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateFlowpool(data) {
  return service_system({
    url: '/sys-card-flowpool/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addFlowpool(data) {
  return service_system({
    url: 'sys-card-flowpool/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteFlowpool(ids) {
  return service_system({
    url: 'sys-card-flowpool/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
