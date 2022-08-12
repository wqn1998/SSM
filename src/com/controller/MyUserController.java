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
	
    
    @RequestMapping("frontLogin.do")  //ǰ̨�û���¼����
    public String frontlogin(Myuser  mu,HttpServletRequest request){
    	MyuserQuery  mq=new MyuserQuery();
    	mq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd()).andRoleEqualTo(mu.getRole());
    	
    	List<Myuser> list=  md.selectByExample(mq);
   	       String path="/login.jsp";   
	 
   		if(list!=null&&list.size()>0){  
   			
   		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
   		            request.setAttribute("message","<script>alert('��¼�ɹ�!')</script>");
   		           path="index.do";
   		        }else{
   		            request.setAttribute("message","<script>alert('��¼ʧ��!')</script>");
   		        }
   		    return path; 
    	
    }  
   
    
	@RequestMapping("loginaddMyuser.do")// ǰ���û�ע��
	public  String  loginaddMyuser(@RequestParam("file") CommonsMultipartFile file,Myuser  myuser ,HttpServletRequest request){
 
		String msg="�����ɹ�";
		String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//��ȡ �ļ��е�·��
		  System.out.println("path:::::"+path); 
		 
		  if(!file.isEmpty()){
		   String fname= ""+System.currentTimeMillis()+file.getOriginalFilename();//��ȡ�ϴ��ļ����� 
		   System.out.println("path:::::"+path+"\\"+fname);
		   //�����ظ����Ƹ�������
		   File f=new File(path+"\\"+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
        request.setAttribute("message","<script>alert('�����ɹ�!')</script>");
    }else{
        request.setAttribute("message","<script>alert('����ʧ��!')</script>");
    }
    return "login.jsp"; 
	
	}
    
    
	
		@RequestMapping("showfrontMyuser.do")//չʾ��ϸ�û���Ϣ
 	  public String  showfrontMyuser(Integer uid,HttpServletRequest  request,HttpServletResponse response) throws ServletException, IOException{
			System.out.println("xxx"+uid);
			if(request.getSession().getAttribute("dangqianyonghu")==null||uid==null){
				System.out.println("xxxxx");
				 request.setAttribute("message", "<script>alert('���ȵ�¼');<script>");
				 return "login.jsp";
			}
			
			Myuser g=    md.selectByPrimaryKey(uid);
		   		     request.setAttribute("g", g);  
		   		     return "user.jsp"; 
		}
		@RequestMapping("showfrontpwdMyuser.do")//չʾ��ϸ�û�������Ϣ
	 	  public String  showfrontpwdMyuser(Integer uid,HttpServletRequest  request){
				System.out.println("xxx"+uid);
				Myuser g=    md.selectByPrimaryKey(uid);
			   		     request.setAttribute("g", g);  
			   		     return "user_pwd.jsp"; 
			} 
		
		@RequestMapping(value="updatefrontpwdMyuser.do") //�����û�����
		public String  updatefrontpwdMyuser(Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid());
			   
			  int result=   md.updateByExampleSelective(myuser, cq);
	          System.out.println("qqqq"); 
			   
	         return "showfrontMyuser.do?uid="+myuser.getUid(); 
			  
		}
		
		
		
		@RequestMapping(value="updatefrontMyuser.do") //�����û���Ϣ
		public String  updatefrontMyuser(@RequestParam("file") CommonsMultipartFile file,Myuser  myuser,HttpServletRequest request){ 
			
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid());
			    String msg="�����ɹ�";
				String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//��ȡ �ļ��е�·��
				   
				 
				  if(!file.isEmpty()){
				   String fname= ""+System.currentTimeMillis()+file.getOriginalFilename();//��ȡ�ϴ��ļ����� 
				   System.out.println("path:::::"+path+"\\"+fname);
				   //�����ظ����Ƹ�������
				   File f=new File(path+"\\"+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
	
	//������ �б��ѯ
		 
			
			 @RequestMapping("showfrontjingjiren.do")  //ǰ̨�������б��ѯ
		public  String  showfrontjingji( Myuser   myuser  ,HttpServletRequest request){
	    	MyuserQuery  mq=new MyuserQuery();
	    	Criteria cc= mq.createCriteria();    
	                cc.andRoleEqualTo("������"); 
			    
			 List<Myuser> list=  md.selectByExample(mq); 
			 request.setAttribute("list", list); 
			
			return "user_jingji.jsp";
		}
    
    
    
    /////////////////////��˴���/////////////////////////////////////////////////////////////////   
    
	 
    @RequestMapping("back/backlogin.do") //��̨��½����
    public String login(Myuser  mu,HttpServletRequest request){
    	MyuserQuery  mq=new MyuserQuery();
    	mq.createCriteria().andLoginEqualTo(mu.getLogin()).andPwdEqualTo(mu.getPwd()).andRoleEqualTo(mu.getRole());
    	List<Myuser> list=  md.selectByExample(mq);
   	       String path="login.jsp";   
	 
   		if(list!=null&&list.size()>0){  
   			
   		     request.getSession().setAttribute("dangqianyonghu", list.get(0));
   		            request.setAttribute("message","<script>alert('��¼�ɹ�!')</script>");
   		           path="index.jsp";
   		        }else{
   		            request.setAttribute("message","<script>alert('��¼ʧ��!')</script>");
   		        }
   		    return path;  
    } 
    
    
    @RequestMapping("back/showMyuser.do")  //��̨�б��ѯ
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
		    
		    int count =md.countByExample(mq); //��ѯ��¼��
		    myuser.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Myuser> list=  md.selectByExample(mq);
		 request.setAttribute("pager",myuser); 
		 request.setAttribute("list", list); 
		
		return "myuserList.jsp";
	}
	
 
		@RequestMapping(value="back/addMyuser.do",produces="text/html;charset=UTF-8")//�����Ϣ
		@ResponseBody
	public  String  addMyuser(@RequestParam("file") CommonsMultipartFile file,Myuser  myuser ,HttpServletRequest request){
			String msg="�����ɹ�";
			String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//��ȡ �ļ��е�·��
			  System.out.println("path:::::"+path);
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				  JSONObject json=new JSONObject();
		          json.accumulate("success", "success");
		          json.accumulate("msg", "��¼��ʱ�����µ�¼"); 
		          json.accumulate("url", "login.jsp"); 
		           System.out.println("json::"+json.toString());
				  return json.toString();  
			   } 
			  if(!file.isEmpty()){
			   String fname= ""+System.currentTimeMillis()+file.getOriginalFilename();//��ȡ�ϴ��ļ����� 
			   System.out.println("path:::::"+path+"\\"+fname);
			   //�����ظ����Ƹ�������
			   File f=new File(path+"\\"+fname);//���ļ��ϴ��� ��Ӧ��λ��
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
				  msg="���ʧ��";
			 }
		 
		 JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", msg); 
	           System.out.println("json::"+json.toString());
			   return json.toString(); 
	        // return "result.jsp";
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		@RequestMapping(value="back/delMyuser.do",produces="text/html;charset=UTF-8") //ɾ����Ϣ
		@ResponseBody
   public String  delMyuser(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="�����ɹ�";
			if(ids!=null&&ids.length>0){
			try{
				MyuserQuery gq=new MyuserQuery();
				   gq.createCriteria().andUidIn(Arrays.asList(ids));
				   md.deleteByExample(gq);  
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
	          
	          
	        
	          //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		@RequestMapping(value="back/updatepwd.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updatepwd(Myuser  myuser,HttpServletRequest request){ 
			String msg="����ʧ��";
			MyuserQuery cq=new MyuserQuery();
			    cq.createCriteria().andUidEqualTo(myuser.getUid()) ;
			  int result=   md.updateByExampleSelective(myuser, cq);
	           if(result>0){
	                msg="�����ɹ�";
	           } 
	           //��Ҫ�����ص��ͻ��˵Ķ���
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
