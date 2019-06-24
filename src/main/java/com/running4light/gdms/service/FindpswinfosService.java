package com.running4light.gdms.service;

import java.util.List;

import com.running4light.gdms.pojo.Findpswinfos;

public interface FindpswinfosService {
	int deleteByPrimaryKey(Integer id);

    int insert(Findpswinfos findpswinfos);

    Findpswinfos selectByPrimaryKey(Integer id);

    List<Findpswinfos> selectAll();

    int updateByPrimaryKey(Findpswinfos findpswinfos);

	Findpswinfos selectByUid(String uid);
}
