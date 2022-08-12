<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        
        <script type="text/javascript" src="./js/jquery.js"></script> 
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
  
        
        
    </head>
    <body>
    
 
    
    
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="myformm"  action="addHetong.do" method="post" enctype="multipart/form-data" >
                     <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span>标题</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_email" name="title"  value="${g.title }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                           
                            </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span></div></div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>文档</label>
                        <div class="layui-input-inline"> 
                          <input type="file"   name="file"  > 
                             </div>
                   
                    </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                         <button class="layui-btn" lay-filter="add" lay-submit="">增加</button>
                       
                       
                        
                        </div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //自定义验证规则
                form.verify({
                    nikename: function(value) {
                        if (value.length < 5) {
                            return '昵称至少得5个字符啊';
                        }
                    },
                    pass: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#L_pass').val() != $('#L_repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });

                //监听提交
                form.on('submit(add)',
                function(data) {
                    //console.log(data);
                    //发异步，把数据提交给php 
var formdata= new FormData($("#myformm")[0]);
 //alert("123");
   $.ajax({
url:'addHetong.do',
type:'post',
dataType:"json",
data: formdata,//data: formdata,
processData: false,
contentType : false,
success: function (data) {  
	      
      layer.alert(data.msg, {
          icon: 6
      },
      function() {
          //关闭当前frame
          xadmin.close(); 
          // 可以对父窗口进行刷新 
          xadmin.father_reload();
      });  
	
	
},
error: function (data) {
	 alert("error"+data.msg);
	
}
})
                    
                    return false;
                });

            });

        
      
         
</script>
        
        
        
        
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>