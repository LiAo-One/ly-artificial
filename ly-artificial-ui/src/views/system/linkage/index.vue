<template>
  <div class="app-container">
    <!--sys-device-linkage数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="联动名称" prop="linkageName">
            <el-input
              v-model="queryParams.linkageName"
              placeholder="请输入联动名称"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="联动设备" prop="linkageeDevice">
            <el-input
              v-model="queryParams.linkageeDevice"
              placeholder="请输入联动设备"
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

        <el-table v-loading="loading" :data="linkageList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>


          <el-table-column label="联动记录id" align="center" prop="linkageId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="联动名称" align="center" prop="linkageName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="联动来源" align="center" prop="linkageSource"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="联动设备" align="center" prop="linkageeDevice"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="从机名称" align="center" prop="slaveName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="变量名称" align="center" prop="variableName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="触发条件" align="center" prop="sparkCondition"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="触发设备名称" align="center" prop="deviceName"
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
          <el-form-item label="联动名称" prop="linkageName">
            <el-input v-model="form.linkageName" placeholder="请输入联动名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="联动来源" prop="linkageSource">
            <el-input v-model="form.linkageSource" placeholder="请输入联动来源"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="联动设备" prop="linkageeDevice">
            <el-input v-model="form.linkageeDevice" placeholder="请输入联动设备"/>
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
          <el-form-item label="触发条件" prop="sparkCondition">
            <el-input v-model="form.sparkCondition" placeholder="请输入触发条件"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="触发设备" prop="deviceName">
            <el-input v-model="form.deviceName" placeholder="请输入触发设备名称"/>
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
  listLinkage,
  getLinkage,
  updateLinkage,
  addLinkage,
  deleteLinkage
} from '@/api/system/linkage'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Linkage',
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
      linkageList: null,
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
        linkageId: undefined,
        linkageName: undefined,
        linkageSource: undefined,
        linkageeDevice: undefined,
        slaveName: undefined,
        variableName: undefined,
        sparkCondition: undefined,
        deviceName: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        linkageId: [
          { required: true, message: '联动记录id不能为空', trigger: 'blur' }
        ],
        linkageName: [
          { required: true, message: '联动名称不能为空', trigger: 'blur' }
        ],
        linkageSource: [
          { required: true, message: '联动来源不能为空', trigger: 'blur' }
        ],
        linkageeDevice: [
          { required: true, message: '联动设备不能为空', trigger: 'blur' }
        ],
        slaveName: [
          { required: true, message: '从机名称不能为空', trigger: 'blur' }
        ],
        variableName: [
          { required: true, message: '变量名称不能为空', trigger: 'blur' }
        ],
        sparkCondition: [
          { required: true, message: '触发条件不能为空', trigger: 'blur' }
        ],
        deviceName: [
          { required: true, message: '触发设备名称不能为空', trigger: 'blur' }
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
      listLinkage(this.queryParams).then(response => {
          this.linkageList = response.data.records
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
        linkageId: undefined,
        linkageName: undefined,
        linkageSource: undefined,
        linkageeDevice: undefined,
        slaveName: undefined,
        variableName: undefined,
        sparkCondition: undefined,
        deviceName: undefined,
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
      this.ids = selection.map(item => item.linkageId)
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
      const updateId = row.linkageId || this.ids
      getLinkage(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.linkageId !== undefined) {
            updateLinkage(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addLinkage(this.form).then(response => {
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
      const deletedId = row.linkageId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteLinkage(deletedId.toString())
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
