package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.ControlLog;
import cn.zj.sunda.water.bo.Sewage;

public interface SewageService {

	public List<Sewage> queryAllSewage();
	
	public List<Sewage> querySewageByCondition(String condition);
	
	public Sewage querySewageById(int id);
	
	public void deleteById(int id);
	
	public void deleteByIds(String[] ids);
	
	public void saveSewage(Sewage sewage);
	
	public Sewage querySewageByShorttitle(String title);
	
	public List<Sewage> queryAllSewageByShorttitle(String title);
	
	public Sewage querySewageByName(String sewageName);
	
	public List<Sewage> querySewageByAreaId(Integer areaId);
	
	public void saveControlLog(ControlLog controlLog);
	
	public List<Sewage> querySewageByControlID(Integer controlID);
	
}
