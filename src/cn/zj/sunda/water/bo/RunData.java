package cn.zj.sunda.water.bo;

import java.sql.Timestamp;


/**
 * RunData entity. @author MyEclipse Persistence Tools
 */

public class RunData  implements java.io.Serializable {


    // Fields    

     private Long runId;
     private Sewage sewage;
     private Timestamp testingtime;
     private Short equipment1state;
     private Short equipment2state;
     private Short equipment3state;
     private Short equipment4state;
     private Short equipment5state;


    // Constructors

    /** default constructor */
    public RunData() {
    }

    
    /** full constructor */
    public RunData(Sewage sewage, Timestamp testingtime, Short equipment1state, Short equipment2state, Short equipment3state, Short equipment4state, Short equipment5state) {
        this.sewage = sewage;
        this.testingtime = testingtime;
        this.equipment1state = equipment1state;
        this.equipment2state = equipment2state;
        this.equipment3state = equipment3state;
        this.equipment4state = equipment4state;
        this.equipment5state = equipment5state;
    }

   
    // Property accessors

    public Long getRunId() {
        return this.runId;
    }
    
    public void setRunId(Long runId) {
        this.runId = runId;
    }

    public Sewage getSewage() {
        return this.sewage;
    }
    
    public void setSewage(Sewage sewage) {
        this.sewage = sewage;
    }

    public Timestamp getTestingtime() {
        return this.testingtime;
    }
    
    public void setTestingtime(Timestamp testingtime) {
        this.testingtime = testingtime;
    }

    public Short getEquipment1state() {
        return this.equipment1state;
    }
    
    public void setEquipment1state(Short equipment1state) {
        this.equipment1state = equipment1state;
    }

    public Short getEquipment2state() {
        return this.equipment2state;
    }
    
    public void setEquipment2state(Short equipment2state) {
        this.equipment2state = equipment2state;
    }

    public Short getEquipment3state() {
        return this.equipment3state;
    }
    
    public void setEquipment3state(Short equipment3state) {
        this.equipment3state = equipment3state;
    }

    public Short getEquipment4state() {
        return this.equipment4state;
    }
    
    public void setEquipment4state(Short equipment4state) {
        this.equipment4state = equipment4state;
    }

    public Short getEquipment5state() {
        return this.equipment5state;
    }
    
    public void setEquipment5state(Short equipment5state) {
        this.equipment5state = equipment5state;
    }
   








}