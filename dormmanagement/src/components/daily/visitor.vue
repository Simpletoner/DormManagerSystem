<template>
  <div>
    <el-button type="success" @click="insertNoticeVisible=true">新增访客记录</el-button>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="visitorName" label="访客姓名" width="120">
      </el-table-column>
      <el-table-column prop="relationship" label="与被访问者关系" width="120">
      </el-table-column>
      <el-table-column prop="reason" label="访问理由" width="120">
      </el-table-column>
      <el-table-column prop="stuNum" label="被访问学生学号" width="120">
      </el-table-column>
      <el-table-column prop="visitDate" label="访问时间" width="120">
      </el-table-column>
      <el-table-column prop="leaveDate" label="离开时间" width="120">
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
    <el-dialog title="新增访客记录" :visible.sync="insertNoticeVisible">
      <el-form :model="insertForm">
        <el-form-item label="访客姓名" :label-width="formLabelWidth">
          <el-input v-model="insertForm.visitorName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="与被访问者关系" :label-width="formLabelWidth">
          <el-input v-model="insertForm.relationship" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="访问理由" :label-width="formLabelWidth">
          <el-input v-model="insertForm.reason" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="被访问学生学号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.roomNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="来访时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="insertForm.visitDate"
                type="datetime"
                placeholder="选择来访时间"
                align="right"
                :picker-options="pickerOptions">
              </el-date-picker>
        </el-form-item>
        <el-form-item label="离开时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="insertForm.leaveDate"
                type="datetime"
                placeholder="选择离开时间"
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
        <el-form-item label="访客姓名" :label-width="formLabelWidth">
         {{detailData.visitorName}}
        </el-form-item>
        <el-form-item label="与被访问者关系" :label-width="formLabelWidth">
          {{detailData.relationship}}
        </el-form-item>
        <el-form-item label="访问理由" :label-width="formLabelWidth">
          {{detailData.reason}}
        </el-form-item>
        <el-form-item label="被访问学生学号" :label-width="formLabelWidth">
          {{detailData.stuNum}}
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          {{detailData.dormNum}}
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          {{detailData.roomNum}}
        </el-form-item>
        <el-form-item label="来访时间" :label-width="formLabelWidth">
           {{detailData.visitDate}}
        </el-form-item>
        <el-form-item label="离开时间" :label-width="formLabelWidth">
           {{detailData.leaveDate}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="noticeDetailVisible = false">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 更新通知弹窗 -->
    <el-dialog title="更新通知公告" :visible.sync="updateNoticeVisible">
      <el-form :model="detailData">
        <el-form-item label="访客姓名" :label-width="formLabelWidth">
          <el-input v-model="detailData.visitorName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="与被访问者关系" :label-width="formLabelWidth">
          <el-input v-model="detailData.relationship" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="访问理由" :label-width="formLabelWidth">
          <el-input v-model="detailData.reason" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="被访问学生学号" :label-width="formLabelWidth">
          <el-input v-model="detailData.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="detailData.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          <el-input v-model="detailData.roomNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="来访时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="detailData.visitDate"
                type="datetime"
                placeholder="选择来访时间"
                align="right"
                :picker-options="pickerOptions">
              </el-date-picker>
        </el-form-item>
        <el-form-item label="离开时间" :label-width="formLabelWidth">
           <el-date-picker
                v-model="detailData.leaveDate"
                type="datetime"
                placeholder="选择离开时间"
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
    name: 'visitor',
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
          url: 'http://localhost:8088/visitor/getAll',
          type: 'post',
          success: function(data) {
            console.log(data);
            for (let i = 0; i < data.data.length; i++) {
              data.data[i].visitDate = time(data.data[i].visitDate);
              data.data[i].leaveDate = time(data.data[i].leaveDate);
            }
            _this.tableData = data.data;
          }
        });
      },
      insert() {
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/visitor/insert',
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
        var timeNum = Number(this.detailData.noticeCreateTime);
        this.detailData.noticeCreateTime = timeNum;
        $.ajax({
            url: 'http://localhost:8088/visitor/update',
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
        this.detailData.visitDate =Number(this.detailData.visitDate);
        this.detailData.leaveDate = Number(this.detailData.leaveDate);
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/visitor/delete',
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
