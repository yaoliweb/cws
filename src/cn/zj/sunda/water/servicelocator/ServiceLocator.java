package cn.zj.sunda.water.servicelocator;

import cn.zj.sunda.water.service.BugService;
import cn.zj.sunda.water.service.AdminService;
import cn.zj.sunda.water.service.AreaService;
import cn.zj.sunda.water.service.DayCollectService;
import cn.zj.sunda.water.service.DetectionDataService;
import cn.zj.sunda.water.service.DeviceDocService;
import cn.zj.sunda.water.service.EquipRepairRecordService;
import cn.zj.sunda.water.service.MenuService;
import cn.zj.sunda.water.service.MessagesService;
import cn.zj.sunda.water.service.RoleService;
import cn.zj.sunda.water.service.RunDataService;
import cn.zj.sunda.water.service.SewageService;
import cn.zj.sunda.water.service.StatisticsService;
import cn.zj.sunda.water.service.SysparamService;
import cn.zj.sunda.water.service.UserService;

public interface ServiceLocator {

	public UserService getUserService();
	public MenuService getMenuService();	
	public RoleService getRoleService();
	public BugService getBugService();
	public DayCollectService getDayCollectService();
	public SewageService getSewageService();
	public AreaService getAreaService();
	public DetectionDataService getDetectionDataService();
	public RunDataService getRunDataService();
	public AdminService getAdminService();
	public SysparamService getSysparamService();
	public MessagesService getMessagesService();
	public DeviceDocService getDeviceDocService();
	public EquipRepairRecordService getEquipRepairrecordService();
	public StatisticsService getStatisticsService();
}
