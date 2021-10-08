package com.examserver.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.InstrumentTypeMasterParameter;

public interface InstrumentTypeMasterParameterRepo extends JpaRepository<InstrumentTypeMasterParameter, Long> {

	Set<InstrumentTypeMasterParameter> findByInstrumentType(InstrumentTypeMaster instrumentTypeMaster);
}
