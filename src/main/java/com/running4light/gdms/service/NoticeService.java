package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Notice;

public interface NoticeService {
	int deleteByPrimaryKey(Integer id);

    int insert(Notice notice);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAll(Integer receiver);

    List<Notice> selectPage(Integer receiver,Integer index,Integer page);
    
    int updateByPrimaryKey(Notice notice);

	List<Notice> getNew(String uid, Integer count);
	
	Integer selectCount(Integer receiver,Integer index,Integer page);
}
