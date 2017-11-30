<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="zh_cn">
<head>
   <meta charset=UTF-8>
   <title>err2</title>
     <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
   <script type="text/javascript">
       

   
   </script>
</head>
<body>
   
   <p>
   <c:if test="${msg!=null }">
      <c:forEach  items="${msg}" var="err">
            <span style="color: red;">${err.defaultMessage }</span>
      </c:forEach>
   
   </c:if>
   
   <br>
   <img alt="" src="/imgs/err.bmp">
     
   
</body>
</html>
