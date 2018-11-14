package gdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import gdms.model.Topic;

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

	List<Topic> queryTopicByTeacher(@Param("teacherName") String teacherName);

	String queryTopicNameByStudentName(@Param("sId") String sId);
	
	List<Topic> queryTopicByKey(@Param("key") String key);

	List<String> queryTop10Key();

	void updateHotKey(@Param("keyName") String key);

	String queryKeyByName(@Param("keyName") String key);

	void insertHotKey(String key);
	
	List<Topic> queryTopicByTag(@Param("tag") int tag);
}
