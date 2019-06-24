package com.running4light.gdms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.StDao;
import com.running4light.gdms.pojo.St;
import com.running4light.gdms.service.StService;
@Service
@Transactional
public class StServiceImpl implements StService {
	
	@Autowired
	private StDao stDao;
	@Override
	public int deleteByPrimaryKey(Byte id) {
		return stDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(String sid, String studentName,String topicId,String topicName,String teacherName) {
		St st = new St();
		st.setsId(sid);
		st.setStudentName(studentName);
		st.setTopicId(topicId);
		st.setTopicName(topicName);
		st.setTeacherName(teacherName);
		return stDao.insert(st);
	}

	@Override
	public St selectByPrimaryKey(Byte id) {
		return stDao.selectByPrimaryKey(id);
	}

	@Override
	public List<St> selectAll() {
		return stDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(St record) {
		return stDao.updateByPrimaryKey(record);
	}

	@Override
	public List<St> queryBySid(String key) {
		return stDao.queryBySid(key);
	}

	@Override
	public List<St> queryPage(Integer index, Integer page) {
		Map<String,Object> map = new HashMap<>();
		map.put("index", index*page);
		map.put("page", page);
		return stDao.queryPage(map);
	}

	@Override
	public Integer countst() {
		return stDao.countst();
	}

	@Override
	public List<String> queryUidByTeachername(String teacherName) {
		return stDao.queryUidByTeachername(teacherName);
	}

}
