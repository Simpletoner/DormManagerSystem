<template>
  <div>
    <el-input v-model="inputClass" placeholder="请输入班级名称" style="width: 150px;"></el-input>
    <el-button type="primary" @click="getByClass">查询</el-button>
    <el-button type="primary" @click="insertDialogVisible=true">新增</el-button>
    <el-button type="primary" @click="deleteStudents">删除所选学生信息</el-button>
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
          <el-button @click="detailDialog(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="updateDialog(scope.row)" type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 新增学生弹窗 -->
    <el-dialog title="新建学生信息" :visible.sync="insertDialogVisible">
      <el-form :model="insertForm">
        <el-form-item label="学生姓名:" :label-width="formLabelWidth">
          <el-input v-model="insertForm.stuName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学号:" :label-width="formLabelWidth">
          <el-input v-model="insertForm.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别:" :label-width="formLabelWidth">
          <el-select v-model="insertForm.stuGender" placeholder="请选择性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学院:" :label-width="formLabelWidth">
          <el-select v-model="insertForm.stuCollege" placeholder="请选择学院">
            <el-option v-for="(item,index) in colleges" :key="index" :label="item.college" :value="item.college"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="班级:" :label-width="formLabelWidth">
          <el-input v-model="insertForm.stuClass" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="insertDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 学生详情弹窗 -->
    <el-dialog title="学生信息详情" :visible.sync="detailDialogVisible">
      <el-form :model="detailData">
        <el-form-item label="学生姓名:" :label-width="formLabelWidth">
         {{detailData.stuNum}}
        </el-form-item>
        <el-form-item label="学号:" :label-width="formLabelWidth">
          {{detailData.stuNum}}
        </el-form-item>
        <el-form-item label="性别:" :label-width="formLabelWidth">
          {{detailData.stuGender}}
        </el-form-item>
        <el-form-item label="学院:" :label-width="formLabelWidth">
          {{detailData.stuCollege}}
        </el-form-item>
        <el-form-item label="班级:" :label-width="formLabelWidth">
          {{detailData.stuClass}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="detailDialogVisible = false">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 修改学生信息弹窗 -->
    <el-dialog title="修改学生信息" :visible.sync="updateDialogVisible">
      <el-form :model="detailData">
        <el-form-item label="学生姓名:" :label-width="formLabelWidth">
          <el-input v-model="detailData.stuName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="学号:" :label-width="formLabelWidth">
          <el-input v-model="detailData.stuNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别:" :label-width="formLabelWidth">
          <el-select v-model="detailData.stuGender" placeholder="请选择性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学院:" :label-width="formLabelWidth">
          <el-select v-model="detailData.stuCollege" placeholder="请选择学院">
            <el-option v-for="(item,index) in colleges" :key="index" :label="item.college" :value="item.college"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="班级:" :label-width="formLabelWidth">
          <el-input v-model="detailData.stuClass" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="updateDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="update">确 定</el-button>
      </div>
    </el-dialog>
    </div>
  </div>
</template>

<script>
  import $ from 'jquery'
  export default{
    name:'student',
    data(){
      return{
        inputClass:'',
        multipleSelection:[],
        tableData:[],
        colleges:[],
        updateDialogVisible:false,
        insertDialogVisible:false,
        formLabelWidth:"150px",
        insertForm:{},
        detailData:{},
        detailDialogVisible:false
      }
    },
    methods:{
      handleSelectionChange(val) {
        console.log(val);
        this.multipleSelection = val;
      },
      updateDialog(row){
        this.detailData=row;
        this.updateDialogVisible=true;
      },
      update(){
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/stu/update',
          type: 'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.detailData),
          dataType: 'json',
          success: function(data) {
            _this.$message({
              message:data.message,
              type:'success',
              shoeClose:'true'
            })
            console.log(data);
            _this.getAll();
            _this.updateDialogVisible = false;
          }
        })
      },
      getByClass(){
        var _this =this;
        $.ajax({
          url:'http://localhost:8088/stu/getByClass',
          type:'post',
          dataType:'json',
          data:{
            stuClass:_this.inputClass,
          },
          success:function(data){
            _this.tableData=data.data;
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
        var _this =this;
        $.ajax({
          url:'http://localhost:8088/stu/getAll',
          type:'post',
          dataType:'json',
          success:function(data){
            _this.tableData=data.data;
            console.log(data);
            _this.$message({
              message:data.message,
              type:"success",
              showClose:true
            })
          }
        });
        $.ajax({
          url:'http://localhost:8088/college/getAll',
          type:'post',
          dataType:'json',
          success:function(data){
            _this.colleges=data.data;
            console.log(data);
          }
        })
      },
      insert(){
        var _this = this;
        $.ajax({
          url: 'http://localhost:8088/stu/insert',
          type: 'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.insertForm),
          dataType: 'json',
          success: function(data) {
            _this.$message({
              message:data.message,
              type:'success',
              shoeClose:'true'
            })
            console.log(data);
            _this.getAll();
            _this.insertDialogVisible = false;
          }
        })
      },
      detailDialog(row){
        this.detailData=row;
        this.detailDialogVisible=true;
      },
      deleteStudents(){
        var _this=this;
        var num=0;
        for(let i=0;i<_this.multipleSelection.length;i++){
          $.ajax({
            url: 'http://localhost:8088/stu/delete',
            type: 'post',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(_this.multipleSelection[i]),
            dataType: 'json',
            success: function(data) {
              if(data.success==true){
                num = num+1;
              }
              console.log(data);
            }
          })
        }
        _this.$message({
          message:"成功删除"+num+"条学生信息",
          type:'success',
          showClose:true
        })
        _this.getAll();
        _this.insertDialogVisible = false;
      }
    },
    mounted() {
      this.getAll();
    }
  }
</script>

<style>
</style>
