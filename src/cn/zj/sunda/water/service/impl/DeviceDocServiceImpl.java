package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.DeviceDoc;
import cn.zj.sunda.water.dao.DeviceDocDao;
import cn.zj.sunda.water.service.DeviceDocService;

public class DeviceDocServiceImpl implements DeviceDocService {
	public DeviceDocDao deviceDocDao;

	public DeviceDocDao getDeviceDocDao() {
		return deviceDocDao;
	}

	public void setDeviceDocDao(DeviceDocDao deviceDocDao) {
		this.deviceDocDao = deviceDocDao;
	}
	public List<DeviceDoc> queryByCondition(String condition) {
		
		return deviceDocDao.queryByCondition(condition);
	}
	public void saveDeviceDoc(DeviceDoc deviceDoc){
		deviceDocDao.saveDeviceDoc(deviceDoc);
	}
	public void updateDeviceDoc(DeviceDoc deviceDoc){
		deviceDocDao.updateDeviceDoc(deviceDoc);
	}
	public void deleteDeviceDoc(DeviceDoc deviceDoc){
		deviceDocDao.deleteDeviceDoc(deviceDoc);
	}
}
