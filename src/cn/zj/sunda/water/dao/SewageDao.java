package cn.zj.sunda.water.dao;

import java.util.List;

import cn.zj.sunda.water.bo.ControlLog;
import cn.zj.sunda.water.bo.Sewage;

public interface SewageDao {

	public List<Sewage> queryAllSewage();
	
	public List<Sewage> querySewageByCondition(String condition);
	
	public Sewage querySewageById(int id);
	
	public void saveSewage(Sewage sewage);
	
	public void deleteSewage(Sewage sewage);
	
	public Sewage querySewageByShorttitle(String title);
	
	public List<Sewage> queryAllSewageByShorttitle(String title);
	
	public Sewage querySewageByName(String sewageName);
	
	public List<Sewage> querySewageByAreaId(Integer areaId);
	
	public void saveControlLog(ControlLog controlLog);
	
	public List<Sewage> querySewageByControlID(Integer controlID);
	
	}