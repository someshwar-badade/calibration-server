package com.examserver.service;

import java.util.Set;

import org.springframework.data.domain.Page;

import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.CommonPage;
import com.examserver.model.SearchCriteria;
import com.examserver.util.ApplicationResponse;

public interface InstrumentTypeMasterService {

	public InstrumentTypeMaster addInstrumentType(InstrumentTypeMaster instrumentTypeMaster);
	public InstrumentTypeMaster updateInstrumentType(InstrumentTypeMaster instrumentTypeMaster);
	public ApplicationResponse getInstrumentTypes();
	public InstrumentTypeMaster getInstrumentType(Long id);
	public void deleteInstrumentType(Long id);
	public Page<InstrumentTypeMaster> getAllFilteredRecords(CommonPage instrumentTypeMasterPage,SearchCriteria searchCriteria);
}
