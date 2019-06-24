package com.running4light.gdms.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.running4light.gdms.common.SessionValue;
import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Docs;
import com.running4light.gdms.pojo.Process;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.pojo.St;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.DepartmentService;
import com.running4light.gdms.service.DocService;
import com.running4light.gdms.service.ProcessService;
import com.running4light.gdms.service.StService;
import com.running4light.gdms.service.StudentService;
import com.running4light.gdms.service.TopicService;

@Controller
@RequestMapping("student")
public class StudentController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentService studentService;
	@Autowired
	private StService stService;
	@Autowired
	private DocService docService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ProcessService processService;

	
	@ResponseBody
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public Result userLogin(HttpServletResponse response,@RequestParam("username") String loginname,
			@RequestParam("password") String password, HttpSession session, ModelAndView mv) {
		logger.debug("======= 学生sessionid  =======  "+session.getId());
		/*PageHelper.startPage(2,10);
		List<Student> list = studentService.selectAll();
		logger.debug("==============分页测试"+list.toArray());*/
		Student student = studentService.studentLogin(loginname, password);
		/*Student student = list.get(0);*/
		if(student!=null) {
			SessionValue sessionValue = new SessionValue(student.getId(),"student",student.getUsername());
			session.setAttribute(WebWords.USERSESSION, sessionValue);
			response.addHeader("uid", student.getId());
			if(student.getPassword().equals("12345678"))
				return new Result(true,StatusCode.OK,"登录成功,密码不安全，请尽快修改！");
			else
				return new Result(true,StatusCode.OK,"登录成功");
		}else {
			return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
		}
	}
	
	@ResponseBody
	@RequestMapping("loginerror")
	public Result loginerror() {
		return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
	}
	
	@RequestMapping("loginsuccess")
	public ModelAndView loginSuccess(HttpServletResponse response,ModelAndView mv,HttpSession session) {
		mv.setViewName("redirect:studentcenter");
		return mv;
	}
	
	@RequestMapping(value = "logout")
	public ModelAndView logout(ModelAndView mv,HttpSession session) {
		session.removeAttribute(WebWords.USERSESSION);
		mv.setViewName("redirect:/login.html");
		return mv;
	}
	
	/**
	 * 获得个人信息
	 * @param uid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getinfo",method = RequestMethod.GET)
	public Result getInfo(@RequestParam("uid") String uid) {
		Student student = studentService.queryById(uid);
		if(student!=null) {
			String department = departmentService.queryNameById(student.getDeptId());
			Map<String,Object> mapinfo = new HashMap<>();
			mapinfo.put("username", student.getUsername());
			mapinfo.put("id", student.getId());
			mapinfo.put("enterYear", student.getEnterYear());
			mapinfo.put("className", student.getClassName());
			mapinfo.put("sex", student.getSex());
			mapinfo.put("tel", student.getTel());
			mapinfo.put("email", student.getEmail());
			mapinfo.put("mayor", student.getMayor());
			mapinfo.put("department", department);
			return new Result(true,StatusCode.OK,"查询成功",mapinfo);
		}
		return new Result(false,StatusCode.ERROR,"查询失败");
		
	}
	/**
	 * 修改密码前查询密码是否正确
	 * @param session
	 * @param psw
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkPsw",method = RequestMethod.POST)
	public Result checkPsw(HttpSession session,@RequestParam("old")String psw) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.USERSESSION);
		String uid = sessionValue.getId();
		String pswFromDB = studentService.getPsw(uid);
		if(pswFromDB!=null && psw.equals("12345678")) {
			return new Result(true,StatusCode.OK,"密码正确");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(psw, pswFromDB))
			return new Result(true,StatusCode.OK,"密码正确");
		else
			return new Result(false,StatusCode.ERROR,"密码不正确");
	}
	/**
	 * 修改密码
	 * @param session
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "changePsw",method = RequestMethod.POST)
	public Result changePsw(HttpSession session,@RequestParam("new")String password) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.USERSESSION);
		String uid = sessionValue.getId();
		int result = studentService.updatePassword(uid,password);
		if(result>0) {
			session.invalidate();
			return new Result(true,StatusCode.OK,"修改成功");
		}
		else
			return new Result(false,StatusCode.REMOTEERROR,"服务器错误");
	}
	
	/**
	 * 找回密码
	 * @param session
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "findPsw",method = RequestMethod.POST)
	public Result findPsw(@RequestParam("uid")String uid,@RequestParam("new")String password) {
		int result = studentService.updatePassword(uid,password);
		if(result>0) {
			return new Result(true,StatusCode.OK,"修改成功");
		}
		else
			return new Result(false,StatusCode.REMOTEERROR,"服务器错误");
	}
	
	/**
	 * 修改个人信息
	 * @param session
	 * @param sex
	 * @param tel
	 * @param email
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modifyInfo",method = RequestMethod.POST)
	public Result modifyInfo (HttpSession session, @RequestParam("sex") String sex, 
			@RequestParam("tel") String tel, @RequestParam("email") String email) {
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.USERSESSION);
		String uid = sessionValue.getId();
		Student student = new Student();
		student.setId(uid);
		student.setSex(sex);
		student.setEmail(email);
		student.setTel(tel);
		int result = studentService.updateByPrimaryKey(student);
		if(result>0)
			return new Result(true,StatusCode.OK,"修改成功",student);
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
	}
	
	/**
	 * 根据id下载模板文件（转发请求）
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "download",method = RequestMethod.GET)
	public String download(@RequestParam("id") Integer docId,RedirectAttributes attrs) {
		attrs.addAttribute("id", docId);
		return "redirect:/mubanfile/getById";
	}
	/**
	 * 根据id下载文件（转发请求）
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "downloadDoc",method = RequestMethod.GET)
	public String downloadDoc(@RequestParam("id") Integer docId,RedirectAttributes attrs) {
		attrs.addAttribute("id", docId);
		return "redirect:/docs/download";
	}
	
	
	
	/**
	 * 获取模板文件列表（分页）（转发请求）
	 * @param index
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "get-muban-file-student/{index}/{size}", method = RequestMethod.GET)
	public String getAllMubanFile(@PathVariable("index") Integer index,@PathVariable("size") Integer size,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("size", size);
		return "redirect:/mubanfile/getOfStudent";
	}
	/**
	 * 将通知标记为已读（转发请求）
	 * @param uid
	 * @param noticeid
	 * @return
	 */
	@RequestMapping(value = "changeUserNoticeState",method = RequestMethod.POST)
	public String changeUserNoticeState(@RequestParam("uid")String uid,@RequestParam("noticeid") Integer noticeid) {
		return "forward:/usernoticestate/insert";
	}
	/**
	 * 获取未读的通知（转发请求）
	 * @param uid
	 * @param count
	 * @return
	 */
	@RequestMapping(value = "getNewNotice",method = RequestMethod.POST)
	public String getNewNotice(@RequestParam("uid") String uid,@RequestParam("count") Integer count) {
		return "forward:/notice/getNew";
	}
	
	@RequestMapping(value = "getNotices/{receiver}/{index}/{size}",method = RequestMethod.GET)
	public String getNotices(@PathVariable("receiver") Integer receiver,@PathVariable("index") Integer index,@PathVariable("size") Integer size,RedirectAttributes attrs) {
		attrs.addAttribute("receiver", receiver);
		attrs.addAttribute("index", index);
		attrs.addAttribute("size", size);
		return "redirect:/notice/get/{receiver}/{index}/{size}";
	}
	/**
	 * 获取课题详情（转发请求）
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "topicContent.action",method = RequestMethod.POST)
	public String topicContent(@RequestParam("id")String id) {
		return "forward:/topic/getContent";
	}
	/**
	 * 分页获取课题列表（转发请求）
	 * @param tag
	 * @param index
	 * @param page
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getTopics/{tag}/{index}/{page}", method = RequestMethod.GET)
	public String getTopics(@PathVariable("tag") Integer tag,@PathVariable("index") Integer index,@PathVariable("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("tag", tag);
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/topic/getTopics";
	}
	
	/**
	 * 获取热搜词（转发请求）
	 * @param temp
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "hotkey.action", method = RequestMethod.GET)
	public String getHotKey(@RequestParam("temp") String temp,RedirectAttributes attrs) {
		attrs.addAttribute("temp", temp);
		return "redirect:/topic/hotkey.action";
	}
	/**
	 * 搜索课题（转发请求）
	 * @param key
	 * @param tag
	 * @param index
	 * @param page
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "searchTopic",method = RequestMethod.POST)
	public String searchTopic(@RequestParam("keyWord")String key,@RequestParam("tag") Integer tag,
			@RequestParam("index") Integer index,@RequestParam("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("tag", tag);
		attrs.addAttribute("index", index);
		attrs.addAttribute("page",page);
		attrs.addAttribute("keyWord", key);
		return "redirect:/topic/searchTopic";
	}
	
	@ResponseBody
	@RequestMapping(value = "getstudent",method = RequestMethod.GET)
	public Map<String,Object> getStudent(@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		Map<String,Object> map = new HashMap<>();
		int countOfTeacher = studentService.countStudent();
		map.put("index", index);
		map.put("pages", countOfTeacher%page==0?countOfTeacher/page:countOfTeacher/page+1);
		map.put("data", studentService.selectPage(index*page,page));
		return map;
	}
	/**
	 * 学生选题
	 * @param session
	 * @param topicId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="selectTopic.action",method = RequestMethod.POST)
	public Result selectTopic(HttpSession session,@RequestParam("id")String topicId) {
		String uid = ((SessionValue)session.getAttribute(WebWords.USERSESSION)).getId();
		List<St> list = stService.queryBySid(uid);
		if(list.size()!=0)
			return new Result(false,StatusCode.ERROR,"不能重复选题");
		String topicName = topicService.queryNameById(topicId);
		String studentName = ((SessionValue)session.getAttribute(WebWords.USERSESSION)).getUsername();
		String teacherName = topicService.queryTeacherNameById(topicId);
		Integer effectRows = stService.insert(uid, studentName,topicId,topicName,teacherName);
		if(effectRows>0)
			return new Result(true,StatusCode.OK,"选题成功");
		else
			return new Result(false,StatusCode.ERROR,"出现错误");
	}
	/**
	 * 获取文档分类（转发请求）
	 * @return
	 */
	@RequestMapping(value = "fileclassify.action",method = RequestMethod.GET)
	public String getFileClassify() {
		return "forward:/fileclassify/get";
	}
	/**
	 * 获取个人文档（转发请求）
	 * @param id
	 * @param classify
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "mydocument/{id}/{classify}",method = RequestMethod.GET)
	public String getDoc(@PathVariable("id") String id,@PathVariable("classify") Integer classify, RedirectAttributes attrs) {
		attrs.addAttribute("id", id);
		attrs.addAttribute("classify", classify);
		return "redirect:/docs/getone";
	}
	
	/**
	 * 获取文档分类及对应的状态（完成没）（转发请求）
	 * @param uid
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "proccess",method = RequestMethod.GET)
	public String getStateAndClassify(@RequestParam("uid") String uid,RedirectAttributes attrs) {
		attrs.addAttribute("uid", uid);
		return "forward:/fileclassify/proccess";
	}
	/**
	 * 获取个人课题信息
	 * @param uid
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getMyTopic",method = RequestMethod.GET)
	public String getMyTopic(@RequestParam("uid") String uid,RedirectAttributes attrs) {
		attrs.addAttribute("uid", uid);
		return "forward:/topic/getByUid";
	}
	/**
	 * 根据uid获取进度状态
	 * @param session
	 * @param attrs
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getStates", method = RequestMethod.GET)
	public Result getStatesByuid(HttpSession session,RedirectAttributes attrs) {
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.USERSESSION);
		String uid = sessionValue.getId();
		Process process = processService.queryByUid(uid);
		if(process!=null) {
			List<Short> states = new ArrayList<>();
			states.add(process.getTaskBook());
			states.add(process.getOpenningReport());
			states.add(process.getMidTermCheck());
			states.add(process.getPaper());
			states.add(process.getEvaluation1());
			states.add(process.getEvaluation2());
			states.add(process.getCheckRepetition());
			states.add(process.getAnswerApplication());
			states.add(process.getAnswerRecord());
			return new Result(true,StatusCode.OK,"查询成功",states);
		}else {
			return new Result(false,StatusCode.EMPTYERROR,"无记录");
		}
	}
	
	/**
	 * 文档上传
	 * @param session
	 * @param uploadFile
	 * @param classify
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "uploadfile")
	public Result uploadFile(HttpSession session,@RequestParam("upload-file") MultipartFile uploadFile,@RequestParam("classify") String classify) {
		try {
			SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.USERSESSION);
			Docs newDoc = new Docs();
			String[] docOriginalFilename = uploadFile.getOriginalFilename().split("\\.");
			String docName = docOriginalFilename[0];
			String docType = docOriginalFilename[1];
			String docUrl = "F:\\web\\GDMS\\upload";
			String path = "\\" + classify+sessionValue.getId()+"."+docType;
			logger.debug(classify);
			logger.debug(uploadFile.getOriginalFilename());
			logger.debug(docUrl);
			logger.debug(path);
			File file = new File(docUrl + path);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			uploadFile.transferTo(file);
			Date t = new Date(new java.util.Date().getTime());
			newDoc.setUid(sessionValue.getId());
			newDoc.setClassify(classify);
			newDoc.setDocName(classify+sessionValue.getId());
			newDoc.setDocType(docType);
			newDoc.setDocUrl(docUrl+"\\"+path);
			newDoc.setCreateTime(t);
			newDoc.setState(1);
			docService.addDoc(newDoc);
			processService.updateState(1, sessionValue.getId(), classify);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Result(true,StatusCode.OK,"上传成功");
	}
	
	/**
	 * 个人文档下载
	 * @param response
	 * @param docId
	 * @return
	 */
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
			
			responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),header,HttpStatus.CREATED);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseEntity;
	}
	
	
	
	
	
	@RequestMapping(value = "/studentcenter")
	public String showStudentCenterPage(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.USERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "student/studentcenter";
	}

	@RequestMapping(value = "/st")
	public String showStPage(HttpServletResponse response,HttpSession session) {
		return "student/st";
	}

	@RequestMapping(value = "/document")
	public String showDocumentPage(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.USERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "student/document";
	}

	@RequestMapping(value = "/schedule")
	public String showSchedulePage(HttpServletResponse response,HttpSession session) {
		return "student/schedule";
	}

	@RequestMapping(value = "/stu-info")
	public String showInfoPage(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.USERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "student/info";
	}
	@RequestMapping(value = "mubanfiles")
	public String showMubanfiles(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.USERSESSION);
		/*if(values==null) {
			return "redirect:/login.html";
		}else {
			String role = values.getRole();
			if(role.equals("学生")) {
				response.setHeader("uid", (String)values.getId());
				return "student/mubanfiles";
			}else {
				return "redirect:/401.html";
			}
		}*/
		response.setHeader("uid", (String)values.getId());
		return "student/mubanfiles";
	}
	
	@RequestMapping(value = "notices")
	public String showNotice(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.USERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "student/notices";
	}
	@RequestMapping(value = "mytopic")
	public String showMyTopic(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.USERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "student/mytopic";
	}
	
	
}
