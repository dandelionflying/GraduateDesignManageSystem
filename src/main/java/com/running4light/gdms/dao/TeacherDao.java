package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.pojo.Teacher;

public interface TeacherDao {
	int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    Teacher selectByPrimaryKey(String id);

    List<Teacher> selectAll();
	
	Teacher selectByLoginNameAndPassword(@Param("username") String id,@Param("password") String password);
	
	List<Student> queryMyStudent(@Param("teacherName")String teacherName);

	Teacher queryById(@Param("t_id") String id);

	Integer countTeacher();

	List<Teacher> selectPage(Map<String,Object> param);
}
