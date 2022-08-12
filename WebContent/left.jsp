<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <div class="vip-left">
       <div class="vipNav">
        <h3 class="vipTitle">会员中心</h3>
        <dl>
         <dt class="vipIcon3">账户设置</dt>
          <dd>
           <a href="showfrontMyuser.do?uid=${dangqianyonghu.uid}" class="vipNavCur">我的资料</a>
           <a href="showfrontpwdMyuser.do?uid=${dangqianyonghu.uid}">账户密码设置</a>
          </dd>
         <dt class="vipIcon1">我的邻居大妈</dt>
          <dd>
           <a href="showMyguanzhu.do">关注房源</a>
           <a href="showmyyuyue.do?uid=${dangqianyonghu.uid }">预约记录</a>
           <a href="tofrontAddFangyuan.do">发布房源</a>
           <a href="showfrontFangyuan.do?uid=${dangqianyonghu.uid }">我的房源</a>
           <a href="showfrontjingjiren.do">经纪人</a>
          </dd>
        </dl>
       </div><!--vipNav/-->
    </div><!--vip-left/-->