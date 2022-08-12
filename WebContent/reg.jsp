<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 <%@include file="head.jsp" %>
 
 <script>
 function checktijiao(){
	var login= document.getElementById("login");
	var password= document.getElementById("password");
	var tel= document.getElementById("tel");
	 if(login.value==''){
		  alert("请输入登录名");
		 return false;
	 }
	 if(password.value==''){
		  alert("请输入密码");
		 return false;
	 }
	 if(tel.value==''){
		  alert("请输入电话号");
		 return false;
	 }
	 if(tel.value.length!=11){
		  alert("电话号长度不正确");
		 return false;
	 }
	 
	 
 }
 </script>
 
 <div class="content">
  <div class="width1190">
   <div class="reg-logo">
   <form id="signupForm" method="post" action="loginaddMyuser.do" enctype="multipart/form-data"   class="zcform">
        <p class="clearfix">
        	<label class="one" for="agent">用户名：</label>
        	<input id="login" name="login" type="text" class="required" value="${g.login }" placeholder="请输入您的登录名" />
        </p>
        
        <p class="clearfix">
         	<label class="one"  for="password">登录密码：</label>
        	<input id="password" name="pwd" type="password"   class="{required:true,rangelength:[1,20],}" value="${g.pwd }" placeholder="请输入密码" />
        </p>
        <p class="clearfix">
        	<label class="one" for="confirm_password">姓名：</label>
        	<input id="name" name="name" type="text"  value="${g.name }"  class="required"  placeholder="请输入姓名" />
        </p>
         <p class="clearfix">
         <label class="one" for="confirm_password">性别：</label>
        	<select id="agent" name="sex"  >
        	<option value="男" <c:if test="${g.sex=='男'}">selected</c:if> >男</option>
        	<option value="女" <c:if test="${g.sex=='女'}">selected</c:if> >女</option>
        	</select> 
        </p>
         <p class="clearfix">
        	<label class="one" for="confirm_password">电话：</label>
        	<input id="tel"  name="tel" type="text"  value="${g.tel }"  class="required"  placeholder="请输入电话号" />
        </p>
          <p class="clearfix">
        	<label class="one" for="confirm_password">头像：</label>
        	<input  id="agent" type="file" name="file"  class="required"></input> 
        </p> 
          <p class="clearfix">
         <label class="one" for="confirm_password">角色：</label>
        	<select id="agent" name="role"  >
        	<option value="普通用户"  <c:if test="${g.role=='普通用户'}">selected</c:if> >我是普通用户</option>
        	<option value="经纪人"   <c:if test="${g.role=='经纪人'}">selected</c:if> >我是经纪人</option>
        	</select> 
        </p>
        
       	<p class="clearfix"><input class="submit" type="submit" onclick="return checktijiao()" value="立即注册"/></p>  
    </form>
    <div class="reg-logo-right">
     <h3>如果您已有账号，请</h3>
     <a href="login.jsp" class="logo-a">立即登录</a>
    </div><!--reg-logo-right/-->
    <div class="clears"></div>
  </div><!--reg-logo/-->
  </div><!--width1190/-->
 </div><!--content/-->
 <jsp:include page="foot.jsp"></jsp:include>