package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.RunData;
import cn.zj.sunda.water.dao.RunDataDao;
import cn.zj.sunda.water.service.RunDataService;

public class RunDataServiceImpl implements RunDataService {

	public RunDataDao runDataDao;
	
	public RunDataDao getRunDataDao() {
		return runDataDao;
	}

	public void setRunDataDao(RunDataDao runDataDao) {
		this.runDataDao = runDataDao;
	}

	public List<RunData> queryAllRunData() {
		return runDataDao.queryAllRunData();
	}

	public List<RunData> queryRunDataByCondition(String condition) {
		
		return runDataDao.queryRunDataByCondition(condition);
	}

	public RunData queryRunDataById(int id) {
		
		return runDataDao.queryRunDataById(id);
	}

}
