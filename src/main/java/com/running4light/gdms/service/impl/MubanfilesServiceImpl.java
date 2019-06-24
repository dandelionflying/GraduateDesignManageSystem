package com.running4light.gdms.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.dao.MubanfilesDao;
import com.running4light.gdms.pojo.Mubanfiles;
import com.running4light.gdms.service.MubanfilesService;
@Service
@Transactional
public class MubanfilesServiceImpl implements MubanfilesService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MubanfilesDao mubanfilesDao;
	@Value(value = "${gdms.saveurl}")
	private String saveUrl;
	@Override
	public List<Mubanfiles> selectByids(Integer[] param) {
		List<Integer> ids = new ArrayList<Integer>(Arrays.asList(param));
		return mubanfilesDao.selectByids(ids);
	}
	@Override
	public boolean deleteItems(Integer[] ids) {
		List<Mubanfiles> list = selectByids(ids);
		List<Integer> param = new ArrayList<Integer>(Arrays.asList(ids));
		Integer result = mubanfilesDao.deleteByids(param);
		if (result > 0) {
			for (Mubanfiles mubanfiles : list) {
				String url = mubanfiles.getUrl();
				File file = new File(url);
				if (file.exists() && file.isFile()) {
					if (file.delete()) {
						logger.debug("删除成功");
					}else {
						logger.debug("删除失败");
					}
				}
			}
			return true;
		}
		return false;

	}
	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		Mubanfiles mubanfiles = selectByPrimaryKey(id);
		Integer result = mubanfilesDao.deleteByPrimaryKey(id);
		System.out.println(result);
		if(result>0) {
			String url = mubanfiles.getUrl();
			File file = new File(url);
			if(file.exists() && file.isFile()) {
				if(file.delete()) {
					System.out.println("删除成功");
					return true;
				}
			}
			return false;
		}else {
			return false;
		}
	}
	/**
	 * 添加模板文件
	 */
	@Override
	public Mubanfiles addMubanFile(MultipartFile uploadFile,Short towho) {
		logger.debug("从properties中取值=============="+saveUrl);
		Mubanfiles mubanFiles = new Mubanfiles();
		
		String[] docOriginalFilename = uploadFile.getOriginalFilename().split("\\.");
		Date t = new Date(new java.util.Date().getTime());
		String docName = docOriginalFilename[0] + t.getTime();
		String docType = docOriginalFilename[1];
		//String docUrl = request.getSession().getServletContext().getRealPath("/upload");
		String docUrl = "F:\\web\\GDMS\\upload";
		String path = "\\muban\\" + docName +"."+docType;
		File file = new File(docUrl + path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdir();
		}
		try {
			uploadFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		mubanFiles.setUploadTime(t);
		mubanFiles.setName(docName);
		mubanFiles.setUrl(docUrl+"\\"+path);
		mubanFiles.setReceiver(towho);
		if(mubanfilesDao.insert(mubanFiles)!=0)
			return mubanFiles;
		else
			return null;
	}

	@Override
	public Mubanfiles selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mubanfilesDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Mubanfiles> selectAll() {
		// TODO Auto-generated method stub
		return mubanfilesDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Mubanfiles record) {
		// TODO Auto-generated method stub
		return mubanfilesDao.updateByPrimaryKey(record);
	}

	@Override
	public List<Mubanfiles> selectPage(Integer index, Integer size) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index);
		param.put("size", size);
		return mubanfilesDao.selectPage(param);
	}
	@Override
	public List<Mubanfiles> selectPage(Integer index, Integer size,Integer receiver) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index);
		param.put("size", size);
		param.put("receiver", receiver);
		return mubanfilesDao.selectPage(param);
	}

	@Override
	public Integer countSelectAll() {
		return mubanfilesDao.countSelectAll(null);
	}
	
	
	@Override
	public Integer countSelectAll(Integer receiver) {
		Map<String,Object> param = new HashMap<>();
		param.put("receiver", receiver);
		return mubanfilesDao.countSelectAll(param);
	}
	
	
}
