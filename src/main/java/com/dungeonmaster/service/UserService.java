package com.dungeonmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungeonmaster.entity.User;
import com.dungeonmaster.modelDto.user.LoginForm;
import com.dungeonmaster.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public User register(User user) {
		return repository.save(user);
	}
	
	public boolean login(LoginForm form) {
		
		return false;
	}
	
}
