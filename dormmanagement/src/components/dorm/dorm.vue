<template>
  <div>
    <el-button type="primary" @click="insertFormVisible=true">新建楼栋信息</el-button>
    <el-dialog title="新增楼栋信息" :visible.sync="insertFormVisible">
      <el-form :model="insertForm">
        <el-form-item label="楼栋名称" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼栋性别" :label-width="formLabelWidth">
          <el-select v-model="insertForm.dormGender" placeholder="请选择楼栋所住性别">
            <el-option label="男" value="1"></el-option>
            <el-option label="女" value="0"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="床位数量" :label-width="formLabelWidth">
          <el-input v-model="insertForm.bedsNum" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="宿舍类型" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormType" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="房间数量" :label-width="formLabelWidth">
          <el-input v-model="insertForm.roomCount" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="楼层数" :label-width="formLabelWidth">
          <el-input v-model="insertForm.dormFloor" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="居住群体" :label-width="formLabelWidth">
          <el-select v-model="insertForm.dormGroup" placeholder="请选择居住群体">
            <el-option label="学生" value="学生"></el-option>
            <el-option label="教师" value="教师"></el-option>
            <el-option label="宿舍管理员" value="宿舍管理员"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="insertFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="insert">确 定</el-button>
      </div>
    </el-dialog>
    <dormEchars></dormEchars>
  </div>

</template>

<script>
  import $ from 'jquery';
  import dormEchars from './dormEchars.vue'
  export default{
    name:'dorm',
    data(){
      return{
        insertFormVisible:false,
        insertForm:{},

      }
    },
    methods:{
      insert(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/dorm/insert',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.insertForm),
          dataType:'json',
          success:function(data){
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
            })
            _this.insertFormVisible=false;
          }
        })
      }
    },
    components:{
      dormEchars
    }
  }
</script>

<style>
</style>
