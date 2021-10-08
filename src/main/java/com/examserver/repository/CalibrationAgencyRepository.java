package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.CalibrationAgency;

public interface CalibrationAgencyRepository extends JpaRepository<CalibrationAgency, Long> {

}
