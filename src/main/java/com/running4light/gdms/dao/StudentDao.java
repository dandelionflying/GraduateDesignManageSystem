package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.running4light.gdms.pojo.Student;
@Repository
public interface StudentDao {
	
	int deleteByPrimaryKey(String id);

    int insert(Student student);

    /*List<Student> selectAll();*/

    int updateByPrimaryKey(Student student);
	// 以注解方式
//	@Select("select * from " + STUDENT + "where sname = #{loginname} and spassword = #{password}")
	Student selectByLoginnameAndPassword(@Param("username") String username,
			@Param("password") String password);

	int insertInfoBatch(List<Student> studentList);

	List<Student> queryAll();
	
	Student queryById(@Param("id")String sId);

	int countStudent();

	List<Student> selectPage(Map<String,Object> param);
	
	Integer selectByPrimaryKeys(List<String> list);
	
	Student selectByPrimaryKey(@Param("uid") String id);

	String queryPswById(@Param("uid") String uid);

	int updatePassword(@Param("uid") String uid, @Param("password") String password);

	String queryEmailById(@Param("uid") String uid);
}
