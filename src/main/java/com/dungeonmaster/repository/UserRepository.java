package com.dungeonmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungeonmaster.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
