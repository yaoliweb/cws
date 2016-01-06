package cn.zj.sunda.water.dao;

import java.util.List;

import cn.zj.sunda.water.bo.DeviceDoc;

public interface DeviceDocDao {
	public List<DeviceDoc> queryByCondition(String condition);
	public void saveDeviceDoc(DeviceDoc deviceDoc);
	public void updateDeviceDoc(DeviceDoc deviceDoc);
	public void deleteDeviceDoc(DeviceDoc deviceDoc);
}
