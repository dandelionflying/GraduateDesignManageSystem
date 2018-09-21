package gdms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import gdms.model.Student;
import gdms.model.Teacher;

public interface TeacherDao {
	
	Teacher selectByLoginNameAndPassword(@Param("username") String id,@Param("password") String password);
	
	Teacher queryById(@Param("t_id") String id);
	
	List<Student> queryMyStudent(@Param("teacherName")String teacherName);
	
	Student queryMyStudentById(@Param("sId")String sId);
	
}
