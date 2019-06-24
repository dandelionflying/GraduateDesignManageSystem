package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.UserNoticeState;

public interface UserNoticeStateService {
	 	
	int deleteByPrimaryKey(Integer id);

	int insert(UserNoticeState record);

	UserNoticeState selectByPrimaryKey(Integer id);

	List<UserNoticeState> selectAll();

	int updateByPrimaryKey(UserNoticeState record);
}
