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
                           
                	   
                	  $(".bt_sp").click(function(){
                		  
                		  var reason=$("#reason_"+this.id).val();
                		  
                		   if(reason == ''){
                			   alert("请填写审批理由！")
                			   return; 
                		   }
                		  
                		  window.location.href="updSpAction.do?kid="+this.id+"&reason="+reason;
                		   
                	  });
                	   
                	   
                   });

</script>
</head>
<body>
   
      <h1>审批考勤中心</h1>
      
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
                    
                    <tr><th>员工姓名</th><th>日期</th><th>打开时间</th><th>说明原由</th><th>审批说明</th><th>操作</th></tr>
                         
                         <c:forEach var="tAttendance"  items="${tAttendances}">
                          <tr>
                          <th>${tAttendance.tuser.uname }</th>
                          <th>${tAttendance.attendanceDay }</th>
                          <th>${tAttendance.attendanceEvery }</th>
                          <th>${tAttendance.exceptionExplain }</th>
                          <th><input  id="reason_${tAttendance.kid}"></input></th>
                           <th><button id="${tAttendance.kid}" class="bt_sp">审批</button> </th> 
                          </tr>  
                         </c:forEach>   
                            
                    </table>
                 </c:if>
              
                 
              </div>
        
        </div>
     <hr />
    
	
</body>
</html>