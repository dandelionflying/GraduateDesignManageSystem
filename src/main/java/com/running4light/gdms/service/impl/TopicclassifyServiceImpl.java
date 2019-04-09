package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.TopicclassifyDao;
import com.running4light.gdms.pojo.Topicclassify;
import com.running4light.gdms.service.TopicclassifyService;
@Service
@Transactional
public class TopicclassifyServiceImpl implements TopicclassifyService {
	@Autowired
	private TopicclassifyDao topicclassifyDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return topicclassifyDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Topicclassify record) {
		return topicclassifyDao.insert(record);
	}

	@Override
	public Topicclassify selectByPrimaryKey(Integer id) {
		return topicclassifyDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Topicclassify> selectAll() {
		return topicclassifyDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Topicclassify record) {
		return topicclassifyDao.updateByPrimaryKey(record);
	}

}
