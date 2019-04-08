package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.running4light.gdms.pojo.Student;
@Repository
public interface StudentDao {
	
	int deleteByPrimaryKey(String id);

    int insert(Student record);

    /*Student selectByPrimaryKey(String id);*/

    /*List<Student> selectAll();*/

    int updateByPrimaryKey(Student record);
	// 以注解方式
//	@Select("select * from " + STUDENT + "where sname = #{loginname} and spassword = #{password}")
	Student selectByLoginnameAndPassword(@Param("username") String username,
			@Param("password") String password);

	void insertInfoBatch(List<Student> studentList);

	List<Student> queryAll();
	
	Student queryById(@Param("id")String sId);

	int countStudent();

	List<Student> selectPage(Map<String,Object> param);
}
