package com.running4light.gdms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.TopicDao;
import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.TopicService;
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
		return topicDao.queryTopicByTeacherName(teacherName);
	}

	@Override
	public boolean addTopic(Topic topic) {
		String topicId= Integer.toString(new Random().nextInt(999999));
		topic.setId(topicId);
		return topicDao.addTopic(topic);
	}

	@Override
	public String queryTopicNameByStudentId(String sId) {
		return topicDao.queryTopicNameByStudentId(sId);
	}

	@Override
	public List<Topic> searchTopicByKey(String key) {
		return topicDao.queryTopicByKey(key);
	}

	@Override
	public List<String> getTop10HotKeys() {
		return topicDao.queryTop10Key();
	}

	@Override
	public void modifyHotKey(String key) {
		topicDao.updateHotKey(key);
		
	}

	@Override
	public boolean searchKeyByName(String key) {
		if(topicDao.queryKeyByName(key)==null)
			return false;
		else
			return true;
	}

	@Override
	public void addHotKey(String key) {
		topicDao.insertHotKey(key);
	}
	


	@Override
	public List<Topic> queryTopicByTag(int tag) {
		return topicDao.queryTopicByTag(tag);
	}

	@Override
	public List<Topic> queryTopicByName(String topicName) {
		return topicDao.queryTopicByName(topicName);
	}

	@Override
	public int updateTagById(int id, int tag) {
		return topicDao.updateTagById(id, tag);
	}

	@Override
	public List<String> getName() {
		return topicDao.queryNameOrderById();
	}

	@Override
	public List<Topic> queryPageByTagAndName(int tag, String key,Integer index,Integer page) {
		Map<String,Object> map = new HashMap<>();
		map.put("tag", tag);
		map.put("index", index*page);
		map.put("page", page);
		map.put("key", key);
		return topicDao.queryPageByTagAndName(map);
	}


	@Override
	public List<Topic> queryPageByTag(Integer tag, Integer index, Integer page) {
		Map<String,Object> map = new HashMap<>();
		map.put("tag", tag);
		map.put("index", index*page);
		map.put("page", page);
		return topicDao.queryPageByTag(map);
	}

	@Override
	public Integer countTopicByTag(Integer tag) {
		return topicDao.countTopicByTag(tag);
	}

	@Override
	public List<Topic> queryPageByTagAndNameAndType(Integer tag, String key, String classify, Integer index, Integer page) {
		Map<String,Object> map = new HashMap<>();
		map.put("tag", tag);
		map.put("key", key);
		map.put("classify", classify);
		map.put("index", index*page);
		map.put("page", page);
		return topicDao.queryPageByTagAndNameAndType(map);
	}

	@Override
	public Integer countTopicByTagAndNameAndKey(Integer tag, String key, String classify) {
		Map<String,Object> map = new HashMap<>();
		map.put("tag", tag);
		map.put("key", key);
		map.put("classify", classify);
		return topicDao.countTopicByTagAndNameAndKey(map);
	}
	@Override
	public Integer countTopicByTagAndName(Integer tag, String key) {
		Map<String,Object> map = new HashMap<>();
		map.put("tag", tag);
		map.put("key", key);
		return topicDao.countTopicByTagAndName(map);
	}
	
}
