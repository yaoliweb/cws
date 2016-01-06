package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.dao.AreaDao;

public class AreaDaoImpl extends HibernateDaoSupport implements AreaDao{

	public Area getAreaById(int id)
	{
		return getHibernateTemplate().load(Area.class, id);
	}
	public void deleteAreaById(int id) {
		
		getHibernateTemplate().delete(getAreaById(id));
	}

	public List<Area> queryAllArea() {
		
		List<Area> list=getHibernateTemplate().find("from Area");
		return list;
	}
	
	public List<Area> queryAreaByCondition(String condition) {
		List<Area> list=getHibernateTemplate().find("from Area where "+condition);
		return list;
	}
	public void saveArea(Area area) {
		
		getHibernateTemplate().saveOrUpdate(area);
		
	}
	public Area queryAreaById(int id) {
		
		return getHibernateTemplate().get(Area.class, id);
	}

	public Area queryAreaByName(String areaName) {
		
		return (Area)getHibernateTemplate().find("from Area where name = '" + areaName + "'").get(0);
	}	
}
