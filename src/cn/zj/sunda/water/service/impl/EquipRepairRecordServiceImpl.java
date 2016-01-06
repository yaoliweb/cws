package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.EquipRepairRecord;
import cn.zj.sunda.water.dao.EquipRepairRecordDao;
import cn.zj.sunda.water.service.EquipRepairRecordService;

public class EquipRepairRecordServiceImpl implements EquipRepairRecordService {
	public EquipRepairRecordDao equipRepairRecordDao;
	public EquipRepairRecordDao getEquipRepairRecordDao() {
		return equipRepairRecordDao;
	}
	public void setEquipRepairRecordDao(EquipRepairRecordDao equipRepairRecordDao) {
		this.equipRepairRecordDao = equipRepairRecordDao;
	}
	public List<EquipRepairRecord> queryByCondition(String condition) {		
		return equipRepairRecordDao.queryByCondition(condition);
	}
	public void saveEquipRepairRecordService(EquipRepairRecord equipRepairRecord){
		equipRepairRecordDao.saveEquipRepairRecordDao(equipRepairRecord);
	}
}
