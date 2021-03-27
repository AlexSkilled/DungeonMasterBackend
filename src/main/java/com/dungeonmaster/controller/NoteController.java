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

import com.dungeonmaster.entity.Note;
import com.dungeonmaster.errros.ProductNotFoundException;
import com.dungeonmaster.modelDto.NoteDTO;
import com.dungeonmaster.service.NoteService;

@RestController
@RequestMapping("note")
public class NoteController {
	
	@Autowired 
	private final NoteService noteService;
	
	
	public NoteController(NoteService noteService) {
		this.noteService = noteService;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<NoteDTO> get(@PathVariable("id") long id) {
		Note entity = noteService.findById(id)
				.orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
		return new ResponseEntity<>(new NoteDTO(entity), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> post(@RequestBody NoteDTO dto) {
		Note createdNote = noteService.createNote(new Note(dto));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdNote.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
}
