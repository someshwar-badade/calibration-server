package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;

import com.examserver.model.Department;
import com.examserver.model.Company;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Set<Department> findByCompany(Company company);

}
