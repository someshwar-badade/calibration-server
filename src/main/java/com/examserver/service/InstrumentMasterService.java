package com.examserver.service;

import org.springframework.data.domain.Page;

import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentMaster;
import com.examserver.model.SearchCriteria;
import com.examserver.util.ApplicationResponse;

public interface InstrumentMasterService {

	public InstrumentMaster addInstrument(InstrumentMaster instrumentMaster);
	public InstrumentMaster updateInstrument(InstrumentMaster instrumentMaster);
	public ApplicationResponse getInstruments(Integer pageNo,Integer pageSize,String sortBy, String sortDirection);
	public InstrumentMaster getInstrument(Long id);
	public void deleteInstrument(Long id);
	public Page<InstrumentMaster> getAllFilteredRecords(CommonPage commonPage,SearchCriteria searchCriteria);
}
