package com.dungeonmaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dungeonmaster.domain.user.User;
import com.dungeonmaster.modelDto.NoteDTO;

@Entity
@Table(name = "note")
public class Note {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String notes;
    @ManyToOne
    private User owner;
    
    public Note() {}

    public Note(NoteDTO dto) {
    	this.id = dto.getId();
		this.name = dto.getName();
		this.notes = dto.getNotes();
    }
    
	public Note(Long id, String name, String notes) {
		this.id = id;
		this.name = name;
		this.notes = notes;
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

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
