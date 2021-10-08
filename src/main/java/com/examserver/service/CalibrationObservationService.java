package com.examserver.service;

import java.util.Set;

import com.examserver.model.CalibrationObservation;
import com.examserver.model.InstrumentCalibration;

public interface CalibrationObservationService {
	public CalibrationObservation addRecord(CalibrationObservation r);
	public CalibrationObservation updateRecord(CalibrationObservation r);
//	public ApplicationResponse getList(Integer pageNo,Integer pageSize,String sortBy, String sortDirection);
	public CalibrationObservation getRecord(Long id);
	public void deleteRecord(Long id);
	public Set<CalibrationObservation> getParameter(InstrumentCalibration instrumentCalibration);
}
