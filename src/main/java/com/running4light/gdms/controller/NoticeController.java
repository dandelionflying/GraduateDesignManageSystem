package com.running4light.gdms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Notice;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	@ResponseBody
	@RequestMapping(value = "get",method = RequestMethod.GET)
	public Result get() {
		List<Notice> notices = noticeService.selectAll();
		
		return new Result(true,StatusCode.OK,"操作成功",notices);
	}
	@ResponseBody
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public Result add(Short receiver,String content) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String time = sdf.format(now);
		Date date = null;
		try {
			date = sdf.parse(time);
			System.out.println(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Notice notice = new Notice(content,date,"manager",new Short("1"),receiver);
		//先测试  publilsher和deptid拟从session中取
		int result = noticeService.insert(notice);
		if(result>0)
			return new Result(true,StatusCode.OK,"添加成功");
		else
			return new Result(false,StatusCode.ERROR,"添加失败");
	}
	
}
