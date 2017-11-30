<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/four.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">

                   $(function(){
                	   
                	   $("#ip_rd").click(function(){
                		   
                		   var reason=$("input[ name='reson']").val();
                		   
                		   if(reason== '' || reason == null){
                			     
                			     $("#reson").html("请输入请假理由！");
                			     return   false;
                		   }
                		   
                		   
                	   });
                	   
                	   $("input[ name='reson']").keyup(function(){
                		 
  						var reason=$("input[ name='reson']").val();
                		   
                		   if(reason != '' || reason != null){
                			     
                			   $("#reson").html("");              			  
                		   }
                		   
                	   });
                	   
                   });

</script>
</head>
<body>
   
      <h1>个人考勤中心</h1>
      
       <br />
                       当月考勤
         <br></br>
        <div   style="background-color: gray;width: 550px;">
             
             <div>
                        ${msg }
                        
                     <form action="Bq.do">
                     
                     选择时间:<input name="date"  onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /><br />
                     补勤原因:<input  name="reson" /> <span id="reson"></span>   <br />
                     <input  id="ip_rd"   type="submit"  value="补考勤"  />          
                      
                     </form>
             
             </div>
             <hr />
             
              <div>
                   <form action="showKqAction.do">
                      <table>
                         <tr>
                        <td>查询指定月份</td><td><input  name="month"  onclick="WdatePicker({dateFmt:'yyyy-MM'})"  value="${month}"></input></td>
                         </tr>
                         <tr>
                           <td> <input type="submit" value="查询"></input></td>
                         </tr>
                      </table>
                   
                   </form>      
              </div>
            
              <div>
                <c:if test="${tAttendances == null}">
              			       没有数据
                </c:if>
                
                
                <c:if test="${tAttendances != null}">
                    <table border="1">
                    
                    <tr><th style="width: 150">日期</th><th style="width: 150">打开时间</th><th style="width: 250">说明原由</th></tr>
                         
                         <c:forEach var="tAttendance"  items="${tAttendances}">
                          <tr>
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