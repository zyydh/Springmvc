<%@ page contentType="image/jpeg"%>
<%@ page import="javax.imageio.*"%>
<%@ page import="java.io.*"%>
<jsp:useBean id="image" scope="session"
	class="com.jk1205.util.ImageTool" />
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	//设置响应格式
	ImageIO.write(image.creatImage(), "JPEG",
			response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();

	//把验证放到session作用域当中
	session.setAttribute("rand", image.sRand);
%>
