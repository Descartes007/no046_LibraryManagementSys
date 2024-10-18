package com.henu.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Flags.Flag;

import com.henu.Db.DbUtil;
import com.henu.bean.Info;
import com.henu.dao.IInfoDao;

public class InfoDaoImpl implements IInfoDao {

	@Override
	public boolean add(Info info) {
		int result = 0;
		String sql = "insert into borrow(id,bookname,type,date,days,count) values(?,?,?,?,?,?)";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setString(1, info.getId());
			ps.setString(2, info.getBookname());
			ps.setString(3, info.getType());
			ps.setString(4, info.getDate());
			ps.setInt(5, info.getDays());
			ps.setInt(6, info.getCon());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean select(String bookname) {
		int c = 0;
		String sql = "select * from borrow where bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		try {
			ps.setString(1, bookname);
			rs = ps.executeQuery();
			if(rs.next()){
				c = rs.getRow();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(bookname+" "+c);
		if(c > 0)
			return true;
		else
			return false;
		
	}

	@Override
	public List<Info> searchBorrow()
	{
		List<Info> list=new ArrayList<Info>();
		String sql = "select * from borrow ";
		try {
			ResultSet rs=DbUtil.executeQuery(sql);
			while(rs.next())
			{
				Info info=new Info();
				info.setId(rs.getString("id"));
				info.setBookname(rs.getString("bookname"));
				info.setType(rs.getString("type"));
				info.setDays(rs.getInt("days"));
				info.setCon(rs.getInt("count"));
				info.setDate(rs.getString("date"));
				
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean isBorrow(String id, String bookname) {
		String sql = "select * from borrow where id=? and bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		boolean result = false;
		
		try {
			ps.setString(1, id);
			ps.setString(2, bookname);
			rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}else{
				result = false;
			}
		} catch (SQLException e) {
			result = false;
		}
		
		return result;
		
	}

	@Override
	public Boolean huan(String id, String bookname) {
		String sql = "delete from borrow where id=? and bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		int result = 0;
		try {
			ps.setString(1, id);
			ps.setString(2, bookname);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

}
