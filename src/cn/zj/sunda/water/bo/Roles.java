package cn.zj.sunda.water.bo;

import java.util.HashSet;
import java.util.Set;


/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles  implements java.io.Serializable {


    // Fields    

     private Integer roleid;
     private String name;
     private Set userroles = new HashSet(0);
     private Set rolemenus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Roles() {
    }

    
    /** full constructor */
    public Roles(String name, Set userroles, Set rolemenus) {
        this.name = name;
        this.userroles = userroles;
        this.rolemenus = rolemenus;
    }

   
    // Property accessors

    public Integer getRoleid() {
        return this.roleid;
    }
    
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getUserroles() {
        return this.userroles;
    }
    
    public void setUserroles(Set userroles) {
        this.userroles = userroles;
    }

    public Set getRolemenus() {
        return this.rolemenus;
    }
    
    public void setRolemenus(Set rolemenus) {
        this.rolemenus = rolemenus;
    }
   








}