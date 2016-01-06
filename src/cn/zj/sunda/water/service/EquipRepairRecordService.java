package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.DeviceDoc;
import cn.zj.sunda.water.bo.EquipRepairRecord;

public interface EquipRepairRecordService {
	public List<EquipRepairRecord> queryByCondition(String condition);
	public void saveEquipRepairRecordService(EquipRepairRecord equipRepairRecord);
}
