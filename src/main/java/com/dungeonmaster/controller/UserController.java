package com.dungeonmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungeonmaster.errros.InvalidUsernameDataException;
import com.dungeonmaster.modelDto.user.UserDTO;
import com.dungeonmaster.service.user.UserService;


@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/registration")
    public  ResponseEntity<?> addUser(@RequestBody UserDTO dto) {
    	try {
    		   userService.saveUser(dto);
    	} catch(InvalidUsernameDataException e) {
            new ResponseEntity<>("Пользователь с таким именем уже существует", HttpStatus.BAD_REQUEST);    		
    	}


        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
    
    @PostMapping("/hello")
	public ResponseEntity<?> isActive() {
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
