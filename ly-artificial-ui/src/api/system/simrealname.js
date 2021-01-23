import { service_system } from '@/utils/request'

// 查询用户列表
export function listSimrealname(query) {
  return service_system({
    url: 'sys-simrealname/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getSimrealname(id) {
  return service_system({
    url: '/sys-simrealname/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateSimrealname(data) {
  return service_system({
    url: '/sys-simrealname/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addSimrealname(data) {
  return service_system({
    url: 'sys-simrealname/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteSimrealname(ids) {
  return service_system({
    url: 'sys-simrealname/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
