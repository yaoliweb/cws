package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Sysparam;
import cn.zj.sunda.water.dao.SysparamDao;
import cn.zj.sunda.water.service.SysparamService;

public class SysparamServiceImpl implements SysparamService {

	public SysparamDao sysparamDao;
	
	public SysparamDao getSysparamDao() {
		return sysparamDao;
	}

	public void setSysparamDao(SysparamDao sysparamDao) {
		this.sysparamDao = sysparamDao;
	}

	public void deleteSysparam(Sysparam sysparam) {
		
		this.sysparamDao.deleteSysparam(sysparam);

	}

	public void deleteSysparamById(int id) {

		this.sysparamDao.deleteSysparam(querySysparamById(id));

	}

	public void deleteSysparamByIds(String[] ids) {

		for (int i = 0; i < ids.length; i++) {
			deleteSysparamById(Integer.parseInt(ids[i]));
		}

	}

	public List<Sysparam> queryAllSysparam() {

		return this.sysparamDao.queryAllSysparam();
	}

	public List<Sysparam> querySysparamByCondition(String condition) {
		
		return this.sysparamDao.querySysparamByCondition(condition);
	}

	public Sysparam querySysparamById(int id) {
		
		return this.sysparamDao.querySysparamById(id);
	}

	public void savaSysparam(Sysparam sysparam) {
	
		this.sysparamDao.savaSysparam(sysparam);
	}

}
