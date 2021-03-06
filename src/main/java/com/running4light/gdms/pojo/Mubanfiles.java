package com.running4light.gdms.pojo;

import java.io.Serializable;
import java.util.Date;

public class Mubanfiles implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mubanfiles.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mubanfiles.NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mubanfiles.URL
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mubanfiles.UPLOAD_TIME
     *
     * @mbggenerated
     */
    private Date uploadTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table mubanfiles
     *
     * @mbggenerated
     */
    
    private Short receiver;
    
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mubanfiles.ID
     *
     * @return the value of mubanfiles.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mubanfiles.ID
     *
     * @param id the value for mubanfiles.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mubanfiles.NAME
     *
     * @return the value of mubanfiles.NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mubanfiles.NAME
     *
     * @param name the value for mubanfiles.NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mubanfiles.URL
     *
     * @return the value of mubanfiles.URL
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mubanfiles.URL
     *
     * @param url the value for mubanfiles.URL
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mubanfiles.UPLOAD_TIME
     *
     * @return the value of mubanfiles.UPLOAD_TIME
     *
     * @mbggenerated
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mubanfiles.UPLOAD_TIME
     *
     * @param uploadTime the value for mubanfiles.UPLOAD_TIME
     *
     * @mbggenerated
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mubanfiles
     *
     * @mbggenerated
     */
    
    public Short getReceiver() {
    	return receiver;
    }
    
    public void setReceiver(Short receiver) {
    	this.receiver = receiver;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", receiver=").append(receiver);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

}