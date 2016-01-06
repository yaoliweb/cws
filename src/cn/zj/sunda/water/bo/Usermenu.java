package cn.zj.sunda.water.bo;



/**
 * Usermenu entity. @author MyEclipse Persistence Tools
 */

public class Usermenu  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Menus menus;
     private Csusers csusers;


    // Constructors

    /** default constructor */
    public Usermenu() {
    }

    
    /** full constructor */
    public Usermenu(Menus menus, Csusers csusers) {
        this.menus = menus;
        this.csusers = csusers;
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

    public Csusers getCsusers() {
        return this.csusers;
    }
    
    public void setCsusers(Csusers csusers) {
        this.csusers = csusers;
    }
   








}