<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>

 <div class="content">
  <div class="width1190">
   <form action="#" method="get" class="pro-search">
    
     
   </form><!--pro-search/-->
  </div><!--width1190/-->
  <div class="width1190">
   <div class="pro-left">
    <c:if test="${list== null || fn:length(list) == 0 }"><h3> 暂无房源  </h3></c:if>
   <c:forEach items="${list }" var="g">
    <dl>
     <dt><a href="toshowFangyuan.do?fid=${g.fid }"><img src="${fn:split(g.pics, ',')[0] }" width="286" height="188" /></a></dt>
     <dd>
      <h3><a href="toshowFangyuan.do?fid=${g.fid }">【${g.type}】 ${g.title }</a></h3>
      <div class="pro-wei">
       <img src="images/weizhi.png" width="12" height="16" /> <strong class="red">${g.area }</strong>
      </div>
      <div class="pro-fang">${g.huxing } ${g.mianji }平 ${g.chaoxiang }向  ${g.louceng}</div>
      <div class="pra-fa">发布人：${g.faburen.name } 委托人:${g.weituoren.name } 发布时间：<fmt:formatDate value="${g.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /> 
      <br> <a href="delmyFangyuan.do?ids=${g.fid }" onclick="return confirm('是否删除?')"><strong class="red">删除</strong></a>
      
      </div>
     </dd>
     <div class="price">
      <c:if test="${g.type=='新房' or g.type=='二手房' }">   
     ¥<strong>${g.saleprice }</strong><span class="font12">万</span></a><br />
   </c:if>
   <c:if test="${g.type=='出租房' }">   
     ¥<strong>${g.rentprice }</strong><span class="font12">元/月</span></a><br />
   </c:if> 
   </div> 
     <div class="clears"></div>
    </dl>
  </c:forEach>
  
   </div><!--pro-left/-->
   <div class="pro-right">
    <h2 class="right-title">新上房源</h2>
    <div class="right-pro">
     <c:forEach  items="${newlist }" var="g">
     <dl>
      <dt><a href="toshowFangyuan.do?fid=${g.fid }"><img src="${fn:split(g.pics, ',')[0] }" /></a></dt>
      <dd>
       <h3><a href="toshowFangyuan.do?fid=${g.fid }">${g.title }</a></h3>
       <div class="pro-fang">${g.huxing } ${g.mianji }平 ${g.chaoxiang }向  ${g.louceng}层</div>
       <div class="right-price"> <c:if test="${g.type=='新房' or g.type=='二手房' }">   
     ¥${g.saleprice }万
   </c:if>
   <c:if test="${g.type=='出租房' }">   
     ¥${g.rentprice }元/月
   </c:if>  </div>
      </dd>
     </dl>
     </c:forEach>
    </div><!--right-pro/-->
   </div><!--pro-right/-->
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 
 <jsp:include page="foot.jsp"></jsp:include>


</body>
</html>