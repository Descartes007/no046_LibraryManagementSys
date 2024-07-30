package com.henu.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.henu.Db.DbUtil;
import com.henu.bean.Student;
import com.henu.factory.DaoFactory;
import com.henu.tool.GetStudentData;

/**
 * Servlet implementation class ImportFromExcel
 */
@WebServlet("/ImportFromExcel")
public class ImportStudentFromExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImportStudentFromExcel() {
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
		//选择的路径,前段需要更改
		String path = request.getParameter("file");
		List<Student> list = GetStudentData.getAllByExcel(path);
		HttpSession session = request.getSession();
		try {
			for(Student student : list){
				if(!GetStudentData.isExist(student.getId())){
					//如果数据库中没有此记录，则添加进去
					DaoFactory.getStudentDaoImpl().addStudent(student);
				}
			}
			session.setAttribute("success", "<script> alert('导入成功!') </script>");
			DbUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//添加完后要跳转的界面
		request.getRequestDispatcher("FenYe").forward(request, response);
	}

}
