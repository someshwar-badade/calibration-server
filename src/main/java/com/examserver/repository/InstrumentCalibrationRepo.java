package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examserver.model.InstrumentCalibration;

@Repository
public interface InstrumentCalibrationRepo extends JpaRepository<InstrumentCalibration, Long> {

}
