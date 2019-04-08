package com.running4light.gdms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.StService;
import com.running4light.gdms.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private StService stService;
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("username") String loginname,
			@RequestParam("password") String password, HttpSession session, ModelAndView mv) {

		Student student = studentService.studentLogin(loginname, password);
	
		
		if(student!=null) {
			session.setAttribute(WebWords.USERSESSION, student);
			mv.setViewName("redirect:studentcenter");
		}else {
			mv.addObject("message", "用户名或密码错误！");
			mv.setViewName("forward:/login.html");
		}
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "getstudent",method = RequestMethod.GET)
	public Map<String,Object> getStudent(@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		Map<String,Object> map = new HashMap<>();
		int countOfTeacher = studentService.countStudent();
		map.put("index", index);
		map.put("pages", countOfTeacher%page==0?countOfTeacher/page:countOfTeacher/page+1);
		map.put("data", studentService.selectPage(index,page));
		return map;
	}
	@RequestMapping(value = "/studentcenter")
	public String showStudentCenterPage(HttpSession session, Model model) {
		return "student/studentcenter";
	}

	@RequestMapping(value = "/st")
	public String showStPage() {
		return "student/st";
	}

	/*@RequestMapping(value = "/document")
	public String showDocumentPage() {
		return "student/document";
	}*/

	@RequestMapping(value = "/schedule")
	public String showSchedulePage() {
		return "student/schedule";
	}

	@RequestMapping(value = "/stu-info")
	public String showInfoPage() {
		return "student/info";
	}
	
	@ResponseBody
	@RequestMapping(value="selectTopic.action")
	public String selectTopic(HttpSession session,@RequestParam("id")String topicId) {
//		String uid = ((Student)session.getAttribute(WebWords.USERSESSION)).getId();
//		String result = stService.insert(uid, topicId)==1?"操作成功！":"不能重复选题！";
		return null;
	}
}
