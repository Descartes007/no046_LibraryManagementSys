<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书管理系统</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<style>
.imgs {
	width: 900px;
	height: 400px;
	background-position: center;
	background-size: cover;
}
</style>
</head>
<body background="../img/background.jpg">
	
		<h2 align="center" style="margin-top: 20px">用户退出</h2>
		<div class="container">
		<div class="row " style="margin-top: 50px;">
			<div align="center" class="col-md-3">
				<ul class="list-group" >
					<li class="list-group-item"><a href="student_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item    "><a href="../ShowBookInfo"><span
							style="color: black">借书信息</span></a></li>
					<li class="list-group-item "><a href="../SelectAllBook?type=student"><span
							style="color: black">借书</span></a></li>
					<li class="list-group-item active"><span
							style="color: black">退出</span></li>
				</ul>
			</div>
			<div  class="col-md-9" align="center" style="border:1px solid black;">
			<h3 align="center" style="padding-top: 20px;">确定要退出吗？</h3>
			<div align="center" style=" padding-top: 80px;width:250px;" class=" row">
				<a  href="../Exit?type=student" class="btn btn-danger "  style="width:80px;margin-right:75px;" > 退出</a>
				<a  href="student_about.jsp"><button class="btn btn-info " style="width:80px" > 取消</button></a>
			</div>
			</div>
		</div>
	</div>
</body>
</html>