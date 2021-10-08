package com.examserver.service;

import java.util.List;

import com.examserver.model.Company;

public interface CompanyService {
	Company saveCompany(Company company);
	List<Company> getAllCompany();
	Company getCompanyById(long id);
	Company updateCompany(Company company, long id);
	void deleteCompany(long id);
}
