package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.UserroleDao;
import com.running4light.gdms.pojo.Userrole;
import com.running4light.gdms.service.UserroleService;
@Service
@Transactional
public class UserroleServiceImpl implements UserroleService {
	@Autowired
	private UserroleDao userroleDao;
	@Override
	public int deleteByPrimaryKey(Byte id) {
		return userroleDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Userrole userrole) {
		return userroleDao.insert(userrole);
	}

	@Override
	public Userrole selectByPrimaryKey(Byte id) {
		return userroleDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Userrole> selectAll() {
		return userroleDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Userrole userrole) {
		return userroleDao.updateByPrimaryKey(userrole);
	}

	@Override
	public Userrole selectByUid(String uid) {
		return userroleDao.selectByUid(uid);
	}

}
