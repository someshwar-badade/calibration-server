package com.examserver.service;


import java.util.Set;

import org.springframework.data.domain.Page;

import com.examserver.model.CalibrationAgency;
import com.examserver.model.CommonPage;
import com.examserver.model.SearchCriteria;
import com.examserver.util.ApplicationResponse;

public interface CalibrationAgencyService {
	public ApplicationResponse getAgencies();
	public CalibrationAgency addCalibrationAgency(CalibrationAgency calibrationAgency);
	public CalibrationAgency updateCalibrationAgency(CalibrationAgency calibrationAgency);
	public CalibrationAgency getCalibrationAgency(Long id);
	public void deleteCalibrationAgency(Long id);
	public Page<CalibrationAgency> getAllFilteredRecords(CommonPage commonPage,SearchCriteria searchCriteria);
}
