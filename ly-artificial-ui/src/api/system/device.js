import { service_system } from '@/utils/request'

// 查询用户列表
export function listDevice(query) {
  return service_system({
    url: 'sys-device/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getDevice(id) {
  return service_system({
    url: '/sys-device/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateDevice(data) {
  return service_system({
    url: '/sys-device/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addDevice(data) {
  return service_system({
    url: 'sys-device/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteDevice(ids) {
  return service_system({
    url: 'sys-device/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
