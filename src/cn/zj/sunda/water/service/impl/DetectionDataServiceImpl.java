package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.DetectionData;
import cn.zj.sunda.water.dao.DetectionDataDao;
import cn.zj.sunda.water.service.DetectionDataService;

public class DetectionDataServiceImpl implements DetectionDataService {

	public DetectionDataDao detectionDataDao;
	
	public DetectionDataDao getDetectionDataDao() {
		return detectionDataDao;
	}

	public void setDetectionDataDao(DetectionDataDao detectionDataDao) {
		this.detectionDataDao = detectionDataDao;
	}

	public void deleteById(int id) {
		
		this.detectionDataDao.deleteDetectionData(queryDetectionDataById(id));

	}

	public void deleteByIds(String[] ids) {
		
		for (int i = 0; i < ids.length; i++) {
			deleteById(Integer.valueOf(ids[i]));
		}

	}

	public List<DetectionData> queryAllDetectionData() {
		
		return this.detectionDataDao.queryAllDetectionData();
	}

	public List<DetectionData> queryDetectionDataByCondition(String condition) {
		
		return this.detectionDataDao.queryDetectionDataByCondition(condition);
	}

public List<DetectionData> queryDetectionDataByCondition2(Integer condition) {
		
		return this.detectionDataDao.queryDetectionDataByCondition2(condition);
	}
	
	
	public DetectionData queryDetectionDataById(int id) {
		
		return this.detectionDataDao.queryDetectionDataById(id);
	}

	public void saveDetectionData(DetectionData detectionData) {
		
		this.detectionDataDao.saveDetectionData(detectionData);

	}
	public List<DetectionData> queryDetectionDataBySewageId(Integer id)
	{
		return this.detectionDataDao.queryDetectionDataBySewageID(id);
	}

}
