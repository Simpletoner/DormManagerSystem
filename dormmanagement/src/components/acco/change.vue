<template>
  <div>
    <el-input v-model="stuNum" placeholder="请输入学号" style="width: 150px;"></el-input>
    <el-button type="primary" @click="getStuInfo">查询</el-button>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="55">
      </el-table-column>
      <el-table-column
        prop="stuName"
        label="姓名"
        width="120">
      </el-table-column>
      <el-table-column
        prop="stuNum"
        label="学号"
        width="120">
      </el-table-column>
      <el-table-column
        prop="stuGender"
        label="性别"
        width="120">
      </el-table-column>
      <el-table-column
        prop="stuRoom"
        label="房间号"
        width="120">
      </el-table-column>
      <el-table-column
        prop="stuClass"
        label="班级"
        width="120">
      </el-table-column>
      <el-table-column
        prop="stuTel"
        label="联系方式"
        width="120">
      </el-table-column>
      <el-table-column
        label="操作"
        width="120">
        <template slot-scope="scope">
          <el-button @click="change(scope.row)" type="text" size="small">调换宿舍</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 换宿弹窗 -->
    <el-dialog title="请选择宿舍" :visible.sync="changeDialogVisible" width="80%">
      <el-table
         :data="dialogTableData"
         border
         style="width: 100%">
         <el-table-column
           fixed
           prop="roomNum"
           label="房间号"
           width="130">
         </el-table-column>
         <el-table-column
           prop="rooomGender"
           label="性别"
           width="130">
         </el-table-column>
         <el-table-column
           prop="dormNum"
           label="房间号"
           width="130">
         </el-table-column>
         <el-table-column
           prop="bedsNum"
           label="房间人数"
           width="130">
         </el-table-column>
         <el-table-column
           prop="checkedInNum"
           label="入住人数"
           width="130">
         </el-table-column>
         <el-table-column
           prop="toward"
           label="朝向"
           width="130">
         </el-table-column>
         <el-table-column
           fixed="right"
           label="操作"
           width="">
           <template slot-scope="scope">
             <el-button @click="getRoomInfo(scope.row)" type="text" size="small">查看</el-button>
             <el-button @click="changeRoom(scope.row)" type="text" size="small">入住</el-button>
           </template>
         </el-table-column>
       </el-table>
    </el-dialog>
  </div>
</template>

<script>
  import $ from 'jquery'
  export default{
    name:'change',
    data(){
      return{
        tableData:[],
        multipleSelection:[],
        stuNum:'',
        selectStu:{},
        selectRoom:{},
        changeDialogVisible:'',
        dialogTableData:[]
      }
    },
    methods:{
      getStuInfo(){

      },
      getStudent(row){

      },
      change(row){
        var _this = this;
        _this.selectStu = row;
          $.ajax({
            url:'http://localhost:8088/sys/getNotFullRoom',
            type:'post',
            dataType:'json',
            data:{
              stuNum:_this.selectStu.stuNum
            },
            success:function(data){
              console.log(data);
              _this.dialogTableData=data.data;
            }
          })
        _this.changeDialogVisible=true;

      },
      changeRoom(row){
        console.log(row)
        var _this = this;
        this.selectRoom=row;
        $.ajax({
          url:'http://localhost:8088/sys/change',
          type:'post',
          dataType:'json',
          data:{
            stuNum:_this.selectStu.stuNum,
            roomNum:_this.selectRoom.roomNum
          },
          success:function(data){
            _this.changeDialogVisible=false;
            _this.getAll();
            console.log(data);
            _this.$message({
              message:data.message,
              type:"success",
              showClose:true
            })
          }
        })
      },
      getAll(){
        var _this = this;
        $.ajax({
          url:'http://localhost:8088/sys/getInDorm',
          type: 'post',
          success: function(data){
            _this.tableData=data.data;
            console.log(data);
            _this.$message({
              message: data.message,
              type: "success",
              showClose:true
            });
          }
        })
      },
      handleSelectionChange(val) {
        this.multipleSelection = val;
      }
    },
    mounted() {
    this.getAll();
    },
    created() {
      this.changeDialogVisible=false;
    }

  }
</script>

<style>
</style>
