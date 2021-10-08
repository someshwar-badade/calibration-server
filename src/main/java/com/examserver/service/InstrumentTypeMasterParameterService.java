package com.examserver.service;

import java.util.Set;

import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.InstrumentTypeMasterParameter;


public interface InstrumentTypeMasterParameterService {
	public InstrumentTypeMasterParameter addRecord(InstrumentTypeMasterParameter r);
	public InstrumentTypeMasterParameter updateRecord(InstrumentTypeMasterParameter r);
//	public ApplicationResponse getList(Integer pageNo,Integer pageSize,String sortBy, String sortDirection);
	public InstrumentTypeMasterParameter getRecord(Long id);
	public void deleteRecord(Long id);
	public Set<InstrumentTypeMasterParameter> getParameter(InstrumentTypeMaster instrumentTypeMaster);
}
