package gdms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
			Doc newDoc = new Doc();
			String[] docOriginalFilename = uploadFile.getOriginalFilename().split("\\.");
			String docName = docOriginalFilename[0];
			String docType = docOriginalFilename[1];
			String docUrl = request.getSession().getServletContext().getRealPath("/upload");
			String path = "\\" + uploadFile.getOriginalFilename();
			logger.debug(classify);
			logger.debug(uploadFile.getOriginalFilename());
			logger.debug(docUrl);
			logger.debug(path);
			File file = new File(docUrl + path);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			uploadFile.transferTo(file);
			Student student = (Student)session.getAttribute(WebWords.USERSESSION);
			
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
			Date t = new Date(new java.util.Date().getTime());
			newDoc.setUid(student.getsId());
			newDoc.setClassify(classify);
			newDoc.setDocName(docName);
			newDoc.setDocType(docType);
			newDoc.setDocUrl(docUrl);
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
}
