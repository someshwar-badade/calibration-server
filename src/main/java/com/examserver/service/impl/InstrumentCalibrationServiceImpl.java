package com.examserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentCalibration;
import com.examserver.model.SearchCriteria;
import com.examserver.repository.InstrumentCalibrationCriteriaRepo;
import com.examserver.repository.InstrumentCalibrationRepo;
import com.examserver.service.InstrumentCalibrationService;

@Service
public class InstrumentCalibrationServiceImpl implements InstrumentCalibrationService{

	@Autowired
	InstrumentCalibrationRepo repo;
	
	@Autowired
	InstrumentCalibrationCriteriaRepo criteriaRepo;
	
	@Override
	public InstrumentCalibration addRecord(InstrumentCalibration r) {
		return repo.save(r);
	}

	@Override
	public InstrumentCalibration updateRecord(InstrumentCalibration r) {
		return repo.save(r);
	}

	@Override
	public InstrumentCalibration getRecord(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteRecord(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Page<InstrumentCalibration> getAllFilteredRecords(CommonPage commonPage, SearchCriteria searchCriteria) {
		return criteriaRepo.findAllWithFilter(commonPage, searchCriteria);
	}

}
