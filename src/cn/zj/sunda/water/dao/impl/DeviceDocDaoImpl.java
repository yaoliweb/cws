package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.DeviceDoc;
import cn.zj.sunda.water.dao.DeviceDocDao;

public class DeviceDocDaoImpl extends HibernateDaoSupport implements
		DeviceDocDao {
	public List<DeviceDoc> queryByCondition(String condition) 
	{	
		List<DeviceDoc> list = this.getHibernateTemplate().find("from DeviceDoc as DeviceDoc where "+condition);
		return list;
	}
	public void saveDeviceDoc(DeviceDoc deviceDoc) {
		getHibernateTemplate().saveOrUpdate(deviceDoc);
	}
	public void updateDeviceDoc(DeviceDoc deviceDoc) {
		getHibernateTemplate().update(deviceDoc);
	}
	public void deleteDeviceDoc(DeviceDoc deviceDoc){
		getHibernateTemplate().delete(deviceDoc);
	}
}
