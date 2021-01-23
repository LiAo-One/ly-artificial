<template>
  <div class="app-container">
    <!--sys-alarmcontact数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="联系人姓名" prop="contactNaem">
            <el-input
              v-model="queryParams.contactNaem"
              placeholder="请输入联系人姓名"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="所属项目" prop="contactProject">
            <el-input
              v-model="queryParams.contactProject"
              placeholder="请输入所属项目"
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

        <el-table v-loading="loading" :data="alarmcontactList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>

          <el-table-column label="联系人id" align="center" prop="contactId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="联系人姓名" align="center" prop="contactNaem"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="联系人手机" align="center" prop="contactPhon"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="所属项目" align="center" prop="contactProject"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="创建时间" align="center" prop="createTime"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="修改时间" align="center" prop="updateTime"
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
          <el-form-item label="姓名" prop="contactNaem">
            <el-input v-model="form.contactNaem" placeholder="请输入联系人姓名"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机">
            <el-input v-model="form.contactPhon" placeholder="请输入联系人手机"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="form.contactEmail" placeholder="请输入邮箱"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="微信">
            <el-input v-model="form.contactWachat" placeholder="请输入微信"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所属项目">
            <!--<el-input v-model="form.contactProject" placeholder="请输入所属项目"/>-->
            <treeselect @select="deviceProjectClike" :options="deptOptions" :show-count="true"
                        placeholder="请选择所属项目名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="remarks">
            <el-input v-model="form.remarks" placeholder="请输入备注"/>
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
  listAlarmcontact,
  getAlarmcontact,
  updateAlarmcontact,
  addAlarmcontact,
  deleteAlarmcontact
} from '@/api/system/alarmcontact'
import { treeselect } from '@/api/system/dept'
import Treeselect from '@riophae/vue-treeselect'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Alarmcontact',
  components: { Treeselect },
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
      alarmcontactList: null,
      // 部门树选项
      deptOptions: undefined,
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
        contactId: undefined,
        contactNaem: undefined,
        contactPhon: undefined,
        contactEmail: undefined,
        contactWachat: undefined,
        contactProject: undefined,
        remarks: undefined,
        version: undefined,
        deleted: undefined,
        createTime: undefined,
        updateTime: undefined
      },
      // 表单校验
      rules: {
        contactId: [
          { required: true, message: '联系人id不能为空', trigger: 'blur' }
        ],
        contactNaem: [
          { required: true, message: '联系人姓名不能为空', trigger: 'blur' }
        ],
        contactPhon: [
          { required: true, message: '联系人手机不能为空', trigger: 'blur' }
        ],
        email: [
          {
            type: 'email',
            message: '\'请输入正确的邮箱地址',
            trigger: ['blur', 'change']
          }
        ]
      }
    }
  },
  created() {
    this.getList()
    this.getTreeselect()
  },
  methods: {
    /** 查询联系人列表 */
    getList() {
      this.loading = true
      listAlarmcontact(this.queryParams).then(response => {
          this.alarmcontactList = response.data.records
          this.total = response.data.total
          this.loading = false
        }
      )
    },
    // 项目树下拉
    getTreeselect() {
      treeselect().then(response => {
        this.deptOptions = response.data
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        contactId: undefined,
        contactNaem: undefined,
        contactPhon: undefined,
        contactEmail: undefined,
        contactWachat: undefined,
        contactProject: undefined,
        remarks: undefined,
        version: undefined,
        deleted: undefined,
        createTime: undefined,
        updateTime: undefined

      }
      this.form.contactProject = undefined,
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
      this.ids = selection.map(item => item.contactId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.getTreeselect()
      this.reset()
      this.open = true
      this.title = '添加联系人'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      this.getTreeselect()
      const updateId = row.contactId || this.ids
      getAlarmcontact(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改联系人'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.contactId !== undefined) {
            updateAlarmcontact(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addAlarmcontact(this.form).then(response => {
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
      const deletedId = row.contactId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteAlarmcontact(deletedId.toString())
      }).then(() => {
        this.getList()
        this.msgSuccess('删除成功')
      })
    },
    // 项目数选中事件
    deviceProjectClike(data) {
      this.form.contactProject = data.label
    }
  }
}
</script>

<style scoped>
>>> .el-col-20 {
  width: 100%;
}
</style>
