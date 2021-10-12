package com.examserver.service;

import java.util.Set;

import com.examserver.model.Company;
import com.examserver.model.Department;
import com.examserver.util.ApplicationResponse;


public interface DepartmentService {
	public ApplicationResponse getDepartments();
	public Department addDepartment(Department department);
	public Department updateDepartment(Department department);
	public Department getDepartment(Long id);
	public void deleteDepartment(Long id);
	public Set<Department> findByCompany(Company company);
}
