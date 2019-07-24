package com.tracking.system.trackingsystem.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessTrackingRepository extends JpaRepository<ProcessTrackingInfo, Integer>{
	
	

}
