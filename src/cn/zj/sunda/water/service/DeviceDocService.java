package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.DeviceDoc;

public interface DeviceDocService {
	public List<DeviceDoc> queryByCondition(String condition);
	public void saveDeviceDoc(DeviceDoc deviceDoc);
	public void updateDeviceDoc(DeviceDoc deviceDoc);
	public void deleteDeviceDoc(DeviceDoc deviceDoc);
}
