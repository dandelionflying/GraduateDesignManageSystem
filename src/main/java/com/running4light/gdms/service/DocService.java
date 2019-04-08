package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Docs;

public interface DocService {
	int deleteByPrimaryKey(Integer id);
	
	Docs selectByPrimaryKey(Integer id);
	
	List<Docs> selectAll();
	
	int updateByPrimaryKey(Docs record);
	public boolean addDoc(Docs newDoc);
	public List<Docs> getDocsByUid(String uid);
	public String downloadById(int docId);
}
