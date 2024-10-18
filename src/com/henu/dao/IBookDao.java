package com.henu.dao;

import java.util.List;

import com.henu.bean.Book;

public interface IBookDao {
	
	
	
	/**
	 * 根据书名查询书籍
	 * @param bookname
	 * @return
	 */
	public Book book(String bookname);
	
	/**
	 * 判断书籍数量是否足够
	 * @param bookname 书名
	 * @param count	借阅数量
	 * @return
	 */
	public boolean isEnough(String bookname,int count);
	
	/**
	 * 更改图书的数量(借书还书后的数量)
	 * @param bookname  书名
	 * @param count	借书或还书的数量
	 * @param type	类型(借书还是还书)
	 * @return
	 */
	public int changeCount(String bookname,int count,String type);
	
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
	public int addBook(Book book);
	
	/**
	 * 查询所有图书信息
	 * @return
	 */
	public List<Book> selectAllBook();
	
	/**
	 * 删除书籍
	 * @param bookname
	 * @return
	 */
	public int deleteBook(String bookname);
}
