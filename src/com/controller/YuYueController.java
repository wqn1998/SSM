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
    
@RequestMapping(value="yuyueadd.do")//�����Ϣ 
public  String  addfrontYuyue(Yuyue  yuyue ,HttpServletRequest request){
		String msg="�����ɹ�";
		yuyue.setCreatetime(new Date());
	 int result=   yd.insertSelective(yuyue);
		 if(result==0){
			  msg="���ʧ��";
		 } 
	msg=  "<script>alert('"+msg+"')</script>"; 
	
	return "toshowFangyuan.do?fid="+yuyue.getFid();
} 
    
    

	 @RequestMapping("showmyyuyue.do")
		public  String  showmyyuyue( Yuyue   yuyue  ,HttpServletRequest request){
	    	YuyueQuery  mq=new YuyueQuery();
	    	Myuser user=  (Myuser)request.getSession().getAttribute("dangqianyonghu");
			    if(user==null){
			    	 request.setAttribute("message", "<script>alert('���ȵ�¼')</script>");
			    	 return "login.jsp";
			    }
			    mq.createCriteria().andUidEqualTo(user.getUid());//���Լ���ԤԼ��Ϣ
			 List<Yuyue> list=  yd.selectByExample(mq); 
			 request.setAttribute("list", list); 
			
			return "yuyuefrontList.jsp";
		} 
    
    
    /////////////////////��˴���/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showYuyue.do")
	public  String  showYuyue( Yuyue   yuyue  ,HttpServletRequest request){
    	YuyueQuery  mq=new YuyueQuery();
		    if(yuyue!=null&&yuyue.getCreatetime()!=null&&!"".equals(yuyue.getCreatetime())){
		    	mq.createCriteria().andCreatetimeGreaterThan(yuyue.getCreatetime());
		    }
		     
		    
		    mq.setPageNo(yuyue.getCurrentPage());
		    mq.setPageSize(yuyue.getSize());
		    
		    int count =yd.countByExample(mq); //��ѯ��¼��
		    yuyue.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Yuyue> list=  yd.selectByExample(mq);
		 request.setAttribute("pager",yuyue); 
		 request.setAttribute("list", list); 
		
		return "yuyueList.jsp";
	}
	
    
    @RequestMapping("back/showMyYuyue.do")//��ѯ��ǰ�����˵�����ԤԼ
   	public  String  showMyYuyue( Yuyue   yuyue  ,HttpServletRequest request){
    	Myuser user=  (Myuser)request.getSession().getAttribute("dangqianyonghu");
	    if(user==null){
	    	 request.setAttribute("message", "<script>alert('���ȵ�¼')</script>");
	    	 return "login.jsp";
	    }
    	//��ѯ��ǰ�����˵�  ���з�Դ   ��״̬�����ѳɽ�
    	 FangyuanQuery fq=new FangyuanQuery();
    	  Criteria  fc=  fq.createCriteria();
    	      fc.andFaburenidEqualTo(user.getUid()).andStatusNotEqualTo("�ѳɽ�");
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
   		    
   		    int count =yd.countByExample(mq); //��ѯ��¼��
   		    yuyue.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
   		    
   		 List<Yuyue> list=  yd.selectByExample(mq);
   		 request.setAttribute("pager",yuyue); 
   		 request.setAttribute("list", list); 
   		
   		return "yuyuemyList.jsp";
   	}
    
    
 
		@RequestMapping(value="back/addYuyue.do",produces="text/html;charset=UTF-8")//�����Ϣ
		@ResponseBody
	public  String  addYuyue(Yuyue  yuyue ,HttpServletRequest request){
			String msg="�����ɹ�";
			yuyue.setCreatetime(new Date());
		 int result=   yd.insertSelective(yuyue);
			 if(result==0){
				  msg="���ʧ��";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	       
	} 
		
	
		@RequestMapping(value="back/delYuyue.do",produces="text/html;charset=UTF-8") //ɾ����Ϣ
		@ResponseBody
   public String  delYuyue(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="�����ɹ�";
			if(ids!=null&&ids.length>0){
			try{
				YuyueQuery gq=new YuyueQuery();
				   gq.createCriteria().andYidIn(Arrays.asList(ids));
				   yd.deleteByExample(gq);  
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
			    yuyue.setReceivetime(new Date());//�ظ�ʱ��
			  int result=   yd.updateByExampleSelective(yuyue, cq);
	          System.out.println("qqqq"); 
			    
	        
	          //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		 
 
		@InitBinder
		public void init(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		}    	
    	 
    
    
	
	
}
