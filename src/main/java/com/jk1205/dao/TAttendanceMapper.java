package com.jk1205.dao;

import com.jk1205.pojo.TAttendance;
import com.jk1205.pojo.TAttendanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAttendanceMapper {
    int countByExample(TAttendanceExample example);

    int deleteByExample(TAttendanceExample example);

    int deleteByPrimaryKey(Integer kid);

    int insert(TAttendance record);

    int insertSelective(TAttendance record);

    List<TAttendance> selectByExample(TAttendanceExample example);

    TAttendance selectByPrimaryKey(Integer kid);

    int updateByExampleSelective(@Param("record") TAttendance record, @Param("example") TAttendanceExample example);

    int updateByExample(@Param("record") TAttendance record, @Param("example") TAttendanceExample example);

    int updateByPrimaryKeySelective(TAttendance record);

    int updateByPrimaryKey(TAttendance record);

     //查询个人考勤   通过  月份  和  session获取员工id
	List<TAttendance> findByMonthAndEid(@Param("month") String month,@Param("uid")  Integer uid);

	List<TAttendance> findByMonthAndAid(@Param("month")String month,@Param("gid") Integer gid);

	List<TAttendance> findBySp();

}