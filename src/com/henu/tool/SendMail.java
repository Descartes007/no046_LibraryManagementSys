package com.henu.tool;

import com.henu.service.UserManager;

public class SendMail implements Runnable{

	private String username;
	private String password;
	private String email;
	UserManager userManager;
	public SendMail(String username,String password,String email,UserManager userManager) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.userManager = userManager;
	}
	
	@Override
	public void run() {
		userManager.Register(username, password, email);
	}
}
