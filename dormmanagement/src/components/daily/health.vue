<template>
  <div>
    <el-input v-model="inputRoomNum" placeholder="请输入宿舍号" style="width: 150px;"></el-input>
    <el-button type="primary" @click="getByRoomNum">查询</el-button>
    <el-button type="primary" @click="insertDialogVisible=true">新增</el-button>
    <hr>
     <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          fixed
          prop="scoreTime"
          label="评分时间"
          width="200">
        </el-table-column>
        <el-table-column
          prop="roomNum"
          label="宿舍号"
          width="200">
        </el-table-column>
        <el-table-column
          prop="grade"
          label="分数"
          width="200">
        </el-table-column>
        <el-table-column
          prop="type"
          label="类型"
          width="200">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="getById(scope.row)" type="text" size="small">查看</el-button>
            <el-button @click="editDialog(scope.row)" type="text" size="small">编辑</el-button>
            <el-button @click="deleteDialog(scope.row)" type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 新增弹窗 -->
      <el-dialog title="新增卫生评分" :visible.sync="insertDialogVisible">
        <el-form :model="insertForm">
          <el-form-item label="宿舍号" :label-width="formLabelWidth">
            <el-input v-model="insertForm.roomNum" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="分数" :label-width="formLabelWidth">
            <el-input v-model="insertForm.grade" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="类型" :label-width="formLabelWidth">
            <el-input v-model="insertForm.scoreType" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="insertDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="insert">确 定</el-button>
        </div>
      </el-dialog>
      <!-- 详情弹窗 -->
      <el-dialog title="卫生评分详情" :visible.sync="detailDialogVisible">
        <el-form :model="detailData">
          <el-form-item label="宿舍号" :label-width="formLabelWidth">
            {{detailData.roomNum}}
          </el-form-item>
          <el-form-item label="分数" :label-width="formLabelWidth">
            {{detailData.grade}}
          </el-form-item>
          <el-form-item label="类型" :label-width="formLabelWidth">
            {{detailData.scoreType}}
          </el-form-item>
          <el-form-item label="录入(修改)时间" :label-width="formLabelWidth">
            {{detailData.scoreTime}}
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="detailDialogVisible = false">确 定</el-button>
        </div>
      </el-dialog>
      <!-- 编辑弹窗 -->
      <el-dialog title="编辑卫生评分" :visible.sync="editDialogVisible">
        <el-form :model="insertForm">
          <el-form-item label="宿舍号" :label-width="formLabelWidth">
            <el-input v-model="detailData.roomNum" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="分数" :label-width="formLabelWidth">
            <el-input v-model="detailData.grade" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="类型" :label-width="formLabelWidth">
            <el-input v-model="detailData.scoreType" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="edit">确 定</el-button>
        </div>
      </el-dialog>
      <!-- 删除弹窗 -->
      <el-dialog
        title="提示"
        :visible.sync="deleteDialogVisible"
        width="30%">
        <span>确认删除吗？</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="deleteDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="deleteHealth">确 定</el-button>
        </span>
      </el-dialog>
  </div>
</template>

<script>
  function time(time = +new Date()) {
      var date = new Date(time + 8 * 3600 * 1000); // 增加8小时
      return date.toJSON().substr(0, 19).replace('T', ' ');
  }
  import $ from 'jquery';
  export default{
    name:'health',
    data(){
      return{
        formLabelWidth:'150px',
        insertDialogVisible:false,
        detailDialogVisible:false,
        editDialogVisible:false,
        deleteDialogVisible:false,
        inputRoomNum:'',
        tableData:[],
        detailData:{},
        insertForm:{
          roomNum:'',
          grade:'',
          type:'',
          scoreTime:''
        }
      }
    },
    methods:{
      getByRoomNum(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/health/getByRoomNum',
          type:'post',
          dataType:'json',
          data:{
            roomNum:_this.inputRoomNum
          },
          success:function(data){
            console.log(data);
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true,
            })
             _this.tableData = data.data;
          }
        })
      },
      editDialog(row){
        this.detailData=row;
        this.editDialogVisible=true;
      },
      deleteDialog(row){
        this.detailData=row;
        this.deleteDialogVisible=true;
      },
      deleteHealth(){
        var timeNum = Number(this.detailData.scoreTime);
        this.detailData.scoreTime=timeNum;
        var _this = this;
        $.ajax({
          url:'http://localhost:8088/health/delete',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data:JSON.stringify(_this.detailData),
          dataType:'json',
          success: function(data){
            console.log(data);
            _this.$message({
              message:data.message,
              type:'success'
            })
            _this.deleteDialogVisible=false;
            _this.getAll();

          }
        })
      },
      edit(){
        var _this = this;
        var timeNum = Number(this.detailData.scoreTime);
        this.detailData.scoreTime=timeNum;
        $.ajax({
          url:'http://localhost:8088/health/update',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data:JSON.stringify(_this.detailData),
          dataType:'json',
          success: function(data){
            if(data.success=false){
              _this.$message({
                message:data.message,
                type:'warning',
                showClose:true
              })
            }else{
              _this.$message({
                message:data.message,
                type:'success',
                showClose:true
              })
            }
            console.log(data);
            _this.editDialogVisible=false;
            _this.getAll();
          }
        }),
        _this.updateNoticeVisible="false";
      },
      getById(row) {
        console.log(row);
        this.detailData=row;
        this.detailDialogVisible=true;
      },
      getAll(){
        var _this = this;
        $.ajax({
          url:'http://localhost:8088/health/getAll',
          type:'post',
          success: function(data){
            console.log(data);
            for(let i=0;i<data.data.length;i++){
              data.data[i].scoreTime=time(data.data[i].scoreTime);
            }
             _this.tableData=data.data;
          }
        });
      },
      insert(){
        var _this = this;
        $.ajax({
          url:'http://localhost:8088/health/insert',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data:JSON.stringify(_this.insertForm),
          dataType:'json',
          success: function(data){
            console.log(data);
            _this.insertDialogVisible=false;
            _this.getAll();
          }
        })
      },

    },
    mounted() {
      this.getAll();
    },
    create() {

    },
  }
</script>

<style>
</style>
