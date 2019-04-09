package com.running4light.gdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.pojo.Fileclassify;
import com.running4light.gdms.service.FileclassifyService;

@Controller
@RequestMapping("/fileclassify")
public class FileclassifyController {
	
	@Autowired
	private FileclassifyService fileclassifyService;
	@ResponseBody
	@RequestMapping(value="/fileclassify.action",method=RequestMethod.GET)
	public List<Fileclassify> getAll(){
//		response.setCharacterEncoding("UTF-8");
		return fileclassifyService.selectAll();
	}
}
