<template>
  <div>
    <div class="title">欢迎使用宿舍管理系统</div>
    <div class="lbt">
      <el-carousel :interval="5000" arrow="always">
      <el-carousel-item>
        <img src="../assets/img/main1.jpg">
      </el-carousel-item>
      <el-carousel-item>
        <img src="../assets/img/main2.jpg">
      </el-carousel-item>
      <el-carousel-item>
        <img src="../assets/img/main3.jpg">
      </el-carousel-item>
      <el-carousel-item>
        <img src="../assets/img/main4.jpg">
      </el-carousel-item>
    </el-carousel>
    </div>
    <div class="loginDiv">
      <el-row class="login">
        <el-col :span="18">
          <el-form ref="loginForm" :model="loginForm" :label-position="formLablePosition" :rules="rules"  label-width="80px">
            <el-form-item label="用户名:" prop="sysAdminNum">
              <el-input v-model="loginForm.sysAdminNum"  placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码:" prop="sysAdminPwd">
              <el-input v-model="loginForm.sysAdminPwd" show-password placeholder="请输入6-18位密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="login('loginForm')">登录</el-button>
              <el-button type="" @click="reset">重置</el-button>
              <el-button type="text" @click="regist()">还没有账号？注册一个</el-button>
            </el-form-item>
          </el-form>
        </el-col>

        <!-- 注册表单弹窗 ref控制弹窗显示 -->
        <regist-dialog ref="registForm"></regist-dialog>
      </el-row>
    </div>

  </div>



</template>
<script>
  import $ from 'jquery';
  import registDialog from './regist.vue'
  export default{
    components:{
      registDialog
    },
    data(){
      return{
        registFormVisiable: 'false',
        formLablePosition:"right",
        loginForm:{
          sysAdminNum:'',
          sysAdminPwd:''
        },
        admin:{},
        rules: {
          sysAdminNum:[
              { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          sysAdminPwd:[
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' }
          ],
        }
      }
    },
    methods:{
      login(loginForm){
        var _this = this;
        console.log(_this);
        _this.$refs[loginForm].validate((valid) =>{
          if(valid){
             $.ajax({
               url:'http://localhost:8088/sys/sysLogin',
               type: 'post',
               data: _this.loginForm,
               success: function(data){
                 console.log(data);
                 if(data.code==2){
                   _this.admin=data.data;
                   // console.log(data.data);
                   //alert(data.message);
                   _this.$message({
                     showClose:true,
                     message: data.message,
                     type: "success"
                   });
                   _this.$router.push({
                     name: 'adminMain',
                     params:{
                       admin: data.data
                     }
                   });
                 }else if(data.code!=2){
                   _this.$message({
                     showClose:true,
                     message: data.message,
                     type: "warning"
                   })
                 }
               }
             })
            // alert(this.loginForm.username+this.loginForm.password);
             //this.$router.push('adminMain');
          }else{
            alert("error");
          }
        })
      },
      reset(){
        this.loginForm.sysAdminNum = '';
        this.loginForm.sysAdminPwd = '';
      },
      regist(){
        this.$refs.registForm.changeShow(true);
      }
    }
  }
</script>

<style>
    .title{
      text-align: center;
      font-size: 30px;
      font-family: '微软雅黑';
      padding-top: 6%;
    }
    .el-carousel__item:nth-child(2n) {
      background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
      background-color: #d3dce6;
    }
    .lbt{
      width: 50%;
      float: left;
      margin-left: 5%;
      margin-top: 5%;
      box-shadow: 10px 10px 5px #888888;
    }
    .loginDiv{
      width: 35%;
      margin-top: 10%;
      margin-right: 3%;
      float: right;
      box-shadow: 10px 10px 5px #888888;
    }
    .el-carousel__item img {
      height: 100%;
      width: 100%;
    }
</style>
