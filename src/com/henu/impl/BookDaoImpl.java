package com.henu.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.henu.Db.DbUtil;
import com.henu.bean.Book;
import com.henu.dao.IBookDao;
import com.sun.xml.internal.ws.db.glassfish.BridgeWrapper;

public class BookDaoImpl implements IBookDao {

	@Override
	public int addBook(Book book) {
		int result = 0;
		String sql = "insert into book(bookname,author,press,pubdate,type,bookshelf,count) values (?,?,?,?,?,?,?)";
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
	public List<Book> selectAllBook() {
		List<Book> list = new ArrayList<>();
		String sql = "select * from book";
		ResultSet rs = null;
		rs = DbUtil.executeQuery(sql);
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setBookname(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setPress(rs.getString(3));
				book.setPubdate(rs.getString(4));
				book.setType(rs.getString(5));
				book.setBookshelf(rs.getString(6));
				book.setCount(rs.getInt(7));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteBook(String bookname) {
		int result = 0;
		String sql = "delete from book where bookname=?";
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
	public boolean isEnough(String bookname, int count) {
		String sql = "select count from book where bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		int c = 0;
		try {
			ps.setString(1, bookname);
			rs = ps.executeQuery();
			if (rs.next()) {
				c = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (c >= count) {
			return true;
		} else{
			return false;
		}
	}

	@Override
	public int changeCount(String bookname, int c, String type) {
		int result = 0;
		String sql = "";
		if(type.equals("jie")){
			sql = "update book set count=count-? where bookname=?";
		}
		if(type.equals("huan")){
			sql = "update book set count=count+? where bookname=?";
		}
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		try {
			ps.setInt(1, c);
			ps.setString(2, bookname);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	@Override
	public Book book(String bookname) {
		String sql = "select * from book where bookname=?";
		PreparedStatement ps = DbUtil.executePreparedStatement(sql);
		ResultSet rs = null;
		Book book = new Book();
		try {
			ps.setString(1, bookname);
			rs = ps.executeQuery();
			if(rs.next()){
				book.setBookname(rs.getString(1));
				book.setAuthor(rs.getString(2));
				book.setPress(rs.getString(3));
				book.setPubdate(rs.getString(4));
				book.setType(rs.getString(5));
				book.setBookshelf(rs.getString(6));
				book.setCount(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	

}
