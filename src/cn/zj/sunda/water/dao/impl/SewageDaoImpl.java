package cn.zj.sunda.water.dao.impl;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.ControlLog;
import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.statistics;
import cn.zj.sunda.water.dao.SewageDao;

public class SewageDaoImpl extends HibernateDaoSupport implements SewageDao {

	public void deleteSewage(Sewage sewage) {
		
		getHibernateTemplate().delete(sewage);

	}

	public List<Sewage> queryAllSewage() {
		List<Sewage> list = getHibernateTemplate().find("from Sewage");
		Iterator it=list.iterator();
		while(it.hasNext()){	
			Sewage sewage=(Sewage) it.next();	
			String year,month,day;
			Calendar date = Calendar.getInstance();
			year= String.valueOf(date.get(Calendar.YEAR));
			month= String.valueOf(date.get(Calendar.MONTH)+1);
			day= String.valueOf(date.get(Calendar.DAY_OF_MONTH));
			int id=sewage.getSewageId();
			List<statistics> list_ststistics=getHibernateTemplate().find("from statistics as statistics where statistics.sewageID='" +
					id+"' and statistics.year='"+year+"'and statistics.month='"+month+"'and statistics.day='"+day+"'");
			statistics s=null;
			if(list_ststistics.size()>=1){
			 s=(statistics)list_ststistics.get(0);
		     sewage.setFlow(s.getWater());
		     sewage.setCod(s.getCod());
		     sewage.setP(s.getP());
		     sewage.setNh3n(s.getNh3n());
			}
			else{
				sewage.setFlow(0);
			    sewage.setCod(0);
			    sewage.setP(0);
			    sewage.setNh3n(0);
			}
			sewage.setUserRole(cn.zj.sunda.water.bean.UserBean.idOfRole);
		}
		return list;
	}

	public List<Sewage> querySewageByCondition(String condition) {
		List<Sewage> list = getHibernateTemplate().find("from Sewage where "+condition);
		return list;
	}

	public Sewage querySewageById(int id) {
		
		Sewage sewage = getHibernateTemplate().get(Sewage.class, id);
		sewage.setUserRole(cn.zj.sunda.water.bean.UserBean.idOfRole);
		return sewage;
	}

	public void saveSewage(Sewage sewage) {
		
		getHibernateTemplate().saveOrUpdate(sewage);

	}
	
	public Sewage querySewageByShorttitle(String title) {
		
		return  (Sewage)getHibernateTemplate().find("from Sewage where shortTitle ='"+title+"'").get(0);
		
	}
	
	public List<Sewage> queryAllSewageByShorttitle(String title) {
		List<Sewage> list = this.getHibernateTemplate().find("from Sewage where shortTitle ='"+title+"' or operationnum = '"+title+"' ");
		return list;
	}

	public Sewage querySewageByName(String sewageName) {
		Sewage sewage= (Sewage)getHibernateTemplate().find("from Sewage where name ='" + sewageName + "'").get(0);
		return sewage;
	}
	
	public List<Sewage> querySewageByAreaId(Integer areaId) {
	   List<Sewage> sewages=getHibernateTemplate().find("from Sewage where areaID ='" + areaId + " ' order by short_title" );
	   for (int i=0;i<sewages.size();i++){
		   sewages.get(i).setNumber(i+1);
	   }
	   return sewages;
	}
	
	public void saveControlLog(ControlLog controlLog) {
		
		getHibernateTemplate().saveOrUpdate(controlLog);

	}	
	
	public List<Sewage> querySewageByControlID(Integer controlID) {
		List<Sewage> list = this.getHibernateTemplate().find("from Sewage where controlId ='" + controlID + "'");
		return list;
	}
}
