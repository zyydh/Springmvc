package com.jk1205.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jk1205.dao.TAttendanceMapper;
import com.jk1205.pojo.TAttendance;
import com.jk1205.pojo.TAttendanceExample;
import com.jk1205.pojo.TAttendanceExample.Criteria;

@Component
public class IKqBiz  implements KqBiz{

	@Autowired
	private TAttendanceMapper  tAttendanceMapper;
	
	public List<TAttendance> showKq(String month, Integer uid) {
		return tAttendanceMapper.findByMonthAndEid(month,uid);
	}

	public List<TAttendance> showDptKq(String month, Integer gid) {
		// TODO Auto-generated method stub
		return tAttendanceMapper.findByMonthAndAid(month, gid);
	}

	public boolean firstKq(Integer uid, String date) {
		
		TAttendanceExample  tAttendanceExample=new TAttendanceExample();
		com.jk1205.pojo.TAttendanceExample.Criteria  criteria=	
				tAttendanceExample.createCriteria();
		
		criteria.andAttendanceDayEqualTo(date);
		criteria.andEmpidEqualTo(uid);
	List<TAttendance>	lists=tAttendanceMapper.selectByExample(tAttendanceExample);
		
		if(lists.size()==0){
			return  true;
		}
		
		return false;
	}

	public int addKq(TAttendance tAttendance) {
		// TODO Auto-generated method stub
		return tAttendanceMapper.insert(tAttendance);
	}

	public List<TAttendance> showSp() {
		// TODO Auto-generated method stub
		return tAttendanceMapper.findBySp();
	}

}
