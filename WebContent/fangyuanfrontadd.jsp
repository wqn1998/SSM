<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="head.jsp" %>


<div class="content">
  <div class="width1190">
 <%@include file="left.jsp" %> 
 
 <script>
 function checktijiao(){
		var title= document.getElementById("title");
		var huxing= document.getElementById("huxing");
	
		 if(title.value==''){
			  alert("请输入标题");
			 return false;
		 }
		 if(huxing.value==''){
			  alert("请输入户型");
			 return false;
		 }
	 
		 
	 }
 
 </script>
 
    
    <form action="addfrontFangyuan.do"  enctype="multipart/form-data"  method="post">
    <div class="vip-right">
     <h3 class="vipright-title">添加房源</h3>
    <!--vip-touxiang/-->
    
     <table class="grinfo">
        <tbody>
        
        <tr>
        <th>标题：</th>
        <td>  
         <input class="inp inw" id="title" type="text" name="title"   value="${g.title }" maxlength="14"> 
        </td>
        </tr>
        <tr>
        <th><span class="red">*</span> 售价：</th>
        <td>
        <input class="inp inw" type="text" name="saleprice"  value="${g.saleprice }"  maxlength="14">
        </td>
        </tr>
        <tr>
        <th><span class="red"></span> 租金</th>
        <td>
          <input class="inp inw" type="text" name="rentprice" value="${g.rentprice }"   maxlength="14">
          </td>
        </tr>
        <tr>
        <th><span class="red"></span> 户型：</th>
        <td>
        <input class="inp inw" type="text" id="huxing"  name="huxing" value="${g.huxing }"  maxlength="14">
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 面积：</th>
        <td>
        <input class="inp inw" type="text"  name="mianji"  value="${g.mianji }" maxlength="14">
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 朝向：</th>
        <td>
        <input class="inp inw" type="text"  name="chaoxiang"  value="${g.chaoxiang }" maxlength="14">
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 楼层：</th>
        <td>
        <input class="inp inw" type="text"  name="louceng"  value="${g.louceng }"  maxlength="14">
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 装修：</th>
        <td>
         <select  name="zhuangxiu"  >
                            <option value="简单装修" <c:if test="${g.zhuangxiu=='简单装修' }">selected</c:if> >简单装修</option>
                             <option value="中等装修" <c:if test="${g.zhuangxiu=='中等装修' }">selected</c:if> >中等装修</option>
                            <option value="精装修" <c:if test="${g.zhuangxiu=='精装修' }">selected</c:if> >精装修</option>
                            </select> 
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 类型：</th>
        <td>
         <select  name="type" class="layui-input">
                            <option value="新房" <c:if test="${g.type=='新房' }">selected</c:if> >新房</option>
                             <option value="二手房" <c:if test="${g.type=='二手房' }">selected</c:if> >二手房</option>
                            <option value="出租房" <c:if test="${g.type=='出租房' }">selected</c:if> >出租房</option>
                            </select>
           </td>
        </tr>
        <tr>
        <th><span class="red"></span> 委托人：</th>
        <td>
        <select  name="weituorenid" class="layui-input">
                            <option value="${dangqianyonghu.uid }" <c:if test="${g.weituorenid==dangqianyonghu.uid }">selected</c:if> >本人</option>
                            <c:forEach items="${mlist}" var="m">
                             <option value="${m.uid }" <c:if test="${g.weituorenid==m.uid }">selected</c:if> >${m.name}-${m.role}</option>
                            </c:forEach> 
                            </select>
                            <br>
        <span class="fgrey">此处默认是本人发布可以直接在主页面看到不需要审核<br>如果选择其他委托人则需要管理员审核才能显示</span>
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 描述信息：</th>
        <td>
       <textarea  name="description"  cols="60" rows="50"    class="grtextarea"></textarea>
        <br>
        <span class="fgrey"> </span>
         </td>
        </tr>
         <tr>
        <th><span class="red"></span> 区域：</th>
        <td>
        <select  name="area" class="layui-input">
                            <option value="智慧园" <c:if test="${g.area=='智慧园' }">selected</c:if> >智慧园</option>
                             <option value="立民村" <c:if test="${g.area=='立民村' }">selected</c:if> >立民村</option>
                            <option value="塘口村" <c:if test="${g.area=='塘口村' }">selected</c:if> >塘口村</option>
                            <option value="勤劳村" <c:if test="${g.area=='勤劳村' }">selected</c:if> >勤劳村</option>
                            <option value="芦胜村" <c:if test="${g.area=='芦胜村' }">selected</c:if> >芦胜村</option>
                            <option value="知新村" <c:if test="${g.area=='知新村' }">selected</c:if> >知新村</option>
                             </select> </td>
        </tr>
         <tr>
        <th><span class="red"></span> </th>
        <td>
            <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span><input type="button" class="layui-btn" onclick="addtufile()" value="添加图片" lay-submit="">  </label>
                        <br/>
                        <div class="layui-input-inline" id="tus" > 
                           <span ><input type="file" name="files"  ><label onclick="del(this)" >删除图片</label>   </span>
                           </div>
         </td>
        </tr>
         
        
        
        
        
        
        
        
     
        
        
      
        
        <tr>
        <th>&nbsp;</th>
        <td colspan="2">
        <label class="butt" id="butt">
        <input type="submit"   onclick="return checktijiao()"  class="member_mod_buttom" value="提交" />
        </label>
        </td>
        </tr>
        </tbody>
     </table>
    </div><!--vip-right/-->
     </form>
    <div class="clearfix"></div>
  </div><!--width1190/-->
 </div><!--content/-->
 <script type="text/javascript">
 function addtufile(){ 
	 var xx= "<br><span ><input type=\"file\" name=\"files\"  ><label onclick=\"del(this)\" >删除图片</label>   </span>";      	  
	  $("#tus").append(xx);
  }

  function del(x){
	  $(x).parent().remove();
  }  
</script>

 <div class="xinren">
  <div class="width1190">
   <dl style="background:url(images/icon1.jpg) left center no-repeat;">
    <dt>承诺</dt>
    <dd>真实可信100%真房源<br />链家承诺，假一赔百</dd>
   </dl>
   <dl style="background:url(images/icon2.jpg) left center no-repeat;">
    <dt>权威</dt>
    <dd>独家房源 覆盖全城<br />房源信息最权威覆盖最广</dd>
   </dl>
   <dl style="background:url(images/icon3.jpg) left center no-repeat;">
    <dt>信赖</dt>
    <dd>万名置业顾问 专业服务<br />百万家庭的信赖之选</dd>
   </dl>
   <dl style="background:url(images/icon4.jpg) left center no-repeat;">
    <dt>安全</dt>
    <dd>安心承诺 保驾护航<br />多重风险防范机制 无后顾之忧</dd>
   </dl>
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--xinren/-->
 <div class="footer">
  <div class="width1190">
   <div class="fl"><a href="index.do"><strong>邻居大妈</strong></a><!-- <a href="about.html">关于我们</a><a href="contact.html">联系我们</a> --></div>
   <div class="fr">
    <dl>
     <dt><img src="images/erweima.png" width="76" height="76" /></dt>
     <dd>微信扫一扫<br />房价点评，精彩发布</dd>
    </dl>
    <dl>
     <dt><img src="images/erweima.png" width="76" height="76" /></dt>
     <dd>微信扫一扫<br />房价点评，精彩发布</dd>
    </dl>
    <div class="clears"></div>
   </div>
   <div class="clears"></div>
  </div><!--width1190/-->
 </div><!--footer/-->
 <div class="copy">Copyright@ 2015 邻居大妈 版权所有 沪ICP备1234567号-0&nbsp;&nbsp;&nbsp;&nbsp;技术支持：<a target="_blank" href="http://www.webqin.net/">秦王网络</a> </div>
 

</body>
</html>