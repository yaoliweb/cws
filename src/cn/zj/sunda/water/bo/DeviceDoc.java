package cn.zj.sunda.water.bo;

import java.util.Date;

public class DeviceDoc {
	
	private long deviceDocID;
	private int number;
	private String deviceName;
	private String deviceType;
	private Date setupTime;
	private Date lastRepairTime;
	private int repairCycle;
	private int useTimeLimit;
	private int repairRecord;
	private String sewageName;
	public DeviceDoc(){
	}
	public DeviceDoc(long deviceDocID, int number, String deviceName,
			String deviceType, Date setupTime, Date lastRepairTime,
			int repairCycle, int useTimeLimit, int repairRecord,
			String sewageName) {
		super();
		this.deviceDocID = deviceDocID;
		this.number = number;
		this.deviceName = deviceName;
		this.deviceType = deviceType;
		this.setupTime = setupTime;
		this.lastRepairTime = lastRepairTime;
		this.repairCycle = repairCycle;
		this.useTimeLimit = useTimeLimit;
		this.repairRecord = repairRecord;
		this.sewageName = sewageName;
	}
	public long getDeviceDocID() {
		return deviceDocID;
	}
	public void setDeviceDocID(long deviceDocID) {
		this.deviceDocID = deviceDocID;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public Date getSetupTime() {
		return setupTime;
	}
	public void setSetupTime(Date setupTime) {
		this.setupTime = setupTime;
	}
	public Date getLastRepairTime() {
		return lastRepairTime;
	}
	public void setLastRepairTime(Date lastRepairTime) {
		this.lastRepairTime = lastRepairTime;
	}
	public int getRepairCycle() {
		return repairCycle;
	}
	public void setRepairCycle(int repairCycle) {
		this.repairCycle = repairCycle;
	}
	public int getUseTimeLimit() {
		return useTimeLimit;
	}
	public void setUseTimeLimit(int useTimeLimit) {
		this.useTimeLimit = useTimeLimit;
	}
	public int getRepairRecord() {
		return repairRecord;
	}
	public void setRepairRecord(int repairRecord) {
		this.repairRecord = repairRecord;
	}
	public String getSewageName() {
		return sewageName;
	}
	public void setSewageName(String sewageName) {
		this.sewageName = sewageName;
	}
	
}
