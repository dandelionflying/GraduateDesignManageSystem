package com.running4light.gdms.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.util.StringUtil;
import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.service.FileService;
import com.running4light.gdms.service.ManagerService;
import com.running4light.gdms.service.StudentService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private FileService fileService;
	@Autowired
	private ManagerService managerService;
	


	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView managerLogin(@RequestParam("username") String id,
			@RequestParam("password") String password,HttpSession session,ModelAndView mv) {
		String psw = managerService.queryPasswordById(id);
//		Manager manager = managerService.queryByIdAndPassword(id,password);
		Map<String,Object> manager = new HashMap<>();
		if(!StringUtil.isEmpty(psw)){
			if(psw.equals(password)) {
				manager.put("id", id);
				manager.put("id", password);
				session.setAttribute(WebWords.MANAGERSESSION, manager);
				mv.setViewName("redirect:edumanagercenter");
			}else {
				mv.addObject("message", "用户名或密码错误！");
				mv.setViewName("forward:/managerEntry.html");
			}
		}else {
			mv.addObject("message", "没有该用户！");
			mv.setViewName("forward:/managerEntry.html");
		}
		return mv;
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
}
