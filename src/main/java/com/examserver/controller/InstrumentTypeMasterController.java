package com.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.CommonPage;
import com.examserver.model.SearchCriteria;
import com.examserver.service.InstrumentTypeMasterService;
import com.examserver.util.ApplicationResponse;

@RestController
@RequestMapping("/api/instrument-type-master")
@CrossOrigin("*")
public class InstrumentTypeMasterController {

	@Autowired
	private InstrumentTypeMasterService instrumentTypeMasterService;
	
	//get all categories
	@GetMapping("/all")
	public ApplicationResponse getInstrumentTypes(){
		return this.instrumentTypeMasterService.getInstrumentTypes();
	}
	
	@GetMapping
	public ResponseEntity<Page<InstrumentTypeMaster>> getInstrumentTypes(CommonPage instrumentTypeMasterPage,
			SearchCriteria instrumentTypeMasterSearchCriteria){
		return new ResponseEntity<>(instrumentTypeMasterService.getAllFilteredRecords(instrumentTypeMasterPage, instrumentTypeMasterSearchCriteria),HttpStatus.OK);
	}
	
	//get category
	@GetMapping("/{id}")
	public ResponseEntity<?> getInstrumentType(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.instrumentTypeMasterService.getInstrumentType(id));
	}
	
	//create category
	@PostMapping
	public InstrumentTypeMaster addInstrumentType(@RequestBody InstrumentTypeMaster instrumentType) {
		return this.instrumentTypeMasterService.addInstrumentType(instrumentType);
	}
	
	//Update category
	@PutMapping
	public InstrumentTypeMaster updateInstrumentDetails(@RequestBody InstrumentTypeMaster instrumentType) {
		return this.instrumentTypeMasterService.updateInstrumentType(instrumentType);
	}
	
	//get category
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable("id") Long id){
		this.instrumentTypeMasterService.deleteInstrumentType(id);
	}
}
