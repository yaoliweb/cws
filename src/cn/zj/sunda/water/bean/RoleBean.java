package cn.zj.sunda.water.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import org.richfaces.model.TreeNode;

import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.Menus;
import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Roles;
import cn.zj.sunda.water.util.FacesUtils;

public class RoleBean extends BaseBean {

	private int roleid;
	private String name;
	private List<Roles> wraplist;
	private DataModel listDataModel = new ListDataModel();
	private String delDataIDStr;
	private List<Menus> treeCheckedList = new ArrayList();

	public void setTreeCheckedList(List<Menus> treeCheckedList) {
		this.treeCheckedList = treeCheckedList;
	}

	public List<Menus> getTreeCheckedList() {
		Iterator it = MenuBean.menuTreeNode.getChildren();
		treeCheckedList.clear();
		try {
			while (it.hasNext()) {
				TreeNode node = (TreeNode) ((Entry) it.next()).getValue();

				if (node.getData() instanceof Menus) {
					
					Menus m = (Menus) node.getData();
					
					if (m.isSelected()) {
						treeCheckedList.add(m);// 这个是定义了一个存放选中节点对象的容器
					}
					if (!node.isLeaf()) {
						// 递归算法得到下层的节点
						getCheckSubNode(node.getChildren());
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return treeCheckedList;
	}

	private void getCheckSubNode(Iterator it) {
		while (it.hasNext()) {
			TreeNode node = (TreeNode) ((Entry) it.next()).getValue();
			if (node.getData() instanceof Menus) {
				Menus m = (Menus) node.getData();
				if (m.isSelected()) {
					treeCheckedList.add(m);
				}

				if (!node.isLeaf()) {
					getCheckSubNode(node.getChildren());
				}
			}

		}
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public List<Roles> getWraplist() {
		return wraplist;
	}

	public void setWraplist(List<Roles> wraplist) {
		this.wraplist = wraplist;
	}

	public DataModel getListDateModel() {
		wraplist = this.serviceLocator.getRoleService().queryAllRoles();
		listDataModel.setWrappedData(wraplist);
		return listDataModel;
	}

	public void setListDateModel(DataModel listDataModel) {
		this.listDataModel = listDataModel;
	}
	
	public void deleteByIDs() {

		String temp = this.getDelDataIDStr();
		//System.out.println(temp);
		String[] ids = temp.split("@");
		this.serviceLocator.getRoleService().deleteRoleMenuByRoleIds(ids);
		this.serviceLocator.getRoleService().deleteRoleByIds(ids);

	}

	public String addRoleAction() {
		this.name = "";
		return NavigationResults.ADDROLEACTION;
	}

	public String addRoleSuccessAction() {
		Roles role = new Roles();
		if ((name == null) || (name.equals(""))) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("addrole");
			
			FacesUtils.addErrorMessage(prompt);
			return null;			
		} else {
			role.setName(name);
			this.serviceLocator.getRoleService().saveRole(role);
			getTreeCheckedList();
			//System.out.println("treeCheckedList"+treeCheckedList.size());
			
			for (int i = 0; i < treeCheckedList.size(); i++) {
				//System.out.println(treeCheckedList.get(i).getName());
				Rolemenu roleMenu = new Rolemenu();
				roleMenu.setRoles(role);
				roleMenu.setMenus(treeCheckedList.get(i));
				this.serviceLocator.getRoleService().saveRoleMenu(roleMenu);
			}
	
			return NavigationResults.ADDROLESUCCESSACTION;
		}
	}

	public String editRoleAction() {
		String roleId = (String) FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("roleId");
		//System.out.println(roleId);
		Roles role = this.serviceLocator.getRoleService().queryRoleById(
				Integer.valueOf(roleId));
		name = role.getName();
		roleid = role.getRoleid();
		return NavigationResults.EDITROLEACTION;
	}

	public String editRoleSuccessAction() {
		Roles role = this.serviceLocator.getRoleService().queryRoleById(roleid);
		
		role.setName(name);
		this.serviceLocator.getRoleService().saveRole(role);
		String[] roleids = new String[1];
		roleids[0] =String.valueOf(roleid);
		this.serviceLocator.getRoleService().deleteRoleMenuByRoleIds(roleids);
		getTreeCheckedList();
		for (int i = 0; i < treeCheckedList.size(); i++) {
			//System.out.println(treeCheckedList.get(i).getName());
			
			Rolemenu roleMenu = new Rolemenu();
			roleMenu.setRoles(role);
			roleMenu.setMenus(treeCheckedList.get(i));
			this.serviceLocator.getRoleService().saveRoleMenu(roleMenu);
		}
		for (int i = 0; i < treeCheckedList.size(); i++) {
			//System.out.println(treeCheckedList.get(i).getName());
			treeCheckedList.get(i).setSelected(false);
		}

		return NavigationResults.EDITROLESUCCESSACTION;
	}

}