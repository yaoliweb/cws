package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Administrator;
import cn.zj.sunda.water.dao.AdminDao;
import cn.zj.sunda.water.service.AdminService;

public class AdminServiceImpl implements AdminService {

	public AdminDao adminDao;
	
	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void deleteAdministratorById(int id) {
		
		this.adminDao.deleteAreaById(id);

	}

	public void deleteAdministratorByIds(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			deleteAdministratorById(Integer.parseInt(ids[i]));
		}

	}

	public List<Administrator> queryAdministratorByCondition(String condition) {
		
		return this.adminDao.queryAdministratorByCondition(condition);
	}

	public Administrator queryAdministratorById(int id) {
		
		return this.adminDao.queryAdministratorById(id);
	}

	public List<Administrator> queryAllAdministrator() {
		
		return this.adminDao.queryAllAdministrator();
	}

	public void saveAdministrator(Administrator admin) {
		
		this.adminDao.saveAdministrator(admin);

	}

}
