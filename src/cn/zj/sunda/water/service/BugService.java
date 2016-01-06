package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.Bug;

public interface BugService {
	public Bug queryBugById(Long bugId);
	
	public List<Bug> queryByCondition(String condition);

	public List<Bug> queryBugByCondition(String condition);
	
	public void deleteBugByIds(String[] bugIdList);
	
	public void saveBug(Bug bugContent);

}
