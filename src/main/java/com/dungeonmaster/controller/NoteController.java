package com.dungeonmaster.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungeonmaster.errros.NoteWasNotFoundException;
import com.dungeonmaster.modelDto.NoteDTO;
import com.dungeonmaster.modelDto.user.UserDTO;
import com.dungeonmaster.service.NoteService;
import com.dungeonmaster.service.user.UserService;

@RestController
@RequestMapping("note")
public class NoteController {
	
	@Autowired
	private final UserService userService;
	
	@Autowired 
	private final NoteService noteService;
	
	public NoteController(NoteService noteService, UserService userService) {
		this.noteService = noteService;
		this.userService = userService;
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable("id") long id) {
		NoteDTO dto = null;
		try {
			dto = noteService.findById(id);
		} catch (NoteWasNotFoundException e) {
			return new ResponseEntity<>("Собщение не было найдено", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<?> post(@RequestBody NoteDTO dto, Principal principal) {
		System.out.println(dto.getName());
		NoteDTO createdNote = noteService.createOrUpdateNote(dto, principal.getName());
		
		return new ResponseEntity<>(createdNote.getId(), HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<?> list(Principal principal){
		UserDTO user = userService.findByUsername(principal.getName());
		return new ResponseEntity<>(noteService.findAllByOwnerId(user.getId()), HttpStatus.OK);
	}
	
	@PostMapping("/drop/{id}")
	public ResponseEntity<?> list(@PathVariable Long id, Principal principal){
		UserDTO user = userService.findByUsername(principal.getName());
		noteService.findAndDeleteByOwnerId(user.getId(), id);
		return new ResponseEntity<>("ok", HttpStatus.OK);
	}	
	
}
