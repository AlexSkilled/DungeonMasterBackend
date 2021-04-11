package com.dungeonmaster.modelDto.user;

import com.dungeonmaster.domain.user.User;

public class UserDTO {

    private Long id;
	private String username;
	private String email;
    private String password;
	public UserDTO() {	}
	
	public UserDTO(Long id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.email = entity.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
}
