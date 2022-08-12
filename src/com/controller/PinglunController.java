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

import com.dao.MyuserDao;
import com.dao.PinglunDao;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Pinglun;
import com.pojo.PinglunQuery;

import net.sf.json.JSONObject;

@Controller
public class PinglunController {
    @Autowired
	private PinglunDao  pd; 
    
    
    
	@RequestMapping(value="addfrontpinglun.do")//前台添加评论信息 
public  String  addfrontPinglun(Pinglun  pinglun ,HttpServletRequest request){
		 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){  
			  request.setAttribute("message", "<script>alert('超时或未登录请重新登录')</script>");
			  return "login.jsp";  
		   } 
		pinglun.setUid(user.getUid());
		pinglun.setCreatetime(new Date()); 
		String msg="操作成功";
	 int result=   pd.insertSelective(pinglun);
		 if(result==0){
			  msg="操作失败";
		 }
		 request.setAttribute("message", "<script>alert(\""+msg+"\")</script>");
		 return "redirect:toshowFangyuan.do?fid="+pinglun.getFid();
 
} 
    
    
    
    
    
    /////////////////////后端处理/////////////////////////////////////////////////////////////////   
     
    
    @RequestMapping("back/showPinglun.do")
	public  String  showEmployee( Pinglun   pinglun  ,HttpServletRequest request){
    	PinglunQuery  mq=new PinglunQuery();
		    if(pinglun!=null&&pinglun.getContent()!=null&&!"".equals(pinglun.getContent())){
		    	mq.createCriteria().andContentLike("%"+pinglun.getContent()+"%");
		    }
		    
		    mq.setPageNo(pinglun.getCurrentPage());
		    mq.setPageSize(pinglun.getSize());
		    
		    int count =pd.countByExample(mq); //查询记录数
		    pinglun.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Pinglun> list=  pd.selectByExample(mq);
		 request.setAttribute("pager",pinglun); 
		 request.setAttribute("list", list); 
		
		return "pinglunList.jsp";
	}
	
 
		@RequestMapping(value="back/addPinglun.do",produces="text/html;charset=UTF-8")//添加信息
		@ResponseBody
	public  String  addPinglun(Pinglun  pinglun ,HttpServletRequest request){
			 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				  JSONObject json=new JSONObject();
		          json.accumulate("success", "success");
		          json.accumulate("msg", "登录超时请重新登录"); 
		          json.accumulate("url", "login.jsp"); 
		           System.out.println("json::"+json.toString());
				  return json.toString();  
			   } 
			pinglun.setUid(user.getUid());
			pinglun.setCreatetime(new Date());
			
			String msg="操作成功";
		 int result=   pd.insertSelective(pinglun);
			 if(result==0){
				  msg="添加失败";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	        // return "result.jsp";
	} 
		
		
		@RequestMapping(value="back/delPinglun.do",produces="text/html;charset=UTF-8") //删除信息
		@ResponseBody
   public String  delPinglun(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="操作成功";
			if(ids!=null&&ids.length>0){
			try{
				PinglunQuery gq=new PinglunQuery();
				   gq.createCriteria().andPidIn(Arrays.asList(ids));
				   pd.deleteByExample(gq);  
			}catch(Exception e){
				msg="数据存在依赖关系不能删除请删除新增加的信息";
			}
			}
			
			JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
   }
		@RequestMapping("back/toupdatePinglun.do")
   	  public String  showOnePinglun(Integer pid,HttpServletRequest  request){
			Pinglun g=    pd.selectByPrimaryKey(pid);
		   		     request.setAttribute("g", g);  
		   		     return "pinglunUpdate.jsp"; 
		}
		
		
			@RequestMapping("back/tohuifuPinglun.do")
	   	  public String  tohuifuPinglun(Integer pid,HttpServletRequest  request){
				Pinglun g=    pd.selectByPrimaryKey(pid);
			   		     request.setAttribute("g", g);  
			   		     return "pinglunHuifu.jsp"; 
			}
		
		
		
		
		@RequestMapping(value="back/updatePinglun.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updatePinglun(Pinglun  pinglun,HttpServletRequest request){ 
			
			PinglunQuery cq=new PinglunQuery();
			    cq.createCriteria().andPidEqualTo(pinglun.getPid());
			  int result=   pd.updateByExampleSelective(pinglun, cq);
	          System.out.println("qqqq"); 
			   
	        //  return "redirect:showPinglun.do";
	          
	          
	        
	          //将要被返回到客户端的对象
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "操作成功"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		
 
    
    
    
	
	
}
