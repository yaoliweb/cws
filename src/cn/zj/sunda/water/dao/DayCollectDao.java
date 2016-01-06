package cn.zj.sunda.water.dao;

import java.util.List;

import cn.zj.sunda.water.bo.DayCollect;

public interface DayCollectDao  {

	public void deleteDayCollectById(int id);
	
	public List<DayCollect> queryDayCollectByDate(String date,String area);
	
	public List<DayCollect> queryDayCollectByMonth(String month,String area);
	
	public List<DayCollect> queryDayCollectByYear(String year,String area);
	
	public List<DayCollect> queryDayCollectByMonth(String month,String area,String sewage);
	
	public List<DayCollect> queryDayCollectByYear(String year,String area,String sewage);
}
