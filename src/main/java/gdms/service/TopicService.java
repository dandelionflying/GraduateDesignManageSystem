package gdms.service;

import java.util.List;

import gdms.model.Topic;

public interface TopicService {
	List<Topic> getAllTopics();
	
	String getContent(String topicId);
	
	List<Topic> getMyTopic(String teacherName);
	
	boolean addTopic(Topic topic);
	
	String getTopicNameByStudent(String sId);
	
	List<Topic> searchTopicByKey(String key);
}
