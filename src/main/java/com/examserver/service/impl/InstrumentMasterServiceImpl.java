package com.examserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentMaster;
import com.examserver.model.SearchCriteria;
import com.examserver.repository.InstrumentMasterCriteriaRepo;
import com.examserver.repository.InstrumentMasterRepository;
import com.examserver.service.InstrumentMasterService;
import com.examserver.util.ApplicationResponse;

@Service
public class InstrumentMasterServiceImpl implements InstrumentMasterService {

	@Autowired
	InstrumentMasterRepository instrumentMasterRepository;
	
	@Autowired
	InstrumentMasterCriteriaRepo instrumentMasterCriteiaRepo;
	
	@Override
	public InstrumentMaster addInstrument(InstrumentMaster instrumentMaster) {
		return instrumentMasterRepository.save(instrumentMaster);
	}

	@Override
	public InstrumentMaster updateInstrument(InstrumentMaster instrumentMaster) {
		return instrumentMasterRepository.save(instrumentMaster);
	}

	@Override
	public ApplicationResponse getInstruments(Integer pageNo,Integer pageSize,String sortBy, String sortDirection) {
		Object data = new Object();
		
		ApplicationResponse response = new ApplicationResponse();
		//Pageable paging = PageRequest.of(pageNo, pageSize,Sort.by(sortDirection.toUpperCase(),sortBy) );
		Pageable paging;
		if(sortDirection.equalsIgnoreCase("ASC")) {
			paging = PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.ASC, sortBy);
		}else {
			paging = PageRequest.of(pageNo, pageSize).withSort(Sort.Direction.DESC, sortBy);
		}
		Page<InstrumentMaster> pagedResult = instrumentMasterRepository.findAll(paging);
//		return new LinkedHashSet<InstrumentTypeMaster>(pagedResult);
		response.setData(pagedResult.getContent());
		response.setTotal(pagedResult.getTotalElements());
		return response;
//		return new LinkedHashSet<InstrumentTypeMaster>(pagedResult.getContent());
	}

	@Override
	public InstrumentMaster getInstrument(Long id) {
		return this.instrumentMasterRepository.findById(id).get();
	}

	@Override
	public void deleteInstrument(Long id) {
		this.instrumentMasterRepository.deleteById(id);
		
	}

	@Override
	public Page<InstrumentMaster> getAllFilteredRecords(CommonPage commonPage, SearchCriteria searchCriteria) {
		return this.instrumentMasterCriteiaRepo.findAllWithFilter(commonPage, searchCriteria);
	}
}
