package com.henu.dao;

import java.util.List;

import com.henu.bean.Info;

public interface IInfoDao {
	
	/**
	 * 根据id和bookname删除该条信息
	 * @param id
	 * @param bookname
	 * @return
	 */
	public Boolean huan(String id,String bookname);
	
	/**
	 * 判断该用户是否已经借过此书
	 * @param id
	 * @param bookname
	 * @return
	 */
	public boolean isBorrow(String id,String bookname);

	/**
	 * 添加借书信息
	 * @param info
	 * @return
	 */
	public boolean add(Info info);
	
	/**
	 * 查询此书是否借出
	 * @param bookname
	 * @return
	 */
	public boolean select(String bookname);
	
	public List<Info> searchBorrow();
}
