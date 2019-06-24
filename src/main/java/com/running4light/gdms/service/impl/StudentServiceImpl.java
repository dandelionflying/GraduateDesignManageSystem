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
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.dao.StudentDao;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.security.MyBCryptPasswordEncoder;
import com.running4light.gdms.service.StudentService;
import com.running4light.gdms.util.ExcelUtil;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentDao studentDao;
	/*@Autowired
	private MyBCryptPasswordEncoder myBCryptPasswordEncoder;*/
	
	@Override
	public int countStudent() {
		return studentDao.countStudent();
	}
	
	@Override
	public List<Student> selectPage(Integer index, Integer page) {
		Map<String,Object> map = new HashMap<>();
		map.put("index", index);
		map.put("page", page);
		return studentDao.selectPage(map);
	}

	@Override
	public Student studentLogin(String id, String password) {
		Student student = studentDao.selectByPrimaryKey(id);
		if(student!=null && student.getPassword().equals("12345678")) {
			return student;
		}
		
//		Md5PasswordEncoder
		//注入失败，先直接使用，另外找时间再修改。
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPSW = encoder.encode(password);
		boolean result = encoder.matches("dandelion", "$2a$10$8hyU1dL/SbvueMnsTCGTquo4QYpx4B6zFMtjtSuuZlG0p.mhZLhsG");
		logger.debug("========用户信息"+student.toString());
		logger.debug("========加密后的password======  "+encoderPSW);
		logger.debug("========匹配结果======  "+result);
		
		if(student!=null && encoder.matches(password, student.getPassword())) {
			return student;
		}
		return null;
	}

	@Override
	public void importExcelInfo(InputStream in, MultipartFile file, String salaryDate,Integer adminId){
	    List<List<Object>> listob = null;
		try {
			listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
	    List<Student> studentList = new ArrayList<Student>();
	    //遍历listob数据，把数据放到List中
	    for (int i = 0; i < listob.size(); i++) {
	        List<Object> ob = listob.get(i);
	        Student student = new Student();
	        //设置编号
	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载
	        student.setId(String.valueOf(ob.get(0)));
	        student.setUsername(String.valueOf(ob.get(1)));
	        student.setPassword(String.valueOf(ob.get(2)));
	        student.setEnterYear(String.valueOf(ob.get(3)));
	        student.setClassName(String.valueOf(ob.get(4)));
	        student.setMayor(String.valueOf(ob.get(5)));
	        student.setDeptId(Short.parseShort((String)ob.get(6)));
	        student.setSex(String.valueOf(ob.get(7)));
	        student.setTel(String.valueOf(ob.get(8)));
	        studentList.add(student);
	    }
	    //批量插入
	    studentDao.insertInfoBatch(studentList);
	}

	@Override
	public Student queryById(String id) {
		return studentDao.queryById(id);
	}


	@Override
	public Integer addStudents(MultipartFile file) {
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
		List<Student> students = new ArrayList<>();
		List<String> ids = new ArrayList<>();
		for (List<Object> row : tablecells) {
			Student newOne = new Student();
			newOne.setId(String.valueOf(row.get(0)));
			ids.add(String.valueOf(row.get(0)));
			newOne.setUsername(String.valueOf(row.get(1)));
			newOne.setPassword(String.valueOf(row.get(2)));
			newOne.setEnterYear(String.valueOf(row.get(3)));
			newOne.setClassName(String.valueOf(row.get(4)));
			newOne.setMayor(String.valueOf(row.get(5)));
			;
			newOne.setDeptId(Short.parseShort(String.valueOf(row.get(6))));
			newOne.setSex(String.valueOf(row.get(7)));
			newOne.setTel(String.valueOf(row.get(8)));
			newOne.setEmail(String.valueOf(row.get(9)));
			logger.debug("==============================================");
			logger.debug(newOne.toString());
			students.add(newOne);
		}
		Integer count = selectByPrimaryKeys(ids);
		logger.debug("批量查询id结果：  ==============    "+count);
		if(count>0) {
			return 1;//文件中某个或某些id在数据库中已存在
		}
		int result = 0;
		result = studentDao.insertInfoBatch(students);
		logger.debug("批量插入返回值：  ==============    "+result);
		if(result==students.size()) {
			return 0;//成功
		}else {
			return 2;//内部错误，插入失败
		}
	}

	@Override
	public Integer selectByPrimaryKeys(List<String> list) {
		return studentDao.selectByPrimaryKeys(list);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return studentDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Student student) {
		return studentDao.insert(student);
	}

	@Override
	public Student selectByPrimaryKey(String id) {
		return studentDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> selectAll() {
		return studentDao.queryAll();
	}

	@Override
	public int updateByPrimaryKey(Student student) {
		return studentDao.updateByPrimaryKey(student);
	}

	@Override
	public String getPsw(String uid) {
		return studentDao.queryPswById(uid);
	}

	@Override
	public int updatePassword(String uid, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoderPSW = encoder.encode(password);
		return studentDao.updatePassword(uid,encoderPSW);
	}

	@Override
	public String getEmailById(String uid) {
		return studentDao.queryEmailById(uid);
	}

}
