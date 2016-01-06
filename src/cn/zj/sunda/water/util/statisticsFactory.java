package cn.zj.sunda.water.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.statistics;
import cn.zj.sunda.water.service.impl.SewageServiceImpl;
import cn.zj.sunda.water.service.impl.StatisticsServiceImpl;

public class statisticsFactory extends HibernateDaoSupport{
	
	private static statisticsFactory instance;
	
	private static ApplicationContext context = WebApplicationContextUtils
	.getRequiredWebApplicationContext(InitServlet.SERVLET_CONTEXT);
	
	private final StatisticsServiceImpl StatisticsServiceImpl=(StatisticsServiceImpl) 
	context.getBean("StatisticsService"); 
	
	private final SewageServiceImpl sewageServiceImpl=(SewageServiceImpl)context.getBean("sewageService");
	
	public static statisticsFactory getInstance() {
		if (instance == null) {
			instance = new statisticsFactory();
		}
		return instance;
	}
	public List<statistics> queryStatisticsByDay(String year, String month,String day,String SewageName){
		List<statistics> list=StatisticsServiceImpl.queryStatisticsByDay(year, month, day, SewageName);
		return list;
	}
	public List<statistics> queryStatisticsByMonth(String year, String month,String SewageName){
		List<statistics> list=StatisticsServiceImpl.queryStatisticsByMonth(year, month,SewageName);
		return list;
	}
	public List<statistics> queryStatisticsByYear(String year,String SewageName){
		List<statistics> list=StatisticsServiceImpl.queryStatisticsByYear(year,SewageName);
		return list;
	}
	public List<statistics> queryAllByDay(String year, String month,String day){
		List<statistics> list=StatisticsServiceImpl.queryAllByDay(year, month, day);
		return list;
	}
	public List<statistics> queryAllByMonth(String year, String month){
		List<statistics> array=new ArrayList<statistics>();
		Iterator<Sewage> seweageList;
		Iterator<statistics> it;
		List<Sewage>sewage=sewageServiceImpl.queryAllSewage();
		seweageList=sewage.iterator();
		statistics statistics;
		float water,cod,nh3n,p;
		while(seweageList.hasNext()){
			Sewage temp=(Sewage) seweageList.next();
			List<statistics> list=StatisticsServiceImpl.queryStatisticsByMonth(year, month,temp.getShortTitle());
			it=list.iterator();
			water=0;
			cod=0;
			nh3n=0;
			p=0;
			if(list.size()>0){
				statistics=(statistics) it.next();
				water+=statistics.getWater();
				cod+=statistics.getCod();
				nh3n+=statistics.getNh3n();
				p+=statistics.getP();
				while(it.hasNext()){
					statistics=(statistics) it.next();
					water+=statistics.getWater();
					cod+=statistics.getCod();
					nh3n+=statistics.getNh3n();
					p+=statistics.getP();
					}
				statistics.setWater(water);
				statistics.setCod(cod);
				statistics.setNh3n(nh3n);
				statistics.setP(p);
				array.add(statistics);
			}
			else{
				statistics=new statistics();
				statistics.setSewageName(temp.getShortTitle());
				statistics.setCod(0);
				statistics.setNh3n(0);
				statistics.setP(0);
				statistics.setWater(0);
				array.add(statistics);
			}
		}
		return array;
	}
	public List<statistics> queryAllByYear(String year){
		List<statistics> array=new ArrayList<statistics>();
		Iterator<Sewage> seweageList;
		Iterator<statistics> it;
		List<Sewage>sewage=sewageServiceImpl.queryAllSewage();
		seweageList=sewage.iterator();
		statistics statistics;
		float water,cod,nh3n,p;
		while(seweageList.hasNext()){
			Sewage temp=(Sewage) seweageList.next();
			List<statistics> list=StatisticsServiceImpl.queryStatisticsByYear(year, temp.getShortTitle());
			it=list.iterator();
			water=0;
			cod=0;
			nh3n=0;
			p=0;
			if(list.size()>0){
				statistics=(statistics) it.next();
				water+=statistics.getWater();
				cod+=statistics.getCod();
				nh3n+=statistics.getNh3n();
				p+=statistics.getP();
				while(it.hasNext()){
					statistics=(statistics) it.next();
					water+=statistics.getWater();
					cod+=statistics.getCod();
					nh3n+=statistics.getNh3n();
					p+=statistics.getP();
					}
				statistics.setWater(water);
				statistics.setCod(cod);
				statistics.setNh3n(nh3n);
				statistics.setP(p);
				array.add(statistics);
			}
			else{
				statistics=new statistics();
				statistics.setSewageName(temp.getShortTitle());
				statistics.setCod(0);
				statistics.setNh3n(0);
				statistics.setP(0);
				statistics.setWater(0);
				array.add(statistics);
			}
		}
		return array;
	}
	public List<Sewage> queryAllSewage(){
		List<Sewage> list=sewageServiceImpl.queryAllSewage();		
		return list;
	}
}
