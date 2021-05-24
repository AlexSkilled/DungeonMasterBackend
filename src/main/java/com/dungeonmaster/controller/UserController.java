package com.dungeonmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
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
    			return new ResponseEntity<>(new String("Ошибка регистрации. Пользователь существует."), HttpStatus.OK);
    		case InvalidEmail:
    			return new ResponseEntity<>(new String("Ошибка регистрации. Неверный Email"), HttpStatus.OK);
    		case InvalidName:
    			return new ResponseEntity<>(new String("Ошибка регистрации. Неверное имя"), HttpStatus.OK);
    		}
    	}
    	UserDTO user = userService.findByUsername(dto.getUsername());
        return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
    }
    
    @GetMapping("/login")
	public ResponseEntity<?> login() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();

		return new ResponseEntity<>(login, HttpStatus.OK);
	}
}
