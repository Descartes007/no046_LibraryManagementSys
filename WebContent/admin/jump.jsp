<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书管理系统</title>
</head>
<body>
	<%
String code = request.getParameter("code");
session.setAttribute("code", code);
%>
	<a href="../ActiveServlet">点击激活</a>
</body>
</html>