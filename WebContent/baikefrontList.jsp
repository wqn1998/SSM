<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<div class="content">
  <div class="width1190">
 <%@include file="left.jsp" %> 
     
    <div class="vip-right">
     <h3 class="vipright-title">百科知识</h3>
     <ul class="guanzhueq">
      <li class="guanzhueqcur"><a href="javascript:;">百科知识</a></li>
   
      <div class="clearfix"></div>
     </ul><!--guanzhueq/-->
     
     <div class="guanzhulist">
     <c:forEach  items="${list }" var="g"> 
      <dl>
       <dt><img src="images/qianyan.png"  style="height:128px; width: 190px;" /></dt>
       <dd>
        <h3>${g.title }</h3>
        <div class="guantext"></div>
        <div class="guantext">${g.daan }</div>
        <div class="guantext2"><fmt:formatDate value="${g.createtime}" pattern="yyyy-MM-dd HH:mm:ss" />  </div>
       </dd>
       
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