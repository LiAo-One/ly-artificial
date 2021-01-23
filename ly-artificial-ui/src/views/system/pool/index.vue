<template>
  <div class="app-container">
    <!--sys-flow-pool数据-->
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="流量池编码" prop="poolCode">
            <el-input
              v-model="queryParams.poolCode"
              placeholder="请输入流量池编码"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
          <el-form-item label="套餐信息" prop="setmealInfo">
            <el-input
              v-model="queryParams.setmealInfo"
              placeholder="请输入套餐信息"
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
          <el-form-item label="APN 名称" prop="destApn">
            <el-input
              v-model="queryParams.destApn"
              placeholder="请输入APN 名称"
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

        <el-table v-loading="loading" :data="poolList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>

          <el-table-column label="主键" align="center" prop="poolId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="流量池编码" align="center" prop="poolCode"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="套餐信息" align="center" prop="setmealInfo"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="运营商" align="center" prop="destOperators"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="APN" align="center" prop="destApn"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="年流量" align="center" prop="poolTitFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="已使用" align="center" prop="poolUsedFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="剩余流量" align="center" prop="poolHaveFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="扩容包已用流量" align="center" prop="poolSpreadFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="自动扩容" align="center" prop="poolAutomatic"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.poolAutomatic=== 0">否</span>
              <span v-if="scope.row.poolAutomatic=== 1">是</span>
            </template>
          </el-table-column>

          <el-table-column label="成员数量" align="center" prop="memberAmount"
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
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-col :span="12">
          <el-form-item label="流量池" prop="poolCode">
            <el-input v-model="form.poolCode" placeholder="请输入流量池编码"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="套餐信息" prop="setmealInfo">
            <el-input v-model="form.setmealInfo" placeholder="请输入套餐信息"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="运营商" prop="destOperators">
            <el-input v-model="form.destOperators" placeholder="请输入运营商"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="APN" prop="destApn">
            <el-input v-model="form.destApn" placeholder="请输入APN 名称"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="年流量" prop="poolTitFlow">
           <!-- <el-input v-model="form.poolTitFlow" placeholder="请输入年流量"/>-->
            <el-input-number v-model="form.poolTitFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="已使用" prop="poolUsedFlow">
            <!--<el-input v-model="form.poolUsedFlow" placeholder="请输入已使用"/>-->
            <el-input-number v-model="form.poolUsedFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="剩余流量" prop="poolHaveFlow">
            <!--<el-input v-model="form.poolHaveFlow" placeholder="请输入剩余流量"/>-->
            <el-input-number v-model="form.poolHaveFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="已用流量" prop="poolSpreadFlow">
            <!--<el-input v-model="form.poolSpreadFlow" placeholder="请输入扩容包已用流量"/>-->
            <el-input-number v-model="form.poolSpreadFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="自动扩容" prop="poolAutomatic">
            <!--<el-input v-model="form.poolAutomatic" placeholder="请输入是否自动扩容 0否 1是"/>-->
            <el-select v-model="form.poolAutomatic" placeholder="请选择">
              <el-option
                label="否"
                value="0">
              </el-option>
              <el-option
                label="是"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="成员数量" prop="memberAmount">
            <!--<el-input v-model="form.memberAmount" placeholder="请输入成员数量"/>-->
            <el-input-number v-model="form.memberAmount" controls-position="right" :min="1.00"/>
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
  listPool,
  getPool,
  updatePool,
  addPool,
  deletePool
} from '@/api/system/pool'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Pool',
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
      poolList: null,
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
        poolId: undefined,
        poolCode: undefined,
        setmealInfo: undefined,
        destOperators: undefined,
        destApn: undefined,
        poolTitFlow: undefined,
        poolUsedFlow: undefined,
        poolHaveFlow: undefined,
        poolSpreadFlow: undefined,
        poolAutomatic: undefined,
        memberAmount: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        poolId: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ],
        poolCode: [
          { required: true, message: '流量池编码不能为空', trigger: 'blur' }
        ],
        setmealInfo: [
          { required: true, message: '套餐信息不能为空', trigger: 'blur' }
        ],
        destOperators: [
          { required: true, message: '运营商不能为空', trigger: 'blur' }
        ],
        destApn: [
          { required: true, message: 'APN 名称不能为空', trigger: 'blur' }
        ],
        poolTitFlow: [
          { required: true, message: '年流量不能为空', trigger: 'blur' }
        ],
        poolUsedFlow: [
          { required: true, message: '已使用不能为空', trigger: 'blur' }
        ],
        poolHaveFlow: [
          { required: true, message: '剩余流量不能为空', trigger: 'blur' }
        ],
        poolSpreadFlow: [
          { required: true, message: '扩容包已用流量不能为空', trigger: 'blur' }
        ],
        poolAutomatic: [
          { required: true, message: '是否自动扩容 0否 1是不能为空', trigger: 'blur' }
        ],
        memberAmount: [
          { required: true, message: '成员数量不能为空', trigger: 'blur' }
        ],
        version: [
          { required: true, message: '乐观锁不能为空', trigger: 'blur' }
        ],
        deleted: [
          { required: true, message: '逻辑删除不能为空', trigger: 'blur' }
        ],
        updateTime: [
          { required: true, message: '更新时间不能为空', trigger: 'blur' }
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
      listPool(this.queryParams).then(response => {
          this.poolList = response.data.records
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
        poolId: undefined,
        poolCode: undefined,
        setmealInfo: undefined,
        destOperators: undefined,
        destApn: undefined,
        poolTitFlow: undefined,
        poolUsedFlow: undefined,
        poolHaveFlow: undefined,
        poolSpreadFlow: undefined,
        poolAutomatic: undefined,
        memberAmount: undefined,
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
      this.ids = selection.map(item => item.poolId)
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
      const updateId = row.poolId || this.ids
      getPool(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.poolId !== undefined) {
            updatePool(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addPool(this.form).then(response => {
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
      const deletedId = row.poolId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deletePool(deletedId.toString())
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
