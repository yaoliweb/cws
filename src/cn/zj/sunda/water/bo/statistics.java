package cn.zj.sunda.water.bo;

public class statistics implements java.io.Serializable  {
	private long id;
	private int sewageID;
	private String sewageName;
	private String year;
	private String month;
	private String day;
	private float waterflow;
	private float reduceCOD;
	private float reduceNH3N;
	private float reduceP;
	private int pumpRunTime;
	private float water;
	private float cod;
	private float nh3n;
	private float p;
	
	public statistics() {
		super();
		// TODO Auto-generated constructor stub
	}


	public statistics(long id, int sewageID, String sewageName, String year,
			String month, String day, float waterflow, float reduceCOD,
			float reduceNH3N, float reduceP, int pumpRunTime, float water,
			float cod, float nh3n, float p) {
		super();
		this.id = id;
		this.sewageID = sewageID;
		this.sewageName = sewageName;
		this.year = year;
		this.month = month;
		this.day = day;
		this.waterflow = waterflow;
		this.reduceCOD = reduceCOD;
		this.reduceNH3N = reduceNH3N;
		this.reduceP = reduceP;
		this.pumpRunTime = pumpRunTime;
		this.water = water;
		this.cod = cod;
		this.nh3n = nh3n;
		this.p = p;
	}


	public String getSewageName() {
		return sewageName;
	}


	public void setSewageName(String sewageName) {
		this.sewageName = sewageName;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSewageID() {
		return sewageID;
	}

	public void setSewageID(int sewageID) {
		this.sewageID = sewageID;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
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

	public int getPumpRunTime() {
		return pumpRunTime;
	}

	public void setPumpRunTime(int pumpRunTime) {
		this.pumpRunTime = pumpRunTime;
	}

	public float getWater() {
		return water;
	}

	public void setWater(float water) {
		this.water = water;
	}

	public float getCod() {
		return cod;
	}

	public void setCod(float cod) {
		this.cod = cod;
	}

	public float getNh3n() {
		return nh3n;
	}

	public void setNh3n(float nh3n) {
		this.nh3n = nh3n;
	}

	public float getP() {
		return p;
	}

	public void setP(float p) {
		this.p = p;
	}
	
}
