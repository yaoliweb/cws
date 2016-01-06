package cn.zj.sunda.water.bo;

import java.util.HashSet;
import java.util.Set;


/**
 * Csusers entity. @author MyEclipse Persistence Tools
 */

public class Csusers  implements java.io.Serializable {


    // Fields    

     private Integer userid;
     private String logid;
     private String logpass;
     private String name;
     private String dept;
     private String tel;
     private Set userroles = new HashSet(0);
     private Set usermenus = new HashSet(0);


    // Constructors

    /** default constructor */
    public Csusers() {
    }

    
    /** full constructor */
    public Csusers(String logid, String logpass, String name, String dept, String tel, Set userroles, Set usermenus) {
        this.logid = logid;
        this.logpass = logpass;
        this.name = name;
        this.dept = dept;
        this.tel = tel;
        this.userroles = userroles;
        this.usermenus = usermenus;
    }

   
    // Property accessors

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLogid() {
        return this.logid;
    }
    
    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getLogpass() {
        return this.logpass;
    }
    
    public void setLogpass(String logpass) {
        this.logpass = logpass;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return this.dept;
    }
    
    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Set getUserroles() {
        return this.userroles;
    }
    
    public void setUserroles(Set userroles) {
        this.userroles = userroles;
    }

    public Set getUsermenus() {
        return this.usermenus;
    }
    
    public void setUsermenus(Set usermenus) {
        this.usermenus = usermenus;
    }
   








}