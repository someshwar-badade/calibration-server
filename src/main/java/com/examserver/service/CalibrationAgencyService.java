package com.examserver.service;


import java.util.Set;

import com.examserver.model.CalibrationAgency;
import com.examserver.util.ApplicationResponse;

public interface CalibrationAgencyService {
	public ApplicationResponse getAgencies();
	public CalibrationAgency addCalibrationAgency(CalibrationAgency calibrationAgency);
	public CalibrationAgency updateCalibrationAgency(CalibrationAgency calibrationAgency);
	public CalibrationAgency getCalibrationAgency(Long id);
	public void deleteCalibrationAgency(Long id);
}
