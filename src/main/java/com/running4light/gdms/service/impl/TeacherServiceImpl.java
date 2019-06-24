package com.running4light.gdms.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.dao.TeacherDao;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.pojo.StudentResult;
import com.running4light.gdms.pojo.Teacher;
import com.running4light.gdms.service.TeacherService;
import com.running4light.gdms.util.ExcelUtil;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TeacherDao teacherDao;
	

	@Override
	public int deleteByPrimaryKey(String id) {
		return teacherDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Teacher record) {
		return teacherDao.insert(record);
	}

	@Override
	public Teacher selectByPrimaryKey(String id) {
		return teacherDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Teacher> selectAll() {
		return teacherDao.selectAll();
	}
	
	@Override
	public List<Teacher> selectPage(Integer index,Integer page) {
		Map<String,Object> param = new HashMap<>();
		param.put("index", index*page);
		param.put("page", page);
		return teacherDao.selectPage(param);
	}

	@Override
	public int updateByPrimaryKey(Teacher record) {
		return teacherDao.updateByPrimaryKey(record);
	}
	
	@Override
	public Teacher login(String username, String password) {
		Teacher teacher = teacherDao.selectByPrimaryKey(username);
		if(teacher!=null && teacher.getPassword().equals("12345678")) {
			return teacher;
		}
		//注入失败，先直接使用，另外找时间再修改。
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPSW = encoder.encode(password);
		boolean result = encoder.matches("dandelion", "$2a$10$8hyU1dL/SbvueMnsTCGTquo4QYpx4B6zFMtjtSuuZlG0p.mhZLhsG");
		logger.debug("========用户信息"+teacher.toString());
		logger.debug("========加密后的password======  "+encoderPSW);
		logger.debug("========匹配结果======  "+result);
		
		if(teacher!=null && encoder.matches(password, teacher.getPassword())) {
			return teacher;
		}
		return null;
	}
	
	@Override
	public List<StudentResult> queryMyStudent(String teacherName) {
		return teacherDao.queryMyStudent(teacherName);
	}

	@Override
	public int countTeacher() {
		return teacherDao.countTeacher();
	}

	@Override
	public Integer addTeachers(MultipartFile file) {
		if(file.isEmpty()) {
			try {
				throw new Exception("文件不存在！");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		InputStream inputStream =null;  
        try {
        	inputStream = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        
		List<List<Object>> tablecells = null; 
		try {
			tablecells = ExcelUtil.getBankListByExcel(inputStream,file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Teacher> teachers = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		for (List<Object> row : tablecells) {
			Teacher newOne = new Teacher();
			newOne.setId(String.valueOf(row.get(0)));
			ids.add(String.valueOf(row.get(0)));
			newOne.setUsername(String.valueOf(row.get(1)));
			newOne.setPassword(String.valueOf(row.get(2)));
			newOne.setDeptId(new Byte(String.valueOf(row.get(3))));
			newOne.setIdentity(String.valueOf(row.get(4)));
			newOne.setSex(String.valueOf(row.get(5)));
			newOne.setTel(String.valueOf(row.get(6)));
			newOne.setRank(String.valueOf(row.get(7)));
			newOne.setEmail(String.valueOf(row.get(8)));
			logger.debug("==============================================");
			logger.debug(newOne.toString());
			teachers.add(newOne);
		}
		Integer count = selectByPrimaryKeys(ids);
		logger.debug("批量查询id结果：  ==============    "+count);
		if(count>0) {
			return 1;//文件中某个或某些id在数据库中已存在
		}
		int result = 0;
		result = teacherDao.insertForeach(teachers);
		logger.debug("批量插入返回值：  ==============    "+result);
		if(result==teachers.size()) {
			return 0;//成功
		}else {
			
			return 2;//内部错误，插入失败
		}
	}
	@Override
	public Integer selectByPrimaryKeys(List<String> ids) {
		
		return teacherDao.selectByPrimaryKeys(ids);
	}

	@Override
	public String getPsw(String uid) {
		return teacherDao.queryPswById(uid);
	}

	@Override
	public int updatePassword(String uid,String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPSW = encoder.encode(password);
		return teacherDao.updatePassword(uid,encoderPSW);
	}

	@Override
	public String getEmailById(String uid) {
		return teacherDao.getEmailById(uid);
	}

	
}
