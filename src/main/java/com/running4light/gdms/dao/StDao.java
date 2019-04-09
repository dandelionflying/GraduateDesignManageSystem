package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.St;

public interface StDao {

	int deleteByPrimaryKey(Byte id);

    int insert(St record);

    St selectByPrimaryKey(Byte id);

    List<St> selectAll();

    int updateByPrimaryKey(St record);
    
    List<St> queryBySid(@Param("key") String key);

	List<St> queryPage(Map<String, Object> map);
	
	Integer countst();
}