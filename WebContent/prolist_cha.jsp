<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>
<script src="js/jquery.js"></script>
<script>
function type1(vv){
	//alert(vv);
	$("#type1").val(vv);
}
function area(vv){
	$("#area").val(vv);
}
function mianji(vv){
	$("#mianji").val(vv);
}
function huxing(vv){
	$("#huxing").val(vv);
}

function money1(vv){
	
	if(vv==''){//空串处理
		$("#startmoney").val('');
		$("#endmoney").val('');
	}else{
		var xx=vv.split("-");
		//alert(xx[0]);
		$("#startmoney").val(xx[0]);
		$("#endmoney").val(xx[1]); 
	}
	
}

</script>
 <div class="content">
  <div class="width1190">
   <form action="showfronttiaojianFangyuan.do" method="post" class="pro-search">
   <input type="hidden" value="${type }" id="type1"  name="type">
   <input type="hidden" value="${area }" id="area"  name="area">
    <input type="hidden" value="${mianji }" id="mianji"  name="mianji">
    <input type="hidden" value="${huxing }" id="huxing"  name="huxing">  
    <table>
    <tr>
      <th>房源类型：</th>
      <td>
       <a href="javascript:;" onclick="type1('')" <c:if test="${type=='' || type==null }"> class="pro-cur"</c:if>>不限</a>
       <a href="javascript:" onclick="type1('出租房')"  <c:if test="${type=='出租房'  }" > class="pro-cur"</c:if>  >出租房</a>
       <a href="javascript:;"  onclick="type1('新房')"  <c:if test="${type=='新房'  }"> class="pro-cur"</c:if>    >新房</a>
       <a href="javascript:;"  onclick="type1('二手房')"  <c:if test="${type=='二手房'  }"> class="pro-cur"</c:if>    >二手房</a> 
      </td>
     </tr>    
     <tr>
      <th>房源区域：</th>
      <td>
       <a href="javascript:;" onclick="area('')"  <c:if test="${area=='' || area==null  }"> class="pro-cur"</c:if> >不限</a>
       <a href="javascript:;" onclick="area('智慧园')"  <c:if test="${area=='智慧园'  }"> class="pro-cur"</c:if> >智慧园</a>
       <a href="javascript:;" onclick="area('立民村')"  <c:if test="${area=='立民村'  }"> class="pro-cur"</c:if> >立民村</a>
       <a href="javascript:;" onclick="area('塘口村')"  <c:if test="${area=='塘口村'  }"> class="pro-cur"</c:if>  >塘口村</a>
       <a href="javascript:;" onclick="area('勤劳村')"  <c:if test="${area=='勤劳村'  }"> class="pro-cur"</c:if> >勤劳村</a>
       <a href="javascript:;" onclick="area('芦胜村')"  <c:if test="${area=='芦胜村'  }"> class="pro-cur"</c:if> >芦胜村</a>
       <a href="javascript:;" onclick="area('知新村')"  <c:if test="${area=='知新村'  }"> class="pro-cur"</c:if> >知新村</a>
      </td>
     </tr>
     <tr>
      <th>价格：</th>
      <td>
       <a href="javascript:;"  onclick="money1('')"  <c:if test="${money=='-' || money=='null-null'  }"> class="pro-cur"</c:if>>不限</a>
       <a href="javascript:;"  onclick="money1('500-1000')"  <c:if test="${money=='500-1000'  }"> class="pro-cur"</c:if>     >500-1000</a>
       <a href="javascript:;"  onclick="money1('1001-2000')"  <c:if test="${money=='1001-2000'  }"> class="pro-cur"</c:if>     >1001-2000</a>
       <a href="javascript:;"  onclick="money1('2001-3000')"  <c:if test="${money=='2001-3000'  }"> class="pro-cur"</c:if>     >2001-3000</a>
       <a href="javascript:;"  onclick="money1('3001-4000')"  <c:if test="${money=='3001-4000'  }"> class="pro-cur"</c:if>     >3001-4000</a>
       <input type="text" id="startmoney" name="startmoney" value="${startmoney }" class="protext" /> - <input type="text"  id="endmoney" name="endmoney" value="${endmoney }" class="protext" /> 元 
       <input type="submit" class="proSub"  value="确定" />
      </td>
     </tr>
     <tr>
      <th>面积：</th>
      <td>
       <a href="javascript:;" onclick="mianji('')"  <c:if test="${mianji=='' || mianji==null  }"> class="pro-cur"</c:if>>不限</a>
       <a href="javascript:;"  onclick="mianji('1~10')"  <c:if test="${mianji=='1~10'  }"> class="pro-cur"</c:if> >10平方</a>
       <a href="javascript:;"  onclick="mianji('20~40')"  <c:if test="${mianji=='20~40'  }"> class="pro-cur"</c:if>>20-40平方</a>
       <a href="javascript:;"  onclick="mianji('41~60')"  <c:if test="${mianji=='41~60'  }"> class="pro-cur"</c:if>>41-60平方</a>
       <a href="javascript:;"  onclick="mianji('61~80')"  <c:if test="${mianji=='61~80'  }"> class="pro-cur"</c:if>>61-80平方</a>
       <a href="javascript:;"  onclick="mianji('100~999')"  <c:if test="${mianji=='100~999'  }"> class="pro-cur"</c:if>>100平方以上</a>
      </td>
     </tr>
     <tr>
      <th>房型：</th>
      <td>
       <a href="javascript:;" onclick="huxing('')"  <c:if test="${huxing=='' || huxing==null  }"> class="pro-cur"</c:if> >不限</a>
       <a href="javascript:;" onclick="huxing('一室一厅')"  <c:if test="${huxing=='一室一厅'  }"> class="pro-cur"</c:if>  >一室一厅</a>
       <a href="javascript:;" onclick="huxing('两室一厅')"  <c:if test="${huxing=='两室一厅'  }"> class="pro-cur"</c:if>  >两室一厅</a>
       <a href="javascript:;" onclick="huxing('三室一厅')"  <c:if test="${huxing=='三室一厅'  }"> class="pro-cur"</c:if>   >三室一厅</a>
       <a href="javascript:;" onclick="huxing('三室二厅二卫')"  <c:if test="${huxing=='三室二厅二卫'  }"> class="pro-cur"</c:if>  >三室二厅二卫</a>
       <a href="javascript:;" onclick="huxing('四室二厅二卫')"  <c:if test="${huxing=='四室二厅二卫'  }"> class="pro-cur"</c:if>  >四室二厅二卫</a>
      </td>
     </tr>
    </table>
     
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
      <div class="pra-fa">发布人：${g.faburen.name } 委托人:${g.weituoren.name } 发布时间：<fmt:formatDate value="${g.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /> </div>
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
    <h2 class="right-title">猜你喜欢</h2>
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