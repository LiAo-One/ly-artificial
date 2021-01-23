import { service_system } from '@/utils/request'

// 查询用户列表
export function listWorkorder(query) {
  return service_system({
    url: 'sys-my-workorder/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getWorkorder(id) {
  return service_system({
    url: '/sys-my-workorder/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateWorkorder(data) {
  return service_system({
    url: '/sys-my-workorder/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addWorkorder(data) {
  return service_system({
    url: 'sys-my-workorder/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteWorkorder(ids) {
  return service_system({
    url: 'sys-my-workorder/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
