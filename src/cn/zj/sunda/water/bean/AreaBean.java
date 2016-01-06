package cn.zj.sunda.water.bean;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import cn.zj.sunda.water.bo.Administrator;
import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.util.FacesUtils;

public class AreaBean extends BaseBean {
	private Integer areaId;
	private Integer superiorArea;
	private String name;
	private Double coordinateX;
	private Double coordinateY;
	public Double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}

	private String intro;
	private String principal;
	private String tel;

	private String name_edit;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getSuperiorArea() {
		return superiorArea;
	}

	public void setSuperiorArea(Integer superiorArea) {
		this.superiorArea = superiorArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName_edit() {
		return name_edit;
	}

	public void setName_edit(String nameEdit) {
		name_edit = nameEdit;
	}

	private String delDataIDStr;

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public DataModel wraplistDataModel = new ListDataModel();

	public DataModel getWraplistDataModel() {

		List<Area> list = this.serviceLocator.getAreaService().queryAllArea();
		wraplistDataModel.setWrappedData(list);
		return wraplistDataModel;
	}

	public void setWraplistDataModel(DataModel wraplistDataModel) {
		this.wraplistDataModel = wraplistDataModel;
	}

	private SelectItem[] areaItem;
	private String areaSelectIndex;
	private String areaSelectName;

	public String getAreaSelectName() {
		return areaSelectName;
	}

	public void setAreaSelectName(String areaSelectName) {
		this.areaSelectName = areaSelectName;
	}

	public String getAreaSelectIndex() {
		return areaSelectIndex;
	}

	public void setAreaSelectIndex(String areaSelectIndex) {
		this.areaSelectIndex = areaSelectIndex;
	}

	public SelectItem[] getAreaItem() {
		List<Area> list = this.serviceLocator.getAreaService().queryAllArea();
		areaItem = new SelectItem[list.size() + 1];
		areaItem[0] = new SelectItem(0, "请选择区县");
		for (int i = 1; i <= list.size(); i++) {
			areaItem[i] = new SelectItem(i, list.get(i-1).getName());
		}

		return areaItem;
	}

	public void setAreaItem(SelectItem[] areaItem) {
		this.areaItem = areaItem;
	}

	public void valuechange_area() {
		this.areaSelectName = areaItem[Integer.valueOf(this.areaSelectIndex)]
				.getLabel();
		//System.out.println(areaSelectName);
	}

	public String areaAddAction() {
		areaId = 0;
		superiorArea = 0;
		name = "";
		intro = "";
		principal = "";
		tel = "";
		return NavigationResults.AREAADDACTION;
	}

	public String areaAddSuccessAction() {
		Area area = new Area();
		if ((areaSelectName == null) || (areaSelectName.equals(""))) {
			//superiorArea = 0;
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("selectSuperArea");
			
			FacesUtils.addErrorMessage(prompt);
			return null;
		} else {
			String condition = "name ='" + this.areaSelectName + "'";
			superiorArea = this.serviceLocator.getAreaService()
					.queryAreaByCondition(condition).get(0).getAreaId();
		
			area.setSuperiorArea(superiorArea);
			area.setName(name);
			area.setIntro(intro);
			area.setPrincipal(principal);
			area.setTel(tel);
			area.setCoordinateX(coordinateX);
			area.setCoordinateY(coordinateY);
			this.serviceLocator.getAreaService().saveArea(area);
			return NavigationResults.AREAADDSUCCESSACTION;
		}
	}

	public String areaEditAction() {
		String areaId_s = FacesUtils.getRequestParameter("areaId");

		Area area = this.serviceLocator.getAreaService().queryAreaById(
				Integer.parseInt(areaId_s));
		areaId = area.getAreaId();
		superiorArea = area.getSuperiorArea();
		if (superiorArea == 0) {
			name_edit = "";
		} else {
			//name_edit = this.serviceLocator.getAreaService().queryAreaById(
			//		superiorArea).getName();
			name_edit = "无锡";
		}
		name = area.getName();
		intro = area.getIntro();
		principal = area.getPrincipal();
		tel = area.getTel();
		coordinateX=area.getCoordinateX();
		coordinateY=area.getCoordinateY();
		return NavigationResults.AREAEDITACTION;
	}

	public String areaEditSuccessAction() {
		Area area = this.serviceLocator.getAreaService().queryAreaById(areaId);
		if (areaSelectName == null) {
			area.setSuperiorArea(superiorArea);
		} else {
			String condition = "name ='" + this.areaSelectName + "'";
			superiorArea = this.serviceLocator.getAreaService()
					.queryAreaByCondition(condition).get(0).getAreaId();
			area.setSuperiorArea(superiorArea);
		}
		area.setName(name);
		area.setIntro(intro);
		area.setTel(tel);
		area.setPrincipal(principal);
		area.setCoordinateX(coordinateX);
		area.setCoordinateY(coordinateY);
		this.serviceLocator.getAreaService().saveArea(area);
		return NavigationResults.AREAEDITSUCCESSACTION;
	}

	public void deleteByIDs() {
		String temp = getDelDataIDStr();
		String[] ids = temp.split("@");
		this.serviceLocator.getAreaService().deleteAreaByIds(ids);
	}
	
	//管理员配置=================================================
	
	private String delDataIDStr_admin;

	public String getDelDataIDStr_admin() {
		return delDataIDStr_admin;
	}

	public void setDelDataIDStr_admin(String delDataIDStr_admin) {
		this.delDataIDStr_admin = delDataIDStr_admin;
	}
	public DataModel wraplistDataModel_admin = new ListDataModel();
	public DataModel getWraplistDataModel_admin() {
		
		List<Administrator> list = this.serviceLocator.getAdminService().queryAllAdministrator();
		wraplistDataModel_admin.setWrappedData(list);
		return wraplistDataModel_admin;
	}
	public void setWraplistDataModel_admin(DataModel wraplistDataModel) {
		this.wraplistDataModel_admin = wraplistDataModel;
	}
	
	public void deleteByIDs_admin() {
		String temp = getDelDataIDStr_admin();
		String[] ids = temp.split("@");
		this.serviceLocator.getAdminService().deleteAdministratorByIds(ids);
	}
	
	private Integer administratorId;
	private Area area_admin;
	private String name_admin;
	private String tel_admin;
	private String adr_admin;
	private String email_admin;

	public Integer getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	public Area getArea_admin() {
		return area_admin;
	}

	public void setArea_admin(Area areaAdmin) {
		area_admin = areaAdmin;
	}

	public String getName_admin() {
		return name_admin;
	}

	public void setName_admin(String nameAdmin) {
		name_admin = nameAdmin;
	}

	public String getTel_admin() {
		return tel_admin;
	}

	public void setTel_admin(String telAdmin) {
		tel_admin = telAdmin;
	}

	public String getAdr_admin() {
		return adr_admin;
	}

	public void setAdr_admin(String adrAdmin) {
		adr_admin = adrAdmin;
	}

	public String getEmail_admin() {
		return email_admin;
	}
	private String name_edit_admin;
	
	public String getName_edit_admin() {
		return name_edit_admin;
	}

	public void setName_edit_admin(String nameEditAdmin) {
		name_edit_admin = nameEditAdmin;
	}

	public void setEmail_admin(String emailAdmin) {
		email_admin = emailAdmin;
	}
	
	public String adminAddAction()
	{
		area_admin = null;
		name_admin="";
		tel_admin="";
		adr_admin="";
		email_admin="";
		return NavigationResults.ADMINADDACTION;
	}
	
	public String adminAddSuccessAction()
	{
		if (areaSelectName == null) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("selectArea");
			
			FacesUtils.addErrorMessage(prompt);
			return null;			
		} else {
			Administrator admin = new Administrator();
			String condition = " name ='"+this.areaSelectName+"'";
			area_admin = this.serviceLocator.getAreaService().queryAreaByCondition(condition).get(0);
			admin.setAdr(adr_admin);
			admin.setArea(area_admin);
			admin.setEmail(email_admin);
			admin.setName(name_admin);
			admin.setTel(tel_admin);
			this.serviceLocator.getAdminService().saveAdministrator(admin);
			return NavigationResults.ADMINADDSUCCESSACTION;
		}
	}
	
	public String adminEditAction()
	{
		administratorId = Integer.parseInt(FacesUtils.getRequestParameter("adminId"));
		Administrator admin =this.serviceLocator.getAdminService().queryAdministratorById(administratorId);
		area_admin = admin.getArea();
		areaSelectName =area_admin.getName();
		name_admin=admin.getName();
		tel_admin=admin.getTel();
		adr_admin=admin.getAdr();
		email_admin=admin.getEmail();
		return NavigationResults.ADMINEDITACTION;
	}
	
	public String adminEditSuccessAction()
	{
		Administrator admin =this.serviceLocator.getAdminService().queryAdministratorById(administratorId);
		String condition = " name ='"+this.areaSelectName+"'";
		area_admin = this.serviceLocator.getAreaService().queryAreaByCondition(condition).get(0);
		admin.setAdr(adr_admin);
		admin.setArea(area_admin);
		admin.setEmail(email_admin);
		admin.setName(name_admin);
		admin.setTel(tel_admin);
		this.serviceLocator.getAdminService().saveAdministrator(admin);
		return NavigationResults.ADMINEDITSUCCESSACTION;
	}

}
