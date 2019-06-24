package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Docs;

public interface DocService {
	int deleteByPrimaryKey(Integer id);
	
	Docs selectByPrimaryKey(Integer id);
	
	List<Docs> selectAll();
	
	int updateByPrimaryKey(Docs record);
	public boolean addDoc(Docs newDoc);
	public List<Docs> getDocsByUid(String uid);
	public String downloadById(int docId);

	List<Docs> selectAllPage(Integer index, Integer page);
	
	Integer selectCount();

	Docs getByUidAndClassify(String uid, Integer classify);
	
	List<Docs> getWithTeachername(String teachername);

	int updateStateByPrimaryKey(Integer state,Integer docId);
	
	List<Docs> selectByUidAndClassify(String[] classify,String[] uids);
	
	List<Docs> selectByClassify(String uid, String[] classify);

	List<Docs> getWithTeacherAndClass(String uid);

	List<Docs> selectByClassifys(String[] classifys, Integer index, Integer page);

	Integer countByClassifys(String[] classifys);
}
