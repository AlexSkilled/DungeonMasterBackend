package com.dungeonmaster.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungeonmaster.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
