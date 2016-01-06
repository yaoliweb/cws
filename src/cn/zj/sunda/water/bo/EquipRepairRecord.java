package cn.zj.sunda.water.bo;

import java.util.Date;

public class EquipRepairRecord {
	private long  recordID;
	private String sewageName;
	private String deviceName;
	private String serialNumber ;
	private String projectSerialNumber;
	private String projectName;
	private String site;
	private Date time;
	private Date lastRepairTime;
	private String consumeTime;
	private String repairReason;
	private String repairContent;
	private String consumeMaterial;
	private String feedBack;
	private String repairMan;
	private String  proprietorConfirm;
	private String directorName;
	private Date completeTime;
	
	public EquipRepairRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipRepairRecord(long recordID, String sewageName,
			String deviceName, String serialNumber, String projectSerialNumber,
			String projectName, String site, Date time, Date lastRepairTime,
			String consumeTime, String repairReason, String repairContent,
			String consumeMaterial, String feedBack, String repairMan,
			String proprietorConfirm, String directorName, Date completeTime) {
		super();
		this.recordID = recordID;
		this.sewageName = sewageName;
		this.deviceName = deviceName;
		this.serialNumber = serialNumber;
		this.projectSerialNumber = projectSerialNumber;
		this.projectName = projectName;
		this.site = site;
		this.time = time;
		this.lastRepairTime = lastRepairTime;
		this.consumeTime = consumeTime;
		this.repairReason = repairReason;
		this.repairContent = repairContent;
		this.consumeMaterial = consumeMaterial;
		this.feedBack = feedBack;
		this.repairMan = repairMan;
		this.proprietorConfirm = proprietorConfirm;
		this.directorName = directorName;
		this.completeTime = completeTime;
	}

	public long getRecordID() {
		return recordID;
	}

	public void setRecordID(long recordID) {
		this.recordID = recordID;
	}

	public String getSewageName() {
		return sewageName;
	}

	public void setSewageName(String sewageName) {
		this.sewageName = sewageName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProjectSerialNumber() {
		return projectSerialNumber;
	}

	public void setProjectSerialNumber(String projectSerialNumber) {
		this.projectSerialNumber = projectSerialNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getLastRepairTime() {
		return lastRepairTime;
	}

	public void setLastRepairTime(Date lastRepairTime) {
		this.lastRepairTime = lastRepairTime;
	}

	public String getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

	public String getRepairReason() {
		return repairReason;
	}

	public void setRepairReason(String repairReason) {
		this.repairReason = repairReason;
	}

	public String getRepairContent() {
		return repairContent;
	}

	public void setRepairContent(String repairContent) {
		this.repairContent = repairContent;
	}

	public String getConsumeMaterial() {
		return consumeMaterial;
	}

	public void setConsumeMaterial(String consumeMaterial) {
		this.consumeMaterial = consumeMaterial;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getRepairMan() {
		return repairMan;
	}

	public void setRepairMan(String repairMan) {
		this.repairMan = repairMan;
	}

	public String getProprietorConfirm() {
		return proprietorConfirm;
	}

	public void setProprietorConfirm(String proprietorConfirm) {
		this.proprietorConfirm = proprietorConfirm;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	
}
