package com.dungeonmaster;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DungeonMasterApplication {

	public static void main(String[] args) {
		System.out.println("My project encoding is : "+ Charset.defaultCharset());
		SpringApplication.run(DungeonMasterApplication.class, args);
	}

}
