<template>
  <div class="app-container">
    <!--sys-alarm-notice数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="通知id" prop="noticeId">
            <el-input
              v-model="queryParams.noticeId"
              placeholder="请输入通知id"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="通知名称" prop="noticeName">
            <el-input
              v-model="queryParams.noticeName"
              placeholder="请输入通知名称"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="设备SN" prop="deviceSn">
            <el-input
              v-model="queryParams.deviceSn"
              placeholder="请输入设备SN"
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

        <el-table v-loading="loading" :data="noticeList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>


          <el-table-column label="通知id" align="center" prop="noticeId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="通知名称" align="center" prop="noticeName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="设备SN" align="center" prop="deviceSn"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="推送间隔" align="center" prop="noticeInterval"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="推送方式" align="center" prop="noticeTheway"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="推送人的id" align="center" prop="noticePeople"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="修改时间" align="center" prop="updateTime"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="创建时间" align="center" prop="createTime"
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
          <el-form-item label="通知名称" prop="noticeName">
            <el-input v-model="form.noticeName" placeholder="请输入通知名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="设备SN" prop="deviceSn">
            <el-input v-model="form.deviceSn" placeholder="请输入设备SN"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="推送间隔">
            <el-input-number v-model="form.noticeInterval" controls-position="right" :min="1"/>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="推送方式">
            <el-select v-model="noticeThewayValue" multiple placeholder="请选择">
              <el-option
                label="短信"
                value="0">
              </el-option>
              <el-option
                label="微信"
                value="1">
              </el-option>
              <el-option
                label="邮件"
                value="2">
              </el-option>
              <el-option
                label="语音"
                value="3">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="推送人id" prop="noticePeople">
            <el-select v-model="noticePeopleValue" multiple placeholder="请选择">
              <el-option v-for="value in alarmcontactAll"
                         :key="value.contactId"
                         :label="value.contactNaem"
                         :value="value.contactId">
              </el-option>
            </el-select>
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
  listNotice,
  getNotice,
  updateNotice,
  addNotice,
  deleteNotice
} from '@/api/system/notice'

import {
  getAll
} from '@/api/system/alarmcontact'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Notice',
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
      noticeList: null,
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
        noticeId: undefined,
        noticeName: undefined,
        deviceSn: undefined,
        noticeInterval: undefined,
        noticeTheway: undefined,
        noticePeople: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      noticeThewayValue: [],
      // 所有推送人
      alarmcontactAll: [],
      // 选中推送人
      noticePeopleValue: [],
      // 表单校验
      rules: {
        noticeId: [
          { required: true, message: '通知id不能为空', trigger: 'blur' }
        ],
        noticeName: [
          { required: true, message: '通知名称不能为空', trigger: 'blur' }
        ],
        deviceSn: [
          { required: true, message: '设备SN不能为空', trigger: 'blur' }
        ],
        noticeInterval: [
          { required: true, message: '推送间隔 分钟不能为空', trigger: 'blur' }
        ],
        noticePeople: [
          { required: true, message: '推送人的id，多个用“,” 隔开不能为空', trigger: 'blur' }
        ],
        version: [
          { required: true, message: '乐观锁不能为空', trigger: 'blur' }
        ],
        deleted: [
          { required: true, message: '逻辑删除不能为空', trigger: 'blur' }
        ],
        updateTime: [
          { required: true, message: '修改时间不能为空', trigger: 'blur' }
        ],
        createTime: [
          { required: true, message: '创建时间不能为空', trigger: 'blur' }
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
      listNotice(this.queryParams).then(response => {
          this.noticeList = response.data.records
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
        noticeId: undefined,
        noticeName: undefined,
        deviceSn: undefined,
        noticeInterval: undefined,
        noticeTheway: undefined,
        noticePeople: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      }
      this.resetForm('form')
      this.noticeThewayValue = []
      // 选中推送人
      this.noticePeopleValue = []
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
      this.ids = selection.map(item => item.noticeId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加报警'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      this.getAlarmcontact()
      const updateId = row.noticeId || this.ids
      getNotice(updateId.toString()).then(response => {
        this.form = response.data
        // 联系方式
        this.noticeThewayValue = this.getArr(this.form.noticeTheway, ',')
        // 选中推送人
        this.noticePeopleValue = this.getArr(this.form.noticePeople, ',')
        this.open = true
        this.title = '修改报警'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        // 推送种类
        this.form.noticeTheway = this.noticeThewayValue.toString()
        // 联系人
        this.form.noticePeople = this.noticePeopleValue.toString()
        if (valid) {
          if (this.form.noticeId !== undefined) {
            updateNotice(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addNotice(this.form).then(response => {
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
      const deletedId = row.noticeId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteNotice(deletedId.toString())
      }).then(() => {
        this.getList()
        this.msgSuccess('删除成功')
      })
    },
    getAlarmcontact() {
      getAll().then(arr => {
        // 联系人
        this.alarmcontactAll = arr.data
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
