package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.EquipRepairRecord;
import cn.zj.sunda.water.dao.EquipRepairRecordDao;

public class EquipRepairRecordDaoImpl extends HibernateDaoSupport implements
		EquipRepairRecordDao {
	public List<EquipRepairRecord> queryByCondition(String condition) 
	{	
		List<EquipRepairRecord> list = getHibernateTemplate().find("from EquipRepairRecord as EquipRepairRecord where "+condition);
		return list;
	}
	public void saveEquipRepairRecordDao(EquipRepairRecord equipRepairRecord){
		getHibernateTemplate().saveOrUpdate(equipRepairRecord);
	}
}
