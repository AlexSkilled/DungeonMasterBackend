package com.dungeonmaster.domain;



import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dungeonmaster.modelDto.GameProgressDTO;

@Entity
@Table(name = "game_progress")
public class GameProgress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="game_name")
	private String gameName;
	@Column
	private String payload;
	@Column(name="user_id")
	private Long userId;
	@Column
	@Basic
	private Date dateCreated;
	@Column
	@Basic
	private Date dateLastChange;

	public GameProgress() {}
	public GameProgress(GameProgressDTO dto) {
		gameName = dto.getGameName();
		payload = dto.getPayload();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
}
