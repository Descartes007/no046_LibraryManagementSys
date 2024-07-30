package com.henu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.factory.DaoFactory;

/**
 * Servlet implementation class HuanShu
 */
@WebServlet("/HuanShu")
public class HuanShu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuanShu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String bookname = request.getParameter("book");
		String id = (String)session.getAttribute("studentId");
		int con = Integer.parseInt(request.getParameter("count"));
		DaoFactory.getBookDaoImpl().changeCount(bookname, con, "huan");
		if(DaoFactory.getInfoDaoImpl().huan(id, bookname)){
			session.setAttribute("success", "<script> alert('还书成功!') </script>");
		}else{
			session.setAttribute("error", "<script> alert('还书失败!') </script>");
		}
		request.getRequestDispatcher("ShowBookInfo").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
