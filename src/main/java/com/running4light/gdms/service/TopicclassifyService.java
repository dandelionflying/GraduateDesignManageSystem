package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Topicclassify;

public interface TopicclassifyService {
	int deleteByPrimaryKey(Integer id);

    int insert(Topicclassify record);

    Topicclassify selectByPrimaryKey(Integer id);

    List<Topicclassify> selectAll();

    int updateByPrimaryKey(Topicclassify record);
}
