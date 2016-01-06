package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Bug;
import cn.zj.sunda.water.dao.BugDao;

public class BugDaoImpl extends HibernateDaoSupport implements BugDao{
	
	public Bug queryBugById(Long bugId)
	{
		Bug bug = (Bug)getHibernateTemplate().find("from Bug where bugid="+bugId).get(0);
		return bug;
	}

	public List<Bug> queryByCondition(String condition) 
	{	
		List<Bug> list = getHibernateTemplate().find("from Bug as Bug where "+condition);
		return list;
	}
	
	public List<Bug> queryBugByCondition(String condition) {

		List<Bug> list = getHibernateTemplate().find("from Bug " + condition + " order by bugid");
		return list;		
	}

	public void deleteBugByIds(String[] bugIdList) {
		for(int i=0;i<bugIdList.length;i++)
		{
			deleteBugById(Long.valueOf(bugIdList[i]));
		}
	}
	
	public void deleteBugById(Long bugId)
	{
		getHibernateTemplate().delete(getBugByid(bugId));
	}
	
	public Bug getBugByid(Long bugId) {

		return getHibernateTemplate().load(Bug.class, bugId);
	}

	public void saveBug(Bug bugContent) {
		getHibernateTemplate().saveOrUpdate(bugContent);
	}

}
