<template>
  <div class="app-container">
    <!--sys-meal-changeapply数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="卡号" prop="cardNum">
            <el-input
              v-model="queryParams.cardNum"
              placeholder="请输入卡号"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="ICCID" prop="cardIccid">
            <el-input
              v-model="queryParams.cardIccid"
              placeholder="请输入ICCID"
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

        <el-table v-loading="loading" :data="changeapplyList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>

          <el-table-column label="变更申请Id" align="center" prop="mealChangeApplyId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="卡号" align="center" prop="cardNum"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="ICCID" align="center" prop="cardIccid"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="状态" align="center" prop="cardState"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.cardState === 0" type="success">进行中</el-tag>
              <el-tag v-else-if="scope.row.cardState === 1" type="info">已结单</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="运营商" align="center" prop="cardOpear"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="类型" align="center" prop="cardType"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <el-tag v-if="scope.row.cardType === 0" type="success">类型1</el-tag>
              <el-tag v-else-if="scope.row.cardType === 1" type="info">类型2</el-tag>
            </template>
          </el-table-column>

          <el-table-column label="当前套餐" align="center" prop="cardCurMeal"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="剩余流量" align="center" prop="cardHaveFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="到期时间" align="center" prop="cardTimeout"
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
          <el-form-item label="卡号" prop="cardNum">
            <el-input v-model="form.cardNum" placeholder="请输入卡号"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="ICCID" prop="cardIccid">
            <el-input v-model="form.cardIccid" placeholder="请输入ICCID"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="状态" prop="cardState">
            <!--<el-input v-model="form.cardState" placeholder="请输入状态"/>-->
            <el-select v-model="form.cardState" placeholder="请选择">
              <el-option
                label="进行中"
                value="0">
              </el-option>
              <el-option
                label="已结单"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="运营商" prop="cardOpear">
            <el-input v-model="form.cardOpear" placeholder="请输入运营商"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类型" prop="cardType">
            <!--<el-input v-model="form.cardType" placeholder="请输入类型"/>-->
            <el-select v-model="form.cardType" placeholder="请选择">
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
          <el-form-item label="当前套餐" prop="cardCurMeal">
            <el-input v-model="form.cardCurMeal" placeholder="请输入当前套餐"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="剩余流量" prop="cardHaveFlow">
            <!--<el-input v-model="form.cardHaveFlow" placeholder="请输入剩余流量"/>-->
            <el-input-number v-model="form.cardHaveFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="到期时间" prop="cardTimeout">
            <template>
              <el-date-picker
                v-model="form.cardTimeout"
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
  listChangeapply,
  getChangeapply,
  updateChangeapply,
  addChangeapply,
  deleteChangeapply
} from '@/api/system/changeapply'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Changeapply',
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
      changeapplyList: null,
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
        mealChangeApplyId: undefined,
        cardNum: undefined,
        cardIccid: undefined,
        cardState: undefined,
        cardOpear: undefined,
        cardType: undefined,
        cardCurMeal: undefined,
        cardHaveFlow: undefined,
        cardTimeout: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        mealChangeApplyId: [
          { required: true, message: '变更申请Id不能为空', trigger: 'blur' }
        ],
        cardNum: [
          { required: true, message: '卡号不能为空', trigger: 'blur' }
        ],
        cardIccid: [
          { required: true, message: 'ICCID不能为空', trigger: 'blur' }
        ],
        cardState: [
          { required: true, message: '状态不能为空', trigger: 'blur' }
        ],
        cardOpear: [
          { required: true, message: '运营商不能为空', trigger: 'blur' }
        ],
        cardType: [
          { required: true, message: '类型不能为空', trigger: 'blur' }
        ],
        cardCurMeal: [
          { required: true, message: '当前套餐不能为空', trigger: 'blur' }
        ],
        cardHaveFlow: [
          { required: true, message: '剩余流量不能为空', trigger: 'blur' }
        ],
        cardTimeout: [
          { required: true, message: '到期时间不能为空', trigger: 'blur' }
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
      listChangeapply(this.queryParams).then(response => {
          this.changeapplyList = response.data.records
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
        mealChangeApplyId: undefined,
        cardNum: undefined,
        cardIccid: undefined,
        cardState: undefined,
        cardOpear: undefined,
        cardType: undefined,
        cardCurMeal: undefined,
        cardHaveFlow: undefined,
        cardTimeout: undefined,
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
      this.ids = selection.map(item => item.mealChangeApplyId)
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
      const updateId = row.mealChangeApplyId || this.ids
      getChangeapply(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.mealChangeApplyId !== undefined) {
            updateChangeapply(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addChangeapply(this.form).then(response => {
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
      const deletedId = row.mealChangeApplyId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteChangeapply(deletedId.toString())
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
