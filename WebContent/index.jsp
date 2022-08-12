<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 
 
<%@include file="head.jsp"%>
 <div class="content">
  <div class="width1190">
   <h2 class="title">租房 <a href="showfronttiaojianFangyuan.do?type=出租房">更多&gt;&gt;</a></h2>
   <div class="index-fang-list">
   <c:forEach items="${chuzulist }" var="cz">
    <dl>
     <dt><a href="toshowFangyuan.do?fid=${cz.fid }"><img src="${fn:split(cz.pics, ',')[0] }" width="286" height="188" /></a></dt>
     <dd>
      <h3><a href="toshowFangyuan.do?fid=${cz.fid }"></a>${cz.title }</h3>
      <div class="hui">${cz.huxing } | ${cz.mianji }m² | ${cz.zhuangxiu}</div>
     </dd>
    </dl>
    </c:forEach>
    <div class="clears"></div>
   </div><!--index-fang-list/-->
   
   <h2 class="title">新房 <a href="showfronttiaojianFangyuan.do?type=新房">更多&gt;&gt;</a></h2>
   <div class="index-fang-list">
    <c:forEach items="${xinlist }" var="xcz">
    <dl>
     <dt><a href="toshowFangyuan.do?fid=${xcz.fid }"><img src="${fn:split(xcz.pics, ',')[0] }" width="286" height="188" /></a></dt>
     <dd>
      <h3><a href="toshowFangyuan.do?fid=${xcz.fid }"></a>${xcz.title }</h3>
      <div class="hui">${xcz.huxing } | ${xcz.mianji }m² | ${xcz.zhuangxiu}</div>
     </dd>
    </dl>
    </c:forEach>
    
    <div class="clears"></div>
   </div><!--index-fang-list/-->
   
   <h2 class="title">二手房 <a href="showfronttiaojianFangyuan.do?type=二手">更多&gt;&gt;</a></h2>
   <div class="index-ershou">
   
    <div class="in-er-left">
     <a href="toshowFangyuan.do?fid=${ershou1.fid }"><img src="${fn:split(ershou1.pics, ',')[0] }" width="380" height="285" /></a>
     <div class="in-er-left-text"><strong class="fl">${ershou1.title }</strong><strong class="fr alignRight">¥${ershou1.saleprice }</strong></div>
    </div><!--in-er-left/-->
    
    
    
    <div class="in-er-right">
      <c:forEach items="${ershoulist }" var="ecz">
     <dl>
      <dt><a href="toshowFangyuan.do?fid=${ecz.fid }"><img src="${fn:split(ecz.pics, ',')[0] }" width="150" height="115" /></a></dt>
      <dd>
       <h3><a href="toshowFangyuan.do?fid=${ecz.fid }">${ecz.title }</a></h3>
       <div class="in-er-right-text">
        ${ecz.description }
       </div>
       <div class="price">¥<strong>${ecz.saleprice }万</strong></div>
      </dd>
      <div class="clears"></div>
     </dl>
     </c:forEach>
     
      
     <div class="clears"></div>
    </div><!--in-er-right/-->
    <div class="clears"></div>
   </div><!--index-ershou/-->
  </div><!--width1190/-->
 </div><!--content/-->
 <jsp:include page="foot.jsp" /> 
</body>
</html>
