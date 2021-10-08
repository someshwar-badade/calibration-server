package com.examserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentMaster;
import com.examserver.model.SearchCriteria;
import com.examserver.service.InstrumentMasterService;

@RestController
@RequestMapping("/api/instrument-master")
@CrossOrigin("*")
public class InstrumentMasterController {
	
	@Autowired
	private InstrumentMasterService instrumentMasterService;
	Principal principal;
	//get all instruments
//	@GetMapping
//	public ApplicationResponse getInstruments(@RequestParam(defaultValue = "0") Integer pageNo,
//												@RequestParam(defaultValue = "10") Integer pageSize,
//												@RequestParam(defaultValue = "id") String sortBy,
//												@RequestParam(defaultValue = "ASC") String sortDirection){
//		return this.instrumentMasterService.getInstruments(pageNo,pageSize,sortBy,sortDirection);
//	}
	
	@GetMapping
	public ResponseEntity<Page<InstrumentMaster>> getInstruments(CommonPage commonPage,
			SearchCriteria searchCriteria){
		return new ResponseEntity<>(instrumentMasterService.getAllFilteredRecords(commonPage, searchCriteria),HttpStatus.OK);
	}
	
	//get instrument
	@GetMapping("/{id}")
	public ResponseEntity<?> getInstrument(@PathVariable("id") Long id){
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getUsername());
		return ResponseEntity.ok(this.instrumentMasterService.getInstrument(id));
	}
	
	//create instrument
	@PostMapping
	public InstrumentMaster addInstrumentType(@RequestBody InstrumentMaster instrument) {
		return this.instrumentMasterService.addInstrument(instrument);
	}
	
	//Update instrument
	@PutMapping
	public InstrumentMaster updateInstrumentDetails(@RequestBody InstrumentMaster instrument) {
		return this.instrumentMasterService.updateInstrument(instrument);
	}
	
	@DeleteMapping("/{id}")
	public void deleteInstrument(@PathVariable("id") Long id){
		this.instrumentMasterService.deleteInstrument(id);
	}
		
}
