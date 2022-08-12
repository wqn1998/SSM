package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
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

import com.dao.FangyuanDao;
import com.dao.MyuserDao;
import com.dao.PinglunDao;
import com.pojo.Fangyuan;
import com.pojo.FangyuanQuery;
import com.pojo.Myuser;
import com.pojo.MyuserQuery;
import com.pojo.PinglunQuery;
import com.pojo.MyuserQuery.Criteria;
import com.pojo.Pinglun;

import net.sf.json.JSONObject;

@Controller
public class FangYuanController {
    @Autowired
	private FangyuanDao  fd;
    @Autowired
    private MyuserDao  md;
    @Autowired
    private PinglunDao pd;
    
    
    @RequestMapping("index.do")
   	public  String  index( Fangyuan   fangyuan  ,HttpServletRequest request){
       	FangyuanQuery  mq=new FangyuanQuery();
       	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();  
   		    cc.andStatusEqualTo("δ�ɽ�").andTypeEqualTo("���ַ�");
   		 mq.setOrderByClause(" createtime desc");
   		    mq.setPageNo(1);
   		    mq.setPageSize(4);  
   		 List<Fangyuan> ershoulist=  fd.selectByExample(mq);
   		 request.setAttribute("ershoulist", ershoulist); 
   		 request.setAttribute("ershou1", ershoulist.get(0));
   		
   		 mq=new FangyuanQuery();
   		  cc=	mq.createCriteria();  
		    cc.andStatusEqualTo("δ�ɽ�").andTypeEqualTo("�·�");
		    mq.setOrderByClause(" createtime desc");
		    mq.setPageNo(1);
		    mq.setPageSize(4);  
		 List<Fangyuan> xinlist=  fd.selectByExample(mq);
		 request.setAttribute("xinlist", xinlist); 
		 mq=new FangyuanQuery();
		  cc=	mq.createCriteria();  
   		    cc.andStatusEqualTo("δ�ɽ�").andTypeEqualTo("���ⷿ");
   		    mq.setOrderByClause(" createtime desc");
   		    mq.setPageNo(1);
   		    mq.setPageSize(4);  
   		 List<Fangyuan> chuzulist=  fd.selectByExample(mq);
   		 request.setAttribute("chuzulist", chuzulist); 
   		
   		return "index.jsp";
   	}
    
	@RequestMapping("toshowFangyuan.do")//չʾ��Դ����ϸ��Ϣ
 	  public String  toshowFangyuan(Integer fid,HttpServletRequest  request){ 
			
			Fangyuan g=    fd.selectByPrimaryKey(fid);
			  String [] pics=  g.getPics().split(",");//���ն��Ų��
			   List<String> piclist=Arrays.asList(pics);
			        request.setAttribute("piclist", piclist);//ͼƬ�ļ���
		   		     request.setAttribute("g", g); 
		   		    
		   		     
		   		     
		 //��ѯ չʾ ��Դ������Ϣ
		   PinglunQuery  pq=new PinglunQuery();
		       pq.createCriteria().andFidEqualTo(fid);
		       pq.setOrderByClause(" createtime desc ");
		       List<Pinglun> plist=  pd.selectByExample(pq);
		   		     request.setAttribute("plist",	plist);
		   		     
		   		     
		   		     return "proinfo.jsp"; 
		}
    
    
	//ͨ����������� ����˷���  
	@RequestMapping("showfrontFangyuan.do")
   	public  String  showfrontFangyuan( Integer uid, Fangyuan   fangyuan  ,HttpServletRequest request){
       	FangyuanQuery  mq=new FangyuanQuery();
       	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();  
   		    cc.andWeituorenidEqualTo(uid);//ί�����ǵ�ǰ������ 
   		 com.pojo.FangyuanQuery.Criteria  ccc=	mq.createCriteria(); 
   		    ccc.andFaburenidEqualTo(uid);//�������ǵ�ǰ������  
   		 mq.or(ccc);
   		 mq.setOrderByClause(" createtime desc"); 
   		  
   		 List<Fangyuan> list=  fd.selectByExample(mq);
   		 request.setAttribute("list", list); 
   		 
   		FangyuanQuery  mq2=new FangyuanQuery();//��ѯ�����·�����4��δ�ɽ��ķ�Դ��Ϣ�����Ƽ�
   		  mq2.createCriteria().andStatusEqualTo("δ�ɽ�");
           mq2.setOrderByClause(" createtime desc"); 
           mq2.setPageNo(1);
           mq2.setPageSize(4);
   		  
   		 List<Fangyuan> newlist=  fd.selectByExample(mq2);
   		 request.setAttribute("newlist", newlist);  
   		
   		return "prolist_jingji.jsp";
   	}
    
    
	//����ҳ��ͨ������ɸѡ ����˷���  
	@RequestMapping("showfronttiaojianFangyuan.do")
   	public  String  showfronttiaojianFangyuan( String type,String area,String huxing ,String money,String startmoney,
   			String endmoney,String mianji,HttpServletRequest request){
       	FangyuanQuery  mq=new FangyuanQuery();
       	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();  
   		    cc.andStatusEqualTo("δ�ɽ�"); 
   		 mq.setOrderByClause(" createtime desc"); 
   		 
   		 System.out.println(type);
   		System.out.println(area);
   		System.out.println(huxing);
   		 if(type!=null&&!"".equals(type)){//�� ���Ͳ��� ���ⷿ ���� ��  �·�
   			   cc.andTypeEqualTo(type); 
   		 }
   		 if(area!=null&&!"".equals(area)){//���������
 			   cc.andAreaEqualTo(area);
 		 }
   		 if(huxing!=null&&!"".equals(huxing)){//�����Ͳ���
			   cc.andHuxingEqualTo(huxing);
		 }
   		 if(startmoney!=null&&!"".equals(startmoney)  ){//�����ڵ�����ʼ���
   			 BigDecimal bd=new BigDecimal(startmoney);
   			  cc.andRentpriceGreaterThanOrEqualTo(bd);
   		 }
   		 if(endmoney!=null&&!"".equals(endmoney)  ){ //���С�ڵ��ڽ������
   			 BigDecimal bd=new BigDecimal(endmoney);
   			  cc.andRentpriceLessThanOrEqualTo(bd);
   		 }
   		 //�������ѯ
   		 if(mianji!=null&&!"".equals(mianji)){
   			String[] mm= mianji.split("~");
   			cc.andMianjiBetween(Double.parseDouble(mm[0]), Double.parseDouble(mm[1]));   			
   			
   		 }
   		 
   		 System.out.println("money:"+startmoney+"-"+endmoney);
   		 System.out.println("mianji:"+mianji);
   		 
   		  
   		 List<Fangyuan> list=  fd.selectByExample(mq);
   		 request.setAttribute("list", list); 
   		 request.setAttribute("type", type);
   		 request.setAttribute("area", area);
   		 request.setAttribute("huxing", huxing);
   		 request.setAttribute("money", startmoney+"-"+endmoney);//��Χ
   		 request.setAttribute("mianji", mianji);
   		 
   		FangyuanQuery  mq2=new FangyuanQuery();//��ѯ�����·�����4��δ�ɽ��ķ�Դ��Ϣ�����Ƽ�
   		  mq2.createCriteria().andStatusEqualTo("δ�ɽ�");
           mq2.setOrderByClause(" createtime desc"); 
           mq2.setPageNo(1);
           mq2.setPageSize(4);
   		  
   		 List<Fangyuan> newlist=  fd.selectByExample(mq2);
   		 request.setAttribute("newlist", newlist);  
   		
   		return "prolist_cha.jsp";
   	}
	
	
	
		@RequestMapping("jubao.do")//�ٱ���Դ
	  public String  jubaoFangyuan(Integer fid,HttpServletRequest  request){  
			
			Fangyuan g=    fd.selectByPrimaryKey(fid); 
			  String [] pics=  g.getPics().split(",");//���ն��Ų��
			   List<String> piclist=Arrays.asList(pics);
			        request.setAttribute("piclist", piclist);//ͼƬ�ļ���
		   		     		   		     
		   		  FangyuanQuery fq=new FangyuanQuery();//���¾ٱ�����
					 fq.createCriteria().andFidEqualTo(fid);
					 Fangyuan ff=new Fangyuan();
					 if(g.getXujiacount()==null){
				     ff.setXujiacount(1);
				     g.setXujiacount(1);//չʾʱҲ��+1֮���
					 }else{
						 ff.setXujiacount( g.getXujiacount()+1);	
						 g.setXujiacount(g.getXujiacount()+1);
					 }
					 fd.updateByExampleSelective(ff, fq);
					 request.setAttribute("g", g);  
   
		 //��ѯ չʾ ��Դ������Ϣ
		   PinglunQuery  pq=new PinglunQuery();
		       pq.createCriteria().andFidEqualTo(fid);
		       pq.setOrderByClause(" createtime desc ");
		       List<Pinglun> plist=  pd.selectByExample(pq);
		   		     request.setAttribute("plist",	plist);
		   		     
		   		     
		   		     return "proinfo.jsp"; 
		}
	
	
	
	
    
	
	@RequestMapping(value="addfrontFangyuan.do")//�����Ϣ 
public  String  addfrontFangyuan(@RequestParam("files") CommonsMultipartFile [] files,Fangyuan  fangyuan ,HttpServletRequest request){
		String msg="�����ɹ�";
		String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//��ȡ �ļ��е�·��
		  System.out.println("path:::::"+path);
		  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){  
			  return "login.jsp";  
		   } 
		  
		  
		  String pics="";
		  if(files!=null||files.length>0){
			  for(int i=0;i<files.length;i++){
				  CommonsMultipartFile file=files[i];
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
					    if(i!=files.length-1){
					    pics+="uploadimg/"+fname+",";
					    }else{
					     pics+="uploadimg/"+fname;
					    }
					    
					  }   
			  } 
			  fangyuan.setPics(pics);  
		  }else{
			  fangyuan.setPics(null);
		  }
		 
		  fangyuan.setCreatetime(new Date());
		  fangyuan.setFaburenid(user.getUid());//������Դ���˾��ǵ�ǰ��¼����id 
		  //����������ǹ���Ա�����û����˷�������Ҫ���ֱ�ӷ�������  
		  if( fangyuan.getWeituorenid().equals(user.getUid())){
			  fangyuan.setStatus("δ�ɽ�");
		  }else{
			  fangyuan.setStatus("ί�����")	;
		  }
		  
		  
	 int result=   fd.insertSelective(fangyuan);
		 if(result==0){
			  msg="���ʧ��";
		 }
	     return "redirect:showfrontFangyuan.do?uid="+user.getUid();//�鿴�ҵķ�Դ��Ϣ
}
	
	
	@RequestMapping("tofrontAddFangyuan.do")
	public String tofrontAddFangyuan(HttpServletRequest request){
		  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){ 
			 request.setAttribute("msg", "��¼��ʱ�����µ�¼");
	           return "result.jsp";
		   }   
		
		
		MyuserQuery mq=new MyuserQuery();//ί�����б�  ί���� Ĭ�����Լ� ��ǰ�û� ����Ķ��Ǿ�����
	 Criteria mc=	mq.createCriteria();
	          mc.andRoleEqualTo("������");
	 
	 
	List<Myuser>list=	  md.selectByExample(mq);
	System.out.println(list);
		request.setAttribute("mlist", list);//�û��б�
		return "fangyuanfrontadd.jsp";
	}
	
	
	@RequestMapping(value="delmyFangyuan.do") //ɾ����Ϣ
	 
public String  delmyFangyuan(Integer[]  ids ,HttpServletRequest  request){
		 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){  
			  return "login.jsp";  
		   } 
		   
		
		String msg="�����ɹ�";
		if(ids!=null&&ids.length>0){
		try{
			FangyuanQuery gq=new FangyuanQuery();
			   gq.createCriteria().andFidIn(Arrays.asList(ids));
			   fd.deleteByExample(gq);  
		}catch(Exception e){
			msg="���ݴ���������ϵ����ɾ����ɾ�������ӵ���Ϣ";
		}
		} 
		 
           return "redirect:showfrontFangyuan.do?uid="+user.getUid();//�鿴�ҵķ�Դ��Ϣ
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////////////////////��˴���/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showFangyuan.do")
	public  String  showFangyuan( Fangyuan   fangyuan  ,HttpServletRequest request){
    	FangyuanQuery  mq=new FangyuanQuery();
    	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();   
    	if(fangyuan!=null&&fangyuan.getTitle()!=null&&!"".equals(fangyuan.getTitle())){//����
    		    cc.andTitleLike("%"+fangyuan.getTitle()+"%");
		    }
		    if(fangyuan!=null&&fangyuan.getType()!=null&&!"".equals(fangyuan.getType())){//��Դ����  ���ⷿ���ַ� �·�
		    	cc.andTypeEqualTo(fangyuan.getType());
		    	}
		    if(fangyuan!=null&&fangyuan.getStatus()!=null&&!"".equals(fangyuan.getStatus())){//��Դ״̬�ѳɽ� δ�ɽ� ί�����
		    	cc.andStatusEqualTo(fangyuan.getStatus());
		    	}
		    mq.setPageNo(fangyuan.getCurrentPage());
		    mq.setPageSize(fangyuan.getSize());
		    
		    int count =fd.countByExample(mq); //��ѯ��¼��
		    fangyuan.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Fangyuan> list=  fd.selectByExample(mq);
		 request.setAttribute("pager",fangyuan); 
		 request.setAttribute("list", list); 
		
		return "fangyuanList.jsp";
	}
    
 
    @RequestMapping("back/showmyFangyuan.do")
	public  String  showmyFangyuan( Fangyuan   fangyuan  ,HttpServletRequest request){
    	 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){ 
			 request.setAttribute("msg", "��¼��ʱ�����µ�¼");
	           return "result.jsp";
		   }   
    	
    	FangyuanQuery  mq=new FangyuanQuery();
    com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();   
    	if(fangyuan!=null&&fangyuan.getTitle()!=null&&!"".equals(fangyuan.getTitle())){//����
    		    cc.andTitleLike("%"+fangyuan.getTitle()+"%");
		    }
		    if(fangyuan!=null&&fangyuan.getType()!=null&&!"".equals(fangyuan.getType())){//��Դ����  ���ⷿ���ַ� �·�
		    	cc.andTypeEqualTo(fangyuan.getType());
		    	}
		    if(fangyuan!=null&&fangyuan.getStatus()!=null&&!"".equals(fangyuan.getStatus())){//��Դ״̬���۳� δ�۳� ί�����
		    	cc.andStatusEqualTo(fangyuan.getStatus());
		    	}
		    mq.setPageNo(fangyuan.getCurrentPage());
		    mq.setPageSize(fangyuan.getSize());
		    //�ҵķ�Դ��Ҫ�޶� �ҷ����Ļ��� ��ί�и��ҵ�
		    cc.andWeituorenidEqualTo(user.getUid());
		    com.pojo.FangyuanQuery.Criteria  cc2=mq.createCriteria();
		    cc2.andFaburenidEqualTo(user.getUid()); 
		    if(fangyuan!=null&&fangyuan.getTitle()!=null&&!"".equals(fangyuan.getTitle())){//����
    		    cc2.andTitleLike("%"+fangyuan.getTitle()+"%");
		    }
		    if(fangyuan!=null&&fangyuan.getType()!=null&&!"".equals(fangyuan.getType())){//��Դ����  ���ⷿ���ַ� �·�
		    	cc2.andTypeEqualTo(fangyuan.getType());
		    	}
		    if(fangyuan!=null&&fangyuan.getStatus()!=null&&!"".equals(fangyuan.getStatus())){//��Դ״̬���۳� δ�۳� ί�����
		    	cc2.andStatusEqualTo(fangyuan.getStatus());
		    	}
		    mq.or(cc2);
		    
		    int count =fd.countByExample(mq); //��ѯ��¼��
		    fangyuan.setTotalCount(count); //���ò�ѯ�������ܼ�¼����
		    
		 List<Fangyuan> list=  fd.selectByExample(mq);
		 request.setAttribute("pager",fangyuan); 
		 request.setAttribute("list", list); 
		
		return "fangyuanmyList.jsp";
	}
    
    
    
		@RequestMapping(value="back/addFangyuan.do",produces="text/html;charset=UTF-8")//�����Ϣ
		@ResponseBody
	public  String  addFangyuan(@RequestParam("files") CommonsMultipartFile [] files,Fangyuan  fangyuan ,HttpServletRequest request){
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
			  
			  
			  String pics="";
			  if(files!=null||files.length>0){
				  for(int i=0;i<files.length;i++){
					  CommonsMultipartFile file=files[i];
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
						    if(i!=files.length-1){
						    pics+="uploadimg/"+fname+",";
						    }else{
						     pics+="uploadimg/"+fname;
						    }
						    
						  }   
				  } 
				  fangyuan.setPics(pics);  
			  }else{
				  fangyuan.setPics(null);
			  }
			 
			  fangyuan.setCreatetime(new Date());
			  fangyuan.setFaburenid(user.getUid());//������Դ���˾��ǵ�ǰ��¼����id 
			  //����������ǹ���Ա�����û����˷�������Ҫ���ֱ�ӷ�������  
			  if(user.getRole().equals("����Ա")|| fangyuan.getWeituorenid().equals(user.getUid())){
				  fangyuan.setStatus("δ�ɽ�");
			  }else{
				  fangyuan.setStatus("ί�����")	;
			  }
			  
			  
		 int result=   fd.insertSelective(fangyuan);
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
		
		
		@RequestMapping("back/toAddFangyuan.do")
		public String toAdd(HttpServletRequest request){
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				 request.setAttribute("msg", "��¼��ʱ�����µ�¼");
		           return "result.jsp";
			   }   
			
			
			MyuserQuery mq=new MyuserQuery();//ί�����б�  ί���� Ĭ�����Լ� ��ǰ�û� ����Ķ��Ǿ�����
		 Criteria mc=	mq.createCriteria();
		          mc.andRoleEqualTo("������");
		 
		 
		List<Myuser>list=	  md.selectByExample(mq);
		System.out.println(list);
			request.setAttribute("mlist", list);//�û��б�
			return "fangyuanAdd.jsp";
		}
		
		
		
		
		
		
		
		
		
		
		
		
	
		@RequestMapping(value="back/delFangyuan.do",produces="text/html;charset=UTF-8") //ɾ����Ϣ
		@ResponseBody
   public String  delFangyuan(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="�����ɹ�";
			if(ids!=null&&ids.length>0){
			try{
				FangyuanQuery gq=new FangyuanQuery();
				   gq.createCriteria().andFidIn(Arrays.asList(ids));
				   fd.deleteByExample(gq);  
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
		@RequestMapping("back/toupdateFangyuan.do")
   	  public String  showOneFangyuan(Integer fid,HttpServletRequest  request){
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				 request.setAttribute("msg", "��¼��ʱ�����µ�¼");
		           return "result.jsp";
			   }   
			
			MyuserQuery mq=new MyuserQuery();//ί�����б�  ί���� Ĭ�����Լ� ��ǰ�û� ����Ķ��Ǿ�����
		 Criteria mc=	mq.createCriteria();
		          mc.andRoleEqualTo("������");
		 
		 
		List<Myuser>list=	  md.selectByExample(mq);
		System.out.println(list);
			request.setAttribute("mlist", list);//�û��б�
			
			Fangyuan g=    fd.selectByPrimaryKey(fid);
		   		     request.setAttribute("g", g);  
		   		     return "fangyuanUpdate.jsp"; 
		}
		
		@RequestMapping(value="back/updateFangyuan.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updateFangyuan(@RequestParam("files") CommonsMultipartFile [] files,Fangyuan  fangyuan ,HttpServletRequest request){
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
			  
			 // System.out.println("1111111"+fangyuan.getPics());
			  //System.out.println(files);
			  String pics="";
			  if(files!=null&&files.length>0){
				  for(int i=0;i<files.length;i++){
					  CommonsMultipartFile file=files[i];
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
						    if(i!=files.length-1){
						    pics+="uploadimg/"+fname+",";
						    }else{
						     pics+="uploadimg/"+fname;
						    } 
						    
						  }   
				  } 
				  if(!pics.equals("")){
				  fangyuan.setPics(pics);
				  }  
			  }else{
				  fangyuan.setPics(null);
			  }
			   
			
			
			FangyuanQuery cq=new FangyuanQuery();
			    cq.createCriteria().andFidEqualTo(fangyuan.getFid());
			  int result=   fd.updateByExampleSelective(fangyuan, cq);
	          System.out.println("qqqq"); 
			   
	        //  return "redirect:showFangyuan.do";
	           
	        
	          //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		@RequestMapping(value="back/updateFangyuantongguo.do") //���ͨ������
		public String  updateFangyuantongguo(Fangyuan  fangyuan,HttpServletRequest request){ 
			
			FangyuanQuery cq=new FangyuanQuery();
			    cq.createCriteria().andFidEqualTo(fangyuan.getFid());
			    fangyuan.setStatus("δ�ɽ�");//�ѳɽ� δ�ɽ� ί�����
			  int result=   fd.updateByExampleSelective(fangyuan, cq);
	          System.out.println("qqqq"); 
	          request.setAttribute("msg", "�����ɹ���");
	           return "result.jsp";
	          
	          
	        
	        /*  //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();*/
		}
		
		@RequestMapping(value="back/ajaxtongjifangyuanshuliang.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  ajaxtongjifangyuanshuliang(Fangyuan  fangyuan ,HttpServletRequest request){
			String msg="�����ɹ�";
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				  JSONObject json=new JSONObject();
		          json.accumulate("success", "nosession");
		          json.accumulate("msg", "��¼��ʱ�����µ�¼"); 
		          json.accumulate("url", "login.jsp"); 
		           System.out.println("json::"+json.toString());
				  return json.toString();  
			   }  
			
			FangyuanQuery cq=new FangyuanQuery();
			   
			 List<Fangyuan> list=   fd.selectByExample(cq);
	    int ershoufang=0;
	    int xinfang=0;
	    int chuzufang=0;
	            for(Fangyuan f:list){
	                if("���ַ�".equals(f.getType())){
	                	ershoufang++;
	                }else  if("�·�".equals(f.getType())){
	                	xinfang++;
	                }else  if("���ⷿ".equals(f.getType())){
	                	chuzufang++;
	                }	 
	            }
	            
	            
			   
	           
	        
	          //��Ҫ�����ص��ͻ��˵Ķ���
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "�����ɹ�"); 
	          json.accumulate("exc", ershoufang+","+xinfang+","+chuzufang);//��Դ����ͳ��
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}	
		
		
	
    
    
	
	
}
