package gdms.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import gdms.model.Student;
@Repository
public interface StudentDao {

	// 以注解方式
//	@Select("select * from " + STUDENT + "where sname = #{loginname} and spassword = #{password}")
	Student selectByLoginnameAndPassword(@Param("username") String username,
			@Param("password") String password);
	
	Student queryByS_ID(@Param("s_id") String id);
	
	Student updateStudentMessage(@Param("s_id") String id);
	
	boolean insertSt(@Param("s_id") String id,@Param("topic_id")String topicId);
}
