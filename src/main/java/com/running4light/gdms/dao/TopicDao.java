package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.running4light.gdms.pojo.Topic;

@Repository
public interface TopicDao {

	List<Topic> queryAllTopic();

	List<Topic> queryTopicByName(@Param("topicName") String topicName);

	/*
	 * Topic addTopic(@Param("topic_name") String topicName, @Param("content")
	 * String content,
	 * 
	 * @Param("topic_type") String topicType,@Param("demand") String demand);
	 */
	boolean addTopic(Topic topic);
	
	String queryContentById(@Param("topicId") String topicId);
	
	List<Topic> queryTopicByTeacherName(@Param("teacherName") String teacherName);

	String queryTopicNameByStudentId(@Param("id") String id);
	
	List<Topic> queryTopicByKey(@Param("key") String key);
	
	List<String> queryTop10Key();

	void updateHotKey(@Param("keyName") String key);

	String queryKeyByName(@Param("keyName") String key);

	void insertHotKey(String key);
	
	List<Topic> queryTopicByTag(@Param("tag") int tag);
	
	int updateTagById(@Param("id") int id,@Param("tag") int tag);
	
	List<String> queryNameOrderById();
	
	List<Topic> queryPageByTagAndName(Map<String, Object> map);

//	List<Topic> queryTopicByTagAndNameAndType(@Param("tag") int tag, @Param("key") String key, @Param("classify") String topicType);

	List<Topic> queryPageByTag(Map<String, Object> map);

	Integer countTopicByTag(Integer tag);

	List<Topic> queryPageByTagAndNameAndType(Map<String, Object> map);
	
	Integer countTopicByTagAndNameAndKey(Map<String,Object> map);
	
	Integer countTopicByTagAndName(Map<String,Object> map);
}
