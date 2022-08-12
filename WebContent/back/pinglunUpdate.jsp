<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]--></head>
    
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form"  id="myform"    action="updatePinglun.do"   method="post">
                   <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span>发布人</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_email" readonly="readonly"   value="${g.myuser.name }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                             <input type="hidden" id="L_email" name="pid"  value="${g.pid }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                            <input type="hidden" id="L_email" name="uid"  value="${g.uid }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                           
                            </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span></div></div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>房源</label>
                        <div class="layui-input-inline">
                         ${g.fangyuan.title }
                          <input type="hidden" id="L_email" name="fid"  value="${g.fid }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                           
                            </div>
                   
                    </div>
                    
                     <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>内容</label>
                        <div class="layui-input-inline"> 
                          <input type="text" id="L_email" name="content"  value="${g.content }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                            </div> 
                    </div>
                     <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>时间</label>
                        <div class="layui-input-inline">
                        <fmt:formatDate value="${g.createtime}" pattern="yyyy/MM/dd HH:mm:ss" />
                            
                            </div>
                   
                    </div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label> 
                        <button     class="layui-btn" lay-filter="add" lay-submit="">更新</button></div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer'],
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
                    //$("form").submit();
                    ///////////ajax提交//////////////////
                    var  xx="操作成功"; 
     var form = $("#myform");
     $.ajax({
         url: form.attr("action"),
         type: form.attr("mathod"),
         data: form.serialize(),
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
        	// alert(data.msg);
         	xx=data.msg;//$("#article").html(data);
         }
     });
                    /////////////ajax提交结束/////////////////////
                    //window.parent.location.reload();
                  
                    layer.alert(xx, {
                        icon: 6
                    },
                    function() { 
                    	
                    	window.parent.location.reload();
                        // 获得frame索引
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                    });
                    return false;
                });

            });</script>
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>