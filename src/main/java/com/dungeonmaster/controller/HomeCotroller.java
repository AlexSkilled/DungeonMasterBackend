package com.dungeonmaster.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dungeonmaster.entity.user.User;
import com.dungeonmaster.modelDto.user.LoginForm;
import com.dungeonmaster.modelDto.user.UserDTO;
import com.dungeonmaster.service.user.UserService;

@RestController
@RequestMapping("/")
public class HomeCotroller {

	@Autowired
	private final UserService userService;

	public HomeCotroller(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDTO dto) {
		User createdUser = userService.register(new User(dto));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm dto) {
		boolean logged = userService.login(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/")
				.buildAndExpand(logged)
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
