package gdms.service;

import java.util.List;

import gdms.model.Student;
import gdms.model.Teacher;

public interface TeacherService {
	Teacher login(String username,String password);
	
	List<Student> queryMyStudent(String teacherName);
	
	Student queryMyStudentById(String sId);
}
