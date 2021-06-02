package com.dungeonmaster.modelDto;

import com.dungeonmaster.domain.TableGame;

public class TableGameDTO {

	    private Long id;
		private String name;
	   	private String playersAmount;
	   	private String shortDiscriprion;
	   	private String complectation;
	   	private String rools;
	   	private boolean createdByUser;
	   	
		public TableGameDTO() {}
	   	
	   	public TableGameDTO(Long id, String name, String playersAmount, String shortDiscriprion, String complectation,
				String rools, boolean createdByUser) {
			this.id = id;
			this.name = name;
			this.playersAmount = playersAmount;
			this.shortDiscriprion = shortDiscriprion;
			this.complectation = complectation;
			this.rools = rools;
			this.createdByUser = createdByUser;
		}
	   	
	   	public TableGameDTO(TableGame entity) {
	   		this.id = entity.getId();
			this.name = entity.getName();
			this.playersAmount = entity.getPlayersAmount();
			this.shortDiscriprion = entity.getShortDiscriprion();
			this.complectation = entity.getComplectation();
			this.rools = entity.getRools();
			this.createdByUser = entity.isCreatedByUser();
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
		
		public void getShort(TableGame entity) {
			this.id = entity.getId();
			this.name = entity.getName();
		}
}
