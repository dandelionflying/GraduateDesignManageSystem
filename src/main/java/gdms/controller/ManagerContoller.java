package gdms.controller;

import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gdms.service.FileService;
import gdms.service.ManagerService;
import gdms.service.StudentService;
import gdms.service.TopicService;
import net.sf.jsqlparser.parser.ParseException;

@Controller
public class ManagerContoller {
	@Autowired
	private StudentService studentService;
	@Autowired
	private FileService fileService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "edumanagercenter")
	public String toIndex() {
		
		return "edumanager/edumanagercenter";
	}

	/*
	 * 从表格导入学生信息到数据库
	 */
	
	@RequestMapping("/import")
	public String impotr(HttpServletRequest request, Model model) throws Exception {
	     int adminId = 1;
	     //获取上传的文件
	     MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
	     MultipartFile file = multipart.getFile("upfile");
	     String month = request.getParameter("month");
	     InputStream in = file.getInputStream();
	     //数据导入
	     studentService.importExcelInfo(in,file,month,adminId);
	     in.close();
	     return "redirect:/salary/index.html";
	}
	
	/*
	 * 学生信息导入到表格中
	 */
	@RequestMapping("/export")
	public @ResponseBody void export(HttpServletRequest request, HttpServletResponse response) {
	    String someParam = request.getParameter("someParam");
	    if(someParam!=""){
	        response.reset(); //清除buffer缓存
	        Map<String,Object> map=new HashMap<String,Object>();
	        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
	        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
	        try {
				response.setHeader("Content-Disposition", "attachment;filename=" + new String(someParam.getBytes("GBK"),"ISO-8859-1"));
		        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		        response.setHeader("Pragma", "no-cache");
		        response.setHeader("Cache-Control", "no-cache");
		        response.setDateHeader("Expires", 0);
	        } catch (UnsupportedEncodingException e1) {
	        	e1.printStackTrace();
	        }
	        XSSFWorkbook workbook=null;
	        //导出Excel对象
	        workbook = fileService.exportExcelInfo(someParam);
	        OutputStream output;
	        try {
	            output = response.getOutputStream();
	            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
	            bufferedOutPut.flush();
	            workbook.write(bufferedOutPut);
	            bufferedOutPut.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
