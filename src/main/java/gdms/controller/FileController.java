package gdms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import gdms.common.WebWords;
import gdms.model.Doc;
import gdms.model.Student;
import gdms.service.DocService;

@Controller
public class FileController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DocService docService;
	@RequestMapping(value = "/uploadfile")
	@ResponseBody
	public Map<String,Object> uploadFile(HttpServletRequest request, HttpServletResponse response,HttpSession session,
			@RequestParam("upload-file") MultipartFile uploadFile,@RequestParam("classify") String classify) {
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			Student student = (Student)session.getAttribute(WebWords.USERSESSION);
			Doc newDoc = new Doc();
			String[] docOriginalFilename = uploadFile.getOriginalFilename().split("\\.");
			String docName = docOriginalFilename[0];
			String docType = docOriginalFilename[1];
			//String docUrl = request.getSession().getServletContext().getRealPath("/upload");
			String docUrl = "F:\\web\\GDMS\\upload";
			String path = "\\" + classify+student.getsId()+"."+docType;
			logger.debug(classify);
			logger.debug(uploadFile.getOriginalFilename());
			logger.debug(docUrl);
			logger.debug(path);
			File file = new File(docUrl + path);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			uploadFile.transferTo(file);
			
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
			Date t = new Date(new java.util.Date().getTime());
			newDoc.setUid(student.getsId());
			newDoc.setClassify(classify);
			newDoc.setDocName(docName);
			newDoc.setDocType(docType);
			newDoc.setDocUrl(docUrl+"\\"+docName+"."+docType);
			newDoc.setCreateDate(t);
			docService.addDoc(newDoc);
			json.put("success", "成功");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="document")
	public String showDocs(Model model,HttpSession session) {
		String uid = ((Student)session.getAttribute(WebWords.USERSESSION)).getsId();
		List<Doc> docs = docService.getDocsByUid(uid);
		Iterator<Doc> iterator = docs.iterator();
		Map<String, Doc> docMap = new HashMap<String,Doc>();
		while(iterator.hasNext()) {
			Doc tmp = iterator.next();
			docMap.put(tmp.getClassify(), tmp);
		}
		model.addAttribute("docs",docMap);
		return "student/document";
	}
	@RequestMapping(value="download")
	public ResponseEntity<byte[]> download(HttpServletResponse response,@RequestParam("id") int docId) {
		String url = null;
		StringTokenizer stringToken = null;
		String fileName = null;
		ResponseEntity<byte[]> responseEntity = null;
		try {
			url = docService.downloadById(docId);
			stringToken = new StringTokenizer(url, "\\");
			while (stringToken.hasMoreTokens()) {
				fileName = stringToken.nextToken();
			}
			File file = new File(url);
			HttpHeaders header = new HttpHeaders();
			String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			header.setContentDispositionFormData("attachment", downloadFileName);
			header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			
			logger.debug(url);
			
			responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),header,HttpStatus.CREATED);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
}
