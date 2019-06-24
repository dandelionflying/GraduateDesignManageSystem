package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Role;

public interface RoleService {
	int deleteByPrimaryKey(Byte id);

    int insert(Role role);

    Role selectByPrimaryKey(Byte id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role role);

	String queryRolenameById(String uid);
}
