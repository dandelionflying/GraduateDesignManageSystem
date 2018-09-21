package gdms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import gdms.common.WebWords;
import gdms.model.Student;
import gdms.model.Topic;
import gdms.service.StudentService;
import gdms.service.TopicService;

@Controller
public class StudentController {
	
	@Autowired
	private TopicService topicService;
	@Autowired
	private StudentService studentService;
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
	@RequestMapping(value="/st.action")
	public List<Topic> allTopic(ModelAndView mv) {
		List<Topic> topics = topicService.getAllTopics();
		
		return topics;
	}
	@ResponseBody
	@RequestMapping(value="selectTopic.action")
	public String selectTopic(HttpSession session,@RequestParam("topicId")String topicId) {
		String uid = ((Student)session.getAttribute(WebWords.USERSESSION)).getsId();
		String result = studentService.selectToopic(uid, topicId)?"操作成功！":"操作失败！";
		return result;
	}
}
