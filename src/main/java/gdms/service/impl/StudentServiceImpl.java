package gdms.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gdms.dao.StudentDao;
import gdms.model.Student;
import gdms.service.StudentService;
import gdms.util.ExcelUtil;
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Student studentLogin(String loginname, String password) {
		
		return studentDao.selectByLoginnameAndPassword(loginname, password);
	}

	@Override
	public boolean selectToopic(String sid, String topicId) {
		return studentDao.insertSt(sid, topicId);
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
	        student.setsId(String.valueOf(ob.get(0)));
	        student.setStudentName(String.valueOf(ob.get(1)));
	        student.setsPassword(String.valueOf(ob.get(2)));
	        student.setEnterYear(String.valueOf(ob.get(3)));
	        student.setClassName(String.valueOf(ob.get(4)));
	        student.setS_Mayor(String.valueOf(ob.get(5)));
	        student.setDeptId(Integer.parseInt((String)ob.get(6)));
	        student.setsSex(String.valueOf(ob.get(7)));
	        student.setsTel(String.valueOf(ob.get(8)));
	    }
	    //批量插入
	    studentDao.insertInfoBatch(studentList);
	}

}
