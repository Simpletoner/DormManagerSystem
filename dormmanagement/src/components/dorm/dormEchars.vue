<template>
    <!-- 矩形图组件 -->
    <div>
      <div style="width: 1000px;height: 400px;" ref="chart"></div>
    </div>

</template>

<script>
  import $ from 'jquery';
  export default{
    name:'dormEchars',
    data(){
      return{
        tableData:[],
        xArray:[],
        yArray:[]
      }
    },
    methods:{
      getAll(){
        var _this=this;
        $.ajax({
          url:'http://localhost:8088/dorm/getAll',
          type:'post',
          success:function(data){
            console.log(data.data);
            _this.tableData=data.data;
            for(let i=0;i<data.data.length;i++){
              _this.xArray[i]=data.data[i].dormName;
              _this.yArray[i]=data.data[i].roomCount;
            }
            _this.loading();
          }
        })
      },
      loading(){
        console.log(this);
        var _this=this;
        var tubiao = true;
        // 绘制图表
        if(tubiao){
          let myChart = this.$echarts.init(this.$refs.chart,'light');
          myChart.setOption({
              title: {
                  text: '楼栋信息柱形图'
              },
              tooltip: {},
              xAxis: {
                  data: _this.xArray
              },
              yAxis: {},
              series: [{
                  name: '人数',
                  type: 'bar',
                  data: _this.yArray
              }]
          });
        }

      }
    },
    mounted() {
      this.getAll();

    }
  }
</script>

<style>
  .mainEcharts{
    width: 100%;
    height: 100%;
  }
</style>
