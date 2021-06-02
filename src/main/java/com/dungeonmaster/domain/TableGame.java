package com.dungeonmaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dungeonmaster.modelDto.TableGameDTO;

@Entity
@Table(name = "table_game")
public class TableGame {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
	private String name;
    @Column
   	private String playersAmount;
    @Column
   	private String shortDiscriprion;
    @Column
   	private String complectation;
    @Column
   	private String rools;
    @Column
   	private boolean createdByUser;
    
	public TableGame() {}

	public TableGame(Long id, String name, String playersAmount, String shortDiscriprion, String complectation,
			String rools, boolean createdByUser) {
		this.id = id;
		this.name = name;
		this.playersAmount = playersAmount;
		this.shortDiscriprion = shortDiscriprion;
		this.complectation = complectation;
		this.rools = rools;
		this.createdByUser = createdByUser;
	}

	public TableGame(TableGameDTO dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.playersAmount = dto.getPlayersAmount();
		this.shortDiscriprion = dto.getShortDiscriprion();
		this.complectation = dto.getComplectation();
		this.rools = dto.getRools();
		this.createdByUser = dto.isCreatedByUser();
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPlayersAmount() {
		return playersAmount;
	}

	public String getShortDiscriprion() {
		return shortDiscriprion;
	}

	public String getComplectation() {
		return complectation;
	}

	public String getRools() {
		return rools;
	}

	public boolean isCreatedByUser() {
		return createdByUser;
	}
    
}
