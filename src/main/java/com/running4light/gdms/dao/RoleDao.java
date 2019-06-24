package com.running4light.gdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.Role;

public interface RoleDao {

    int deleteByPrimaryKey(Byte id);

    int insert(Role role);

    Role selectByPrimaryKey(Byte id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role role);
    
    String queryRolenameById(@Param("uid") String uid);
}