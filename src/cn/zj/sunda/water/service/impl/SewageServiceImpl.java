package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.ControlLog;
import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.dao.SewageDao;
import cn.zj.sunda.water.service.SewageService;

public class SewageServiceImpl implements SewageService {

	public SewageDao sewageDao;
	
	public SewageDao getSewageDao() {
		return sewageDao;
	}

	public void setSewageDao(SewageDao sewageDao) {
		this.sewageDao = sewageDao;
	}

	public void deleteById(int id) {
		
		this.sewageDao.deleteSewage(this.querySewageById(id));

	}

	public void deleteByIds(String[] ids) {
		
		for (int i = 0; i < ids.length; i++) {
			this.deleteById(Integer.valueOf(ids[i]));
		}

	}

	public List<Sewage> queryAllSewage() {
		return this.sewageDao.queryAllSewage();
	}

	public List<Sewage> querySewageByCondition(String condition) {
		return this.sewageDao.querySewageByCondition(condition);
	}

	public Sewage querySewageById(int id) {
		return this.sewageDao.querySewageById(id);
	}

	public void saveSewage(Sewage sewage) {
		this.sewageDao.saveSewage(sewage);

	}

	public Sewage querySewageByShorttitle(String title) {
		
		return this.sewageDao.querySewageByShorttitle(title);
	}
	
	public List<Sewage> queryAllSewageByShorttitle(String title) {
		return this.sewageDao.queryAllSewageByShorttitle(title);
	}
	
	public Sewage querySewageByName(String sewageName) {
		return (Sewage)this.sewageDao.querySewageByName(sewageName);
	}

	public List<Sewage> querySewageByAreaId(Integer areaId) {
		return this.sewageDao.querySewageByAreaId(areaId);
	}
	
	public void saveControlLog(ControlLog controlLog) {
		this.sewageDao.saveControlLog(controlLog);

	}
	
	public List<Sewage> querySewageByControlID(Integer controlID) {
		return this.sewageDao.querySewageByControlID(controlID);
	}
}