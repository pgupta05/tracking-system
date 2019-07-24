	package com.tracking.system.trackingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tracking.system.trackingsystem.entity.ProcessTrackingInfo;

@Component
public class ProcessTrackingInfoDaoService {
	
	private static List<ProcessTrackingInfo> records = new ArrayList<>();
	private static int userCount = 5;
	
	static {
		
		records.add(new ProcessTrackingInfo(1,"domain-1","Instanceid-1","processName-1","CurrentActivity-1","OriginProcess-1","OriginSourceID-1","processStatus-1"));
		records.add(new ProcessTrackingInfo(2,"domain-2","Instanceid-2","processName-2","CurrentActivity-2","OriginProcess-2","OriginSourceID-2","processStatus-2"));
		records.add(new ProcessTrackingInfo(3,"domain-3","Instanceid-3","processName-3","CurrentActivity-3","OriginProcess-3","OriginSourceID-3","processStatus-3"));
		records.add(new ProcessTrackingInfo(4,"domain-4","Instanceid-4","processName-4","CurrentActivity-4","OriginProcess-4","OriginSourceID-4","processStatus-4"));
		records.add(new ProcessTrackingInfo(5,"domain-5","Instanceid-5","processName-5","CurrentActivity-5","OriginProcess-5","OriginSourceID-5","processStatus-5"));
	}
	
	
	public List<ProcessTrackingInfo> findAll() {
		return records;
		
	}
	
	
	public ProcessTrackingInfo save(ProcessTrackingInfo processRecord) {
		if  (processRecord.getActivityInfoId() == null)  {
			processRecord.setActivityInfoId(++userCount);
		}
		records.add(processRecord);
		return processRecord;
	}

	public ProcessTrackingInfo findOne(int id) {
		
		for (ProcessTrackingInfo record: records) {
			if (record.getActivityInfoId()==id) {
				return  record;
			}
		}
		return null;
		
	}
}
