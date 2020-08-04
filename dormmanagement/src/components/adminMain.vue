<template>
  <el-container>
    <el-aside width="200px">
      <div><img src="../assets/img/title.jpg" style="width: 50%"><div class="title1">宿舍管理系统</div></div>
     <el-menu :default-active="navDefalt"  class="el-menu-vertical-demo" router="true"  :collapse="isCollapse">
        <el-menu-item v-for="(item,index) in navList[sidebarIndex].sidebar" :key="item" :index="item.path">
            <i class="el-icon-menu"></i>
            <span slot="title">{{item.title}}</span>
          </el-menu-item>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>
        <el-menu :default-active="def"  class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-menu-item v-for="(item,i) in navList" :key="item.name" :index="item.index">
            <template slot="title">
              <!-- <i class="el-icon-s-platform"></i> -->
              <span> {{ item.navItem }}</span>
            </template>
          </el-menu-item>
           <div style="float: right; margin-right: 10px; padding: 20px;">管理员：{{admin.sysAdminName}}</div>
        </el-menu>

      </el-header>
      <el-main>
        <router-view></router-view>
      </el-main>
      <el-footer class="footer">
        <el-divider></el-divider>
        山东理工大学 软件1606吕岩毕业设计
      </el-footer>
    </el-container>
  </el-container>



</template>

<script>
  export default{
  name: 'adminMain',
  data() {
        return {
          def:'0',
          isCollapse: false,
          navList:[
            {index:0,name:'dorm',navItem:'宿舍管理',sidebar:[]},
            {index:1,name:'acco',navItem:'住宿管理',sidebar:[]},
            {index:2,name:'daily',navItem:'日常管理',sidebar:[]},
            {index:3,name:'sys',navItem:'系统管理',sidebar:[]},
          ],
          dorm:[
            {index:0,path:'/dorm',title:'楼栋宿舍管理'},
            {index:1,path:'/room',title:'房间信息管理'},
            // {index:2,path:'/info',title:'信息统计'}
          ],
          acco:[
            {index:0,path:'/student',title:'学生特征信息管理'},
            {index:1,path:'/choose',title:'自主选房'},
            {index:4,path:'/change',title:'调宿管理'},
            {index:5,path:'/checkOut',title:'退宿管理'},
            {index:6,path:'/accoAuto',title:'自主分配宿舍'}
          ],
          daily:[
            {index:0,path:'/notice',title:'公告管理'},
            {index:1,path:'/health',title:'卫生评分管理'},
            {index:2,path:'/visitor',title:'访客记录管理'},
            {index:3,path:'/repair',title:'报修管理'},
            {index:4,path:'/late',title:'晚归记录管理'}
          ],
          sys:[
            {index:0,path:'/student',title:'学生信息管理'},
            // {index:1,path:'/dormAdmin',title:'宿舍管理员信息管理'},
            {index:2,path:'/college',title:'学院信息管理'}
          ],
          navDefalt:'/mainEcharts',
          activeIndex: '0',
          admin: {},
          sidebarIndex: 0
        };
      },
      methods: {
        handleSelect(key, keyPath) {
          this.sidebarIndex=key;
          this.navDefalt=this.navList[key].sidebar[0].path;
          console.log(this.navDefalt);
        },
        sidebarSelect(key,keyPath){

        }
      },
      beforeCreate() {

      },
      mounted() {
        this.asideUrl=this.aside+"Aside";
        this.navList[0].sidebar=this.dorm;
        this.navList[1].sidebar=this.acco;
        this.navList[2].sidebar=this.daily;
        this.navList[3].sidebar=this.sys;
        // this.$router.push('/mainEchars')
      },
      beforeMount() {
        this.admin=this.$route.params.admin;
        this.navDefalt='/mainEcharts';
      },
      watch:{
        navDefalt:function(){
          this.$router.push(this.navDefalt);
        }
      }
}
</script>
<style>
    .el-header, .el-footer {
      /* background-color: #B3C0D1; */
      color: #333;
      text-align: center;
      height: 15%;
    }

    .el-aside {
      height: 100%;
      /* background-color: #D3DCE6; */
      color: #333;
      text-align: center;
    }

    .el-main {
      height: 70%;
      /* background-color: #E9EEF3; */
      color: #333;
      text-align: center;
    }

    .el-container {
      height: 618px;
      /* height: 100%; */
      width: 100%;
    }

    .el-container:nth-child(7) .el-aside {
    }
    .title1{
      font-size: 20px;
      margin-bottom: 10px;
    }
    .footer{
      font-size: 14px;
      font-family: "微软雅黑";
      color: #888888;
    }
</style>
