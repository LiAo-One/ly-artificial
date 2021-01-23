import { service_system } from '@/utils/request'

// 查询角色列表
export function listRole(query) {
  return service_system({
    url: '/sys-role/sel_page',
    method: 'post',
    params: query
  })
}

// 查询角色枚举
export function roleMenu() {
  return service_system({
    url: 'sys-role/sel_id',
    method: 'post'
  })
}

// 查询角色详细
export function getRole(id) {
  return service_system({
    url: '/sys-role/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 新增角色
export function addRole(data) {

  if (data.menuIds) {
    data.menuIds = data.menuIds.toString()
  }

  return service_system({
    url: '/sys-role/add',
    method: 'post',
    params: data
  })
}

// 修改角色
export function updateRole(data) {

  if (data.menuIds) {
    data.menuIds = data.menuIds.toString()
  }
  return service_system({
    url: '/sys-role/upd_id',
    method: 'post',
    params: data
  })
}

// 角色数据权限
export function dataScope(data) {
  return service_system({
    url: '/system/role/dataScope',
    method: 'put',
    data: data
  })
}

// 角色状态修改
export function changeRoleStatus(roleId, roleStatus) {
  const data = {
    roleId,
    roleStatus
  }
  return service_system({
    url: '/sys-role/upd_id',
    method: 'post',
    params: data
  })
}

// 删除角色
export function delRole(ids) {
  return service_system({
    url: '/sys-role/del_ids/',
    method: 'post',
    params: {
      ids
    }
  })
}

// 导出角色
export function exportRole(query) {
  return service_system({
    url: '/system/role/export',
    method: 'get',
    params: query
  })
}
