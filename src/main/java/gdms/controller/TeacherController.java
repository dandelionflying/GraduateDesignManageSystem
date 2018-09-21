package gdms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gdms.common.WebWords;
import gdms.model.Student;
import gdms.model.Teacher;
import gdms.service.TeacherService;
import gdms.service.TopicService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/teachercenter")
	public String show(HttpSession session,Model model) {
		Teacher teacher = (Teacher)session.getAttribute(WebWords.USERSESSION);
		List<Student> students = teacherService.queryMyStudent(teacher.getTeacherName());
		model.addAttribute("myStudents", students);
		return "teacher/teachercenter";
	}
	@RequestMapping(value="studentTopicMsg.action",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> studentMsg(@RequestBody Map<String,String> map) {
		Map<String,String> returnMap = new HashMap<String,String>();
		Student student = teacherService.queryMyStudentById(map.get("sId"));
		String topicName = topicService.getTopicNameByStudent(map.get("sId"));
		returnMap.put("sId",student.getsId());
		returnMap.put("studentName", student.getStudentName());
		returnMap.put("className", student.getClassName());
		returnMap.put("sMayor", student.getS_Mayor());
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
}
