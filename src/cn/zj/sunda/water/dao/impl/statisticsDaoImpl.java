package cn.zj.sunda.water.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.statistics;
import cn.zj.sunda.water.dao.statisticsDao;

public class statisticsDaoImpl extends HibernateDaoSupport implements statisticsDao {

	@SuppressWarnings("null")
	public List<statistics> queryAllByDay(String year, String month, String day) {
		// TODO Auto-generated method stub
		List<Sewage> sewage=getHibernateTemplate().find("from Sewage as Sewage");
		Iterator<Sewage> it=sewage.iterator();
		List<statistics> list = new ArrayList<statistics>();
		List<statistics> tmp = null;
		
		while(it.hasNext()){
			Sewage obj_sewage=(Sewage)it.next();
			tmp=getHibernateTemplate().find("from statistics as statistics " +	"where statistics.year='"+year
				+"' and statistics.month='"+month+"' and statistics.day='"+day+"' and statistics.sewageID='"+obj_sewage.getSewageId()+"'");
			if(tmp.size()>0){
				list.add(tmp.get(0));
			}
			else{
				statistics statistics = new statistics();
				statistics.setCod(0);
				statistics.setSewageName(obj_sewage.getShortTitle());
				statistics.setNh3n(0);
				statistics.setWater(0);
				statistics.setP(0);
				list.add(statistics);
			}
		}
		return list;
	}

	public List<statistics> queryAllByMonth(String year, String month) {
		// TODO Auto-generated method stub
		List<statistics> list=getHibernateTemplate().find("from statistics as statistics " +
				"where statistics.year='"+year+"' and statistics.month='"+month+"'");
		return list;
	}

	public List<statistics> queryAllByYear(String year) {
		// TODO Auto-generated method stub
		List<statistics> list=getHibernateTemplate().find("from statistics as statistics " +
				"where statistics.year='"+year+"'");
		return list;
	}

	public List<statistics> queryStatisticsByDay(String year, String month,
			String day, String sewageName) {
		// TODO Auto-generated method stub
		List<statistics> list=getHibernateTemplate().find("from statistics as statistics " +
				"where statistics.year='"+year+"' and statistics.month='"+month+"' and statistics.day='"+day+"' and statistics.sewageName='"+sewageName+"'");
		return list;
	}

	public List<statistics> queryStatisticsByMonth(String year, String month,
			String sewageName) {
		// TODO Auto-generated method stub
		List<statistics> list=getHibernateTemplate().find("from statistics as statistics " +
				"where statistics.year='"+year+"' and statistics.month='"+month+"' and statistics.sewageName='"+sewageName+"'");
		return list;
	}

	public List<statistics> queryStatisticsByYear(String year, String sewageName) {
		// TODO Auto-generated method stub
		List<statistics> list=getHibernateTemplate().find("from statistics as statistics " +
				"where statistics.year='"+year+"' and statistics.sewageName='"+sewageName+"'");
		return list;
	}
	public statistics queryStatisticBysewageID(Integer id)
	{
		statistics st=(statistics) this.getHibernateTemplate().find("from statistics where sewageID='"+id+"' order by ID desc").get(0);
		return st;
	}
}
