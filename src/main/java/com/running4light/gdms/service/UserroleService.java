package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Userrole;

public interface UserroleService {
	int deleteByPrimaryKey(Byte id);

    int insert(Userrole userrole);

    Userrole selectByPrimaryKey(Byte id);

    List<Userrole> selectAll();

    int updateByPrimaryKey(Userrole userrole);
    
    Userrole selectByUid(String uid);
}
