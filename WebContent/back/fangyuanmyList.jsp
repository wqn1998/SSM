
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
        <script src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        <!--[if lt IE 9]>
          <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
          <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
     
        <div class="x-nav">
          <span class="layui-breadcrumb">
           <!--  <a href="">首页</a>
            <a href="">演示</a> -->
            <a>
              <cite>导航元素</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i></a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                           <form class="layui-form layui-col-space5"    >
                                <div class="layui-inline layui-show-xs-block">
                                    <input class="layui-input"  autocomplete="off" placeholder="请输入房源信息" name="title"  >
                                </div> 
                                 <div class="layui-inline layui-show-xs-block">
                                      <select class="layui-input"  name="type">
                                      <option value="">全部房源</option>
                                     <option value="二手房">二手房</option>
                                      <option value="新房">新房</option>
                                       <option value="出租房">出租房</option>
                                    </select>
                                    <input id="currentPage" name="currentPage" type="hidden" value="${pager.currentPage }" type="text" class="right-textfield03" size="1" />
                                </div>
                                 <div class="layui-inline layui-show-xs-block">
                                      <select class="layui-input"  name="status">  
                                      <option value="">全部状态</option>
                                     <option value="已成交">已成交</option>
                                      <option value="未成交">未成交</option>
                                       <option value="委托审核">委托审核</option>
                                    </select>
                                </div>
                                
                                <div class="layui-inline layui-show-xs-block">
                                 <i class="layui-icon">&#xe615;</i>     <input type="submit" class="layui-btn"  lay-submit="" lay-filter="sreach"  ></input>
                                </div>
                             </form>
                        </div>
                        <div class="layui-card-header">
                            <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
                            <button class="layui-btn" onclick="xadmin.open('添加','toAddFangyuan.do',600,400)"><i class="layui-icon"></i>添加</button>
                        </div>
                        <div class="layui-card-body layui-table-body layui-table-main">
                            <table class="layui-table layui-form">
                                <thead>
                                  <tr>
                                    <th>
                                      <input type="checkbox" lay-filter="checkall" name="" lay-skin="primary">
                                    </th>
                                    <th>ID</th>
                                    <th>标题</th>
                                    <th>售价</th>
                                    <th>租金</th>
                                    <th>户型</th>
                                    <th>面积</th>
                                      <th>朝向/楼层</th>
                                      <th>装修</th>
                                      <th>类型</th>
                                      <th>状态</th>
                                      <th>发布人</th>
                                      <th>委托人</th>
                                      <th>创建时间</th> 
                                      <th>虚假举报数量</th>
                                      <th>区域</th>
                                    <th>操作</th></tr>
                                </thead>
                                <tbody>
                                 
                                 <c:forEach items="${list }" var="u">
                                  <tr>
                                    <td>
                                      <input type="checkbox" name="ids"  value="${u.fid }"   lay-skin="primary"> 
                                    </td>
                                    <td>${u.fid }</td>
                                    <td>${u.title }</td>
                                    <td>${u.saleprice }</td>
                                    <td>${u.rentprice }</td>
                                    <td>${u.huxing }</td>
                                    <td>${u.mianji }</td>
                                    <td>${u.chaoxiang }-${u.louceng }层</td>
                                    <td>${u.zhuangxiu }</td>
                                     <td>${u.type }</td>
                                      <td>${u.status }</td>
                                       <td>${u.faburen.name }</td>
                                        <td>${u.weituoren.name }</td>
                                         <td><fmt:formatDate value="${u.createtime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                                          <td>${u.xujiacount }</td>
                                           <td>${u.area }</td>
                                    <td class="td-manage"> 
                                      <a title="编辑"  onclick="xadmin.open('编辑','toupdateFangyuan.do?fid=${u.fid}',600,400)" href="javascript:;">
                                        <i class="layui-icon">&#xe642;</i>
                                      </a> 
                                      <a title="删除" onclick="member_del(this,'${u.fid}')" href="javascript:;">
                                        <i class="layui-icon">&#xe640;</i>
                                      </a>
                                      
                                    </td>
                                  </tr> 
                         </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="layui-card-body ">
                            <div class="page">
                                <div>
                                <%--   <a href="javascript:void(0)" class="prev" href="">&lt;&lt;</a>
                                  <a href="javascript:void(0)"   class="num" href="">1</a>
                                 <span class="current">${pager.currentPage }</span>
                                  <a href="javascript:void(0)" class="num" href="">3</a>
                                  <a href="javascript:void(0)" class="num" href="">489</a>
                                  <a href="javascript:void(0)" class="next" href="">&gt;&gt;</a>  --%>
                                  
                                   <!-- 分页部分开始 -->
                <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
                    </tr>
                    <tr>
                        <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
                            <tr>
                                <td width="50%">共 <span class="right-text09">${pager.totalPage }</span> 页 | 第 <span class="current">${pager.currentPage }</span> 页</td>
                                <td width="49%" align="right"><a href="javascript:void(0)" onclick="fenye(1)" class="right-font08">首页</a>  <a href="javascript:void(0)" onclick="fenye(${pager.prePage})" >上一页</a>  <a href="javascript:void(0)" onclick="fenye(${pager.nextPage})" >下一页</a>  <a href="javascript:void(0)" onclick="fenye(${pager.totalPage})" class="right-font08">末页</a> </td>
                                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="1%"></td>
                                        <td width="87%">
                                        </td>
                                    </tr>
                                </table></td>
                            </tr>
                        </table></td>
                    </tr>
                </table>
                <script>
                    function  fenye(p){
                        var pp= document.getElementById("currentPage");
                        pp.value=p;
                        if(pp.value>0&&pp.value!=""&&pp.value<=${pager.totalPage }){
                            document.forms[0].submit();
                        }else{
                            alert("跳转页数不正确");
                            pp.focus();
                        }

                    }

                </script>
                <!-- 分页部分结束 -->
                                  
                                  
                                  
                                  
                                  
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
       
    </body>
    <script>
      layui.use(['laydate','form'], function(){
        var laydate = layui.laydate;
        var  form = layui.form;


        // 监听全选
        form.on('checkbox(checkall)', function(data){

          if(data.elem.checked){
            $('tbody input').prop('checked',true);
          }else{
            $('tbody input').prop('checked',false);
          }
          form.render('checkbox');
        }); 
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });


      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
                 var xx="";
               $.ajax({
                   url: "delFangyuan.do",
                   type: "GET",
                   data: "ids="+id,
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
                   	xx=data.msg;
                   
                 //  	$(obj).parents("tr").remove();
                    layer.msg(xx,{icon:1,time:1000},function() { 
                    	location.reload();
                    });
                   }
               });
              
              
             
          });
      }



      function delAll() {
    	 /*  var ids = [];
    	  $('tbody input:checked').each(function(index, el) {
              if($(this).prop('checked')){
                 ids.push($(this).val())
              }
          });  
    	 if($('tbody input:checked').size()==0){
    		 
    		 alert("请选择记录");
    		 return false;
    	 }
    	// alert(ids.toString());
    	  $.ajax({
              url: "delMyuser.do",
              type: "GET",
              data: "ids="+ids.toString(),
              dataType: "json",
              beforeSend: function ()
              {  //alert("beforeSend"+data);
                //  $("#ajax-loader").show();
              },
              error: function ()
              {
               //alert("error"+data.msg);
              },
              complete:function (data) {
             	  alert("complete"+data.msg);//   $("#ajax-loader").hide();
              },
              success: function (data)
              {
             	// alert(data.msg);
              	//xx=data.msg;
              
            //  	$(obj).parents("tr").remove();
                layer.msg(xx,{icon:1,time:1000},function() {  
               	location.reload();
               });
              }
          }); */
    	  
    	  
      var ids = [];
 
        // 获取选中的id 
       $('tbody input:checked').each(function(index, el) {
            if($(this).prop('checked')){
               ids.push($(this).val())
            }
        });  
       
      
        
        layer.confirm('确认要删除吗？'+ids.toString(),function(index){
            //捉到所有被选中的，发异步进行删除
             var xx="";
               $.ajax({
                   url: "delFangyuan.do",
                   type: "GET",
                   data: "ids="+ids.toString(),
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
                   	xx=data.msg;
                   
                 //  	$(obj).parents("tr").remove();
                    layer.msg(xx,{icon:1,time:1000},function() { 
                    	location.reload();
                    });
                   }
               });
            
            
           // layer.msg('删除成功', {icon: 1});
           // $(".layui-form-checked").not('.header').parents('tr').remove();
        }); 
        
      }
    </script>
</html>