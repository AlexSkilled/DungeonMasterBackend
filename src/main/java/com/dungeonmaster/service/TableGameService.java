package com.dungeonmaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungeonmaster.entity.TableGame;
import com.dungeonmaster.repository.TableGameRepository;

@Service
public class TableGameService {

	@Autowired
	private final TableGameRepository repository;

	public TableGameService(TableGameRepository repository) {
		this.repository = repository;
	}
	
	public Optional<TableGame> getById(Long id) {
		return repository.findById(id);
	}
	
	public TableGame add(TableGame description) {
		return repository.save(description);		
	}
}
