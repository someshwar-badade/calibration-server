package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examserver.model.InstrumentTypeMaster;

@Repository
public interface InstrumentTypeMasterRepository extends JpaRepository<InstrumentTypeMaster, Long> {

}
