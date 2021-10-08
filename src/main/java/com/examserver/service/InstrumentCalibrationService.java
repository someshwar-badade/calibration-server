package com.examserver.service;



import org.springframework.data.domain.Page;

import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentCalibration;
import com.examserver.model.SearchCriteria;

public interface InstrumentCalibrationService {
	public InstrumentCalibration addRecord(InstrumentCalibration r);
	public InstrumentCalibration updateRecord(InstrumentCalibration r);
//	public ApplicationResponse getList(Integer pageNo,Integer pageSize,String sortBy, String sortDirection);
	public InstrumentCalibration getRecord(Long id);
	public void deleteRecord(Long id);
	public Page<InstrumentCalibration> getAllFilteredRecords(CommonPage commonPage,SearchCriteria searchCriteria);
}
