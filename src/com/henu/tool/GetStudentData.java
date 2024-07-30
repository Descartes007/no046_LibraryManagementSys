package com.henu.tool;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.henu.Db.DbUtil;
import com.henu.bean.Student;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetStudentData {
	public static List<Student> getAllByExcel(String path) throws IOException {
		if (path == null || path.equals(""))
			path = "E:\\Test.xls";
		File filePath = new File(path);
		List<Student> list = new ArrayList<>();

		try {
			Workbook wb = Workbook.getWorkbook(filePath);
			//得到文件中第一个工作表格，若要得到全部用sheet[] sheets = wb.getSheets()
			Sheet sheet = wb.getSheet(0);

			//得到第一个表中的总行数和列数
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			
			//循环取出表中的所有数据,第一行一般是标题，所以循环从1开始而不是0
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					String id = sheet.getCell(j++, i).getContents();
					String name = sheet.getCell(j++, i).getContents();
					String gender = sheet.getCell(j++, i).getContents();
					String phone = sheet.getCell(j++, i).getContents();
					String email = sheet.getCell(j++, i).getContents();
					String department = sheet.getCell(j++, i).getContents();
					
					list.add(new Student(id, name,gender,phone,email,department,0));
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static boolean isExist(String id){
		String sql = "select * from student where id = ?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, id);
			rs = ps.executeQuery();
			int i = rs.getRow();

			if(rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			return true;
		}
	}
}
