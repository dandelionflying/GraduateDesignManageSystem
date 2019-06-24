package com.running4light.gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.DepartmentDao;
import com.running4light.gdms.pojo.Department;
import com.running4light.gdms.service.DepartmentService;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public Integer deleteByPrimaryKey(Short id) {
		// TODO Auto-generated method stub
		return departmentDao.deleteByPrimaryKey(id);
	}

	@Override
	public Integer insert(Department record) {
		// TODO Auto-generated method stub
		return departmentDao.insert(record);
	}

	@Override
	public Department selectByPrimaryKey(Short id) {
		// TODO Auto-generated method stub
		return departmentDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> selectAll() {
		// TODO Auto-generated method stub
		return departmentDao.selectAll();
	}

	@Override
	public Integer updateByPrimaryKey(Department record) {
		// TODO Auto-generated method stub
		return departmentDao.updateByPrimaryKey(record);
	}
	@Override
	public String queryNameById(Short deptId) {
		return departmentDao.queryNameById(deptId);
	}

}
