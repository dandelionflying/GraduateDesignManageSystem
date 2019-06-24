package com.running4light.gdms.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.dao.DocDao;
import com.running4light.gdms.pojo.Docs;
import com.running4light.gdms.service.DocService;
@Service
@Transactional
public class DocServiceImpl implements DocService {
	@Autowired
	private DocDao docDao;
	@Override
	public boolean addDoc(Docs newDoc) {
		if(docDao.insert(newDoc)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Docs> getDocsByUid(String uid) {
		List<Docs> docs = docDao.getDocsBySid(uid);
		return docs;
	}
	@Override
	public String downloadById(int docId) {
		return docDao.queryUrlById(docId);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return docDao.deleteByPrimaryKey(id);
	}
	@Override
	public Docs selectByPrimaryKey(Integer id) {
		return docDao.selectByPrimaryKey(id);
	}
	@Override
	public List<Docs> selectAll() {
		return docDao.selectAll();
	}
	@Override
	public int updateByPrimaryKey(Docs record) {
		return docDao.updateByPrimaryKey(record);
	}
	@Override
	public List<Docs> selectAllPage(Integer index, Integer page) {
		Map<String,Integer> param = new HashMap<>();
		param.put("index", index);
		param.put("page", page);
		return docDao.selectAllPage(param);
	}
	@Override
	public Integer selectCount() {
		return docDao.selectCount();
	}
	@Override
	public Docs getByUidAndClassify(String uid, Integer classify) {
		Map<String,Object> param = new HashMap<>();
		param.put("uid", uid);
		param.put("classify", classify);
		return docDao.getByUidAndClassify(param);
	}
	@Override
	public List<Docs> getWithTeachername(String teachername) {
		return docDao.getWithTeachername(teachername);
	}
	@Override
	public int updateStateByPrimaryKey(Integer state,Integer docId) {
		return docDao.updateStateByPrimaryKey(state,docId);
	}
	@Override
	public List<Docs> selectByUidAndClassify(String[] classify,String[] uids) {
		List<String> classifys = Arrays.asList(classify);
		List<String> ids = Arrays.asList(uids);
		return docDao.selectByUidAndClassify(ids, classifys);
	}
	@Override
	public List<Docs> selectByClassify(String uid, String[] classify) {
		List<String> classifys = Arrays.asList(classify);
		return docDao.selectByClassify(uid, classifys);
	}
	@Override
	public List<Docs> getWithTeacherAndClass(String uid) {
		return docDao.getWithTeacherAndClass(uid);
	}
	@Override
	public List<Docs> selectByClassifys(String[] classifys, Integer index, Integer page) {
		List<String> cs = Arrays.asList(classifys);
//		List<Docs> docs = docDao.selectByClassifys(cs);
//		return docs.subList(index, page);
		return docDao.selectByClassifys(cs,index,page);
	}
	@Override
	public Integer countByClassifys(String[] classifys) {
		List<String> cs = Arrays.asList(classifys);
		return docDao.countByClassifys(cs);
	}

	
}
