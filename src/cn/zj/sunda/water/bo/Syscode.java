package cn.zj.sunda.water.bo;



/**
 * Syscode entity. @author MyEclipse Persistence Tools
 */

public class Syscode  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String type;
     private String code;
     private String name;
     private String note;


    // Constructors

    /** default constructor */
    public Syscode() {
    }

    
    /** full constructor */
    public Syscode(String type, String code, String name, String note) {
        this.type = type;
        this.code = code;
        this.name = name;
        this.note = note;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return this.code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
   








}