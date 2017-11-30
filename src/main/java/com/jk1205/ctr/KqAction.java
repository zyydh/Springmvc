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
	
	
	//�鿴Ա�����˿��ڼ�¼               Ա��id   session       ʱ���  Ĭ��  ����
	//showKqAction.do
	@RequestMapping("showKqAction.do")
	public String showKqAction(String month,HttpServletRequest req) throws ParseException{
		TUser user= (TUser) req.getSession().getAttribute("user");
		//û�е�¼�Ĳ��ò�ѯ
	 if(null!=user){		
		// �ж�   month �Ƿ�Ϊ�գ�   �������null    Ĭ�ϵ���  
		if(null==month||"".equals(month)){
			//��ȡϵͳ��ǰʱ��
			Date date=new Date();
			month=DateUtil.datefm.format(date);
		}
		
		//System.out.println(month);
		
		   
		List<TAttendance>  tAttendances = kqbiz.showKq(month,user.getUid());
          //����
		  //ͳ�ƿ�����Ϣ  
		//    ׼��      �޹ʳٵ�    ��ԭ���        ����
		  int zd=0,wgcd=0,ygcd=0,others=0;
		  
		  if(null!=tAttendances&&tAttendances.size()>0){
			  //��ÿһ��������Ϣ �����ж�
			  for (TAttendance tAttendance : tAttendances) {
				  
				    // ��������
				  if(1==tAttendance.getAttendanceType()){
					  // ��ʱ��
					  Date tmpdate2=DateUtil.datefm2.parse(tAttendance.getAttendanceEvery());
					
					  //�ϰ�涨��ʱ��
					  Date tmpdate=DateUtil.datefm2.parse("9:00:00");
					 // System.out.println(tmpdate2+"   "+tmpdate);
					  //ͳ������   ��ʱ��  ��  �涨ʱ��   ֮ǰ
					  if(tmpdate2.before(tmpdate)){
						  zd+=1;
					   }else{
						  wgcd+=1;
					   }
					  
					  
				  }else{
					 //��ԭ���  
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
		//û�е�¼�Ĳ��ò�ѯ
	 if(null!=user&&2!=user.getAid()){		
		
		Date date=new Date();
		String	month=DateUtil.datefm.format(date);
		
		
		//System.out.println(month);
		
		   
		List<TAttendance>  tAttendances = kqbiz.showDptKq(month,user.getGid());
          //����
		  //ͳ�ƿ�����Ϣ  
		//    ׼��      �޹ʳٵ�    ��ԭ���        ����
		  int zd=0,wgcd=0,ygcd=0,others=0;
		  
		  if(null!=tAttendances&&tAttendances.size()>0){
			  //��ÿһ��������Ϣ �����ж�
			  for (TAttendance tAttendance : tAttendances) {
				  
				    // ��������
				  if(1==tAttendance.getAttendanceType()){
					  // ��ʱ��
					  Date tmpdate2=DateUtil.datefm2.parse(tAttendance.getAttendanceEvery());
					
					  //�ϰ�涨��ʱ��
					  Date tmpdate=DateUtil.datefm2.parse("9:00:00");
					  //System.out.println(tmpdate2+"   "+tmpdate);
					  //ͳ������   ��ʱ��  ��  �涨ʱ��   ֮ǰ
					  if(tmpdate2.before(tmpdate)){
						  zd+=1;
					   }else{
						  wgcd+=1;
					   }
					  
					  
				  }else{
					 //��ԭ���  
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
		
		//System.out.println(date+"   ��"+reson);
		//�ж�   �û�  ����  ����   �Ƿ��п��� 
		//��session ��ȡ�û�������Ϣ
		 TUser user=(TUser) req.getSession().getAttribute("user");
		//��ȡ����                        
		boolean  pd =kqbiz.firstKq(user.getUid(),date);
		 
		//��������ǵ�һ�Ρ�  �� ���뿼����Ϣ�����ݿ�  else  ���ܲ�����
		String msg="������ӿ��ڣ���Ϊ�������п��ڼ�¼";
		 Date nowDate=new Date();
		//���������� �����ڵ�ǰ����֮ǰ      
		boolean day=	DateUtil.datefm3.parse(date).before(nowDate);
		
		//  �ж������״ο���     &&        �ж�  ���������� ���� С�ڵ�ǰ����
		if(pd&&day){
			//������ ��ӵ�ԭ����
			TAttendance  tAttendance=new TAttendance();
			tAttendance.setAttendanceDay(date);
			// �����ڵ�ʱ�� ������������
			tAttendance.setAttendanceEvery(DateUtil.datefm2.format(nowDate));
			//��¼ʲôʱ�򲹿��ڵ�
			tAttendance.setAttendanceTime(nowDate);
			//ԭ��
			tAttendance.setExceptionExplain(reson);
			//��������
			tAttendance.setAttendanceType(2);
			//����Ա��id
			tAttendance.setEmpid(user.getUid());
			//��Ӳ�����
			  int i =kqbiz.addKq(tAttendance);
			  if(i==1){
				  msg="��ӳɹ���"; 
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
		
		//��ѯ��û�б������Ŀ�����Ϣ  
		List<TAttendance>  tAttendances =kqbiz.showSp();
		if(null!=tAttendances){
			req.setAttribute("tAttendances", tAttendances);
		}
		
		return "sp.jsp";
	}
	
	
	//��������  updSpAction.do?kid="+this.id+"&reason="+reason;
	@RequestMapping("updSpAction.do")
	public String updSpAction(HttpServletRequest req,String kid,String reason){
		
	  System.out.println(kid+"  "+reason);
	  //ͨ��kid  �ҵ��ÿ��ڼ�¼
	  
	  //  ��reason����          ��bossid ����   ��ɿ���  �޸�
		
		return "toSpkq.do";
	}
	
	
	
	
	
	

}
