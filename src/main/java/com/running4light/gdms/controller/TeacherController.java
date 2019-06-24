package com.running4light.gdms.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.HashMap;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.running4light.gdms.pojo.StudentResult;
import com.running4light.gdms.pojo.Teacher;
import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.DocService;
import com.running4light.gdms.service.ProcessService;
import com.running4light.gdms.service.RoleService;
import com.running4light.gdms.service.TeacherService;
import com.running4light.gdms.service.TopicService;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private DocService docService;
	@Autowired
	private ProcessService processService;
	@Autowired
	private RoleService roleService;
	/**
	 * 登录
	 * @param response
	 * @param loginname 工号
	 * @param password 密码
	 * @param session
	 * @param mv
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public Result userLogin(HttpServletResponse response,@RequestParam("username") String loginname,
			@RequestParam("password") String password, HttpSession session, ModelAndView mv) {
		logger.debug("======= 教师sessionid  =======  "+session.getId());
		Teacher teacher = teacherService.login(loginname, password);
		if(teacher!=null) {
			String role = roleService.queryRolenameById(teacher.getId());
			SessionValue sessionValue = new SessionValue(teacher.getId(),role,teacher.getUsername());
			session.setAttribute(WebWords.TEACHERSESSION, sessionValue);
			response.addHeader("uid", teacher.getId());
			response.addHeader("role", role);
			if(teacher.getPassword().equals("12345678"))
				return new Result(true,StatusCode.OK,"登录成功,密码不安全，请尽快修改！",role);
			else
				return new Result(true,StatusCode.OK,"登录成功",role);
		}else {
			return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
		}
	}
	/**
	 * 注销
	 * @param mv
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "logout")
	public ModelAndView logout(ModelAndView mv,HttpSession session) {
		session.invalidate();
		mv.setViewName("redirect:/teacherEntry.html");
		return mv;
	}
	/**
	 * 上传评阅教师评价表
	 * @param session
	 * @param uploadFile
	 * @param uid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "uploadfileEvaluation")
	public Result uploadfileEvaluation(HttpSession session,@RequestParam("upload-file") MultipartFile uploadFile,@RequestParam("uid")String uid) {
		try {
			Docs newDoc = new Docs();
			String[] docOriginalFilename = uploadFile.getOriginalFilename().split("\\.");
			String docName = docOriginalFilename[0];
			String docType = docOriginalFilename[1];
			String docUrl = "F:\\web\\GDMS\\upload";
			String classify = "评阅老师评阅表";
			String path = "\\" + classify+uid+"."+docType;
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
			newDoc.setUid(uid);
			newDoc.setClassify(classify);
			newDoc.setDocName(classify+uid);
			newDoc.setDocType(docType);
			newDoc.setDocUrl(docUrl+"\\"+path);
			newDoc.setCreateTime(t);
			newDoc.setState(1);
			docService.addDoc(newDoc);
			processService.updateState(1, uid, classify);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Result(true,StatusCode.OK,"上传成功");
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
	public Result uploadFile(HttpSession session,@RequestParam("upload-file") MultipartFile uploadFile,@RequestParam("uid")String uid) {
		try {
			SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.USERSESSION);
			Docs newDoc = new Docs();
			String[] docOriginalFilename = uploadFile.getOriginalFilename().split("\\.");
			String docName = docOriginalFilename[0];
			String docType = docOriginalFilename[1];
			String docUrl = "F:\\web\\GDMS\\upload";
			/*String docUrl = "/home/upload";*/
			String classify = "指导老师评阅表";
			String path = "\\" + classify+uid+"."+docType;
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
			newDoc.setUid(uid);
			newDoc.setClassify(classify);
			newDoc.setDocName(classify+uid);
			newDoc.setDocType(docType);
			newDoc.setDocUrl(docUrl+"\\"+path);
			newDoc.setCreateTime(t);
			newDoc.setState(1);
			docService.addDoc(newDoc);
			processService.updateState(1, uid, classify);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Result(true,StatusCode.OK,"上传成功");
	}
	/**
	 * 获取进度
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getprocess",method = RequestMethod.GET)
	public Result getProcess(HttpSession session) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String username = sessionValue.getUsername();
		List<Process> process = processService.selectByTeacher(username);
		if(process.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",process);
		else
			return new Result(true,StatusCode.EMPTYERROR,"无记录");
		
	}
	/**
	 * 根据工号查询教师信息
	 * @param uid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getinfo",method = RequestMethod.GET)
	public Result getInfo(@RequestParam("uid") String uid) {
		Teacher teacher = teacherService.selectByPrimaryKey(uid);
		if(teacher!=null) {
			return new Result(true,StatusCode.OK,"查询成功",teacher);
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
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String uid = sessionValue.getId();
		String pswFromDB = teacherService.getPsw(uid);
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
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String uid = sessionValue.getId();
		int result = teacherService.updatePassword(uid,password);
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
		int result = teacherService.updatePassword(uid,password);
		if(result>0) {
			return new Result(true,StatusCode.OK,"修改成功");
		}
		else
			return new Result(false,StatusCode.REMOTEERROR,"服务器错误");
	}
	
	/**
	 * 修改教师个人信息
	 * @param session
	 * @param sex
	 * @param email
	 * @param tel
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modifyInfo",method = RequestMethod.POST)
	public Result modifyInfo(HttpSession session,@RequestParam("sex")String sex,@RequestParam("email")String email,@RequestParam("tel")String tel) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String uid = sessionValue.getId();
		Teacher teacher = new Teacher();
		teacher.setId(uid);;
		teacher.setSex(sex);
		teacher.setEmail(email);
		teacher.setTel(tel);
		Integer result = teacherService.updateByPrimaryKey(teacher);
		logger.debug("==== update查询返回结果===="+result);
		if(result>0)
			return new Result(true,StatusCode.OK,"修改成功",teacher);
		else
			return new Result(false,StatusCode.REMOTEERROR,"操作失败");
		
	}

	/**
	 * 获取该教师下所有学生的信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="getStudents",method=RequestMethod.POST)
	@ResponseBody
	public Result studentMsg(@RequestParam("uid")String uid,HttpSession session) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String teacherName = sessionValue.getUsername();
		List<StudentResult> students = teacherService.queryMyStudent(teacherName);
		
		if(students.size()>0) {
			return new Result(true,StatusCode.OK,"查询成功",students);
		}else {
			return new Result(false,StatusCode.EMPTYERROR,"未查询到信息");
		}
	}
	/**
	 * 添加新课题(或更新)
	 * @param topic
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="addNewTopic.action",method=RequestMethod.POST)
	public Result addNewTopic(@ModelAttribute Topic topic,Model model) {
		Topic oldtopic = topicService.queryById(topic.getId());
		//先判断要修改的记录存不存在，存在就执行更新操作，不存在就执行insert操作
		if(oldtopic!=null){
			topic.setId(oldtopic.getId());
			/*topic.setTag(oldtopic.getTag());
			topic.setState(oldtopic.getState());*/
			int result = topicService.updateByPrimaryKey(topic);
			if(result>0)
				return new Result(true,StatusCode.OK,"更新成功");
			else
				return new Result(false,StatusCode.REMOTEERROR,"操作失败");
		}
		if(topicService.addTopic(topic)) {
			return new Result(true,StatusCode.OK,"添加成功");
		}else
			return new Result(false,StatusCode.REMOTEERROR,"操作失败");
	}
	/**
	 * 分页获取教师信息（其他控制器转发调用）
	 * @param index
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getteacher",method = RequestMethod.GET)
	public Map<String, Object> getTeacher(@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		Map<String,Object> map = new HashMap<>();
		int countOfTeacher = teacherService.countTeacher();
		map.put("index", index);
		map.put("pages", countOfTeacher%page==0?countOfTeacher/page:countOfTeacher/page+1);
		map.put("data", teacherService.selectPage(index,page));
		return map;
	}
	/**
	 * 更新教师角色
	 * @param uid
	 * @param role
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateTeacherRole",method = RequestMethod.POST)
	public Result updateTeacherRole(String uid,String rolename) {
		Teacher teacher = new Teacher();
		teacher.setId(uid);
		teacher.setIdentity(rolename);
		logger.debug("========"+rolename);
		Integer result = teacherService.updateByPrimaryKey(teacher);
		if(result>0)
			return new Result(true,StatusCode.OK,"修改成功");
		else
			return new Result(false,StatusCode.REMOTEERROR,"操作失败");
	}
	
	
	/**-----------------------------------------------------------------------------
	 * -----------------------------------转发请求-----------------------------------
	 * -----------------------------------------------------------------------------
	 */
	
	@RequestMapping(value = "updateGTGrade",method = RequestMethod.POST)
	public String updateGTGrade(@RequestParam("id")Short id,@RequestParam("guider")Integer guider,@RequestParam("translate")Integer translate) {
		
		return "forward:/grade/updateGTGrade";
	}
	
	@RequestMapping(value = "updateEvaluation",method = RequestMethod.POST)
	public String updateEvaluation(@RequestParam("id")Short id,@RequestParam("grade")Integer grade) {
		
		return "forward:/grade/updateEvaluation";
	}
	
	@RequestMapping(value = "getGradesByGuider/{index}/{page}",method = RequestMethod.GET)
	public String getGradesByGuider(HttpSession session,RedirectAttributes attrs,@PathVariable("index") Integer index,@PathVariable("page") Integer page) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String teacherName = sessionValue.getUsername();
		attrs.addAttribute("teacherName", teacherName);
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/grade/getGradesByGuider";
		
	}
	@RequestMapping(value = "getGradesByClass/{index}/{page}",method = RequestMethod.GET)
	public String getGradesByClass(HttpSession session,RedirectAttributes attrs,@PathVariable("index") Integer index,@PathVariable("page") Integer page) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String uid = sessionValue.getId();
		attrs.addAttribute("uid", uid);
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/grade/getGradesByClass";
		
	}
	
	
	@RequestMapping(value = "deleteTopic",method = RequestMethod.POST)
	public String deleteTopic(@RequestParam("topicId")String topicId) {
		return "forward:/topic/delete";
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
	 * 获取当前教师的课题信息（转发请求）
	 * @param session
	 * @param response
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getmytopic/{index}/{size}",method = RequestMethod.GET)
	public String getmytopic(HttpSession session,@PathVariable("index") Integer index,@PathVariable("size") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/topic/getbyteacher";
	}
	
	/**根据topicid获取content
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="topicContent.action")
	@ResponseBody
	public String topicContent(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		return topicService.getContent(request.getParameter("topicId"));
	}
	
	/**
	 * 获取学生文档列表（转发请求）（指导教师）
	 * @param session
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getstudocslist",method = RequestMethod.POST)
	public String studentdocs(HttpSession session,RedirectAttributes attrs) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		String teachername = values.getUsername();
		attrs.addAttribute("teachername", teachername);
		return "redirect:/docs/getwithteacher";
	}
	/**
	 * 获取学生文档列表（转发请求）(评阅教师)
	 * @param session
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getstudocslist2",method = RequestMethod.POST)
	public String studentdocs2(HttpSession session,RedirectAttributes attrs) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		String uid = values.getId();
		attrs.addAttribute("uid", uid);
		return "redirect:/docs/getwithteacher2";
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
	 * 获取教师对应学生id（转发请求）
	 * @param session
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getSids",method = RequestMethod.POST)
	public String getSids(HttpSession session,RedirectAttributes attrs) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		String teachername = values.getUsername();
		attrs.addAttribute("teacherName", teachername);
		return "redirect:/st/getSids";
	}
	/**
	 * 分页获取通知（转发请求）
	 * @param receiver
	 * @param index
	 * @param size
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getNotices/{receiver}/{index}/{size}",method = RequestMethod.GET)
	public String getNotices(@PathVariable("receiver") Integer receiver,@PathVariable("index") Integer index,@PathVariable("size") Integer size,RedirectAttributes attrs) {
		attrs.addAttribute("receiver", receiver);
		attrs.addAttribute("index", index);
		attrs.addAttribute("size", size);
		return "redirect:/notice/get/{receiver}/{index}/{size}";
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
	 * 筛选文档（转发请求）
	 * @param classify
	 * @param uids
	 * @return
	 */
	@RequestMapping(value = "searchdoc",method = RequestMethod.POST)
	public String searchDoc(@RequestParam("classify") String[] classify,@RequestParam("uids")String[] uids) {
		return "forward:/docs/searchdoc";
	}
	
	@RequestMapping(value = "searchdocbyclassify",method = RequestMethod.POST)
	public String searchDocByclassify(@RequestParam("classify") String[] classify) {
		return "forward:/docs/searchdocbyclassify";
	}
	/**
	 * 下载学生文档
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
	@ResponseBody
	@RequestMapping(value = "changestate",method = RequestMethod.POST)
	public Result updatestate(@RequestParam("docid")Integer docId,@RequestParam("uid")String uid,@RequestParam("classify")String classify) {
		
		int result1 = docService.updateStateByPrimaryKey(2,docId);
		int result2 = processService.updateState(2,uid,classify);
		if(result1 > 0 && result2 > 0)
			return new Result(true,StatusCode.OK,"修改成功");
		else
			return new Result(false,StatusCode.REMOTEERROR,"操作失败");
	}
	
	
	
	/**-----------------------------------------------------------------------------
	 * -----------------------------------页面渲染-----------------------------------
	 * -----------------------------------------------------------------------------
	 */
	

	@RequestMapping(value="/topicmanage")
	public String getAlltopic(HttpSession session) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String uid = sessionValue.getId();
		return "teacher/topicmanage";
	}
	
	@RequestMapping(value = "notice")
	public String teachernotice(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/tnotice";
	}
	@RequestMapping(value = "teacherinfo")
	public String teacherinfo(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/tinfo";
	}
	@RequestMapping(value = "teacherinfo2")
	public String teacherinfo2(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/tinfo2";
	}
	
	@RequestMapping(value="/studentschedule")
	public String studentschedule(HttpSession session) {
		return "teacher/studentschedule";
	}
	/**
	 * 指导教师
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/teachercenter")
	public String show(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/teachercenter";
	}
	/**
	 * 评阅教师
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/teachercenter2")
	public String show2(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/teachercenter2";
	}
	@RequestMapping(value="/evaluation")
	public String evalution2(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/evaluation";
	}
	@RequestMapping(value="/guider-grade")
	public String evalution1(HttpServletResponse response,HttpSession session) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());
		return "teacher/evaluation-guider";
	}
	@RequestMapping(value = "tdocument")
	public String tdocument(HttpServletResponse response,HttpSession session) {
		/*SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		response.setHeader("uid", (String)values.getId());*/
		return "teacher/tdocument";
	}
}
