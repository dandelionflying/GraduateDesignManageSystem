package com.running4light.gdms.dao;

import com.running4light.gdms.pojo.Userrole;
import java.util.List;

public interface UserroleDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userrole
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Byte id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userrole
     *
     * @mbggenerated
     */
    int insert(Userrole userrole);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userrole
     *
     * @mbggenerated
     */
    Userrole selectByPrimaryKey(Byte id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userrole
     *
     * @mbggenerated
     */
    List<Userrole> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userrole
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Userrole userrole);
    
    Userrole selectByUid(String uid);
}