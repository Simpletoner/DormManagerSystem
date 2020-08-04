<template>
  <div>
    <el-button type="success" @click="insertNoticeVisible=true">新增晚归记录</el-button>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="stuNum" label="学号" width="150">
      </el-table-column>
      <el-table-column prop="dormNum" label="楼栋号" width="150">
      </el-table-column>
      <el-table-column prop="roomNum" label="房间号" width="150">
      </el-table-column>
      <el-table-column prop="lateTime" label="晚归时间" width="150">
      </el-table-column>
      <el-table-column prop="reason" label="晚归原因" width="">
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
    <el-dialog title="新增晚归记录" :visible.sync="insertNoticeVisible">
      <el-form :model="insertForm">
        <el-form-item label="晚归时间" :label-width="formLabelWidth">
          <el-input v-model="insertForm.lateTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.roomNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="晚归原因" :label-width="formLabelWidth">
          <el-input type="textarea" placeholder="请输入内容" v-model="insertForm.reason">
          </el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="insertNoticeVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 查看详情弹窗 -->
    <el-dialog title="查看通知公告详情" :visible.sync="noticeDetailVisible">
      <el-form :model="detailData">
        <el-form-item label="晚归时间" :label-width="formLabelWidth">
          {{detailData.lateTime}}
        </el-form-item>
        <el-form-item label="学号" :label-width="formLabelWidth">
          {{detailData.stuNum}}
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          {{detailData.dormNum}}
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          {{detailData.roomNum}}
        </el-form-item>
        <el-form-item label="晚归原因" :label-width="formLabelWidth">
          {{detailData.reason}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="noticeDetailVisible = false">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 更新晚归信息 -->
    <el-dialog title="更新晚归信息" :visible.sync="updateNoticeVisible">
      <el-form :model="detailData">
        <el-form-item label="晚归时间" :label-width="formLabelWidth">
          <el-input v-model="detailData.lateTime" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学号" :label-width="formLabelWidth">
          <el-input v-model="detailData.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="detailData.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间号" :label-width="formLabelWidth">
          <el-input v-model="detailData.roomNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="晚归原因" :label-width="formLabelWidth">
          <el-input type="textarea" placeholder="请输入内容" v-model="detailData.reason">
          </el-input>
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

  export default {
    name: 'late',
    data() {
      return {
        updateNoticeVisible:false,
        noticeDetailVisible:false,
        insertNoticeVisible:false,
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
          url: 'http://localhost:8088/late/getAll',
          type: 'post',
          success: function(data) {
            _this.tableData = data.data;
          }
        });
      },
      insert() {
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/late/insert',
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
        $.ajax({
            url: 'http://localhost:8088/late/update',
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
        var timeNum = Number(this.detailData.noticeCreateTime);
        this.detailData.noticeCreateTime = timeNum;
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/late/delete',
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
