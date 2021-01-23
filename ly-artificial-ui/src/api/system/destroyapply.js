import { service_system } from '@/utils/request'

// 查询用户列表
export function listDestroyapply(query) {
  return service_system({
    url: 'sys-destroyapply/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getDestroyapply(id) {
  return service_system({
    url: '/sys-destroyapply/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateDestroyapply(data) {
  return service_system({
    url: '/sys-destroyapply/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addDestroyapply(data) {
  return service_system({
    url: 'sys-destroyapply/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteDestroyapply(ids) {
  return service_system({
    url: 'sys-destroyapply/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
