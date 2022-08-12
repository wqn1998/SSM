package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
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
import com.dao.HetongDao;
import com.dao.MyuserDao;
import com.pojo.Baike;
import com.pojo.BaikeQuery;
import com.pojo.BaikeQuery.Criteria;
import com.pojo.Hetong;
import com.pojo.HetongQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery; 

import net.sf.json.JSONObject;

@Controller
public class HetongController {
    @Autowired
	private HetongDao  hd;
    
	
    @RequestMapping("showfrontHetong.do")//ǰ̨չʾ��ͬ
   	public  String  showfrontHetong( Hetong   hetong  ,HttpServletRequest request){
       	HetongQuery  mq=new HetongQuery();
         
   		 List<Hetong> list=  hd.selectByExample(mq); 
   		 request.setAttribute("list", list); 
   		
   		return "hetongfrontList.jsp";
   	}
    
    @RequestMapping("xiazai.do")
    public  void download(Hetong ht,
    		HttpServletRequest request, HttpServletResponse response) 
    		throws Exception { 
    	String path=  request.getSession().getServletContext().getRealPath("/uploadhetong");//��ȡ �ļ��е�·��
		  System.out.println("path:::::"+path); 
		 
		 
		   String fname=ht.getPath();
		    System.out.println("xiazaiffname"+fname);
		   File f=new File(path+"\\"+fname);//���ļ��ϴ��� ��Ӧ��λ��  
		   
    	
    		    //������Ӧͷ�Ϳͻ��˱����ļ���
    		    response.setCharacterEncoding("utf-8");
    		    response.setContentType("multipart/form-data");
    		    response.setHeader("Content-Disposition", "attachment;fileName=demo" + URLEncoder.encode(fname, "UTF-8"));
    		    //���ڼ�¼����ɵ����ص�����������λ��byte
    		    long downloadedLength = 0l;
    		    try {
    		        //�򿪱����ļ���
    		        InputStream inputStream = new FileInputStream(f);
    		        //�������ز���
    		        OutputStream os = response.getOutputStream();

    		        //ѭ��д�������
    		        byte[] b = new byte[2048];
    		        int length;
    		        while ((length = inputStream.read(b)) > 0) {
    		            os.write(b, 0, length);
    		            downloadedLength += b.length;
    		        }
    		        // ������Ҫ�رա�
    		        os.close();
    		        inputStream.close();
    		    } catch (Exception e){
    		       
    		        throw e;
    		    }
    		    
    		    
    		  
    		}
    
    


    
    
    
    
    /////////////////////��˴���/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showHetong.do")
	public  String  showHetong( Hetong   hetong  ,HttpServletRequest request){
    	HetongQuery  mq=new HetongQuery();
    	  
    	 if(hetong!=null&&hetong.getTitle()!=null&&!"".equals(hetong.getTitle())){
		    	mq.createCriteria().andTitleLike("%"+hetong.getTitle()+"%");
		    	}
    	
    	    mq.setPageNo(hetong.getCurrentPage());
		    mq.setPageSize(hetong.getSize());
		    
		    int count =hd.countByExample(mq); //��ѯ��¼��
		    hetong.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Hetong> list=  hd.selectByExample(mq);
		 request.setAttribute("pager",hetong); 
		 request.setAttribute("list", list); 
		
		return "hetongList.jsp";
	}
	
 
		@RequestMapping(value="back/addHetong.do",produces="text/html;charset=UTF-8")//�����Ϣ
		@ResponseBody
	public  String  addHetong(@RequestParam("file") CommonsMultipartFile file,Hetong  hetong ,HttpServletRequest request){
			 System.out.println(hetong.getTitle());
			 System.out.println(hetong.getPath());
			String msg="�����ɹ�";
			String path=  request.getSession().getServletContext().getRealPath("/uploadhetong");//��ȡ �ļ��е�·��
			  System.out.println("path:::::"+path); 
			 
			  if(!file.isEmpty()){
			   String fname=file.getOriginalFilename();//��ȡ�ϴ��ļ����� 
			    
			   File f=new File(path+"\\"+fname);//���ļ��ϴ��� ��Ӧ��λ��
			    try {
			    	file.transferTo(f);
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    hetong.setPath(fname);//���ļ�����
			  }else{
				  hetong.setPath(null); 
			  }	 
		 int result=  hd.insertSelective(hetong);
			 if(result==0){
				  msg="���ʧ��";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	         // return "�����ɹ�";
	           // return "result.jsp";
	}
		 
	
		@RequestMapping(value="back/delHetong.do",produces="text/html;charset=UTF-8") //ɾ����Ϣ
		@ResponseBody
   public String  delHetong(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="�����ɹ�";
			if(ids!=null&&ids.length>0){
			try{
				HetongQuery gq=new HetongQuery();
				   gq.createCriteria().andHidIn(Arrays.asList(ids));
				   hd.deleteByExample(gq);  
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
		 
	
}
