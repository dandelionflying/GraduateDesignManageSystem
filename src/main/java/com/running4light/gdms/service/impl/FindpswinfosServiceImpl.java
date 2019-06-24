package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.FindpswinfosDao;
import com.running4light.gdms.pojo.Findpswinfos;
import com.running4light.gdms.service.FindpswinfosService;
@Service
@Transactional
public class FindpswinfosServiceImpl implements FindpswinfosService {
	@Autowired
	private FindpswinfosDao findpswinfosDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return findpswinfosDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Findpswinfos findpswinfos) {
		return findpswinfosDao.insert(findpswinfos);
	}

	@Override
	public Findpswinfos selectByPrimaryKey(Integer id) {
		return findpswinfosDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Findpswinfos> selectAll() {
		return findpswinfosDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Findpswinfos findpswinfos) {
		return findpswinfosDao.updateByPrimaryKey(findpswinfos);
	}

	@Override
	public Findpswinfos selectByUid(String uid) {
		return findpswinfosDao.selectByUid(uid);
	}

}
