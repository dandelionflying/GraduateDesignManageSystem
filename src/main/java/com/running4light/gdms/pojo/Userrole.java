package com.running4light.gdms.pojo;

import java.io.Serializable;

public class Userrole implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrole.ID
     *
     * @mbggenerated
     */
    private Byte id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrole.UID
     *
     * @mbggenerated
     */
    private String uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column userrole.RID
     *
     * @mbggenerated
     */
    private Byte rid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table userrole
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrole.ID
     *
     * @return the value of userrole.ID
     *
     * @mbggenerated
     */
    public Byte getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrole.ID
     *
     * @param id the value for userrole.ID
     *
     * @mbggenerated
     */
    public void setId(Byte id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrole.UID
     *
     * @return the value of userrole.UID
     *
     * @mbggenerated
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrole.UID
     *
     * @param uid the value for userrole.UID
     *
     * @mbggenerated
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column userrole.RID
     *
     * @return the value of userrole.RID
     *
     * @mbggenerated
     */
    public Byte getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column userrole.RID
     *
     * @param rid the value for userrole.RID
     *
     * @mbggenerated
     */
    public void setRid(Byte rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userrole
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
        sb.append(", rid=").append(rid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}