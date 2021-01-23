import { service_system } from '@/utils/request'

// 查询用户列表
export function listAdmin(query) {
  return service_system({
    url: '/sys-admin/sel_page',
    method: 'post',
    params: query
  })
}

// 查询用户详细
export function getAdmin(id) {
  return service_system({
    url: '/sys-admin/sel_id',
    method: 'post',
    params: {
      id
    }
  })
}

// 修改用户
export function updateAdmin(data) {
  return service_system({
    url: '/sys-admin/upd_id',
    method: 'post',
    params: data
  })
}

// 添加用户
export function addAdmin(data) {
  return service_system({
    url:'sys-admin/add',
    method:'post',
    params:data
  })
}

// 删除单个用户
export function deleteAdmin(ids) {
  return service_system({
    url:'sys-admin/del_ids',
    method:'post',
    params:{
      ids
    }
  })
}

// 用户密码重置
export function updateUserPwd(oldPassword, newPassword) {
  const data = {
    oldPassword,
    newPassword
  }
  return service_system({
    url: '/system/user/profile/updatePwd',
    method: 'put',
    params: data
  })
}

// 用户头像上传
export function uploadAvatar(data) {
  return service_system({
    url: '/system/user/profile/avatar',
    method: 'post',
    data: data
  })
}

