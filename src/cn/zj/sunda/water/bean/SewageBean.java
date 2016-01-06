package cn.zj.sunda.water.bean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.axis.session.Session;

import com.sun.xml.internal.ws.encoding.SwACodec;

import cn.zj.sunda.water.bo.Administrator;
import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.ControlLog;
import cn.zj.sunda.water.bo.ControlLogId;
import cn.zj.sunda.water.bo.DetectionData;
import cn.zj.sunda.water.bo.RunData;
import cn.zj.sunda.water.bo.Sewage;
import cn.zj.sunda.water.bo.WarnSearch;
import cn.zj.sunda.water.dao.warnSearchDao;
import cn.zj.sunda.water.dao.impl.WarnSearchDaoImpl;
import cn.zj.sunda.water.util.FacesUtils;

public class SewageBean extends BaseBean{

	private Integer sewageId;
	private Area area;
	private Administrator administrator;
	private Integer controlId;
	private String shortTitle;
	private String name;
	private String address;
	private Float coordinateX;
	private Float coordinateY;
	private String equipment1state;
	private String equipment2state;
	private String equipment3state;
	private String equipment4state;
	private String equipment5state="1";
	private Float detection1;
	private Float detection1ul;
	private Float detection1dl;
	private Float detection2;
	private Float detection2ul;
	private Float detection2dl;
	private Float detection3ul;
	private Float detection3;
	private Float detection3dl;
	private Float detection4;
	private Float detection4ul;
	private Float detection4dl;
	private Float detection5;
	private Float detection5ul;
	private Float detection5dl;
	private Float detection6=0f;
	private Float detection6ul=0f;
	private Float detection6dl=0f;
	private int gratingDays=0;
	private String operationnum;
	private Integer controlMethod;
	private String name1="曝气机";
	private String name2="污水泵";
	private String name3="回流泵";
	private String name4="吸膜泵";
	private String timeControl="";
	private String errorMess;
	private DataModel warnSearchList;
	private DataModel WaterQuality;
	
	
    
	
	
	public DataModel getWaterQuality() {
		WaterQuality = new ListDataModel();
	    List<Sewage> sewagelisttt = new ArrayList<Sewage>();
		
		try {
            Integer areaID=this.serviceLocator.getAreaService().queryAreaByName(this.areaSelectName).getAreaId();
        
			String condition1="areaID='"+areaID+"' and (detection1>detection1ul or detection1<detection1dl)";     //1大于上下线的
			List<Sewage> sewage1=this.serviceLocator.getSewageService().querySewageByCondition(condition1);
			
		if(sewage1.size()!=0)
		{	
			for(int i=0;i<sewage1.size();i++)
			{ 
				
				String state="温度";
				sewage1.get(i).setStatement(state);
				sewagelisttt.add(sewage1.get(i));	
			}	
		}
		
		String condition2="areaID='"+areaID+"' and (detection2>detection2ul or detection2<detection2dl)";     //1大于上下线的
		List<Sewage> sewage2=this.serviceLocator.getSewageService().querySewageByCondition(condition2);
		
	if(sewage2.size()!=0)
	{	
		for(int i=0;i<sewage2.size();i++)
		{ 
			
			String state="PH";
			sewage2.get(i).setStatement(state);
			sewagelisttt.add(sewage2.get(i));	
		}	
	}
		
	
	String condition3="areaID='"+areaID+"' and (detection3>detection3ul or detection3<detection3dl)";     //1大于上下线的
	List<Sewage> sewage3=this.serviceLocator.getSewageService().querySewageByCondition(condition3);
	
if(sewage3.size()!=0)
{	
	for(int i=0;i<sewage3.size();i++)
	{ 
		
		String state="ORP";
		sewage3.get(i).setStatement(state);
		sewagelisttt.add(sewage3.get(i));	
	}	
}
		
String condition4="areaID='"+areaID+"' and (detection4>detection4ul or detection4<detection4dl)";     //1大于上下线的
List<Sewage> sewage4=this.serviceLocator.getSewageService().querySewageByCondition(condition4);

if(sewage4.size()!=0)
{	
for(int i=0;i<sewage4.size();i++)
{ 
	
	String state="LS";
	sewage4.get(i).setStatement(state);
	sewagelisttt.add(sewage4.get(i));	
}	
}
   


String condition5="areaID='"+areaID+"' and (detection5>detection5ul or detection5<detection5dl)";     //1大于上下线的
List<Sewage> sewage5=this.serviceLocator.getSewageService().querySewageByCondition(condition5);

if(sewage5.size()!=0)
{	
for(int i=0;i<sewage5.size();i++)
{ 
	
	String state="DO";
	sewage5.get(i).setStatement(state);
	sewagelisttt.add(sewage5.get(i));	
}	
}
		
	for(int i=0;i<sewagelisttt.size();i++)
	{
		
		sewagelisttt.get(i).setNumber(i+1);
		int ID=sewagelisttt.get(i).getSewageId();
	
		
		sewagelisttt.get(i).setTime(this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition2(ID).get(0).getLastupdate());
		
	}
		
	//String condition="select  top 1 testingtime  from detection_data where sewageID=100 order by testingtime desc ";
			//this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition2(condition);
			//System.out.println(this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition2(condition));
			//sewage1.get(i).setDate(date);
	
			WaterQuality.setWrappedData(sewagelisttt);
			
			
		} catch (Exception e) {
			
			String condition1="detection1>detection1ul or detection1<detection1dl";     //1大于上下线的
			List<Sewage> sewage1=this.serviceLocator.getSewageService().querySewageByCondition(condition1);
			
		if(sewage1.size()!=0)
		{	
			for(int i=0;i<sewage1.size();i++)
			{ 
				
				String state="温度";
				sewage1.get(i).setStatement(state);
				sewagelisttt.add(sewage1.get(i));	
			}	
		}
		
		String condition2="detection2>detection2ul or detection2<detection2dl";     //1大于上下线的
		List<Sewage> sewage2=this.serviceLocator.getSewageService().querySewageByCondition(condition2);
		
	if(sewage2.size()!=0)
	{	
		for(int i=0;i<sewage2.size();i++)
		{ 
			
			String state="PH";
			sewage2.get(i).setStatement(state);
			sewagelisttt.add(sewage2.get(i));	
		}	
	}
		
	
	String condition3="detection3>detection3ul or detection3<detection3dl";     //1大于上下线的
	List<Sewage> sewage3=this.serviceLocator.getSewageService().querySewageByCondition(condition3);
	
if(sewage3.size()!=0)
{	
	for(int i=0;i<sewage3.size();i++)
	{ 
		
		String state="ORP";
		sewage3.get(i).setStatement(state);
		sewagelisttt.add(sewage3.get(i));	
	}	
}
		
String condition4="detection4>detection4ul or detection4<detection4dl";     //1大于上下线的
List<Sewage> sewage4=this.serviceLocator.getSewageService().querySewageByCondition(condition4);

if(sewage4.size()!=0)
{	
for(int i=0;i<sewage4.size();i++)
{ 
	
	String state="LS";
	sewage4.get(i).setStatement(state);
	sewagelisttt.add(sewage4.get(i));	
}	
}
   


String condition5="detection5>detection5ul or detection5<detection5dl";     //1大于上下线的
List<Sewage> sewage5=this.serviceLocator.getSewageService().querySewageByCondition(condition5);

if(sewage5.size()!=0)
{	
for(int i=0;i<sewage5.size();i++)
{ 
	
	String state="DO";
	sewage5.get(i).setStatement(state);
	sewagelisttt.add(sewage5.get(i));	
}	
}
		
	for(int i=0;i<sewagelisttt.size();i++)
	{
		
		sewagelisttt.get(i).setNumber(i+1);
		int ID=sewagelisttt.get(i).getSewageId();
		
		
		
		sewagelisttt.get(i).setTime(this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition2(ID).get(0).getLastupdate());
		
	}
		
	//String condition="select  top 1 testingtime  from detection_data where sewageID=100 order by testingtime desc ";
			//this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition2(condition);
			//System.out.println(this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition2(condition));
			//sewage1.get(i).setDate(date);
	
			WaterQuality.setWrappedData(sewagelisttt);
			
			
			
			
			//TODO: handle exception
			System.out.println("报错了");
		}
		
		
		return WaterQuality;
	}
	public void setWaterQuality(DataModel waterQuality) {
		
		WaterQuality = waterQuality;
	}
	public String getErrorMess() {
		return errorMess;
	}
	public void setErrorMess(String errorMess) {
		this.errorMess = errorMess;
	}
	public DataModel getWarnSearchList() {
		warnSearchList = new ListDataModel();
		List<Sewage> sewages = null;
		List<Sewage> sewageAdd=new ArrayList<Sewage>();
		int timecontrol = 0;
		if (getTimeControl().equals("") || getTimeControl()==null){
			timecontrol = 5;
			
			System.out.println("timecontrol"+timecontrol);
		}else{
			try {
				timecontrol = Integer.parseInt(getTimeControl());
			} catch (Exception e) {
				// TODO: handle exception
				setErrorMess("输入的信息有误！");
				System.out.println("12333333333333");
			}
		}
		warnSearchDao dao = new WarnSearchDaoImpl();
		
		try {
			
			Integer areaId=this.serviceLocator.getAreaService().queryAreaByName(this.areaSelectName).getAreaId();
			sewages=this.serviceLocator.getSewageService().querySewageByAreaId(areaId);
			
			for (int i=0;i<sewages.size();i++){
				if(!dao.queryByAreaID(sewages.get(i).getSewageId(),timecontrol).equals(""))
				{
				String [] res = dao.queryByAreaID(sewages.get(i).getSewageId(),timecontrol).split("#");
		       
				sewages.get(i).setDate(res[1]);
				sewages.get(i).setStatement(res[0]);
				sewageAdd.add(sewages.get(i));
				}
			}
		} catch (Exception e) {
			System.out.println("报错了");
			System.out.println("timeControl"+timecontrol);
			Integer areaId= 9;
			sewages=this.serviceLocator.getSewageService().querySewageByAreaId(areaId);
			for (int i=0;i<sewages.size();i++){
				int sid = sewages.get(i).getSewageId();
				if(!dao.queryByAreaID(sid,timecontrol).equals(""))
				{
				String[] res = dao.queryByAreaID(sid,timecontrol).split("#");
				
				sewages.get(i).setDate(res[1]);
				sewages.get(i).setStatement(res[0]);
				sewageAdd.add(sewages.get(i));
				}
			}
				
			}
		
		warnSearchList.setWrappedData(sewageAdd);
		
		return warnSearchList;
	}
	public void setWarnSearchList(DataModel warnSearchList) {
		this.warnSearchList = warnSearchList;
	}
	public String getTimeControl() {
		return this.timeControl;
	}
	public void setTimeControl(String timeControl) {
		this.timeControl = timeControl;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public Integer getControlMethod() {
		return controlMethod;
	}
	public void setControlMethod(Integer controlMethod) {
		this.controlMethod = controlMethod;
	}
	public DataModel troublelist = new ListDataModel();
	
	public DataModel troublelist2 = new ListDataModel();
	public DataModel getTroublelist2() {
		try {
			Integer areaID=this.serviceLocator.getAreaService().queryAreaByName(this.areaSelectName).getAreaId();
			
			String condition="areaID='"+areaID+"' and (equipment1state=3 or equipment2state=3 or equipment3state=3 or equipment4state=3)";
		
			List<Sewage> sewageWithTrouble=this.serviceLocator.getSewageService().querySewageByCondition(condition);
			
			
			troublelist.setWrappedData(sewageWithTrouble);
			
		} catch (Exception e) {
			

			String condition=" (equipment1state=3 or  equipment2state=3  or equipment3state=3 or equipment4state=3)";
			List<Sewage> sewageWithTrouble=this.serviceLocator.getSewageService().querySewageByCondition(condition);
			troublelist.setWrappedData(sewageWithTrouble);
			
			
			// TODO: handle exception
		}
		return troublelist2;
	}
	public void setTroublelist2(DataModel troublelist2) {
		this.troublelist2 = troublelist2;
	}
	public String getOperationnum() {
		return operationnum;
	}
	public void setOperationnum(String operationnum) {
		this.operationnum = operationnum;
	}
	////////////////////////////////////
	 private float waterflow;
	 private float reduceCOD;
	 private float reduceNH3N;
	 private float reduceP;
	 ////////////////////////////////////
	 
	public int getGratingDays() {
		return gratingDays;
	}
	public float getWaterflow() {
		return waterflow;
	}
	public void setWaterflow(float waterflow) {
		this.waterflow = waterflow;
	}
	public float getReduceCOD() {
		return reduceCOD;
	}
	public void setReduceCOD(float reduceCOD) {
		this.reduceCOD = reduceCOD;
	}
	public float getReduceNH3N() {
		return reduceNH3N;
	}
	public void setReduceNH3N(float reduceNH3N) {
		this.reduceNH3N = reduceNH3N;
	}
	public float getReduceP() {
		return reduceP;
	}
	public void setReduceP(float reduceP) {
		this.reduceP = reduceP;
	}
	public void setGratingDays(int gratingDays) {
		this.gratingDays = gratingDays;
	}
	private Integer idOfRole;
	private String air_sched[] = new String[24];
	public String[] getAir_sched() {
		return air_sched;
	}
	public void setAir_sched(String[] airSched) {
		air_sched = airSched;
	}
	public String[] getWater_sched() {
		return water_sched;
	}
	public void setWater_sched(String[] waterSched) {
		water_sched = waterSched;
	}
	public String[] getMud_sched() {
		return mud_sched;
	}
	public void setMud_sched(String[] mudSched) {
		mud_sched = mudSched;
	}
	public String[] getFlow_sched() {
		return flow_sched;
	}
	public void setFlow_sched(String[] flowSched) {
		flow_sched = flowSched;
	}
	public String[] getBackup_sched() {
		return backup_sched;
	}
	public void setBackup_sched(String[] backupSched) {
		backup_sched = backupSched;
	}
	private String water_sched[] = new String[24];
	private String mud_sched[] = new String[24];
	private String flow_sched[] = new String[24];
	private String backup_sched[] = new String[24];
	private String control_strategy[] = new String[5];
	private String device_alert[] = new String[5];

	public  Integer getIdOfRole() {
		return idOfRole;
	}
	public void setIdOfRole(Integer idOfRole) {
		this.idOfRole = idOfRole;
	}
	public Integer getSewageId() {
		return sewageId;
	}
	public void setSewageId(Integer sewageId) {
		this.sewageId = sewageId;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	
	public Integer getControlId() {
		return controlId;
	}
	public void setControlId(Integer controlId) {
		this.controlId = controlId;
	}
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(Float coordinateX) {
		this.coordinateX = coordinateX;
	}
	public Float getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(Float coordinateY) {
		this.coordinateY = coordinateY;
	}
	public String getEquipment1state() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("sewageSelectIndex");
		
		if (sewageSessionSelectIndex == null) {
			return equipment1state;
		} else {

			sewageSelectName = sewageItem[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
		
			Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
			this.setEquipment1state(sewage.getEquipment1state());

			
			return equipment1state;
		}
	}
	
	public void setEquipment1state(String equipment1state) {
		this.equipment1state = equipment1state;
	}
	public String getEquipment2state() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("sewageSelectIndex");
		
		if (sewageSessionSelectIndex == null) {
			return equipment2state;
		} else {

			sewageSelectName = sewageItem[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
		
			Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
			this.setEquipment2state(sewage.getEquipment2state());

			//System.out.println("getEquipment2state() -> equipment2state: " + equipment2state);
			return equipment2state;
		}
	}
	public void setEquipment2state(String equipment2state) {
		this.equipment2state = equipment2state;
	}
	public String getEquipment3state() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("sewageSelectIndex");
		
		if (sewageSessionSelectIndex == null) {
			return equipment3state;
		} else {

			sewageSelectName = sewageItem[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
		
			Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
			this.setEquipment3state(sewage.getEquipment3state());

			//System.out.println("getEquipment3state() -> equipment3state: " + equipment3state);
			return equipment3state;
		}

	}
	public void setEquipment3state(String equipment3state) {
		this.equipment3state = equipment3state;
	}
	public String getEquipment4state() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("sewageSelectIndex");
		
		if (sewageSessionSelectIndex == null) {
			return equipment4state;
		} else {

			sewageSelectName = sewageItem[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
		
			Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
			this.setEquipment4state(sewage.getEquipment4state());

			//System.out.println("getEquipment4state() -> equipment4state: " + equipment4state);
			return equipment4state;
		}

	}
	public void setEquipment4state(String equipment4state) {
		this.equipment4state = equipment4state;
	}
	public String getEquipment5state() {
		return equipment5state;
	}
	public void setEquipment5state(String equipment5state) {
		this.equipment5state = equipment5state;
	}
	public Float getDetection1() {
		return detection1;
	}
	public void setDetection1(Float detection1) {
		this.detection1 = detection1;
	}
	public Float getDetection1ul() {
		return detection1ul;
	}
	public void setDetection1ul(Float detection1ul) {
		this.detection1ul = detection1ul;
	}
	public Float getDetection1dl() {
		return detection1dl;
	}
	public void setDetection1dl(Float detection1dl) {
		this.detection1dl = detection1dl;
	}
	public Float getDetection2() {
		return detection2;
	}
	public void setDetection2(Float detection2) {
		this.detection2 = detection2;
	}
	public Float getDetection2ul() {
		return detection2ul;
	}
	public void setDetection2ul(Float detection2ul) {
		this.detection2ul = detection2ul;
	}
	public Float getDetection2dl() {
		return detection2dl;
	}
	public void setDetection2dl(Float detection2dl) {
		this.detection2dl = detection2dl;
	}
	public Float getDetection3ul() {
		return detection3ul;
	}
	public void setDetection3ul(Float detection3ul) {
		this.detection3ul = detection3ul;
	}
	public Float getDetection3() {
		return detection3;
	}
	public void setDetection3(Float detection3) {
		this.detection3 = detection3;
	}
	public Float getDetection3dl() {
		return detection3dl;
	}
	public void setDetection3dl(Float detection3dl) {
		this.detection3dl = detection3dl;
	}
	public Float getDetection4() {
		return detection4;
	}
	public void setDetection4(Float detection4) {
		this.detection4 = detection4;
	}
	public Float getDetection4ul() {
		return detection4ul;
	}
	public void setDetection4ul(Float detection4ul) {
		this.detection4ul = detection4ul;
	}
	public Float getDetection4dl() {
		return detection4dl;
	}
	public void setDetection4dl(Float detection4dl) {
		this.detection4dl = detection4dl;
	}
	public Float getDetection5() {
		return detection5;
	}
	public void setDetection5(Float detection5) {
		this.detection5 = detection5;
	}
	public Float getDetection5ul() {
		return detection5ul;
	}
	public void setDetection5ul(Float detection5ul) {
		this.detection5ul = detection5ul;
	}
	public Float getDetection5dl() {
		return detection5dl;
	}
	public void setDetection5dl(Float detection5dl) {
		this.detection5dl = detection5dl;
	}
	public Float getDetection6() {
		return detection6;
	}
	public void setDetection6(Float detection6) {
		this.detection6 = detection6;
	}
	public Float getDetection6ul() {
		return detection6ul;
	}
	public void setDetection6ul(Float detection6ul) {
		this.detection6ul = detection6ul;
	}
	public Float getDetection6dl() {
		return detection6dl;
	}
	public void setDetection6dl(Float detection6dl) {
		this.detection6dl = detection6dl;
	}
	private SelectItem[] areaItem;
	private SelectItem[] methodItem;
	private Integer SelectSewageControlId;
	

	public Integer getSelectSewageControlId() {
		try{
		
		SelectSewageControlId=this.serviceLocator.getSewageService().querySewageByShorttitle(this.sewageSelectName).getControlMethod();
		
		}catch(Exception e){
			SelectSewageControlId=0;//默认为普通显示方式
		}
		return SelectSewageControlId;
	}
	public void setSelectSewageControlId(Integer selectSewageControlId) {
		SelectSewageControlId = selectSewageControlId;
	}
	public SelectItem[] getMethodItem() {
		
		methodItem = new SelectItem[4];
		methodItem[0] = new SelectItem(0, "请选择控制方式");
		methodItem[1] = new SelectItem(1, "一般控制");
		methodItem[2] = new SelectItem(2, "无锡信捷XC1-16 PLC");
		methodItem[3] = new SelectItem(3, "台达DVP PLC");
		
		
		
		
		return methodItem;
	}
	public void setMethodItem(SelectItem[] methodItem) {
		this.methodItem = methodItem;
	}
	private SelectItem[] sewageItem;

	private String areaSelectIndex;
	private String sewageSelectIndex;
	
	private String areaSelectName;
	private String sewageSelectName;
	
	public DataModel getTroublelist() {
		try {
			Integer areaID=this.serviceLocator.getAreaService().queryAreaByName(this.areaSelectName).getAreaId();
			
			String condition="areaID='"+areaID+"' and (equipment1state=3 or equipment2state=3 or equipment3state=3)";
		
			List<Sewage> sewageWithTrouble=this.serviceLocator.getSewageService().querySewageByCondition(condition);
			
			
			troublelist.setWrappedData(sewageWithTrouble);
			
		} catch (Exception e) {
			

			String condition=" (equipment1state=3 or  equipment2state=3  or equipment3state=3)";
			List<Sewage> sewageWithTrouble=this.serviceLocator.getSewageService().querySewageByCondition(condition);
			troublelist.setWrappedData(sewageWithTrouble);
			
			
			// TODO: handle exception
		}
		
	
		
		
		return troublelist;
	}
	public void setTroublelist(DataModel troublelist) {
		this.troublelist = troublelist;
	}
	public String getAreaSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String areaSessionSelectIndex = (String)session.getAttribute("areaSelectIndex");
		String sewageRequestId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");
      
		
		if (sewageRequestId != null) {
			Sewage sewageFromRequest = this.serviceLocator.getSewageService()
				.querySewageById(Integer.parseInt(sewageRequestId));
			areaSelectName = sewageFromRequest.getArea().getName();
			for (int i = 1; i <= areaItem.length; i++) {
				if (areaItem[i].getLabel().equals(areaSelectName)) {
				//getLabel()获取此按钮的标签.返回：按钮的标签，如果按钮没有标签，则返回 null。
					areaSelectIndex = String.valueOf(i);
					session.setAttribute("areaSelectIndex", areaSelectIndex);
					break;
				} 						
			}
			return areaSelectIndex;		
		}
		
		if (areaSessionSelectIndex == null) {
			return areaSelectIndex;
		} else {
			
			areaSelectName = areaItem[Integer.valueOf(areaSessionSelectIndex)].getLabel();
			areaSelectIndex = areaSessionSelectIndex;
			
			session.setAttribute("areaSelectIndex", areaSelectIndex);
			session.setAttribute("areaSelectName", areaSelectName);
			return areaSelectIndex;
		}
	}
	
	public void setAreaSelectIndex(String areaSelectIndex) {
		this.areaSelectIndex = areaSelectIndex;
	}
	
	public String getSewageSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("sewageSelectIndex");
		String sewageRequestId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");
		
		//System.out.println("getSewageSelectIndex() -> sewageSessionSelectIndex:" + sewageSessionSelectIndex);
		//System.out.println("sewageRequestId:" + sewageRequestId);

		if (sewageRequestId != null) {
			Sewage sewageFromRequest = this.serviceLocator.getSewageService().querySewageById(Integer.parseInt(sewageRequestId));
			sewageSelectName = sewageFromRequest.getShortTitle();
			for (int i = 1; i <= sewageItem.length; i++) {
				if (sewageItem[i].getLabel().equals(sewageSelectName)) {
					sewageSelectIndex = String.valueOf(i);
					session.setAttribute("sewageSelectIndex", sewageSelectIndex);
					break;
				} 						
			}
			return sewageSelectIndex;
		}
		
		if (sewageSessionSelectIndex == null) {
			return sewageSelectIndex;
		} else {
			getSewageItem();

			sewageSelectName = sewageItem[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
			sewageSelectIndex = sewageSessionSelectIndex;

			session.setAttribute("sewageSelectIndex", sewageSelectIndex);
			session.setAttribute("sewageSelectName", sewageSelectName);
			return sewageSelectIndex;
		}
	}
	
	public void setSewageSelectIndex(String sewageSelectIndex) {
		this.sewageSelectIndex = sewageSelectIndex;
	}
	
	public String getAreaSelectName() {
			return areaSelectName;
	}
	public void setAreaSelectName(String areaSelectName) {
		this.areaSelectName = areaSelectName;
	}
	
	public String getSewageSelectName() {
		return sewageSelectName;
	}
	public void setSewageSelectName(String sewageSelectName) {
		this.sewageSelectName = sewageSelectName;
	}
	public SelectItem[] getAreaItem() {
		List<Area> list = this.serviceLocator.getAreaService().queryAllArea();
		//System.out.println(list.size());
		areaItem = new SelectItem[list.size()+1];
		areaItem[0] = new SelectItem(0, "请选择区县");
		for (int i = 1; i <= list.size(); i++) {
			areaItem[i] = new SelectItem(i,list.get(i-1).getName());
			//System.out.println("areaItem[" + i + "]" + areaItem[i].getLabel());
		}
		
		return areaItem;
	}
	public void setAreaItem(SelectItem[] areaItem) {
		this.areaItem = areaItem;
	}
	public SelectItem[] getSewageItem() {
		//System.out.println("getSewageItem() -> areaSelectName: " + areaSelectName);

		String condition = "area.name = '"+this.areaSelectName+"' order by short_title";
		List<Sewage> list = this.serviceLocator.getSewageService().querySewageByCondition(condition);
		System.out.println(list.size()+"折");
		sewageItem = new SelectItem[list.size()+1];
		sewageItem[0] = new SelectItem(0,"请选择污水站点");
		for (int i = 1; i <= list.size(); i++) {
			sewageItem[i] = new SelectItem(i,list.get(i-1).getShortTitle());
		}
		return sewageItem;
	}
	
	public void setSewageItem(SelectItem[] sewageItem) {
		this.sewageItem = sewageItem;
	}
//谷歌地图搜索功能	
	public void getsewageLatLng(){
		Double coordinateX;
		Double coordinateY;
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true));
		List<Sewage> sewageList = this.serviceLocator.getSewageService().queryAllSewageByShorttitle(shortTitle);
		if(sewageList.size() > 0){
			coordinateX = sewageList.get(0).getCoordinateX();
			coordinateY = sewageList.get(0).getCoordinateY();
			session.setAttribute("coordinateX", coordinateX);
			session.setAttribute("coordinateY", coordinateY);
			session.setAttribute("shortTitle", shortTitle);
		}else{
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("sewageshorttitlenull");
			FacesUtils.addErrorMessage(prompt);
		}
	}
	public void valuechange_area_focus()
	{
		
		Double coordinateX;
		Double coordinateY;
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
		this.areaSelectName = areaItem[Integer.valueOf(this.areaSelectIndex)].getLabel();

		
	  
	    List<Sewage> listsewage;
	    
	    if(!areaSelectName.equals("请选择区县"))
	    {
	    	  Area are=this.serviceLocator.getAreaService().queryAreaByName(areaSelectName);
	    	listsewage=this.serviceLocator.getSewageService().querySewageByAreaId(are.getAreaId());
		    coordinateX=are.getCoordinateX();
		    coordinateY=are.getCoordinateY();
	    }
	    else
	    {
	    	listsewage=this.serviceLocator.getSewageService().queryAllSewage();
	    	 coordinateX=31.593349;
			 coordinateY=120.383333;
	    }
	
	    
	    
	    session.setAttribute("coordinateX", coordinateX);
	    session.setAttribute("coordinateY", coordinateY);
	    session.setAttribute("listsewage", listsewage);
		
	}
	public void valuechange_area()
	{
		this.areaSelectName = areaItem[Integer.valueOf(this.areaSelectIndex)].getLabel();
		this.sewageSelectIndex="-1";
		this.managerSelectIndex="-1";
		//System.out.println("valuechange_area() -> areaSelectName: " + areaSelectName);
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("sewageSelectIndex", null);
		session.setAttribute("areaSelectName", areaSelectName);
		session.setAttribute("areaSelectIndex", areaSelectIndex);
	}
	
	public void valuechanged_sewage()
	{
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true));		

		//System.out.println(sewageSelectName);
		//HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		//request.setAttribute("sewageSelectName", sewageSelectName);
		
		this.sewageSelectName = sewageItem[Integer.valueOf(this.sewageSelectIndex)].getLabel();
		//System.out.println(sewageSelectName);
		if(sewageSelectName!="请选择污水站点")
		{
			session.setAttribute("sewageSelectName", sewageSelectName);
			session.setAttribute("sewageSelectIndex", sewageSelectIndex);
			session.setAttribute("str", sewageSelectName);
			System.out.println("sewageBean里session为"+sewageSelectName);
		Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
		
		/*sewageId = sewage.getSewageId();
		area = sewage.getArea();
		controlId = sewage.getControlId();
		administrator = sewage.getAdministrator();
		shortTitle = sewage.getShortTitle();
		name = sewage.getName();
		address = sewage.getAddress();
		coordinateX = sewage.getCoordinateX();
		coordinateY = sewage.getCoordinateY();*/
		equipment1state = sewage.getEquipment1state();
		equipment2state = sewage.getEquipment2state();
		equipment3state = sewage.getEquipment3state();
		equipment4state = sewage.getEquipment4state();
		equipment5state = sewage.getEquipment5state();
		this.idOfRole=cn.zj.sunda.water.bean.UserBean.idOfRole;
		detection1 = sewage.getDetection1();
		detection1ul = sewage.getDetection1ul();
		detection1dl = sewage.getDetection1dl();
		detection2= sewage.getDetection2();
		detection2ul = sewage.getDetection2ul();
		detection2dl = sewage.getDetection2dl();
		detection3ul = sewage.getDetection3ul();
		detection3 = sewage.getDetection3();
		detection3dl = sewage.getDetection3dl();
		detection4 = sewage.getDetection4();
		detection4ul = sewage.getDetection4ul();
		detection4dl = sewage.getDetection4dl();
		detection5 = sewage.getDetection5();
		detection5ul = sewage.getDetection5ul();
		detection5dl =sewage.getDetection5dl();
		detection6 = sewage.getDetection6();
		detection6ul =sewage.getDetection6ul();
		detection6dl = sewage.getDetection6dl();
		controlMethod=sewage.getControlMethod();
		if(controlMethod==1)
		{
			name1="曝气机";
			name2="污水泵";
			name3="回流泵";
		}
		if(controlMethod==2)
		{
			name1="风机";
			name2="提升泵";
			name3="洗膜泵";
		}
		if(controlMethod==3)
		{
			name1="电磁式气泵";
			name2="潜水提升泵";
			name3="洗潜水排水泵";
			
		}
		
		if(detection1ul == null)
		{
			detection1ul = Float.MAX_VALUE;
		}
		if(detection2ul == null)
		{
			detection2ul = Float.MAX_VALUE;
		}
		if(detection3ul == null)
		{
			detection3ul = Float.MAX_VALUE;
		}
		if(detection4ul == null)
		{
			detection4ul = Float.MAX_VALUE;
		}
		if(detection5ul == null)
		{
			detection5ul = Float.MAX_VALUE;
		}
		if(detection6ul == null)
		{
			detection6ul = Float.MAX_VALUE;
		}
		if(detection1dl ==null)
		{
			detection1dl = Float.MIN_VALUE;
		}
		if(detection2dl ==null)
		{
			detection2dl = Float.MIN_VALUE;
		}
		if(detection3dl ==null)
		{
			detection3dl = Float.MIN_VALUE;
		}
		if(detection4dl ==null)
		{
			detection4dl = Float.MIN_VALUE;
		}
		if(detection5dl ==null)
		{
			detection5dl = Float.MIN_VALUE;
		}
		if(detection6dl ==null)
		{
			detection6dl = Float.MIN_VALUE;
		}
	  }
		else
			//this.sewageSelectIndex="0";
		this.setSewageSelectIndex("-1");
	}
	private String tempid;
	
	public String getTempid() {
		String sewageId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true));
		session.setAttribute("tempid", sewageId);
		return tempid;

	}
	public void setTempid(String tempid) {
		this.tempid = tempid;
	}

	public void paint(OutputStream out, Object data) {
		
		int paintDataHeight = 600;
		int paintDataWidth = 800;
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true));
		String tempid = (String)session.getAttribute("tempid");
		HttpServletRequest request = (HttpServletRequest) FacesContext
		.getCurrentInstance().getExternalContext().getRequest();
		String imagePath  = request.getRealPath("/") + "images\\map.jpg";
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(imagePath));
			BufferedImage bimage = new BufferedImage(paintDataWidth,
					paintDataHeight, BufferedImage.TYPE_INT_RGB); // 缓存图片对象
			BufferedInputStream ins = new BufferedInputStream(in); // 生成缓存输入流
			bimage = ImageIO.read(ins);
			Graphics2D graphics2D = bimage.createGraphics();
			Sewage sewage = this.serviceLocator.getSewageService().querySewageById(Integer.valueOf(tempid));
			String detection1=sewage.getDetection1().toString();
			String detection2=sewage.getDetection2().toString();
			String detection3=sewage.getDetection3().toString();
			String detection4=sewage.getDetection4().toString();
			String detection5=sewage.getDetection5().toString();
			String detection6=sewage.getDetection6().toString();
			
			Random r = new Random();
			float ls = r.nextInt(1000)/100*1.0f;
			float ph = r.nextInt(1000)/100*1.0f;
			float orp =r.nextInt(10000)/100*1.0f;
			float flow = r.nextInt(1000)/100*1.0f;
			float t = r.nextInt(10000)/100*1.0f;
			//String detection2=sewage.getDetection2().toString();
			
			graphics2D.setColor(Color.black);
			graphics2D.fillRect(411, 121, 36, 15);
			graphics2D.fillRect(411, 140, 36, 15);
			graphics2D.fillRect(411, 159, 36, 15);
			graphics2D.fillRect(411, 178, 36, 15);
			graphics2D.fillRect(411, 197, 36, 15);
			graphics2D.setColor(Color.white);
			graphics2D.drawString(String.valueOf(ls), 415, 135);
			graphics2D.drawString(String.valueOf(ph), 415, 154);
			graphics2D.drawString(String.valueOf(orp), 415, 173);
			graphics2D.drawString(String.valueOf(flow), 415, 192);
			graphics2D.drawString(String.valueOf(t), 415, 211);
			/*graphics2D.drawString(detection1, 415, 135);
			graphics2D.drawString(detection2, 415, 154);
			graphics2D.drawString(detection3, 415, 173);
			graphics2D.drawString(detection4, 415, 192);
			graphics2D.drawString(detection5, 415, 211);*/
			Font f=new Font("Serif",Font.BOLD,48);//创建一个Font对象，传入字体名，风格，大小
			graphics2D.setFont(f);
			graphics2D.setColor(Color.green);
			graphics2D.drawString(sewage.getShortTitle(), 120, 70);
			ImageIO.write(bimage, "jpeg", out);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//detectionData历史数据Benin
	public Date beginDate = new Date();
	public Date endDate = new Date();
	
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String flag_detection = "0";//0:从首页地图超链接显示页面，1:通过点击查询按钮显示页面
	
	public String getFlag() {
		return flag_detection;
	}

	public void setFlag(String flag) {
		this.flag_detection = flag;
	}
	public DataModel wraplistDataModel_detection = new ListDataModel();

	public DataModel getWraplistDataModel_detection() {
		List<DetectionData> list = new ArrayList<DetectionData>();
		String condition = "";
		String sewageid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");
		if(sewageid == null)
		{
			flag_detection="1";
		}
		if("0".equals(flag_detection))
		{
			this.sewageId =Integer.valueOf(sewageid);
			String today = new Date().toLocaleString();
			String[] dateA = today.split(" ");
			condition = "sewage.sewageId ="+sewageId+" and testingtime between '"+dateA[0]+" 00:00' and '"+dateA[0]+" 23:59'";
		}
		else
		{
			/*HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(true));
			String sewageshorttitle = (String)session.getAttribute("sewageshorttitle");*/
			String sewageshorttitle =sewageSelectName;
			condition ="sewage.shortTitle ='"+sewageshorttitle+"' and testingtime between '"+this.beginDate.toLocaleString()+"' and '"+this.endDate.toLocaleString()+"'";
		}
		list = this.serviceLocator.getDetectionDataService().queryDetectionDataByCondition(condition);
		wraplistDataModel_detection.setWrappedData(list);
		//this.flag_detection="0";
		return wraplistDataModel_detection;
	}

	public void setWraplistDataModel_detection(DataModel wraplistDataModel) {
		this.wraplistDataModel_detection = wraplistDataModel;
	}
	//detectionData历史数据End
	
	//runData历史数据Begin
	public DataModel wraplistDataModel_rundata = new ListDataModel();
	public String flag_equipment = "0";//0:从首页地图超链接显示页面，1:通过点击查询按钮显示页面
	
	public DataModel getWraplistDataModel_rundata() {
		List<RunData> list = new ArrayList<RunData>();
		String condition = "";
		String sewageid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sewageid");

		if(sewageid == null)
		{
			flag_equipment="1";
		}
		
		if("0".equals(flag_equipment))
		{
			String today = new Date().toLocaleString();
			//System.out.println(today);
			String[] dateA = today.split(" ");
			//System.out.println(dateA[0]);
			//System.out.println(dateA[1]);
			condition = "sewage.sewageId ="+sewageId+" and testingtime between '"+dateA[0]+" 00:00' and '"+dateA[0]+" 23:59'";
		}
		else
		{
			/*HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(true));
			String sewageshorttitle = (String)session.getAttribute("sewageshorttitle");*/
			String sewageshorttitle =sewageSelectName;
			condition ="sewage.shortTitle ='"+sewageshorttitle+"' and testingtime between '"+this.beginDate.toLocaleString()+"' and '"+this.endDate.toLocaleString()+"'";
		}
		//System.out.println(condition);
		list = this.serviceLocator.getRunDataService().queryRunDataByCondition(condition);		
		List<DetectionData> lists=this.getServiceLocator().getDetectionDataService().queryDetectionDataByCondition(condition);
	  Integer MAX;
	  if(lists.size()>list.size())
	  {
		  MAX=list.size();
	  }
	  else
	  {
		  MAX=lists.size();
	  }
		for(int i=0;i<MAX;i++)
		{
		
			list.get(i).setEquipment5state(lists.get(i).getDetection4().shortValue());
			
		}
		wraplistDataModel_rundata.setWrappedData(list);
		//flag_equipment="0";
		return wraplistDataModel_rundata;
	}
	public void setWraplistDataModel_rundata(DataModel wraplistDataModel) {
		this.wraplistDataModel_rundata = wraplistDataModel;
	}
	//runData历史数据End
	
	//点击监测记录页面的查询按钮，部分刷新列表
	public void selectAction()
	{
		this.flag_detection="1";
	}
	//污水站点管理
	private String delDataIDStr;

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public DataModel wraplistDataModel = new ListDataModel();

	public DataModel getWraplistDataModel() {

		List<Sewage> list = this.serviceLocator.getSewageService().queryAllSewage();
		wraplistDataModel.setWrappedData(list);
		return wraplistDataModel;
	}

	public void setWraplistDataModel(DataModel wraplistDataModel) {
		this.wraplistDataModel = wraplistDataModel;
	}
	
	public String sewageAddAction()
	{
		controlId=0;
		controlMethod=0;
		shortTitle="";
		name="";
		address="";
		operationnum="";
		coordinateX=0f;
		coordinateY=0f;
		equipment1state="1";
		equipment2state="1";
		equipment3state="1";
		equipment4state="1";
		equipment5state="1";
		detection1=0f;
		detection2=0f;
		detection3=0f;
		detection4=0f;
		detection5=0f;
		detection6=0f;
		return NavigationResults.SEWAGEADDACTION;
	}
	
	public String sewageAddSuccessAction()
	{
		FacesContext context = FacesContext.getCurrentInstance();
        String bundleName = context.getApplication().getMessageBundle();
        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
        List<Sewage> list = this.serviceLocator.getSewageService().querySewageByControlID(controlId);
		if ((areaSelectName == null) || (manageSelectName == null) || (shortTitle == "") || (name == "") ||(controlId == 0)) {
	        String prompt = messageBundle.getString("areaManagernull");
			FacesUtils.addErrorMessage(prompt);
			return null;
		}else if(list.size() > 0){
			String prompt = messageBundle.getString("controlIdExist");
			FacesUtils.addErrorMessage(prompt);
			return null;
		}else {
			Sewage sewage = new Sewage();
			String condition_area="name ='"+this.areaSelectName+"'";
			String condition_manager ="name ='"+this.manageSelectName+"'";
			Area area = this.serviceLocator.getAreaService().queryAreaByCondition(condition_area).get(0);
			Administrator manager = this.serviceLocator.getAdminService().queryAdministratorByCondition(condition_manager).get(0);
			sewage.setSewageId(controlId);
			sewage.setAddress(address);
			sewage.setAdministrator(manager);
			sewage.setArea(area);
			sewage.setControlId(controlId);
			sewage.setCoordinateX(coordinateX.doubleValue());
			sewage.setCoordinateY(coordinateY.doubleValue());
			sewage.setName(name);
			sewage.setShortTitle(shortTitle);
			sewage.setEquipment1state(equipment1state);
			sewage.setEquipment2state(equipment2state);
			sewage.setEquipment3state(equipment3state);
			sewage.setEquipment4state(equipment4state);
			sewage.setEquipment5state(equipment5state);
			sewage.setDetection1(detection1);
			sewage.setDetection1dl(detection1dl);
			sewage.setDetection1ul(detection1ul);
			sewage.setDetection2(detection2);
			sewage.setDetection2dl(detection2dl);
			sewage.setDetection2ul(detection2ul);
			sewage.setDetection3(detection3);
			sewage.setDetection3dl(detection3dl);
			sewage.setDetection3ul(detection3ul);
			sewage.setDetection4(detection4);
			sewage.setDetection4dl(detection4dl);
			sewage.setDetection4ul(detection4ul);
			sewage.setDetection5(detection5);
			sewage.setDetection5dl(detection5dl);
			sewage.setDetection5ul(detection5ul);		
			sewage.setDetection6(detection6);
			sewage.setDetection6dl(detection6dl);
			sewage.setDetection6ul(detection6ul);	
			sewage.setGratingDays(this.gratingDays);
			sewage.setWaterflow(waterflow);
			sewage.setReduceCOD(reduceCOD);
			sewage.setReduceNH3N(reduceNH3N);
			sewage.setReduceP(reduceP);
			sewage.setOperationnum(operationnum);
			sewage.setControlMethod(controlMethod);
			this.serviceLocator.getSewageService().saveSewage(sewage);
			return NavigationResults.SEWAGEADDSUCCESSACTION;
		}
	}
	public String sewageEditAction()
	{
		String sewageId_s = FacesUtils.getRequestParameter("sewageId");
		Sewage sewage = this.serviceLocator.getSewageService().querySewageById(Integer.parseInt(sewageId_s));
		areaSelectName = sewage.getArea().getName();
		manageSelectName = sewage.getAdministrator().getName();
		sewageId = sewage.getSewageId();
		controlId=sewage.getControlId();
		shortTitle=sewage.getShortTitle();
		name=sewage.getName();
		address=sewage.getAddress();
		coordinateX=sewage.getCoordinateX().floatValue();
		coordinateY=sewage.getCoordinateY().floatValue();
		equipment1state=sewage.getEquipment1state();
		equipment2state=sewage.getEquipment2state();
		equipment3state=sewage.getEquipment3state();
		equipment4state=sewage.getEquipment4state();
		equipment5state=sewage.getEquipment5state();
		this.idOfRole=cn.zj.sunda.water.bean.UserBean.idOfRole;
		detection1=sewage.getDetection1();
		detection1dl = sewage.getDetection1dl();
		detection1ul = sewage.getDetection1ul();
		detection2=sewage.getDetection2();
		detection2dl = sewage.getDetection2dl();
		detection2ul = sewage.getDetection2ul();		
		detection3=sewage.getDetection3();
		detection3dl = sewage.getDetection3dl();
		detection3ul = sewage.getDetection3ul();		
		detection4=sewage.getDetection4();
		detection4dl = sewage.getDetection4dl();
		detection4ul = sewage.getDetection4ul();		
		detection5=sewage.getDetection5();
		detection5dl = sewage.getDetection5dl();
		detection5ul = sewage.getDetection5ul();
		detection6=sewage.getDetection6();
		detection6dl = sewage.getDetection6dl();
		detection6ul = sewage.getDetection6ul();
		gratingDays = sewage.getGratingDays();
		operationnum=sewage.getOperationnum();
		controlMethod=sewage.getControlMethod();
		this.waterflow=sewage.getWaterflow();
		this.reduceCOD=sewage.getReduceCOD();
		this.reduceNH3N=sewage.getReduceNH3N();
		this.reduceP=sewage.getReduceP();
		//detection6=sewage.getDetection6();
		char tmp[] = new char[24];
		String temp = sewage.getAir_sched();
		if (temp == null)
		{
			temp = "222222222222222222222222";
		}
		tmp = temp.toCharArray();
		for (int i=0; i<24; i++)
		{
			air_sched[i] = String.valueOf(tmp[i]);
		}
		temp = sewage.getWater_sched();
		if (temp == null)
		{
			temp = "222222222222222222222222";
		}
		tmp = temp.toCharArray();
		for (int i=0; i<24; i++)
		{
			water_sched[i] = String.valueOf(tmp[i]);
		}
		
		temp = sewage.getMud_sched();
		if (temp == null)
		{
			temp = "222222222222222222222222";
		}
		tmp = temp.toCharArray();
		for (int i=0; i<24; i++)
		{
			mud_sched[i] = String.valueOf(tmp[i]);
		}

		temp = sewage.getFlow_sched();
		if (temp == null)
		{
			temp = "222222222222222222222222";
		}
		tmp = temp.toCharArray();
		for (int i=0; i<24; i++)
		{
			flow_sched[i] = String.valueOf(tmp[i]);
		}

		temp = sewage.getBackup_sched();
		if (temp == null)
		{
			temp = "222222222222222222222222";
		}
		tmp = temp.toCharArray();
		for (int i=0; i<24; i++)
		{
			backup_sched[i] = String.valueOf(tmp[i]);
		}
		/* tmp2[5] strategy 和 alert 的临时数组*/
		char tmp2[] = new char[5];
		temp = sewage.getControl_strategy();
		if (temp == null)
		{
			temp = "11111";
		}
		tmp2 = temp.toCharArray();
		for (int i=0; i<5; i++)
		{
			control_strategy[i] = String.valueOf(tmp2[i]);
		}
		
		temp = sewage.getDevice_alert();
		if (temp == null)
		{
			temp = "11111";
		}
		tmp2 = temp.toCharArray();
		for (int i=0; i<5; i++)
		{
			device_alert[i] = String.valueOf(tmp2[i]);
		}
		
		return NavigationResults.SEWAGEEDITACTION;
	}
	
	public String sewageEditSuccessAction()
	{
		FacesContext context = FacesContext.getCurrentInstance();
        String bundleName = context.getApplication().getMessageBundle();
        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
		if ((areaSelectName == null) || (manageSelectName == null) || (shortTitle == "") || (name == "")) {
	        String prompt = messageBundle.getString("areaManagernull");
			FacesUtils.addErrorMessage(prompt);
			return null;
		}else{
			Sewage sewage = this.serviceLocator.getSewageService().querySewageById(this.sewageId);
			
			String condition_area="name ='"+this.areaSelectName+"'";
			Area area = this.serviceLocator.getAreaService().queryAreaByCondition(condition_area).get(0);
			sewage.setArea(area);
		
			String condition_manager ="name ='"+this.manageSelectName+"'";
			Administrator manager = this.serviceLocator.getAdminService().queryAdministratorByCondition(condition_manager).get(0);
			sewage.setAdministrator(manager);
		
			sewage.setAddress(address);
			sewage.setControlId(controlId);
			sewage.setCoordinateX(coordinateX.doubleValue());
			sewage.setCoordinateY(coordinateY.doubleValue());
			sewage.setName(name);
			sewage.setShortTitle(shortTitle);
			sewage.setEquipment1state(equipment1state);
			sewage.setEquipment2state(equipment2state);
			sewage.setEquipment3state(equipment3state);
			sewage.setEquipment4state(equipment4state);
			sewage.setEquipment5state(equipment5state);
			sewage.setDetection1(detection1);
			sewage.setDetection1dl(detection1dl);
			sewage.setDetection1ul(detection1ul);
			sewage.setDetection2(detection2);
			sewage.setDetection2dl(detection2dl);
			sewage.setDetection2ul(detection2ul);		
			sewage.setDetection3(detection3);
			sewage.setDetection3dl(detection3dl);
			sewage.setDetection3ul(detection3ul);		
			sewage.setDetection4(detection4);
			sewage.setDetection4dl(detection4dl);
			sewage.setDetection4ul(detection4ul);		
			sewage.setDetection5(detection5);
			sewage.setDetection5dl(detection5dl);
			sewage.setDetection5ul(detection5ul);	
			sewage.setDetection6(detection6);
			sewage.setDetection6dl(detection6dl);
			sewage.setDetection6ul(detection6ul);
			sewage.setGratingDays(gratingDays);
			sewage.setWaterflow(waterflow);
			sewage.setReduceCOD(reduceCOD);
			sewage.setReduceNH3N(reduceNH3N);
			sewage.setReduceP(reduceP);
			sewage.setOperationnum(operationnum);
			sewage.setControlMethod(controlMethod);
			//sewage.setDetection6(detection6);
			String temp = "";
			for (int i=0; i<24; i++)
			{
				temp += air_sched[i];
			}
			sewage.setAir_sched(temp);
			temp = "";
			for (int i=0; i<24; i++)
			{
				temp += water_sched[i];
			}
			sewage.setWater_sched(temp);
			temp = "";
			for (int i=0; i<24; i++)
			{
				temp += mud_sched[i];
			}
			sewage.setMud_sched(temp);
			temp = "";
			for (int i=0; i<24; i++)
			{
				temp += flow_sched[i];
			}
			sewage.setFlow_sched(temp);
			temp = "";
			for (int i=0; i<24; i++)
			{
				temp += backup_sched[i];
			}
			sewage.setBackup_sched(temp);
			
			temp = "";
			for (int i=0; i<5; i++)
			{
				temp += control_strategy[i];
			}
			sewage.setControl_strategy(temp);
			
			temp = "";
			for (int i=0; i<5; i++)
			{
				temp += device_alert[i];
			}
			sewage.setDevice_alert(temp);
			
			this.serviceLocator.getSewageService().saveSewage(sewage);
			return NavigationResults.SEWAGEEDITSUCCESSACTION;
		}
	}
	
	private SelectItem[] managerItem;
	private String managerSelectIndex;
	private String manageSelectName;
	public SelectItem[] getManagerItem() {
		String condition = "area.name = '"+this.areaSelectName+"'";
		List<Administrator> list = this.serviceLocator.getAdminService().queryAdministratorByCondition(condition);
		managerItem = new SelectItem[list.size()+1];
		managerItem[0]=new SelectItem(0,"请选择管理员");
		for (int i = 0; i < list.size(); i++) {
			managerItem[i+1] = new SelectItem(i,list.get(i).getName());
		}
		return managerItem;
	}
	public void setManagerItem(SelectItem[] managerItem) {
		this.managerItem = managerItem;
	}
	public String getManagerSelectIndex() {
		return managerSelectIndex;
	}
	public void setManagerSelectIndex(String managerSelectIndex) {
		this.managerSelectIndex = managerSelectIndex;
	}
	public String getManageSelectName() {
		return manageSelectName;
	}
	public void setManageSelectName(String manageSelectName) {
		this.manageSelectName = manageSelectName;
	}
	public void valuechange_manager()
	{
		this.manageSelectName = managerItem[Integer.valueOf(this.managerSelectIndex)+1].getLabel();
		this.managerSelectIndex="-1";
	}
	public void deleteByIDs() {
		String temp = getDelDataIDStr();
		String[] ids = temp.split("@");
		this.serviceLocator.getSewageService().deleteByIds(ids);
	}
	
	private Long air;
	
	private Long water;
	
	private Long mud;
	
	private Long flow;
	
	private Long back_up = 2l;
	
	private ControlLogId controlLogId;
	
	/**
	 * @return the controlLogId
	 */
	public ControlLogId getControlLogId() {
		return controlLogId;
	}
	
	/**
	 * @param controlLogId the controlLogId to set
	 */
	public void setControlLogId(ControlLogId controlLogId) {
		this.controlLogId = controlLogId;
	}
	
	/**
	 * @return the air
	 */
	public Long getAir() {
		return air;
	}
	/**
	 * @param air the air to set
	 */
	public void setAir(Long air) {
		this.air = air;
	}
	/**
	 * @return the water
	 */
	public Long getWater() {
		return water;
	}
	/**
	 * @param water the water to set
	 */
	public void setWater(Long water) {
		this.water = water;
	}
	/**
	 * @return the mud
	 */
	public Long getMud() {
		return mud;
	}
	/**
	 * @param mud the mud to set
	 */
	public void setMud(Long mud) {
		this.mud = mud;
	}
	/**
	 * @return the flow
	 */
	public Long getFlow() {
		return flow;
	}
	/**
	 * @param flow the flow to set
	 */
	public void setFlow(Long flow) {
		this.flow = flow;
	}
	/**
	 * @return the back_up
	 */
	public Long getBack_up() {
		return back_up;
	}
	/**
	 * @param backUp the back_up to set
	 */
	public void setBack_up(Long backUp) {
		back_up = backUp;
	}	

	public void updateControlLog() {
		
		ControlLog controlLog = new ControlLog();
		
		if ((sewageSelectName == null) || (areaSelectName == null)) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("sewagenull");
			FacesUtils.addErrorMessage(prompt);
			
		} else {
			Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
	
			HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(true));
			Integer userid = (Integer) (session.getAttribute("userid"));
			 if(UserBean.idOfRole==1||UserBean.idOfRole==2)
				{
					//JOptionPane.showMessageDialog(null,"对不起，你没有这个权限！","警告",JOptionPane.WARNING_MESSAGE);
				}
				else{
					ControlLogId controlLogId = new ControlLogId();
					controlLogId.setCreatedAt(new java.sql.Timestamp(new Date().getTime()));
					controlLogId.setUserId(userid.longValue());
					controlLogId.setSId(sewage.getControlId().longValue());
					
					controlLog.setId(controlLogId);
					controlLog.setAir(Long.valueOf(this.equipment1state));
					controlLog.setWater(Long.valueOf(this.equipment2state));
					controlLog.setMud(Long.valueOf(this.equipment3state));
					controlLog.setFlow(Long.valueOf(this.equipment4state));
					controlLog.setBackUp(back_up);
					
					//ADD for Test
					sewage.setEquipment1state(this.equipment1state);
					sewage.setEquipment2state(this.equipment2state);
					sewage.setEquipment3state(this.equipment3state);
					//sewage.setEquipment4state(this.equipment4state);
					//Set<Userrole> role=this.getServiceLocator().getUserService().queryUserByUserId(userid).getUserroles();
					
					this.serviceLocator.getSewageService().saveSewage(sewage);
					
								
					this.serviceLocator.getSewageService().saveControlLog(controlLog);
				}
	      }
	}
	public void confirmGrating()
	{
		if ((sewageSelectName == null) || (areaSelectName == null)) {
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("sewagenull");
			FacesUtils.addErrorMessage(prompt);
			
		}
		else {
			Sewage sewage = this.serviceLocator.getSewageService().querySewageByShorttitle(sewageSelectName);
	
			HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(true));
			Integer userid = (Integer) (session.getAttribute("userid"));
			sewage.setConfirmGratingTime(new java.sql.Timestamp(new Date().getTime()));
		    this.serviceLocator.getSewageService().saveSewage(sewage);
		}
	}

	public void releaseAirWarning()
	{
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "update sewage set equipment1state='"+String.valueOf(2)
			+ "'where short_title ='"
			+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releaseElevatorWarning()
	{
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "update sewage set equipment2state='"+String.valueOf(2)
			+ "'where short_title ='"
			+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releaseMudWarning()
	{
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "update sewage set equipment3state='"+String.valueOf(2)
			+ "'where short_title ='"
			+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releasemembraneWarning()
	{
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "update sewage set equipment4state='"+String.valueOf(2)
			+ "'where short_title ='"
			+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releaseDOWarning()
	{
		String str;
		char tmp[]=new char[5];
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "select device_alert"
				+ " from sewage where short_title ='"
				+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			ResultSet rs = stmtQuery.executeQuery(strQuery);
			if (rs != null) {
				while (rs.next()) {
					str=rs.getString(1);
					tmp[0]=str.charAt(0);
					tmp[1]=str.charAt(1);
					tmp[2]=str.charAt(2);
					tmp[3]=str.charAt(3);
					tmp[4]='1';
				}
			} else
				System.out.println("未查询到结果");
			strQuery = "update sewage set device_alert='"+String.valueOf(tmp)
				+ "'where short_title ='"
				+ sewageSelectName + "'";
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releaseLSWarning()
	{
		String str;
		char tmp[]=new char[5];
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "select device_alert"
				+ " from sewage where short_title ='"
				+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			ResultSet rs = stmtQuery.executeQuery(strQuery);
			if (rs != null) {
				while (rs.next()) {
					str=rs.getString(1);
					tmp[0]=str.charAt(0);
					tmp[1]=str.charAt(1);
					tmp[2]=str.charAt(2);
					tmp[3]='1';
					tmp[4]=str.charAt(4);
				}
			} else
				System.out.println("未查询到结果");
			strQuery = "update sewage set device_alert='"+String.valueOf(tmp)
				+ "'where short_title ='"
				+ sewageSelectName + "'";
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releaseORPWarning()
	{
		String str;
		char tmp[]=new char[5];
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "select device_alert"
				+ " from sewage where short_title ='"
				+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			ResultSet rs = stmtQuery.executeQuery(strQuery);
			if (rs != null) {
				while (rs.next()) {
					str=rs.getString(1);
					tmp[0]=str.charAt(0);
					tmp[1]=str.charAt(1);
					tmp[2]='1';
					tmp[3]=str.charAt(3);
					tmp[4]=str.charAt(4);
				}
			} else
				System.out.println("未查询到结果");
			strQuery = "update sewage set device_alert='"+String.valueOf(tmp)
				+ "'where short_title ='"
				+ sewageSelectName + "'";
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releasePHWarning()
	{
		String str;
		char tmp[]=new char[5];
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "select device_alert"
				+ " from sewage where short_title ='"
				+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			ResultSet rs = stmtQuery.executeQuery(strQuery);
			if (rs != null) {
				while (rs.next()) {
					str=rs.getString(1);
					tmp[0]=str.charAt(0);
					tmp[1]='1';
					tmp[2]=str.charAt(2);
					tmp[3]=str.charAt(3);
					tmp[4]=str.charAt(4);

				}
			} else
				System.out.println("未查询到结果");
			strQuery = "update sewage set device_alert='"+String.valueOf(tmp)
				+ "'where short_title ='"
				+ sewageSelectName + "'";
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}
	public void releaseTemWarning()
	{
		String str;
		char tmp[]=new char[5];
		if ((sewageSelectName != null) && (areaSelectName != null)) {
		Connection con = null;
		try {
			// 加载JDBC驱动器类
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 建立到TestDB的数据库连接
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;DatabaseName=CS",
							"sa", "123");
			//查询数据
			String strQuery = "select device_alert"
				+ " from sewage where short_title ='"
				+ sewageSelectName + "'";
			Statement stmtQuery = con.createStatement();
			ResultSet rs = stmtQuery.executeQuery(strQuery);
			if (rs != null) {
				while (rs.next()) {
					str=rs.getString(1);
					tmp[0]='1';
					tmp[1]=str.charAt(1);
					tmp[2]=str.charAt(2);
					tmp[3]=str.charAt(3);
					tmp[4]=str.charAt(4);
					System.out.println(tmp);
				}
			} else
				System.out.println("未查询到结果");
			strQuery = "update sewage set device_alert='"+String.valueOf(tmp)
				+ "'where short_title ='"
				+ sewageSelectName + "'";
			stmtQuery.executeQuery(strQuery);
			stmtQuery.close();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException sqle) {
				System.out.println(sqle.getMessage());
			}
		}
	   }
	}

	public String[] getControl_strategy() {
		return control_strategy;
	}
	public void setControl_strategy(String[] controlStrategy) {
		control_strategy = controlStrategy;
	}
	public void setDevice_alert(String device_alert[]) {
		this.device_alert = device_alert;
	}
	public String[] getDevice_alert() {
		return device_alert;
	}
}
