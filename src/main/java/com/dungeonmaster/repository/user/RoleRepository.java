package com.dungeonmaster.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungeonmaster.domain.user.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
