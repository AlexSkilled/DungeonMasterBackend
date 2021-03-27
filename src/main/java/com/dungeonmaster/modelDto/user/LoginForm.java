package com.dungeonmaster.modelDto.user;

public class LoginForm {

	private String login;
	private String password;
	
	public LoginForm() {}
	
	public LoginForm(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}
	
}
