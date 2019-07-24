package com.tracking.system.trackingsystem.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tracking.system.trackingsystem.dao.ProcessTrackingInfoDaoService;
import com.tracking.system.trackingsystem.entity.ProcessTrackingInfo;
import com.tracking.system.trackingsystem.exceptions.RecordsNotFoundException;

@RestController
public class ProcessTrackingInfoService {

	@Autowired
	private ProcessTrackingInfoDaoService service;
	
	//Get Records
	// retrieve all Records
	@GetMapping("/records")
	public List<ProcessTrackingInfo> retriveAllRecords() {
		
		return service.findAll();
	}
	
	//Get recordbyId
	// retrieve by ID
	@GetMapping("/records/{id}")
	public ProcessTrackingInfo retrieveUserbyId(@PathVariable int id) {
		ProcessTrackingInfo findRec = service.findOne(id);
		if (findRec==null) {
			throw new RecordsNotFoundException("Id = "+id);
		}
		return findRec;
	}
	@PostMapping("/records")
	public ResponseEntity<Object> createRecord(@RequestBody ProcessTrackingInfo postRecord) {
		ProcessTrackingInfo savedRecord = service.save(postRecord);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRecord.getActivityInfoId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
