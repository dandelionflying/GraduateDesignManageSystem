package com.running4light.gdms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.Manager;

public interface ManagerService {

	Manager queryByIdAndPassword(String id, String password);

	int deleteByPrimaryKey(String id);

    int insert(Manager record);

    Manager selectByPrimaryKey(String id);

    List<Manager> selectAll();
    
    int updateByPrimaryKey(Manager record);
    
    String queryPasswordById(@Param("id") String id);

}
