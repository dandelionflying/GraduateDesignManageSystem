package com.running4light.gdms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.running4light.gdms.pojo.Grade;
import com.running4light.gdms.pojo.GradeResult;
import com.running4light.gdms.pojo.GradeResultEvaluation;

public interface GradeDao {
	int deleteByPrimaryKey(Short id);

    int insert(Grade grade);

    GradeResult selectByPrimaryKey(Short id);

    List<Grade> selectAll();

    int updateByPrimaryKey(Grade grade);
    
    GradeResult selectByUid(@Param("uid") String uid);

	List<GradeResult> selectPage(Map<String, Object> param);
	
	Integer countAll();

	List<GradeResultEvaluation> selectPageByClass(Map<String, Object> param);
	
	Integer countPageByClass(@Param("uid") String uid);
	
	List<GradeResultEvaluation> selectPageByGuider(Map<String,Object> param);
	
	Integer countPageByGuider(@Param("teacherName") String teacherName);
}
