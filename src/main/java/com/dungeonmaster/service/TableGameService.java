package com.dungeonmaster.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungeonmaster.domain.GameProgress;
import com.dungeonmaster.domain.TableGame;
import com.dungeonmaster.modelDto.GameProgressDTO;
import com.dungeonmaster.modelDto.TableGameDTO;
import com.dungeonmaster.repository.GameProgressRepository;
import com.dungeonmaster.repository.TableGameRepository;

@Service
public class TableGameService {

	@Autowired
	private final TableGameRepository repository;

	@Autowired
	private final GameProgressRepository gameProgress;
	
	public TableGameService(TableGameRepository repository, GameProgressRepository gameProgress) {
		this.repository = repository;
		this.gameProgress = gameProgress;
	}
	
	public Optional<TableGame> getById(Long id) {
		return repository.findById(id);
	}
	
	public TableGame ADD(TableGame description) {
		return repository.save(description);		
	}
	
	public GameProgressDTO updateProgress(GameProgressDTO dto, long useId) {
		GameProgress gp = gameProgress.findById(dto.getId()).get();
		
		gp.setDateLastChange(new Date(new java.util.Date().getTime()));
		
		gp.setPayload(dto.getPayload());

		gp.setGameName(dto.getGameName());
		
		gp = gameProgress.save(gp);
		
		return new GameProgressDTO(gp);
	}
	
	public Long saveProgress(GameProgressDTO dto, Long userId) {
		GameProgress gp = new GameProgress(dto);
		gp.setUserId(userId);
		if (gp.getDateCreated() == null) {
			gp.setDateCreated(new Date(new java.util.Date().getTime()));
		}
		
		gp.setDateLastChange(new Date(new java.util.Date().getTime()));
		
		gp = gameProgress.save(gp);
		
		return gp.getId();
	}
	
	public GameProgressDTO getProgress(Long id, Long userId) {
		Optional<GameProgress> gp = gameProgress.findById(id);
		GameProgressDTO dto = new GameProgressDTO(gp.get());
		return dto;
	}

	public GameProgressDTO[] getSavesForUser(Long id) {
		List<GameProgress> gps = gameProgress.findByUserId(id);
		GameProgressDTO[] out = new GameProgressDTO[gps.size()];
		
		for(int i = 0; i < gps.size(); i++) {
			out[i] = new GameProgressDTO(gps.get(i));
		}
		
		return out;
	}

	public void dropSave(Long saveId, Long id) {
		gameProgress.deleteById(saveId);
	}
	
	public TableGameDTO[] shortListGames() {
		List<TableGame> games = repository.findAll();
		TableGameDTO[] dtos = new TableGameDTO[games.size()];
		for(int i = 0; i < games.size(); i++) {
			dtos[i] = new TableGameDTO();
			dtos[i].getShort(games.get(i));
		}
		return dtos;
	}
	
	public TableGameDTO[] listGames(){
		List<TableGame> games = repository.findAll();
		TableGameDTO[] dtos = new TableGameDTO[games.size()];
		for(int i = 0; i < games.size(); i++) {
			dtos[i] = new TableGameDTO(games.get(i));
		}
		return dtos;
	}

}
