<template>
  <div>
    <el-button type="success" @click="insertNoticeVisible=true">新增报修记录</el-button>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="stuNum" label="报修人" width="120">
      </el-table-column>
      <el-table-column prop="applyTime" label="申请时间" width="120">
      </el-table-column>
      <el-table-column prop="repairTime" label="报修时间" width="120">
      </el-table-column>
      <el-table-column prop="type" label="报修类型" width="120">
      </el-table-column>
      <el-table-column prop="repairStaff" label="维修工工号" width="120">
      </el-table-column>
      <el-table-column prop="state" label="维修状态" width="120">
      </el-table-column>
      <el-table-column label="操作" width="220">
        <template slot-scope="scope">
          <el-button @click="getNotice(scope.row)" type="text" size="small">查看详情</el-button>
          <el-button @click="updateNotice(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteNotice(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 新增通知弹窗 -->
    <el-dialog title="新增报修记录" :visible.sync="insertNoticeVisible">
      <el-form :model="insertForm">
        <el-form-item label="报修人学号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.roomNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="报修类型" :label-width="formLabelWidth">
          <el-input v-model="insertForm.type" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="维修工编号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.repairStaff" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="申请时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="insertForm.applyTime"
                type="datetime"
                placeholder="选择申请时间"
                align="right"
                :picker-options="pickerOptions">
              </el-date-picker>
        </el-form-item>
        <el-form-item label="维修时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="insertForm.repairTime"
                type="datetime"
                placeholder="选择维修时间时间"
                align="right"
                :picker-options="pickerOptions">
              </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="insertNoticeVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 查看详情弹窗 -->
    <el-dialog title="查看访客信息详情" :visible.sync="noticeDetailVisible">
      <el-form :model="detailData">
        <el-form-item label="报修人学号" :label-width="formLabelWidth">
          {{detailData.stuNum}}
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          {{detailData.dormNum}}
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          {{detailData.roomNum}}
        </el-form-item>
        <el-form-item label="报修类型" :label-width="formLabelWidth">
          {{detailData.type}}
        </el-form-item>
        <el-form-item label="维修工编号" :label-width="formLabelWidth">
          {{detailData.repairStaff}}
        </el-form-item>
        <el-form-item label="申请时间" :label-width="formLabelWidth">
          {{detailData.applyTime}}
        </el-form-item>
        <el-form-item label="维修时间" :label-width="formLabelWidth">
          {{detailData.repairTime}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="noticeDetailVisible = false">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 更新通知弹窗 -->
    <el-dialog title="更新通知公告" :visible.sync="updateNoticeVisible">
      <el-form :model="detailData">
        <el-form-item label="报修人学号" :label-width="formLabelWidth">
          <el-input v-model="detailData.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="detailData.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          <el-input v-model="detailData.roomNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="报修类型" :label-width="formLabelWidth">
          <el-input v-model="detailData.type" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="维修工编号" :label-width="formLabelWidth">
          <el-input v-model="detailData.repairStaff" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="申请时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="detailData.applyTime"
                type="datetime"
                placeholder="选择申请时间"
                align="right"
                :picker-options="pickerOptions">
              </el-date-picker>
        </el-form-item>
        <el-form-item label="维修时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="detailData.repairTime"
                type="datetime"
                placeholder="选择维修时间时间"
                align="right"
                :picker-options="pickerOptions">
              </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateNoticeVisible = false">取 消</el-button>
        <el-button type="primary" @click="update">确 定</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
  import $ from 'jquery'
  function time(time = +new Date()) {
    var date = new Date(time + 8 * 3600 * 1000); // 增加8小时
    return date.toJSON().substr(0, 19).replace('T', ' ');
  }
  export default {
    name: 'repair',
    data() {
      return {
         pickerOptions: {
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        updateNoticeVisible:false,
        noticeDetailVisible: false,
        insertNoticeVisible: false,
        tableData: [],
        detailData: {},
        insertForm: {
          noticeTitle: '',
          noticeContent: '',
          noticePublisher: ''
        }
      }
    },
    methods: {

      getAll() {
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/rep/getAll',
          type: 'post',
          success: function(data) {
            console.log(data);
            for (let i = 0; i < data.data.length; i++) {
              data.data[i].applyTime = time(data.data[i].applyTime);
              data.data[i].repairTime = time(data.data[i].repairTime);
            }
            _this.tableData = data.data;
          }
        });
      },
      insert() {
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/rep/insert',
          type: 'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.insertForm),
          dataType: 'json',
          success: function(data) {
            console.log(data);
            _this.getAll();
            _this.insertNoticeVisible = false;
          }
        })
      },
      getNotice(row) {
        console.log(row);
        this.detailData = row;
        this.noticeDetailVisible = true;
      },
      updateNotice(row) {
        this.detailData = row;
        this.updateNoticeVisible = true;
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      update() {
        var _this = this;
        this.detailData.applyTime = Number(this.detailData.applyTime);
        this.detailData.repairTime = Number(this.detailData.repairTime);
        $.ajax({
            url: 'http://localhost:8088/rep/update',
            type: 'post',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(_this.detailData),
            dataType: 'json',
            success: function(data) {
              console.log(data);
              _this.getAll();
            }
          }),
          _this.updateNoticeVisible = false;
      },
      deleteNotice(row) {
        this.detailData = row;
        this.detailData.applyTime =Number(this.detailData.applyTime);
        this.detailData.repairTime = Number(this.detailData.repairTime);
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/rep/delete',
          type: 'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.detailData),
          dataType: 'json',
          success: function(data) {
            console.log(data);
            _this.$message({
              message: data.message,
              type: 'success'
            })
            _this.getAll();
          }
        })
      }
    },
    mounted() {},
    created() {
      this.getAll();
    }
  }
</script>

<style>
</style>
