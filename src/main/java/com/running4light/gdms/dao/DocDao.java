package com.running4light.gdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.running4light.gdms.pojo.Docs;

@Repository
public interface DocDao {
	
	int deleteByPrimaryKey(Integer id);
	
	Docs selectByPrimaryKey(Integer id);
	
	List<Docs> selectAll();
	
	int updateByPrimaryKey(Docs record);
	
	public boolean insert(Docs newDoc);
	public List<Docs> getDocsBySid(@Param("uid")String uid);
	public String queryUrlById(int docId);
}
