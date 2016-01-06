package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.DetectionData;


public interface DetectionDataService {

	public List<DetectionData> queryAllDetectionData();
	
	public List<DetectionData> queryDetectionDataByCondition(String condition);
	public List<DetectionData> queryDetectionDataByCondition2(Integer condition);
	
	public DetectionData queryDetectionDataById(int id);
	
	public void deleteById(int id);
	
	public void deleteByIds(String[] ids);
	
	public void saveDetectionData(DetectionData detectionData);
	public List<DetectionData> queryDetectionDataBySewageId(Integer id);

}
