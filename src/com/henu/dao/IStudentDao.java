package com.henu.dao;

import java.util.List;

import com.henu.bean.Book;
import com.henu.bean.Info;
import com.henu.bean.Student;

public interface IStudentDao {
	
	/**
	 * 查询总记录的条数
	 * @return
	 */
	public int allCount();
	
	/**
	 * 显示所有学生信息
	 * @return
	 */
	public List<Student> findAllStudent();
	
	/**
	 * 删除学生
	 * @param id 根据学号删除学生
	 * @return 受影响的记录的条数
	 */
	public int deleteStudent(String id);
	
	/**
	 * 保存学生
	 * @param student 保存的对象
	 * @return 受影响的记录的条数
	 */
	public int addStudent(Student student);
	
	/**
	 * 学生退出，把相应的属性设为0
	 * @param id
	 */
	public void logout(String id);
	
	/**
	 * 判断该学生是否登录
	 * @param id
	 * @return
	 */
	public boolean judgeLogin(String id);
	
	/**
	 * 学生登录
	 * @param id 学号
	 * @param name 姓名
	 * @return 登录成功返回true,否则返回false
	 */
	public boolean login(String id,String name);
	
	
	/**
	 * 登录成功后修改标志位1
	 * @param id
	 */
	public void change(String id);
	
	/**
	 * 查询借书信息
	 * @param id 学号
	 * @return 借书信息
	 */
	public List<Info> findById(String id);
	
	/**
	 * 借书
	 * @param book 图书对象
	 * @return 受影响个数
	 */
	public int add(Book book);
	
	/**
	 * 还书
	 * @param book
	 * @return
	 */
	public int delete(String bookname);

	public Student findStudentById(String id);

	int updateStudent(Student student);
}
