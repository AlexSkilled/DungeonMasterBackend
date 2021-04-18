package com.dungeonmaster.errros.user;

@SuppressWarnings("serial")
public class InvalidUserData extends IllegalArgumentException {

	private UserError error;

	public InvalidUserData(UserError error) {
		this.error = error;
	}
	
	public InvalidUserData(String message) {
		super(message);
	}

	public UserError getError() {
		return error;
	}
}
