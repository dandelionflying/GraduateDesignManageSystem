package gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdms.dao.DocDao;
import gdms.model.Doc;
import gdms.service.DocService;
@Service
@Transactional
public class DocServiceImpl implements DocService {
	@Autowired
	private DocDao docDao;
	@Override
	public boolean addDoc(Doc newDoc) {
		if(docDao.insertDoc(newDoc)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<Doc> getDocsByUid(String uid) {
		List<Doc> docs = docDao.getDocsBySid(uid);
		return docs;
	}

}
