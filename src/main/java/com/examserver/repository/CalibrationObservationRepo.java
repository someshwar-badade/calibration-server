package com.examserver.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examserver.model.CalibrationObservation;
import com.examserver.model.InstrumentCalibration;

@Repository
public interface CalibrationObservationRepo extends JpaRepository<CalibrationObservation, Long> {
	Set<CalibrationObservation> findByInstrumentCalibration(InstrumentCalibration instrumentCalibration);
}
