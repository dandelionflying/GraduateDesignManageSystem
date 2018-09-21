package gdms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gdms.dao.TeacherDao;
import gdms.model.Student;
import gdms.model.Teacher;
import gdms.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public Teacher login(String username, String password) {
		
		return teacherDao.selectByLoginNameAndPassword(username,password);
	}

	@Override
	public List<Student> queryMyStudent(String teacherName) {
		return teacherDao.queryMyStudent(teacherName);
	}

	@Override
	public Student queryMyStudentById(String sId) {
		return teacherDao.queryMyStudentById(sId);
	}

}
