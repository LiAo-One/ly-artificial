<template>
  <div class="app-container">
    <!--sys-alarm-record数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="设备名称" prop="deviceName">
            <el-input
              v-model="queryParams.deviceName"
              placeholder="请输入设备名称"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="从机名称" prop="slaveName">
            <el-input
              v-model="queryParams.slaveName"
              placeholder="请输入从机名称"
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

        <el-table v-loading="loading" :data="recordList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>


          <el-table-column label="设备id" align="center" prop="recordId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="设备名称" align="center" prop="deviceName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="从机名称" align="center" prop="slaveName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="变量名称" align="center" prop="variableName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="当前值" align="center" prop="currentValuet"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="触发条件" align="center" prop="currentSpark"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="当前状态" align="center" prop="student"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.student === 0">正常</el-tag>
              <el-tag v-if="scope.row.student === 1">异常</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="是否处理" align="center" prop="isProcess"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.isProcess === 0">已处理</el-tag>
              <el-tag v-if="scope.row.isProcess === 1">未处理</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="创建时间" align="center" prop="createTime"
                           :show-overflow-tooltip="true"/>
          <el-table-column
            label="操作"
            align="center"
            width="160"
            class-name="small-padding fixed-width"
          >
            <template slot-scope="scope">
              <el-button v-if="scope.row.isProcess === 1"
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
              >处理
              </el-button>
              <!-- v-if="scope.row.userId !== 1"-->
              <!--<el-button
                size="mini"
                type="text"
                icon="el-icon-delete"
                @click="handleDelete(scope.row)"
              >删除
              </el-button>-->
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
          <el-form-item label="设备名称" prop="deviceName">
            <el-input v-model="form.deviceName" placeholder="请输入设备名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="从机名称" prop="slaveName">
            <el-input v-model="form.slaveName" placeholder="请输入从机名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="变量名称" prop="variableName">
            <el-input v-model="form.variableName" placeholder="请输入变量名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="当前值" prop="currentValuet">
            <!--<el-input v-model="form.currentValuet" placeholder="请输入当前值"/>-->
            <el-input-number v-model="form.currentValuet" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="触发条件" prop="currentSpark">
            <el-input v-model="form.currentSpark" placeholder="请输入触发条件"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="当前状态" prop="student">
            <el-select v-model="form.student" placeholder="请选择">
              <el-option
                label="正常"
                value="0">
              </el-option>
              <el-option
                label="异常"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="是否处理" prop="isProcess">
            <el-select v-model="form.isProcess" placeholder="请选择">
              <el-option
                label="已处理"
                value="0">
              </el-option>
              <el-option
                label="未处理"
                value="1">
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
  listRecord,
  getRecord,
  updateRecord,
  addRecord,
  deleteRecord
} from '@/api/system/record'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Record',
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
      recordList: null,
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
        recordId: undefined,
        deviceName: undefined,
        slaveName: undefined,
        variableName: undefined,
        currentValuet: undefined,
        currentSpark: undefined,
        student: undefined,
        isProcess: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        recordId: [
          { required: true, message: '设备id不能为空', trigger: 'blur' }
        ],
        deviceName: [
          { required: true, message: '设备名称不能为空', trigger: 'blur' }
        ],
        slaveName: [
          { required: true, message: '从机名称不能为空', trigger: 'blur' }
        ],
        variableName: [
          { required: true, message: '变量名称不能为空', trigger: 'blur' }
        ],
        currentValuet: [
          { required: true, message: '当前值不能为空', trigger: 'blur' }
        ],
        currentSpark: [
          { required: true, message: '触发条件不能为空', trigger: 'blur' }
        ],
        student: [
          { required: true, message: '当前状态 0正常 1异常不能为空', trigger: 'blur' }
        ],
        isProcess: [
          { required: true, message: '是否处理 0处理 1 未处理不能为空', trigger: 'blur' }
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
      listRecord(this.queryParams).then(response => {
          this.recordList = response.data.records
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
        recordId: undefined,
        deviceName: undefined,
        slaveName: undefined,
        variableName: undefined,
        currentValuet: undefined,
        currentSpark: undefined,
        student: undefined,
        isProcess: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
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
      this.ids = selection.map(item => item.recordId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加用户'
    },
    /** 处理事故 */
    handleUpdate(row) {
      this.reset()
      const updateId = row.recordId || this.ids

      this.$confirm('是否处理事件编号为"' + updateId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return updateRecord(updateId.toString())
      }).then(() => {
        this.getList()
        this.msgSuccess('处理成功')
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.recordId !== undefined) {
            updateRecord(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addRecord(this.form).then(response => {
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
      const deletedId = row.recordId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteRecord(deletedId.toString())
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
