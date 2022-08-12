<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="head.jsp" %>


<div class="content">
  <div class="width1190">
   <%@include file="left.jsp" %> 
    <div class="vip-right">
     <h3 class="vipright-title">修改资料</h3>
     <form action="updatefrontpwdMyuser.do" method="post">
      <input type="hidden" id="uid" name="uid" value="${g.uid }"   >
     <table class="grinfo">
      <tbody>
        <tr>
        <th>手机号：</th>
        <td> <strong>${g.tel }</strong></td>
        </tr>
        <tr>
        <th>账号：</th>
        <td> <input class="inp inw" type="text"  maxlength="15"  name="login"  value="${g.login }" readonly="readonly"    >
        
        </td>
        </tr>
        <tr>
        <th>原密码：</th>
        <td>
        <input class="inp inw" type="password" id="newpwd"   placeholder="不少于1位"     >
        <input type="hidden" id="oldpwd"  value="${g.pwd }"   >
        </td>
        </tr>
        <tr>
        <th>新密码：</th>
        <td>
        <input class="inp inw" type="password" id="pwd" name="pwd"   placeholder="不少于1位">
        </td>
        </tr>
        <tr>
        <th>&nbsp;</th>
        <td colspan="2">
        <label class="butt" id="butt">
        <input type="submit" class="member_mod_buttom"  onclick="return cc()"   value="完成修改" />
        </label>
        </td>
        </tr>
        </tbody>
     </table>
     </form>
    </div><!--vip-right/-->
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 <script>
  function cc(){
	var newpwd=  document.getElementById("newpwd") ;
	var oldpwd=  document.getElementById("oldpwd") ;
	var pwd=  document.getElementById("pwd") ; 
	  
	if(newpwd.value!=oldpwd.value){
		 alert("原密码不正确");
		 return false;
	}else if(pwd.value==''){
		 alert("密码不能为空");
		return false;
	}
	
	  
  }
 </script>
 
 
 
 <jsp:include page="foot.jsp"></jsp:include>
</body>
</html>