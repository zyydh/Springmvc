package com.jk1205.ctr;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk1205.pojo.TAttendance;
import com.jk1205.pojo.TUser;
import com.jk1205.service.KqBiz;
import com.jk1205.util.DateUtil;

@Controller
public class KqAction {
	
	
	@Autowired
	private  KqBiz kqbiz;
	
	
	//查看员工个人考勤记录               员工id   session       时间点  默认  当月
	//showKqAction.do
	@RequestMapping("showKqAction.do")
	public String showKqAction(String month,HttpServletRequest req) throws ParseException{
		TUser user= (TUser) req.getSession().getAttribute("user");
		//没有登录的不让查询
	 if(null!=user){		
		// 判断   month 是否为空？   如果等于null    默认当月  
		if(null==month||"".equals(month)){
			//获取系统当前时间
			Date date=new Date();
			month=DateUtil.datefm.format(date);
		}
		
		//System.out.println(month);
		
		   
		List<TAttendance>  tAttendances = kqbiz.showKq(month,user.getUid());
          //解析
		  //统计考勤信息  
		//    准点      无故迟到    有原因的        其他
		  int zd=0,wgcd=0,ygcd=0,others=0;
		  
		  if(null!=tAttendances&&tAttendances.size()>0){
			  //对每一条考勤信息 进行判断
			  for (TAttendance tAttendance : tAttendances) {
				  
				    // 正常考勤
				  if(1==tAttendance.getAttendanceType()){
					  // 打卡时间
					  Date tmpdate2=DateUtil.datefm2.parse(tAttendance.getAttendanceEvery());
					
					  //上班规定的时间
					  Date tmpdate=DateUtil.datefm2.parse("9:00:00");
					 // System.out.println(tmpdate2+"   "+tmpdate);
					  //统计正常   打开时间  在  规定时间   之前
					  if(tmpdate2.before(tmpdate)){
						  zd+=1;
					   }else{
						  wgcd+=1;
					   }
					  
					  
				  }else{
					 //有原因的  
					if(null!=tAttendance.getBossid()){
						ygcd+=1;
					}else{
						others+=1;
					}  
					  
					  
				  }
				    
				  
				
		    	}
			  
	
			  req.setAttribute("zd", zd);
			  req.setAttribute("wgcd", wgcd);
			  req.setAttribute("ygcd", ygcd);
			  req.setAttribute("others", others);
			  req.setAttribute("tAttendances", tAttendances);
			
		  }
		
		  req.setAttribute("month", month);
		
		return "/showOne.jsp";
		
	  }
	    return "/index.jsp";	
	}
	
	
	//export.do
	@RequestMapping("export.do")
	public String export(HttpServletRequest req) throws ParseException{
		TUser user= (TUser) req.getSession().getAttribute("user");
		//没有登录的不让查询
	 if(null!=user&&2!=user.getAid()){		
		
		Date date=new Date();
		String	month=DateUtil.datefm.format(date);
		
		
		//System.out.println(month);
		
		   
		List<TAttendance>  tAttendances = kqbiz.showDptKq(month,user.getGid());
          //解析
		  //统计考勤信息  
		//    准点      无故迟到    有原因的        其他
		  int zd=0,wgcd=0,ygcd=0,others=0;
		  
		  if(null!=tAttendances&&tAttendances.size()>0){
			  //对每一条考勤信息 进行判断
			  for (TAttendance tAttendance : tAttendances) {
				  
				    // 正常考勤
				  if(1==tAttendance.getAttendanceType()){
					  // 打卡时间
					  Date tmpdate2=DateUtil.datefm2.parse(tAttendance.getAttendanceEvery());
					
					  //上班规定的时间
					  Date tmpdate=DateUtil.datefm2.parse("9:00:00");
					  //System.out.println(tmpdate2+"   "+tmpdate);
					  //统计正常   打开时间  在  规定时间   之前
					  if(tmpdate2.before(tmpdate)){
						  zd+=1;
					   }else{
						  wgcd+=1;
					   }
					  
					  
				  }else{
					 //有原因的  
					if(null!=tAttendance.getBossid()){
						ygcd+=1;
					}else{
						others+=1;
					}  
					  
					  
				  }
				    
				  
				
		    	}
			  
	
			  req.setAttribute("zd", zd);
			  req.setAttribute("wgcd", wgcd);
			  req.setAttribute("ygcd", ygcd);
			  req.setAttribute("others", others);
			  req.setAttribute("tAttendances", tAttendances);
			
		  }
	
		return "/export.jsp";
		
	  }
	    return "/index.jsp";	
	}
	
	
	
	
	@RequestMapping("Bq.do")
	public String Bq(HttpServletRequest req,String date,String  reson) throws ParseException {
		
		//System.out.println(date+"   —"+reson);
		//判定   用户  补勤  当天   是否有考勤 
		//从session 获取用户个人信息
		 TUser user=(TUser) req.getSession().getAttribute("user");
		//获取日期                        
		boolean  pd =kqbiz.firstKq(user.getUid(),date);
		 
		//如果当天是第一次。  就 加入考勤信息到数据库  else  不能补考勤
		String msg="不能添加考勤！因为改日已有考勤记录";
		 Date nowDate=new Date();
		//补考勤日期 必须在当前日期之前      
		boolean day=	DateUtil.datefm3.parse(date).before(nowDate);
		
		//  判定当天首次考勤     &&        判定  补考勤日期 必须 小于当前日期
		if(pd&&day){
			//构建好 添加的原材料
			TAttendance  tAttendance=new TAttendance();
			tAttendance.setAttendanceDay(date);
			// 补考勤的时间 随便给。。。。
			tAttendance.setAttendanceEvery(DateUtil.datefm2.format(nowDate));
			//记录什么时候补考勤的
			tAttendance.setAttendanceTime(nowDate);
			//原因
			tAttendance.setExceptionExplain(reson);
			//考勤类型
			tAttendance.setAttendanceType(2);
			//设置员工id
			tAttendance.setEmpid(user.getUid());
			//添加补考勤
			  int i =kqbiz.addKq(tAttendance);
			  if(i==1){
				  msg="添加成功！"; 
			  }
			
		}
		
		req.setAttribute("msg", msg);
		return "showKqAction.do";
	}
	 
	
	@RequestMapping("toSpkq.do")
	public String toSpkq(HttpServletRequest req){
		
		TUser user =(TUser) req.getSession().getAttribute("user");
		
		if(1!=user.getAid()){
			return "main.jsp";
		}
		
		//查询出没有被审批的考勤信息  
		List<TAttendance>  tAttendances =kqbiz.showSp();
		if(null!=tAttendances){
			req.setAttribute("tAttendances", tAttendances);
		}
		
		return "sp.jsp";
	}
	
	
	//审批考勤  updSpAction.do?kid="+this.id+"&reason="+reason;
	@RequestMapping("updSpAction.do")
	public String updSpAction(HttpServletRequest req,String kid,String reason){
		
	  System.out.println(kid+"  "+reason);
	  //通过kid  找到该考勤记录
	  
	  //  把reason补上          不bossid 补上   完成考勤  修改
		
		return "toSpkq.do";
	}
	
	
	
	
	
	

}
