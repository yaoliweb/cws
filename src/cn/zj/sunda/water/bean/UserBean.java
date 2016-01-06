package cn.zj.sunda.water.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import cn.zj.sunda.water.bo.Csusers;
import cn.zj.sunda.water.bo.Rolemenu;
import cn.zj.sunda.water.bo.Roles;
import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.Userrole;
import cn.zj.sunda.water.bo.statistics;
import cn.zj.sunda.water.util.CipherUtil;
import cn.zj.sunda.water.util.FacesUtils;

public class UserBean extends BaseBean {
	// the username of the current user
	private String username;
	// the password of the current user
	private String cname;
	private String password;

	private String validateCode;

	private Integer roleid;
	static public Integer idOfRole;
	private String dept;

	private String tel;

	public static Csusers user;
	public static Integer userid;

	public List<Csusers> wraplistUser = null;

	private DataModel listDataModel = new ListDataModel();

	private String delDataIDStr;

	private String selectroleIDStr;
	private String roleName;
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCname1() {
		return cname1;
	}

	public void setCname1(String cname1) {
		this.cname1 = cname1;
	}

	public String getDept1() {
		return dept1;
	}

	public void setDept1(String dept1) {
		this.dept1 = dept1;
	}
	private String cname1;
	private String dept1;
	public  Set<Rolemenu> roleMenuSet = new HashSet<Rolemenu>();

	public String getSelectroleIDStr() {
		return selectroleIDStr;
	}

	public void setSelectroleIDStr(String selectroleIDStr) {
		this.selectroleIDStr = selectroleIDStr;
	}

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public List<Csusers> getWraplistUser() {
		return wraplistUser;
	}

	public void setWraplistUser(List<Csusers> wraplistUser) {
		this.wraplistUser = wraplistUser;
	}

	public DataModel getListDataModel() {
		wraplistUser = this.serviceLocator.getUserService().queryAllUsers();
		listDataModel.setWrappedData(wraplistUser);
		return listDataModel;
	}

	public void setListDataModel(DataModel listDataModel) {
		this.listDataModel = listDataModel;
	}
	
	private DataModel listDataModel_Userrole = new ListDataModel();
	public List<Userrole> wraplistUserrole = new ArrayList <Userrole>();   //新建一个list，必须的方式
	public DataModel getListDataModel_Userrole() {
		wraplistUserrole.clear();
		wraplistUser = this.serviceLocator.getUserService().queryAllUsers();
		for(int i=0;i<wraplistUser.size();i++){
			Csusers User=wraplistUser.get(i);
			 int Userid=User.getUserid();
			 Userrole userrole=(Userrole)(this.serviceLocator.getRoleService().getUserRoleByUserId(Userid).get(0));
			 wraplistUserrole.add(userrole);		
		}
	    listDataModel_Userrole.setWrappedData(wraplistUserrole);
	    return listDataModel_Userrole;		
	}
	public void setListDataModel_Userrole(DataModel listDataModel_Userrole) {
	this.listDataModel_Userrole=listDataModel_Userrole;
	}

	public Csusers getUser() {
		return user;
	}

	public void setUser(Csusers user1) {
		user = user1;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid1) {
		userid = userid1;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	public int orgNum;
	public String orgname;
	public String orgCameraName;

	public String getOrgCameraName() {
		return orgCameraName;
	}

	public void setOrgCameraName(String orgCameraName) {
		this.orgCameraName = orgCameraName;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public int getOrgNum() {
		return orgNum;
	}

	public void setOrgNum(int orgNum) {
		this.orgNum = orgNum;
	}

	public String loginAction() {
		try {
			/*总部用，分厂删除*/
			//CustomerContextHolder.setCustomerType(DataSourceMap.admin);
			/*总部用，分厂删除*/
			HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(true));
			String key = (String) (session.getAttribute("verifyCode"));
			if (!key.equals(validateCode.toUpperCase())) {
				FacesUtils.addErrorMessage("验证码错误");
				return NavigationResults.RETRY;
			} else {
				user = this.serviceLocator.getUserService().login(this.username,
						this.password);
				if (user != null) {
					cname = user.getName();
					dept = user.getDept();
					userid = user.getUserid();
                    tel=user.getTel();
					Set<Userrole> userroles = user.getUserroles();
					Set<Rolemenu> roleMenus = null;
					Iterator it = userroles.iterator();
					List<Roles> roleList = new ArrayList();
					while (it.hasNext()) {
						Userrole userRole = (Userrole) it.next();
						Roles role = userRole.getRoles();
						roleList.add(role);
						this.idOfRole=role.getRoleid();
					}

					for (int i = 0; i < roleList.size(); i++) {
						roleMenuSet = roleList.get(i).getRolemenus();
					}
					session.setAttribute("roleMenu", roleMenuSet);
					session.setAttribute("user", username);
					session.setAttribute("userid",userid);
					session.setAttribute("tel",tel);
					MenuBean.menutype = 0;
					List<Sewage> allsewage = this.serviceLocator.getSewageService().queryAllSewage();
					session.setAttribute("allsewage", allsewage);
					Calendar c = Calendar.getInstance();
					String year=String.valueOf(c.get(Calendar.YEAR));
					String month=String.valueOf(c.get(Calendar.MONTH)+1);
					String day=String.valueOf(c.get(Calendar.DAY_OF_MONTH));
					session.setAttribute("serviceLocator",this.serviceLocator);
					List<Sewage> listsewage=this.serviceLocator.getSewageService().queryAllSewage();
					session.setAttribute("listsewage", listsewage);
					//List<statistics> statistics = this.serviceLocator.getStatisticsService().queryAllByDay(year, month, day);;
					//session.setAttribute("statistics", statistics);

				} else {
					String msg = "密码错误";
					FacesUtils.addErrorMessage(msg + ", 请重新输入.");
					return NavigationResults.RETRY;
				}
			}
		} catch (IllegalStateException ee) {
			
		}
		cname1=this.getCname();
		dept1=this.getDept();
		return NavigationResults.SUCCESS;
	}

	public void logoutAction() {
		//this.logger.debug("Logout successfully.");
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false));
		session.invalidate();
		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestContextPath();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(
					path + "/login.faces");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String newUsername) {
		this.username = newUsername;
	}

	public String getPassword() {
		return CipherUtil.generatePassword(this.password);
	}

	public void setPassword(String newPassword) {
		this.password = newPassword;
	}


	public String getDummyVariable() {
		return null;
	}

	public void clear() {
		this.username = null;
		this.password = null;
		this.validateCode = null;
	}

	public String addUserAction() {
		this.username = "";
		this.cname = "";
		this.dept = "";
		this.tel = "";
		return NavigationResults.ADDUSERACTION;
	}
	
//此部分添加代码是为了将“添加用户|修改用户”的“授予权限”的功能改为下拉框形式（之前是复选框形式）
	private SelectItem[] roleItem;
	private String roleSelectIndex;
	private String roleSelectName;
	
	public String getRoleSelectName() {
		return roleSelectName;
	}

	public void setRoleSelectName(String roleSelectName) {
		this.roleSelectName = roleSelectName;
	}

	public String getRoleSelectIndex() {
		return roleSelectIndex;
	}

	public void setRoleSelectIndex(String roleSelectIndex) {
		this.roleSelectIndex = roleSelectIndex;
	}
	
	public SelectItem[] getRoleItem() {
		List<Roles> list = this.serviceLocator.getRoleService().queryAllRoles();
		roleItem = new SelectItem[list.size() + 1];
		roleItem[0] = new SelectItem(0, "请选择角色");
		for (int i = 1; i <= list.size(); i++) {
			roleItem[i] = new SelectItem(i, list.get(i-1).getName());
		}

		return roleItem;
	}

	public void setRoleItem(SelectItem[] roleItem) {
		this.roleItem = roleItem;
	}

	public void valuechange_role() {
		this.roleSelectName = roleItem[Integer.valueOf(this.roleSelectIndex)].getLabel();
		//System.out.println(roleSelectName);
	}
//此部分添加代码是为了将“添加用户|修改用户”的“授予权限”的功能改为下拉框形式（之前是复选框形式）

	public String addUserSuccessAction() {
		if (username == null) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("userNameNull");
			
			FacesUtils.addErrorMessage(prompt);
			return null;			
		} else {
			List<Csusers> userexistNum = this.serviceLocator.getUserService()
					.queryUserByUserLogid(username);//查找数据库中是否已存在输入登录名
			if (userexistNum.size() == 0) {         //如果不存在
				
			//	if ((selectroleIDStr == null)||(selectroleIDStr.equals(""))) {
				if(roleSelectName == null){
					FacesContext context = FacesContext.getCurrentInstance();
			        String bundleName = context.getApplication().getMessageBundle();
			        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
			        String prompt = messageBundle.getString("roleNull");
					
					FacesUtils.addErrorMessage(prompt);
					return null;					
				} else {
					Csusers user = new Csusers();
					user.setLogid(username);
					user.setLogpass(CipherUtil.generatePassword(username));
					user.setName(cname);
					user.setDept(dept);
					user.setTel(tel);
					this.serviceLocator.getUserService().saveUser(user);
		
					String condition = " name ='"+this.roleSelectName+"'";
					Roles r = this.serviceLocator.getRoleService().queryRoleByCondition(condition).get(0);
					Userrole userRole = new Userrole();
					userRole.setRoles(r);
					userRole.setCsusers(user);
					this.serviceLocator.getRoleService().saveUserRole(userRole);
					
/*					String[] selectIds = this.selectroleIDStr.split("@");
					for (int i = 0; i < selectIds.length; i++) {
		
						Roles r = this.serviceLocator.getRoleService().queryRoleById(
								Integer.valueOf(selectIds[i]));
						Userrole userRole = new Userrole();
						userRole.setRoles(r);
						userRole.setCsusers(user);
		
						this.serviceLocator.getRoleService().saveUserRole(userRole);
		
					}
*/
					return NavigationResults.ADDUSERSUCCESSACTION;
				}
			} else {  
				FacesContext context = FacesContext.getCurrentInstance();
		        String bundleName = context.getApplication().getMessageBundle();
		        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
		        String prompt = messageBundle.getString("userExist");
				
				FacesUtils.addErrorMessage(prompt);
				
				this.username = "";
				this.cname = "";
				this.dept = "";
				this.tel = "";
				return null;
			}
		}

	}

	public void deleteByIDs() {
		String temp = this.getDelDataIDStr();
		// System.out.println(temp);
		String[] ids = temp.split("@");
		this.serviceLocator.getRoleService().deleteUserRole(ids);
		this.serviceLocator.getUserService().deleteUserByIds(ids);

	}

	public String editUserAction() {
		String userId = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("userId");
		Csusers user = this.serviceLocator.getUserService().queryUserByUserId(
				Integer.valueOf(userId));
		username = user.getLogid();
		cname = user.getName();
		// password=user.getLogpass();
		dept = user.getDept();
		tel = user.getTel();
		userid = user.getUserid();
		Userrole userrole=this.serviceLocator.getRoleService().getUserRoleByUserId(user.getUserid()).get(0);
		roleid=userrole.getRoles().getRoleid();
		Roles role = this.getServiceLocator().getRoleService().queryRoleById(roleid);
		roleName=role.getName();
		roleSelectName=role.getName();
		return NavigationResults.EDITUSERACTION;

	}

	public String editUserSuccessAction() {
		
//		if ((selectroleIDStr == null)||(selectroleIDStr.equals(""))) {
		if (roleSelectName == null) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("roleNull");
			
			FacesUtils.addErrorMessage(prompt);
			return null;					
		} else {
			Csusers user = this.serviceLocator.getUserService().queryUserByUserId(
					Integer.valueOf(userid));
			user.setLogid(username);
			//user.setLogpass(CipherUtil.generatePassword(username));
			user.setName(cname);
			user.setDept(dept);
			user.setTel(tel);
			this.serviceLocator.getUserService().saveUser(user);
			List<Userrole> userRoleList = this.serviceLocator.getRoleService()
					.getUserRoleByUserId(userid);
			for (int i = 0; i < userRoleList.size(); i++) {
				this.serviceLocator.getRoleService().deleteUserRole(
						userRoleList.get(i));
			}
			
			String condition = " name ='"+this.roleSelectName+"'";
			Roles r = this.serviceLocator.getRoleService().queryRoleByCondition(condition).get(0);
			Userrole userRole = new Userrole();
			userRole.setRoles(r);
			userRole.setCsusers(user);
			this.serviceLocator.getRoleService().saveUserRole(userRole);

/*			
			String[] selectIds = this.selectroleIDStr.split("@");
			for (int i = 0; i < selectIds.length; i++) {
	
				Roles r = this.serviceLocator.getRoleService().queryRoleById(
						Integer.valueOf(selectIds[i]));
				Userrole userRole = new Userrole();
				userRole.setRoles(r);
				userRole.setCsusers(user);
	
				this.serviceLocator.getRoleService().saveUserRole(userRole);
	
			}
*/
			return NavigationResults.EDITUSERSUCCESSACTION;
		}
	}
	public String editUserSuccessAction1(){
		Csusers user = this.serviceLocator.getUserService().queryUserByUserId(
				Integer.valueOf(userid));
		user.setLogid(username);
		//user.setLogpass(CipherUtil.generatePassword(username));
		user.setName(cname);
		user.setDept(dept);
		user.setTel(tel);
		this.serviceLocator.getUserService().saveUser(user);
		FacesUtils.addErrorMessage("基本信息修改成功");
		return NavigationResults.EDITUSERSUCCESSACTION;
	}

	// 个人信息管理--修改密码
	private String oldpassword;
	private String newpassword;
	private String newpasswordagain;

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getNewpasswordagain() {
		return newpasswordagain;
	}

	public void setNewpasswordagain(String newpasswordagain) {
		this.newpasswordagain = newpasswordagain;
	}

	public void changePasswordAction() {
		if (!CipherUtil.validatePassword(user.getLogpass(), oldpassword)) {
			FacesUtils.addErrorMessage("原密码输入不正确,请重新输入");
			oldpassword = "";
		} else if (!newpassword.equals(newpasswordagain)) {
			FacesUtils.addErrorMessage("新密码输入不一致，请重新输入");
			newpassword = "";
			newpasswordagain = "";
		} else {
			FacesUtils.addErrorMessage("修改密码成功");
			user.setLogpass(CipherUtil.generatePassword(newpassword));
			this.serviceLocator.getUserService().saveUser(user);
		}

	}

}
