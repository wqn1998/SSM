package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dao.MyuserDao; 
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.MyuserQuery.Criteria;

import net.sf.json.JSONObject;

@Controller
public class MyUserController {
    @Autowired
	private MyuserDao  md;
	
    
    @RequestMapping("frontLogin.do")  //前台用户登录功能
    public String frontlogin(Myuser  mu,HttpServletRequest request){
    	MyuserQuery  mq=new MyuserQuery();
    	mq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd()).andRoleEqualTo(mu.getRole());
    	
    	List<Myuser> list=  md.selectByExample(mq);
   	       String path="/login.jsp";   
	 
   		if(list!=null&&list.size()>0){  
   			
   		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
   		            request.setAttribute("message","<script>alert('登录成功!')</script>");
   		           path="index.do";
   		        }else{
   		            request.setAttribute("message","<script>alert('登录失败!')</script>");
   		        }
   		    return path; 
    	
    }  
   
    
	@RequestMapping("loginaddMyuser.do")// 前端用户注册
	public  String  loginaddMyuser(@RequestParam("file") CommonsMultipartFile file,Myuser  myuser ,HttpServletRequest request){
 
		String msg="操作成功";
		String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//获取 文件夹的路径
		  System.out.println("path:::::"+path); 
		 
		  if(!file.isEmpty()){
		   String fname= ""+System.currentTimeMillis()+file.getOriginalFilename();//获取上传文件名称 
		   System.out.println("path:::::"+path+"\\"+fname);
		   //避免重复名称覆盖问题
		   File f=new File(path+"\\"+fname);//将文件上传到 对应的位置
		    try {
		    	file.transferTo(f);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		    myuser.setPic("uploadimg/"+fname);
		  }else{
			  myuser.setPic(null); 
		  }
	 int result=   md.insertSelective(myuser); 
		 
    if(result>0){
        request.setAttribute("message","<script>alert('操作成功!')</script>");
    }else{
        request.setAttribute("message","<script>alert('操作失败!')</script>");
    }
    return "login.jsp"; 
	
	}
    
    
	
		@RequestMapping("showfrontMyuser.do")//展示详细用户信息
 	  public String  showfrontMyuser(Integer uid,HttpServletRequest  request,HttpServletResponse response) throws ServletException, IOException{
			System.out.println("xxx"+uid);
			if(request.getSession().getAttribute("dangqianyonghu")==null||uid==null){
				System.out.println("xxxxx");
				 request.setAttribute("message", "<script>alert('请先登录');<script>");
				 return "login.jsp";
			}
			
			Myuser g=    md.selectByPrimaryKey(uid);
		   		     request.setAttribute("g", g);  
		   		     return "user.jsp"; 
		}
		@RequestMapping("showfrontpwdMyuser.do")//展示详细用户密码信息
	 	  public String  showfrontpwdMyuser(Integer uid,HttpServletRequest  request){
				System.out.println("xxx"+uid);
				Myuser g=    md.selectByPrimaryKey(uid);
			   		     request.setAttribute("g", g);  
			   		     return "user_pwd.jsp"; 
			} 
		
		@RequestMapping(value="updatefrontpwdMyuser.do") //更新用户密码
		public String  updatefrontpwdMyuser(Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid());
			   
			  int result=   md.updateByExampleSelective(myuser, cq);
	          System.out.println("qqqq"); 
			   
	         return "showfrontMyuser.do?uid="+myuser.getUid(); 
			  
		}
		
		
		
		@RequestMapping(value="updatefrontMyuser.do") //更新用户信息
		public String  updatefrontMyuser(@RequestParam("file") CommonsMultipartFile file,Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid());
			    String msg="操作成功";
				String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//获取 文件夹的路径
				   
				 
				  if(!file.isEmpty()){
				   String fname= ""+System.currentTimeMillis()+file.getOriginalFilename();//获取上传文件名称 
				   System.out.println("path:::::"+path+"\\"+fname);
				   //避免重复名称覆盖问题
				   File f=new File(path+"\\"+fname);//将文件上传到 对应的位置
				    try {
				    	file.transferTo(f);
					}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				    myuser.setPic("uploadimg/"+fname);
				  }else{
					  myuser.setPic(null); 
				  } 
			     
			    
			  int result=   md.updateByExampleSelective(myuser, cq);
	          System.out.println("qqqq"); 
			   
	         return "showfrontMyuser.do?uid="+myuser.getUid(); 
			  
		}
	
	//经纪人 列表查询
		 
			
			 @RequestMapping("showfrontjingjiren.do")  //前台经纪人列表查询
		public  String  showfrontjingji( Myuser   myuser  ,HttpServletRequest request){
	    	MyuserQuery  mq=new MyuserQuery();
	    	Criteria cc= mq.createCriteria();    
	                cc.andRoleEqualTo("经纪人"); 
			    
			 List<Myuser> list=  md.selectByExample(mq); 
			 request.setAttribute("list", list); 
			
			return "user_jingji.jsp";
		}
    
    
    
    /////////////////////后端处理/////////////////////////////////////////////////////////////////   
    
	 
    @RequestMapping("back/backlogin.do") //后台登陆功能
    public String login(Myuser  mu,HttpServletRequest request){
    	MyuserQuery  mq=new MyuserQuery();
    	mq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd()).andRoleEqualTo(mu.getRole());
    	List<Myuser> list=  md.selectByExample(mq);
   	       String path="login.jsp";   
	 
   		if(list!=null&&list.size()>0){  
   			
   		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
   		            request.setAttribute("message","<script>alert('登录成功!')</script>");
   		           path="index.jsp";
   		        }else{
   		            request.setAttribute("message","<script>alert('登录失败!')</script>");
   		        }
   		    return path;  
    } 
    
    
    @RequestMapping("back/showMyuser.do")  //后台列表查询
	public  String  showEmployee( Myuser   myuser  ,HttpServletRequest request){
    	MyuserQuery  mq=new MyuserQuery();
    	Criteria cc= mq.createCriteria();    
    	if(myuser!=null&&myuser.getName()!=null&&!"".equals(myuser.getName())){
		    	cc.andNameLike("%"+myuser.getName()+"%");
		    }
		    if(myuser!=null&&myuser.getRole()!=null&&!"".equals(myuser.getRole())){
		    	cc.andRoleEqualTo(myuser.getRole());
		    	}
		    mq.setPageNo(myuser.getCurrentPage());
		    mq.setPageSize(myuser.getSize());
		    
		    int count =md.countByExample(mq); //查询记录数
		    myuser.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Myuser> list=  md.selectByExample(mq);
		 request.setAttribute("pager",myuser); 
		 request.setAttribute("list", list); 
		
		return "myuserList.jsp";
	}
	
 
		@RequestMapping(value="back/addMyuser.do",produces="text/html;charset=UTF-8")//添加信息
		@ResponseBody
	public  String  addMyuser(@RequestParam("file") CommonsMultipartFile file,Myuser  myuser ,HttpServletRequest request){
			String msg="操作成功";
			String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//获取 文件夹的路径
			  System.out.println("path:::::"+path);
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				  JSONObject json=new JSONObject();
		          json.accumulate("success", "success");
		          json.accumulate("msg", "登录超时请重新登录"); 
		          json.accumulate("url", "login.jsp"); 
		           System.out.println("json::"+json.toString());
				  return json.toString();  
			   } 
			  if(!file.isEmpty()){
			   String fname= ""+System.currentTimeMillis()+file.getOriginalFilename();//获取上传文件名称 
			   System.out.println("path:::::"+path+"\\"+fname);
			   //避免重复名称覆盖问题
			   File f=new File(path+"\\"+fname);//将文件上传到 对应的位置
			    try {
			    	file.transferTo(f);
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			    myuser.setPic("uploadimg/"+fname);
			  }else{
				  myuser.setPic(null); 
			  }
		 int result=   md.insertSelective(myuser);
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		@RequestMapping(value="back/delMyuser.do",produces="text/html;charset=UTF-8") //删除信息
		@ResponseBody
   public String  delMyuser(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="操作成功";
			if(ids!=null&&ids.length>0){
			try{
				MyuserQuery gq=new MyuserQuery();
				   gq.createCriteria().andUidIn(Arrays.asList(ids));
				   md.deleteByExample(gq);  
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
	
		@RequestMapping("back/toupdateMyuser.do")
   	  public String  showOneMyuser(Integer uid,HttpServletRequest  request){
			System.out.println("xxx"+uid);
			Myuser g=    md.selectByPrimaryKey(uid);
		   		     request.setAttribute("g", g);  
		   		     return "myuserUpdate.jsp"; 
		}
		
		@RequestMapping(value="back/updateMyuser.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updateMyuser(Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid());
			  int result=   md.updateByExampleSelective(myuser, cq);
	          System.out.println("qqqq"); 
			   
	        //  return "redirect:showMyuser.do";
	          
	          
	        
	          //将要被返回到客户端的对象
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "操作成功"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		@RequestMapping(value="back/updatepwd.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updatepwd(Myuser  myuser,HttpServletRequest request){ 
			String msg="操作失败";
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid()) ;
			  int result=   md.updateByExampleSelective(myuser, cq);
	           if(result>0){
	                msg="操作成功";
	           } 
	           //将要被返回到客户端的对象
		          JSONObject json=new JSONObject();
		          json.accumulate("success", "success");
		          json.accumulate("msg",msg ); 
		           System.out.println("json::"+json.toString());
				  return json.toString();
		}
       
		@RequestMapping("back/topwdMyuser.do")
	   	  public String  showMyuser(Integer uid,HttpServletRequest  request){
				Myuser g=    md.selectByPrimaryKey(uid);
			   		     request.setAttribute("g", g);  
			   		     return "myuserpwdUpdate.jsp"; 
			}
		
		
    
    
    
	
	
}
