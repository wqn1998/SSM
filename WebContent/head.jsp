<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html>
<html lang="zh-CN">
   <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="Author" contect="http://www.webqin.net">
<title>房屋租赁</title>
<link rel="shortcut icon" href="images/favicon.ico" />
<link type="text/css" href="css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/js.js"></script>



<script type="text/javascript">
 $(function(){
	 //导航定位
	 $(".nav li:eq(0)").addClass("navCur");
	 })
</script>
 ${message} 
 <script>
   function  xianshi(){
	 $("#llist").fadeIn();	
	 $("#llist").on("mouseleave",function (){
		 $("#llist").fadeOut(); 
	 });
   }
   /* function yincang(){
	  $("#llist").fadeOut();	
	   
   } */
   
 </script>

</head>

<body> 
 <div class="header">
  <div class="width1190">
   <div class="fl">您好，欢迎来到房屋租赁！</div>
   <div class="fr">
   <c:if test="${dangqianyonghu!=null }">
     <span style="color: red"> 欢迎您   </span>  ${dangqianyonghu.name } ${dangqianyonghu.role }   <a href="showfrontMyuser.do?uid=${dangqianyonghu.uid}" >个人信息</a>  <a href="loginout.jsp">注销</a>  
   </c:if>
   <c:if test="${dangqianyonghu==null }">
    <a href="login.jsp">登录</a> | 
    <a href="reg.jsp">注册</a> | 
   </c:if>
   
    <a href="javascript:;" onclick="AddFavorite(window.location,document.title)">加入收藏</a> | 
    <a href="javascript:;" onclick="SetHome(this,window.location)">设为首页</a>
   </div>
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--header/-->
 <div class="logo-phone">
  <div class="width1190">
   <h1 class="logo"><a href="index.do"><img src="images/abc.png" width="163" height="59" /><!-- <img src="images/logo.png" width="163" height="59" /> --></a></h1>
   <div class="phones"><strong>021-63179891</strong></div>
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--logo-phone/-->
 <div class="list-nav">
  <div class="width1190">
   <div class="list">
    <h3 onmouseover="xianshi()"  >房源分类</h3>
    <div id="llist"    style="display: none;"   class="list-list"> 
     <dl>
      <dt><a href="showfronttiaojianFangyuan.do?type=出租房">租房</a></dt> 
     </dl>
     <dl>
      <dt><a href="showfronttiaojianFangyuan.do?type=新房">新房</a></dt> 
     </dl>
     <dl>
      <dt><a href="showfronttiaojianFangyuan.do?type=二手房">二手房</a></dt> 
     </dl>
    </div>
   </div><!--list/-->
   <ul class="nav">
    <li><a href="index.do">首页</a></li>
    <li><a href="showfronttiaojianFangyuan.do?type=出租房">租房</a></li>
    <li><a href="showfronttiaojianFangyuan.do?type=新房">新房</a></li>
    <li><a href="showfronttiaojianFangyuan.do?type=二手房">二手房</a></li>
    <li><a href="showfrontjingjiren.do">金牌经纪人</a></li>
    <li><a href="showfrontBaike.do">百科知识</a></li>
    <li><a href="showfrontHetong.do">合同模板</a></li>
    <div class="clears"></div>
   </ul><!--nav/-->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--list-nav/-->
 <div class="banner" style="background:url(images/ban.jpg) center center no-repeat;"></div>
 
 