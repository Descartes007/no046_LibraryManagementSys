package com.henu.dao;

import java.util.List;

import com.henu.bean.Book;
import com.henu.bean.Manager;
import com.henu.bean.Student;

public interface IManagerDao {
	
	
	/**
	 * 根据用户名得到密码
	 * @param username
	 * @return
	 */
	public String getPassword(String username);
	
	/**
	 * 改变管理员的激活状态
	 * @param username
	 * @return
	 */
	public boolean setState(String username);
	
	/**
	 * 查看管理员的激活状态
	 * @param username
	 * @return
	 */
	public boolean checkState(String username);
	
	/**
	 * 通过激活码查找用户名
	 * @param code
	 */
	public String findUserByCode(String code);
	
	/**
	 * 添加管理员
	 * @param manager
	 */
	public void addAdmin(Manager manager);
	
	/**
	 * 管理员登录
	 * @param username
	 * @param pwd
	 * @return
	 */
	public boolean login(String username,String pwd);
	

	/**
	 * 登录成功后修改标志位1
	 * @param id
	 */
	public void change(String username);
	
	/**
	 * 管理员退出，修改islogin的值为0
	 * @param username
	 */
	public void logout(String username);
	
	/**
	 * 判断管理员是否登录
	 * @param username
	 * @return
	 */
	public boolean judgeLogin(String username);
	
	/**
	 * 显示所有借书学生的信息
	 * @return
	 */
	public List<Student> findBorrowBook();
	
	/**
	 * 修改管理员密码吗
	 * @param username 用户名
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @return
	 */
	public int changePwd(String username,String newPwd);
	
	/**
	 * 更改图书的位置(更换书架)
	 * @param bookname 书名
	 * @param bookshelf 书架
	 * @return
	 */
	public int changePosition(String bookname,String bookshelf);
	
	
}
