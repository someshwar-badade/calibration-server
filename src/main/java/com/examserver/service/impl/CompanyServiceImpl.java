package com.examserver.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examserver.model.Company;
import com.examserver.repository.CompanyRepository;
import com.examserver.service.CompanyService;


@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public Company saveCompany(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyById(long id) {
		return companyRepository.findById(id).get();
	}

	@Override
	public Company updateCompany(Company company, long id) {
		Company existingCompany = companyRepository.findById(id).get();

		existingCompany.setName(company.getName());
		existingCompany.setAddress(company.getAddress());
		existingCompany.setEmail(company.getEmail());
		existingCompany.setPhone(company.getPhone());
		existingCompany.setLogo(company.getLogo());
		existingCompany.setIsActive(company.getIsActive());
//		existingCompany.setPassword(company.getPassword());
		// save existing Company to DB
		companyRepository.save(existingCompany);

		return existingCompany;
	}

	
	@Override
	public void deleteCompany(long id) {
		// check whether a company exist in DB or not
				companyRepository.findById(id).get();

				companyRepository.deleteById(id);
	}

}
