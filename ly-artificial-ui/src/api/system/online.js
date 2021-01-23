import { service_system } from '@/utils/request'

// 查询数据列表
export function listOnline(query) {
  return service_system({
    url: 'sys-device-online/sel_page',
    method: 'post',
    params: query
  })
}

// 查询数据详细
export function getOnline(id) {
  return service_system({
    url: '/sys-device-online/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改数据
export function updateOnline(data) {
  return service_system({
    url: '/sys-device-online/upd_id',
    method: 'post',
    params: data
  })
}

// 添加数据
export function addOnline(data) {
  return service_system({
    url: 'sys-device-online/add',
    method: 'post',
    params: data
  })
}

// 删除数据
export function deleteOnline(ids) {
  return service_system({
    url: 'sys-device-online/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
