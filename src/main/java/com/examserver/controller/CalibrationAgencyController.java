package com.examserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.examserver.model.CalibrationAgency;
import com.examserver.service.CalibrationAgencyService;
import com.examserver.util.ApplicationResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/calibration-agency")
public class CalibrationAgencyController {

	@Autowired
	private CalibrationAgencyService calibrationAgencyService;
	
	@GetMapping
	public ApplicationResponse getList() {
		return calibrationAgencyService.getAgencies();
	}
	
	//get Department
			@GetMapping("/{id}")
			public ResponseEntity<?> getCalibrationAgency(@PathVariable("id") Long id){
				return ResponseEntity.ok(this.calibrationAgencyService.getCalibrationAgency(id));
			}
			
			//create Department
			@PostMapping
			public CalibrationAgency addCalibrationAgency(@RequestBody CalibrationAgency c) {
				return this.calibrationAgencyService.addCalibrationAgency(c);
			}
			
			//Update Department
			@PutMapping
			public CalibrationAgency updateCalibrationAgency(@RequestBody CalibrationAgency c) {
				return this.calibrationAgencyService.updateCalibrationAgency(c);
			}
				
			//delete Department
			@DeleteMapping("/{id}")
			public void deleteCalibrationAgency(@PathVariable("id") Long id){
				this.calibrationAgencyService.deleteCalibrationAgency(id);
			}
}
