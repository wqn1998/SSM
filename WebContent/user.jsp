<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%@include file="head.jsp" %>
<div class="content">
  <div class="width1190">
 <%@include file="left.jsp" %> 
    <div class="vip-right">
     <h3 class="vipright-title">修改头像</h3>
     <form action="updatefrontMyuser.do"   enctype="multipart/form-data"     method="post">
     <dl class="vip-touxiang">
      <dt>
     <!--  <img src="images/tx.jpg" width="100" height="100" /> -->
        <img src="${g.pic }" width="100" height="100" />
      </dt>
      <dd>
       <h3><strong>点击选择文件上传头像</strong></h3>
       <div class="sctx"><input type="file"  name="file" /><a href="javascript:;">上传</a></div>
       <p>图片格式：GIF、JPG、JPEG、PNG ，最适合尺寸100*100像素</p>
      </dd>
      <div class="clearfix"></div>
     </dl><!--vip-touxiang/-->
    <input type="hidden" name="uid" value="${g.uid }">
     <h3 class="vipright-title">修改资料</h3>
     <table class="grinfo">
        <tbody>
        <tr>
        <th>手机号：</th>
        <td> <strong><input type="text" name="tel" value="${g.tel }">
        
        </strong> 
        </td>
        </tr>
        <tr>
        <th><span class="red">*</span> 姓名：</th>
        <td>
        <input class="inp inw" type="text"  name="name" value="${g.name }" >
        </td>
        </tr>
        <tr>
        <th><span class="red">*</span> 性 &nbsp; &nbsp;别：</th>
        <td>
        <input type="radio" value="男" id="rbSex1"     name="sex"  <c:if test="${g.sex=='男'}">checked</c:if>   >
        <label for="rbSex1">男</label>
        <input type="radio" value="女" id="rbSex2"   name="sex"  <c:if test="${g.sex=='女'}">checked</c:if>>
        <label for="rbSex2">女</label>
        <span id="Sex_Tip"></span>
        </td>
        </tr>
        <tr>
        <th><span class="red"></span> 登 &nbsp;录&nbsp;名：</th>
        <td>
        <input class="inp inw"  type="text" value="${g.login}"   name="login">
        </td>
        </tr>
        
        
        <tr>
        <th>&nbsp;密 &nbsp; &nbsp;码：</th>
        <td>
        <input class="inp inw" type="password" maxlength="15" value="${g.pwd }" name="pwd">
        </td>
        </tr>
        
       <!--  <tr>
        <th valign="top">个性签名：</th>
        <td>
        <textarea id="sign" class="grtextarea"></textarea>
        <br>
        <span class="fgrey">(128字符以内)</span>
        </td>
        </tr> -->
        <tr>
        <th>&nbsp;</th>
        <td colspan="2">
        <label class="butt" id="butt">
        <input type="submit" class="member_mod_buttom"  value="完成修改" />
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


<jsp:include page="foot.jsp"></jsp:include>

</body>
</html>