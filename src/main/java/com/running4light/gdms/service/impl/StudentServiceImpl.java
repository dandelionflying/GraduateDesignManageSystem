package com.running4light.gdms.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.dao.StudentDao;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.StudentService;
import com.running4light.gdms.util.ExcelUtil;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	
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
	public Student studentLogin(String loginname, String password) {
		
		return studentDao.selectByLoginnameAndPassword(loginname, password);
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
	    }
	    //批量插入
	    studentDao.insertInfoBatch(studentList);
	}

	@Override
	public Student queryById(String id) {
		return studentDao.queryById(id);
	}

}
