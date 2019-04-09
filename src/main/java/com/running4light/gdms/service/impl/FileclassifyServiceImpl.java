package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.FileclassifyDao;
import com.running4light.gdms.pojo.Fileclassify;
import com.running4light.gdms.service.FileclassifyService;
@Service
@Transactional
public class FileclassifyServiceImpl implements FileclassifyService{
	@Autowired
	private FileclassifyDao fileclassifyDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return fileclassifyDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Fileclassify record) {
		return fileclassifyDao.insert(record);
	}

	@Override
	public Fileclassify selectByPrimaryKey(Integer id) {
		
		return fileclassifyDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Fileclassify> selectAll() {
		return fileclassifyDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Fileclassify record) {
		int result = fileclassifyDao.updateByPrimaryKey(record);
		return 0;
	}

}
