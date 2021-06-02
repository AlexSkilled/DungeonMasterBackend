package com.dungeonmaster.modelDto;

import java.util.Date;

import com.dungeonmaster.domain.GameProgress;

public class GameProgressDTO {

	private Long id;
	
	private String gameName;
	
	private String payload;
	
	private Date dateCreated;
	private Date dateLastChange;
	
	public GameProgressDTO() {}
	public GameProgressDTO(GameProgress gp) {
		id = gp.getId();
		gameName = gp.getGameName();
		payload = gp.getPayload();
		dateCreated = gp.getDateCreated();
		dateLastChange = gp.getDateLastChange();
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateLastChange() {
		return dateLastChange;
	}
	public void setDateLastChange(Date dateLastChange) {
		this.dateLastChange = dateLastChange;
	}
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
