package com.running4light.gdms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.Topic;

public interface TopicService {
	List<Topic> getAllTopics();
	
	
	List<Topic> queryTopicByTag(int tag);
	
	List<Topic> getMyTopic(String teacherName);
	
	
	List<Topic> queryTopicByName(String topicName);
	
	
	String getContent(String topicId);
	
	boolean addTopic(Topic topic);
	
	
	String queryTopicNameByStudentId(String id);
	
	
	List<Topic> searchTopicByKey(String key);
	

	List<String> getTop10HotKeys();
	

	void modifyHotKey(String key);
	

	boolean searchKeyByName(String key);

	void addHotKey(String key);
	
	int updateTagById(int id,int tag);
	
	List<String> getName();
	
	List<Topic> queryPageByTagAndName(int tag,String key,Integer index,Integer page);


	List<Topic> queryPageByTag(Integer tag, Integer index, Integer page);


	Integer countTopicByTag(Integer tag);


	List<Topic> queryPageByTagAndNameAndType(Integer tag, String key, String classify, Integer index, Integer page);
	
	Integer countTopicByTagAndNameAndKey(Integer tag, String key, String classify);
	
	Integer countTopicByTagAndName(Integer tag, String key);
}
