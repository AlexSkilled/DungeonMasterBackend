package com.dungeonmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dungeonmaster.domain.TableGame;
import com.dungeonmaster.errros.NoteWasNotFoundException;
import com.dungeonmaster.modelDto.GameProgressDTO;
import com.dungeonmaster.modelDto.TableGameDTO;
import com.dungeonmaster.modelDto.user.UserDTO;
import com.dungeonmaster.service.TableGameService;
import com.dungeonmaster.service.user.UserService;

@RestController
@RequestMapping("tableGame")
public class TableGameController {

	@Autowired 
	private final TableGameService tableGameService;

	@Autowired
	private final UserService userService;
	
	public TableGameController(TableGameService noteService, UserService userService) {
		this.tableGameService = noteService;
		this.userService = userService;
	}
	
	@GetMapping("/game/{id}")
	public ResponseEntity<TableGameDTO> get(@PathVariable("id") long id) {
		TableGame entity = tableGameService.getById(id)
				.orElseThrow(()->new NoteWasNotFoundException("No Product with ID : "+id));
		return new ResponseEntity<>(new TableGameDTO(entity), HttpStatus.OK);
	}
	
	@PostMapping("/saveGameInfo")
	public ResponseEntity<?> saveGameInfo(@RequestBody TableGameDTO dto) {
		tableGameService.ADD(new TableGame(dto));
		
		return new ResponseEntity<>("Заебись сохранило", HttpStatus.OK);
	}
	
	@PostMapping("/saveGameProgress")
	public ResponseEntity<?> saveGameProgress(@RequestBody GameProgressDTO dto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	UserDTO user = userService.findByUsername(login);
		Long id = tableGameService.saveProgress(dto, user.getId());
		
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@GetMapping("/getGameProgress/{id}")
	public ResponseEntity<?> getGameProgressById(@PathVariable("id") Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	UserDTO user = userService.findByUsername(login);
    	
    	GameProgressDTO dto = tableGameService.getProgress(id, user.getId());
		
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	@PostMapping("/updateGameProgress")
	public ResponseEntity<?> updateGameProgress(@RequestBody GameProgressDTO dto)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	UserDTO user = userService.findByUsername(login);

    	GameProgressDTO resp = tableGameService.updateProgress(dto, user.getId());
    	
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@GetMapping("/listOfSaves")
	public ResponseEntity<?> listOfSaves(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	UserDTO user = userService.findByUsername(login);
    	
    	GameProgressDTO[] saves = tableGameService.getSavesForUser(user.getId());
    	
		return new ResponseEntity<>(saves, HttpStatus.OK);
	}
	
	@GetMapping("/dropSave/{saveId}")
	public ResponseEntity<?> dropSave(@PathVariable Long saveId){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String login = authentication.getName();
    	UserDTO user = userService.findByUsername(login);
    	
    	tableGameService.dropSave(saveId, user.getId());
    	
		return new ResponseEntity<>("удалено", HttpStatus.OK);
	}
}
