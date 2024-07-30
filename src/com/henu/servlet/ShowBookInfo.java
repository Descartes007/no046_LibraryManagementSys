package com.henu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Info;
import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class ShowBookInfo
 */
@WebServlet("/ShowBookInfo")
public class ShowBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBookInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("studentId");
		List<Info> list = new ArrayList<>();
		list = DaoFactory.getStudentDaoImpl().findById(id);
		StringBuilder sb = new StringBuilder();
		for (Info info : list) {
			sb.append("<tr><td>"+info.getBookname()+"</td>");
			sb.append("<td>"+info.getDays()+"</td>");
			sb.append("<td>"+info.getCon()+"</td>");
			sb.append("<td>"+info.getDate()+"</td>");
			sb.append("<td><a class='btn btn-info' href='../HuanShu?book="+info.getBookname()+"&count="+info.getCon()+"'>还书</a></td></tr>");
		}
		
		session.setAttribute("bookinfo", sb.toString());
		response.sendRedirect("student/student_Message.jsp");
	}

}
