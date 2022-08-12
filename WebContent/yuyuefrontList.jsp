<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<div class="content">
  <div class="width1190">
 <%@include file="left.jsp" %> 
    <div class="vip-right">
     <h3 class="vipright-title">预约的房源</h3>
     <ul class="guanzhueq">
      <li class="guanzhueqcur"><a href="javascript:;">预约的房源</a></li>
   
      <div class="clearfix"></div>
     </ul><!--guanzhueq/-->
     <div class="guanzhulist">
     <c:forEach  items="${list }" var="g"> 
      <dl>
       <dt><a href="toshowFangyuan.do?fid=${g.fid }"><img src="${fn:split(g.fangyuan.pics,',')[0] }" width="190" height="128" /></a></dt>
       <dd>
        <h3><a href="toshowFangyuan.do?fid=${g.fid }">${g.fangyuan.title }</a></h3>
        <div class="guantext">${g.fangyuan.type } - ${g.fangyuan.zhuangxiu } - ${g.fangyuan.status }  ${g.fangyuan.huxing } | ${g.fangyuan.mianji } 平米| ${g.fangyuan.chaoxiang }</div>
        <div class="guantext">预约信息:${g.ymessage }  <fmt:formatDate value="${g.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /> </div>
        <div class="guantext2">回复内容:${g.receive }  <fmt:formatDate value="${g.receivetime}" pattern="yyyy-MM-dd HH:mm:ss" />    ${g.status }       </div>
       </dd>
       <div class="price">
        <c:if test="${g.fangyuan.type=='新房' or g.fangyuan.type=='二手房' }">   
      ¥ <strong>${g.fangyuan.saleprice }</strong><span class="font12">万</span></a>
          </c:if>
      <c:if test="${g.fangyuan.type=='出租房' }">   
      ¥ <strong>${g.fangyuan.rentprice }</strong><span class="font12">元/月</span></a>
     </c:if>  
       
       </div>
       <div class="clearfix"></div>
      </dl>
        </c:forEach>
     </div><!--guanzhulist/-->
    
    </div><!--vip-right/-->
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 
 
<%@include file="foot.jsp" %>



</body>
</html>