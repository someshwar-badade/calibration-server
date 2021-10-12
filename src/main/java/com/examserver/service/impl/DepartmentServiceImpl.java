package com.examserver.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.Company;
import com.examserver.model.Department;
import com.examserver.repository.DepartmentRepository;
import com.examserver.service.DepartmentService;
import com.examserver.util.ApplicationResponse;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public ApplicationResponse getDepartments() {
		Object data = new Object();
		
		ApplicationResponse response = new ApplicationResponse();
		
		response.setData(departmentRepository.findAll());
		response.setTotal(departmentRepository.findAll().size());
		return response;
	}

	@Override
	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartment(Long id) {
		return this.departmentRepository.findById(id).get();
	}

	@Override
	public void deleteDepartment(Long id) {
		this.departmentRepository.deleteById(id);
		
	}
	
	@Override
	public Set<Department>findByCompany(Company company) {
		// TODO Auto-generated method stub
		return this.departmentRepository.findByCompany(company);
	}
	
}
