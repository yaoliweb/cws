package cn.zj.sunda.water.bean;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import cn.zj.sunda.water.bo.Sysparam;
import cn.zj.sunda.water.util.FacesUtils;

public class SysparamBean extends BaseBean {

	private String delDataIDStr;

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public DataModel wraplistDataModel = new ListDataModel();

	public DataModel getWraplistDataModel() {

		List<Sysparam> list = this.serviceLocator.getSysparamService()
				.queryAllSysparam();
		wraplistDataModel.setWrappedData(list);
		return wraplistDataModel;
	}

	public void setWraplistDataModel(DataModel wraplistDataModel) {
		this.wraplistDataModel = wraplistDataModel;
	}

	private Integer id;
	private String name;
	private String cname;
	private String note;
	private String value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String sysparamAddAction() {
		name = "";
		cname = "";
		note = "";
		value = "";
		return NavigationResults.SYSPARAMADDACTION;
	}

	public String sysparamAddSuccessAction() {
		Sysparam sysparam = new Sysparam();
		sysparam.setCname(cname);
		sysparam.setName(name);
		sysparam.setNote(note);
		sysparam.setValue(value);
		this.serviceLocator.getSysparamService().savaSysparam(sysparam);
		return NavigationResults.SYSPARAMADDSUCCESSACTION;
	}

	public String sysparamEditAction() {
		Sysparam sysparam = this.serviceLocator.getSysparamService()
				.querySysparamById(
						Integer.parseInt(FacesUtils
								.getRequestParameter("sysparamId")));
		id = sysparam.getId();
		name = sysparam.getName();
		cname = sysparam.getCname();
		note = sysparam.getNote();
		value = sysparam.getValue();
		return NavigationResults.SYSPARAMEDITACTION;
	}

	public String sysparamEditSuccessAction() {
		Sysparam sysparam = this.serviceLocator.getSysparamService()
		.querySysparamById(id);
		sysparam.setCname(cname);
		sysparam.setName(name);
		sysparam.setNote(note);
		sysparam.setValue(value);
		this.serviceLocator.getSysparamService().savaSysparam(sysparam);
		return NavigationResults.SYSPARAMEDITSUCCESSACTION;
	}
	public void deleteByIDs() {
		String temp = getDelDataIDStr();
		String[] ids = temp.split("@");
		this.serviceLocator.getSysparamService().deleteSysparamByIds(ids);
	}
}
