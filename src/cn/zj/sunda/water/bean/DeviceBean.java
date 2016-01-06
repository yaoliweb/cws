package cn.zj.sunda.water.bean;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.Bug;
import cn.zj.sunda.water.bo.DeviceDoc;
import cn.zj.sunda.water.bo.EquipRepairRecord;
import cn.zj.sunda.water.bo.Sewage;

public class DeviceBean extends BaseBean {
	private int Number;
	private int newNumber;
	private long DeviceDocID;
	private long newDeviceDocID;
	private String DeviceName;
	private String newDeviceName;
	private String DeviceType;
	private String newDeviceType;
	private Date SetupTime=new java.util.Date();
	private Date newSetupTime=new java.util.Date();
	private Date LastRepairTime=new java.util.Date();
	private Date newLastRepairTime=new java.util.Date();
	private int RepairCycle;
	private int newRepairCycle;
	private int UseTimeLimit;
	private int newUseTimeLimit;
	private int RepairRecord;
	private int newRepairRecord;
	private String SewageName;
	private long  RecordID;
	private long  newRecordID;
	private String SerialNumber;
	private String newSerialNumber;
	private String ProjectSerialNumber;
	private String newProjectSerialNumber;
	private String ProjectName;
	private String newProjectName;
	private String Site;
	private String newSite;
	private Date Time=new java.util.Date();
	private Date newTime=new java.util.Date();
	private String ConsumeTime;
	private String newConsumeTime;
	private String RepairReason;
	private String newRepairReason;
	private String RepairContent;
	private String newRepairContent;
	private String ConsumeMaterial;
	private String newConsumeMaterial;
	private String FeedBack;
	private String newFeedBack;
	private String RepairMan;
	private String newRepairMan;
	private String  ProprietorConfirm;
	private String  newProprietorConfirm;
	private String DirectorName;
	private String newDirectorName;
	private Date CompleteTime=new java.util.Date();
	public Date getSetupTime() {
		return SetupTime;
	}

	public String getSewageName() {
		return SewageName;
	}

	public void setSewageName(String sewageName) {
		SewageName = sewageName;
	}

	public int getUseTimeLimit() {
		return UseTimeLimit;
	}

	public void setUseTimeLimit(int useTimeLimit) {
		UseTimeLimit = useTimeLimit;
	}

	public void setSetupTime(Date setupTime) {
		SetupTime = setupTime;
	}

	public int getRepairCycle() {
		return RepairCycle;
	}

	public void setRepairCycle(int repairCycle) {
		RepairCycle = repairCycle;
	}

	public int getRepairRecord() {
		return RepairRecord;
	}

	public void setRepairRecord(int repairRecord) {
		RepairRecord = repairRecord;
	}

	public String getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}

	public String getSite() {
		return Site;
	}

	public void setSite(String site) {
		Site = site;
	}

	public Date getTime() {
		return Time;
	}

	public void setTime(Date time) {
		Time = time;
	}

	public String getRepairReason() {
		return RepairReason;
	}

	public void setRepairReason(String repairReason) {
		RepairReason = repairReason;
	}

	public String getRepairMan() {
		return RepairMan;
	}

	public void setRepairMan(String repairMan) {
		RepairMan = repairMan;
	}

	public int getNumber() {
		return Number;
	}

	public void setNumber(int number) {
		Number = number;
	}

	public int getNewUseTimeLimit() {
		return newUseTimeLimit;
	}

	public void setNewUseTimeLimit(int newUseTimeLimit) {
		this.newUseTimeLimit = newUseTimeLimit;
	}

	public long getRecordID() {
		return RecordID;
	}

	public void setRecordID(long recordID) {
		RecordID = recordID;
	}

	public String getProjectSerialNumber() {
		return ProjectSerialNumber;
	}

	public void setProjectSerialNumber(String projectSerialNumber) {
		ProjectSerialNumber = projectSerialNumber;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getNewSite() {
		return newSite;
	}

	public void setNewSite(String newSite) {
		this.newSite = newSite;
	}

	public Date getNewTime() {
		return newTime;
	}

	public void setNewTime(Date newTime) {
		this.newTime = newTime;
	}

	public String getRepairContent() {
		return RepairContent;
	}

	public void setRepairContent(String repairContent) {
		RepairContent = repairContent;
	}

	public String getProprietorConfirm() {
		return ProprietorConfirm;
	}

	public void setProprietorConfirm(String proprietorConfirm) {
		ProprietorConfirm = proprietorConfirm;
	}
	private Date newCompleteTime=new java.util.Date();
	private SelectItem[] newAreaItem;

	private SelectItem[] newSewageItem;

	private String newAreaSelectIndex;
	private String newSewageSelectIndex;
	
	private String newAreaSelectName;
	private String newSewageSelectName;
	
	public int getNewNumber() {
		return newNumber;
	}

	public void setNewNumber(int newNumber) {
		this.newNumber = newNumber;
	}

	public long getDeviceDocID() {
		return DeviceDocID;
	}

	public void setDeviceDocID(long deviceDocID) {
		DeviceDocID = deviceDocID;
	}

	public long getNewDeviceDocID() {
		return newDeviceDocID;
	}

	public void setNewDeviceDocID(long newDeviceDocID) {
		this.newDeviceDocID = newDeviceDocID;
	}

	public String getDeviceName() {
		return DeviceName;
	}

	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}

	public String getNewDeviceName() {
		return newDeviceName;
	}

	public void setNewDeviceName(String newDeviceName) {
		this.newDeviceName = newDeviceName;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getNewDeviceType() {
		return newDeviceType;
	}

	public void setNewDeviceType(String newDeviceType) {
		this.newDeviceType = newDeviceType;
	}

	public Date getNewSetupTime() {
		return newSetupTime;
	}

	public void setNewSetupTime(Date newSetupTime) {
		this.newSetupTime = newSetupTime;
	}

	public Date getLastRepairTime() {
		return LastRepairTime;
	}

	public void setLastRepairTime(Date lastRepairTime) {
		LastRepairTime = lastRepairTime;
	}

	public Date getNewLastRepairTime() {
		return newLastRepairTime;
	}

	public void setNewLastRepairTime(Date newLastRepairTime) {
		this.newLastRepairTime = newLastRepairTime;
	}

	public int getNewRepairCycle() {
		return newRepairCycle;
	}

	public void setNewRepairCycle(int newRepairCycle) {
		this.newRepairCycle = newRepairCycle;
	}

	public int getNewRepairRecord() {
		return newRepairRecord;
	}

	public void setNewRepairRecord(int newRepairRecord) {
		this.newRepairRecord = newRepairRecord;
	}

	public long getNewRecordID() {
		return newRecordID;
	}

	public void setNewRecordID(long newRecordID) {
		this.newRecordID = newRecordID;
	}

	public String getNewSerialNumber() {
		return newSerialNumber;
	}

	public void setNewSerialNumber(String newSerialNumber) {
		this.newSerialNumber = newSerialNumber;
	}

	public String getNewProjectSerialNumber() {
		return newProjectSerialNumber;
	}

	public void setNewProjectSerialNumber(String newProjectSerialNumber) {
		this.newProjectSerialNumber = newProjectSerialNumber;
	}

	public String getNewProjectName() {
		return newProjectName;
	}

	public void setNewProjectName(String newProjectName) {
		this.newProjectName = newProjectName;
	}

	public String getConsumeTime() {
		return ConsumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		ConsumeTime = consumeTime;
	}

	public String getNewConsumeTime() {
		return newConsumeTime;
	}

	public void setNewConsumeTime(String newConsumeTime) {
		this.newConsumeTime = newConsumeTime;
	}

	public String getNewRepairReason() {
		return newRepairReason;
	}

	public void setNewRepairReason(String newRepairReason) {
		this.newRepairReason = newRepairReason;
	}

	public String getNewRepairContent() {
		return newRepairContent;
	}

	public void setNewRepairContent(String newRepairContent) {
		this.newRepairContent = newRepairContent;
	}

	public String getConsumeMaterial() {
		return ConsumeMaterial;
	}

	public void setConsumeMaterial(String consumeMaterial) {
		ConsumeMaterial = consumeMaterial;
	}

	public String getNewConsumeMaterial() {
		return newConsumeMaterial;
	}

	public void setNewConsumeMaterial(String newConsumeMaterial) {
		this.newConsumeMaterial = newConsumeMaterial;
	}

	public String getFeedBack() {
		return FeedBack;
	}

	public void setFeedBack(String feedBack) {
		FeedBack = feedBack;
	}

	public String getNewFeedBack() {
		return newFeedBack;
	}

	public void setNewFeedBack(String newFeedBack) {
		this.newFeedBack = newFeedBack;
	}

	public String getNewRepairMan() {
		return newRepairMan;
	}

	public void setNewRepairMan(String newRepairMan) {
		this.newRepairMan = newRepairMan;
	}

	public String getNewProprietorConfirm() {
		return newProprietorConfirm;
	}

	public void setNewProprietorConfirm(String newProprietorConfirm) {
		this.newProprietorConfirm = newProprietorConfirm;
	}

	public String getDirectorName() {
		return DirectorName;
	}

	public void setDirectorName(String directorName) {
		DirectorName = directorName;
	}

	public String getNewDirectorName() {
		return newDirectorName;
	}

	public void setNewDirectorName(String newDirectorName) {
		this.newDirectorName = newDirectorName;
	}

	public Date getCompleteTime() {
		return CompleteTime;
	}

	public void setCompleteTime(Date completeTime) {
		CompleteTime = completeTime;
	}

	public Date getNewCompleteTime() {
		return newCompleteTime;
	}

	public void setNewCompleteTime(Date newCompleteTime) {
		this.newCompleteTime = newCompleteTime;
	}

	public String getnewAreaSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String areaSessionSelectIndex = (String)session.getAttribute("newAreaSelectIndex");
		String sewageRequestId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");

		//System.out.println("areaSessionSelectIndex:" + areaSessionSelectIndex);
		//System.out.println("sewageRequestId:" + sewageRequestId);	
		
		if (sewageRequestId != null) {
			Sewage sewageFromRequest = this.serviceLocator.getSewageService()
				.querySewageById(Integer.parseInt(sewageRequestId));
			newAreaSelectName = sewageFromRequest.getArea().getName();
			for (int i = 1; i <= newAreaItem.length; i++) {
				if (newAreaItem[i].getLabel().equals(newAreaSelectName)) {
					newAreaSelectIndex = String.valueOf(i);
					session.setAttribute("newAreaSelectIndex", newAreaSelectIndex);
					break;
				} 						
			}
			return newAreaSelectIndex;		
		}
		
		if (areaSessionSelectIndex == null) {
			return newAreaSelectIndex;
		} else {
			
			newAreaSelectName = newAreaItem[Integer.valueOf(areaSessionSelectIndex)].getLabel();
			newAreaSelectIndex = areaSessionSelectIndex;
			
			session.setAttribute("newAreaSelectIndex", newAreaSelectIndex);
			session.setAttribute("newAreaSelectName", newAreaSelectName);
			//System.out.println("getnewAreaSelectIndex() -> newAreaSelectName:" + newAreaSelectName);
			return newAreaSelectIndex;
		}
	}
	
	public void setnewAreaSelectIndex(String newAreaSelectIndex) {
		this.newAreaSelectIndex = newAreaSelectIndex;
	}
	
	public String getnewSewageSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("newSewageSelectIndex");
		String sewageRequestId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");
		
		//System.out.println("getnewSewageSelectIndex() -> sewageSessionSelectIndex:" + sewageSessionSelectIndex);
		//System.out.println("sewageRequestId:" + sewageRequestId);

		if (sewageRequestId != null) {
			Sewage sewageFromRequest = this.serviceLocator.getSewageService().querySewageById(Integer.parseInt(sewageRequestId));
			newSewageSelectName = sewageFromRequest.getShortTitle();
			for (int i = 1; i <= newSewageItem.length; i++) {
				if (newSewageItem[i].getLabel().equals(newSewageSelectName)) {
					newSewageSelectIndex = String.valueOf(i);
					session.setAttribute("newSewageSelectIndex", newSewageSelectIndex);
					break;
				} 						
			}
			return newSewageSelectIndex;
		}
		
		if (sewageSessionSelectIndex == null) {
			return newSewageSelectIndex;
		} else {
			getnewSewageItem();

			newSewageSelectName = newSewageItem[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
			newSewageSelectIndex = sewageSessionSelectIndex;

			session.setAttribute("newSewageSelectIndex", newSewageSelectIndex);
			session.setAttribute("newSewageSelectName", newSewageSelectName);
			return newSewageSelectIndex;
		}
	}
	
	public void setnewSewageSelectIndex(String newSewageSelectIndex) {
		this.newSewageSelectIndex = newSewageSelectIndex;
	}
	
	public String getnewAreaSelectName() {
			return newAreaSelectName;
	}
	public void setnewAreaSelectName(String newAreaSelectName) {
		this.newAreaSelectName = newAreaSelectName;
	}
	
	public String getnewSewageSelectName() {
		return newSewageSelectName;
	}
	public void setnewSewageSelectName(String newSewageSelectName) {
		this.newSewageSelectName = newSewageSelectName;
	}
	public SelectItem[] getnewAreaItem() {
		List<Area> list = this.serviceLocator.getAreaService().queryAllArea();
		//System.out.println(list.size());
		newAreaItem = new SelectItem[list.size()+1];
		newAreaItem[0] = new SelectItem(0, "请选择区县");
		for (int i = 1; i <= list.size(); i++) {
			newAreaItem[i] = new SelectItem(i,list.get(i-1).getName());
			//System.out.println("newAreaItem[" + i + "]" + newAreaItem[i].getLabel());
		}
		
		return newAreaItem;
	}
	public void setnewAreaItem(SelectItem[] newAreaItem) {
		this.newAreaItem = newAreaItem;
	}
	public SelectItem[] getnewSewageItem() {
		//System.out.println("getnewSewageItem() -> newAreaSelectName: " + newAreaSelectName);

		String condition = "area.name = '"+this.newAreaSelectName+"'";
		List<Sewage> list = this.serviceLocator.getSewageService().querySewageByCondition(condition);
		newSewageItem = new SelectItem[list.size()+1];
		newSewageItem[0] = new SelectItem(0,"请选择污水站点");
		for (int i = 1; i <= list.size(); i++) {
			newSewageItem[i] = new SelectItem(i,list.get(i-1).getShortTitle());
		}
		return newSewageItem;
	}
	
	public void setnewSewageItem(SelectItem[] newSewageItem) {
		this.newSewageItem = newSewageItem;
	}
	
	public void valuechange_area()
	{
		this.newAreaSelectName = newAreaItem[Integer.valueOf(this.newAreaSelectIndex)].getLabel();
		this.newSewageSelectIndex="-1";
		//System.out.println("valuechange_area() -> newAreaSelectName: " + newAreaSelectName);
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("newSewageSelectIndex", null);
		session.setAttribute("newAreaSelectName", newAreaSelectName);
		session.setAttribute("newAreaSelectIndex", newAreaSelectIndex);
	}	
	public void valuechanged_sewage()
	{
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true));		

		//System.out.println(newSewageSelectName);
		//HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//request.setAttribute("newSewageSelectName", newSewageSelectName);
		
		this.newSewageSelectName = newSewageItem[Integer.valueOf(this.newSewageSelectIndex)].getLabel();
		//System.out.println(newSewageSelectName);
		if(newSewageSelectName!="请选择污水站点")
		{
			session.setAttribute("newSewageSelectName", newSewageSelectName);
			session.setAttribute("newSewageSelectIndex", newSewageSelectIndex);
		
		//DeviceDoc deviceDoc = (DeviceDoc) this.serviceLocator.getDeviceDocService().queryByCondition(newSewageSelectName);
		this.SewageName=newSewageSelectName;
		this.setnewSewageSelectIndex("-1");
	    }
	}
	public DataModel wraplistDataModel_DeviceDoc = new ListDataModel();
	public DataModel getWraplistDataModel_DeviceDoc() {
		List<DeviceDoc> list = new ArrayList<DeviceDoc>();
		String condition = "DeviceDoc.sewageName=''";
		//String sewageid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");
		if(newSewageSelectName != "请选择污水站点")
			condition ="DeviceDoc.sewageName='"+newSewageSelectName+"'";
		list = this.serviceLocator.getDeviceDocService().queryByCondition(condition);
		wraplistDataModel_DeviceDoc.setWrappedData(list);
		//Iterator it;
		//it=list.iterator();
		//while(it.hasNext()){
		//	DeviceDoc d=(DeviceDoc)it.next();
		//System.out.println(d.getDeviceDocID()+"="+d.getDeviceName());
		//}
		return wraplistDataModel_DeviceDoc;
	}

	public void setWraplistDataModel_DeviceDoc(DataModel wraplistDataModel) {
		this.wraplistDataModel_DeviceDoc = wraplistDataModel;
	}
	public String DeviceDocAddSuccessAction(){
		if(newSewageSelectName=="请选择污水站点"){
			return null;
		}
		else{
			DeviceDoc newDeviceDoc=new DeviceDoc();
			newDeviceDoc.setNumber(this.newNumber);
			newDeviceDoc.setDeviceName(this.newDeviceName);
			newDeviceDoc.setDeviceType(this.newDeviceType);
			newDeviceDoc.setLastRepairTime(this.newLastRepairTime);
			newDeviceDoc.setRepairCycle(this.newRepairCycle);
			//newDeviceDoc.setRepairRecord(this.newRepairRecord);
			newDeviceDoc.setSetupTime(this.newSetupTime);
			newDeviceDoc.setSewageName(this.newSewageSelectName);
			newDeviceDoc.setUseTimeLimit(this.newUseTimeLimit);
			String condition="EquipRepairRecord.sewageName='"+newSewageSelectName+"'"+" and "+"EquipRepairRecord.deviceName='"+DeviceName+"'";
			List<EquipRepairRecord> er=this.serviceLocator.getEquipRepairrecordService().queryByCondition(condition);
			newDeviceDoc.setRepairRecord(er.size());
			this.getServiceLocator().getDeviceDocService().saveDeviceDoc(newDeviceDoc);
			return NavigationResults.DEVICEDOCADDSUCCESSACTION;
		}
	}
	public String deviceDocAddAction()
	{
		return NavigationResults.DEVICEDOCADDACTION;
	}
	List<EquipRepairRecord> docs=new ArrayList<EquipRepairRecord>();
	public String str1=null,str2=null;
	public String editDeviceContent(){
		Number=newNumber=Integer.parseInt(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("number"));
		DeviceName=newDeviceName=String.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("devicename"));
		DeviceType=newDeviceType=String.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("devicetype"));
		
		try {
			str1=FacesContext.getCurrentInstance()
			.getExternalContext().getRequestParameterMap().get("setuptime");
			if(str1!=null)
			newSetupTime=DateFormat.getDateInstance().parse(str1);
		} catch (ParseException e) {
			e.printStackTrace();		
		}
		if(str1.length()>=19)
		str1=str1.substring(0, 19);
		try {
			 str2=FacesContext.getCurrentInstance()
			.getExternalContext().getRequestParameterMap().get("lastrepairtime");
			if(str2!=null)
			newLastRepairTime=DateFormat.getDateInstance().parse(str2);
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		if(str2.length()>=19)
		str2=str2.substring(0, 19);
		RepairCycle=newRepairCycle=Integer.parseInt(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("repaircycle"));
		UseTimeLimit=newUseTimeLimit=Integer.parseInt(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("usetimelimit"));
		RepairRecord=newRepairRecord=Integer.parseInt(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("repairrecord"));
		
		return NavigationResults.EDITDEVICEDOC;	
	}
	public String DeviceDocEditSuccessAction(){
		String condition="DeviceDoc.sewageName='"+this.newSewageSelectName+"'"+" and "+"DeviceDoc.number='"+this.Number+"'"
		+" and "+"DeviceDoc.deviceName='"+this.DeviceName+"'"+" and "+"DeviceDoc.lastRepairTime='"+this.str2+"'"
		+" and "+"DeviceDoc.setupTime='"+this.str1+"'"+" and "+"DeviceDoc.deviceType='"+this.DeviceType+"'"
		+" and "+"DeviceDoc.repairCycle='"+this.RepairCycle+"'"+" and "+"DeviceDoc.useTimeLimit='"+this.UseTimeLimit+"'"
		+" and "+"DeviceDoc.repairRecord='"+this.RepairRecord+"'";
		List<DeviceDoc> dd=this.serviceLocator.getDeviceDocService().queryByCondition(condition);
		Iterator it=dd.iterator();
		DeviceDoc device=(DeviceDoc)it.next();
		device.setNumber(newNumber);
		device.setRepairCycle(newRepairCycle);
		this.serviceLocator.getDeviceDocService().updateDeviceDoc(device);
		
		return NavigationResults.DEVICEDOCEDITSUCCESSACTION;	
	}
	public String DeviceDocDelSuccessAction(){
		String condition="DeviceDoc.sewageName='"+this.newSewageSelectName+"'"+" and "+"DeviceDoc.number='"+this.Number+"'"
		+" and "+"DeviceDoc.deviceName='"+this.DeviceName+"'"+" and "+"DeviceDoc.lastRepairTime='"+this.str2+"'"
		+" and "+"DeviceDoc.setupTime='"+this.str1+"'"+" and "+"DeviceDoc.deviceType='"+this.DeviceType+"'"
		+" and "+"DeviceDoc.repairCycle='"+this.RepairCycle+"'"+" and "+"DeviceDoc.useTimeLimit='"+this.UseTimeLimit+"'"
		+" and "+"DeviceDoc.repairRecord='"+this.RepairRecord+"'";
		List<DeviceDoc> dd=this.serviceLocator.getDeviceDocService().queryByCondition(condition);
		Iterator it=dd.iterator();
		DeviceDoc device=(DeviceDoc)it.next();
		this.serviceLocator.getDeviceDocService().deleteDeviceDoc(device);
		
		return NavigationResults.DEVICEDOCDELTSUCCESSACTION;
	}
	public String getDeviceContent(){
		DeviceName=String.valueOf(FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap().get("devicename"));
		if (null == DeviceName) {
			try {
				String path = FacesContext.getCurrentInstance()
						.getExternalContext().getRequestContextPath();
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(path + "/pages/work/devicedoc.faces");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			String condition="EquipRepairRecord.sewageName='"+newSewageSelectName+"'"+" and "+"EquipRepairRecord.deviceName='"+DeviceName+"'";
		    docs = this.serviceLocator.getEquipRepairrecordService().queryByCondition(condition);
		}
		return NavigationResults.REPAIRCONTENT;	
	}
	public DataModel wraplistDataModel_EquipRepairRecord = new ListDataModel();
	public DataModel getWraplistDataModel_EquipRepairRecord() {
		String condition="EquipRepairRecord.sewageName='"+newSewageSelectName+"'"+" and "+"EquipRepairRecord.deviceName='"+DeviceName+"'";
	    docs = this.serviceLocator.getEquipRepairrecordService().queryByCondition(condition);
		wraplistDataModel_EquipRepairRecord.setWrappedData(docs);
		//Iterator it=docs.iterator();
		//EquipRepairRecord e=(EquipRepairRecord)it.next();
		//System.out.println(e.getSerialNumber());
		return wraplistDataModel_EquipRepairRecord;
	}
	public void setWraplistDataModel_EquipRepairRecord(
			DataModel wraplistDataModelEquipRepairRecord) {
		this.wraplistDataModel_EquipRepairRecord = wraplistDataModelEquipRepairRecord;
	}
	public String getEquipRepairRecordContent(){
		EquipRepairRecord er=new EquipRepairRecord();
		SerialNumber=String.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap().get("serialnumber"));
	if (null == SerialNumber) {
		try {
			String path = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestContextPath();
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(path + "/pages/work/devicedrepairrecord.faces");
		} catch (IOException e) {
			e.printStackTrace();
		}
	 } else {
		String condition="EquipRepairRecord.serialNumber='"+SerialNumber+"'";
		er=(EquipRepairRecord)this.serviceLocator.getEquipRepairrecordService().queryByCondition(condition).get(0);
	  }
	    this.SerialNumber=er.getSerialNumber();
	    this.ProjectSerialNumber=er.getProjectSerialNumber();
	    this.ProjectName=er.getProjectName();
	    this.Site=er.getSite();
	    this.Time=er.getTime();
	    this.LastRepairTime=er.getLastRepairTime();
	    this.ConsumeTime=er.getConsumeTime();
	    this.RepairReason=er.getRepairReason();
	    this.RepairContent=er.getRepairContent();
	    this.ConsumeMaterial=er.getConsumeMaterial();
	    this.FeedBack=er.getFeedBack();
	    this.RepairMan=er.getRepairMan();
	    this.ProprietorConfirm=er.getProprietorConfirm();
	    this.DirectorName=er.getDirectorName();
	    this.CompleteTime=er.getCompleteTime();
		return NavigationResults.RECORDDETAIL;
	}
	public String RecordDetailAddSuccessAction(){
		EquipRepairRecord equiprecord=new EquipRepairRecord();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    this.newSerialNumber=formatter.format(new java.util.Date()).trim().replace(":", "").replace("-", "").replace(" ", "");
		equiprecord.setSewageName(newSewageSelectName);
		equiprecord.setDeviceName(newDeviceName);
		equiprecord.setSerialNumber(this.newSerialNumber);
		equiprecord.setProjectSerialNumber(newProjectSerialNumber);
		equiprecord.setProjectName(newProjectName);
		equiprecord.setSite(this.newSite);
		equiprecord.setTime(this.newTime);
		equiprecord.setLastRepairTime(this.newLastRepairTime);
		equiprecord.setConsumeTime(newConsumeTime);
		equiprecord.setRepairReason(newRepairReason);
		equiprecord.setRepairContent(newRepairContent);
		equiprecord.setConsumeMaterial(newConsumeMaterial);
		equiprecord.setFeedBack(newFeedBack);
		equiprecord.setRepairMan(newRepairMan);
		equiprecord.setProprietorConfirm(newProprietorConfirm);
		equiprecord.setDirectorName(newDirectorName);
		equiprecord.setCompleteTime(this.newCompleteTime);
		String condition = "DeviceDoc.sewageName='"+this.newSewageSelectName+"'"+" and "+"DeviceDoc.deviceName='"+this.newDeviceName+"'";
		List<DeviceDoc> doc=this.getServiceLocator().getDeviceDocService().queryByCondition(condition);
		Iterator it=doc.iterator();
		while(it.hasNext()){
			DeviceDoc temp=(DeviceDoc)it.next();
			temp.setLastRepairTime(this.newCompleteTime);
			temp.setRepairRecord(temp.getRepairRecord()+1);
			this.getServiceLocator().getDeviceDocService().updateDeviceDoc(temp);
		}
		this.getServiceLocator().getEquipRepairrecordService().saveEquipRepairRecordService(equiprecord);
		this.newSewageSelectName=null;
		this.newDeviceName=null;
		this.newProjectSerialNumber=null;
		this.newProjectName=null;
		this.newSite=null;
		this.newConsumeMaterial=null;
		this.newRepairContent=null;
		this.newRepairReason=null;
		this.newConsumeTime=null;
		this.newFeedBack=null;
		this.newRepairMan=null;
		this.newProprietorConfirm=null;
		this.newDirectorName=null;
		
		return NavigationResults.RECORDDETAILADDACTION;
	}
}
