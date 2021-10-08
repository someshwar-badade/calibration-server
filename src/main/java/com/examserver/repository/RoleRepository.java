package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
