/*
 * JCatalog Project
 */
package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.Csusers;

public interface UserService {

	public Csusers login(String username, String password);
	
	public List<Csusers> queryAllUsers();
	
	public void saveUser(Csusers user);
	
	public void deleteUserById(int id);
	
	public void deleteUserByIds(String[] ids);
	
	public List<Csusers> queryUserByUserLogid(String logid);
	
	public Csusers queryUserByUserId(int userId);
}
