package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Department;

public interface DepartmentService {
	Integer deleteByPrimaryKey(Short id);

	Integer insert(Department record);

    Department selectByPrimaryKey(Short id);

    List<Department> selectAll();

    Integer updateByPrimaryKey(Department record);
    
    String queryNameById(Short deptId);
}
