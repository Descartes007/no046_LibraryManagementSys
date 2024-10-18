package com.henu.service;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.henu.bean.Manager;
import com.henu.factory.DaoFactory;

public class UserManager {
	public void Register(String username, String password, String email) {

		// 生成用户code
		String code = UUID.randomUUID().toString().replace("-", "");

		// 添加用户
		Manager manager = new Manager();
		manager.setUsername(username);
		manager.setPassword(password);
		manager.setCode(code);
		DaoFactory.getManagerDaoImpl().addAdmin(manager);

		// 向用户发送邮件
		sendMail(email, code);
	}

	public static boolean sendMail(String email, String code) {
		try {
			Properties props = new Properties();
			props.put("username", "15824961993@163.com");
			props.put("password", "q1025605919");
			// 发送邮件协议名称
			props.put("mail.transport.protocol", "smtp");
			// 设置邮件服务器主机名
			props.put("mail.smtp.host", "smtp.163.com");
			props.put("mail.smtp.port", "25");

			Session mailSession = Session.getDefaultInstance(props);

			// 创建邮件对象
			Message message = new MimeMessage(mailSession);
			// 发件人
			message.setFrom(new InternetAddress("15824961993@163.com"));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			// 主题
			message.setSubject("激活邮件");
			// HTML内容
			message.setContent(
					"<h1>此邮件为官方激活邮件!请点击下面链接完成激活操作!</h1><h3><a href='http://localhost:8080/Library/admin/jump.jsp?code="
							+ code + "'>http://localhost:8080/Library/mainLogin.jsp</a></h3>",
					"text/html;charset=UTF-8");
			message.saveChanges();

			Transport transport = mailSession.getTransport("smtp");
			transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("username"),
					props.getProperty("password"));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	//激活用户
	public boolean Active(String code){
		String username = DaoFactory.getManagerDaoImpl().findUserByCode(code);
		if(username!=null&&!username.equals("")){
			//将用户的状态设为激活
			DaoFactory.getManagerDaoImpl().setState(username);
			return true;
		}else{
			return false;
		}
	
	}
}
