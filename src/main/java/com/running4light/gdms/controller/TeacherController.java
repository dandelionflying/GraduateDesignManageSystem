package com.running4light.gdms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.pojo.Teacher;
import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.StudentService;
import com.running4light.gdms.service.TeacherService;
import com.running4light.gdms.service.TopicService;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private StudentService studentService;
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView teacherLogin(@RequestParam("username") String loginname,
			@RequestParam("password") String password, HttpSession session, ModelAndView mv) {

		Teacher teacher = teacherService.login(loginname, password);
		if(teacher!=null){
			session.setAttribute(WebWords.TEACHERSESSION, teacher);
			mv.setViewName("redirect:teachercenter");
		}else {
			mv.addObject("message", "用户名或密码错误！");
			mv.setViewName("forward:/teacherEntry.html");
		}
		return mv;
	}
	/**
	 * 根据教师姓名获取课题列表（陈露露 测试数据  实际从session或token中获取）
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/topicmanage",method = RequestMethod.GET)
	public String getAlltopic(Model model) {
		List<Topic> topics = topicService.getAllTopics();
		List<Topic> myTopics = topicService.getMyTopic("陈露露");
		if(topics!=null) {
			model.addAttribute("topics", topics);
			model.addAttribute("myTopics", myTopics);
		}
		
		return "teacher/topicmanage";
	}
	@RequestMapping(value="/teachercenter")
	public String show(HttpSession session,Model model) {
		Teacher teacher = (Teacher)session.getAttribute(WebWords.TEACHERSESSION);
		List<Student> students = teacherService.queryMyStudent(teacher.getUsername());
		model.addAttribute("myStudents", students);
		return "teacher/teachercenter";
	}
	/**
	 * 获取该教师下所有学生的信息
	 * @param map
	 * @return
	 */
	@RequestMapping(value="studentTopicMsg.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> studentMsg(@RequestBody Map<String,String> map) {
		Map<String,String> returnMap = new HashMap<String,String>();
		Student student = studentService.queryById(map.get("sId"));
		String topicName = topicService.queryTopicNameByStudentId(map.get("sId"));
		returnMap.put("id",student.getId());
		returnMap.put("username", student.getUsername());
		returnMap.put("className", student.getClassName());
		returnMap.put("mayor", student.getMayor());
		returnMap.put("topicName", topicName);
		String jsonData = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonData = mapper.writeValueAsString(returnMap);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return returnMap;
	}
	@RequestMapping(value="/studentschedule")
	public String studentschedule(HttpSession session) {
		return "teacher/studentschedule";
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
	 * 添加新课题
	 * @param topic
	 * @param model
	 * @return
	 */
	@RequestMapping(value="addNewTopic.action",method=RequestMethod.POST)
	public String addNewTopic(@ModelAttribute Topic topic,Model model) {
		topicService.addTopic(topic);
		return "teacher/topicmanage";
	}
	@RequestMapping(value = "teacherinfo")
	public String teacherinfo() {
		
		return "teacher/tinfo";
	}
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
}
