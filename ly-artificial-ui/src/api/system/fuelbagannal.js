import { service_system } from '@/utils/request'

// 查询用户列表
export function listFuelbagannal(query) {
  return service_system({
    url: 'sys-fuelbagannal/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getFuelbagannal(id) {
  return service_system({
    url: '/sys-fuelbagannal/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateFuelbagannal(data) {
  return service_system({
    url: '/sys-fuelbagannal/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addFuelbagannal(data) {
  return service_system({
    url: 'sys-fuelbagannal/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteFuelbagannal(ids) {
  return service_system({
    url: 'sys-fuelbagannal/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
