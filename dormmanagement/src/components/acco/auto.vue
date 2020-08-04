<template>
  <div>
    <el-button type="primary" @click="query">查询未分配宿舍学生</el-button>
    <el-button type="success" @click="autoInsert">自主分配所选学生</el-button>
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
      prop="stuCollege"
      label="学院"
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
        <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
  import $ from 'jquery'
  export default{
    name:'accoAuto',
    data() {
          return {
            tableData:[],
            multipleSelection: []
          }
        },
    methods:{
      handleSelectionChange(val) {
        this.multipleSelection = val;
      },
      getAll(){
        var _this = this;
        $.ajax({
          url:'http://localhost:8088/stu/notInDorm',
          type: 'post',
          success: function(data){
             _this.tableData = data.data;
             _this.$message({
               message:data.message,
               type:"success",
               showClose:true
             })
          }
        })
      },
      query(){
      var _this = this;
        $.ajax({
          url:'http://localhost:8088/stu/notInDorm',
          type: 'post',
          success: function(data){
             _this.tableData = data.data;
             _this.$message({
               showClose:true,
               message:data.message,
               type:"success"
             })
          }
        })
      },
      autoInsert(){
        var _this = this;
        var students=_this.multipleSelection;
        $.ajax({
          url:'http://localhost:8088/sys/autoInDorm',
          type:'post',
          dataType:'json',
          contentType:'application/json',
          data:JSON.stringify(students),
          success: function(data){
            _this.getAll();
            _this.$message({
              message:data.message,
              type:"success",
              showClose:true,
            })
          }
        })
      }
    },
    mounted() {
      this.getAll();
    }
  }
</script>

<style>
</style>
