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
    
    
    
	@RequestMapping(value="addfrontpinglun.do")//ǰ̨���������Ϣ 
public  String  addfrontPinglun(Pinglun  pinglun ,HttpServletRequest request){
		 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){  
			  request.setAttribute("message", "<script>alert('��ʱ��δ��¼�����µ�¼')</script>");
			  return "login.jsp";  
		   } 
		pinglun.setUid(user.getUid());
		pinglun.setCreatetime(new Date()); 
		String msg="�����ɹ�";
	 int result=   pd.insertSelective(pinglun);
		 if(result==0){
			  msg="����ʧ��";
		 }
		 request.setAttribute("message", "<script>alert(\""+msg+"\")</script>");
		 return "redirect:toshowFangyuan.do?fid="+pinglun.getFid();
 
} 
    
    
    
    
    
    /////////////////////��˴���/////////////////////////////////////////////////////////////////   
     
    
    @RequestMapping("back/showPinglun.do")
	public  String  showEmployee( Pinglun   pinglun  ,HttpServletRequest request){
    	PinglunQuery  mq=new PinglunQuery();
		    if(pinglun!=null&&pinglun.getContent()!=null&&!"".equals(pinglun.getContent())){
		    	mq.createCriteria().andContentLike("%"+pinglun.getContent()+"%");
		    }
		    
		    mq.setPageNo(pinglun.getCurrentPage());
		    mq.setPageSize(pinglun.getSize());
		    
		    int count =pd.countByExample(mq); //��ѯ��¼��
		    pinglun.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Pinglun> list=  pd.selectByExample(mq);
		 request.setAttribute("pager",pinglun); 
		 request.setAttribute("list", list); 
		
		return "pinglunList.jsp";
	}
	
 
		@RequestMapping(value="back/addPinglun.do",produces="text/html;charset=UTF-8")//�����Ϣ
		@ResponseBody
	public  String  addPinglun(Pinglun  pinglun ,HttpServletRequest request){
			 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				  JSONObject json=new JSONObject();
		          json.accumulate("success", "success");
		          json.accumulate("msg", "��¼��ʱ�����µ�¼"); 
		          json.accumulate("url", "login.jsp"); 
		           System.out.println("json::"+json.toString());
				  return json.toString();  
			   } 
			pinglun.setUid(user.getUid());
			pinglun.setCreatetime(new Date());
			
			String msg="�����ɹ�";
		 int result=   pd.insertSelective(pinglun);
			 if(result==0){
				  msg="���ʧ��";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	        // return "result.jsp";
	} 
		
		
		@RequestMapping(value="back/delPinglun.do",produces="text/html;charset=UTF-8") //ɾ����Ϣ
		@ResponseBody
   public String  delPinglun(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="�����ɹ�";
			if(ids!=null&&ids.length>0){
			try{
				PinglunQuery gq=new PinglunQuery();
				   gq.createCriteria().andPidIn(Arrays.asList(ids));
				   pd.deleteByExample(gq);  
			}catch(Exception e){
				msg="���ݴ���������ϵ����ɾ����ɾ�������ӵ���Ϣ";
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
	          
	          
	        
	          //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		
 
    
    
    
	
	
}
