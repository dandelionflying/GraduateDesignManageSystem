package gdms.service.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdms.dao.TopicDao;
import gdms.model.Topic;
import gdms.service.TopicService;
@Service
@Transactional
public class TopicServiceImpl implements TopicService{

	@Autowired
	private TopicDao topicDao;
	
	@Override
	public List<Topic> getAllTopics() {
		
		return topicDao.queryAllTopic();
	}

	@Override
	public String getContent(String topicId) {
		
		return topicDao.queryContentById(topicId);
	}

	@Override
	public List<Topic> getMyTopic(String teacherName) {
		return topicDao.queryTopicByTeacher(teacherName);
	}

	@Override
	public boolean addTopic(Topic topic) {
		String topicId= Integer.toString(new Random().nextInt(999999));
		topic.setTopicId(topicId);
		return topicDao.addTopic(topic);
	}

	@Override
	public String getTopicNameByStudent(String sId) {
		return topicDao.queryTopicNameByStudentName(sId);
	}

	@Override
	public List<Topic> searchTopicByKey(String key) {
		return topicDao.queryTopicByKey(key);
	}

}
