import Vue from 'vue'
import Router from 'vue-router'
import login from '@/components/login'
import regist from '@/components/regist'
import adminMain from '@/components/adminMain'
import accoAuto from '@/components/acco/auto'
import checkOut from '@/components/acco/checkOut'
import checkIn from '@/components/acco/checkIn'
import repair from '@/components/daily/repair'
import late from '@/components/daily/late'
import visitor from '@/components/daily/visitor'
import health from '@/components/daily/health'
import notice from '@/components/daily/notice'
import room from '@/components/dorm/room'
import info from '@/components/dorm/info'
import feature from '@/components/acco/feature'
import choose from '@/components/acco/choose'
import putIn from '@/components/acco/putIn'
import change from '@/components/acco/change'
import dorm from '@/components/dorm/dorm'
import dormEchars from '@/components/dorm/dormEchars'
import student from '@/components/sys/student'
import dormAdmin from '@/components/sys/dormAdmin'
import college from '@/components/sys/college'

import 'jquery'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login,
      children:[
        {
          path: '/regist',
          name: 'registForm',
          component: regist,
        }
      ],
    },
    {
      path: '/adminMain',
      name: 'adminMain',
      component: adminMain,
      children:[
        {
          //主页图表
          path:'/dorm',
          name:'dorm',
          component:dorm
        },
        {
          path:'/dormEchars',
          name:'dormEchars',
          component:dormEchars
        },
        {
          //房间信息
          path:'/room',
          name:'room',
          component:room
        },
        {
          //信息统计
          path:'/info',
          name:'info',
          component:info
        },
        {
          //学生特征信息
          path:'/feature',
          name:'feature',
          component:feature
        },
        {
          //自主选房
          path:'/choose',
          name:'choose',
          component:choose
        },
        {
          //安排入住
          path:'/putIn',
          name:'putIn',
          component:putIn
        },
        {
          //换宿
          path:'/change',
          name:'change',
          component:change
        },
        {
          // 自主分配宿舍
          path:'/accoAuto',
          name:'accoAuto',
          component: accoAuto
        },
        {
          //退宿管理
          path:'/checkOut',
          name:'checkOut',
          component: checkOut
        },
        {
          //报修管理
          path:'/repair',
          name:'repair',
          component: repair
        },
        {
          //晚归管理
          path:'/late',
          name:'late',
          component: late
        },
        {
          //确认入住
          path:'/checkIn',
          name:'checkIn',
          component: checkIn
        },
        {
          //访客记录
          path:'/visitor',
          name:'visitor',
          component: visitor
        },
        {
          //卫生评分
          path:'/health',
          name:'health',
          component:health
        },
        {
          //通知公告
          path:'/notice',
          name:'notice',
          component:notice
        },
        //学生信息管理
        {
          path:'/student',
          name:'student',
          component:student
        },
        //宿舍管理员信息管理
        {
          path:'/dormAdmin',
          name:'dormAdmin',
          component:dormAdmin
        },
        //学院信息管理
        {
          path:'/college',
          name:'college',
          component:college
        }
      ]
    },
  ]
})
