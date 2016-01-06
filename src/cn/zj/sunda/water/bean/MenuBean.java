package cn.zj.sunda.water.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.richfaces.component.UITree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import cn.zj.sunda.water.bo.Menus;
import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Usermenu;
import cn.zj.sunda.water.exception.WaterException;
import cn.zj.sunda.water.util.FacesUtils;

public class MenuBean extends BaseBean {
	private String nodeTitle;
	Set<Usermenu> usermenusSet;
	Set<Rolemenu> rolemenus;

	public Set<Rolemenu> getRolemenus() {
		return rolemenus;
	}

	public void setRolemenus(Set<Rolemenu> rolemenus) {
		this.rolemenus = rolemenus;
	}

	public Set<Usermenu> getUsermenusSet() {
		return usermenusSet;
	}

	public void setUsermenusSet(Set<Usermenu> usermenusSet) {
		this.usermenusSet = usermenusSet;
	}

	public String getNodeTitle() {
		return nodeTitle;
	}


	public void setNodeTitle(String nodeTitle) {
		this.nodeTitle = nodeTitle;
	}

	/*public void nodeSelectAction() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		String filename = externalContext.getRequestParameterMap().get(
				"contenturl");
		String path = externalContext.getRequestContextPath();
		try {

			externalContext.redirect(path + filename);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (IllegalStateException ee) {

		}
		return;
	}*/
	public void nodeSelectAction() {

		ExternalContext externalContext = FacesContext.getCurrentInstance()
				.getExternalContext();
		String filename = externalContext.getRequestParameterMap().get(
				"contenturl");
		if(UserBean.idOfRole==2)
		   {if(filename.equals("/pages/User/usermanager.faces")||filename.equals("/pages/User/rolemanager.faces")||filename.equals("/pages/User/menumanager.faces"))
		   {
			   JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "对不起，你没有这个权限！","警告",JOptionPane.WARNING_MESSAGE);
		   }
		   else{
			   String path = externalContext.getRequestContextPath();
				try {

					externalContext.redirect(path + filename);

				} catch (IOException e) {

					e.printStackTrace();
				} catch (IllegalStateException ee) {

				}
			
				return;
		   }
		   }
		else if(UserBean.idOfRole==1)
		{
			if(filename.equals("/pages/User/usermanager.faces")||filename.equals("/pages/User/rolemanager.faces")||filename.equals("/pages/User/menumanager.faces")
					||filename.equals("/pages/work/bugmanager.faces")||filename.equals("/pages/setup/sewagemanager.faces")||filename.equals("/pages/setup/areamanager.faces")
					||filename.equals("/pages/setup/adminmanager.faces")||filename.equals("/pages/setup/sysparammanager.faces")||filename.equals("/pages/report/areadays.faces")
					||filename.equals("/pages/report/areamonths.faces")||filename.equals("/pages/report/sewagedays.faces")||filename.equals("/pages/report/areayears.faces")
					||filename.equals("/pages/report/sewageyears.faces")||filename.equals("/pages/work/detectionlist.faces")||filename.equals("/pages/work/equipmentlist.faces")
					||filename.equals("")||filename.equals("/pages/work/buglist.faces")||filename.equals("/pages/setup/messageadd.faces")||filename.equals("/pages/setup/messagelist.faces"))
			{
				 JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"对不起，你没有这个权限！","警告",JOptionPane.WARNING_MESSAGE);	
			}
			else{
				String path = externalContext.getRequestContextPath();
				try {

					externalContext.redirect(path + filename);

				} catch (IOException e) {

					e.printStackTrace();
				} catch (IllegalStateException ee) {

				}
			
				return;
			}
		}
		else
		{String path = externalContext.getRequestContextPath();
		try {

			externalContext.redirect(path + filename);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (IllegalStateException ee) {

		}
	
		return;
		}
	}
	
	
	public void processSelection(NodeSelectedEvent event) {

		UITree tree = (UITree) event.getComponent();
		
		Object o = tree.getRowData();
	}
		

	public static TreeNode<String> menuTreeNode;
	List<Menus> menus = new ArrayList<Menus>();
	public static int menutype = 0;

	public int getMenutype() {
		return menutype;
	}

	public void setMenutype(int menutype) {
		MenuBean.menutype = menutype;
	}


	// 0:根据用户角色得到所有菜单（分厂用）
	// 1:菜单类别=公共菜单+总部管理（切换总厂）
	// 2:菜单类别=分厂查询(切换分厂)
	public TreeNode getMenuTreeNode() {
		try {
			//Set<Rolemenu> roleMenus = UserBean.roleMenuSet;
			HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Set<Rolemenu> roleMenus = (Set<Rolemenu>)session.getAttribute("roleMenu");
			
			Iterator<Rolemenu> it = roleMenus.iterator();
			while (it.hasNext()) {
				Rolemenu roleMenu = (Rolemenu) it.next();
				Menus menu = (Menus) roleMenu.getMenus();
				if (menutype == 1) {

					if ("公共菜单".equals(menu.getType())
							|| "总部管理".equals(menu.getType())) {
						menus.add(menu);
					}
				} else if (menutype == 2) {
					if ("分厂查询".equals(menu.getType())) {
						menus.add(menu);
					}
				} else {
					menus.add(menu);
				}
			}
			ComparatorMenu comparatorMenu = new ComparatorMenu();
			
			 HashSet h = new HashSet(menus); 
			 menus.clear(); 
			 menus.addAll(h);
			 
			Collections.sort(menus, comparatorMenu);
			menuTreeNode = new TreeNodeImpl();
			if (menus.size() > 0) {
				addNodes(Integer.valueOf(menus.get(0).getLocation()), menus,
						menuTreeNode);
			}
			menus.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuTreeNode;
	}

	public void addNodes(int counter, List<Menus> menus, TreeNode menuTreeNode) {
		String lastLocation = menus.get((menus.size() - 1)).getLocation();
		String[] lastLocationArray = lastLocation.split("\\.");
		int length = Integer.valueOf(lastLocationArray[0]);
		for (int i = counter; i <= length; i++) {
			for (int t = 0; t < menus.size(); t++) {
				Menus menu = menus.get(t);
				String location = menu.getLocation();
				TreeNodeImpl nodeImpl = new TreeNodeImpl();
				if (location.equals(String.valueOf(i))) {
					nodeImpl.setData(menu);
					menuTreeNode.addChild(menu.getMenuid(), nodeImpl);
				}
				
				for (int j = t + 1; j < menus.size(); j++) {
					Menus m = menus.get(j);
					String[] locationArray = m.getLocation().split("\\.");
					if (locationArray[0].equals(location)) {
						TreeNodeImpl subnode = new TreeNodeImpl();
						subnode.setData(m);
						nodeImpl.addChild(m.getMenuid(), subnode);
					}
				}
			}

		}

	}

	public void setMenuTreeNode(TreeNode<String> menuTreeNode) {
		this.menuTreeNode = menuTreeNode;
	}

	

	
	// 菜单管理Begin
	private int menuid;
	private String location;
	private String name;
	private String filename;
	private String type;
	private String delDataIDStr;
	public DataModel listDataModel = new ListDataModel();

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public DataModel getListDataModel() {
		List<Menus> wraplistMenus = this.serviceLocator.getMenuService()
				.queryAllMenus();
		listDataModel.setWrappedData(wraplistMenus);
		return listDataModel;
	}

	public void setListDataModel(DataModel listDataModel) {
		this.listDataModel = listDataModel;
	}

	public String addMenuAction() {
		location = "";
		name = "";
		filename = "";
		type = "";
		return NavigationResults.ADDMENUACTION;
	}

	public String addMenuSuccessAction() {
		Menus menus = new Menus();
		if ((location == null) || (location.equals("")) || (name == null) || (name.equals(""))) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("addmenu");
			
			FacesUtils.addErrorMessage(prompt);
			return null;			
		} else {
			menus.setLocation(location);
			menus.setName(name);
			menus.setFilename(filename);
			menus.setType(type);
			this.serviceLocator.getMenuService().saveMenu(menus);
			return NavigationResults.ADDMENUSUCCESSACTION;
		}
	}

	public void deleteByIDs() {
		String temp = this.getDelDataIDStr();
		String[] ids = temp.split("@");
		this.serviceLocator.getRoleService().deleteRoleMenuByMenuIds(ids);
		this.serviceLocator.getMenuService().deleteMenusByIds(ids);
	}

	public String editMenuAction() {
		String menuId = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("menuId");
		try {
			Menus menu = this.serviceLocator.getMenuService().getMenusByMenuId(
					Integer.valueOf(menuId));
			menuid = menu.getMenuid();
			location = menu.getLocation();
			name = menu.getName();
			filename = menu.getFilename();
			type = menu.getType();
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (WaterException e) {

			e.printStackTrace();
		}
		return NavigationResults.EDITMENUACTION;
	}

	public String editMenuSucceddAction() {
		try {
			Menus menu = this.serviceLocator.getMenuService().getMenusByMenuId(
					Integer.valueOf(menuid));
			menu.setLocation(location);
			menu.setName(name);
			menu.setFilename(filename);
			menu.setType(type);
			this.serviceLocator.getMenuService().saveMenu(menu);
		} catch (WaterException e) {

			e.printStackTrace();
		}
		return NavigationResults.EDITMENUSUCCESSACTION;
	}

	// 菜单管理End

}
