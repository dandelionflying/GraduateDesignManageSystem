package com.running4light.gdms.service;

import java.util.List;
import com.running4light.gdms.pojo.Process;

public interface ProcessService {
	int deleteByPrimaryKey(Short id);

    int insert(Process process);

    Process selectByPrimaryKey(Short id);

    List<Process> selectAll();

    int updateByPrimaryKey(Process process);
    
    String countState(Short state);
    
    List<Process> selectByTeacher(String teacherName);

	int updateState(Integer state,String uid, String classify);

	Process queryByUid(String uid);
}
