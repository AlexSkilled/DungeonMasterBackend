package com.dungeonmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungeonmaster.entity.TableGame;

public interface TableGameRepository  extends JpaRepository<TableGame, Long>{

}
