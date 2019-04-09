package com.running4light.gdms.dao;

import com.running4light.gdms.pojo.Notice;
import java.util.List;

public interface NoticeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    Notice selectByPrimaryKey(Integer id);

    List<Notice> selectAll();

    int updateByPrimaryKey(Notice notice);
}