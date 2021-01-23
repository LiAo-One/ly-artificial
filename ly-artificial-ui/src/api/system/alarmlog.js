import { service_system } from '@/utils/request'

// 查询用户列表
export function listAlarmlog(query) {
  return service_system({
    url: 'sys-alarmlog/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getAlarmlog(id) {
  return service_system({
    url: '/sys-alarmlog/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateAlarmlog(data) {
  return service_system({
    url: '/sys-alarmlog/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addAlarmlog(data) {
  return service_system({
    url: 'sys-alarmlog/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteAlarmlog(ids) {
  return service_system({
    url: 'sys-alarmlog/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
