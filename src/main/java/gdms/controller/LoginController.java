package gdms.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gdms.common.WebWords;
import gdms.model.Student;
import gdms.model.Teacher;
import gdms.service.StudentService;
import gdms.service.TeacherService;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private StudentService studentSerivice;
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(value = "/userlogin")
	public ModelAndView userLogin(@RequestParam("username") String loginname,
			@RequestParam("password") String password, HttpSession session, ModelAndView mv) {
		
		
		
		
		
		Student student = studentSerivice.studentLogin(loginname, password);
		Teacher teacher = teacherService.login(loginname, password);
		if(student!=null) {
			session.setAttribute(WebWords.USERSESSION, student);
			mv.setViewName("redirect:studentcenter");
		}else if(teacher!=null){
			session.setAttribute(WebWords.USERSESSION, teacher);
			mv.setViewName("redirect:teachercenter");
		}else {
			mv.addObject("message", "用户名或密码错误！");
			mv.setViewName("forward:/login.html");
		}
		
		
		return mv;
	}
	
	@RequestMapping(value="/loginout")
	public ModelAndView loginout(HttpSession session,ModelAndView mv) {
		session.removeAttribute(WebWords.USERSESSION);
		mv.setViewName("forward:/login.html");
		return mv;
	}

}
