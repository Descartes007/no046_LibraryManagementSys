package com.henu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Book;
import com.henu.bean.Student;
import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class FenYe
 */
@WebServlet("/FenYe")
public class FenYe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FenYe() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int pages; // 总页数
		int count = DaoFactory.getStudentDaoImpl().allCount();// 获得记录总条数
		int pageSize = 5; // 设置每页显示5条记录
		// 计算总页数
		if (count % pageSize == 0) {
			pages = count / pageSize; // 总页数
		} else {
			pages = count / pageSize + 1; // 总页数
		}
		
		int currpage = 1; // 当前页码

		
		String page = request.getParameter("page");
		if (page != null) { // 判断传递的页码是否存在
			int t = Integer.parseInt(page);
			if(t > 0 && t < pages)
				currpage = t; // 将点击的页码号赋给当前页码
			if(t==0)
				currpage = 1;
			if(t==pages)
				currpage = pages;
		}

		List<Student> list = DaoFactory.getStudentDaoImpl().findAllStudent();// 查出学生信息

		

		StringBuilder sb1 = new StringBuilder(); // 存放本页图书信息
		// 取出本页的数据
		for (int i = (currpage - 1) * pageSize; i < list.size() && i < currpage * pageSize; i++) {
			Student student = list.get(i);
			sb1.append("<tr><td>"+student.getId()+"</td>");
			sb1.append("<td>"+student.getName()+"</td>");
			sb1.append("<td>"+student.getGender()+"</td>");
			sb1.append("<td>"+student.getPhone()+"</td>");
			sb1.append("<td>"+student.getEmail()+"</td>");
			sb1.append("<td>"+student.getDepartment()+"</td>");
			sb1.append("<td><a class='btn btn-info' href='../SelectBorrowinfo?id="+student.getId()+"'>详情</a>"
					+ "<a class='btn btn-danger btn-xs' href='../DeleteStudent?id="+student.getId()+"'>删除</a>"
					+ "<a class='btn btn-success btn-xs' href='../PreUpdateStudent?id="+student.getId()+"'>编辑</a></td>");
			
		}
		
		session.setAttribute("sb1", sb1.toString());
		
		StringBuilder sb = new StringBuilder(); // 存放页数信息
		
		for (int i = 1; i <= pages; i++) {
			// 构建分页当行条
			if (i == currpage) {
				sb.append("<li class='active page-item'><a  class='page-link' href='#'>" + i + "</a></li>");
			} else {
				sb.append("<li class='page-item'><a  class='page-link' href='../FenYe?page=" + i + "'>" + i + "</a></li>");
			}
		}
		
		if(currpage == 1){
			session.setAttribute("current1", 0);
		}else{
			session.setAttribute("current1", currpage-1);
		}
		
		if(currpage == pages){
			session.setAttribute("current2", pages);
		}else{
			session.setAttribute("current2", currpage+1);
		}

		session.setAttribute("bar", sb.toString());
		// 跳转到显示界面
		response.sendRedirect("admin/admin_selectAll.jsp");
		//request.getRequestDispatcher("admin/admin_selectAll.jsp").forward(request, response);

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
