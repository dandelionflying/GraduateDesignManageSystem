package com.running4light.gdms.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.StudentService;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/loginout")
	public ModelAndView loginout(HttpSession session,ModelAndView mv) {
		session.removeAttribute(WebWords.USERSESSION);
		mv.setViewName("forward:/login.html");
		return mv;
	}

}
