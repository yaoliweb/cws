package cn.zj.sunda.water.bo;

import java.util.HashSet;
import java.util.Set;

/**
 * Administrator entity. @author MyEclipse Persistence Tools
 */

public class Administrator implements java.io.Serializable {

	// Fields

	private Integer administratorId;
	private Area area;
	private String name;
	private String tel;
	private String adr;
	private String email;
	private Set dayCollects = new HashSet(0);
	private Set bugs = new HashSet(0);
	private Set sewages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Administrator() {
	}

	/** full constructor */
	public Administrator(Area area, String name, String tel, String adr,
			String email, Set dayCollects, Set bugs, Set sewages) {
		this.area = area;
		this.name = name;
		this.tel = tel;
		this.adr = adr;
		this.email = email;
		this.dayCollects = dayCollects;
		this.bugs = bugs;
		this.sewages = sewages;
	}

	// Property accessors

	public Integer getAdministratorId() {
		return this.administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdr() {
		return this.adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getDayCollects() {
		return this.dayCollects;
	}

	public void setDayCollects(Set dayCollects) {
		this.dayCollects = dayCollects;
	}

	public Set getBugs() {
		return this.bugs;
	}

	public void setBugs(Set bugs) {
		this.bugs = bugs;
	}

	public Set getSewages() {
		return this.sewages;
	}

	public void setSewages(Set sewages) {
		this.sewages = sewages;
	}

}