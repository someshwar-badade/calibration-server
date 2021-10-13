package com.examserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.model.Company;
import com.examserver.model.Department;
import com.examserver.service.DepartmentService;
import com.examserver.util.ApplicationResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ApplicationResponse getList() {
		return departmentService.getDepartments();
	}
	
	//get Department
		@GetMapping("/{id}")
		public ResponseEntity<?> getDepartment(@PathVariable("id") Long id){
			return ResponseEntity.ok(this.departmentService.getDepartment(id));
		}
		
		@GetMapping("/company/{cid}")
		public Set<Department> getAllDepartmentByCompanyId(@PathVariable("cid") Long companyId) {
			Company company = new Company();
			company.setId(companyId);
			return this.departmentService.findByCompany(company);
//			return departmentService.findByCompany(company);
		}
		
		//create Department
		@PostMapping
		public Department addDepartment(@RequestBody Department d) {
			return this.departmentService.addDepartment(d);
		}
//		@PostMapping()
//		public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
//
//			return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
//		}
		
		//Update Department
		@PutMapping
		public Department updateDepartment(@RequestBody Department d) {
			return this.departmentService.updateDepartment(d);
		}
			
		//delete Department
		@DeleteMapping("/{id}")
		public void deleteDepartment(@PathVariable("id") Long id){
			this.departmentService.deleteDepartment(id);
		}
}
