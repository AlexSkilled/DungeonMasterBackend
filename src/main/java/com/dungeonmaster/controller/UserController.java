package com.dungeonmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungeonmaster.errros.user.InvalidUserData;
import com.dungeonmaster.modelDto.user.LoginForm;
import com.dungeonmaster.modelDto.user.UserDTO;
import com.dungeonmaster.service.user.UserService;


@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<?> addUser(@RequestBody UserDTO dto) {
    	try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    	
    	try {
    		   userService.saveUser(dto);
    	} catch(InvalidUserData e) {
    		switch (e.getError()) {
    		case UserAlreadyExists:
    			return new ResponseEntity<>(new String("������ �����������. ������������ ����������."), HttpStatus.OK);
    		case InvalidEmail:
    			return new ResponseEntity<>(new String("������ �����������. �������� Email"), HttpStatus.OK);
    		case InvalidName:
    			return new ResponseEntity<>(new String("������ �����������. �������� ���"), HttpStatus.OK);
    		}
    	}
    	UserDTO user = userService.findByUsername(dto.getUsername());
        return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginForm dto) {
    	UserDTO user = null;
    	try {
    		user =  userService.findByEmail(dto.getLogin());
    	} catch(UsernameNotFoundException e) {
    		try {
    			user =  userService.findByUsername(dto.getLogin());
        	} catch(UsernameNotFoundException innerE) {
        		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        	}
    		
    	}
    	
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
    @GetMapping("/hello")
    public ResponseEntity<?> hello(@RequestBody LoginForm dto) {
    	UserDTO user = null;
    	try {
    		user =  userService.findByEmail(dto.getLogin());
    	} catch(UsernameNotFoundException e) {
    		try {
    			user =  userService.findByUsername(dto.getLogin());
        	} catch(UsernameNotFoundException innerE) {
        		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        	}
    		
    	}
    	
		return new ResponseEntity<>(user.getUsername(), HttpStatus.OK);
    }
    
    @GetMapping("/foo")
    public ResponseEntity<?> hello() {
    	return new ResponseEntity<>(HttpStatus.OK);
    	
    }
    
}
