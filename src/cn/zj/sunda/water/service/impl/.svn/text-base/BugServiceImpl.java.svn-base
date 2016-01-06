package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Bug;
import cn.zj.sunda.water.dao.BugDao;
import cn.zj.sunda.water.service.BugService;

public class BugServiceImpl implements BugService {

	public BugDao bugDao;

	/**
	 * @return the bugDao
	 */
	public BugDao getBugDao() {
		return bugDao;
	}

	/**
	 * @param bugDao the bugDao to set
	 */
	public void setBugDao(BugDao bugDao) {
		this.bugDao = bugDao;
	}

	public Bug queryBugById(Long bugId) {
		
		return bugDao.queryBugById(bugId);
	}

	public List<Bug> queryByCondition(String condition) {
		
		return bugDao.queryByCondition(condition);
	}

	public List<Bug> queryBugByCondition(String condition) {
		
		return bugDao.queryBugByCondition(condition);
	}

	public void deleteBugByIds(String[] BugIdList) {

		this.bugDao.deleteBugByIds(BugIdList);
	}

	public void saveBug(Bug BugContent) {

		bugDao.saveBug(BugContent);
	}

}
