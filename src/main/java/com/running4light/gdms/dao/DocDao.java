package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.running4light.gdms.pojo.Docs;

@Repository
public interface DocDao {

	int deleteByPrimaryKey(Integer id);

	Docs selectByPrimaryKey(Integer id);

	List<Docs> selectAll();

	int updateByPrimaryKey(Docs record);

	public boolean insert(Docs newDoc);

	public List<Docs> getDocsBySid(@Param("uid") String uid);

	public String queryUrlById(int docId);

	List<Docs> selectAllPage(Map<String, Integer> param);

	Integer selectCount();

	Docs getByUidAndClassify(Map<String, Object> param);

	List<Docs> getWithTeachername(@Param("teachername") String teachername);

	int updateStateByPrimaryKey(@Param("state") Integer state, @Param("docId") Integer docId);

	List<Docs> selectByUidAndClassify(@Param("uids") List<String> uids, @Param("classify") List<String> classify);

	List<Docs> selectByClassify(@Param("uid") String uid, @Param("classify") List<String> classify);

	List<Docs> getWithTeacherAndClass(@Param("uid") String uid);

//	List<Docs> selectByClassifys(@Param("classifys") List<String> cs);
	List<Docs> selectByClassifys(@Param("classifys") List<String> cs,@Param("index")Integer index, @Param("page")Integer page);
	Integer countByClassifys(@Param("classifys") List<String> cs);
}
