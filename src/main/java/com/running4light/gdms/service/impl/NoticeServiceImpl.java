package com.running4light.gdms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.NoticeDao;
import com.running4light.gdms.pojo.Notice;
import com.running4light.gdms.service.NoticeService;
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return noticeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Notice notice) {
		return noticeDao.insert(notice);
	}

	@Override
	public Notice selectByPrimaryKey(Integer id) {
		return noticeDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Notice> selectAll(Integer receiver) {
		Map<String,Object> param = new HashMap<>();
		param.put("receiver", receiver);
		return noticeDao.selectAll(param);
	}
	
	@Override
	public List<Notice> selectPage(Integer receiver,Integer index,Integer size) {
		Map<String,Object> param = new HashMap<>();
		param.put("receiver", receiver);
		param.put("index", index);
		param.put("page", size);
		return noticeDao.selectAll(param);
	}
	@Override
	public Integer selectCount(Integer receiver,Integer index,Integer size) {
		Map<String,Object> param = new HashMap<>();
		param.put("receiver", receiver);
		param.put("index", index);
		param.put("page", size);
		return noticeDao.selectCount(param);
	}

	@Override
	public int updateByPrimaryKey(Notice notice) {
		return noticeDao.updateByPrimaryKey(notice);
	}

	@Override
	public List<Notice> getNew(String uid, Integer count) {
		Map<String,Object> param = new HashMap<>();
		param.put("uid", uid);
		param.put("count", count);
		return noticeDao.getNewNotice(param);
	}

}
