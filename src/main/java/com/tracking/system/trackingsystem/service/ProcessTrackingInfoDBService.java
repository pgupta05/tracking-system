package com.tracking.system.trackingsystem.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tracking.system.trackingsystem.dao.ProcessTrackingInfoDaoService;
import com.tracking.system.trackingsystem.entity.ProcessTrackingInfo;
import com.tracking.system.trackingsystem.entity.ProcessTrackingRepository;
import com.tracking.system.trackingsystem.exceptions.RecordsNotFoundException;

@RestController
public class ProcessTrackingInfoDBService {

	@Autowired
	private ProcessTrackingInfoDaoService service;
	
	@Autowired
	private ProcessTrackingRepository recordRepository;
	
	//Get Records
	// retrieve all Records
	//@CrossOrigin(origins = "http://localhost:7001")
	@GetMapping("/db/records")
	public List<ProcessTrackingInfo> retriveAllRecords() {
		
		return recordRepository.findAll();
	}
	
	//Get recordbyId
	// retrieve by ID
	@GetMapping("/db/records/{id}")
	public ProcessTrackingInfo retrieveUserbyId(@PathVariable int id) {
		Optional<ProcessTrackingInfo> findRec = recordRepository.findById(id);
		if (!findRec.isPresent()) {
			throw new RecordsNotFoundException("Id = "+id);
		}
	
	  //Resource<ProcessTrackingInfo> resource = new   Resource<ProcessTrackingInfo>(findRec.get());
	 // ControllerLinkBuilder lintTo =	  linkTo(methodOn(this.getClass()).retrieveAllUsers());
	  //resource.add(linkTo.withRel("all-users"));
	 
	    
		return findRec.get();
	}
	@PostMapping("/db/records")
	public ResponseEntity<Object> createRecord(@RequestBody ProcessTrackingInfo postRecord) {
		ProcessTrackingInfo savedRecord = service.save(postRecord);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRecord.getActivityInfoId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
