package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Roles;
import cn.zj.sunda.water.bo.Userrole;
import cn.zj.sunda.water.dao.RoleDao;
import cn.zj.sunda.water.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public List<Roles> queryAllRoles() {
		
		return this.roleDao.queryAllRoles();
	}
	public void saveRole(Roles role) {
		
		this.roleDao.saveRole(role);
		
	}
	public void saveRoles(List<Roles> roles) {
		
		for(Roles r:roles){
			saveRole(r);
		}
		
	}
	public Roles queryRoleById(int id) {
		
		return this.roleDao.queryRoleById(id);
	}
	
	public List<Roles> queryRoleByCondition(String condition){
		
		return this.roleDao.queryRoleByCondition(condition);
	}
	
	public void saveUserRole(Userrole userRole) {
		
		this.roleDao.saveUserRole(userRole);
		
	}
	public void deleteUserRole(String[] userIds) {
		
		for (int i = 0; i < userIds.length; i++) {
			List<Userrole> userRoleList =getUserRoleByUserId(Integer.valueOf(userIds[i]));
			for (int j = 0; j < userRoleList.size(); j++) {
				this.roleDao.deleteUserRole(userRoleList.get(j));
			}	
		}
		
		
	}
	public List<Userrole> getUserRoleByUserId(int Userid) {
		
		return this.roleDao.getUserRoleByUserId(Userid);
	}
	public void deleteRoleById(int id) {
		
		this.roleDao.deleteRoleById(id);
		
	}
	public void deleteRoleByIds(String[] ids) {
		
		for (int i = 0; i < ids.length; i++) {
			deleteRoleById(Integer.valueOf(ids[i]));
		}
		
	}
	public void saveRoleMenu(Rolemenu roleMenu) {
		
		this.roleDao.saveRoleMenu(roleMenu);
		
	}

	public void deleteRoleMenuByRoleIds(String[] ids) {
		
		for (int i = 0; i < ids.length; i++) {
			List<Rolemenu> roleMenuList = queryRoleMenuByRoleId(Integer.valueOf(ids[i]));
			for (int j = 0; j < roleMenuList.size(); j++) {
				this.roleDao.deleteRoleMenu(roleMenuList.get(j));
			}
		}
		
	}
	
	public List<Rolemenu> queryRoleMenuByRoleId(int roleId)
	{
		return this.roleDao.queryRolemenuByRoleId(roleId);
	}
	
	public List<Rolemenu> queryRoleMenuByMenuId(int menuId)
	{
		return this.roleDao.queryRolememuByMenuId(menuId);
	}
	public void deleteRoleMenuByMenuIds(String[] ids) {
		
		for (int i = 0; i < ids.length; i++) {
			List<Rolemenu> rolemenuList =queryRoleMenuByMenuId(Integer.valueOf(ids[i]));
			for (int j = 0; j < rolemenuList.size(); j++) {
				this.roleDao.deleteRoleMenu(rolemenuList.get(j));
			}
		}
		
	}
	public void deleteUserRole(Userrole userRole) {


		this.roleDao.deleteUserRole(userRole);
		
		
	}

}
