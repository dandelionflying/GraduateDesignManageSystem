package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.pojo.Teacher;

public interface TeacherService {
	
	int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(String id);

    List<Teacher> selectAll();
    
    List<Teacher> selectPage(Integer index,Integer page);

    int updateByPrimaryKey(Teacher record);
    
	Teacher login(String username,String password);
	
	List<Student> queryMyStudent(String teacherName);

	int countTeacher();
}
