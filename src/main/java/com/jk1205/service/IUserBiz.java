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
		
		//��������
		 TUserExample  tUserExample=new TUserExample();
		 Criteria  criteria=tUserExample.createCriteria();
		 
		 criteria.andUnameEqualTo(user.getUname());
		 criteria.andPwdEqualTo(user.getPwd());
		 
	    List<TUser>  users=udao.selectByExample(tUserExample);
	    //�ҵ���¼�û�    ���ظ�Action
	    if(null!=users&&users.size()==1){
	    	
	    	//�ҵ��û�֮��   ����action  ֮ǰ �����Զ����ж�
	    	// �õ��û�id   
	    	TUser   usr   =users.get(0);
	   TAttendanceExample  tAttendanceExample=new TAttendanceExample();
	   com.jk1205.pojo.TAttendanceExample.Criteria  criterias
	   =tAttendanceExample.createCriteria();
	   
	   // ��ӵ���ʱ��
	   Date date=new Date();
	   criterias.andAttendanceDayEqualTo(DateUtil.datefm3.format(date));
	   //���� ��¼�û��� id
	   criterias.andEmpidEqualTo(usr.getUid());
	    	
	   //�����ӽ��в�ѯ    ����з���ֵ   �򲻽��п���
	  List<TAttendance>  tAttendances = tAttendanceMapper.selectByExample(tAttendanceExample);
	   
	  //���Ϊ�� ֤�������һ������
	       if(tAttendances.size()==0){
	    	   //��¼����
	    	   TAttendance tAttendance=new TAttendance();
	    	   // yyyy-MM-dd
	    	   tAttendance.setAttendanceDay(DateUtil.datefm3.format(date));
	    	   // HH:mm:ss
	    	   tAttendance.setAttendanceEvery(DateUtil.datefm2.format(date));
	    	   //Date
	    	   tAttendance.setAttendanceTime(date);
	    	   
	    	   //������ id
	    	   tAttendance.setEmpid(usr.getUid());
	    	   
	    	   //��������    --  ��������
	    	   tAttendance.setAttendanceType(1);
	    	   
	    	   tAttendanceMapper.insert(tAttendance);
	       }
	  
	    	
	    	return usr;
	    }
		
		return null;
	}
	

	 //������� ����һ����
	@Transactional
	public boolean batchImport(String fileName, MultipartFile actfile) {
		
		boolean b=false;
		
		ReadExcel readExcel=new ReadExcel();
		  //����excel      �õ�list��Tuser��    ÿ1����ӽ����ݿ�
		      List<TUser> users  = readExcel.getExcelInfo(fileName, actfile);
		  
		       if(users!=null&&users.size()>0){
		    	   
		    	   
		    	      //����ÿһ��ʵ�� �������
		    	 for (TUser tUser : users) {
		    		 udao.insert(tUser);
				  }     
		    	    b=true;
		    	      
		    	     return b;
		       }
		      
		      
		
		return b;
	}


}
