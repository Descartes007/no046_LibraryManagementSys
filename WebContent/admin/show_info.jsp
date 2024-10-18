<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书管理系统</title>
</head>
<body>
	<%
	String error = (String)session.getAttribute("error");
	if(error!=null&&!error.equals("")){
		out.print(error);
		session.setAttribute("error", "");
	}
	
	String success = (String)session.getAttribute("success");
	if(success!=null&&!success.equals("")){
		out.print(success);
		session.setAttribute("success", "");
	}

	%>
</body>
</html>