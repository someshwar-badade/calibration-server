package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.InstrumentMaster;

public interface InstrumentMasterRepository extends JpaRepository<InstrumentMaster, Long> {

}
