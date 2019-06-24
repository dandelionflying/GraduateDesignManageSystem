package com.running4light.gdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.DocStateClassify;
import com.running4light.gdms.pojo.Fileclassify;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.FileclassifyService;

@Controller
@RequestMapping("/fileclassify")
public class FileclassifyController {
	
	@Autowired
	private FileclassifyService fileclassifyService;
	@ResponseBody
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public Result getAll(){
//		response.setCharacterEncoding("UTF-8");
		List<Fileclassify> list = fileclassifyService.selectAll();
		if(list!=null)
			return new Result(true,StatusCode.OK,"查询成功",list);
		else
			return new Result(true,StatusCode.OK,"查询成功");
	}
	
	@ResponseBody
	@RequestMapping(value = "proccess",method = RequestMethod.GET)
	public Result getStateAndClassify(@RequestParam("uid") String uid) {
//		List<String> classifys = fileclassifyService.selectAllNames();
		List<DocStateClassify> stateAndClassifys = fileclassifyService.selectStateClassify(uid);
		if(stateAndClassifys.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",stateAndClassifys);
		else
			return new Result(false,StatusCode.ERROR,"查询失败");
	}
}
