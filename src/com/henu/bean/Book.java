package com.henu.bean;

import java.sql.Date;

public class Book {
	private String bookname;  //书名
	private String author;  //作者
	private String press;	//出版社
	private String pubdate; //出版时间
	private String type;  //类型
	private String bookshelf;  //书架
	private int count;  //数量
	
	public Book(){}
	
	public Book(String bookname,String author,String press,String pubdate,String type,String bookshelf,int count){
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.pubdate = pubdate;
		this.type = type;
		this.bookshelf = bookshelf;
		this.count = count;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getPubdate() {
		return pubdate;
	}

	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBookshelf() {
		return bookshelf;
	}

	public void setBookshelf(String bookshelf) {
		this.bookshelf = bookshelf;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
