<template>
  <div>
    <el-button type="primary" v-for="(item,index) in colleges" :key="index" @click="delDialog(item)">{{item.college}}</el-button>
    <el-button type="infor" @click="insertDialogVisible=true">新增学院</el-button>
    <!-- 新增学院信息 -->
    <el-dialog title="新增学院" :visible.sync="insertDialogVisible">
      <el-form :model="insertForm">
        <el-form-item label="学院名称">
          <el-input v-model="insertForm.college" autocomplete="off" style="width: 80%;" placeholder="请输入学院名称"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="insertDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 删除学院信息 -->
    <el-dialog title="删除学院信息" :visible.sync="deleteDialogVisible">
     <span>是否删除{{selectCollege.college}}的学院信息?</span>
      <div slot="footer" class="dialog-footer">
        <el-button @click="deleteDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="del">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import $ from 'jquery';
  export default{
    name:'college',
    data(){
      return{
        selectCollege:{},
        deleteDialogVisible:false,
        insertDialogVisible:false,
        colleges:[],
        insertForm:{
          college:''
        }
      }
    },
    methods:{
      delDialog(item){
        this.selectCollege=item;
        this.deleteDialogVisible=true;
      },
      del(){
        var _this =this;
        $.ajax({
          url:'http://localhost:8088/college/delete',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.selectCollege),
          dataType:'json',
          success:function(data){
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
            })
          }
        })
        this.getAll();
        this.deleteDialogVisible=false;
      },
      getAll(){
        var _this = this;
        $.ajax({
          url:'http://localhost:8088/college/getAll',
          type:'post',
          dataType:'json',
          success:function(data){
            _this.colleges=data.data;
            // _this.$message({
            //   message:data.message,
            //   type:'success',
            //   showClose:true
            // })
          }
        })
      },
      insert(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/college/insert',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.insertForm),
          dataType:'json',
          success:function(data){
            console.log(data);
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
            })

          }
        })
        _this.getAll();
        _this.insertDialogVisible=false;
      }
    },
    mounted() {
      this.getAll();
    }
  }
</script>

<style>
</style>
