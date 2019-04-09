package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.St;

public interface StService {
	int deleteByPrimaryKey(Byte id);

    St selectByPrimaryKey(Byte id);

    List<St> selectAll();

    int updateByPrimaryKey(St record);

	int insert(String sid, String studentName, String topicId, String topicName);

	List<St> queryBySid(String key);

	List<St> queryPage(Integer index, Integer page);
	
	Integer countst();
}
