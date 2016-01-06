package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.statistics;
import cn.zj.sunda.water.dao.statisticsDao;
import cn.zj.sunda.water.service.StatisticsService;

public class StatisticsServiceImpl implements StatisticsService {

	statisticsDao statisticsDao;
	public statisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	public void setStatisticsDao(statisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	public List<statistics> queryAllByDay(String year, String month, String day) {
		// TODO Auto-generated method stub
		return statisticsDao.queryAllByDay(year, month, day);
		
	}

	public List<statistics> queryAllByMonth(String year, String month) {
		// TODO Auto-generated method stub
		return statisticsDao.queryAllByMonth(year, month);
	}

	public List<statistics> queryAllByYear(String year) {
		// TODO Auto-generated method stub
		return statisticsDao.queryAllByYear(year);
	}

	public List<statistics> queryStatisticsByDay(String year, String month,
			String day, String sewageName) {
		// TODO Auto-generated method stub
		return statisticsDao.queryStatisticsByDay(year, month, day, sewageName);
	}

	public List<statistics> queryStatisticsByMonth(String year, String month,
			String sewageName) {
		// TODO Auto-generated method stub
		return statisticsDao.queryStatisticsByMonth(year, month, sewageName);
	}

	public List<statistics> queryStatisticsByYear(String year, String sewageName) {
		// TODO Auto-generated method stub
		return statisticsDao.queryStatisticsByYear(year, sewageName);
	}
	public statistics queryBysewageIdTop1(Integer id){
		
		
		
		return statisticsDao.queryStatisticBysewageID(id);
		
	}
}
