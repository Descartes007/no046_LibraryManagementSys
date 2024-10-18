package com.henu.tool;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.henu.Db.DbUtil;
import com.henu.bean.Book;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetBookData {
	public static List<Book> getAllByExcel(String path) throws IOException {
		if (path == null)
			path = "E:\\Book.xls";
		File filePath = new File(path);
		List<Book> list = new ArrayList<>();

		try {
			Workbook wb = Workbook.getWorkbook(filePath);
			//得到文件中第一个工作表格，若要得到全部用sheet[] sheets = wb.getSheets()
			Sheet sheet = wb.getSheet(0);

			//得到第一个表中的总行数和列数
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			//循环取出表中的所有数据,第一行一般是标题，所有循环从1开始而不是0
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					String bookname = sheet.getCell(j++, i).getContents();
					String author = sheet.getCell(j++, i).getContents();
					String press = sheet.getCell(j++, i).getContents();
					String pubdate = sheet.getCell(j++, i).getContents();
					String type = sheet.getCell(j++, i).getContents();
					String bookshelf = sheet.getCell(j++, i).getContents();
					int count = Integer.parseInt(sheet.getCell(j++, i).getContents());
					

					list.add(new Book(bookname,author,press,pubdate,type,bookshelf,count));
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean isExist(String bookname){
		String sql = "select * from book where bookname = ?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		
		try {
			ps.setString(1, bookname);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}
}
