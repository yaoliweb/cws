package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Roles;
import cn.zj.sunda.water.bo.Userrole;
import cn.zj.sunda.water.dao.RoleDao;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao {

	public List<Roles> queryAllRoles() {
		//getHibernateTemplate().setCacheQueries(true);
		List<Roles> list = getHibernateTemplate().find("from Roles");
		return list;
	}

	public void saveRole(Roles role) {
		
		getHibernateTemplate().saveOrUpdate(role);
		
	}

	
	public Roles getRoleById(int id) {
		
		return getHibernateTemplate().load(Roles.class, id);
	}

	public void saveUserRole(Userrole userRole) {
		
		getHibernateTemplate().saveOrUpdate(userRole);
		
	}
	
public void deleteUserRole(Userrole userRole) {
		
		getHibernateTemplate().delete(userRole);
		
	}
	
	public List<Userrole> getUserRoleByUserId(int Userid){
		//getHibernateTemplate().setCacheQueries(true);
		List<Userrole> list = getHibernateTemplate().find("from Userrole where userid="+Userid);
		return list;
	}

	public void deleteRoleById(int id) {
		
		Roles role = getRoleById(id);
		getHibernateTemplate().delete(role);
		
	}

	public void saveRoleMenu(Rolemenu rolemenu) {
		
		getHibernateTemplate().saveOrUpdate(rolemenu);
		
	}

	public void deleteRoleMenu(Rolemenu roleMenu) {
		
		getHibernateTemplate().delete(roleMenu);
		
		
	}

	
	public List<Rolemenu> queryRolemenuByRoleId(int id)
	{
		List<Rolemenu> list = getHibernateTemplate().find("from Rolemenu where roleid ="+id);
		return list;
	}

	public List<Rolemenu> queryRolememuByMenuId(int menuid) {
		
		List<Rolemenu> list = getHibernateTemplate().find("from Rolemenu where menuid ="+menuid);
		return list;
	}

	public Roles queryRoleById(int id) {
		
		Roles role = (Roles)getHibernateTemplate().find("from Roles where roleid ="+id).get(0);
		return role;
	}
	
	public List<Roles> queryRoleByCondition(String condition){
		List<Roles> list = getHibernateTemplate().find("from Roles where" + condition);
		return list;
	}

}
