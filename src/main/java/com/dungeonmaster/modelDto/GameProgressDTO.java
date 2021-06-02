package com.dungeonmaster.modelDto;

import com.dungeonmaster.domain.GameProgress;

public class GameProgressDTO {

	private String gameName;
	
	private String payload;
	
	
	public GameProgressDTO() {}
	public GameProgressDTO(GameProgress gp) {
		gameName = gp.getGameName();
		payload = gp.getPayload();
	}
	
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}
	
}
