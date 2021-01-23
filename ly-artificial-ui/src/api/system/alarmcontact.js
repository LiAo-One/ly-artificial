import { service_system } from '@/utils/request'

// 查询联系人列表
export function listAlarmcontact(query) {
  return service_system({
    url: 'sys-alarmcontact/sel_page',
    method: 'post',
    params: query
  })
}

// 查询联系人详细
export function getAlarmcontact(id) {
  return service_system({
    url: '/sys-alarmcontact/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateAlarmcontact(data) {
  return service_system({
    url: '/sys-alarmcontact/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addAlarmcontact(data) {
  return service_system({
    url: 'sys-alarmcontact/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deleteAlarmcontact(ids) {
  return service_system({
    url: 'sys-alarmcontact/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}

export function getAll() {
  return service_system({
    url: 'sys-alarmcontact/get_all',
    method: 'post',
    params: {}

  })
}
