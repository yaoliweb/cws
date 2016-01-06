package cn.zj.sunda.water.bean;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.Bug;
import cn.zj.sunda.water.bo.Sewage;


public class BugBean extends BaseBean {

	private static final String AREATITLE = "请选择地区";
	private static final String SEWAGETITLE = "请选择污水站";

	// 故障ID
	private Long bugID;
	
	/**
	 * @return the bugID
	 */
	public Long getBugID() {
		return bugID;
	}

	/**
	 * @param bugID the bugID to set
	 */
	public void setBugID(Long bugID) {
		this.bugID = bugID;
	}

	// 地区ID
	private Integer areaId;
	
	/**
	 * @return the areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId the areaId to set
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	// 地区名称
	private String areaName;
	
	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}
	
	// 选择地区索引
	private String areaSelectIndex;

	/**
	 * @return the areaSelectIndex
	 */
	public String getAreaSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String areaSessionSelectIndex = (String)session.getAttribute("areaSelectIndex");
		
		if (areaSessionSelectIndex == null) {
			return areaSelectIndex;
		} else {
			areaName = areaItems[Integer.valueOf(areaSessionSelectIndex)].getLabel();
			areaSelectIndex = areaSessionSelectIndex;
			session.setAttribute("areaSelectIndex", areaSelectIndex);
			session.setAttribute("areaSelectName", areaName);
			return areaSelectIndex;
		}
	}

	/**
	 * @param areaSelectIndex the areaSelectIndex to set
	 */
	public void setAreaSelectIndex(String areaSelectIndex) {
		this.areaSelectIndex = areaSelectIndex;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	// 污水站ID
	private Integer sewageId;
	
	/**
	 * @return the sewageId
	 */
	public Integer getSewageId() {
		return sewageId;
	}

	/**
	 * @param sewageId the sewageId to set
	 */
	public void setSewageId(Integer sewageId) {
		this.sewageId = sewageId;
	}

	// 污水站名称
	private String sewageName;	

	/**
	 * @return the sewageName
	 */
	public String getSewageName() {
		return sewageName;
	}

	/**
	 * @param sewageName the sewageName to set
	 */
	public void setSewageName(String sewageName) {
		this.sewageName = sewageName;
	}
	
	// 选择污水站索引
	private String sewageSelectIndex;

	/**
	 * @return the sewageSelectIndex
	 */
	public String getSewageSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String sewageSessionSelectIndex = (String)session.getAttribute("sewageSelectIndex");
		if (sewageSessionSelectIndex == null) {
			return sewageSelectIndex;
		} else {
			getSewageItems();
			sewageName = sewageItems[Integer.valueOf(sewageSessionSelectIndex)].getLabel();
			sewageSelectIndex = sewageSessionSelectIndex;
			
			session.setAttribute("sewageSelectIndex", sewageSelectIndex);
			session.setAttribute("sewageSelectName", sewageName);
			return sewageSelectIndex;
		}
	}

	/**
	 * @param sewageSelectIndex the sewageSelectIndex to set
	 */
	public void setSewageSelectIndex(String sewageSelectIndex) {
		this.sewageSelectIndex = sewageSelectIndex;
	}

	// 故障设备
	private String bugEquipment;
	
	/**
	 * @return the bugEquipment
	 */
	public String getBugEquipment() {
		return bugEquipment;
	}

	/**
	 * @param bugEquipment the bugEquipment to set
	 */
	public void setBugEquipment(String bugEquipment) {
		this.bugEquipment = bugEquipment;
	}
	
	// 故障情况
	private String bugCondition;

	/**
	 * @return the bugCondition
	 */
	public String getBugCondition() {
		return bugCondition;
	}

	/**
	 * @param bugCondition the bugCondition to set
	 */
	public void setBugCondition(String bugCondition) {
		this.bugCondition = bugCondition;
	}
	
	// 发生时间
	private Date occurrenceTime;
	
	/**
	 * @return the occurrenceTime
	 */
	public Date getOccurrenceTime() {
		return occurrenceTime;
	}

	/**
	 * @param occurrenceTime the occurrenceTime to set
	 */
	public void setOccurrenceTime(Date occurrenceTime) {
		this.occurrenceTime = occurrenceTime;
	}

	// 故障状态
	private String bugState;

	/**
	 * @return the bugState
	 */
	public String getBugState() {
		return bugState;
	}

	/**
	 * @param bugState the bugState to set
	 */
	public void setBugState(String bugState) {
		this.bugState = bugState;
	}

	// 故障原因
	private String bugCause;
	
	/**
	 * @return the bugCause
	 */
	public String getBugCause() {
		return bugCause;
	}

	/**
	 * @param bugCause the bugCause to set
	 */
	public void setBugCause(String bugCause) {
		this.bugCause = bugCause;
	}

	// 维修状况
	private String repairCondition;
	
	/**
	 * @return the repairCondition
	 */
	public String getRepairCondition() {
		return repairCondition;
	}

	/**
	 * @param repairCondition the repairCondition to set
	 */
	public void setRepairCondition(String repairCondition) {
		this.repairCondition = repairCondition;
	}

	// 维修费用
	private Float repairCost;
	
	/**
	 * @return the repairCost
	 */
	public Float getRepairCost() {
		return repairCost;
	}

	/**
	 * @param repairCost the repairCost to set
	 */
	public void setRepairCost(Float repairCost) {
		this.repairCost = repairCost;
	}

	// 完成时间
	private Date finishTime;

	/**
	 * @return the finishTime
	 */
	public Date getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime the finishTime to set
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	// 维修员
	private String repairr;
	
	/**
	 * @return the repairr
	 */
	public String getRepairr() {
		return repairr;
	}

	/**
	 * @param repairr the repairr to set
	 */
	public void setRepairr(String repairr) {
		this.repairr = repairr;
	}

	// 验收员
	private String accepter;
	/**
	 * @return the accepter
	 */
	public String getAccepter() {
		return accepter;
	}

	/**
	 * @param accepter the accepter to set
	 */
	public void setAccepter(String accepter) {
		this.accepter = accepter;
	}

	// 操作员
	private String operator;
	
	/**
	 * @return the operator
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * @param operator the operator to set
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}

	// 存储所有可选的地区名称
	private SelectItem[] areaItems;

	/**
	 * @return the areaItems
	 */
	public SelectItem[] getAreaItems() {

		List<Area> areaList = this.serviceLocator.getAreaService().queryAllArea();

		// 根据地区记录个数初始化SelectItem
		areaItems = new SelectItem[areaList.size() + 1];
		areaItems[0] = new SelectItem(0, AREATITLE);
		for (int i = 1; i <= areaList.size(); i++) {
			areaItems[i] = new SelectItem(i, areaList.get(i-1).getName());
		}
		return areaItems;
	}

	/**
	 * @param areaItems
	 *            the areaItems to set
	 */
	public void setAreaItems(SelectItem[] areaItems) {
		this.areaItems = areaItems;
	}
	
	// 存储所有可选的污水站名称
	private SelectItem[] sewageItems;

	/**
	 * @return the sewageItems
	 */
	public SelectItem[] getSewageItems() {
		String condition = "area.name = '"+this.areaName+"'";
		List<Sewage> list = this.serviceLocator.getSewageService().querySewageByCondition(condition);
		sewageItems = new SelectItem[list.size()+1];
		sewageItems[0]=new SelectItem(0,SEWAGETITLE);
		for (int i = 1; i <= list.size(); i++) {
			sewageItems[i] = new SelectItem(i,list.get(i-1).getShortTitle());
		}
		return sewageItems;		
	}			

	/**
	 * @param sewageItems
	 *            the sewageItems to set
	 */
	public void setSewageItems(SelectItem[] sewageItems) {
		this.sewageItems = sewageItems;
	}
	
	/**
	 * 方法名称：areaValueChanged
	 * 方法描述：当从地区名称下拉框选择新的地区名称时触发该方法 
	 * @param event
	 * @return void
	 * @exception
	 * @author LY
	 * @date 2011-11-02
	 */ 
	public void areaValueChanged() {
		this.areaName = areaItems[Integer.valueOf(this.areaSelectIndex)].getLabel();
		this.sewageSelectIndex="-1";
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("sewageSelectIndex", null);
		session.setAttribute("areaSelectName", areaName);
		session.setAttribute("areaSelectIndex", areaSelectIndex);
	}
	
	/**
	 * 方法名称：sewageValueChanged
	 * 方法描述：当从污水站名称下拉框选择新的地区名称时触发该方法 
	 * @param event
	 * @return void
	 * @exception
	 * @author LY
	 * @date 2011-11-02
	 */ 
	public void sewageValueChanged() {
		this.sewageName = sewageItems[Integer.valueOf(this.sewageSelectIndex)].getLabel();
		HttpSession session = ((HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true));			
		session.setAttribute("sewageSelectName", sewageName);
		session.setAttribute("sewageSelectIndex", sewageSelectIndex);
	}	

	// 存储开始时间
	private Date octime1;

	/**
	 * @return the octime1
	 */
	public Date getOctime1() {
		return octime1;
	}

	/**
	 * @param octime1 the octime1 to set
	 */
	public void setOctime1(Date octime1) {
		this.octime1 = octime1;
	}
	
	// 存储终止时间
	private Date octime2;

	/**
	 * @return the octime2
	 */
	public Date getOctime2() {
		return octime2;
	}
	
	/**
	 * @param octime2 the octime2 to set
	 */
	public void setOctime2(Date octime2) {
		this.octime2 = octime2;
	}
	
	// 存储故障的查询结果
	private DataModel allBugListModal = new ListDataModel();
	
	/**
	 * @return the allBugListModal
	 */
	public DataModel getAllBugListModal() {
		return allBugListModal;
	}

	/**
	 * @param allBugListModal the allBugListModal to set
	 */
	public void setAllBugListModal(DataModel allBugListModal) {
		this.allBugListModal = allBugListModal;
	}

	/**
	 * 方法名称：queryBugByCondition
	 * 方法描述：可以选择地区、选择污水站、选择起止日期进行查询
	 * @return
	 * @return DataModel
	 * @exception
	 * @author LY
	 * @date 2011-11-02
	 */ 
	public DataModel queryBugByCondition()
	{
		String condition;
	    SimpleDateFormat formatter;
	    formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    
		if (AREATITLE.equals(areaName)) {
			areaName = "";
		}
		
		if (SEWAGETITLE.equals(sewageName)) {
			sewageName = "";
		}
	    
	    if (!sewageName.equals("")) {
	    	Sewage sewage = this.serviceLocator
	    		.getSewageService().querySewageByShorttitle(sewageName);
	    	sewageId = sewage.getSewageId();
	    	areaId = sewage.getArea().getAreaId();
	    }
	    
//	    if (!areaName.equals("")) {
//		    Area area = this.serviceLocator
//	    		.getAreaService().queryAreaByName(areaName);
//		    areaId = area.getAreaId();
//	    }
	    
		if (null != octime1) {
			String soctime1 = formatter.format(octime1);
			if (null != octime2) {
				String soctime2 = formatter.format(octime2);
				condition = "where areaID like " + areaId
					+ " and sewageID like " + sewageId
					+ " and occurrence_time between '"
					+ soctime1 + "' and '" + soctime2 + "'";				
			} else {
				condition = "where areaID like " + areaId
					+ " and sewageID like " + sewageId 
					+ " and occurrence_time >= '" + soctime1 + "'";
			}
		} else {
			if (null != octime2) {
				String soctime2 = formatter.format(octime2);
				condition = "where areaID like " + areaId
					+ " and sewageID like " + sewageId 
					+ " and occurrence_time <= '" + soctime2 + "'";
			} else {
				condition = "where areaID like " + areaId
					+ " and sewageID like " + sewageId + "";	
			}
	    } 
		
		List<Bug> list = this.serviceLocator.getBugService()
			.queryBugByCondition(condition);
		allBugListModal.setWrappedData(list);
	
		return allBugListModal;
	}

	// 存储删除信息
	private String delDataIDStr;
	
	/**
	 * @return the delDataIDStr
	 */
	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	/**
	 * @param delDataIDStr the delDataIDStr to set
	 */
	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}
	
	public void deleteByBugId() {
		String temp = getDelDataIDStr();
		String[] ids = temp.split("@");
		this.serviceLocator.getBugService().deleteBugByIds(ids);
		queryBugByCondition();
	}
	
	private Bug bugContent;
	
	/**
	 * 方法名称：saveBug
	 * 方法描述：用于保存故障信息
	 * @return
	 * @return String
	 * @exception
	 * @author LY
	 * @date 2011-7-22
	 */ 
	public String saveBug() {
		
		if (null == bugID) {
			// 新增故障
			//this.serviceLocator.getBugService().saveBug(bugContent);
			return null;
		} else {
			// 更改故障
			bugContent = this.serviceLocator.getBugService().queryBugById(bugID);
			bugContent.setBugCondition(bugCondition);
			bugContent.setOccurrenceTime(occurrenceTime);
			bugContent.setBugState(bugState);
			bugContent.setBugCause(bugCause);
			bugContent.setRepairCondition(repairCondition);
			bugContent.setRepairCost(repairCost);
			bugContent.setFinishTime(finishTime);
			bugContent.setRepairr(repairr);
			bugContent.setAccepter(accepter);
			bugContent.setOperator(operator);
			bugContent.setBugEquipment(bugEquipment);
			this.serviceLocator.getBugService().saveBug(bugContent);
			queryBugByCondition();
			
			return NavigationResults.BUGSAVESUCCESS;
		}
	}
	
	/**
	 * 方法名称：getBugContent
	 * 方法描述：获取故障明细
	 * @return
	 * @return String
	 * @exception
	 * @author LY
	 * @date 2011-11-02
	 */ 
	public String getBugContent() {
		bugID = Long.valueOf(FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap().get("bugId"));

		if (null == bugID) {
			try {
				String path = FacesContext.getCurrentInstance()
						.getExternalContext().getRequestContextPath();
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect(path + "/pages/work/bugmanager.faces");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			bugContent = this.serviceLocator.getBugService().queryBugById(bugID);
			
		}

		bugID = bugContent.getBugId();
		areaName = bugContent.getArea().getName();
		sewageName = bugContent.getSewage().getName();
		bugEquipment = bugContent.getBugEquipment();
		bugCondition = bugContent.getBugCondition();
		occurrenceTime = bugContent.getOccurrenceTime();
		bugState = bugContent.getBugState();
		bugCause = bugContent.getBugCause();
		repairCondition = bugContent.getRepairCondition();
		repairCost = bugContent.getRepairCost();
		finishTime = bugContent.getFinishTime();
		repairr = bugContent.getRepairr();
		accepter  = bugContent.getAccepter();
		operator = bugContent.getOperator();
		bugEquipment = bugContent.getBugEquipment();
		System.out.println(bugEquipment);
		return NavigationResults.BUGCONTENT;
	}
}
