package cn.zj.sunda.water.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zj.sunda.water.service.impl.AreaServiceImpl;
import cn.zj.sunda.water.service.impl.DayCollectServiceImpl;
import cn.zj.sunda.water.service.impl.SewageServiceImpl;
import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.DayCollect;
import cn.zj.sunda.water.bo.Sewage;

public class BirtFactory {

	private static BirtFactory instance;

	private static ApplicationContext context = WebApplicationContextUtils
			.getRequiredWebApplicationContext(InitServlet.SERVLET_CONTEXT);
	
	private final DayCollectServiceImpl dayCollectServiceImpl=(DayCollectServiceImpl) 
	context.getBean("dayCollectService"); 
	
	private final AreaServiceImpl areaServiceImpl=(AreaServiceImpl)context.getBean("areaService");
	
	private final SewageServiceImpl sewageServiceImpl=(SewageServiceImpl)context.getBean("sewageService");
	
	private BirtFactory() {
	}

	public static BirtFactory getInstance() {
		if (instance == null) {
			instance = new BirtFactory();
		}
		return instance;
	}

	public List<DayCollect> queryDayCollectByDate(String date,String area)
	{
		return dayCollectServiceImpl.queryDayCollectByDate(date,area);
	}
	
	public List<DayCollect> queryDayCollectByYear(String year,String area)
	{
		return dayCollectServiceImpl.queryDayCollectByYear(year,area);
	}
	
	public List<DayCollect> queryDayCollectByMonth(String month,String area)
	{
		return dayCollectServiceImpl.queryDayCollectByMonth(month,area);
	}
	
	public List<Area> queryAllArea()
	{
		return areaServiceImpl.queryAllArea();
	}
	
	public List<Sewage> querySewageByCondition(String condition)
	{
		
		return sewageServiceImpl.querySewageByCondition(condition);
	}
	
	public List<DayCollect> queryDayCollectByMonth(String month,String area,String sewage)
	{
		return dayCollectServiceImpl.queryDayCollectByMonth(month,area,sewage);
	}
	
	public List<DayCollect> queryDayCollectByYear(String year,String area,String sewage)
	{
		return dayCollectServiceImpl.queryDayCollectByYear(year,area,sewage);
	}
}
