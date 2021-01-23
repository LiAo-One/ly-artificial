import { service_system } from '@/utils/request'

// 查询用户列表
export function listDealing(query) {
  return service_system({
    url: 'sys-card-dealing/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getDealing(id) {
  return service_system({
    url: '/sys-card-dealing/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateDealing(data) {
  return service_system({
    url: '/sys-card-dealing/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addDealing(data) {
  return service_system({
    url: 'sys-card-dealing/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteDealing(ids) {
  return service_system({
    url: 'sys-card-dealing/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
