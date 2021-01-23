<template>
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="20" :xs="24">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
          <el-form-item label="用户id" prop="rnUId">
            <el-input
              v-model="queryParams.rnUId"
              placeholder="请输入用户id"
              clearable
              size="small"
              style="width: 240px"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>

          <el-form-item label="身份证号码" prop="rmIdCard">
            <el-input
              v-model="queryParams.rmIdCard"
              placeholder="请输入身份证号码"
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
          <!--<el-col :span="1.5">
            <el-button
              type="primary"
              icon="el-icon-plus"
              size="mini"
              @click="handleAdd"
            >新增
            </el-button>
          </el-col>-->
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

        <el-table v-loading="loading" :data="nameList" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="50" align="center"/>


          <el-table-column label="实名认证id" align="center" prop="rnId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="用户id" align="center" prop="rnUId"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="姓名" align="center" prop="rnName"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="性别" align="center" prop="rnSex"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="出生日期" align="center" prop="rmBornDate"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="身份证号码" align="center" prop="rmIdCard"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="签发机构" align="center" prop="rmMechanism"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="签发日期" align="center" prop="rmIssueDate"
                           :show-overflow-tooltip="true"/>

          <el-table-column label="到期时间" align="center" prop="rmMaturityDate"
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
    <el-dialog :title="title" :visible.sync="open" width="650px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-col :span="12">
          <el-form-item label="姓名" prop="rnName">
            <el-input v-model="form.rnName" placeholder="请输入姓名"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="性别" prop="rnSex">
            <el-select v-model="form.rnSex" placeholder="请选择">
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
          <el-form-item label="出生日期" prop="rmBornDate">
            <!--<el-input v-model="form.rmBornDate" placeholder="请输入出生日期"/>-->
            <template>
              <el-date-picker
                v-model="form.rmBornDate"
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </template>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="身份证号码" prop="rmIdCard">
            <el-input v-model="form.rmIdCard" placeholder="请输入身份证号码"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="身份证正面" prop="rmPositive">
            <el-input v-model="form.rmPositive" placeholder="请输入身份证正面"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="身份证反面" prop="rmNegative">
            <el-input v-model="form.rmNegative" placeholder="请输入身份证反面"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="签发机构" prop="rmMechanism">
            <el-input v-model="form.rmMechanism" placeholder="请输入签发机构"/>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="签发日期" prop="rmIssueDate">
            <!--<el-input v-model="form.rmIssueDate" placeholder="请输入签发日期"/>-->
            <template>
              <el-date-picker
                v-model="form.rmIssueDate"
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd">
              </el-date-picker>
            </template>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="到期时间" prop="rmMaturityDate">
            <!--<el-input v-model="form.rmMaturityDate" placeholder="请输入到期时间"/>-->
            <template>
              <el-date-picker
                v-model="form.rmMaturityDate"
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
  listName,
  getName,
  updateName,
  addName,
  deleteName
} from '@/api/system/realname'

import '@riophae/vue-treeselect/dist/vue-treeselect.css'

export default {
  name: 'Realname',
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
      nameList: null,
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
        rnId: undefined,
        rnUId: undefined,
        rnName: undefined,
        rnSex: undefined,
        rmBornDate: undefined,
        rmIdCard: undefined,
        rmPositive: undefined,
        rmNegative: undefined,
        rmMechanism: undefined,
        rmIssueDate: undefined,
        rmMaturityDate: undefined,
        vsersion: undefined,
        deleted: undefined,
        createTime: undefined,
        updateTime: undefined
      },
      // 表单校验
      rules: {
        rnId: [
          { required: true, message: '实名认证id不能为空', trigger: 'blur' }
        ],
        rnUId: [
          { required: true, message: '用户id不能为空', trigger: 'blur' }
        ],
        rnName: [
          { required: true, message: '姓名不能为空', trigger: 'blur' }
        ],
        rnSex: [
          { required: true, message: '性别不能为空', trigger: 'blur' }
        ],
        rmBornDate: [
          { required: true, message: '出生日期不能为空', trigger: 'blur' }
        ],
        rmIdCard: [
          { required: true, message: '身份证号码不能为空', trigger: 'blur' }
        ],
        rmPositive: [
          { required: true, message: '身份证正面不能为空', trigger: 'blur' }
        ],
        rmNegative: [
          { required: true, message: '身份证反面不能为空', trigger: 'blur' }
        ],
        rmMechanism: [
          { required: true, message: '签发机构不能为空', trigger: 'blur' }
        ],
        rmIssueDate: [
          { required: true, message: '签发日期不能为空', trigger: 'blur' }
        ],
        rmMaturityDate: [
          { required: true, message: '到期时间不能为空', trigger: 'blur' }
        ],
        vsersion: [
          { required: true, message: '乐观锁不能为空', trigger: 'blur' }
        ],
        deleted: [
          { required: true, message: '逻辑删除不能为空', trigger: 'blur' }
        ],
        createTime: [
          { required: true, message: '创建时间不能为空', trigger: 'blur' }
        ],
        updateTime: [
          { required: true, message: '修改时间不能为空', trigger: 'blur' }
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
      listName(this.queryParams).then(response => {
          this.nameList = response.data.records
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
        rnId: undefined,
        rnUId: undefined,
        rnName: undefined,
        rnSex: undefined,
        rmBornDate: undefined,
        rmIdCard: undefined,
        rmPositive: undefined,
        rmNegative: undefined,
        rmMechanism: undefined,
        rmIssueDate: undefined,
        rmMaturityDate: undefined,
        vsersion: undefined,
        deleted: undefined,
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
      this.ids = selection.map(item => item.rnId)
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
      const updateId = row.rnId || this.ids
      getName(updateId.toString()).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改用户'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.rnId !== undefined) {
            updateName(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addName(this.form).then(response => {
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
      const deletedId = row.rnId || this.ids
      this.$confirm('是否确认删除编号为"' + deletedId + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return deleteName(deletedId.toString())
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
