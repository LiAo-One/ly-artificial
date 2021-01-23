import { service_system } from '@/utils/request'

// 查询用户列表
export function listNumberrecord(query) {
  return service_system({
    url: 'sys-pin-numberrecord/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getNumberrecord(id) {
  return service_system({
    url: '/sys-pin-numberrecord/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateNumberrecord(data) {
  return service_system({
    url: '/sys-pin-numberrecord/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addNumberrecord(data) {
  return service_system({
    url: 'sys-pin-numberrecord/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteNumberrecord(ids) {
  return service_system({
    url: 'sys-pin-numberrecord/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
