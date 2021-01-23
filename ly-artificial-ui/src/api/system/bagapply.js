import { service_system } from '@/utils/request'

// 查询用户列表
export function listBagapply(query) {
  return service_system({
    url: 'sys-gas-bagapply/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getBagapply(id) {
  return service_system({
    url: '/sys-gas-bagapply/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateBagapply(data) {
  return service_system({
    url: '/sys-gas-bagapply/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addBagapply(data) {
  return service_system({
    url: 'sys-gas-bagapply/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteBagapply(ids) {
  return service_system({
    url: 'sys-gas-bagapply/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
