package cn.zj.sunda.water.dao;

import java.util.Date;
import java.util.List;

import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.WarnSearch;

public interface warnSearchDao {
	
	public String queryByAreaID(int id,double flagTime);
	
	public List<Sewage> queryLastUpdate();
	


}
