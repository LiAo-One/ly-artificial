import { service_system } from '@/utils/request'

// 查询联动记录列表
export function listLinkage(query) {
  return service_system({
    url: 'sys-device-linkage/sel_page',
    method: 'post',
    params: query
  })
}

// 查询联动记录详细
export function getLinkage(id) {
  return service_system({
    url: '/sys-device-linkage/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改联动记录
export function updateLinkage(data) {
  return service_system({
    url: '/sys-device-linkage/upd_id',
    method: 'post',
    params: data
  })
}

// 添加联动记录
export function addLinkage(data) {
  return service_system({
    url: 'sys-device-linkage/add',
    method: 'post',
    params: data
  })
}

// 删除联动记录
export function deleteLinkage(ids) {
  return service_system({
    url: 'sys-device-linkage/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
