import { service_system } from '@/utils/request'

// 查询用户列表
export function listUser(query) {
  return service_system({
    url: '/sys-user/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getUser(id) {
  return service_system({
    url: '/sys-user/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateUser(data) {
  return service_system({
    url: '/sys-user/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addUser(data) {
  return service_system({
    url: '/sys-user/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteUser(ids) {
  return service_system({
    url: '/sys-user/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
