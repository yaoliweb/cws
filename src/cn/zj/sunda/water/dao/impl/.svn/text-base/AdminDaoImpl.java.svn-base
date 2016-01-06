package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Administrator;
import cn.zj.sunda.water.dao.AdminDao;

public class AdminDaoImpl extends HibernateDaoSupport implements AdminDao {

	public void deleteAreaById(int id) {
		
		getHibernateTemplate().delete(queryAdministratorById(id));

	}

	public List<Administrator> queryAdministratorByCondition(String condition) {
		List<Administrator> list = getHibernateTemplate().find("from Administrator where "+condition);
		return list;
	}

	public Administrator queryAdministratorById(int id) {
		Administrator admin = getHibernateTemplate().get(Administrator.class, id);
		return admin;
	}

	public List<Administrator> queryAllAdministrator() {
		List<Administrator> list = getHibernateTemplate().find("from Administrator");
		return list;
	}

	public void saveAdministrator(Administrator admin) {
		
		getHibernateTemplate().saveOrUpdate(admin);

	}

}
