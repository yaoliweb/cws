package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.DayCollect;
import cn.zj.sunda.water.dao.DayCollectDao;
import cn.zj.sunda.water.service.DayCollectService;

public class DayCollectServiceImpl implements DayCollectService {

	private DayCollectDao dayCollectDao;
	
	public DayCollectDao getDayCollectDao() {
		return dayCollectDao;
	}

	public void setDayCollectDao(DayCollectDao dayCollectDao) {
		this.dayCollectDao = dayCollectDao;
	}

	public void deleteDayCollectById(int id) {
		
		this.dayCollectDao.deleteDayCollectById(id);
	}

	public List<DayCollect> queryDayCollectByDate(String date,String area) {
		
		return this.dayCollectDao.queryDayCollectByDate(date,area);
	}

	public List<DayCollect> queryDayCollectByMonth(String month,String area) {
		
		return this.dayCollectDao.queryDayCollectByMonth(month,area);
	}

	public List<DayCollect> queryDayCollectByYear(String year,String area) {
		
		return this.dayCollectDao.queryDayCollectByYear(year, area);
	}

	public List<DayCollect> queryDayCollectByMonth(String month, String area,
			String sewage) {
		
		return this.dayCollectDao.queryDayCollectByMonth(month, area, sewage);
	}

	public List<DayCollect> queryDayCollectByYear(String year, String area,
			String sewage) {
		
		return this.dayCollectDao.queryDayCollectByYear(year, area, sewage);
	}



}
