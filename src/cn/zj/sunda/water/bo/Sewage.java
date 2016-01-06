package cn.zj.sunda.water.bo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Sewage entity. @author MyEclipse Persistence Tools
 */

public class Sewage  implements java.io.Serializable {


    // Fields    
	private String statement;
	private int number;
	private String date;
	private Integer sewageId;
     private Area area;
     private Administrator administrator;
     private Integer controlId;
     private String shortTitle;
     private String name;
     private String address;
     private Double coordinateX;
     private Double coordinateY;
     private String equipment1state;
     private String equipment2state;
     private String equipment3state;
     private String equipment4state;
     private String equipment5state;
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
     private Float detection6;
     private Float detection6ul;
     private Float detection6dl;
     private String air_sched;
     private String water_sched;
     private String mud_sched;
     private String flow_sched;
     private String backup_sched;
     private String control_strategy;
     private String device_alert;
     ////////////////////////////////////
	 private float waterflow;
	 private float reduceCOD;
	 private float reduceNH3N;
	 private float reduceP;
	 ////////////////////////////////////
	 private float flow;
	 private float cod;
	 private float p;
	 private float nh3n;
     private Date confirmGratingTime;
     private int gratingDays;
     private String operationnum;
     private Integer controlMethod;
     private String time;
     private Date updatetime;



   

	
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getControlMethod() {
		return controlMethod;
	}
	public void setControlMethod(Integer controlMethod) {
		this.controlMethod = controlMethod;
	}
	public String getOperationnum() {
		return operationnum;
	}
	public void setOperationnum(String operationnum) {
		this.operationnum = operationnum;
	}

	private Set runDatas = new HashSet(0);
     private Set dayCollects = new HashSet(0);
     private Set detectionDatas = new HashSet(0);
     private Set bugs = new HashSet(0);
     
     public float getNh3n() {
		return nh3n;
	}
	public void setNh3n(float nh3n) {
		this.nh3n = nh3n;
	}
	public float getFlow() {
		return flow;
	}
	public void setFlow(float flow) {
		this.flow = flow;
	}
	public float getCod() {
		return cod;
	}
	public void setCod(float cod) {
		this.cod = cod;
	}
	public float getP() {
		return p;
	}
	public void setP(float p) {
		this.p = p;
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
	public Date getConfirmGratingTime() {
 		return confirmGratingTime;
 	}
 	public void setConfirmGratingTime(Date confirmGratingTime) {
 		this.confirmGratingTime = confirmGratingTime;
 	}
    public int getGratingDays() {
		return gratingDays;
	}
	public void setGratingDays(int gratingDays) {
		this.gratingDays = gratingDays;
	}
     public Integer getUserRole() {
		return UserRole;
	}


	public void setUserRole(Integer userRole) {
		UserRole = userRole;
	}

	private Integer UserRole;

    // Constructors

    /** default constructor */
    public Sewage() {
    }

    
    /** full constructor */
    public Sewage(Area area, Administrator administrator, Integer controlId, String shortTitle, String name, String address, Double coordinateX, Double coordinateY, String equipment1state, String equipment2state, String equipment3state, String equipment4state, String equipment5state, Float detection1, Float detection1ul, Float detection1dl, Float detection2, Float detection2ul, Float detection2dl, Float detection3ul, Float detection3, Float detection3dl, Float detection4, Float detection4ul, Float detection4dl, Float detection5, Float detection5ul, Float detection5dl, Float detection6, Float detection6ul, Float detection6dl, Set runDatas, Set dayCollects, Set detectionDatas, Set bugs) {
        this.area = area;
        this.administrator = administrator;
        this.controlId = controlId;
        this.shortTitle = shortTitle;
        this.name = name;
        this.address = address;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.equipment1state = equipment1state;
        this.equipment2state = equipment2state;
        this.equipment3state = equipment3state;
        this.equipment4state = equipment4state;
        this.equipment5state = equipment5state;
        this.detection1 = detection1;
        this.detection1ul = detection1ul;
        this.detection1dl = detection1dl;
        this.detection2 = detection2;
        this.detection2ul = detection2ul;
        this.detection2dl = detection2dl;
        this.detection3ul = detection3ul;
        this.detection3 = detection3;
        this.detection3dl = detection3dl;
        this.detection4 = detection4;
        this.detection4ul = detection4ul;
        this.detection4dl = detection4dl;
        this.detection5 = detection5;
        this.detection5ul = detection5ul;
        this.detection5dl = detection5dl;
        this.detection6 = detection6;
        this.detection6ul = detection6ul;
        this.detection6dl = detection6dl;
        this.runDatas = runDatas;
        this.dayCollects = dayCollects;
        this.detectionDatas = detectionDatas;
        this.bugs = bugs;
    }

   
    // Property accessors

    public Integer getSewageId() {
        return this.sewageId;
    }
    
    public void setSewageId(Integer sewageId) {
        this.sewageId = sewageId;
    }

    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }

    public Administrator getAdministrator() {
        return this.administrator;
    }
    
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Integer getControlId() {
        return this.controlId;
    }
    
    public void setControlId(Integer controlId) {
        this.controlId = controlId;
    }

    public String getShortTitle() {
        return this.shortTitle;
    }
    
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public Double getCoordinateX() {
        return this.coordinateX;
    }
    
    public void setCoordinateX(Double coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Double getCoordinateY() {
        return this.coordinateY;
    }
    
    public void setCoordinateY(Double coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getEquipment1state() {
        return this.equipment1state;
    }
    
    public void setEquipment1state(String equipment1state) {
        this.equipment1state = equipment1state;
    }

    public String getEquipment2state() {
        return this.equipment2state;
    }
    
    public void setEquipment2state(String equipment2state) {
        this.equipment2state = equipment2state;
    }

    public String getEquipment3state() {
        return this.equipment3state;
    }
    
    public void setEquipment3state(String equipment3state) {
        this.equipment3state = equipment3state;
    }

    public String getEquipment4state() {
        return this.equipment4state;
    }
    
    public void setEquipment4state(String equipment4state) {
        this.equipment4state = equipment4state;
    }

    public String getEquipment5state() {
        return this.equipment5state;
    }
    
    public void setEquipment5state(String equipment5state) {
        this.equipment5state = equipment5state;
    }

    public Float getDetection1() {
        return this.detection1;
    }
    
    public void setDetection1(Float detection1) {
        this.detection1 = detection1;
    }

    public Float getDetection1ul() {
        return this.detection1ul;
    }
    
    public void setDetection1ul(Float detection1ul) {
        this.detection1ul = detection1ul;
    }

    public Float getDetection1dl() {
        return this.detection1dl;
    }
    
    public void setDetection1dl(Float detection1dl) {
        this.detection1dl = detection1dl;
    }

    public Float getDetection2() {
        return this.detection2;
    }
    
    public void setDetection2(Float detection2) {
        this.detection2 = detection2;
    }

    public Float getDetection2ul() {
        return this.detection2ul;
    }
    
    public void setDetection2ul(Float detection2ul) {
        this.detection2ul = detection2ul;
    }

    public Float getDetection2dl() {
        return this.detection2dl;
    }
    
    public void setDetection2dl(Float detection2dl) {
        this.detection2dl = detection2dl;
    }

    public Float getDetection3ul() {
        return this.detection3ul;
    }
    
    public void setDetection3ul(Float detection3ul) {
        this.detection3ul = detection3ul;
    }

    public Float getDetection3() {
        return this.detection3;
    }
    
    public void setDetection3(Float detection3) {
        this.detection3 = detection3;
    }

    public Float getDetection3dl() {
        return this.detection3dl;
    }
    
    public void setDetection3dl(Float detection3dl) {
        this.detection3dl = detection3dl;
    }

    public Float getDetection4() {
        return this.detection4;
    }
    
    public void setDetection4(Float detection4) {
        this.detection4 = detection4;
    }

    public Float getDetection4ul() {
        return this.detection4ul;
    }
    
    public void setDetection4ul(Float detection4ul) {
        this.detection4ul = detection4ul;
    }

    public Float getDetection4dl() {
        return this.detection4dl;
    }
    
    public void setDetection4dl(Float detection4dl) {
        this.detection4dl = detection4dl;
    }

    public Float getDetection5() {
        return this.detection5;
    }
    
    public void setDetection5(Float detection5) {
        this.detection5 = detection5;
    }

    public Float getDetection5ul() {
        return this.detection5ul;
    }
    
    public void setDetection5ul(Float detection5ul) {
        this.detection5ul = detection5ul;
    }

    public Float getDetection5dl() {
        return this.detection5dl;
    }
    
    public void setDetection5dl(Float detection5dl) {
        this.detection5dl = detection5dl;
    }

    public Float getDetection6() {
        return this.detection6;
    }
    
    public void setDetection6(Float detection6) {
        this.detection6 = detection6;
    }

    public Float getDetection6ul() {
        return this.detection6ul;
    }
    
    public void setDetection6ul(Float detection6ul) {
        this.detection6ul = detection6ul;
    }

    public Float getDetection6dl() {
        return this.detection6dl;
    }
    
    public void setDetection6dl(Float detection6dl) {
        this.detection6dl = detection6dl;
    }

    public Set getRunDatas() {
        return this.runDatas;
    }
    
    public void setRunDatas(Set runDatas) {
        this.runDatas = runDatas;
    }

    public Set getDayCollects() {
        return this.dayCollects;
    }
    
    public void setDayCollects(Set dayCollects) {
        this.dayCollects = dayCollects;
    }

    public Set getDetectionDatas() {
        return this.detectionDatas;
    }
    
    public void setDetectionDatas(Set detectionDatas) {
        this.detectionDatas = detectionDatas;
    }

    public Set getBugs() {
        return this.bugs;
    }
    
    public void setBugs(Set bugs) {
        this.bugs = bugs;
    }


	public void setAir_sched(String air_sched) {
		this.air_sched = air_sched;
	}


	public String getAir_sched() {
		return air_sched;
	}


	public void setWater_sched(String water_sched) {
		this.water_sched = water_sched;
	}


	public String getWater_sched() {
		return water_sched;
	}


	public void setMud_sched(String mud_sched) {
		this.mud_sched = mud_sched;
	}


	public String getMud_sched() {
		return mud_sched;
	}


	public void setFlow_sched(String flow_sched) {
		this.flow_sched = flow_sched;
	}


	public String getFlow_sched() {
		return flow_sched;
	}


	public void setBackup_sched(String backup_sched) {
		this.backup_sched = backup_sched;
	}


	public String getBackup_sched() {
		return backup_sched;
	}


	public void setControl_strategy(String control_strategy) {
		this.control_strategy = control_strategy;
	}


	public String getControl_strategy() {
		return control_strategy;
	}
	public void setDevice_alert(String device_alert) {
		this.device_alert = device_alert;
	}
	public String getDevice_alert() {
		return device_alert;
	}
   








}