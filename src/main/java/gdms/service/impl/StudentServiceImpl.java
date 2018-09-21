package gdms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdms.dao.StudentDao;
import gdms.model.Student;
import gdms.service.StudentService;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao userDao;
	
	@Override
	public Student studentLogin(String loginname, String password) {
		
		return userDao.selectByLoginnameAndPassword(loginname, password);
	}

	@Override
	public boolean selectToopic(String sid, String topicId) {
		return userDao.insertSt(sid, topicId);
	}

}
