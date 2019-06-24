package com.running4light.gdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.Manager;

public interface ManagerDao {

	Manager queryByIdAndPassword(@Param("id") String id, @Param("password") String password);
	
	int deleteByPrimaryKey(String id);

    int insert(Manager record);

    Manager selectByPrimaryKey(String id);

    List<Manager> selectAll();
    
    int updateByPrimaryKey(Manager record);
    
    String queryPasswordById(@Param("id") String id);

    String getEmailById(String uid);
}
