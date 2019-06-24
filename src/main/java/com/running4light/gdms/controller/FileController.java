package com.running4light.gdms.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Docs;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.DocService;
import com.running4light.gdms.service.FileService;

@Controller
@RequestMapping("/file")
public class FileController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DocService docService;
	@Autowired
	private FileService fileService;
	
	@ResponseBody
	@RequestMapping(value="mydocument",method=RequestMethod.GET)
	public Map<String, Docs> showDocs(Model model,HttpSession session) {
		String uid = ((Student)session.getAttribute(WebWords.USERSESSION)).getId();
		List<Docs> docs = docService.getDocsByUid(uid);
		Iterator<Docs> iterator = docs.iterator();
		Map<String, Docs> documents = new HashMap<String,Docs>();
		while(iterator.hasNext()) {
			Docs tmp = iterator.next();
			documents.put(tmp.getClassify(), tmp);
		}
		model.addAttribute("docs",documents);
		return documents;
	}
	
	
	/*@RequestMapping("/export")
	public @ResponseBody void export(HttpServletRequest request, HttpServletResponse response){
	    
	    
        response.reset(); //清除buffer缓存
        Map<String,Object> map=new HashMap<String,Object>();
        // 指定下载的文件名，浏览器都会使用本地编码，即GBK，浏览器收到这个文件名后，用ISO-8859-1来解码，然后用GBK来显示
        // 所以我们用GBK解码，ISO-8859-1来编码，在浏览器那边会反过来执行。
        response.setHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis());
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        XSSFWorkbook workbook=null;
        //导出Excel对象
        workbook = fileService.exportExcelInfo();
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
	    
	}*/
}
