package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.RoleDao;
import com.running4light.gdms.pojo.Role;
import com.running4light.gdms.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	@Override
	public int deleteByPrimaryKey(Byte id) {
		return roleDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role role) {
		return roleDao.insert(role);
	}

	@Override
	public Role selectByPrimaryKey(Byte id) {
		return roleDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> selectAll() {
		return roleDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Role role) {
		return roleDao.updateByPrimaryKey(role);
	}

	@Override
	public String queryRolenameById(String uid) {
		return roleDao.queryRolenameById(uid);
	}

}
