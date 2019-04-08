package com.running4light.gdms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.TeacherDao;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.pojo.Teacher;
import com.running4light.gdms.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	

	@Override
	public int deleteByPrimaryKey(String id) {
		return teacherDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Teacher record) {
		return teacherDao.insert(record);
	}

	@Override
	public Teacher selectByPrimaryKey(String id) {
		return teacherDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Teacher> selectAll() {
		return teacherDao.selectAll();
	}
	
	@Override
	public List<Teacher> selectPage(Integer index,Integer page) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index*page);
		param.put("page", page);
		return teacherDao.selectPage(param);
	}

	@Override
	public int updateByPrimaryKey(Teacher record) {
		return teacherDao.updateByPrimaryKey(record);
	}
	
	@Override
	public Teacher login(String username, String password) {
		return teacherDao.selectByLoginNameAndPassword(username,password);
	}
	
	@Override
	public List<Student> queryMyStudent(String teacherName) {
		return teacherDao.queryMyStudent(teacherName);
	}

	@Override
	public int countTeacher() {
		return teacherDao.countTeacher();
	}

	
}
