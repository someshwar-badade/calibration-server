package com.examserver.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.CalibrationObservation;
import com.examserver.model.InstrumentCalibration;
import com.examserver.repository.CalibrationObservationRepo;
import com.examserver.service.CalibrationObservationService;

@Service
public class CalibrationObservationServiceImpl implements CalibrationObservationService {

	@Autowired
	CalibrationObservationRepo repo;
	@Override
	public CalibrationObservation addRecord(CalibrationObservation r) {
		return repo.save(r);
	}

	@Override
	public CalibrationObservation updateRecord(CalibrationObservation r) {
		return repo.save(r);
	}

	@Override
	public CalibrationObservation getRecord(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteRecord(Long id) {
		repo.deleteById(id);	
	}

	@Override
	public Set<CalibrationObservation> getParameter(InstrumentCalibration instrumentCalibration) {
		return repo.findByInstrumentCalibration(instrumentCalibration);
	}

}
