package cn.zj.sunda.water.bo;



/**
 * Userrole entity. @author MyEclipse Persistence Tools
 */

public class Userrole  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Csusers csusers;
     private Roles roles;


    // Constructors

    /** default constructor */
    public Userrole() {
    }

    
    /** full constructor */
    public Userrole(Csusers csusers, Roles roles) {
        this.csusers = csusers;
        this.roles = roles;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Csusers getCsusers() {
        return this.csusers;
    }
    
    public void setCsusers(Csusers csusers) {
        this.csusers = csusers;
    }

    public Roles getRoles() {
        return this.roles;
    }
    
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
   








}