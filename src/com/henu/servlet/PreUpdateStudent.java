package com.henu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Student;
import com.henu.factory.DaoFactory;

@WebServlet("/PreUpdateStudent")
public class PreUpdateStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PreUpdateStudent() {
		// TODO Auto-generated constructor stub
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuId = request.getParameter("id");
		HttpSession session=request.getSession();
		
		Student student=(Student)DaoFactory.getStudentDaoImpl().findStudentById(stuId) ;
		System.out.println(student.getId());
		request.setAttribute("student1", student);
		request.getRequestDispatcher("admin/admin_updateOneStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
