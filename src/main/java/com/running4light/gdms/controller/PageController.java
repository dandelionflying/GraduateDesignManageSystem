package com.running4light.gdms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	
	@RequestMapping(value="document")
	public String showDocs() {
		
		return "student/document";
	}
	
}
