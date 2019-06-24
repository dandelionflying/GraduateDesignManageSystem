package com.running4light.gdms.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.pojo.Mubanfiles;

public interface MubanfilesService {
	boolean deleteByPrimaryKey(Integer id);

    Mubanfiles addMubanFile(MultipartFile uploadFile,Short towho);

    Mubanfiles selectByPrimaryKey(Integer id);

    List<Mubanfiles> selectAll();

    int updateByPrimaryKey(Mubanfiles record);
    
    List<Mubanfiles> selectPage(Integer index, Integer size);

	List<Mubanfiles> selectPage(Integer index, Integer size, Integer receiver);

	Integer countSelectAll();
	
	Integer countSelectAll(Integer receiver);

	boolean deleteItems(Integer[] ids);
	
	List<Mubanfiles> selectByids(Integer[] param);

}
