package com.running4light.gdms.pojo;

import java.io.Serializable;

public class Findpswinfos implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column findpswinfos.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column findpswinfos.UID
     *
     * @mbggenerated
     */
    private String uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column findpswinfos.TIMEOUT
     *
     * @mbggenerated
     */
    private Long timeout;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column findpswinfos.TOKEN
     *
     * @mbggenerated
     */
    private String token;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table findpswinfos
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column findpswinfos.ID
     *
     * @return the value of findpswinfos.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column findpswinfos.ID
     *
     * @param id the value for findpswinfos.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column findpswinfos.UID
     *
     * @return the value of findpswinfos.UID
     *
     * @mbggenerated
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column findpswinfos.UID
     *
     * @param uid the value for findpswinfos.UID
     *
     * @mbggenerated
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column findpswinfos.TIMEOUT
     *
     * @return the value of findpswinfos.TIMEOUT
     *
     * @mbggenerated
     */
    public Long getTimeout() {
        return timeout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column findpswinfos.TIMEOUT
     *
     * @param timeout the value for findpswinfos.TIMEOUT
     *
     * @mbggenerated
     */
    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column findpswinfos.TOKEN
     *
     * @return the value of findpswinfos.TOKEN
     *
     * @mbggenerated
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column findpswinfos.TOKEN
     *
     * @param token the value for findpswinfos.TOKEN
     *
     * @mbggenerated
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table findpswinfos
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
        sb.append(", uid=").append(uid);
        sb.append(", timeout=").append(timeout);
        sb.append(", token=").append(token);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}