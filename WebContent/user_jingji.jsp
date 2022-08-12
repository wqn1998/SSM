<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
 <div class="content">
  <div class="width1190">
   <%@include file="left.jsp" %> 
    <div class="vip-right">
     <h3 class="vipright-title">经纪人</h3>
     <div class="jingjiren">
     <c:forEach  items="${list }" var="g">
    
      <dl>
       <dt><img src="${g.pic }" /></dt>
       <dd>
        <h3>${g.role } - ${g.name } <img src="images/phone2.jpg" /> ${g.tel }</h3>
        <div class="wuxing"><img src="images/wuxing.jpg" width="104" height="16" /></div>
        <div class="dizhi"><a href="showfrontFangyuan.do?uid=${g.uid }" >查看房源</a></div>
       </dd>
       <div class="xunzhang"><img src="images/xunzhang.jpg" width="51" height="50" /></div>
       <div class="clearfix"></div>
      </dl>
        </c:forEach>
     
     </div><!--jingjiren/-->
    </div><!--vip-right/-->
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 

<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>