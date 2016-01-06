package cn.zj.sunda.water.dao;

import java.util.List;

import cn.zj.sunda.water.bo.EquipRepairRecord;

public interface EquipRepairRecordDao {
	public List<EquipRepairRecord> queryByCondition(String condition);
	public void saveEquipRepairRecordDao(EquipRepairRecord equipRepairRecord);
}
