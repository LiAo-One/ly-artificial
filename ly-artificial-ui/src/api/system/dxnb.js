import { service_system } from '@/utils/request'

// 查询用户列表
export function listDxnb(query) {
  return service_system({
    url: 'sys-card-dxnb/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getDxnb(id) {
  return service_system({
    url: '/sys-card-dxnb/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateDxnb(data) {
  return service_system({
    url: '/sys-card-dxnb/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addDxnb(data) {
  return service_system({
    url: 'sys-card-dxnb/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteDxnb(ids) {
  return service_system({
    url: 'sys-card-dxnb/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
