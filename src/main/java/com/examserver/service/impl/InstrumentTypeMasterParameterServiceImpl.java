package com.examserver.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.InstrumentTypeMasterParameter;
import com.examserver.repository.InstrumentTypeMasterParameterRepo;
import com.examserver.service.InstrumentTypeMasterParameterService;

@Service
public class InstrumentTypeMasterParameterServiceImpl implements InstrumentTypeMasterParameterService{

	@Autowired
	private InstrumentTypeMasterParameterRepo repo;
	
	@Override
	public InstrumentTypeMasterParameter addRecord(InstrumentTypeMasterParameter r) {
		return this.repo.save(r);
	}

	@Override
	public InstrumentTypeMasterParameter updateRecord(InstrumentTypeMasterParameter r) {
		return this.repo.save(r);
	}

	@Override
	public InstrumentTypeMasterParameter getRecord(Long id) {
		return this.repo.findById(id).get();
	}

	@Override
	public void deleteRecord(Long id) {
		this.repo.deleteById(id);
		
	}

	@Override
	public Set<InstrumentTypeMasterParameter> getParameter(InstrumentTypeMaster instrumentTypeMaster) {
		return this.repo.findByInstrumentType(instrumentTypeMaster);
	}

}
