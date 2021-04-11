package com.dungeonmaster.modelDto;

import com.dungeonmaster.domain.Note;

public class NoteDTO {

    private Long id;
 
    private String name;
 
    private String notes;
    
    public NoteDTO() {}
    
    public NoteDTO(Note note) {
		this.id = note.getId();
		this.name =  note.getName();
		this.notes = note.getNotes();
	}
    
	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getNotes() {
		return notes;
	}
	
	public Note toEntity(NoteDTO note) {
		return new Note(note.getId(), note.getName(), note.getNotes());
	}

}
