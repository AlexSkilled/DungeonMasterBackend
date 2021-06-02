package com.dungeonmaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungeonmaster.domain.GameProgress;
import com.dungeonmaster.domain.TableGame;
import com.dungeonmaster.modelDto.GameProgressDTO;
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
	
	public Long saveProgress(GameProgressDTO dto, Long userId) {
		GameProgress gp = new GameProgress(dto);
		gp.setUserId(userId);
		gp = gameProgress.save(gp);
		
		return gp.getId();
	}
	
	public GameProgressDTO getProgress(Long id, Long userId) {
		Optional<GameProgress> gp = gameProgress.findById(id);
		GameProgressDTO dto = new GameProgressDTO(gp.get());
		return dto;
	}
}
