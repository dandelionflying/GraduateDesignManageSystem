package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.StudentResult;
import com.running4light.gdms.pojo.Teacher;

public interface TeacherDao {
	int deleteByPrimaryKey(String id);

	int insert(Teacher record);

	int updateByPrimaryKey(Teacher record);

	Teacher selectByPrimaryKey(String id);

	List<Teacher> selectAll();

	Teacher selectByLoginNameAndPassword(@Param("username") String id, @Param("password") String password);

	List<StudentResult> queryMyStudent(@Param("teacherName") String teacherName);

	Teacher queryById(@Param("t_id") String id);

	Integer countTeacher();

	List<Teacher> selectPage(Map<String, Object> param);

	int insertForeach(List<Teacher> list);

	Integer selectByPrimaryKeys(List<String> ids);

	String queryPswById(@Param("uid") String uid);

	int updatePassword(@Param("uid") String uid,@Param("password") String password);

	String getEmailById(String uid);
}
