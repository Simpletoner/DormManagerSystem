<template>
   <el-dialog title="宿舍管理员注册" :visible.sync="regDialogVisible">
     <el-form ref="regForm" :model="regForm" label-width="100px" :inline="true" :rules="rules">
       <el-form-item label="姓名:" prop="sysAdminName">
         <el-input v-model="regForm.sysAdminName"></el-input>
       </el-form-item>
       <el-form-item label="工号:" prop="sysAdminNum">
         <el-input v-model="regForm.sysAdminNum"></el-input>
       </el-form-item>
       <br>
       <el-form-item label="性别:" prop="sysAdminGender">
         <el-radio-group v-model="regForm.sysAdminGender">
           <el-radio label="男"></el-radio>
           <el-radio label="女"></el-radio>
         </el-radio-group>
       </el-form-item>
       <br>
       <el-form-item label="密码:" prop="sysAdminPwd">
         <el-input v-model="regForm.sysAdminPwd" show-password></el-input>
       </el-form-item>
       <el-form-item label="确认密码:" prop="reSysAdminPwd">
         <el-input v-model="regForm.reSysAdminPwd" show-password></el-input>
       </el-form-item>
       <el-form-item label="联系方式:" prop="sysAdminTel">
         <el-input v-model="regForm.sysAdminTel"></el-input>
       </el-form-item>
       <el-form-item label="邮箱:" prop="sysAdminEmail">
         <el-input v-model="regForm.sysAdminEmail"></el-input>
       </el-form-item>
     </el-form>
     <div slot="footer" class="dialog-footer">
       <el-button @click="regDialogVisible = false">取 消</el-button>
       <el-button type="primary" @click="reg('regForm')" >注 册</el-button>
     </div>
   </el-dialog>
</template>

<script>
  import $ from 'jquery';
  export default{
    name:'registDialog',
    data(){
      var validatePwd2 = (rule,value,callback)=>{
         if (value === '') {
            callback(new Error('请再次输入密码'))
          } else if (value !== this.regForm.sysAdminPwd) {
            callback(new Error('两次输入密码不一致!'))
          } else {
            callback()
          }
      }
      return{
        regForm:{
          sysAdminName:'',
          sysAdminNum:'',
          sysAdminGender:'',
          sysAdminPwd:'',
          reSysAdminPwd:'',
          sysAdminTel:'',
          sysAdminEmail:''
        },
        regDialogVisible:false,
        rules: {
          sysAdminName:[
            { required: true, message: '请输入姓名', trigger: 'blur' }
          ],
          sysAdminNum:[
              { required: true, message: '请输入用户名', trigger: 'blur' }
          ],
          sysAdminPwd:[
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' }
          ],
          reSysAdminPwd:[
            {required: true, validator: validatePwd2, trigger: 'blur'}
          ],
          sysAdminGender:[
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          sysAdminTel:[
            { required: true, message: '请输入联系方式', trigger: 'blur' },
            { min: 11, max: 11, message: '请输入11位正确的电话号码', trigger: 'blur' }
          ],
          sysAdminEmail:[
            { required: true, message: '请输入邮箱', trigger: 'blur' }
          ]
      }
    }
  },
  methods:{
    reg(regForm){
      var _this = this;
      _this.$refs[regForm].validate((valid)=>{
        if(valid){
          $.ajax({
            url:'http://localhost:8088/sys/sysRegist',
            type: "post",
            data: _this.regForm,
            success: function(data){
              console.log(data);
              if(data == false){
                _this.$message({
                  showClose:true,
                  message: "注册失败",
                  type: "warning"
                })
              }else{
                _this.regDialogVisible=false;
                _this.$message({
                  showClose:true,
                  message:"注册成功",
                  type: "success"
                })
              }
            }
          })
        }
      })

    },
    changeShow(isChange){
      this.regDialogVisible = isChange;
    }
  }
}
</script>

<style>
</style>
