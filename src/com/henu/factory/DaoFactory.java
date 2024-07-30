package com.henu.factory;

import com.henu.dao.IBookDao;
import com.henu.dao.IInfoDao;
import com.henu.dao.IManagerDao;
import com.henu.dao.IStudentDao;
import com.henu.impl.BookDaoImpl;
import com.henu.impl.InfoDaoImpl;
import com.henu.impl.ManagerDaoImpl;
import com.henu.impl.StudentDaoImpl;

public class DaoFactory {
	public static IStudentDao getStudentDaoImpl(){
		return new StudentDaoImpl();
	}
	
	public static IManagerDao getManagerDaoImpl(){
		return new ManagerDaoImpl();
	}
	
	public static IBookDao getBookDaoImpl(){
		return new BookDaoImpl();
	}
	
	public static IInfoDao getInfoDaoImpl(){
		return new InfoDaoImpl();
	}
}
