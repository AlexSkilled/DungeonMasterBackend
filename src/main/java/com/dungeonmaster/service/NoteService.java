package com.dungeonmaster.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungeonmaster.entity.Note;
import com.dungeonmaster.repository.NoteRepository;

@Service
public class NoteService {
	 
		@Autowired
		private final NoteRepository noteRepository;
		
		public NoteService(NoteRepository noteRepository){
			this.noteRepository = noteRepository;
		}
		
		public Note createNote(Note note) {
			return noteRepository.save(note);
		}

		public Optional<Note> findById(long id) {
			return noteRepository.findById(id);
		}
		 
}
