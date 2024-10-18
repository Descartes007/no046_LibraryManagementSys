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
import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class SelectAllBook
 */
@WebServlet("/SelectAllBook")
public class SelectAllBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectAllBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> list = DaoFactory.getBookDaoImpl().selectAllBook();
		String type = request.getParameter("type");
		StringBuilder sb = new StringBuilder();
		for (Book book : list) {
			sb.append("<tr><td>" + book.getBookname() + "</td>");
			sb.append("<td>" + book.getAuthor() + "</td>");
			sb.append("<td>" + book.getPress() + "</td>");
			sb.append("<td>" + book.getPubdate() + "</td>");
			sb.append("<td>" + book.getType() + "</td>");
			sb.append("<td>" + book.getBookshelf() + "</td>");
			sb.append("<td>" + book.getCount() + "</td>");
			if (type.equals("admin"))
				sb.append("<td><a href='../DeleteBook?name=" + book.getBookname()
						+ "&type=admin' class='btn btn-danger'>删除</a></td></tr>");
			if (type.equals("student"))
				sb.append("<td><a href='student_lendMessage.jsp?name=" + book.getBookname()
						+ "' class='btn btn-danger'>借阅</a></td></tr>");
		}

		HttpSession session = request.getSession();
		session.setAttribute("bookinfo", sb.toString());
		if (type.equals("admin"))
			response.sendRedirect("admin/admin_changeBook.jsp");
		if (type.equals("student"))
			response.sendRedirect("student/student_lend.jsp");
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
