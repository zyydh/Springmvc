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
</head>
<body>
   <hr>
	个人考勤中心
	<br>
	<br>
	<div style="background-color: #848484;width: 550px;">
		<div style="float: left;">
			<form id="form1" action="Bq.do" method="post">
				<table>
					<tr>
						<td>请选择时间:</td>
						<td><input id="ip_date" type="text" name="date" onClick="WdatePicker()" /></td>
					</tr>
					<tr>
						<td>补勤原因</td>
						<td><input id="ip_rd" type="text" name="reson" />
						</td>
					</tr>
					<tr>
						<td><input id="bt_bq" type="button" value="补考勤">
						</td>
					<td></td>
					</tr>
				</table>
			</form>
		</div>
		<div style="height: 62px">
			<form action="showKqAction.do">
				<table>
					<tr>
						<td>查询指定月份:</td>
						<td><input id="date" type="text" name="month"
							onClick="WdatePicker({dateFmt:'yyyy-MM'})"
							value="${month}" />
						</td>
					</tr>

					<tr>
						<td><input type="submit" value="查询">
						</td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
		<br>
		<div>
			<table border="1">
				<tr>
					<td style="width: 200px;">日期</td>
					<td style="width: 200px;">打卡时间</td>
					<td style="width: 150px;">说明原由</td>
				</tr>
					<c:forEach items="${attendances }" var="attendance">
					<tr>
						<td>${attendance.attendanceDay }</td>
						<td>${attendance.attendanceEvery }</td>
						<td>${attendance.exceptionExplain }</td>
					</tr>
			       </c:forEach>
			</table>
		</div>
	</div>
	<br>
	<br> 月份考勤统计:
	<div style="background-color: #848484;width: 550px;">
		<table border="1">
			<tr>
				<td colspan="4" style="width: 550px;"><span>该月总打卡数: ${requestScope.wgcd+requestScope.ygcd+requestScope.zd+requestScope.others }(次)</span>
				</td>
			</tr>
			<tr>
				<td><span>准点</span>
				</td>
				<td colspan="3"><span>迟到或请假:${requestScope.wgcd+requestScope.ygcd }(次)</span>
				</td>
			</tr>
			<tr>
				<td rowspan="2"><span style="color: #006400;">${requestScope.zd}(次)</span></td>
				<td><span>无故</span>
				</td>
				<td><span>因故</span>
				</td>
				<td><span>未被确认</span>
				</td>
			</tr>
			<tr>
				<td><span style="color: red;">${requestScope.wgcd}</span>
				</td>
				<td><span style="color: #006400;">${requestScope.ygcd}</span>
				<td><span style="color: #87CEFA;">${requestScope.others}</span>
				</td>
			</tr>
		</table>
	</div>

	
</body>
</html>