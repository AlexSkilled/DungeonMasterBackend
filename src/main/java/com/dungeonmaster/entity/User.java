package com.dungeonmaster.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dungeonmaster.modelDto.user.UserDTO;

@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
	private String nickName;
    
    @Column
	private String email;
    
    @Column
    private String password;

	public User() {	}
	
	public User(Long id, String nickName, String email, String password) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}

	public User(UserDTO dto) {
		this.id = dto.getId();
		this.nickName = dto.getNickName();
		this.email = dto.getEmail();
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
