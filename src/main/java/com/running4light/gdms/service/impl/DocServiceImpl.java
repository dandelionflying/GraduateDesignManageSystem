package com.running4light.gdms.service.impl;

import java.util.List;

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

}
