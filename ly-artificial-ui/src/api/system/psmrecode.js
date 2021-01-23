import { service_system } from '@/utils/request'

// 查询用户列表
export function listPsmrecode(query) {
  return service_system({
    url: 'sys-psmrecode/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getPsmrecode(id) {
  return service_system({
    url: '/sys-psmrecode/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updatePsmrecode(data) {
  return service_system({
    url: '/sys-psmrecode/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addPsmrecode(data) {
  return service_system({
    url: 'sys-psmrecode/add',
    method: 'post',
    params: data
  })
}

// 删除用户
export function deletePsmrecode(ids) {
  return service_system({
    url: 'sys-psmrecode/del_ids',
    method: 'post',
    params: {
      ids
    }
  })
}
