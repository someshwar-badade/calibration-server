package com.examserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.service.InstrumentTypeMasterParameterService;
import com.examserver.model.InstrumentTypeMaster;
import com.examserver.model.InstrumentTypeMasterParameter;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/instrument-type-master-parameter")
public class InstrumentTypeMasterParameterController {

	@Autowired
	private InstrumentTypeMasterParameterService service;
	
	@GetMapping("/{instrumentId}")
	public Set<InstrumentTypeMasterParameter> getRecords(@PathVariable("instrumentId") Long instrumentId) {
		InstrumentTypeMaster instrumentType = new InstrumentTypeMaster();
		instrumentType.setId(instrumentId);
		return this.service.getParameter(instrumentType);
	}
	
	@GetMapping("/{instrumentId}/{id}")
	public InstrumentTypeMasterParameter getRecord(@PathVariable("instrumentId") Long instrumentId,@PathVariable("id") Long id) {
		
		return this.service.getRecord(id);
	}
	
	@PostMapping
	public InstrumentTypeMasterParameter addRecord(@RequestBody InstrumentTypeMasterParameter r) {
		
		return service.addRecord(r);
	}
	
	@PutMapping
	public InstrumentTypeMasterParameter updateRecord(@RequestBody InstrumentTypeMasterParameter r) {
		return service.addRecord(r);
	}
	
	@DeleteMapping("/{instrumentId}/{id}")
	public void deleteRecord(@PathVariable("instrumentId") Long instrumentId,@PathVariable("id") Long id) {
			
			 this.service.deleteRecord(id);
		}
	
	
}
