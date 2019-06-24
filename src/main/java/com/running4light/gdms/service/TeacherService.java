package com.running4light.gdms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.pojo.StudentResult;
import com.running4light.gdms.pojo.Teacher;

public interface TeacherService {
	
	int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(String id);

    List<Teacher> selectAll();
    
    List<Teacher> selectPage(Integer index,Integer page);

    int updateByPrimaryKey(Teacher record);
    
	Teacher login(String username,String password);
	
	List<StudentResult> queryMyStudent(String teacherName);

	int countTeacher();

	Integer addTeachers(MultipartFile file);

	Integer selectByPrimaryKeys(List<String> ids);

	String getPsw(String uid);

	int updatePassword(String uid,String password);

	String getEmailById(String uid);
}
