package cn.zj.sunda.water.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

import cn.zj.sunda.water.bo.DetectionData;
import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.dao.DetectionDataDao;

public class DetectionDataDaoImpl extends HibernateDaoSupport implements DetectionDataDao {

	public void deleteDetectionData(DetectionData detectionData) {
		
		getHibernateTemplate().delete(detectionData);

	}
	

	public List<DetectionData> queryAllDetectionData() {
		List<DetectionData> list = getHibernateTemplate().find("from DetectionData order by testingtime asc");
		return list;
	}

	public List<DetectionData> queryDetectionDataByCondition(String condition) {
		List<DetectionData> list = getHibernateTemplate().find("from DetectionData where "+ condition+"order by testingtime desc");
		
		return list;
	}
	
	
	public List<DetectionData> queryDetectionDataByCondition2(Integer condition) {
		List<DetectionData> list=new ArrayList<DetectionData>();
		Integer a=44;
		System.out.println("ID为："+condition);
		Date date;
		Calendar c=Calendar.getInstance();
		c.set(1900, 1, 1);
		date=c.getTime();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		
		try {
			
			
			list = getHibernateTemplate().find("from DetectionData where sewageID="+condition+" order by testingtime desc");
			if(list.size()==0)
			{
				List<DetectionData> listnull = getHibernateTemplate().find("from DetectionData where sewageID="+a+" order by testingtime asc");
				//listnull.get(0).setTestingtime(df.parse(df.format(date)));
				listnull.get(0).setLastupdate(df.format(date));
			System.out.println("为空");	
			return listnull;
			}
			list.get(0).setLastupdate(df.format(list.get(0).getTestingtime()));	
			System.out.println("执行DAO");
			return list;
			//System.out.println(list.get(0).getSewage().getShortTitle());
		} catch (Exception e) {
			
			list = getHibernateTemplate().find("from DetectionData where sewageID="+a+" order by testingtime desc");
			// TODO: handle exception
			System.out.println("执行DAO里的catch");
			return list;
		}
		
	
		
		
	}
	

	public DetectionData queryDetectionDataById(int id) {
		
		DetectionData detectionData = getHibernateTemplate().get(DetectionData.class, id);
		return detectionData;
	}

	public void saveDetectionData(DetectionData detectionData) {
		
		getHibernateTemplate().saveOrUpdate(detectionData);

	}

   public List<DetectionData> queryDetectionDataBySewageID(Integer id)
   {
	  List<DetectionData> dt= (List<DetectionData>) this.getHibernateTemplate().find("from DetectionData where sewageID="+id+" order by testingtime desc");
	   return dt;
   }


}
