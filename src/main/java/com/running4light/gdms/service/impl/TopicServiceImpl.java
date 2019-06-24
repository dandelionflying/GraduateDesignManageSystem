package com.running4light.gdms.service.impl;

import java.sql.Date;
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
	public Topic queryById(String id) {
		return topicDao.queryById(id);
	}
	@Override
	public int updateByPrimaryKey(Topic topic) {
		return topicDao.updateByPrimaryKey(topic);
	}
	@Override
	public List<Topic> getAllTopics() {
		
		return topicDao.queryAllTopic();
	}

	@Override
	public String getContent(String topicId) {
		
		return topicDao.queryContentById(topicId);
	}

	@Override
	public List<Topic> quetyPageMyTeacherName(Integer index,Integer page,String teacherName) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index*page);
		param.put("page", page);
		param.put("teacherName", teacherName);
		return topicDao.queryTopicByTeacherName(param);
	}

	@Override
	public boolean addTopic(Topic topic) {
		String topicId= Integer.toString(new Random().nextInt(999999));
		topic.setId(topicId);
		Date now = new Date(new java.util.Date().getTime());
		topic.setUploadTime(now);
		topic.setState("可选");
		topic.setTag(0);
		return topicDao.addTopic(topic);
	}

	@Override
	public String queryTopicNameByStudentId(String sId) {
		return topicDao.queryTopicNameByStudentId(sId);
	}

	@Override
	public List<Topic> searchTopicByKey(String key, Integer tag, Integer index, Integer page) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index);
		param.put("tag", tag);
		param.put("key", key);
		param.put("page", page);
		return topicDao.queryTopicByKey(param);
	}
	
	@Override
	public Integer countTopicByKey(String key, Integer tag) {
		Map<String,Object> param = new HashMap<>();
		param.put("tag", tag);
		param.put("key", key);
		return topicDao.countTopicByKey(param);
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
	@Override
	public Integer countTopicByTeacherName(String teacherName) {
		Map<String,Object> param = new HashMap<>();
		param.put("teacherName", teacherName);
		return topicDao.countTopicByTeacherName(param);
	}

	@Override
	public String queryNameById(String topicId) {
		Map<String,String> param = new HashMap<>();
		param.put("id", topicId);
		return topicDao.queryNameById(param);
	}

	@Override
	public String queryTeacherNameById(String topicId) {
		Map<String,String> param = new HashMap<>();
		param.put("id", topicId);
		return topicDao.queryTeacherNameById(param);
	}

	@Override
	public Topic queryTopicByStudentId(String uid) {
		Map<String,Object> param = new HashMap<>();
		param.put("uid",uid);
		return topicDao.queryTopicByStudentId(param);
	}

	@Override
	public Integer deleteByPrimaryKey(String topicId) {
		return topicDao.deleteByPrimaryKey(topicId);
	}
	@Override
	public int updateByTag(Integer tag) {
		return topicDao.updateByTag(tag);
	}

	
}
