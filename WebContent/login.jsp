<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@include file="head.jsp" %>
<div class="content">
  <div class="width1190">
   <div class="reg-logo">
   <form id="signupForm" method="post" action="frontLogin.do" class="zcform">
        <p class="clearfix">
        	<label class="one" for="agent">用户名：</label>
        	<input id="agent" name="login" type="text" class="required" value placeholder="请输入您的用户名" />
        </p>
        <p class="clearfix">
         	<label class="one"  for="password">登录密码：</label>
        	<input id="password" name="pwd" type="password" class="{required:true,rangelength:[1,20],}" value placeholder="请输入密码" />
        </p>
          <p class="clearfix">
         	<label class="one"  for="password">选择角色：</label>
         	<select name="role">
         	<option value="普通用户">我是普通用户</option>
         	<option value="经纪人">我是经纪人</option>
         	</select>
        	 
        </p>
        <!--<p class="clearfix agreement">
        	<input type="checkbox" />
            <b class="left">已阅读并同意<a href="#">《用户协议》</a></b>
        </p>-->
       	<p class="clearfix"><input class="submit" type="submit" value="立即登录"/></p>
    </form>
    <div class="reg-logo-right">
     <h3>如果您没有账号，请</h3>
     <a href="reg.jsp" class="logo-a">立即注册</a>
    </div><!--reg-logo-right/-->
    <div class="clears"></div>
  </div><!--reg-logo/-->
  </div><!--width1190/-->
 </div><!--content/-->
 <jsp:include page="foot.jsp"></jsp:include>