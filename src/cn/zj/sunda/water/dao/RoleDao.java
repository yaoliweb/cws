package cn.zj.sunda.water.dao;

import java.util.List;

import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Roles;
import cn.zj.sunda.water.bo.Userrole;

public interface RoleDao {

	public List<Roles> queryAllRoles();

	public void saveRole(Roles role);

	public Roles queryRoleById(int id);
	
	public List<Roles> queryRoleByCondition(String condition); 

	public void saveUserRole(Userrole userRole);

	public void deleteUserRole(Userrole userRole);

	public List<Userrole> getUserRoleByUserId(int Userid);

	public void deleteRoleById(int id);

	public void saveRoleMenu(Rolemenu rolemenu);

	public void deleteRoleMenu(Rolemenu roleMenu);
	public List<Rolemenu> queryRolemenuByRoleId(int id);
	public List<Rolemenu> queryRolememuByMenuId(int menuid);

}
