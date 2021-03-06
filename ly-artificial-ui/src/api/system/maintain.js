import { service_system } from '@/utils/request'

// 查询用户列表
export function listMaintain(query) {
  return service_system({
    url: 'sys-plan-maintain/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getMaintain(id) {
  return service_system({
    url: '/sys-plan-maintain/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateMaintain(data) {
  return service_system({
    url: '/sys-plan-maintain/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addMaintain(data) {
  return service_system({
    url: 'sys-plan-maintain/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteMaintain(ids) {
  return service_system({
    url: 'sys-plan-maintain/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
