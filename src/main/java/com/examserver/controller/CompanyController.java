package com.examserver.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.examserver.model.Company;
import com.examserver.service.CompanyService;

@RestController
@RequestMapping("/api/company")
@CrossOrigin("*")
public class CompanyController {
	private CompanyService companyService;
	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/webapp/WEB-INF/images/company-images";
	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	

	// build create company REST API
	@PostMapping()
	public ResponseEntity<Company> saveCompany(Company company, @RequestParam("file") MultipartFile file) {
		
		String randomUUIDString = UUID.randomUUID().toString();
		
//        String randomUUIDString = uuid.toString();

        System.out.println("1) company.log = " + company.getLogo());
        
		StringBuilder fileNames = new StringBuilder();
		String filename = randomUUIDString + file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
//		.substring(file.getOriginalFilename().length()-4)
		Path fileNameandPath = Paths.get(uploadDirectory,filename);
		try {
			Files.write(fileNameandPath, file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
        
		company.setLogo("/company-images/" + filename);
		 System.out.println("2) company.log = " + company.getLogo());
		return new ResponseEntity<Company>(companyService.saveCompany(company), HttpStatus.CREATED);
//		return null;
	}

	// build get all company REST API
	@GetMapping
	public List<Company> getAllCompany() {
		return companyService.getAllCompany();
	}

	// build get company by id REST API
	// http://localhost:8080/api/company/1
	@GetMapping("{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") long companyId) {
		return new ResponseEntity<Company>(companyService.getCompanyById(companyId), HttpStatus.OK);
	}

	// build update company REST API
	// http://localhost:8080/api/company/1
	@PutMapping("{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") long id, @RequestBody Company company) {
		return new ResponseEntity<Company>(companyService.updateCompany(company, id), HttpStatus.OK);
	}

	// build delete Company REST API
	// http://localhost:8080/api/Company/1
	@DeleteMapping("{id}")
	public void deleteCompany(@PathVariable("id") long id) {
		// delete Company from DB
		companyService.deleteCompany(id);

//		return new ResponseEntity<String>("Employee Deleted Successfuly !. ", HttpStatus.OK);
	}
}
