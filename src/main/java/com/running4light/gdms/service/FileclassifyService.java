package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Fileclassify;

public interface FileclassifyService {
	int deleteByPrimaryKey(Integer id);

    int insert(Fileclassify record);

    Fileclassify selectByPrimaryKey(Integer id);

    List<Fileclassify> selectAll();
    
    int updateByPrimaryKey(Fileclassify record);
}
