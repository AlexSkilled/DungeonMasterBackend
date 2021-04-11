package com.dungeonmaster.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungeonmaster.domain.Note;
import com.dungeonmaster.domain.user.User;
import com.dungeonmaster.errros.NoteWasNotFoundException;
import com.dungeonmaster.modelDto.NoteDTO;
import com.dungeonmaster.repository.NoteRepository;
import com.dungeonmaster.repository.user.UserRepository;

@Service
public class NoteService {
	 
		@Autowired
		private final NoteRepository noteRepository;
		@Autowired
		private final UserRepository userRepository;
		
		public NoteService(NoteRepository noteRepository, UserRepository userRepository) {
			this.noteRepository = noteRepository;
			this.userRepository = userRepository;
		}

		public NoteDTO createNote(NoteDTO dto, String username) {
			Note note = new Note(dto);
			User owner = userRepository.findByUsername(username);
			
			note.setOwner(owner);

			return new NoteDTO(noteRepository.save(note));
		}

		public NoteDTO findById(long id) {
			Note note = noteRepository.findById(id)
					.orElseThrow(() -> new NoteWasNotFoundException("В базе нет записи с id = " + id));
			NoteDTO dto = new NoteDTO(note);
			return dto;
		}
		
		public List<NoteDTO> findAllByOwnerId(Long id){
			List<Note> notes = noteRepository.findByOwnerId(id);
			List<NoteDTO> dtos = new ArrayList<NoteDTO>();
			for(Note note : notes) {
				dtos.add(new NoteDTO(note));
			}
			return dtos;
		}
}
