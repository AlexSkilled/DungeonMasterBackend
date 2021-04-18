package com.dungeonmaster.controller;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dungeonmaster.modelDto.user.LoginForm;
import com.dungeonmaster.service.user.UserService;


@RestController
@RequestMapping("/")
public class HomeCotroller {
	
	@Autowired
	private final UserService userService;

	public HomeCotroller(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm dto) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		boolean logged = userService.login(dto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/")
				.buildAndExpand(logged)
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/hello")
	public ResponseEntity<?> isActive() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
