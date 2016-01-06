package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.RunData;
import cn.zj.sunda.water.dao.RunDataDao;

public class RunDataDaoImpl extends HibernateDaoSupport implements RunDataDao {

	public void deleteRunData(RunData runData) {
		
		getHibernateTemplate().delete(runData);

	}

	public List<RunData> queryAllRunData() {

		List<RunData> list = getHibernateTemplate().find("from RunData");
		return list;
	}

	public List<RunData> queryRunDataByCondition(String condition) {
		List<RunData> list = getHibernateTemplate().find("from RunData where "+condition+ "order by testingtime DESC");
		return list;
	}

	public RunData queryRunDataById(int id) {
		
		RunData runData = getHibernateTemplate().get(RunData.class, id);
		return runData;
	}

	public void saveRunData(RunData runData) {
		
		getHibernateTemplate().save(runData);

	}

}
