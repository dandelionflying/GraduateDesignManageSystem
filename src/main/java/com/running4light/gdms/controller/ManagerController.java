package com.running4light.gdms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.util.StringUtil;
import com.running4light.gdms.common.SessionValue;
import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Manager;
import com.running4light.gdms.pojo.Mubanfiles;
import com.running4light.gdms.pojo.PageResult;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.pojo.Teacher;
import com.running4light.gdms.service.DocService;
import com.running4light.gdms.service.FileService;
import com.running4light.gdms.service.ManagerService;
import com.running4light.gdms.service.MubanfilesService;
import com.running4light.gdms.service.ProcessService;
import com.running4light.gdms.service.StudentService;
import com.running4light.gdms.service.TeacherService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentService;
	@Autowired
	private FileService fileService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private MubanfilesService mubanfilesService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private DocService docService;
	@Autowired
	private ProcessService processService;

	@ResponseBody
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Result managerLogin(HttpServletResponse response,@RequestParam("username") String id,
			@RequestParam("password") String password,HttpSession session) {
//		String psw = managerService.queryPasswordById(id);
		Manager manager = managerService.queryByIdAndPassword(id,password);
		if(manager!=null) {
			SessionValue sessionValue = new SessionValue(manager.getId(),"student",manager.getUsername());
			session.setAttribute(WebWords.MANAGERSESSION, sessionValue);
			response.addHeader("uid", manager.getId());
			return new Result(true,StatusCode.OK,"登录成功");
		}else {
			return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
		}
	}
	@RequestMapping(value = "logout")
	public ModelAndView logout(ModelAndView mv,HttpSession session) {
		session.removeAttribute(WebWords.MANAGERSESSION);
		mv.setViewName("redirect:/managerEntry.html");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "username",method = RequestMethod.GET)
	public Result username(HttpSession session) {
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.MANAGERSESSION);
		String username = sessionValue.getUsername();
		return new Result(true,StatusCode.OK,"查询成功",username);
	}
	/*
	 * 学生信息导入到表格中
	 */
	@RequestMapping("/export")
	public @ResponseBody void export(HttpServletRequest request, HttpServletResponse response) {
	    //String someParam = request.getParameter("someParam");
	    //if(someParam!=""){
	        response.reset(); //清除buffer缓存
	        Map<String,Object> map=new HashMap<String,Object>();
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
	    //}
	}
	/**
	 * 修改密码前的检查
	 * @param session
	 * @param old
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkPsw",method = RequestMethod.POST)
	public Result checkPsw(HttpSession session,String old) {
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.MANAGERSESSION);
		String uid = sessionValue.getId();
		String password = managerService.queryPasswordById(uid);
		if(password.equals(old))
			return new Result(true,StatusCode.OK,"成功");
		else
			return new Result(false,StatusCode.EMPTYERROR,"密码错误");
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
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.MANAGERSESSION);
		String uid = sessionValue.getId();
		Manager manager = new Manager();
		manager.setId(uid);
		manager.setPassword(password);
		int result = managerService.updateByPrimaryKey(manager);
		if(result>0)
			return new Result(true,StatusCode.OK,"修改成功");
		else
			return new Result(false,StatusCode.REMOTEERROR,"操作失败,服务器错误");
		
	}
	/**
	 * 获取个人信息
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getInfo",method = RequestMethod.POST)
	public Result getInfo(HttpSession session) { 
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.MANAGERSESSION);
		String id = sessionValue.getId();
		Manager manager = managerService.selectByPrimaryKey(id);
		if(manager!=null)
			return new Result(true,StatusCode.OK,"查询成功",manager);
		else
			return new Result(false,StatusCode.ERROR,"查询失败");
	}
	/**
	 * 修改个人信息
	 * @param sex
	 * @param email
	 * @param tel
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modifyInfo",method = RequestMethod.POST)
	public Result modifyInfo(@RequestParam("sex") String sex, @RequestParam("email") String email, @RequestParam("tel") String tel,HttpSession session) {
		SessionValue sessionValue = (SessionValue)session.getAttribute(WebWords.MANAGERSESSION);
		String id = sessionValue.getId();
		Manager manager = new Manager();
		manager.setId(id);
		manager.setSex(sex);
		manager.setEmail(email);
		manager.setTel(tel);
		logger.debug("======= "+manager.toString()+"======= ");
		int result = managerService.updateByPrimaryKey(manager);
		if(result>0)
			return new Result(true,StatusCode.OK,"修改成功",manager);
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
	}
	/**
	 * 审核答辩申请表和查重报告
	 * @param docId
	 * @param uid
	 * @param classify
	 * @return
	 */
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
	
	/**
	 * 批量添加教师信息
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add-teachers",method = RequestMethod.POST)
	public Result addTeachers(@RequestParam("file") MultipartFile file) {
		logger.debug("=====================================================");
		logger.debug(file.getOriginalFilename()); 
		Integer result = teacherService.addTeachers(file);
		if(result==0)
			return new Result(true,StatusCode.OK,"添加成功");
		else if(result==1)
			return new Result(false,StatusCode.REPERROR,"有重复id");
		else {
			return new Result(false,StatusCode.REMOTEERROR,"服务器内部错误");
		}
	}
	/**
	 * 批量添加学生信息
	 * @param file
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add-students",method = RequestMethod.POST)
	public Result addStudents(@RequestParam("file") MultipartFile file) {
		logger.debug("=====================================================");
		logger.debug(file.getOriginalFilename()); 
		Integer result = studentService.addStudents(file);
		if(result==0)
			return new Result(true,StatusCode.OK,"添加成功");
		else if(result==1)
			return new Result(false,StatusCode.REPERROR,"有重复id");
		else {
			return new Result(false,StatusCode.REMOTEERROR,"服务器内部错误");
		}
	}
	
	
	/**
	 * ********************转发请求***********************
	 */
	
	@RequestMapping(value = "topics",method = RequestMethod.POST)
	public String topics() {
		return "forward:/topic/passAll";
	}
	
	/**
	 * 获取选题人数
	 * @return
	 */
	@RequestMapping(value = "countSt",method = RequestMethod.GET)
	public String countSt() {
		return "redirect:/st/count";
	}
	/**
	 * 获取待审课题数
	 * @return
	 */
	@RequestMapping(value = "countTopic/{tag}",method = RequestMethod.GET)
	public String countTopicByTag(@PathVariable("tag")Integer tag,RedirectAttributes attrs) {
		attrs.addAttribute("tag", tag);
		return "redirect:/topic/countTopicByTag";
	}
	/**
	 * 获取待审核文档数量
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "countDoc",method = RequestMethod.GET)
	public String countTopic(RedirectAttributes attrs) {
		String[] classifys = {"论文查重报告","答辩申请表"};
		attrs.addAttribute("classifys", classifys);
		return "redirect:/docs/countByClassifys";
	}
	
	/**
	 * 修改教师角色
	 * @param uid
	 * @param rolename
	 * @return
	 */
	@RequestMapping(value = "updateTeacherRole",method = RequestMethod.POST)
	public String updateTeacherRole(@RequestParam("uid")String uid,@RequestParam("rolename")String rolename) {
		
		
		return "forward:/teacher/updateTeacherRole";
	}
	
	
	/**
	 * 分页获取成绩
	 * @param index
	 * @param page
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getGradePage/{index}/{page}",method = RequestMethod.GET)
	public String getGradePage(@PathVariable("index") Integer index, @PathVariable("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/grade/get";
	}
	
	
	
	/**
	 * 根据id下载文档（转发请求）
	 * @param id
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "downloadDoc/{id}",method = RequestMethod.GET)
	public String downloadDoc(@PathVariable("id") Integer id,RedirectAttributes attrs) {
		attrs.addAttribute("id", id);
		return "redirect:/docs/download";
	}
	/**
	 * 分页获取论文查重报告、答辩申请表（转发请求）
	 * @param index
	 * @param page
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getByClassifys/{index}/{page}",method = RequestMethod.GET)
	public String getByClassifys(@PathVariable("index")Integer index,@PathVariable("page")Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page",page);
		String[] classifys = {"论文查重报告","答辩申请表"};
		attrs.addAttribute("classifys", classifys);
		return "redirect:/docs/getByClassifys";
	}
	
	
	/**
	 *获取学生文档列表（转发请求）
	 * @param index
	 * @param page
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getalldocs/{index}/{page}",method = RequestMethod.GET)
	public String getAllStudentDocs(@PathVariable("index") Integer index, @PathVariable("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/docs/get";
	}
	/**
	 * 批量删除模板文件（转发请求）               这里出现404 先不转发
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deleteMubanFiles",method = RequestMethod.POST)
	public Result deleteItems(@RequestParam("ids")Integer[] ids) {
		
		if(mubanfilesService.deleteItems(ids))
			return new Result(true,StatusCode.OK,"删除成功");
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
	}
	/**
	 * 删除模板文件（转发请求）
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteMubanFile",method = RequestMethod.POST)
	public String deleteMubanFile(@RequestParam("id") Integer id) {
		return "forward:/mubanfile/delete";
	}
	/**
	 * 获取模板文件列表（分页）
	 * @param index
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get-muban-file-all/{index}/{size}", method = RequestMethod.GET)
	public PageResult<Mubanfiles> getAllMubanFile(@PathVariable("index") Integer index,@PathVariable("size") Integer size) {
		List<Mubanfiles> list = mubanfilesService.selectPage(index*size,size);
		Integer total = mubanfilesService.countSelectAll();
		int pages = total%size==0?total/size:total/size+1;
		if(list!=null)
			return new PageResult<Mubanfiles>(pages,list);
		else
			return new PageResult<Mubanfiles>(0,null);
	}
	/**
	 * 根据id下载文件
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "get-muban-file",method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@RequestParam("id") int docId) {
		String url = null;
		StringTokenizer stringToken = null;
		String fileName = null;
		ResponseEntity<byte[]> responseEntity = null;
		try {
			Mubanfiles mubanfiles = mubanfilesService.selectByPrimaryKey(docId);
			url = mubanfiles.getUrl();
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
	/**
	 * 添加模板文件
	 * @param uploadFile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add-muban-file",method = RequestMethod.POST)
	public Result addMubanFile(@RequestParam("file") MultipartFile uploadFile,@RequestParam("towho") Short towho) {
		
		Mubanfiles mubanFiles = mubanfilesService.addMubanFile(uploadFile,towho);
		if(mubanFiles!=null)
			return new Result(true,StatusCode.OK,"操作成功",mubanFiles);
		else
			return new Result(true,StatusCode.ERROR,"操作失败");
	}
	/**
	 * 获取所有通知（转发请求）
	 * @return
	 */
	@RequestMapping(value = "getnotice",method = RequestMethod.GET)
	public String getNotice() {
		return "forward:/notice/get";
	}
	/**
	 * 发布新通知（转发请求）
	 * @param receiver
	 * @param content
	 * @return
	 */
	@RequestMapping(value = "addnotice",method = RequestMethod.POST)
	public String addNotice(@RequestParam("receiver") Short receiver,@RequestParam("content") String content) {
		return "forward:/notice/add";
	}
	/**
	 * 删除通知（转发请求）
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteNotice",method = RequestMethod.POST)
	public String deleteNotice(@RequestParam("id") Integer id) {
		
		return "forward:/notice/delete";
	}
	
	
	/**
	 * 分页获得所有学生信息（转发请求）
	 * @param index
	 * @param page
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value = "getstudent/{index}/{page}",method = RequestMethod.GET)
	public String students(@PathVariable("index") Integer index,@PathVariable("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/student/getstudent";
	}
	/**
	 * 获取所有教师信息（转发请求）
	 * @return
	 */
	@RequestMapping(value = "getteacher/{index}/{page}",method = RequestMethod.GET)
	public String teachers(@PathVariable("index") Integer index,@PathVariable("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/teacher/getteacher";
	}
	/**
	 * 根据学生学号搜索选题情况（转发请求）
	 * @param key
	 * @return
	 */
	@RequestMapping(value = "searchst",method = RequestMethod.POST)
	public String searchSt(@RequestParam("key") String key) {
		return "forward:/st/searchst";
	}
	/**
	 * 根据tag、关键词、课题类型搜索课题（转发请求）
	 * @param tag
	 * @param key
	 * @param classify
	 * @return
	 */
	@RequestMapping(value = "searchTopic",method = RequestMethod.POST)
	public String searchTopic(@RequestParam("tag") int tag,@RequestParam("key") String key,@RequestParam("classify") String classify,@RequestParam("index") Integer index,@RequestParam("page") Integer page) {
		return "forward:/topic/searchTopic";
	}
	
	/**
	 * 获取所有课题类型（转发请求）
	 * @return
	 */
	@RequestMapping(value = "get-topicclassify-name",method = RequestMethod.GET)
	public String getTopicClassifyName() {
		return "forward:/topic/getTopicClassifyName";
	}
	/**
	 * 审核课题（转发请求）
	 * @param id
	 * @param tag
	 * @return
	 */
	@RequestMapping(value = "changeTopicState",method = RequestMethod.POST)
	public String changeTopicState(@RequestParam("id") int id,@RequestParam("tag") int tag) {
		return "forward:/topic/changeTopicState";
	}
	/**
	 * 获取所有states（转发请求到StatesController）
	 * @return
	 */
	@RequestMapping(value= "getstates")
	public String getstates(){
		return "forward:/states/getstates";
	}
	/**
	 * 修改states（转发请求到StatesController）
	 * @param id 参数会自动转发
	 * @param state
	 * @return
	 */
	@RequestMapping(value= "changeState",method=RequestMethod.POST)
	public String changeStates(@RequestParam("id") Integer id,@RequestParam("state") String state){
		return "forward:/states/changeState";
	}
	
	/**
	 * 根据审核状态获取课题 0:未审核 1：已驳回 2：已通过（该状态下的课题学生才可见）(转发请求)
	 * @return
	 */
	
	@RequestMapping(value = "getTopics/{tag}/{index}/{page}",method = RequestMethod.GET)
	public String getTopicsByTag(@PathVariable("tag") Integer tag,@PathVariable("index") Integer index,@PathVariable("page") Integer page,RedirectAttributes attrs){
		attrs.addAttribute("tag", tag);
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/topic/getTopics";
		
	}
	/**
	 * 获取选题列表（转发请求到StController）
	 * @return
	 */
	
	@RequestMapping(value = "getall/{index}/{page}",method = RequestMethod.GET)
	public String getAll(@PathVariable("index") Integer index,@PathVariable("page") Integer page,RedirectAttributes attrs) {
		attrs.addAttribute("index", index);
		attrs.addAttribute("page", page);
		return "redirect:/st/getall";
	}
	/**
	 * 审核通过列表
	 * @return
	 */
	@RequestMapping(value="/topiclist2")
	public String toTopicList2() {
		return "edumanager/topiclist2";
	}
	/**
	 * 待审核列表
	 * @return
	 */
	@RequestMapping(value="/topiclist1")
	public String toTopicList1() {
		return "edumanager/topiclist";
	}
	/**
	 * 已驳回列表
	 * @return
	 */
	@RequestMapping(value="/topiclist3")
	public String toTopicList3() {
		return "edumanager/topiclist3";
	}
	/**
	 * 选题详情
	 * @return
	 */
	@RequestMapping(value = "stdetails")
	public String toStdetails() {
		return "edumanager/stdetails";
	}
	
	@RequestMapping("/teacherManage")
	public String toTeacherManager() {
		return "edumanager/teachermanage";
	}
	@RequestMapping("/studentManage")
	public String toStudentManager() {
		return "edumanager/stumanage";
	}
	@RequestMapping(value = "toNotice")
	public String toNotice() {
		return "edumanager/notice";
	}
	@RequestMapping(value = "edumanagercenter")
	public String toIndex() {
		
		return "edumanager/edumanagercenter";
	}
	@RequestMapping(value = "file-muban")
	public String toFileMuban() {
		return "edumanager/file-muban";
	}
	@RequestMapping(value = "file-student")
	public String toStudentFile() {
		return "edumanager/file-student";
	}
	@RequestMapping(value = "managerinfo")
	public String managerinfo() {
		return "edumanager/info";
	}
	@RequestMapping(value = "grade")
	public String grade() {
		return "edumanager/grade";
	}
	@RequestMapping(value = "application")
	public String application() {
		return "edumanager/application";
	}
}
