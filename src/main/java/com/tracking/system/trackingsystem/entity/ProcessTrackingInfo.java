package com.tracking.system.trackingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about the Process.")
@Entity
@Table(name = "XXATI_PROCESS_ACTIVITY_INFO")
public class ProcessTrackingInfo {
	
	
   @Id
   @GeneratedValue
   @Column(name = "ACTIVITY_INFO_ID")
	private Integer activityInfoId;
    
   @Column(name = "DOMAINID", nullable = true, length = 1000)
	private String domainId;
   @Column(name = "INSTANCEID", nullable = true, length = 1000)
	private String instanceID;
   @Column(name = "PROCESSNAME", nullable = true, length = 1000)
	private String procesName;
   @Column(name = "CURRENTACTIVITY", nullable = true, length = 1000)
	private String currentActivity;
   @Column(name = "ORIGINPROCESS", nullable = true, length = 1000)
	private String originProcess;
   @Column(name = "ORIGINSOURCEID", nullable = true, length = 1000)
	private String originSourceId;
   @Column(name = "PROCESSSTATUS", nullable = true, length = 1000)
	private String processStatus;

	protected ProcessTrackingInfo() {
		
	}
	
	public ProcessTrackingInfo(Integer activityInfoId, String domainId, String instanceID, String procesName,
			String currentActivity, String originProcess, String originSourceId, String processStatus) {
		super();
		this.activityInfoId = activityInfoId;
		this.domainId = domainId;
		this.instanceID = instanceID;
		this.procesName = procesName;
		this.currentActivity = currentActivity;
		this.originProcess = originProcess;
		this.originSourceId = originSourceId;
		this.processStatus = processStatus;
	}

	public Integer getActivityInfoId() {
		return activityInfoId;
	}

	public void setActivityInfoId(Integer activityInfoId) {
		this.activityInfoId = activityInfoId;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public String getInstanceID() {
		return instanceID;
	}

	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	public String getProcesName() {
		return procesName;
	}

	public void setProcesName(String procesName) {
		this.procesName = procesName;
	}

	public String getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(String currentActivity) {
		this.currentActivity = currentActivity;
	}

	public String getOriginProcess() {
		return originProcess;
	}

	public void setOriginProcess(String originProcess) {
		this.originProcess = originProcess;
	}

	public String getOriginSourceId() {
		return originSourceId;
	}

	public void setOriginSourceId(String originSourceId) {
		this.originSourceId = originSourceId;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	@Override
	public String toString() {
		return "ProcessTrackingInfo [activityInfoId=" + activityInfoId + ", domainId=" + domainId + ", instanceID="
				+ instanceID + ", procesName=" + procesName + ", currentActivity=" + currentActivity
				+ ", originProcess=" + originProcess + ", originSourceId=" + originSourceId + ", processStatus="
				+ processStatus + "]";
	}
	
	
	
	
	

}
