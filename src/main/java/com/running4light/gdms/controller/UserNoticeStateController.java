package com.running4light.gdms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.pojo.UserNoticeState;
import com.running4light.gdms.service.UserNoticeStateService;

@Controller
@RequestMapping("usernoticestate")
public class UserNoticeStateController {
	@Autowired
	private UserNoticeStateService userNoticeStateService;
	
	@ResponseBody
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public Result insert(String uid,Integer noticeid) {
		UserNoticeState record = new UserNoticeState();
		record.setUid(uid);
		record.setNoticeId(noticeid);
		record.setState(new Integer(1));
		if(userNoticeStateService.insert(record)>0)
			return new Result(true,StatusCode.OK,"操作成功");
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
	}
}
