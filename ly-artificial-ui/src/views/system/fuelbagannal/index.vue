<template>
  <div class="app-container">
    <!--sys-fuelbagannal数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="卡号" prop="annalCardnum">
            <el-input
              v-model="queryParams.annalCardnum"
              placeholder="请输入卡号"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="ICCID" prop="annalIccid">
            <el-input
              v-model="queryParams.annalIccid"
              placeholder="请输入ICCID"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="运营商" prop="destOperators">
            <el-input
              v-model="queryParams.destOperators"
              placeholder="请输入运营商"
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

        <el-table v-loading="loading" :data="fuelbagannalList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>


          <el-table-column label="记录id" align="center" prop="annalId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="卡号" align="center" prop="annalCardnum"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="ICCID" align="center" prop="annalIccid"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="卡状态" align="center" prop="annalState"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.annalState === 0">状态1</el-tag>
              <el-tag v-if="scope.row.annalState === 1">状态2</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="运营商" align="center" prop="destOperators"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="套餐类型" align="center" prop="dextRecodeType"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.dextRecodeType === 0">类型1</el-tag>
              <el-tag v-if="scope.row.dextRecodeType === 1">类型2</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="加油信息" align="center" prop="refuelNews"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="单价" align="center" prop="unitPrice"
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
          <el-form-item label="卡号" prop="annalCardnum">
            <el-input v-model="form.annalCardnum" placeholder="请输入卡号"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="ICCID" prop="annalIccid">
            <el-input v-model="form.annalIccid" placeholder="请输入ICCID"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="卡状态" prop="annalState">
            <!--<el-input v-model="form.cardState" placeholder="请输入卡状态"/>-->
            <el-select v-model="form.annalState" placeholder="请选择">
              <el-option
                label="状态1"
                value="0">
              </el-option>
              <el-option
                label="状态2"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="运营商" prop="destOperators">
            <el-input v-model="form.destOperators" placeholder="请输入运营商"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="套餐类型" prop="dextRecodeType">
           <!-- <el-input v-model="form.dextRecodeType" placeholder="请输入套餐类型"/>-->
            <el-select v-model="form.dextRecodeType" placeholder="请选择">
              <el-option
                label="类型1"
                value="0">
              </el-option>
              <el-option
                label="类型2"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="加油信息" prop="refuelNews">
            <el-input v-model="form.refuelNews" placeholder="请输入加油信息"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="单价" prop="unitPrice">
            <!--<el-input v-model="form.unitPrice" placeholder="请输入单价"/>-->
            <el-input-number v-model="form.unitPrice" controls-position="right" :min="1.00"/>
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
  listFuelbagannal,
  getFuelbagannal,
  updateFuelbagannal,
  addFuelbagannal,
  deleteFuelbagannal
} from '@/api/system/fuelbagannal'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Fuelbagannal',
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
      fuelbagannalList: null,
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
        annalId: undefined,
        annalCardnum: undefined,
        annalIccid: undefined,
        annalState: undefined,
        destOperators: undefined,
        dextRecodeType: undefined,
        refuelNews: undefined,
        unitPrice: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        annalId: [
          { required: true, message: '记录id不能为空', trigger: 'blur' }
        ],
        annalCardnum: [
          { required: true, message: '卡号不能为空', trigger: 'blur' }
        ],
        annalIccid: [
          { required: true, message: 'ICCID不能为空', trigger: 'blur' }
        ],
        annalState: [
          { required: true, message: '卡状态不能为空', trigger: 'blur' }
        ],
        destOperators: [
          { required: true, message: '运营商不能为空', trigger: 'blur' }
        ],
        dextRecodeType: [
          { required: true, message: '套餐类型不能为空', trigger: 'blur' }
        ],
        refuelNews: [
          { required: true, message: '加油信息不能为空', trigger: 'blur' }
        ],
        unitPrice: [
          { required: true, message: '单价不能为空', trigger: 'blur' }
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
      listFuelbagannal(this.queryParams).then(response => {
          this.fuelbagannalList = response.data.records
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
        annalId: undefined,
        annalCardnum: undefined,
        annalIccid: undefined,
        annalState: undefined,
        destOperators: undefined,
        dextRecodeType: undefined,
        refuelNews: undefined,
        unitPrice: undefined,
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
      this.ids = selection.map(item => item.annalId)
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
      const updateId = row.annalId || this.ids
      getFuelbagannal(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.annalId !== undefined) {
            updateFuelbagannal(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addFuelbagannal(this.form).then(response => {
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
      const deletedId = row.annalId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteFuelbagannal(deletedId.toString())
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
