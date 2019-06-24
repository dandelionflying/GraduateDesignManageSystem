package com.running4light.gdms.service.impl;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.running4light.gdms.common.ExcelBean;
import com.running4light.gdms.dao.StudentDao;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.FileService;
import com.running4light.gdms.util.ExcelUtil;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
@Service
@Transactional
public class FileServiceImpl implements FileService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public XSSFWorkbook exportExcelInfo(String ... someParam){
	    //根据条件查询数据，把数据装载到一个list中
	    List<Student> list = studentDao.queryAll();
	    
	    List<ExcelBean> excel=new ArrayList<>();
	    Map<Integer,List<ExcelBean>> map=new LinkedHashMap<>();
	    XSSFWorkbook xssfWorkbook=null;
	    //设置标题栏
	    excel.add(new ExcelBean("学号","sId",0));
	    excel.add(new ExcelBean("姓名","studentName",0));
	    excel.add(new ExcelBean("密码","sPassword",0));
	    excel.add(new ExcelBean("性别","sSex",0));
	    excel.add(new ExcelBean("入学年份","enterYear",0));
	    excel.add(new ExcelBean("班级","className",0));
	    excel.add(new ExcelBean("专业","sMayor",0));
	    excel.add(new ExcelBean("院系","deptId",0));
	    excel.add(new ExcelBean("联系方式","sTel",0));
	    map.put(0, excel);
	    String sheetName = "工作表1";
	    //调用ExcelUtil的方法
	    try {
			xssfWorkbook = ExcelUtil.createExcelFile(Student.class, list, map, sheetName);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	    return xssfWorkbook;
	}

}
