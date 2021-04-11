package com.dungeonmaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungeonmaster.domain.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
	List<Note> findByOwnerId(Long id);
}
