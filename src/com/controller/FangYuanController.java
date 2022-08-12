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
   		    cc.andStatusEqualTo("未成交").andTypeEqualTo("二手房");
   		 mq.setOrderByClause(" createtime desc");
   		    mq.setPageNo(1);
   		    mq.setPageSize(4);  
   		 List<Fangyuan> ershoulist=  fd.selectByExample(mq);
   		 request.setAttribute("ershoulist", ershoulist); 
   		 request.setAttribute("ershou1", ershoulist.get(0));
   		
   		 mq=new FangyuanQuery();
   		  cc=	mq.createCriteria();  
		    cc.andStatusEqualTo("未成交").andTypeEqualTo("新房");
		    mq.setOrderByClause(" createtime desc");
		    mq.setPageNo(1);
		    mq.setPageSize(4);  
		 List<Fangyuan> xinlist=  fd.selectByExample(mq);
		 request.setAttribute("xinlist", xinlist); 
		 mq=new FangyuanQuery();
		  cc=	mq.createCriteria();  
   		    cc.andStatusEqualTo("未成交").andTypeEqualTo("出租房");
   		    mq.setOrderByClause(" createtime desc");
   		    mq.setPageNo(1);
   		    mq.setPageSize(4);  
   		 List<Fangyuan> chuzulist=  fd.selectByExample(mq);
   		 request.setAttribute("chuzulist", chuzulist); 
   		
   		return "index.jsp";
   	}
    
	@RequestMapping("toshowFangyuan.do")//展示房源的详细信息
 	  public String  toshowFangyuan(Integer fid,HttpServletRequest  request){ 
			
			Fangyuan g=    fd.selectByPrimaryKey(fid);
			  String [] pics=  g.getPics().split(",");//按照逗号拆分
			   List<String> piclist=Arrays.asList(pics);
			        request.setAttribute("piclist", piclist);//图片的集合
		   		     request.setAttribute("g", g); 
		   		    
		   		     
		   		     
		 //查询 展示 房源评论信息
		   PinglunQuery  pq=new PinglunQuery();
		       pq.createCriteria().andFidEqualTo(fid);
		       pq.setOrderByClause(" createtime desc ");
		       List<Pinglun> plist=  pd.selectByExample(pq);
		   		     request.setAttribute("plist",	plist);
		   		     
		   		     
		   		     return "proinfo.jsp"; 
		}
    
    
	//通过点击经理人 进入此方法  
	@RequestMapping("showfrontFangyuan.do")
   	public  String  showfrontFangyuan( Integer uid, Fangyuan   fangyuan  ,HttpServletRequest request){
       	FangyuanQuery  mq=new FangyuanQuery();
       	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();  
   		    cc.andWeituorenidEqualTo(uid);//委托人是当前经济人 
   		 com.pojo.FangyuanQuery.Criteria  ccc=	mq.createCriteria(); 
   		    ccc.andFaburenidEqualTo(uid);//发布人是当前经济人  
   		 mq.or(ccc);
   		 mq.setOrderByClause(" createtime desc"); 
   		  
   		 List<Fangyuan> list=  fd.selectByExample(mq);
   		 request.setAttribute("list", list); 
   		 
   		FangyuanQuery  mq2=new FangyuanQuery();//查询出最新发布的4条未成交的房源信息进行推荐
   		  mq2.createCriteria().andStatusEqualTo("未成交");
           mq2.setOrderByClause(" createtime desc"); 
           mq2.setPageNo(1);
           mq2.setPageSize(4);
   		  
   		 List<Fangyuan> newlist=  fd.selectByExample(mq2);
   		 request.setAttribute("newlist", newlist);  
   		
   		return "prolist_jingji.jsp";
   	}
    
    
	//在主页中通过条件筛选 进入此方法  
	@RequestMapping("showfronttiaojianFangyuan.do")
   	public  String  showfronttiaojianFangyuan( String type,String area,String huxing ,String money,String startmoney,
   			String endmoney,String mianji,HttpServletRequest request){
       	FangyuanQuery  mq=new FangyuanQuery();
       	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();  
   		    cc.andStatusEqualTo("未成交"); 
   		 mq.setOrderByClause(" createtime desc"); 
   		 
   		 System.out.println(type);
   		System.out.println(area);
   		System.out.println(huxing);
   		 if(type!=null&&!"".equals(type)){//按 类型查找 出租房 二手 房  新房
   			   cc.andTypeEqualTo(type); 
   		 }
   		 if(area!=null&&!"".equals(area)){//按区域查找
 			   cc.andAreaEqualTo(area);
 		 }
   		 if(huxing!=null&&!"".equals(huxing)){//按户型查找
			   cc.andHuxingEqualTo(huxing);
		 }
   		 if(startmoney!=null&&!"".equals(startmoney)  ){//租金大于等于起始金额
   			 BigDecimal bd=new BigDecimal(startmoney);
   			  cc.andRentpriceGreaterThanOrEqualTo(bd);
   		 }
   		 if(endmoney!=null&&!"".equals(endmoney)  ){ //租金小于等于结束金额
   			 BigDecimal bd=new BigDecimal(endmoney);
   			  cc.andRentpriceLessThanOrEqualTo(bd);
   		 }
   		 //按面积查询
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
   		 request.setAttribute("money", startmoney+"-"+endmoney);//金额范围
   		 request.setAttribute("mianji", mianji);
   		 
   		FangyuanQuery  mq2=new FangyuanQuery();//查询出最新发布的4条未成交的房源信息进行推荐
   		  mq2.createCriteria().andStatusEqualTo("未成交");
           mq2.setOrderByClause(" createtime desc"); 
           mq2.setPageNo(1);
           mq2.setPageSize(4);
   		  
   		 List<Fangyuan> newlist=  fd.selectByExample(mq2);
   		 request.setAttribute("newlist", newlist);  
   		
   		return "prolist_cha.jsp";
   	}
	
	
	
		@RequestMapping("jubao.do")//举报房源
	  public String  jubaoFangyuan(Integer fid,HttpServletRequest  request){  
			
			Fangyuan g=    fd.selectByPrimaryKey(fid); 
			  String [] pics=  g.getPics().split(",");//按照逗号拆分
			   List<String> piclist=Arrays.asList(pics);
			        request.setAttribute("piclist", piclist);//图片的集合
		   		     		   		     
		   		  FangyuanQuery fq=new FangyuanQuery();//更新举报数量
					 fq.createCriteria().andFidEqualTo(fid);
					 Fangyuan ff=new Fangyuan();
					 if(g.getXujiacount()==null){
				     ff.setXujiacount(1);
				     g.setXujiacount(1);//展示时也是+1之后的
					 }else{
						 ff.setXujiacount( g.getXujiacount()+1);	
						 g.setXujiacount(g.getXujiacount()+1);
					 }
					 fd.updateByExampleSelective(ff, fq);
					 request.setAttribute("g", g);  
   
		 //查询 展示 房源评论信息
		   PinglunQuery  pq=new PinglunQuery();
		       pq.createCriteria().andFidEqualTo(fid);
		       pq.setOrderByClause(" createtime desc ");
		       List<Pinglun> plist=  pd.selectByExample(pq);
		   		     request.setAttribute("plist",	plist);
		   		     
		   		     
		   		     return "proinfo.jsp"; 
		}
	
	
	
	
    
	
	@RequestMapping(value="addfrontFangyuan.do")//添加信息 
public  String  addfrontFangyuan(@RequestParam("files") CommonsMultipartFile [] files,Fangyuan  fangyuan ,HttpServletRequest request){
		String msg="操作成功";
		String path=  request.getSession().getServletContext().getRealPath("/uploadimg");//获取 文件夹的路径
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
		  fangyuan.setFaburenid(user.getUid());//发布房源的人就是当前登录的人id 
		  //如果发布人是管理员或者用户本人发布则不需要审核直接发布出来  
		  if( fangyuan.getWeituorenid().equals(user.getUid())){
			  fangyuan.setStatus("未成交");
		  }else{
			  fangyuan.setStatus("委托审核")	;
		  }
		  
		  
	 int result=   fd.insertSelective(fangyuan);
		 if(result==0){
			  msg="添加失败";
		 }
	     return "redirect:showfrontFangyuan.do?uid="+user.getUid();//查看我的房源信息
}
	
	
	@RequestMapping("tofrontAddFangyuan.do")
	public String tofrontAddFangyuan(HttpServletRequest request){
		  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){ 
			 request.setAttribute("msg", "登录超时请重新登录");
	           return "result.jsp";
		   }   
		
		
		MyuserQuery mq=new MyuserQuery();//委托人列表  委托人 默认是自己 当前用户 其余的都是经纪人
	 Criteria mc=	mq.createCriteria();
	          mc.andRoleEqualTo("经纪人");
	 
	 
	List<Myuser>list=	  md.selectByExample(mq);
	System.out.println(list);
		request.setAttribute("mlist", list);//用户列表
		return "fangyuanfrontadd.jsp";
	}
	
	
	@RequestMapping(value="delmyFangyuan.do") //删除信息
	 
public String  delmyFangyuan(Integer[]  ids ,HttpServletRequest  request){
		 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){  
			  return "login.jsp";  
		   } 
		   
		
		String msg="操作成功";
		if(ids!=null&&ids.length>0){
		try{
			FangyuanQuery gq=new FangyuanQuery();
			   gq.createCriteria().andFidIn(Arrays.asList(ids));
			   fd.deleteByExample(gq);  
		}catch(Exception e){
			msg="数据存在依赖关系不能删除请删除新增加的信息";
		}
		} 
		 
           return "redirect:showfrontFangyuan.do?uid="+user.getUid();//查看我的房源信息
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////////////////////后端处理/////////////////////////////////////////////////////////////////   
    
    
    
    
    @RequestMapping("back/showFangyuan.do")
	public  String  showFangyuan( Fangyuan   fangyuan  ,HttpServletRequest request){
    	FangyuanQuery  mq=new FangyuanQuery();
    	com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();   
    	if(fangyuan!=null&&fangyuan.getTitle()!=null&&!"".equals(fangyuan.getTitle())){//标题
    		    cc.andTitleLike("%"+fangyuan.getTitle()+"%");
		    }
		    if(fangyuan!=null&&fangyuan.getType()!=null&&!"".equals(fangyuan.getType())){//房源类型  出租房二手房 新房
		    	cc.andTypeEqualTo(fangyuan.getType());
		    	}
		    if(fangyuan!=null&&fangyuan.getStatus()!=null&&!"".equals(fangyuan.getStatus())){//房源状态已成交 未成交 委托审核
		    	cc.andStatusEqualTo(fangyuan.getStatus());
		    	}
		    mq.setPageNo(fangyuan.getCurrentPage());
		    mq.setPageSize(fangyuan.getSize());
		    
		    int count =fd.countByExample(mq); //查询记录数
		    fangyuan.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Fangyuan> list=  fd.selectByExample(mq);
		 request.setAttribute("pager",fangyuan); 
		 request.setAttribute("list", list); 
		
		return "fangyuanList.jsp";
	}
    
 
    @RequestMapping("back/showmyFangyuan.do")
	public  String  showmyFangyuan( Fangyuan   fangyuan  ,HttpServletRequest request){
    	 Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
		  if(user==null){ 
			 request.setAttribute("msg", "登录超时请重新登录");
	           return "result.jsp";
		   }   
    	
    	FangyuanQuery  mq=new FangyuanQuery();
    com.pojo.FangyuanQuery.Criteria  cc=	mq.createCriteria();   
    	if(fangyuan!=null&&fangyuan.getTitle()!=null&&!"".equals(fangyuan.getTitle())){//标题
    		    cc.andTitleLike("%"+fangyuan.getTitle()+"%");
		    }
		    if(fangyuan!=null&&fangyuan.getType()!=null&&!"".equals(fangyuan.getType())){//房源类型  出租房二手房 新房
		    	cc.andTypeEqualTo(fangyuan.getType());
		    	}
		    if(fangyuan!=null&&fangyuan.getStatus()!=null&&!"".equals(fangyuan.getStatus())){//房源状态已售出 未售出 委托审核
		    	cc.andStatusEqualTo(fangyuan.getStatus());
		    	}
		    mq.setPageNo(fangyuan.getCurrentPage());
		    mq.setPageSize(fangyuan.getSize());
		    //我的房源需要限定 我发布的或者 是委托给我的
		    cc.andWeituorenidEqualTo(user.getUid());
		    com.pojo.FangyuanQuery.Criteria  cc2=mq.createCriteria();
		    cc2.andFaburenidEqualTo(user.getUid()); 
		    if(fangyuan!=null&&fangyuan.getTitle()!=null&&!"".equals(fangyuan.getTitle())){//标题
    		    cc2.andTitleLike("%"+fangyuan.getTitle()+"%");
		    }
		    if(fangyuan!=null&&fangyuan.getType()!=null&&!"".equals(fangyuan.getType())){//房源类型  出租房二手房 新房
		    	cc2.andTypeEqualTo(fangyuan.getType());
		    	}
		    if(fangyuan!=null&&fangyuan.getStatus()!=null&&!"".equals(fangyuan.getStatus())){//房源状态已售出 未售出 委托审核
		    	cc2.andStatusEqualTo(fangyuan.getStatus());
		    	}
		    mq.or(cc2);
		    
		    int count =fd.countByExample(mq); //查询记录数
		    fangyuan.setTotalCount(count); //设置查询出来的总记录条数
		    
		 List<Fangyuan> list=  fd.selectByExample(mq);
		 request.setAttribute("pager",fangyuan); 
		 request.setAttribute("list", list); 
		
		return "fangyuanmyList.jsp";
	}
    
    
    
		@RequestMapping(value="back/addFangyuan.do",produces="text/html;charset=UTF-8")//添加信息
		@ResponseBody
	public  String  addFangyuan(@RequestParam("files") CommonsMultipartFile [] files,Fangyuan  fangyuan ,HttpServletRequest request){
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
			  
			  
			  String pics="";
			  if(files!=null||files.length>0){
				  for(int i=0;i<files.length;i++){
					  CommonsMultipartFile file=files[i];
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
			  fangyuan.setFaburenid(user.getUid());//发布房源的人就是当前登录的人id 
			  //如果发布人是管理员或者用户本人发布则不需要审核直接发布出来  
			  if(user.getRole().equals("管理员")|| fangyuan.getWeituorenid().equals(user.getUid())){
				  fangyuan.setStatus("未成交");
			  }else{
				  fangyuan.setStatus("委托审核")	;
			  }
			  
			  
		 int result=   fd.insertSelective(fangyuan);
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
		
		
		@RequestMapping("back/toAddFangyuan.do")
		public String toAdd(HttpServletRequest request){
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				 request.setAttribute("msg", "登录超时请重新登录");
		           return "result.jsp";
			   }   
			
			
			MyuserQuery mq=new MyuserQuery();//委托人列表  委托人 默认是自己 当前用户 其余的都是经纪人
		 Criteria mc=	mq.createCriteria();
		          mc.andRoleEqualTo("经纪人");
		 
		 
		List<Myuser>list=	  md.selectByExample(mq);
		System.out.println(list);
			request.setAttribute("mlist", list);//用户列表
			return "fangyuanAdd.jsp";
		}
		
		
		
		
		
		
		
		
		
		
		
		
	
		@RequestMapping(value="back/delFangyuan.do",produces="text/html;charset=UTF-8") //删除信息
		@ResponseBody
   public String  delFangyuan(Integer[]  ids ,HttpServletRequest  request){
			System.out.println(Arrays.toString(ids));
			String msg="操作成功";
			if(ids!=null&&ids.length>0){
			try{
				FangyuanQuery gq=new FangyuanQuery();
				   gq.createCriteria().andFidIn(Arrays.asList(ids));
				   fd.deleteByExample(gq);  
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
		@RequestMapping("back/toupdateFangyuan.do")
   	  public String  showOneFangyuan(Integer fid,HttpServletRequest  request){
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				 request.setAttribute("msg", "登录超时请重新登录");
		           return "result.jsp";
			   }   
			
			MyuserQuery mq=new MyuserQuery();//委托人列表  委托人 默认是自己 当前用户 其余的都是经纪人
		 Criteria mc=	mq.createCriteria();
		          mc.andRoleEqualTo("经纪人");
		 
		 
		List<Myuser>list=	  md.selectByExample(mq);
		System.out.println(list);
			request.setAttribute("mlist", list);//用户列表
			
			Fangyuan g=    fd.selectByPrimaryKey(fid);
		   		     request.setAttribute("g", g);  
		   		     return "fangyuanUpdate.jsp"; 
		}
		
		@RequestMapping(value="back/updateFangyuan.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  updateFangyuan(@RequestParam("files") CommonsMultipartFile [] files,Fangyuan  fangyuan ,HttpServletRequest request){
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
			  
			 // System.out.println("1111111"+fangyuan.getPics());
			  //System.out.println(files);
			  String pics="";
			  if(files!=null&&files.length>0){
				  for(int i=0;i<files.length;i++){
					  CommonsMultipartFile file=files[i];
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
	           
	        
	          //将要被返回到客户端的对象
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "操作成功"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}
	 
		@RequestMapping(value="back/updateFangyuantongguo.do") //审核通过功能
		public String  updateFangyuantongguo(Fangyuan  fangyuan,HttpServletRequest request){ 
			
			FangyuanQuery cq=new FangyuanQuery();
			    cq.createCriteria().andFidEqualTo(fangyuan.getFid());
			    fangyuan.setStatus("未成交");//已成交 未成交 委托审核
			  int result=   fd.updateByExampleSelective(fangyuan, cq);
	          System.out.println("qqqq"); 
	          request.setAttribute("msg", "操作成功了");
	           return "result.jsp";
	          
	          
	        
	        /*  //将要被返回到客户端的对象
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "操作成功"); 
	           System.out.println("json::"+json.toString());
			  return json.toString();*/
		}
		
		@RequestMapping(value="back/ajaxtongjifangyuanshuliang.do",produces="text/html;charset=UTF-8")
		@ResponseBody
		public String  ajaxtongjifangyuanshuliang(Fangyuan  fangyuan ,HttpServletRequest request){
			String msg="操作成功";
			  Myuser user=(Myuser) request.getSession().getAttribute("dangqianyonghu"); 
			  if(user==null){ 
				  JSONObject json=new JSONObject();
		          json.accumulate("success", "nosession");
		          json.accumulate("msg", "登录超时请重新登录"); 
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
	                if("二手房".equals(f.getType())){
	                	ershoufang++;
	                }else  if("新房".equals(f.getType())){
	                	xinfang++;
	                }else  if("出租房".equals(f.getType())){
	                	chuzufang++;
	                }	 
	            }
	            
	            
			   
	           
	        
	          //将要被返回到客户端的对象
	          JSONObject json=new JSONObject();
	          json.accumulate("success", "success");
	          json.accumulate("msg", "操作成功"); 
	          json.accumulate("exc", ershoufang+","+xinfang+","+chuzufang);//房源数量统计
	           System.out.println("json::"+json.toString());
			  return json.toString();
		}	
		
		
	
    
    
	
	
}
