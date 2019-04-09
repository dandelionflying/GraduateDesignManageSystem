package com.running4light.gdms.dao;

import java.util.List;

import com.running4light.gdms.pojo.States;

public interface StatesDao {
	int deleteByPrimaryKey(Integer id);

    int insert(States record);

    States selectByPrimaryKey(Integer id);

    List<States> selectAll();

    int updateByPrimaryKey(States record);
}
