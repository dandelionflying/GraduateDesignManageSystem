package gdms.service;

import gdms.model.Student;

public interface StudentService {
	
	Student studentLogin(String loginname,String password);
	
	boolean selectToopic(String sid,String topicId);
}
