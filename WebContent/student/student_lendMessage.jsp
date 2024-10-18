<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormat"%>
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
<%
	Date now = new Date();
	Calendar cal = Calendar.getInstance();

	DateFormat d1 = DateFormat.getDateInstance(); //默认语言（汉语）下的默认风格（MEDIUM风格，比如：2008-6-16 20:54:53）
	String str1 = d1.format(now);
%>
<jsp:include page="../admin/show_info.jsp"></jsp:include>
<body background="../img/background.jpg" onload="startTime()">

	<h2 align="center" style="margin-top: 20px">借阅信息</h2>
	<div class="container">
		<div class="row " style="margin-top: 50px;">
			<div align="center" class="col-md-3">
				<ul class="list-group"">
					<li class="list-group-item"><a href="student_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item"><a href="../ShowBookInfo"><span
							style="color: black">借书信息</span></a></li>
					<li class="list-group-item   active"><a
						href="../SelectAllBook?type=student"><span
							style="color: black">借书</span></a></li>
					<li class="list-group-item"><a href="student_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<form action="../BorrowBook" method="post">
					<table style="margin-left: 50px;">
						<tr>
							<td align="right"><b>书名:<b></td>
							<td style="padding-left: 20px"><input
								style="margin-left: 50px; margin-top: 10px;" type="text"
								readonly="readonly" class="form-control inputclass"
								name="bookname" value="<%=request.getParameter("name")%>"></td>
						</tr>
						<tr>
							<td align="right"><b>数量:<b></td>
							<td style="padding-left: 20px"><input type="text"
								style="margin-left: 50px; margin-top: 10px;"
								class="form-control inputclass" name="counts"></td>

						</tr>

						<tr>
							<td align="right"><b>借阅天数:<b></td>
							<td style="padding-left: 20px"><input maxlength="1"
								type="text" style="margin-left: 50px; margin-top: 10px;"
								class="form-control inputclass" name="days"></td>

						</tr>

						<tr>
							<td align="right"><b>借阅日期:<b></td>
							<td style="padding-left: 20px"><input maxlength="1"
								type="text" style="margin-left: 50px; margin-top: 10px;"
								readonly="readonly" class="form-control inputclass" name="date"
								value="<%out.print(str1);%>"></td>
						</tr>
					</table>
					<button type="submit" style="margin-left: 180px; margin-top: 30px;"
						class="btn btn-info">借阅</button>

					<a href="../SelectAllBook?type=student" class="btn btn-danger"
						style="margin-left: 80px; margin-top: 30px;"><span>取消</span></a>
				</form>
			</div>
		</div>
	</div>



</body>
</html>