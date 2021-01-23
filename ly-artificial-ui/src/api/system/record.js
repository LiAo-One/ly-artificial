import { service_system } from '@/utils/request'

// 查询报警记录表
export function listRecord(query) {
  return service_system({
    url: 'sys-alarm-record/sel_page',
    method: 'post',
    params: query
  })
}

// 查询报警记录详细
export function getRecord(id) {
  return service_system({
    url: '/sys-alarm-record/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改报警记录
export function updateRecord(data) {
  return service_system({
    url: '/sys-alarm-record/upd_id',
    method: 'post',
    params: {
      isProcess: 0,
      recordId: data
    }
  })
}

// 添加报警记录
export function addRecord(data) {
  return service_system({
    url: 'sys-alarm-record/add',
    method: 'post',
    params: data
  })
}

// 删除报警记录
export function deleteRecord(ids) {
  return service_system({
    url: 'sys-alarm-record/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
