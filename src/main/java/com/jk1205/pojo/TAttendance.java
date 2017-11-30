package com.jk1205.pojo;

import java.util.Date;

public class TAttendance {
    private Integer kid;

    private String attendanceDay;

    private String attendanceEvery;

    private Date attendanceTime;

    private String exceptionExplain;

    private String approvalOpinion;

    private Date opinionTime;

    private Integer attendanceType;

    private Integer empid;

    private Integer bossid;
    
    
    private TUser tuser;
    
    

    public TUser getTuser() {
		return tuser;
	}

	public void setTuser(TUser tuser) {
		this.tuser = tuser;
	}

	public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getAttendanceDay() {
        return attendanceDay;
    }

    public void setAttendanceDay(String attendanceDay) {
        this.attendanceDay = attendanceDay == null ? null : attendanceDay.trim();
    }

    public String getAttendanceEvery() {
        return attendanceEvery;
    }

    public void setAttendanceEvery(String attendanceEvery) {
        this.attendanceEvery = attendanceEvery == null ? null : attendanceEvery.trim();
    }

    public Date getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getExceptionExplain() {
        return exceptionExplain;
    }

    public void setExceptionExplain(String exceptionExplain) {
        this.exceptionExplain = exceptionExplain == null ? null : exceptionExplain.trim();
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion == null ? null : approvalOpinion.trim();
    }

    public Date getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(Date opinionTime) {
        this.opinionTime = opinionTime;
    }

    public Integer getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(Integer attendanceType) {
        this.attendanceType = attendanceType;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getBossid() {
        return bossid;
    }

    public void setBossid(Integer bossid) {
        this.bossid = bossid;
    }
}