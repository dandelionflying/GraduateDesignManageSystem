package com.running4light.gdms.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.running4light.gdms.dao.ManagerDao;
import com.running4light.gdms.pojo.Manager;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ManagerDao managerDao;

	@Override
	public Manager queryByIdAndPassword(String id, String password) {
		Manager manager = managerDao.selectByPrimaryKey(id);
		if(manager!=null && manager.getPassword().equals("12345678")) {
			if(password.equals("12345678"))
				return manager;
			return null;
		}
		//注入失败，先直接使用，另外找时间再修改。
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPSW = encoder.encode(password);
		boolean result = encoder.matches(password, "$2a$10$8hyU1dL/SbvueMnsTCGTquo4QYpx4B6zFMtjtSuuZlG0p.mhZLhsG");
		logger.debug("========用户信息"+manager.toString());
		logger.debug("========加密后的password======  "+encoderPSW);
		logger.debug("========匹配结果======  "+result);
		
		if(manager!=null && encoder.matches(password, manager.getPassword())) {
			return manager;
		}
		return null;
		
		
	}
	@Override
	public int deleteByPrimaryKey(String id) {
		return managerDao.deleteByPrimaryKey(id);
	}
	@Override
	public int insert(Manager record) {
		return managerDao.insert(record);
	}
	@Override
	public Manager selectByPrimaryKey(String id) {
		return managerDao.selectByPrimaryKey(id);
	}
	@Override
	public List<Manager> selectAll() {
		return managerDao.selectAll();
	}
	@Override
	public int updateByPrimaryKey(Manager record) {
		return managerDao.updateByPrimaryKey(record);
	}
	@Override
	public String queryPasswordById(String id) {
		return managerDao.queryPasswordById(id);
	}
	@Override
	public String getEmailById(String uid) {
		return managerDao.getEmailById(uid);
	}
	

	

}
