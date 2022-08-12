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
import com.dao.MyuserDao;
import com.pojo.Baike;
import com.pojo.BaikeQuery;
import com.pojo.BaikeQuery.Criteria;
import com.pojo.Myuser;
import com.pojo.MyuserQuery; 

import net.sf.json.JSONObject;

@Controller
public class BaikeController {
    @Autowired
	private BaikeDao  bd;
	
    @RequestMapping("showfrontBaike.do")
   	public  String  showfrontBaike( Baike   baike  ,HttpServletRequest request){
       	BaikeQuery  mq=new BaikeQuery();
       	Criteria  qq=mq.createCriteria();
   		       mq.setOrderByClause(" createtime desc ");
   		   
   		 List<Baike> list=  bd.selectByExample(mq);
   		 
   		 request.setAttribute("list", list); 
   		
   		return "baikefrontList.jsp";
   	}
    
    
    


    
    
    
    
    /////////////////////��˴���/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showBaike.do")
	public  String  showBaike( Baike   baike  ,HttpServletRequest request){
    	BaikeQuery  mq=new BaikeQuery();
    	Criteria  qq=mq.createCriteria();
		    if(baike!=null&&baike.getTitle()!=null&&!"".equals(baike.getTitle())){
		    	qq.andTitleLike("%"+baike.getTitle()+"%");
		    }
		    if(baike!=null&&baike.getDaan()!=null&&!"".equals(baike.getDaan())){
		    	qq.andDaanLike("%"+baike.getDaan()+"%");
		    	}
		    mq.setPageNo(baike.getCurrentPage());
		    mq.setPageSize(baike.getSize());
		    
		    int count =bd.countByExample(mq); //��ѯ��¼��
		    baike.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Baike> list=  bd.selectByExample(mq);
		 request.setAttribute("pager",baike); 
		 request.setAttribute("list", list); 
		
		return "baikeList.jsp";
	}
	
 
		@RequestMapping(value="back/addBaike.do",produces="text/html;charset=UTF-8")//�����Ϣ
		@ResponseBody
	public  String  addBaike(Baike  baike ,HttpServletRequest request){
			String msg="�����ɹ�";
			baike.setCreatetime(new Date());
		 int result=  bd.insertSelective(baike);
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
		
		
		
	
		@RequestMapping(value="back/delBaike.do",produces="text/html;charset=UTF-8") //ɾ����Ϣ
		@ResponseBody
   public String  delBaike(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="�����ɹ�";
			if(ids!=null&&ids.length>0){
			try{
				BaikeQuery gq=new BaikeQuery();
				   gq.createCriteria().andBidIn(Arrays.asList(ids));
				   bd.deleteByExample(gq);  
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
		@RequestMapping("back/toupdateBaike.do")
   	  public String  showOneBaike(Integer bid,HttpServletRequest  request){
			Baike g=    bd.selectByPrimaryKey(bid);
		   		     request.setAttribute("g", g);  
		   		     return "baikeUpdate.jsp"; 
		}
		
		@RequestMapping(value="back/updateBaike.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updateBaike(Baike  baike,HttpServletRequest request){ 
			
			BaikeQuery cq=new BaikeQuery();
			    cq.createCriteria().andBidEqualTo(baike.getBid());
			  int result=   bd.updateByExampleSelective(baike, cq);
	          System.out.println("qqqq"); 
			   
	        //  return "redirect:showBaike.do";
	          
	          
	        
	          //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		 
 
    
    
    
	
	
}
