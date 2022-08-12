<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
       <script src="./js/jquery.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
 
                <div class="layui-col-sm12 layui-col-md6">
                    <div class="layui-card">
                        <div class="layui-card-header">房源统计</div>
                        <div class="layui-card-body" style="min-height: 280px;">
                            <div id="main3" class="layui-col-sm12" style="height: 300px;"></div>

                        </div>
                    </div>
                </div>
                
            </div>
        </div>
        </div>
    
        <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
        <script type="text/javascript">
      
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main3'));
$(function (){
	
	
	  $.ajax({
	         url: "ajaxtongjifangyuanshuliang.do",
	         type: "post",
	         data: "",
	         dataType: "json",
	         beforeSend: function ()
	         {  //alert("beforeSend"+data);
	           //  $("#ajax-loader").show();
	         },
	         error: function ()
	         {
	        	// alert("error"+data.msg);
	         },
	         complete:function (data) {
	        	// alert("complete"+data.msg);//   $("#ajax-loader").hide();
	         },
	         success: function (data)
	         {
	        	if(data.success=="nosession"){//没登录
	        		alert(data.msg);
	        	}else{
	        		xx=data.exc;//$("#article").html(data);
	        	var x=	xx.split(",");
	        	show(x);
	        	}
	         	 
	         }
	     }); 
});
        
       function show(vvv){
    	   // 指定图表的配置项和数据
           var option = {
               tooltip : {
                   trigger: 'item',
                   formatter: "{a} <br/>{b} : {c} ({d}%)"
               },
               legend: {
                   orient: 'vertical',
                   left: 'left',
                   data: ['二手房源数量','新房房源数量','出租房房源数量']
               },
               series : [
                   {
                       name: '房源统计',
                       type: 'pie',
                       radius : '55%',
                       center: ['50%', '60%'],
                       data:[
                           {value:vvv[0], name:'二手房源数量'},
                           {value:vvv[1], name:'新房房源数量'},
                           {value:vvv[2], name:'出租房房源数量'}
                           
                            
                       ],
                       itemStyle: {
                           emphasis: {
                               shadowBlur: 10,
                               shadowOffsetX: 0,
                               shadowColor: 'rgba(0, 0, 0, 0.5)'
                           }
                       }
                   }
               ]
           }; 

           // 使用刚指定的配置项和数据显示图表。
           myChart.setOption(option);
    	   
    	   
       }

    </script>
    <script>
        var _hmt = _hmt || [];
        (function() {
          var hm = document.createElement("script");
          hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
          var s = document.getElementsByTagName("script")[0]; 
          s.parentNode.insertBefore(hm, s);
        })();
        </script>
    </body>
</html>