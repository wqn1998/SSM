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
    
	
    @RequestMapping("showfrontHetong.do")//前台展示合同
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
    	String path=  request.getSession().getServletContext().getRealPath("/uploadhetong");//获取 文件夹的路径
		  System.out.println("path:::::"+path); 
		 
		 
		   String fname=ht.getPath();
		    System.out.println("xiazaiffname"+fname);
		   File f=new File(path+"\\"+fname);//将文件上传到 对应的位置  
		   
    	
    		    //设置响应头和客户端保存文件名
    		    response.setCharacterEncoding("utf-8");
    		    response.setContentType("multipart/form-data");
    		    response.setHeader("Content-Disposition", "attachment;fileName=demo" + URLEncoder.encode(fname, "UTF-8"));
    		    //用于记录以完成的下载的数据量，单位是byte
    		    long downloadedLength = 0l;
    		    try {
    		        //打开本地文件流
    		        InputStream inputStream = new FileInputStream(f);
    		        //激活下载操作
    		        OutputStream os = response.getOutputStream();

    		        //循环写入输出流
    		        byte[] b = new byte[2048];
    		        int length;
    		        while ((length = inputStream.read(b)) > 0) {
    		            os.write(b, 0, length);
    		            downloadedLength += b.length;
    		        }
    		        // 这里主要关闭。
    		        os.close();
    		        inputStream.close();
    		    } catch (Exception e){
    		       
    		        throw e;
    		    }
    		    
    		    
    		  
    		}
    
    


    
    
    
    
    /////////////////////后端处理/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showHetong.do")
	public  String  showHetong( Hetong   hetong  ,HttpServletRequest request){
    	HetongQuery  mq=new HetongQuery();
    	  
    	 if(hetong!=null&&hetong.getTitle()!=null&&!"".equals(hetong.getTitle())){
		    	mq.createCriteria().andTitleLike("%"+hetong.getTitle()+"%");
		    	}
    	
    	    mq.setPageNo(hetong.getCurrentPage());
		    mq.setPageSize(hetong.getSize());
		    
		    int count =hd.countByExample(mq); //查询记录数
		    hetong.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Hetong> list=  hd.selectByExample(mq);
		 request.setAttribute("pager",hetong); 
		 request.setAttribute("list", list); 
		
		return "hetongList.jsp";
	}
	
 
		@RequestMapping(value="back/addHetong.do",produces="text/html;charset=UTF-8")//添加信息
		@ResponseBody
	public  String  addHetong(@RequestParam("file") CommonsMultipartFile file,Hetong  hetong ,HttpServletRequest request){
			 System.out.println(hetong.getTitle());
			 System.out.println(hetong.getPath());
			String msg="操作成功";
			String path=  request.getSession().getServletContext().getRealPath("/uploadhetong");//获取 文件夹的路径
			  System.out.println("path:::::"+path); 
			 
			  if(!file.isEmpty()){
			   String fname=file.getOriginalFilename();//获取上传文件名称 
			    
			   File f=new File(path+"\\"+fname);//将文件上传到 对应的位置
			    try {
			    	file.transferTo(f);
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    hetong.setPath(fname);//存文件名称
			  }else{
				  hetong.setPath(null); 
			  }	 
		 int result=  hd.insertSelective(hetong);
			 if(result==0){
				  msg="添加失败";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	         // return "操作成功";
	           // return "result.jsp";
	}
		 
	
		@RequestMapping(value="back/delHetong.do",produces="text/html;charset=UTF-8") //删除信息
		@ResponseBody
   public String  delHetong(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="操作成功";
			if(ids!=null&&ids.length>0){
			try{
				HetongQuery gq=new HetongQuery();
				   gq.createCriteria().andHidIn(Arrays.asList(ids));
				   hd.deleteByExample(gq);  
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
		 
	
}
