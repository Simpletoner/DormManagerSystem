<template>
  <div>
    <el-input
      placeholder="请输入学号"
      prefix-icon="el-icon-search"
      v-model="stuNum"
      style="width: 20%;"
      >
    </el-input>
    <el-button type="success" @click="getRooms">查询推荐宿舍</el-button>
    <div>
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
            prop="rooomGender"
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
              <el-button @click="sureInRoom(scope.row)" type="text" size="small">入住</el-button>
            </template>
          </el-table-column>
        </el-table>
    </div>
    <!-- 查看宿舍详情弹窗 -->
    <el-dialog title="查看宿舍详情" :visible.sync="roomDetailVisible">
      <el-form :model="detailData">
        <el-form-item label="房间号" :label-width="formLabelWidth">
          {{detailData.roomNum}}
        </el-form-item>
        <el-form-item label="楼栋号" :label-width="formLabelWidth">
         {{detailData.dormNum}}
        </el-form-item>
        <el-form-item label="床位数" :label-width="formLabelWidth">
         {{detailData.bedsNum}}
        </el-form-item>
        <el-form-item label="确认入住人数" :label-width="formLabelWidth">
         {{detailData.checkedInNum}}
        </el-form-item>
        <el-form-item label="性别" :label-width="formLabelWidth">
         {{detailData.roomGender}}
        </el-form-item>
        <el-form-item label="朝向" :label-width="formLabelWidth">
         {{detailData.toward}}
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="roomDetailVisible = false">确 定</el-button>
      </div>
    </el-dialog>

    <!-- 确认入住弹窗 -->
    <el-dialog
      title="提示"
      :visible.sync="sureDialogVisiable"
      width="30%">
      <span>确认入住？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="inRoom">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
  import $ from 'jquery';
  export default{
    name:'choose',
    data(){
      return{
        sureDialogVisiable:false,
        roomDetailVisible:false,
        stuNum:'',
        roomList:[],
        detailData:{}
      }
    },
    methods:{
      getRooms(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/sys/getNotFullRoom',
          type:'post',
          dataType:'json',
          data:{
            stuNum:_this.stuNum
          },
          success:function(data){
            console.log(data);
            _this.$message({
              message:data.message,
              type:'success',
              showClose:true
            })
            _this.roomList=data.data;
          }
        })
      },
      getRoomInfo(row){
        this.detailData=row;
        this.roomDetailVisible=true;
        console.log(row);
      },
      sureInRoom(row){
        this.detailData=row;
        this.sureDialogVisiable=true;
      },
      inRoom(){
        var _this =this;
        $.ajax({
          url:'http://localhost:8088/sys/inRoom',
          type:'post',
          dataType:'json',
          data:{
            stuNum:_this.stuNum,
            roomNum:_this.detailData.roomNum
          },
          success:function(data){
            console.log(data),
            _this.sureDialogVisiable=false;
            if(data.success == false){
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

          }
        })
      }
    },
    created() {
      this.sureDialogVisiable=false;
      this.roomDetailVisible=false;
    }
  }
</script>

<style>
</style>
