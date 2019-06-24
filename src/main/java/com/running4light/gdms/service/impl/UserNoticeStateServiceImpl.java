package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.running4light.gdms.dao.UserNoticeStateDao;
import com.running4light.gdms.pojo.UserNoticeState;
import com.running4light.gdms.service.UserNoticeStateService;
@Service
public class UserNoticeStateServiceImpl implements UserNoticeStateService{
	@Autowired
	private UserNoticeStateDao userNoticesStateDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userNoticesStateDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(UserNoticeState record) {
		return userNoticesStateDao.insert(record);
	}

	@Override
	public UserNoticeState selectByPrimaryKey(Integer id) {
		return userNoticesStateDao.selectByPrimaryKey(id);
	}

	@Override
	public List<UserNoticeState> selectAll() {
		return userNoticesStateDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(UserNoticeState record) {
		return userNoticesStateDao.updateByPrimaryKey(record);
	}
	
}
