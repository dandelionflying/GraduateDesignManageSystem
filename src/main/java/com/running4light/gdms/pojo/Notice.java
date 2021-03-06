package com.running4light.gdms.pojo;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.publish_time
     *
     * @mbggenerated
     */
    private Date publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.publisher
     *
     * @mbggenerated
     */
    private String publisher;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.dept_id
     *
     * @mbggenerated
     */
    private Short deptId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.to
     *
     * @mbggenerated
     */
    private Short receiver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table notice
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    public Notice() {
    	
    }
    public Notice(String content,Date publishTime,String publisher,Short deptId,Short receiver) {
		this.receiver = receiver;
		this.content = content;
		this.publishTime = publishTime;
		this.publisher = publisher;
		this.deptId = deptId;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.id
     *
     * @return the value of notice.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.id
     *
     * @param id the value for notice.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.publish_time
     *
     * @return the value of notice.publish_time
     *
     * @mbggenerated
     */
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.publish_time
     *
     * @param publishTime the value for notice.publish_time
     *
     * @mbggenerated
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.publisher
     *
     * @return the value of notice.publisher
     *
     * @mbggenerated
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.publisher
     *
     * @param publisher the value for notice.publisher
     *
     * @mbggenerated
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.dept_id
     *
     * @return the value of notice.dept_id
     *
     * @mbggenerated
     */
    public Short getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.dept_id
     *
     * @param deptId the value for notice.dept_id
     *
     * @mbggenerated
     */
    public void setDeptId(Short deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.to
     *
     * @return the value of notice.to
     *
     * @mbggenerated
     */
    public Short getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.to
     *
     * @param to the value for notice.to
     *
     * @mbggenerated
     */
    public void setReceiver(Short receiver) {
        this.receiver = receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table notice
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", content=").append(content);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", publisher=").append(publisher);
        sb.append(", deptId=").append(deptId);
        sb.append(", to=").append(receiver);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}