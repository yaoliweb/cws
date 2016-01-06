package cn.zj.sunda.water.bo;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer areaId;
	private Integer superiorArea;
	private String name;
	private byte[] map;
	private String intro;
	private String principal;
	private String tel;
	private Double coordinateX;
	private Double coordinateY;
	private Set administrators = new HashSet(0);
	private Set dayCollects = new HashSet(0);
	private Set bugs = new HashSet(0);
	private Set sewages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(Integer superiorArea, String name, byte[] map, String intro,
			String principal, String tel, Set administrators, Set dayCollects,
			Set bugs, Set sewages) {
		this.superiorArea = superiorArea;
		this.name = name;
		this.map = map;
		this.intro = intro;
		this.principal = principal;
		this.tel = tel;
		this.administrators = administrators;
		this.dayCollects = dayCollects;
		this.bugs = bugs;
		this.sewages = sewages;
	}

	// Property accessors

	public Integer getAreaId() {
		return this.areaId;
	}

	public Double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(Double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public Double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(Double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getSuperiorArea() {
		return this.superiorArea;
	}

	public void setSuperiorArea(Integer superiorArea) {
		this.superiorArea = superiorArea;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getMap() {
		return this.map;
	}

	public void setMap(byte[] map) {
		this.map = map;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Set getAdministrators() {
		return this.administrators;
	}

	public void setAdministrators(Set administrators) {
		this.administrators = administrators;
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