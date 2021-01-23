import { service_system } from '@/utils/request'

// 查询用户列表
export function listRenewalrecord(query) {
  return service_system({
    url: 'sys-renewalrecord/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getRenewalrecord(id) {
  return service_system({
    url: '/sys-renewalrecord/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateRenewalrecord(data) {
  return service_system({
    url: '/sys-renewalrecord/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addRenewalrecord(data) {
  return service_system({
    url: 'sys-renewalrecord/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteRenewalrecord(ids) {
  return service_system({
    url: 'sys-renewalrecord/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
