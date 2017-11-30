package com.jk1205.service;

import java.util.List;

import com.jk1205.pojo.TAttendance;

public interface KqBiz {

	List<TAttendance> showKq(String month, Integer uid);

	List<TAttendance> showDptKq(String month, Integer gid);

	boolean firstKq(Integer uid, String date);

	int addKq(TAttendance tAttendance);

	List<TAttendance> showSp();

}
