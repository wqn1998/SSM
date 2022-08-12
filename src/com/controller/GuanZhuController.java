package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.BaikeDao;
import com.dao.GuanzhuDao;
import com.dao.MyuserDao;
import com.pojo.Baike;
import com.pojo.BaikeQuery;
import com.pojo.BaikeQuery.Criteria;
import com.pojo.Guanzhu;
import com.pojo.GuanzhuQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery; 

import net.sf.json.JSONObject;

@Controller
public class GuanZhuController {
    @Autowired
	private GuanzhuDao  gd;
	  
    
    
    @RequestMapping("showMyguanzhu.do")
	public  String  showguanzhu( Guanzhu   guanzhu  ,HttpServletRequest request){
    	 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){  
			  request.setAttribute("message", "<script>alert('超时或未登录请重新登录')</script>");
			  return "login.jsp";  
		   } 
		  guanzhu.setUid(user.getUid());   
    	
    	GuanzhuQuery  gq=new GuanzhuQuery();
    	com.pojo.GuanzhuQuery.Criteria  qq=gq.createCriteria();
		     qq.andUidEqualTo(guanzhu.getUid());
		     
		 List<Guanzhu> list=  gd.selectByExample(gq);
	 
		 request.setAttribute("list", list); 
		
		return "guanzhuList.jsp";
	}
	
 
		@RequestMapping(value="guanzhuadd.do")//添加信息
	 
	public  String  addguanzhu(Guanzhu guanzhu ,HttpServletRequest request){
			 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){  
				  request.setAttribute("message", "<script>alert('超时或未登录请重新登录')</script>");
				  return "login.jsp";  
			   } 
			  guanzhu.setUid(user.getUid());   
			  //查询是否已经关注
			  GuanzhuQuery gq=new GuanzhuQuery();
			   gq.createCriteria().andFidEqualTo(guanzhu.getFid()).andUidEqualTo(user.getUid());
			  
			 List l= gd.selectByExample(gq);
			    if(l!=null&&l.size()>0){ 
			    	  request.setAttribute("message", "<script>alert('已关注过');</script>");	 
			    }else{ 
		 int result=  gd.insertSelective(guanzhu);  
		         request.setAttribute("message", "<script>alert('关注成功');</script>");	 
			    }
	          return "toshowFangyuan.do?fid="+guanzhu.getFid();
	}
		
		
		
	
		@RequestMapping("delGuanzhu.do") //删除信息
	 
   public String  delguanzhu(Integer gid ,HttpServletRequest  request){
			 
			String msg="操作成功";
		 
			 
				GuanzhuQuery gq=new GuanzhuQuery();
				   gq.createCriteria().andGidEqualTo(gid);
				   gd.deleteByExample(gq);  
			  return "showMyguanzhu.do";
   }
		
		 
 
    
    
    
	
	
}
