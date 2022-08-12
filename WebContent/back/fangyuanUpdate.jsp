<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html class="x-admin-sm">
    
    <head>
        <meta charset="UTF-8">
        <title>欢迎页面-X-admin2.2</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="./css/font.css">
        <link rel="stylesheet" href="./css/xadmin.css">
        <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="./js/xadmin.js"></script>
        
        <script type="text/javascript" src="./js/jquery.js"></script> 
        <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
        <!--[if lt IE 9]>
            <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
            <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
  
        
        
    </head>
    <body>
    
 
    
    
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" id="myform"  action="updateFangyuan.do" method="post" enctype="multipart/form-data" >
                     <div class="layui-form-item">
                        <label for="L_email" class="layui-form-label">
                            <span class="x-red">*</span>标题</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_email" name="title"  value="${g.title }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                             <input type="hidden" id="L_email" name="fid"  value="${g.fid }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                            <input type="hidden" id="L_email" name="faburenid"  value="${g.faburenid }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                            
                            </div>
                        <div class="layui-form-mid layui-word-aux">
                            <span class="x-red">*</span></div>
                      </div>
                    <div class="layui-form-item">
                        <label for="L_username" class="layui-form-label">
                            <span class="x-red">*</span>售价</label>
                        <div class="layui-input-inline">
                              <input type="text" id="L_email" name="saleprice"  value="${g.saleprice }" required="" lay-verify="x" autocomplete="on" class="layui-input">
                            </div>
                       </div>
                    <div class="layui-form-item">
                        <label for="L_pass" class="layui-form-label">
                            <span class="x-red">*</span>租金</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_pass" name="rentprice" value="${g.rentprice }"  lay-verify="" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux"></div></div>
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>户型</label>
                        <div class="layui-input-inline">
                            <input  type="text"  id="L_repass" name="huxing" value="${g.huxing }"  required="" lay-verify="" autocomplete="off" class="layui-input"></div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>面积</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_repass" name="mianji"  value="${g.mianji }"  required="" lay-verify="" autocomplete="off" class="layui-input"></div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>朝向</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_repass" name="chaoxiang"  value="${g.chaoxiang }"  required="" lay-verify="" autocomplete="off" class="layui-input"></div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>楼层</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_repass" name="louceng"  value="${g.louceng }"  required="" lay-verify="" autocomplete="off" class="layui-input"></div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>装修</label>
                        <div class="layui-input-inline">
                             <select  name="zhuangxiu" class="layui-input">
                            <option value="简单装修" <c:if test="${g.zhuangxiu=='简单装修' }">selected</c:if> >简单装修</option>
                             <option value="中等装修" <c:if test="${g.zhuangxiu=='中等装修' }">selected</c:if> >中等装修</option>
                            <option value="精装修" <c:if test="${g.zhuangxiu=='精装修' }">selected</c:if> >精装修</option>
                            </select> 
                            </div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>类型</label>
                        <div class="layui-input-inline">
                             <select  name="type" class="layui-input">
                            <option value="新房" <c:if test="${g.type=='新房' }">selected</c:if> >新房</option>
                             <option value="二手房" <c:if test="${g.type=='二手房' }">selected</c:if> >二手房</option>
                            <option value="出租房" <c:if test="${g.type=='出租房' }">selected</c:if> >出租房</option>
                            </select>
                            </div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>委托人</label>
                        <div class="layui-input-inline">
                        
                        
                      <select  name="weituorenid" class="layui-input">
                            <option value="${dangqianyonghu.uid }" <c:if test="${g.weituorenid==dangqianyonghu.uid }">selected</c:if> >本人</option>
                            <c:forEach items="${mlist}" var="m">
                             <option value="${m.uid }" <c:if test="${g.weituorenid==m.uid }">selected</c:if> >${m.name}-${m.role}</option>
                            </c:forEach> 
                            </select>

                      </div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>描述信息</label>
                        <div class="layui-input-inline">
                            <textarea   name="description"  cols="80" rows="20"  required="" lay-verify="" autocomplete="off" class="layui-input">${g.description }</textarea></div>
                    </div>
                      <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>区域</label>
                        <div class="layui-input-inline">
                            <select  name="area" class="layui-input">
                            <option value="智慧园" <c:if test="${g.area=='智慧园' }">selected</c:if> >智慧园</option>
                             <option value="立民村" <c:if test="${g.area=='立民村' }">selected</c:if> >立民村</option>
                            <option value="塘口村" <c:if test="${g.area=='塘口村' }">selected</c:if> >塘口村</option>
                            <option value="勤劳村" <c:if test="${g.area=='勤劳村' }">selected</c:if> >勤劳村</option>
                            <option value="芦胜村" <c:if test="${g.area=='芦胜村' }">selected</c:if> >芦胜村</option>
                            <option value="知新村" <c:if test="${g.area=='知新村' }">selected</c:if> >知新村</option>
                             </select>
                            </div> 
                    </div>
                     <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span>状态</label>
                        <div class="layui-input-inline">
                            <select  name="status" class="layui-input">
                            <option value="委托审核" <c:if test="${g.status=='委托审核' }">selected</c:if> >委托审核</option>
                             <option value="未成交" <c:if test="${g.status=='未成交' }">selected</c:if> >未成交</option>
                            <option value="已成交" <c:if test="${g.status=='已成交' }">selected</c:if> >已成交</option>
                              </select>
                            </div>
                             
                    </div>
                    
                    
                    
                     <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"> 
                          </label>
                        <div class="layui-input-inline" id="showtus" > 
                          
                          </div>
                      </div>
                    
                     <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label">
                            <span class="x-red">*</span><input type="button" class="layui-btn" onclick="addtufile()" value="添加图片" lay-submit="">  </label>
                        <div class="layui-input-inline" id="tus" > 
                           <span ><input type="file" name="files"  ><label onclick="del(this)" >删除</label>   </span></div>
                     <input type="hidden" name="pics" value="${g.pics }">
                      </div>
                     
                    
                    <div class="layui-form-item">
                        <label for="L_repass" class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">修改</button></div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //自定义验证规则
                form.verify({
                    nikename: function(value) {
                        if (value.length < 5) {
                            return '昵称至少得5个字符啊';
                        }
                    },
                    pass: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#L_pass').val() != $('#L_repass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });

                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php

var formdata= new FormData($("#myform")[0]);

   $.ajax({
url: 'updateFangyuan.do',
type: 'POST',
dataType:"json",
data: formdata,
processData: false,
contentType : false,
success: function (data) { 
	  
	
      layer.alert(data.msg, {
          icon: 6
      },
      function() {
          //关闭当前frame
          xadmin.close(); 
          // 可以对父窗口进行刷新 
          xadmin.father_reload();
      });
	
	
},
error: function (data) {
	 alert("error"+data.msg);
	
}
})
                    
                    return false;
                });

            });

          function addtufile(){ 
        	 var xx= "<span ><input type=\"file\" name=\"files\"  ><label onclick=\"del(this)\" >删除图片</label>   </span>";      	  
        	  $("#tus").append(xx);
          }
      
          function del(x){
        	  $(x).parent().remove();
          }
          $(function(){
        	 var pics="${g.pics}";
        	 //alert(pics);
        	 var xx="";
        var picarr=	 pics.split(",");
        	 for(var i=0;i<picarr.length;i++){
        		 if(picarr[i]!='' &&picarr[i]!=null){
        		  xx+="<img src=\"<%=basePath%>"+picarr[i]+"\" style='width:150px;height:150px;'>";
        		 }
        	 }
        	 
        	 $("#showtus").append(xx);
        	  
          });
          
         
</script>
        
        
        
        
        <script>var _hmt = _hmt || []; (function() {
                var hm = document.createElement("script");
                hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
                var s = document.getElementsByTagName("script")[0];
                s.parentNode.insertBefore(hm, s);
            })();</script>
    </body>

</html>