package com.henu.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.henu.Db.DbUtil;
import com.henu.bean.Book;
import com.henu.bean.Manager;
import com.henu.bean.Student;
import com.henu.dao.IManagerDao;
import com.henu.tool.DesUtils;

public class ManagerDaoImpl implements IManagerDao{

	@Override
	public List<Student> findBorrowBook() {
		
		return null;
	}

	@Override
	public int changePwd(String username, String newPwd) {
		int result = 0;
		
		String sql = "update manager set password=? where username=?";
		String pwd = DesUtils.jiami(newPwd);
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, pwd);
			ps.setString(2, username);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int changePosition(String bookname, String bookshelf) {
		int result = 0;
		String sql = "update book set bookshelf=? where bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, bookshelf);
			ps.setString(2, bookname);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void logout(String username) {
		String sql = "update manager set islogin=0 where username = ?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean judgeLogin(String username) {
		ResultSet rs = null;
		int result = 0;
		String sql = "select islogin from manager where username = ?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getInt("islogin");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean login(String username, String pwd) {
		
		String sql = "select password from manager where username=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
		
	}
	
	/*public boolean login(String username, String pwd) {
		boolean flag = false;
		String p = DesUtils.jiami(pwd);
		String sql = "select password from manager where username=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				if (rs.getString("password").equals(p)) {
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
*/
	@Override
	public boolean checkState(String username) {
		boolean flag = false;
		String sql = "select state from manager where username=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				if (rs.getInt("state")!=0) {
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
	public String findUserByCode(String code) {
		String username="";
		String sql = "select username from manager where code=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, code);
			rs = ps.executeQuery();
			if(rs.next()){
				username = rs.getString("username");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return username;
	}

	@Override
	public void addAdmin(Manager manager) {
		String sql = "insert into manager (username,password,code) values(?,?,?)";
		String pwd = DesUtils.jiami(manager.getPassword());
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, manager.getUsername());
			ps.setString(2, pwd);
			ps.setString(3, manager.getCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean setState(String username) {
		boolean result = false;
		String sql = "update manager set state=1 where username=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, username);
			result = ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void change(String username) {
		String sql = "update manager set islogin=1 where username=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, username);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPassword(String username) {
		String sql = "select password from manager where username=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		String password = "";
		ResultSet rs = null;
		try {
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				password = DesUtils.jiemi(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

}
