package com.dungeonmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ui.UserInterface;

@SpringBootApplication
public class DungeonMasterApplication {

	public static void main(String[] args) {
		UserInterface ui = new UserInterface();
        ui.pack();
        
		SpringApplication.run(DungeonMasterApplication.class, args);
	}

}
