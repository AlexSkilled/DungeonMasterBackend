package com.dungeonmaster.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dungeonmaster.domain.TableGame;
import com.dungeonmaster.errros.NoteWasNotFoundException;
import com.dungeonmaster.modelDto.TableGameDTO;
import com.dungeonmaster.service.TableGameService;

@RestController
@RequestMapping("tableGame")
public class TableGameController {

	@Autowired 
	private final TableGameService tableGameService;

	public TableGameController(TableGameService noteService) {
		this.tableGameService = noteService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TableGameDTO> get(@PathVariable("id") long id) {
		TableGame entity = tableGameService.getById(id)
				.orElseThrow(()->new NoteWasNotFoundException("No Product with ID : "+id));
		return new ResponseEntity<>(new TableGameDTO(entity), HttpStatus.OK);
	}
	
	@PostMapping("/saveProgress")
	public ResponseEntity<?> post(@RequestBody TableGameDTO dto) {
		TableGame createdTableGame = tableGameService.ADD(new TableGame(dto));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdTableGame.getId())
				.toUri();
		
		return new ResponseEntity<>("Заебись сохранило", HttpStatus.OK);
	}
}
