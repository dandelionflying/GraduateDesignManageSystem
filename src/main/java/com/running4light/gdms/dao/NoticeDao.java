package com.running4light.gdms.dao;

import com.running4light.gdms.pojo.Notice;
import java.util.List;
import java.util.Map;

public interface NoticeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAll(Map<String, Object> param);

    int updateByPrimaryKey(Notice notice);

	List<Notice> getNewNotice(Map<String, Object> param);
	
	Integer selectCount(Map<String, Object> param);
}