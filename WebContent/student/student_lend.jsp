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
<jsp:include page="../admin/show_info.jsp"></jsp:include>
<body background="../img/background.jpg">
	<h2 align="center" style="margin-top: 20px">借阅图书</h2>
	<div class="container">
		<div class="row " style="margin-top: 50px;">
			<div align="center" class="col-md-3">
				<ul class="list-group"">
					<li class="list-group-item"><a href="student_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item"><a href="../ShowBookInfo"><span
							style="color: black">借书信息</span></a></li>
					<li class="list-group-item   active"><span
						style="color: black">借书</span></li>
					<li class="list-group-item"><a href="student_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<table align="center" class="table table-bordered">
					<tr>
						<th>书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>出版日期</th>
						<th>类型</th>
						<th>书架</th>
						<th>数量</th>
						<th> </th>
					</tr>
					<%=(String)session.getAttribute("bookinfo") %>
				</table>
			</div>
		</div>
	</div>
</body>
</html>