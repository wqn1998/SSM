package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.FangyuanDao;
import com.dao.MyuserDao;
import com.dao.YuyueDao;
import com.pojo.Fangyuan;
import com.pojo.FangyuanQuery;
import com.pojo.FangyuanQuery.Criteria;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.Yuyue;
import com.pojo.YuyueQuery;

import net.sf.json.JSONObject;

@Controller
public class YuYueController {
    @Autowired
	private MyuserDao  md;
    
    @Autowired
    private FangyuanDao fd;
	
    @Autowired
	private YuyueDao  yd; 
    
@RequestMapping(value="yuyueadd.do")//添加信息 
public  String  addfrontYuyue(Yuyue  yuyue ,HttpServletRequest request){
		String msg="操作成功";
		yuyue.setCreatetime(new Date());
	 int result=   yd.insertSelective(yuyue);
		 if(result==0){
			  msg="添加失败";
		 } 
	msg=  "<script>alert('"+msg+"')</script>"; 
	
	return "toshowFangyuan.do?fid="+yuyue.getFid();
} 
    
    

	 @RequestMapping("showmyyuyue.do")
		public  String  showmyyuyue( Yuyue   yuyue  ,HttpServletRequest request){
	    	YuyueQuery  mq=new YuyueQuery();
	    	Myuser user=  (Myuser)request.getSession().getAttribute("dangqianyonghu");
			    if(user==null){
			    	 request.setAttribute("message", "<script>alert('请先登录')</script>");
			    	 return "login.jsp";
			    }
			    mq.createCriteria().andUidEqualTo(user.getUid());//查自己的预约信息
			 List<Yuyue> list=  yd.selectByExample(mq); 
			 request.setAttribute("list", list); 
			
			return "yuyuefrontList.jsp";
		} 
    
    
    /////////////////////后端处理/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showYuyue.do")
	public  String  showYuyue( Yuyue   yuyue  ,HttpServletRequest request){
    	YuyueQuery  mq=new YuyueQuery();
		    if(yuyue!=null&&yuyue.getCreatetime()!=null&&!"".equals(yuyue.getCreatetime())){
		    	mq.createCriteria().andCreatetimeGreaterThan(yuyue.getCreatetime());
		    }
		     
		    
		    mq.setPageNo(yuyue.getCurrentPage());
		    mq.setPageSize(yuyue.getSize());
		    
		    int count =yd.countByExample(mq); //查询记录数
		    yuyue.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Yuyue> list=  yd.selectByExample(mq);
		 request.setAttribute("pager",yuyue); 
		 request.setAttribute("list", list); 
		
		return "yuyueList.jsp";
	}
	
    
    @RequestMapping("back/showMyYuyue.do")//查询当前经纪人的所有预约
   	public  String  showMyYuyue( Yuyue   yuyue  ,HttpServletRequest request){
    	Myuser user=  (Myuser)request.getSession().getAttribute("dangqianyonghu");
	    if(user==null){
	    	 request.setAttribute("message", "<script>alert('请先登录')</script>");
	    	 return "login.jsp";
	    }
    	//查询当前经纪人的  所有房源   且状态不是已成交
    	 FangyuanQuery fq=new FangyuanQuery();
    	  Criteria  fc=  fq.createCriteria();
    	      fc.andFaburenidEqualTo(user.getUid()).andStatusNotEqualTo("已成交");
    	      fq.or().andWeituorenidEqualTo(user.getUid());
    	 
    	  List<Fangyuan> flist=    fd.selectByExample(fq);
    	      
    	      
       	YuyueQuery  mq=new YuyueQuery();
       com.pojo.YuyueQuery.Criteria c=	mq.createCriteria();
   		    if(yuyue!=null&&yuyue.getCreatetime()!=null&&!"".equals(yuyue.getCreatetime())){
   		    	c.andCreatetimeGreaterThan(yuyue.getCreatetime());
   		    }
   		      List<Integer> ilist=new ArrayList<>();
   		      
   		     for(Fangyuan f:flist){
   		    	 ilist.add(f.getFid());
   		     }
   		  c.andFidIn(ilist) ;
   		    
   		    mq.setPageNo(yuyue.getCurrentPage());
   		    mq.setPageSize(yuyue.getSize());
   		    
   		    int count =yd.countByExample(mq); //查询记录数
   		    yuyue.setTotalCount(count); //设置查询出来的总记录条数
   		    
   		 List<Yuyue> list=  yd.selectByExample(mq);
   		 request.setAttribute("pager",yuyue); 
   		 request.setAttribute("list", list); 
   		
   		return "yuyuemyList.jsp";
   	}
    
    
 
		@RequestMapping(value="back/addYuyue.do",produces="text/html;charset=UTF-8")//添加信息
		@ResponseBody
	public  String  addYuyue(Yuyue  yuyue ,HttpServletRequest request){
			String msg="操作成功";
			yuyue.setCreatetime(new Date());
		 int result=   yd.insertSelective(yuyue);
			 if(result==0){
				  msg="添加失败";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	       
	} 
		
	
		@RequestMapping(value="back/delYuyue.do",produces="text/html;charset=UTF-8") //删除信息
		@ResponseBody
   public String  delYuyue(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="操作成功";
			if(ids!=null&&ids.length>0){
			try{
				YuyueQuery gq=new YuyueQuery();
				   gq.createCriteria().andYidIn(Arrays.asList(ids));
				   yd.deleteByExample(gq);  
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
		@RequestMapping("back/toupdateYuyue.do")
   	  public String  showOneYuyue(Integer yid,HttpServletRequest  request){
			Yuyue g=    yd.selectByPrimaryKey(yid);
		   		     request.setAttribute("g", g);  
		   		     return "yuyueUpdate.jsp"; 
		}
		
		@RequestMapping(value="back/updateYuyue.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updateYuyue(Yuyue  yuyue,HttpServletRequest request){ 
			
			YuyueQuery cq=new YuyueQuery();
			    cq.createCriteria().andYidEqualTo(yuyue.getYid());
			    yuyue.setReceivetime(new Date());//回复时间
			  int result=   yd.updateByExampleSelective(yuyue, cq);
	          System.out.println("qqqq"); 
			    
	        
	          //将要被返回到客户端的对象
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "操作成功"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		 
 
		@InitBinder
		public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}    	
    	 
    
    
	
	
}
