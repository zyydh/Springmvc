package com.jk1205.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.jk1205.dao.TAttendanceMapper;
import com.jk1205.dao.TUserMapper;
import com.jk1205.pojo.TAttendance;
import com.jk1205.pojo.TAttendanceExample;
import com.jk1205.pojo.TUser;
import com.jk1205.pojo.TUserExample;
import com.jk1205.pojo.TUserExample.Criteria;
import com.jk1205.util.DateUtil;
import com.jk1205.util.ReadExcel;

@Component
public class IUserBiz  implements UserBiz {
	
	@Autowired
	private TUserMapper  udao;

	@Autowired
	private TAttendanceMapper  tAttendanceMapper;
	
	public TUser login(TUser user) {
		
		//創建例子
		 TUserExample  tUserExample=new TUserExample();
		 Criteria  criteria=tUserExample.createCriteria();
		 
		 criteria.andUnameEqualTo(user.getUname());
		 criteria.andPwdEqualTo(user.getPwd());
		 
	    List<TUser>  users=udao.selectByExample(tUserExample);
	    //找到登录用户    返回给Action
	    if(null!=users&&users.size()==1){
	    	
	    	//找到用户之后   返回action  之前 进行自动打卡判断
	    	// 拿到用户id   
	    	TUser   usr   =users.get(0);
	   TAttendanceExample  tAttendanceExample=new TAttendanceExample();
	   com.jk1205.pojo.TAttendanceExample.Criteria  criterias
	   =tAttendanceExample.createCriteria();
	   
	   // 添加当天时间
	   Date date=new Date();
	   criterias.andAttendanceDayEqualTo(DateUtil.datefm3.format(date));
	   //加入 登录用户的 id
	   criterias.andEmpidEqualTo(usr.getUid());
	    	
	   //把例子进行查询    如果有返回值   则不进行考勤
	  List<TAttendance>  tAttendances = tAttendanceMapper.selectByExample(tAttendanceExample);
	   
	  //如果为空 证明当天第一次来？
	       if(tAttendances.size()==0){
	    	   //记录考勤
	    	   TAttendance tAttendance=new TAttendance();
	    	   // yyyy-MM-dd
	    	   tAttendance.setAttendanceDay(DateUtil.datefm3.format(date));
	    	   // HH:mm:ss
	    	   tAttendance.setAttendanceEvery(DateUtil.datefm2.format(date));
	    	   //Date
	    	   tAttendance.setAttendanceTime(date);
	    	   
	    	   //考勤人 id
	    	   tAttendance.setEmpid(usr.getUid());
	    	   
	    	   //考勤类型    --  正常考勤
	    	   tAttendance.setAttendanceType(1);
	    	   
	    	   tAttendanceMapper.insert(tAttendance);
	       }
	  
	    	
	    	return usr;
	    }
		
		return null;
	}
	

	 //添加事物 保持一致性
	@Transactional
	public boolean batchImport(String fileName, MultipartFile actfile) {
		
		boolean b=false;
		
		ReadExcel readExcel=new ReadExcel();
		  //处理excel      得到list《Tuser》    每1个添加进数据库
		      List<TUser> users  = readExcel.getExcelInfo(fileName, actfile);
		  
		       if(users!=null&&users.size()>0){
		    	   
		    	   
		    	      //解析每一个实体 进行添加
		    	 for (TUser tUser : users) {
		    		 udao.insert(tUser);
				  }     
		    	    b=true;
		    	      
		    	     return b;
		       }
		      
		      
		
		return b;
	}


}
