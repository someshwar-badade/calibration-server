package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
