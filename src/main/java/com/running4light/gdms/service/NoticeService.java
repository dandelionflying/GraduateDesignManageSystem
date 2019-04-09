package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Notice;

public interface NoticeService {
	int deleteByPrimaryKey(Integer id);

    int insert(Notice notice);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice notice);
}
