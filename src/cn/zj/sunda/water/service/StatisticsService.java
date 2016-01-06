package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.statistics;

public interface StatisticsService {
	
	public List<statistics> queryStatisticsByDay(String year,String month,String day,String sewageName);
	
	public List<statistics> queryStatisticsByMonth(String year,String month,String sewageName);
	
	public List<statistics> queryStatisticsByYear(String year,String sewageName);
	
	public List<statistics> queryAllByDay(String year,String month,String day);
	
	public List<statistics> queryAllByMonth(String year,String month);
	
	public List<statistics> queryAllByYear(String year);
	
	public statistics queryBysewageIdTop1(Integer id);
}
