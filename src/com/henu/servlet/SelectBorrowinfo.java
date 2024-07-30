package com.henu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Info;
import com.henu.bean.Student;
import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class SelectBorrowinfo
 */
@WebServlet("/SelectBorrowinfo")
public class SelectBorrowinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBorrowinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String studentid = request.getParameter("id");
		List<Info> list=DaoFactory.getInfoDaoImpl().searchBorrow();
		StringBuilder sb=new StringBuilder();
		boolean isborrow=false;
		for(Info info:list)
		{
			if(info.getId().equals(studentid))
			{
				System.out.println(info.getId()+"  "+studentid);
				sb.append("<tr><td>"+info.getBookname()+"</td>");
				sb.append("<td>"+info.getType()+"</td>");
				sb.append("<td>"+info.getDate()+"</td>");
				sb.append("<td>"+info.getDays()+"</td>");
				sb.append("<td>"+info.getCon()+"</td></tr>");
				isborrow=true;
			}
			
		}
		HttpSession session = request.getSession();
		session.setAttribute("display", "");
		if(!isborrow)
		{
			sb.append("<center><h5 style='margin-top: 50px' >此学生没有借书!</h5></center>");
			session.setAttribute("display", "none");
		}
		
		
		session.setAttribute("studentinfo", sb.toString());
		response.sendRedirect("admin/amdin_borrowInfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
