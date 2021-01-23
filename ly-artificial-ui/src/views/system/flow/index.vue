<template>
  <div class="app-container">
    <!--sys-card-flow数据-->
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
          <el-form-item label="运营商" prop="operators">
            <el-input
              v-model="queryParams.operators"
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
              type="primary"
              icon="el-icon-plus"
              size="mini"
              :disabled="multiple"
            >续期
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="mini"
              :disabled="multiple"
            >变更套餐
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="mini"
              :disabled="multiple"
            >加油包
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              icon="el-icon-plus"
              size="mini"
              :disabled="multiple"
            >销号
            </el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button
              type="danger"
              icon="el-icon-plus"
              size="mini"
              :disabled="multiple"
            >解绑
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

        <el-table v-loading="loading" :data="flowList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>

          <el-table-column label="卡号" align="center" prop="cardNum"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="ICCID" align="center" prop="cardIccid"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="运营商" align="center" prop="operators"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="类别" align="center" prop="cardType"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.cardType=== 0">年卡</span>
              <span v-else>其他</span>
            </template>
          </el-table-column>

          <el-table-column label="状态" align="center" prop="cardState"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.cardState=== 0">正常</span>
              <span v-else>停用</span>
            </template>
          </el-table-column>

          <el-table-column label="年流量" align="center" prop="cardTitFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="已使用" align="center" prop="cardUsedFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="剩余流量" align="center" prop="cardHaveFlow"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="激活时间" align="center" prop="cardActiDate"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="过期时间" align="center" prop="cardTimeout"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="提醒" align="center" prop="cardRemind"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.cardRemind=== 0">开启</span>
              <span v-else>关闭</span>
            </template>
          </el-table-column>

          <el-table-column label="批次号" align="center" prop="cardBatchnum"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="认证状态" align="center" prop="cardAuthState"
                           :show-overflow-tooltip="true">
            <template slot-scope="scope">
              <span v-if="scope.row.cardRemind=== 0">需要</span>
              <span v-else>不需要</span>
            </template>
          </el-table-column>

          <el-table-column label="用户姓名" align="center" prop="cardUserName"
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
    <el-dialog :title="title" :visible.sync="open" width="800px" append-to-body>
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
          <el-form-item label="运营商" prop="operators">
            <el-input v-model="form.operators" placeholder="请输入运营商"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="类别" prop="cardType">
            <!--<el-input v-model="form.cardType" placeholder="请输入类别 0：年卡 "/>-->
            <el-select v-model="form.cardType" placeholder="请选择">
              <el-option
                label="年卡"
                value="0">
              </el-option>
              <el-option
                label="月卡"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="状态" prop="cardState">
            <!--<el-input v-model="form.cardState" placeholder="请输入状态 0：正常"/>-->
            <el-select v-model="form.cardState" placeholder="请选择">
              <el-option
                label="正常"
                value="0">
              </el-option>
              <el-option
                label="停用"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="年流量" prop="cardTitFlow">
            <!--<el-input v-model="form.cardTitFlow" placeholder="请输入年流量"/>-->
            <el-input-number v-model="form.cardTitFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="已使用" prop="cardUsedFlow">
            <!--<el-input v-model="form.cardUsedFlow" placeholder="请输入已使用"/>-->
            <el-input-number v-model="form.cardUsedFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="剩余流量" prop="cardHaveFlow">
            <!--<el-input v-model="form.cardHaveFlow" placeholder="请输入剩余流量"/>-->
            <el-input-number v-model="form.cardHaveFlow" controls-position="right" :min="1.00"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="激活时间" prop="cardActiDate">
            <!--<el-input v-model="form.cardActiDate" placeholder="请输入激活时间"/>-->
            <template>
              <el-date-picker
                v-model="form.cardActiDate"
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </template>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="过期时间" prop="cardTimeout">
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
        <el-col :span="12">
          <el-form-item label="提醒" prop="cardRemind">
            <!--<el-input v-model="form.cardRemind" placeholder="请输入提醒（0：开启:1：关闭）"/>-->
            <el-select v-model="form.cardRemind" placeholder="请选择">
              <el-option
                label="开启"
                value="0">
              </el-option>
              <el-option
                label="关闭"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="批次号" prop="cardBatchnum">
            <el-input v-model="form.cardBatchnum" placeholder="请输入批次号"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="认证状态" prop="cardAuthState">
            <!--<el-input v-model="form.cardAuthState" placeholder="请输入认证状态（0：需要 1：不需要）"/>-->
            <el-select v-model="form.cardAuthState" placeholder="请选择">
              <el-option
                label="需要"
                value="0">
              </el-option>
              <el-option
                label="不需要"
                value="1">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="标签" prop="cardLable">
            <el-input v-model="form.cardLable" placeholder="请输入标签"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="备注" prop="cardNote">
            <el-input v-model="form.cardNote" placeholder="请输入备注"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label=" 用户id" prop="cardUserid">
            <el-input v-model="form.cardUserid" placeholder="请输入 用户id"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="用户姓名" prop="cardUserName">
            <el-input v-model="form.cardUserName" placeholder="请输入用户姓名"/>
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
  listFlow,
  getFlow,
  updateFlow,
  addFlow,
  deleteFlow
} from '@/api/system/flow'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Flow',
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
      flowList: null,
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
        flowCardId: undefined,
        cardNum: undefined,
        cardIccid: undefined,
        operators: undefined,
        cardType: undefined,
        cardState: undefined,
        cardTitFlow: undefined,
        cardUsedFlow: undefined,
        cardHaveFlow: undefined,
        cardActiDate: undefined,
        cardTimeout: undefined,
        cardRemind: undefined,
        cardBatchnum: undefined,
        cardAuthState: undefined,
        cardLable: undefined,
        cardNote: undefined,
        cardUserid: undefined,
        cardUserName: undefined,
        version: undefined,
        deleted: undefined,
        updateTime: undefined,
        createTime: undefined
      },
      // 表单校验
      rules: {
        flowCardId: [
          { required: true, message: '流量卡主键不能为空', trigger: 'blur' }
        ],
        cardNum: [
          { required: true, message: '卡号不能为空', trigger: 'blur' }
        ],
        cardIccid: [
          { required: true, message: 'ICCID不能为空', trigger: 'blur' }
        ],
        operators: [
          { required: true, message: '运营商不能为空', trigger: 'blur' }
        ],
        cardType: [
          { required: true, message: '类别 0：年卡 不能为空', trigger: 'blur' }
        ],
        cardState: [
          { required: true, message: '状态 0：正常不能为空', trigger: 'blur' }
        ],
        cardTitFlow: [
          { required: true, message: '年流量不能为空', trigger: 'blur' }
        ],
        cardUsedFlow: [
          { required: true, message: '已使用不能为空', trigger: 'blur' }
        ],
        cardHaveFlow: [
          { required: true, message: '剩余流量不能为空', trigger: 'blur' }
        ],
        cardActiDate: [
          { required: true, message: '激活时间不能为空', trigger: 'blur' }
        ],
        cardTimeout: [
          { required: true, message: '过期时间不能为空', trigger: 'blur' }
        ],
        cardRemind: [
          { required: true, message: '提醒（0：开启:1：关闭）不能为空', trigger: 'blur' }
        ],
        cardBatchnum: [
          { required: true, message: '批次号不能为空', trigger: 'blur' }
        ],
        cardAuthState: [
          { required: true, message: '认证状态（0：需要 1：不需要）不能为空', trigger: 'blur' }
        ],
        cardLable: [
          { required: true, message: '标签不能为空', trigger: 'blur' }
        ],
        cardNote: [
          { required: true, message: '备注不能为空', trigger: 'blur' }
        ],
        cardUserid: [
          { required: true, message: ' 用户id不能为空', trigger: 'blur' }
        ],
        cardUserName: [
          { required: true, message: '用户姓名不能为空', trigger: 'blur' }
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
      listFlow(this.queryParams).then(response => {
          this.flowList = response.data.records
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
        flowCardId: undefined,
        cardNum: undefined,
        cardIccid: undefined,
        operators: undefined,
        cardType: undefined,
        cardState: undefined,
        cardTitFlow: undefined,
        cardUsedFlow: undefined,
        cardHaveFlow: undefined,
        cardActiDate: undefined,
        cardTimeout: undefined,
        cardRemind: undefined,
        cardBatchnum: undefined,
        cardAuthState: undefined,
        cardLable: undefined,
        cardNote: undefined,
        cardUserid: undefined,
        cardUserName: undefined,
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
      this.ids = selection.map(item => item.flowCardId)
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
      const updateId = row.flowCardId || this.ids
      getFlow(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.flowCardId !== undefined) {
            updateFlow(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addFlow(this.form).then(response => {
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
      const deletedId = row.flowCardId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteFlow(deletedId.toString())
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
