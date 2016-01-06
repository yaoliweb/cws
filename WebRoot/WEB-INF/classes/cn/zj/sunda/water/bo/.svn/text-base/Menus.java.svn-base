package cn.zj.sunda.water.bo;

import java.util.HashSet;
import java.util.Set;


/**
 * Menus entity. @author MyEclipse Persistence Tools
 */

public class Menus  implements java.io.Serializable {


    // Fields    

     private Integer menuid;
     private String location;
     private String name;
     private String filename;
     private String type;
     private boolean selected;
     private Set rolemenus = new HashSet(0);
     private Set usermenus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Menus() {
    }

    
    /** full constructor */
    public Menus(String location, String name, String filename, String type, Set rolemenus, Set usermenus) {
        this.location = location;
        this.name = name;
        this.filename = filename;
        this.type = type;
        this.rolemenus = rolemenus;
        this.usermenus = usermenus;
    }

   
    // Property accessors

    public Integer getMenuid() {
        return this.menuid;
    }
    
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return this.filename;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public Set getRolemenus() {
        return this.rolemenus;
    }
    
    public void setRolemenus(Set rolemenus) {
        this.rolemenus = rolemenus;
    }

    public Set getUsermenus() {
        return this.usermenus;
    }
    
    public void setUsermenus(Set usermenus) {
        this.usermenus = usermenus;
    }
   








}