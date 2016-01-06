package cn.zj.sunda.water.bean;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import cn.zj.sunda.water.bo.Administrator;
import cn.zj.sunda.water.bo.Area;
import cn.zj.sunda.water.bo.Message;
import cn.zj.sunda.water.util.FacesUtils;


public class MessageBean extends BaseBean{

	private static final String AREAITEM = "请选择区县";
	private static final String MANAGERITEM = "请选择管理员";
	private String delDataIDStr;

	public String getDelDataIDStr() {
		return delDataIDStr;
	}

	public void setDelDataIDStr(String delDataIDStr) {
		this.delDataIDStr = delDataIDStr;
	}

	public DataModel wraplistDataModel = new ListDataModel();

	public DataModel getWraplistDataModel() {
		List<Message> list = this.serviceLocator.getMessagesService().queryAllMessages();
		wraplistDataModel.setWrappedData(list);
		return wraplistDataModel;
	}

	public void setWraplistDataModel(DataModel wraplistDataModel) {
		this.wraplistDataModel = wraplistDataModel;
	}
	
	private SelectItem[] areaItem;
	private String areaSelectIndex;	
	private String areaSelectName;
	
	public String getAreaSelectIndex() {
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String areaSessionSelectIndex = (String)session.getAttribute("areaSelectIndex");
		
		if (areaSessionSelectIndex == null) {
			return areaSelectIndex;
		} else {
			areaSelectName = areaItem[Integer.valueOf(areaSessionSelectIndex)].getLabel();
			areaSelectIndex = areaSessionSelectIndex;
			return areaSelectIndex;
		}
	}
	public void setAreaSelectIndex(String areaSelectIndex) {
		this.areaSelectIndex = areaSelectIndex;
	}
	
	public String getAreaSelectName() {
		return areaSelectName;
	}
	public void setAreaSelectName(String areaSelectName) {
		this.areaSelectName = areaSelectName;
	}
	public SelectItem[] getAreaItem() {
		List<Area> list = this.serviceLocator.getAreaService().queryAllArea();
		areaItem = new SelectItem[list.size()+1];
		areaItem[0]=new SelectItem(0, AREAITEM);
		for (int i = 1; i <= list.size(); i++) {
			areaItem[i] = new SelectItem(i,list.get(i-1).getName());
		}		
		return areaItem;
	}
	public void setAreaItem(SelectItem[] areaItem) {
		this.areaItem = areaItem;
	}
	public void valuechange_area()
	{
		this.areaSelectName = areaItem[Integer.valueOf(this.areaSelectIndex)].getLabel();
		//this.managerSelectIndex="-1";
		HttpSession session =(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("areaSelectName", areaSelectName);
		session.setAttribute("areaSelectIndex", areaSelectIndex);		
	}
	private SelectItem[] managerItem;
	private String managerSelectIndex;
	private String manageSelectName;
	private String managerTel;
	public SelectItem[] getManagerItem() {
		if((areaSelectName==null)||(areaSelectName==AREAITEM))
		{
			managerItem = new SelectItem[1];
			managerItem[0]=new SelectItem(0,MANAGERITEM);
		}
		else
		{
			Area area = this.serviceLocator.getAreaService().queryAreaByName(areaSelectName);
			Integer areaId = area.getAreaId();
			String condition = "areaID = '"+areaId+"'";
			List<Administrator> list = this.serviceLocator.getAdminService().queryAdministratorByCondition(condition);
			managerItem = new SelectItem[list.size()+1];
			managerItem[0]=new SelectItem(0,MANAGERITEM);
			for (int i = 1; i <= list.size(); i++) {
				managerItem[i] = new SelectItem(i,list.get(i-1).getName()+"--"+list.get(i-1).getTel());
			}
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
	
	public String getManagerTel() {
		return managerTel;
	}

	public void setManagerTel(String managerTel) {
		this.managerTel = managerTel;
	}

	public void valuechange_manager()
	{
		this.manageSelectName = managerItem[Integer.valueOf(this.managerSelectIndex)].getLabel();
		
		this.managerSelectIndex="-1";
	}
	
	 private Long messageId;
     private String tel;
     private String messagedetail;
     private Date sendtime;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMessagedetail() {
		return messagedetail;
	}

	public void setMessagedetail(String messagedetail) {
		this.messagedetail = messagedetail;
	}

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public void saveMessage()
	{
		String[] sendTel_A = null;
		String sendTel = null;
		if(manageSelectName == null) {
			sendTel = null;
		} else {
			sendTel_A = manageSelectName.split("--");
			sendTel = sendTel_A[1];
		}
		
		if(sendTel != null)
		{
			/*SendMessage sendMessages = new SendMessage();
			try {
				sendMessages.doIt(sendTel, messagedetail);
			} catch (Exception e) {
				FacesUtils.addErrorMessage("发送失败，请检查设备通信状态！");
				e.printStackTrace();				
			}*/
			Message message = new Message();
			message.setMessagedetail(messagedetail);
			message.setTel(sendTel);
			message.setSendtime(new Date());
			this.serviceLocator.getMessagesService().SaveMessages(message);
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
	        String bundleName = context.getApplication().getMessageBundle();
	        ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName,context.getViewRoot().getLocale(),Thread.currentThread().getContextClassLoader());
	        String prompt = messageBundle.getString("telnull");
			FacesUtils.addErrorMessage(prompt);
		}
		
	}
	
//    public void validate(FacesContext context, UIComponent component, Object obj) throws ValidatorException{  
//        String managerSelectIndex = (String)obj;
//        manageSelectName = managerItem[Integer.valueOf(managerSelectIndex)].getLabel();
//        if(manageSelectName.equals(MANAGERITEM)){  
//            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "请选择管理员","请选择管理员！");  
//            throw new ValidatorException(message);  
//            }  
//        } 	
     
}
