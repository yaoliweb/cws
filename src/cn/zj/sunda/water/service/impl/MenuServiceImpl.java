package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Menus;
import cn.zj.sunda.water.dao.MenuDao;
import cn.zj.sunda.water.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public Menus getMenusByMenuId(int menuid) {

		Menus menus = this.menuDao.getMenusByMenuId(menuid);
		return menus;
	}

	public List<Menus> queryAllMenus() {

		return this.menuDao.queryAllMenus();
	}

	public void saveMenu(Menus menu) {

		this.menuDao.saveMenu(menu);

	}

	public void deleteMenusByIds(String[] ids) {

		for (int i = 0; i < ids.length; i++) {
			deleteMenusById(Integer.valueOf(ids[i]));
		}

	}
	public void deleteMenusById(int id)
	{
		this.menuDao.deleteMenuById(id);
	}

	public List<Menus> queryMenusByCondition(String condition) {
		
		return this.menuDao.queryMenusByCondition(condition);
	}

}
