<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@include file="head.jsp" %>

<div class="content">
  <div class="width1190" style="width:1000px;">
   <div class="proImg fl">
     <img src="${fn:split(g.pics, ',')[0] }" />
   </div><!--proImg/-->
   <div class="proText fr">
    <h3 class="proTitle">${g.title } </h3>
    <img src="images/jb.png"><a style="color:red; cursor: pointer;" href="jubao.do?fid=${g.fid}"  >举报虚假</a>   <a >被举报数:${g.xujiacount}</a> 
    <div class="proText1">
     编号：${g.fid }<br />
  <c:if test="${g.type=='新房' or g.type=='二手房' }">   
     售价：${g.saleprice }万<br />
   </c:if>
   <c:if test="${g.type=='出租房' }">   
    租金：${g.rentprice }元<br />
   </c:if>
     户型：${g.huxing }<br />
     面积：${g.mianji }㎡<br />
     朝向：${g.chaoxiang }<br />
     楼层：${g.louceng }层<br />
     装修：${g.zhuangxiu }<br />
     区域：${g.area }
    </div>
    <div class="xun-car">
     <a href="javascript:;" class="xwjg"> 
    <c:if test="${g.type=='新房' or g.type=='二手房' }">   
     ¥<strong>${g.saleprice }</strong>万</a><br />
   </c:if>
   <c:if test="${g.type=='出租房' }">   
     ¥<strong>${g.rentprice }</strong>元</a><br />
   </c:if> 
     <a href="guanzhuadd.do?fid=${g.fid}"   class="projrgwc">关注房源</a> 
     <a class="projrgwc" id="iwantyuyue" >预约看房</a> 
     
    </div><!--xun-car/-->
   </div><!--proText/-->
   <div class="clears"></div>
  </div><!--width1190/-->
  <div class="proBox" style="width:1000px;margin:10px auto;">
  <div class="proEq">
   <ul class="fl">
    <li class="proEqCur">房源详情</li>
    <li>房源图片</li>
    <li>评论信息</li>
   </ul>
   <div class="lxkf fr"><a href="http://wpa.qq.com/msgrd?v=3&uin=1072631488&site=qq&menu=yes" target="_blank"></a></div>
   <div class="clears"></div>
  </div><!--proEq/-->
  <div class="proList">
    ${g.description }
  
<br />
    <c:forEach items="${piclist }" var="v">
     <img src="${v }" />
    </c:forEach>

  </div><!--proList/-->
  <div class="proList">
  <c:forEach items="${piclist }" var="v">
    <img src="${v }"/>
    </c:forEach> 
  </div><!--proList/-->
  <div class="proList"> 
        <c:if test="${plist== null || fn:length(plist) == 0 }"><h3> 暂无评论 </h3></c:if>
  
      <c:forEach items="${plist}" var="pl">  
      <dl>
       <dt> <img src="${pl.myuser.pic }" width="50" height="50" /> 
       <dd>
         
        <div class="guantext">${pl.myuser.name } 说:</div>
        <div class="guantext">${pl.content }</div>
        <div class="guantext2">评论时间：<fmt:formatDate value="${pl.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />    </div>
       </dd> 
       <div class="clearfix"></div>
      </dl>
      <hr>
        </c:forEach>
<form action="addfrontpinglun.do" method="post"> 
   <!--评论信息--> 
   <input type="hidden" name="fid" value="${g.fid }"  > 
  <table class="grinfo">
        <tbody>  
        <tr>
        <th valign="top">评论内容：</th>
        <td>
        <textarea id="sign" name="content"  class="grtextarea"></textarea>
        <br>
        <span class="fgrey">(128字符以内)</span>
        </td>
        </tr>
          <tr>
        <th>&nbsp;</th>
        <td colspan="2">
        <label class="butt" id="butt">
        <input   value="发表内容"   type="submit"    class="member_mod_buttom" onclick="return ccc()"> 
        </label>
        </td>
        </tr>    
      </tbody>
    </table>  
    </form>
     <!--评论信息/--> 
  </div><!--proList/-->
 </div><!--proBox/-->
 </div><!--content/-->
 <script>
 function ccc(){
	  if(document.getElementById("sign").value==""){
		  alert("请填写评论内容");
		   return false;
	  } 
	 	 
 }
 function checkyuyue(){
	  if(document.getElementById("ymessage").value==""){
		  alert("请填写预约内容");
		   return false;
	  } 
	 
 }
 
 </script>
<%@include file="foot.jsp" %> 

<div class="bg100"></div>
  <div class="zhidinggoufang">
  <h2>预约信息 <span class="close">X</span></h2>
  <c:if test="${dangqianyonghu!=null }">  
  <form action="yuyueadd.do"   method="post">
  <input type="hidden" name="fid" value="${g.fid }" >
  <input type="hidden" name="uid" value="${dangqianyonghu.uid }" >
   <div class="zhiding-list">
    <label>联系方式：</label>
     <input type="text"  name="tel"  value="${dangqianyonghu.tel }"/>
   </div>
   <div class="zhiding-list">
    <label>预约内容</label>
   <textarea rows="4" cols="40" name="ymessage"  id="ymessage"    ></textarea>
    
   </div>
   <div class="zhiding-list">
    <label></label>
     
   </div>
   <div class="zhidingsub"><input type="submit" value="提交" onclick="return checkyuyue()" /></div>
 
  <div class="zhidingtext">
   <h3>指定购房注意事宜：</h3>
   <p>1、请详细输入您所需要购买的房源信息(精确到小区)</p>
   <p>2、制定购房申请提交后，客服中心会在24小时之内与您取得联系</p>
   <p>3、如有任何疑问，请随时拨打我们的电话：400-000-0000</p>
  </div><!--zhidingtext/--> 
    </form>
  </c:if>
  
  <c:if test="${dangqianyonghu==null }">您还没有登录</c:if>
  
 </div><!--zhidinggoufang/-->

</body>
</html>