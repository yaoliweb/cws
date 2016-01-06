package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Roles;
import cn.zj.sunda.water.bo.Userrole;

public interface RoleService {
	
	public List<Roles> queryAllRoles();
	
	public void saveRole(Roles role);
	
	public void saveRoles(List<Roles> roles);
	
	public Roles queryRoleById(int id);
	
	public List<Roles> queryRoleByCondition(String condition);
	
	public void saveUserRole(Userrole userRole);
	
	public void deleteUserRole(String[] userIds);
	public void deleteUserRole(Userrole userRole);
	
	public List<Userrole> getUserRoleByUserId(int Userid);
	
	public void deleteRoleById(int id);
	
	public void deleteRoleByIds(String[] ids);
	
	public void saveRoleMenu(Rolemenu roleMenu);
	
	public void deleteRoleMenuByRoleIds(String[] ids);
	
	public void deleteRoleMenuByMenuIds(String[] ids);

}
