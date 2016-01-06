package cn.zj.sunda.water.bo;



/**
 * Rolemenu entity. @author MyEclipse Persistence Tools
 */

public class Rolemenu  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Menus menus;
     private Roles roles;


    // Constructors

    /** default constructor */
    public Rolemenu() {
    }

    
    /** full constructor */
    public Rolemenu(Menus menus, Roles roles) {
        this.menus = menus;
        this.roles = roles;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Menus getMenus() {
        return this.menus;
    }
    
    public void setMenus(Menus menus) {
        this.menus = menus;
    }

    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
   








}