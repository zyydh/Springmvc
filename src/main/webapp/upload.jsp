<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/four.css" rel="stylesheet" type="text/css" />
</head>
<body>

    批量上传员工   
    <br>
    ${msg }
   <hr/>
	        
        <form action="upload.do"  method="post" enctype="multipart/form-data">
           <a href="${pageContext.request.contextPath}/imgs/模版.xls">下载模板</a>
              <hr />  
              上传文件:<input type="file"  name="actfile"/>  <br />
            
            <input  type="submit" value="提交" />
          
        </form>
</body>
</html>