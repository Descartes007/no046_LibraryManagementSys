package com.henu.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.henu.Db.DbUtil;

import jxl.Workbook;
import jxl.write.Label;

/**
 * Servlet implementation class ExportBookInfo
 */
@WebServlet("/ExportBookInfo")
public class ExportBookInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportBookInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//得到图书数据库中全部数据
			String sql = "select * from book";
			ResultSet rs = null;
			rs = DbUtil.executeQuery(sql);

			//新建Excel文件
			//String filePath = request.getRealPath("Test.xls");
			String filePath = "E:/Book.xls";
			File myFilePath = new File(filePath);
			
			//检查文件是否存在，若存在则删除
			if(myFilePath.exists())
				myFilePath.delete();
			
			//创建一个新的.xls文件
			myFilePath.createNewFile();
			
			//整理数据流
			//OutputStream outf = new FileOutputStream(filePath);
			jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(myFilePath);
			
			//生成名为“sheettest”的工作表，参数0表示这是第一页
			jxl.write.WritableSheet ws = wwb.createSheet("sheettest", 0);
			
			int i=0,j=0;
			//getMetaData()获取此ResultSet对象列的编号、类型、属性
			//getColumnCount()返回此ResultSet对象中的列数
			ws.addCell(new Label(0,0,"书名"));
			ws.addCell(new Label(1,0,"作者"));
			ws.addCell(new Label(2,0,"出版社"));
			ws.addCell(new Label(3,0,"出版日期"));
			ws.addCell(new Label(4,0,"类型"));
			ws.addCell(new Label(5,0,"书架"));
			ws.addCell(new Label(6,0,"数量"));
			
			
			//列数:rs.getMetaData().getColumnCount());
			//插入数据库中的数据
			while(rs.next()){
				for(int k=0;k<rs.getMetaData().getColumnCount();k++){
					ws.addCell(new Label(k,j+i+1,rs.getString(k+1)));
				}
				i++;
			}
			wwb.write();
			wwb.close();
			
			DbUtil.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("admin/admin_changeBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
