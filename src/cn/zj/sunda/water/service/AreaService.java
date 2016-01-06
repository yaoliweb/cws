package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.Area;

public interface AreaService {
	
	public void deleteAreaById(int id);
	
	public List<Area> queryAllArea();
	
	public void deleteAreaByIds(String[] ids);
	
	public List<Area> queryAreaByCondition(String condition);
	
	public void saveArea(Area area);
	
	public Area queryAreaById(int id);
	
	public Area queryAreaByName(String areaName);

}
