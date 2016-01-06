package cn.zj.sunda.water.service;

import java.util.List;

import cn.zj.sunda.water.bo.Menus;
import cn.zj.sunda.water.exception.WaterException;


public interface MenuService {
	public Menus getMenusByMenuId(int menuid)throws WaterException;
	
	public List<Menus> queryAllMenus();
	
	public void saveMenu(Menus menu);
	
	public void deleteMenusByIds(String[] ids);
	
	public List<Menus> queryMenusByCondition(String condition);

}
