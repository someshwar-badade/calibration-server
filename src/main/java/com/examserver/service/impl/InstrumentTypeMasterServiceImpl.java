package com.examserver.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.CommonPage;
import com.examserver.model.SearchCriteria;
import com.examserver.repository.InstrumentTypeMasterCriteiaRepo;
import com.examserver.repository.InstrumentTypeMasterRepository;
import com.examserver.service.InstrumentTypeMasterService;
import com.examserver.util.ApplicationResponse;





@Service
public class InstrumentTypeMasterServiceImpl implements InstrumentTypeMasterService{

	@Autowired
	InstrumentTypeMasterRepository instrumentTypeMasterRepository;
	
	@Autowired
	InstrumentTypeMasterCriteiaRepo instrumentTypeMasterCriteiaRepo;
	
	@Override
	public InstrumentTypeMaster addInstrumentType(InstrumentTypeMaster instrumentTypeMaster) {
		return instrumentTypeMasterRepository.save(instrumentTypeMaster);
	}

	@Override
	public InstrumentTypeMaster updateInstrumentType(InstrumentTypeMaster instrumentTypeMaster) {
		return instrumentTypeMasterRepository.save(instrumentTypeMaster);
	}

	@Override
	public ApplicationResponse getInstrumentTypes() {
		Object data = new Object();
		
		ApplicationResponse response = new ApplicationResponse();
		//Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortDirection.toUpperCase(),sortBy) );
//		Pageable paging;
//		if(sortDirection.equalsIgnoreCase("ASC")) {
//			paging = PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, sortBy);
//		}else {
//			paging = PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.DESC, sortBy);
//		}
//		Page<InstrumentTypeMaster> pagedResult = instrumentTypeMasterRepository.findAll(paging);
//		return new LinkedHashSet<InstrumentTypeMaster>(pagedResult);
		response.setData(instrumentTypeMasterRepository.findAll());
		//response.setTotal(pagedResult.getTotalElements());
		return response;
//		return new LinkedHashSet<InstrumentTypeMaster>(pagedResult.getContent());
	}
	
	@Override
	public Page<InstrumentTypeMaster> getAllFilteredRecords(CommonPage instrumentTypeMasterPage,SearchCriteria searchCriteria){
		return this.instrumentTypeMasterCriteiaRepo.findAllWithFilter(instrumentTypeMasterPage, searchCriteria);
	}

	@Override
	public InstrumentTypeMaster getInstrumentType(Long id) {
		return this.instrumentTypeMasterRepository.findById(id).get();
	}

	@Override
	public void deleteInstrumentType(Long id) {
		this.instrumentTypeMasterRepository.deleteById(id);
		
	}
	
	

}
