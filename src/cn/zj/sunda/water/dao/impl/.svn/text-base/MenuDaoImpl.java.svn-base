package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Menus;
import cn.zj.sunda.water.dao.MenuDao;

public class MenuDaoImpl extends HibernateDaoSupport implements MenuDao{

	public Menus getMenusByMenuId(int menuid) {
		//getHibernateTemplate().setCacheQueries(true);
		Menus menus = (Menus)getHibernateTemplate().find("from Menus where menuid ="+menuid).get(0);
		return menus;
	}

	public List<Menus> queryAllMenus() {
		//getHibernateTemplate().setCacheQueries(true);
		List<Menus> list = getHibernateTemplate().find("from Menus");
		return list;
	}

	public void saveMenu(Menus menu) {
		
		getHibernateTemplate().saveOrUpdate(menu);
		
	}

	public void deleteMenuById(int id) {
		
		getHibernateTemplate().delete(getMenuById(id));
		
	}
	
	public Menus getMenuById(int id)
	{
		//getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().load(Menus.class, id);
	}

	public List<Menus> queryMenusByCondition(String condition) {
		//getHibernateTemplate().setCacheQueries(true);
		List<Menus> list = getHibernateTemplate().find("from Menus where "+condition);
		return list;
	}
	
}
