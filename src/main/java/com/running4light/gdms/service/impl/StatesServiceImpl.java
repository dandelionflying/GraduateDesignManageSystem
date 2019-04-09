package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.StatesDao;
import com.running4light.gdms.pojo.States;
import com.running4light.gdms.service.StatesService;
@Service
@Transactional
public class StatesServiceImpl implements StatesService {
	
	@Autowired
	private StatesDao statesDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return statesDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(States record) {
		return statesDao.insert(record);
	}

	@Override
	public States selectByPrimaryKey(Integer id) {
		return statesDao.selectByPrimaryKey(id);
	}

	@Override
	public List<States> selectAll() {
		return statesDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(States record) {
		return statesDao.updateByPrimaryKey(record);
	}

}
