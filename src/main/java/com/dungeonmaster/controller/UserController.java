package com.dungeonmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungeonmaster.errros.user.InvalidUserData;
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
    			return new ResponseEntity<>(new String("Пользователь с таким именем уже существует"), HttpStatus.OK);
    		case InvalidEmail:
    			return new ResponseEntity<>(new String("Неверный формат электронной почты"), HttpStatus.OK);
    		case InvalidName:
    			return new ResponseEntity<>(new String("Неверный формат имени пользователя"), HttpStatus.OK);
    		}
    	}

        return new ResponseEntity<>("Пользователь успешно создан", HttpStatus.CREATED);
    }
    
    @PostMapping("/hello")
	public ResponseEntity<?> isActive() {
    	try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
