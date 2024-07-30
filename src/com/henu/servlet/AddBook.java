package com.henu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.bean.Book;
import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String date = request.getParameter("date");
		String type = request.getParameter("type");
		String bookshelf = request.getParameter("bookshelf");
		int count = Integer.parseInt(request.getParameter("count"));
		Book book = new Book(bookname,author,press,date,type,bookshelf,count);
		int result = DaoFactory.getBookDaoImpl().addBook(book);
		HttpSession session = request.getSession();
		if(result > 0){
			session.setAttribute("success", "<script> alert('添加成功')</script>");
		}else{
			session.setAttribute("success", "<script> alert('添加失败')</script>");
		}
		response.sendRedirect("admin/admin_addBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
