package com.dungeonmaster.modelDto.user;

import com.dungeonmaster.entity.user.User;

public class UserDTO {

    private Long id;
	private String nickName;
	private String email;
    private String password;
	public UserDTO() {	}
	
	public UserDTO(Long id, String nickName, String email, String password) {
		this.id = id;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.nickName = entity.getUsername();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNickName() {
		return nickName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
}
