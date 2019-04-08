package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.running4light.gdms.dao.ManagerDao;
import com.running4light.gdms.pojo.Manager;
import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	@Override
	public Manager queryByIdAndPassword(String id, String password) {
		return managerDao.queryByIdAndPassword(id, password);
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		return managerDao.deleteByPrimaryKey(id);
	}
	@Override
	public int insert(Manager record) {
		return managerDao.insert(record);
	}
	@Override
	public Manager selectByPrimaryKey(String id) {
		return managerDao.selectByPrimaryKey(id);
	}
	@Override
	public List<Manager> selectAll() {
		return managerDao.selectAll();
	}
	@Override
	public int updateByPrimaryKey(Manager record) {
		return managerDao.updateByPrimaryKey(record);
	}
	@Override
	public String queryPasswordById(String id) {
		return managerDao.queryPasswordById(id);
	}
	

	

}
