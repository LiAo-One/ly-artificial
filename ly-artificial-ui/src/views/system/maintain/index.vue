<template>
  <div class="app-container">
    <!--sys-plan-maintain数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="维保计划名称" prop="planName">
            <el-input
              v-model="queryParams.planName"
              placeholder="请输入维保计划名称"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="所属项目" prop="planProject">
            <el-input
              v-model="queryParams.planProject"
              placeholder="请输入所属项目"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="维保设备SN" prop="planDeviceSn">
            <el-input
              v-model="queryParams.planDeviceSn"
              placeholder="请输入维保设备SN"
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

        <el-table v-loading="loading" :data="maintainList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>


          <el-table-column label="维保计划id" align="center" prop="planId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="维保计划名称" align="center" prop="planName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="所属项目" align="center" prop="planProject"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="维保设备SN" align="center" prop="planDeviceSn"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="计划状态" align="center" prop="planStudent"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.planStudent === 0">待处理</el-tag>
              <el-tag v-else-if="scope.row.planStudent === 1" type="success">已派单</el-tag>
              <el-tag v-else-if="scope.row.planStudent === 2" type="warning">执行中</el-tag>
              <el-tag v-else-if="scope.row.planStudent === 3" type="info">已结单</el-tag>
              <el-tag v-else-if="scope.row.planStudent === 4" type="info">主动结束</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="计计划类型" align="center" prop="planType"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.planType === 0">常规维保</el-tag>
              <el-tag v-else type="danger">故障维保</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="下次维保时间" align="center" prop="nextTime"
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
              <!--<el-button
                size="mini"
                type="text"
                icon="el-icon-edit"
                @click="handleUpdate(scope.row)"
              >修改
              </el-button>-->
              <el-button
                v-if="scope.row.planStudent === 1"
                size="mini"
                type="text"
                icon="el-icon-edit">
                结束工单
              </el-button>

              <el-button
                v-if="scope.row.planStudent === 2"
                size="mini"
                type="text"
                icon="el-icon-edit">
                结束工单
              </el-button>

              <el-button
                v-if="scope.row.planStudent === 3||scope.row.planStudent === 4"
                size="mini"
                type="text"
                icon="el-icon-edit">
                维保报告
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
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-col :span="12">
          <el-form-item label="计划名称" prop="planName">
            <el-input v-model="form.planName" placeholder="请输入维保计划名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="所属项目" prop="planProject">
            <el-input v-model="form.planProject" placeholder="请输入所属项目"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="设备SN" prop="planDeviceSn">
            <el-input v-model="form.planDeviceSn" placeholder="请输入维保设备SN"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="计划状态" prop="planStudent">
            <!--<el-input v-model="form.planStudent" placeholder="0 待处理 1 已派单 2 执行中"/>-->
            <el-select v-model="form.planStudent" placeholder="请选择">
              <el-option
                label="待处理"
                value="0">
              </el-option>
              <el-option
                label="已派单"
                value="1">
              </el-option>
              <el-option
                label="执行中"
                value="2">
              </el-option>
              <el-option
                label="已结单"
                value="3">
              </el-option>
              <el-option
                label="主动结束"
                value="4">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="计划类型">
            <!--<el-input v-model="form.planType" placeholder="请输入计划类型0 保内维保"/>-->
            <el-select v-model="form.planType" placeholder="请选择">
              <el-option
                label="保内维保"
                value="0">
              </el-option>
              <el-option
                label="其他"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="下次时间">
            <template>
              <el-date-picker
                v-model="form.nextTime"
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </template>
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
  listMaintain,
  getMaintain,
  updateMaintain,
  addMaintain,
  deleteMaintain
} from '@/api/system/maintain'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Maintain',
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
      maintainList: null,
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
        planId: undefined,
        planName: undefined,
        planProject: undefined,
        planDeviceSn: undefined,
        planStudent: undefined,
        planType: undefined,
        nextTime: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        planId: [
          { required: true, message: '维保计划id不能为空', trigger: 'blur' }
        ],
        planName: [
          { required: true, message: '维保计划名称不能为空', trigger: 'blur' }
        ],
        planProject: [
          { required: true, message: '所属项目不能为空', trigger: 'blur' }
        ],
        planDeviceSn: [
          { required: true, message: '维保设备SN不能为空', trigger: 'blur' }
        ],
        planStudent: [
          { required: true, message: '计划状态0 待处理 1 已派单 2 执行中不能为空', trigger: 'blur' }
        ],
        planType: [
          { required: true, message: '计划状态0 待处理 1 已派单 2 执行中不能为空', trigger: 'blur' }
        ],
        nextTime: [
          { required: true, message: '下次维保时间不能为空', trigger: 'blur' }
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
      listMaintain(this.queryParams).then(response => {
          this.maintainList = response.data.records
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
        planId: undefined,
        planName: undefined,
        planProject: undefined,
        planDeviceSn: undefined,
        planStudent: undefined,
        planType: undefined,
        nextTime: undefined,
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
      this.ids = selection.map(item => item.planId)
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
      const updateId = row.planId || this.ids
      getMaintain(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.planId !== undefined) {
            updateMaintain(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addMaintain(this.form).then(response => {
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
      const deletedId = row.planId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteMaintain(deletedId.toString())
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
