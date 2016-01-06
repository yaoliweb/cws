package cn.zj.sunda.water.bo;

import java.sql.Timestamp;
import java.util.Date;


/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message  implements java.io.Serializable {


    // Fields    

     private Long messageId;
     private String tel;
     private String messagedetail;
     private Date sendtime;


    // Constructors

    /** default constructor */
    public Message() {
    }

    
    /** full constructor */
    public Message(String tel, String messagedetail, Timestamp sendtime) {
        this.tel = tel;
        this.messagedetail = messagedetail;
        this.sendtime = sendtime;
    }

   
    // Property accessors

    public Long getMessageId() {
        return this.messageId;
    }
    
    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMessagedetail() {
        return this.messagedetail;
    }
    
    public void setMessagedetail(String messagedetail) {
        this.messagedetail = messagedetail;
    }

    public Date getSendtime() {
        return this.sendtime;
    }
    
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
   








}