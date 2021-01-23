import { service_system } from '@/utils/request'

// 查询用户列表
export function listName(query) {
  return service_system({
    url: 'sys-real-name/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getName(id) {
  return service_system({
    url: '/sys-real-name/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateName(data) {
  return service_system({
    url: '/sys-real-name/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addName(data) {
  return service_system({
    url: 'sys-real-name/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteName(ids) {
  return service_system({
    url: 'sys-real-name/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
