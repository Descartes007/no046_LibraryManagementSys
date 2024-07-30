<%@page import="com.henu.factory.DaoFactory"%>
<%@page import="com.henu.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"  import="com.henu.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<jsp:include page="show_info.jsp"></jsp:include>
<body background="../img/background.jpg">
	<h2 align="center" style="margin-top: 20px;">更新用户</h2>
	<div class="container">
		<div class="row " style="margin-top: 50px;">
		<div align="center" class="col-md-3">
				<ul class="list-group">
					<li class="list-group-item "><a href="admin_about.jsp"><span
							style="color: black">首页</span></a></li>
					<li class="list-group-item active   "><a href="FenYe"><span
							style="color: black">用户管理</span></a></li>
					<li class="list-group-item "><a href="admin_addStudent.jsp"><span
					style="color: black">添加用户</span></a></li>
					<li class="list-group-item "><a href="SelectAllBook?type=admin"><span
							style="color: black">图书信息</span></a></li>
					<li class="list-group-item "><a href="admin_addBook.jsp"><span
							style="color: black">添加图书</span></a></li>
					<li class="list-group-item"><a href="${pageContext.request.contextPath}/admin/admin_changePwd.jsp"><span
							style="color: black">修改密码</span></a></li>
							<li class="list-group-item"><a href="admin_register.jsp"><span
							style="color: black">添加管理员</span></a></li>
					<li class="list-group-item "><a href="admin_exit.jsp"><span
							style="color: black">退出</span></a></li>
				</ul>
			</div>
			<div class="col-md-9">
				<div class="container" align="center">
					<form action="UpdateOneStudent"  method="post">
						<table align="center">
							<tr>
								<td align="center"><b>学号:</b></td>
								<td><input type="text" name="sno"  value="${student1.id }"
									style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass"></td>
							</tr>
							<tr>
								<td align="center"><b>姓名:</b></td>
								<td><input type="text" name="xingming" value="${student1.name }"
									style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass"></td>
							</tr>

							<tr>
								<td align="center"><b>性别:</b></td>
								<c:if test="${student1.gender=='男'}">
								<td><label class="radio-inline" style="margin-left: 50px;margin-top: 10px"> <input
										type="radio" name="gender" value="男" checked> 男
								</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="女">女
								</label></td>
								</c:if>
								<c:if test="${student1.gender=='女'}">
								<td><label class="radio-inline" style="margin-left: 50px;margin-top: 10px"> <input
										type="radio" name="gender" value="男"> 男
								</label> <label class="radio-inline"> <input type="radio"
										name="gender" value="女"  checked>女
								</label></td>
								</c:if>

							</tr>

							<tr>
								<td align="center"><b>电话:</b></td>
								<td><input type="text" name="phone" value="${student1.phone }"
									style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass form_date"></td>
							</tr>

							<tr>
								<td align="center"><b>电子邮箱:</b></td>
								<td><input type="text" name="email"  value="${student1.email }"
									style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass form_date"></td>
							</tr>

							<tr>
								<td align="center"><b>院系:</b></td>
								<td><input type="text" name="yuan"  value="${student1.department }"
									style="margin-left: 50px; margin-top: 10px;"
									class="form-control inputclass"></td>
							</tr>


						</table>
						<button type="submit" style="margin-left: 120px; margin-top: 30px;"
							class="btn btn-info">修改</button>
						<button type="reset" 
							class="btn btn-info"  	style="margin-left: 80px; margin-top: 30px;">重置</button>
						
					</form>
				</div>

				

			</div>
		</div>
	</div>

</body>
</html>