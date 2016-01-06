package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Sysparam;
import cn.zj.sunda.water.dao.SysparamDao;

public class SysparamDaoImpl extends HibernateDaoSupport implements SysparamDao {

	public void deleteSysparam(Sysparam sysparam) {
		
		getHibernateTemplate().delete(sysparam);

	}

	public List<Sysparam> queryAllSysparam() {
		List<Sysparam> list = getHibernateTemplate().find("from Sysparam");
		return list;
	}

	public List<Sysparam> querySysparamByCondition(String condition) {
		List<Sysparam> list = getHibernateTemplate().find("from Sysparam where "+condition);
		return list;
	}

	public Sysparam querySysparamById(int id) {
		Sysparam sysparam = getHibernateTemplate().get(Sysparam.class, id);
		return sysparam;
	}

	public void savaSysparam(Sysparam sysparam) {
		
		getHibernateTemplate().saveOrUpdate(sysparam);

	}

}
