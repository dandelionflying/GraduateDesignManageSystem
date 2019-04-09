package com.running4light.gdms.service.impl;

import java.util.List;

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
	public List<Notice> selectAll() {
		return noticeDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Notice notice) {
		return noticeDao.updateByPrimaryKey(notice);
	}

}
