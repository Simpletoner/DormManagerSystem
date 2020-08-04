<template>
  <div>
    <el-button type="success" @click="insertNoticeVisible=true">新增通知</el-button>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55">
      </el-table-column>
      <el-table-column prop="noticeCreateTime" label="创建时间" width="220">
      </el-table-column>
      <el-table-column prop="noticeTitle" label="通知标题" width="420">
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
    <el-dialog title="新增通知公告" :visible.sync="insertNoticeVisible">
      <el-form :model="insertForm">
        <el-form-item label="公告标题" :label-width="formLabelWidth">
          <el-input v-model="insertForm.noticeTitle" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="公告详情" :label-width="formLabelWidth">
          <el-input type="textarea" placeholder="请输入内容" v-model="insertForm.noticeContent">
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
        <el-form-item label="公告标题" :label-width="formLabelWidth">
          {{detailData.noticeTitle}}
        </el-form-item>
        <el-form-item label="公告详情" :label-width="formLabelWidth">
          {{detailData.noticeContent}}
        </el-form-item>
        <el-form-item label="公告发布时间" :label-width="formLabelWidth">
          {{detailData.noticeCreateTime}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="noticeDetailVisible = false">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 更新通知弹窗 -->
    <el-dialog title="更新通知公告" :visible.sync="updateNoticeVisible">
      <el-form :model="detailData">
        <el-form-item label="公告标题" :label-width="formLabelWidth">
          <el-input v-model="detailData.noticeTitle" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="公告详情" :label-width="formLabelWidth">
          <el-input type="textarea" placeholder="请输入内容" v-model="detailData.noticeContent">
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

  function time(time = +new Date()) {
    var date = new Date(time + 8 * 3600 * 1000); // 增加8小时
    return date.toJSON().substr(0, 19).replace('T', ' ');
  }
  export default {
    name: 'notice',
    data() {
      return {
        updateNoticeVisible: 'false',
        noticeDetailVisible: 'false',
        insertNoticeVisible: 'false',
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
          url: 'http://localhost:8088/notice/getAll',
          type: 'post',
          success: function(data) {
            console.log(data);
            for (let i = 0; i < data.data.length; i++) {
              data.data[i].noticeCreateTime = time(data.data[i].noticeCreateTime);
            }
            _this.tableData = data.data;
          }
        });
      },
      insert() {
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/notice/insertNotice',
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
            url: 'http://localhost:8088/notice/updateNotice',
            type: 'post',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(_this.detailData),
            dataType: 'json',
            success: function(data) {
              console.log(data);
              _this.getAll();
            }
          }),
          _this.updateNoticeVisible = "false";
      },
      deleteNotice(row) {
        this.detailData = row;
        var timeNum = Number(this.detailData.noticeCreateTime);
        this.detailData.noticeCreateTime = timeNum;
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/notice/delete',
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
      this.updateNoticeVisible = false;
      this.noticeDetailVisible = false;
      this.insertNoticeVisible = false;
    }
  }
</script>

<style>
</style>
