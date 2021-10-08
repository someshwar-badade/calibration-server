package com.examserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.CalibrationAgency;
import com.examserver.repository.CalibrationAgencyRepository;
import com.examserver.service.CalibrationAgencyService;
import com.examserver.util.ApplicationResponse;

@Service
public class CalibrationAgencyServiceImpl implements CalibrationAgencyService {

	@Autowired
	private CalibrationAgencyRepository calibrationAgencyRepository;
	@Override
	public ApplicationResponse getAgencies() {
		Object data = new Object();
		
		ApplicationResponse response = new ApplicationResponse();
		
		response.setData(calibrationAgencyRepository.findAll());
		response.setTotal(calibrationAgencyRepository.findAll().size());
		return response;
		
	}
	@Override
	public CalibrationAgency addCalibrationAgency(CalibrationAgency calibrationAgency) {
		return this.calibrationAgencyRepository.save(calibrationAgency);
	}
	@Override
	public CalibrationAgency updateCalibrationAgency(CalibrationAgency calibrationAgency) {
		return this.calibrationAgencyRepository.save(calibrationAgency);
	}
	@Override
	public CalibrationAgency getCalibrationAgency(Long id) {
		return this.calibrationAgencyRepository.findById(id).get();
	}
	@Override
	public void deleteCalibrationAgency(Long id) {
		 this.calibrationAgencyRepository.deleteById(id);	
	}

}
