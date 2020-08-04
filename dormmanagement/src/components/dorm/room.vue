<template>
  <div>
    <el-input v-model="dormNum" placeholder="请输入楼栋号" style="width: 150px;"></el-input>
    <el-button type='success' @click="getByDormNum">查询</el-button>
    <el-table
          :data="roomList"
          border
          style="width: 100%">
          <el-table-column
            fixed
            prop="roomNum"
            label="房间号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="roomGender"
            label="性别"
            width="150">
          </el-table-column>
          <el-table-column
            prop="dormNum"
            label="房间号"
            width="150">
          </el-table-column>
          <el-table-column
            prop="bedsNum"
            label="房间人数"
            width="150">
          </el-table-column>
          <el-table-column
            prop="checkedInNum"
            label="入住人数"
            width="150">
          </el-table-column>
          <el-table-column
            prop="toward"
            label="朝向"
            width="150">
          </el-table-column>
          <el-table-column
            fixed="right"
            label="操作"
            width="">
            <template slot-scope="scope">
              <el-button @click="getRoomInfo(scope.row)" type="text" size="small">查看</el-button>
              <el-button @click="deleteRoom(scope.row)" type="text" size="small">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <!-- 查看详情弹窗 -->
        <el-dialog title="房间信息详情" :visible.sync="detailDialogVisible">
          <el-form :model="detailForm">
            <el-form-item label="房间号" :label-width="formLabelWidth">
              {{detailForm.roomNum}}
            </el-form-item>
            <el-form-item label="居住性别" :label-width="formLabelWidth">
              {{detailForm.roomGender}}
            </el-form-item>
            <el-form-item label="楼栋号" :label-width="formLabelWidth">
              {{detailForm.dormNum}}
            </el-form-item>
            <el-form-item label="床位数量" :label-width="formLabelWidth">
              {{detailForm.bedsNum}}
            </el-form-item>
            <el-form-item label="入住人数" :label-width="formLabelWidth">
              {{detailForm.checkedInNum}}
            </el-form-item>
            <el-form-item label="朝向" :label-width="formLabelWidth">
              {{detailForm.toward}}
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="detailDialogVisible = false">确 定</el-button>
          </div>
        </el-dialog>
        <!-- 确认删除弹窗 -->
        <el-dialog title="确认删除" :visible.sync="deleteDialogVisible">
          <span>确认删除该房间信息？</span>
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
    name:'room',
    data(){
      return{
        deleteDialogVisible:false,
        detailDialogVisible:false,
        detailForm:{},
        dormNum:'',
        roomList:[],

      }
    },
    methods:{
      deleteRoom(row){
        this.detailForm=row;
        this.deleteDialogVisible=true;
      },
      del(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/room/delete',
          type:'post',
          contentType: "application/json; charset=utf-8",
          data: JSON.stringify(_this.detailForm),
          success:function(data){
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
            })
          }
        });
        _this.deleteDialogVisible=false;
        _this.getAll();
      },
      getRoomInfo(row){
        this.detailForm=row;
        this.detailDialogVisible=true;
      },
      getByDormNum(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/room/getByDormNum',
          type:'post',
          dataType:'json',
          data:{
            dormNum:_this.dormNum
          },
          success:function(data){
            _this.roomList=data.data;
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
            })
          }
        })
      },
      getAll(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/room/getAll',
          type:'post',
          success:function(data){
            _this.roomList=data.data;
            console.log(data)
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
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
