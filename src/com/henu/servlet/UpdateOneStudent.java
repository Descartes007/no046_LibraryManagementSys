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

@WebServlet("/UpdateOneStudent")
public class UpdateOneStudent extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UpdateOneStudent() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String id = request.getParameter("sno");
		String name = request.getParameter("xingming");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String department = request.getParameter("yuan");
		Student student = new Student(id, name, gender, phone, email, department, 0);
		int result = DaoFactory.getStudentDaoImpl().updateStudent(student);
		HttpSession session = request.getSession();
		if(result > 0){
			session.setAttribute("success", "<script>alert('修改成功!')</script>");
		}else{
			session.setAttribute("error", "<script>alert('修改失败!')</script>");
		}
		request.getRequestDispatcher("FenYe").forward(request, response);
	}
	

	
}
