package com.dungeonmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungeonmaster.domain.GameProgress;

public interface GameProgressRepository extends JpaRepository<GameProgress, Long> {

}
