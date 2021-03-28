package com.dungeonmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungeonmaster.entity.user.User;
import com.dungeonmaster.service.user.UserService;


@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
    private UserService userService;

    @PostMapping("/registration")
    public  ResponseEntity<?> addUser(@RequestBody User userForm) {

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            new ResponseEntity<>("Пароли не совпадают", HttpStatus.BAD_REQUEST);
        }
        if (!userService.saveUser(userForm)){
            new ResponseEntity<>("Пользователь с таким именем уже существует", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    
    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestBody User userForm) {

        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            new ResponseEntity<>("Пароли не совпадают", HttpStatus.BAD_REQUEST);
        }
        if (!userService.saveUser(userForm)){
            new ResponseEntity<>("Пользователь с таким именем уже существует", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
