package cn.zj.sunda.water.bean;

import java.util.List;

import javax.faces.FacesException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.zj.sunda.water.bo.Sysparam;

public class ApplicationBean extends BaseBean {
	//the logger for this class
	private Log logger = LogFactory.getLog(this.getClass());
		
	public ApplicationBean() {
	
		this.logger.debug("ApplicationBean is created");
	}
	protected void init() {
		try {
			this.logger.debug("Initializes ApplicationBean");
			List<Sysparam> list = this.serviceLocator.getSysparamService().queryAllSysparam();			
			
		} catch (Exception e) {
			String msg = "Could not initialize ApplicationBean " + e.toString();
			this.logger.error(msg);
			throw new FacesException(msg);
		}
		
		this.logger.debug("Application bean is initialized");
	}
}
