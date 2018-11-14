package gdms.service;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import gdms.model.Student;

public interface StudentService {
	
	Student studentLogin(String loginname,String password);
	
	boolean selectToopic(String sid,String topicId);

	void importExcelInfo(InputStream in, MultipartFile file, String salaryDate,Integer adminId);
}
