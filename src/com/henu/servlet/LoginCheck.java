package com.henu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("name");
		String username,pwd;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//普通用户登录
		if (type.equals("user")) {
			//得到输入的用户名，判断该用户是否已经登录
			username = request.getParameter("userid");
			session.setAttribute("studentId", username);
			pwd = request.getParameter("userpwd");
			if(DaoFactory.getStudentDaoImpl().judgeLogin(username)){
				//密码正确,进入学生首页
				if(DaoFactory.getStudentDaoImpl().login(username, pwd)){
					DaoFactory.getStudentDaoImpl().change(username);
					response.sendRedirect("student/student_about.jsp");
				}else{
					//密码错误，返回登录页面
					session.setAttribute("error", "<script> alert('账号或者学号错误!')</script>");
					response.sendRedirect("mainLogin.jsp");
				}
			}else{
				//若用户已登录，返回登录界面
				session.setAttribute("error", "<script> alert('用户一已经登录')</script>");
				response.sendRedirect("mainLogin.jsp");
			}
		}

		//管理员登录
		if (type.equals("manager")) {
			username = request.getParameter("masterid");
			session.setAttribute("masterId", username);
			pwd = request.getParameter("masterpwd");
			//判断该账户是否已经激活
			if(DaoFactory.getManagerDaoImpl().checkState(username)){
				if(DaoFactory.getManagerDaoImpl().judgeLogin(username)){
					//密码正确进入管理员界面
					if(DaoFactory.getManagerDaoImpl().login(username, pwd)){
						DaoFactory.getManagerDaoImpl().change(username);
						response.sendRedirect("admin/admin_about.jsp");
					}else {
						//密码错误，返回登录页面
						session.setAttribute("error", "<script> alert('管理员账号或密码错误!')</script>");
						response.sendRedirect("mainLogin.jsp");
					}
				}else{
					//若用户已登录，返回登录界面
					session.setAttribute("error", "<script> alert('管理员已经登陆!')</script>");
					response.sendRedirect("mainLogin.jsp");
				}	
			}else{
				session.setAttribute("error", "<script> alert('账户未激活!')</script>");
				response.sendRedirect("mainLogin.jsp");
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
}
