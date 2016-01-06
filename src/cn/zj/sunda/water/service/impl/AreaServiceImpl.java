package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.dao.AreaDao;
import cn.zj.sunda.water.service.AreaService;

public class AreaServiceImpl implements AreaService {

	private AreaDao areaDao;

	public AreaDao getAreaDao() {
		return areaDao;
	}

	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public void deleteAreaById(int id) {
		
		this.areaDao.deleteAreaById(id);
		
	}

	public List<Area> queryAllArea() {
		
		return this.areaDao.queryAllArea();
	}

	public void deleteAreaByIds(String[] ids) {
		
		for (int i = 0; i < ids.length; i++) {
			deleteAreaById(Integer.valueOf(ids[i]));
		}
		
	}

	public List<Area> queryAreaByCondition(String condition) {
		
		return this.areaDao.queryAreaByCondition(condition);
	}

	public void saveArea(Area area) {
		
		this.areaDao.saveArea(area);
		
	}

	public Area queryAreaById(int id) {
		
		return this.areaDao.queryAreaById(id);
	}
	
	public Area queryAreaByName(String areaName) {
		
		return this.areaDao.queryAreaByName(areaName);
	}	
}
