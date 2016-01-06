package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.DayCollect;
import cn.zj.sunda.water.dao.DayCollectDao;

public class DayCollectDaoImpl extends HibernateDaoSupport implements DayCollectDao{
	
	public DayCollect getDayCollectById(int id){
		
		return getHibernateTemplate().load(DayCollect.class,id);
	}

	public void deleteDayCollectById(int id) {
		
		getHibernateTemplate().delete(getDayCollectById(id));
	}

	public List<DayCollect> queryDayCollectByDate(String date,String area) {
		
		String year,month,day;
		
		year=date.substring(0, 4);
		if(date.substring(4,5).equals("0"))
		{
			month=date.substring(5,6);
		}
		else
		{
			month=date.substring(4,6);
		}
		if(date.substring(6,7).equals("0"))
		{
			day=date.substring(7);
		}
		else
		{
			day=date.substring(6);
		}
		List<DayCollect> list=getHibernateTemplate().find("from DayCollect where year="+year+" and month="+month+" and day="+day +"and area.name ='"+area+"'");
		return list;
	}

	public List<DayCollect> queryDayCollectByMonth(String month,String area) {
		String year,monthNew;
		if(month.substring(4,5).equals("0"))
		{
			monthNew=month.substring(5);
		}
		else
		{
			monthNew=month.substring(4);
		}
		year=month.substring(0, 4);
		List<DayCollect> list=getHibernateTemplate().find("from DayCollect where year = "+year+" and month="+monthNew+" and area.name ='"+area+"'");
		return list;
	}

	public List<DayCollect> queryDayCollectByYear(String year,String area) {
		
		List<DayCollect> list=getHibernateTemplate().find("from DayCollect where year ="+year+"and area.name ='"+area+"'");
		return list;
	}

	public List<DayCollect> queryDayCollectByMonth(String month, String area,
			String sewage) {
		
		String year,monthNew;
		
		if(month.substring(4,5).equals("0"))
		{
			monthNew=month.substring(5);
		}
		else
		{
			monthNew=month.substring(4);
		}
		year=month.substring(0, 4);
		List<DayCollect> list=getHibernateTemplate().find("from DayCollect where year = "+year+" and month="+monthNew+" and area.name ='"+area+"' and sewage.shortTitle='"+sewage+"'");
		return list;
	}

	public List<DayCollect> queryDayCollectByYear(String year, String area,
			String sewage) {
		List<DayCollect> list=getHibernateTemplate().find("from DayCollect where year ="+year+"and area.name ='"+area+"' and sewage.shortTitle='"+sewage+"'");
		return list;
	}

	
	
}
