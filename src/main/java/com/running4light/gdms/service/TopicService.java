package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Topic;

public interface TopicService {
	Topic queryById(String id);
	
	int updateByPrimaryKey(Topic topic);
	
	List<Topic> getAllTopics();
	
	
	List<Topic> queryTopicByTag(int tag);
	
	List<Topic> quetyPageMyTeacherName(Integer index,Integer page,String teacherName);
	
	
	List<Topic> queryTopicByName(String topicName);
	
	Topic queryTopicByStudentId(String uid);
	
	
	String getContent(String topicId);
	
	boolean addTopic(Topic topic);
	
	
	String queryTopicNameByStudentId(String id);
	
	
	List<Topic> searchTopicByKey(String key, Integer tag, Integer index, Integer page);
	
	Integer countTopicByKey(String key, Integer tag);

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

	Integer countTopicByTeacherName(String teacherName);
	
	String queryNameById(String topicId);
	
	String queryTeacherNameById(String topicId);
	
	Integer deleteByPrimaryKey(String topicId);
	
	int updateByTag(Integer tag);
}
