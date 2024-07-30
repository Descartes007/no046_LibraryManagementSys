package com.henu.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.henu.Db.DbUtil;
import com.henu.bean.Book;
import com.henu.bean.Info;
import com.henu.bean.Student;
import com.henu.dao.IStudentDao;

public class StudentDaoImpl implements IStudentDao {
	
	@Override
	public int deleteStudent(String id) {
		int result = 0;
		String sql = "delete from student where id=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStudent(Student student) {
		int result = 0;
		String sql = "update student set name=?,gender=?, phone=?, email=?,department=? where id=?";
		/*String sql = "insert into student(id,name,gender,phone,email,department,islogin) values (?,?,?,?,?,?,?)";*/
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
		
			ps.setString(1, student.getName());
			ps.setString(2, student.getGender());
			ps.setString(3, student.getPhone());
			ps.setString(4, student.getEmail());
			ps.setString(5, student.getDepartment());
			ps.setString(6, student.getId());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int addStudent(Student student) {
		int result = 0;
		String sql = "insert into student(id,name,gender,phone,email,department,islogin) values (?,?,?,?,?,?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getGender());
			ps.setString(4, student.getPhone());
			ps.setString(5, student.getEmail());
			ps.setString(6, student.getDepartment());
			ps.setInt(7, student.getIslogin());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean login(String id, String name) {
		boolean flag = false;
		String sql = "select name from student where id=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				if (rs.getString("name").equals(name)) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public List<Student> findAllStudent() {
		List<Student> list = new ArrayList<>();
		String sql = "select * from student";
		ResultSet rs = null;
		rs = DbUtil.executeQuery(sql);
		try {
			while(rs.next()){
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setGender(rs.getString(3));
				student.setPhone(rs.getString(4));
				student.setEmail(rs.getString(5));
				student.setDepartment(rs.getString(6));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student findStudentById(String id) {
		Student student = new Student();
		ResultSet rs = null;
		
		String sql = "select * from student where id=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		
		try {		
			ps.setString(1, id);
			rs = ps.executeQuery();	
			if(rs.next()){
			student.setId(rs.getString(1));
			student.setName(rs.getString(2));
			student.setGender(rs.getString(3));
			student.setPhone(rs.getString(4));
			student.setEmail(rs.getString(5));
			student.setDepartment(rs.getString(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	@Override
	public List<Info> findById(String id) {
		List<Info> list = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from borrow where id=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Info info = new Info();
				info.setBookname(rs.getString("bookname"));
				info.setType(rs.getString("type"));
				info.setDate(rs.getString("date"));
				info.setDays(rs.getInt("days"));
				info.setCon(rs.getInt("count"));
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int add(Book book) {
		int result = 0;
		String sql = "insert into book(bookname,author,press,pubdate,type,bookshelf,count) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, book.getBookname());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getPress());
			ps.setString(4, book.getPubdate());
			ps.setString(5, book.getType());
			ps.setString(6, book.getBookshelf());
			ps.setInt(7, book.getCount());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(String bookname) {
		int result = 0;
		String sql = "delete from info where bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, bookname);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void logout(String id) {
		String sql = "update student set islogin=0 where id = ?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean judgeLogin(String id) {
		ResultSet rs = null;
		String sql = "select islogin from student where id = ?";
		int login = 0;
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				login = rs.getInt("islogin");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (login == 0)
			return true;
		else
			return false;
	}


	@Override
	public void change(String id) {
		String sql = "update student set islogin=1 where id=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int allCount() {
		int count = 0;
		String sql = "select count(*) from student";
		ResultSet rs = null;
		rs = DbUtil.executeQuery(sql);
		try {
			if(rs.next()){
				count = rs.getInt(1);
			}
			DbUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
