<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
response.setHeader("Content-Disposition", "attachment;filename=export.xls"); 

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> 

      <h1>部门考勤中心</h1>
      
       <br />
                       当月考勤
         <br></br>
        <div   style="background-color: gray;width: 550px;">
             
              <div>
                <c:if test="${tAttendances == null}">
              			       没有数据
                </c:if>
                
                
                <c:if test="${tAttendances != null}">
                    <table border="1">
                    
                    <tr><th>考勤人员日期</th><th>日期</th><th>打开时间</th><th>说明原由</th></tr>
                         
                         <c:forEach var="tAttendance"  items="${tAttendances}">
                          <tr>
                          <th style="width: 150px;">${tAttendance.tuser.uname }</th>
                          <th style="width: 150px;">${tAttendance.attendanceDay }</th>
                          <th style="width: 150px;">${tAttendance.attendanceEvery }</th>
                          <th style="width: 250px;">${tAttendance.exceptionExplain }</th>
                          </tr>  
                         </c:forEach>   
                            
                    </table>
                 </c:if>
              
                 
              </div>
        
        </div>
     <hr />
       <c:if test="${tAttendances != null}">
      		${month }月份考勤统计
     <div   style="background-color: gray;width: 550px;">
               <table border="1">
                   <tr><td colspan="4"  style="width: 550px;" >${month }月份打卡总次数 ${zd+wgcd+ygcd+others }</td></tr>
               		<tr><td>准点</td><td colspan="3">迟到 =${wgcd+ygcd}</td></tr>
               		 <tr><td rowspan="2">${zd }</td><td>无故</td><td>因故</td><td>未确认</td></tr>
                		<tr><td>${wgcd }</td><td>${ygcd }</td><td>${others }</td></tr>
               
               </table>
     
     </div>
          </c:if>

</body>
</html>