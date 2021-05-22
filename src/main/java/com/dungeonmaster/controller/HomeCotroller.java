package com.dungeonmaster.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HomeCotroller {
	
	
	@GetMapping("/hello")
	public ResponseEntity<?> isActive() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
