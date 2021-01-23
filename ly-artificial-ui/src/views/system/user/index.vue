<template>
  <div class="app-container">
    <!--[GenTableColumn{, columnComment='用户主键', javaField='userId'}, GenTableColumn{, columnComment='用户账户', javaField='userAccount'}, GenTableColumn{, columnComment='用户密码', javaField='userPassword'}, GenTableColumn{, columnComment='用户姓名', javaField='userName'}, GenTableColumn{, columnComment='性别', javaField='userSex'}, GenTableColumn{, columnComment='昵称', javaField='userNickname'}, GenTableColumn{, columnComment='头像', javaField='userAvatar'}, GenTableColumn{, columnComment='邮箱', javaField='userEmail'}, GenTableColumn{, columnComment='手机号', javaField='userPhon'}, GenTableColumn{, columnComment='是否密保', javaField='userProtection'}, GenTableColumn{, columnComment='是否实名认证', javaField='userCertification'}, GenTableColumn{, columnComment='备注', javaField='userRemarks'}, GenTableColumn{, columnComment='乐观锁', javaField='version'}, GenTableColumn{, columnComment='逻辑删除', javaField='deleted'}, GenTableColumn{, columnComment='登录时间', javaField='loginTime'}, GenTableColumn{, columnComment='创建时间', javaField='createTime'}, GenTableColumn{, columnComment='修改时间', javaField='updateTime'}]数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="用户账户" prop="userAccount">
            <el-input
              v-model="queryParams.userAccount"
              placeholder="请输入用户账户"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="用户姓名" prop="userName">
            <el-input
              v-model="queryParams.userName"
              placeholder="请输入用户姓名"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="邮箱" prop="userEmail">
            <el-input
              v-model="queryParams.userEmail"
              placeholder="请输入邮箱"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="手机号" prop="userPhon">
            <el-input
              v-model="queryParams.userPhon"
              placeholder="请输入手机号"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
            >新增
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="success"
              icon="el-icon-edit"
              size="mini"
              :disabled="single"
              @click="handleUpdate"
            >修改
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              :disabled="multiple"
              @click="handleDelete"
            >删除
            </el-button>
          </el-col>
          <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="userList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>

          <el-table-column label="用户编号" align="center" prop="userId"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="用户账户" align="center" prop="userAccount"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="用户姓名" align="center" prop="userName"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="性别" align="center" prop="userSex"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="头像" align="center" prop="userAvatar"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="邮箱" align="center" prop="userEmail"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="手机号" align="center" prop="userPhon"
                           :show-overflow-tooltip="true"/>
          <el-table-column label="是否密保" align="center" prop="userProtection"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.userCertification === '1'">是</span>
              <span v-else>否</span>
            </template>
          </el-table-column>
          <el-table-column label="是否实名认证" align="center" prop="userCertification"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.userCertification === '1'">是</span>
              <span v-else>否</span>
            </template>
          </el-table-column>
          <el-table-column label="登录时间" align="center" prop="loginTime"
                           :show-overflow-tooltip="true"/>

          <el-table-column
            label="操作"
            align="center"
            width="160"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
              >修改
              </el-button>
              <!-- v-if="scope.row.userId !== 1"-->
              <el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
              >删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />
      </el-col>
    </el-row>

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-col :span="12">
          <el-form-item label="用户账户" prop="userAccount">
            <el-input v-model="form.userAccount" placeholder="请输入用户账户"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用户密码" prop="userPassword">
            <el-input v-model="form.userPassword" placeholder="请输入用户密码"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用户姓名">
            <el-input v-model="form.userName" placeholder="请输入用户姓名"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="性别" prop="userSex">
            <el-select v-model="form.userSex" placeholder="请选择">
              <el-option
                label="男"
                value="男">
              </el-option>
              <el-option
                label="女"
                value="女">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="昵称">
            <el-input v-model="form.userNickname" placeholder="请输入昵称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="头像">
            <el-input v-model="form.userAvatar" placeholder="请输入头像"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱">
            <el-input v-model="form.userEmail" placeholder="请输入邮箱"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机号">
            <el-input v-model="form.userPhon" placeholder="请输入手机号"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注">
            <el-input v-model="form.userRemarks" placeholder="请输入备注"/>
          </el-form-item>
        </el-col>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import {
  listUser,
  getUser,
  updateUser,
  addUser,
  deleteUser
} from '@/api/system/user'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'User',
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 用户表格数据
      userList: null,
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 表单参数
      form: {},
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: undefined,
        userAccount: undefined,
        userPassword: undefined,
        userName: undefined,
        userSex: undefined,
        userNickname: undefined,
        userAvatar: undefined,
        userEmail: undefined,
        userPhon: undefined,
        userProtection: undefined,
        userCertification: undefined,
        userRemarks: undefined,
        version: undefined,
        deleted: undefined,
        loginTime: undefined,
        createTime: undefined,
        updateTime: undefined
      },
      // 表单校验
      rules: {
        userId: [
          { required: true, message: '用户主键不能为空', trigger: 'blur' }
        ],
        userAccount: [
          { required: true, message: '用户账户不能为空', trigger: 'blur' }
        ],
        userPassword: [
          { required: true, message: '用户密码不能为空', trigger: 'blur' }
        ],
        userNickname: [
          { required: true, message: '昵称不能为空', trigger: 'blur' }
        ],
        userEmail: [
          { required: true, message: '邮箱不能为空', trigger: 'blur' }
        ],
        userPhon: [
          { required: true, message: '手机号不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询用户列表 */
    getList() {
      this.loading = true
      listUser(this.queryParams).then(response => {
          this.userList = response.data.records
          this.total = response.data.total
          this.loading = false
        }
      )
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        userId: undefined,
        userAccount: undefined,
        userPassword: undefined,
        userName: undefined,
        userSex: undefined,
        userNickname: undefined,
        userAvatar: undefined,
        userEmail: undefined,
        userPhon: undefined,
        userProtection: undefined,
        userCertification: undefined,
        userRemarks: undefined,
        version: undefined,
        deleted: undefined,
        loginTime: undefined,
        createTime: undefined,
        updateTime: undefined
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.page = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.userId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加用户'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const updateId = row.userId || this.ids
      getUser(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.userId !== undefined) {
            updateUser(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addUser(this.form).then(response => {
              this.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const deletedId = row.userId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteUser(deletedId.toString())
      }).then(() => {
        this.getList()
        this.msgSuccess('删除成功')
      })
    }
  }
}
</script>

<style scoped>
>>> .el-col-20 {
  width: 100%;
}
</style>
