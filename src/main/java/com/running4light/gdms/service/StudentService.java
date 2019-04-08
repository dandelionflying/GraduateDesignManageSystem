package com.running4light.gdms.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.pojo.Student;

public interface StudentService {
	
	Student studentLogin(String loginname,String password);
	
	void importExcelInfo(InputStream in, MultipartFile file, String salaryDate,Integer adminId);

	Student queryById(String string);

	int countStudent();

	List<Student> selectPage(Integer index, Integer page);
}
