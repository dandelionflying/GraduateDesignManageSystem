package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Grade;
import com.running4light.gdms.pojo.GradeResult;
import com.running4light.gdms.pojo.GradeResultEvaluation;

public interface GradeService {
	int deleteByPrimaryKey(Short id);

    int insert(Grade grade);

    GradeResult selectByPrimaryKey(Short id);

    List<Grade> selectAll();

    int updateByPrimaryKey(Grade grade);
    
    GradeResult selectByUid(String uid);

	List<GradeResult> selectPage(Integer index, Integer page);
	
	Integer countAll();

	List<GradeResultEvaluation> selectPageByClass(String uid, Integer index, Integer page);
	
	Integer countPageByClass(String uid);
	
	List<GradeResultEvaluation> selectPageByGuider(String teacherName, Integer index, Integer page);

	Integer countPageByGuider(String teacherName);
	
}
