package com.running4light.gdms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.GradeDao;
import com.running4light.gdms.pojo.Grade;
import com.running4light.gdms.pojo.GradeResult;
import com.running4light.gdms.pojo.GradeResultEvaluation;
import com.running4light.gdms.service.GradeService;
@Service
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	@Override
	public int deleteByPrimaryKey(Short id) {
		return gradeDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Grade grade) {
		return gradeDao.insert(grade);
	}

	@Override
	public GradeResult selectByPrimaryKey(Short id) {
		return gradeDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Grade> selectAll() {
		return gradeDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Grade grade) {
		return gradeDao.updateByPrimaryKey(grade);
	}

	@Override
	public GradeResult selectByUid(String uid) {
		return gradeDao.selectByUid(uid);
	}

	@Override
	public List<GradeResult> selectPage(Integer index, Integer page) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index*page);
		param.put("page", page);
		return gradeDao.selectPage(param);
	}

	@Override
	public Integer countAll() {
		return gradeDao.countAll();
	}

	@Override
	public List<GradeResultEvaluation> selectPageByClass(String uid, Integer index, Integer page) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index*page);
		param.put("page", page);
		param.put("uid", uid);
		return gradeDao.selectPageByClass(param);
	}

	@Override
	public Integer countPageByClass(String uid) {
		return gradeDao.countPageByClass(uid);
	}

	@Override
	public List<GradeResultEvaluation> selectPageByGuider(String teacherName, Integer index, Integer page) {
		Map<String,Object> param = new HashMap<>();
		param.put("teacherName", teacherName);
		return gradeDao.selectPageByGuider(param);
	}

	@Override
	public Integer countPageByGuider(String teacherName) {
		
		return gradeDao.countPageByGuider(teacherName);
	}

}
