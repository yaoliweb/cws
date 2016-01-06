package cn.zj.sunda.water.bean;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


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
import cn.zj.sunda.water.servicelocator.ServiceLocator;
import cn.zj.sunda.water.util.FacesUtils;

public class ServiceLocatorBean implements ServiceLocator {

	private static final String USER_SERVICE_BEAN_NAME = "userService";
	private static final String MENU_SERVICE_BEAN_NAME = "menuService";
	private static final String ROLE_SERVICE_BEAN_NAME = "roleService";
	private static final String DAYCOLLECT_SERVICE_BEAN_NAME = "dayCollectService";
	private static final String SEWAGE_SERVICE_BEAN_NAME = "sewageService";
	private static final String ADMIN_SERVICE_BEAN_NAME = "adminService";
	private static final String AREA_SERVICE_BEAN_NAME = "areaService";
	private static final String DETECTIONDATA_SERVICE_BEAN_NAME = "detectionDataService";
	private static final String RUNDATA_SERVICE_BEAN_NAME = "runDataService";
	private static final String SYSPARAM_SERVICE_BEAN_NAME="sysparamService";
	private static final String MESSAGES_SERVICE_BEAN_NAME="messagesService";
	private static final String BUG_SERVICE_BEAN_NAME=	"bugService";
	private static final String DEVICEDOC_SERVICE_BEAN_NAME=	"DeviceDocService";
	private static final String EQUIPREPAIR_SERVICE_BEAN_NAME=	"EquipRepairRecordService";
	private static final String STATISTICS_SERVICE_BEAN_NAME= "StatisticsService";
	
	// the logger for this class
	private Log logger = LogFactory.getLog(this.getClass());

	private ApplicationContext appContext;

	private AdminService adminService;
	
	private UserService userService;

	private MenuService menuService;

	private RoleService roleService;

	private DayCollectService dayCollectService;

	private SewageService sewageService;
	
	private BugService bugService;
	
	private AreaService areaService;

	private DetectionDataService detectionDataService;

	private RunDataService runDataService;

	private SysparamService sysparamService;
	
	private MessagesService messagesService;
	private DeviceDocService deviceDocService;
	private EquipRepairRecordService equipRepairRecordService;
	private StatisticsService StatisticsService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ServiceLocatorBean() {
		this.logger.info("Service locator bean is initialized");
		
		ServletContext context = FacesUtils.getServletContext();
		this.appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);

		this.userService = (UserService) this.lookupService(USER_SERVICE_BEAN_NAME);
		
		this.menuService = (MenuService) this.lookupService(MENU_SERVICE_BEAN_NAME);

		this.dayCollectService = (DayCollectService) this.lookupService(DAYCOLLECT_SERVICE_BEAN_NAME);

		this.roleService = (RoleService) this.lookupService(ROLE_SERVICE_BEAN_NAME);

		this.sewageService = (SewageService) this.lookupService(SEWAGE_SERVICE_BEAN_NAME);

		this.areaService = (AreaService) this.lookupService(AREA_SERVICE_BEAN_NAME);

		this.adminService = (AdminService) this.lookupService(ADMIN_SERVICE_BEAN_NAME);

		this.detectionDataService = (DetectionDataService) this.lookupService(DETECTIONDATA_SERVICE_BEAN_NAME);

		this.runDataService = (RunDataService) this.lookupService(RUNDATA_SERVICE_BEAN_NAME);
		
		this.sysparamService=(SysparamService)this.lookupService(SYSPARAM_SERVICE_BEAN_NAME);
		
		this.bugService =(BugService)this.lookupService(BUG_SERVICE_BEAN_NAME);

		this.messagesService =(MessagesService)this.lookupService(MESSAGES_SERVICE_BEAN_NAME);
		
		this.deviceDocService =(DeviceDocService)this.lookupService(DEVICEDOC_SERVICE_BEAN_NAME);
		
		this.equipRepairRecordService=(EquipRepairRecordService)this.lookupService(EQUIPREPAIR_SERVICE_BEAN_NAME);
		
        this.StatisticsService=(StatisticsService) this.lookupService(STATISTICS_SERVICE_BEAN_NAME);
        
		this.logger.info("Service locator bean is initialized");

	}

	public Object lookupService(String serviceBeanName) {
		return appContext.getBean(serviceBeanName);
	}
	
	public UserService getUserService() {
		return this.userService;
	}

	public MenuService getMenuService() {

		return this.menuService;
	}

	public RoleService getRoleService() {
		return this.roleService;
	}

	public BugService getBugService() {
		return this.bugService;
	}

	public DayCollectService getDayCollectService() {
		return this.dayCollectService;
	}

	public SewageService getSewageService() {

		return this.sewageService;
	}

	public AreaService getAreaService() {

		return this.areaService;
	}

	public DetectionDataService getDetectionDataService() {

		return this.detectionDataService;
	}

	public RunDataService getRunDataService() {
		return this.runDataService;
	}

	public AdminService getAdminService() {

		return this.adminService;
	}

	public SysparamService getSysparamService() {
		
		return this.sysparamService;
	}

	public MessagesService getMessagesService() {
		
		return this.messagesService;
	}
    public DeviceDocService getDeviceDocService() {
		
		return this.deviceDocService;
	}
	public EquipRepairRecordService getEquipRepairrecordService() {
		// TODO Auto-generated method stub
		return this.equipRepairRecordService;
	}
	public StatisticsService getStatisticsService() {
		return this.StatisticsService;
	}
}