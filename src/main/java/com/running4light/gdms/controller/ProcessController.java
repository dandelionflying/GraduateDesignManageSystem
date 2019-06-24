package com.running4light.gdms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Process;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.ProcessService;

@Controller
@RequestMapping("process")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	@ResponseBody
	@RequestMapping(value = "getAllStatesByuid",method = RequestMethod.GET)
	public Result getAllStatesByuid(HttpSession session,@RequestParam("uid")String uid) {
		Process process = processService.queryByUid(uid);
		if(process!=null) {
			List<Short> states = new ArrayList<>();
			states.add(process.getTaskBook());
			states.add(process.getOpenningReport());
			states.add(process.getMidTermCheck());
			states.add(process.getPaper());
			states.add(process.getEvaluation1());
			states.add(process.getEvaluation2());
			states.add(process.getCheckRepetition());
			states.add(process.getAnswerApplication());
			states.add(process.getAnswerRecord());
			return new Result(true,StatusCode.OK,"查询成功",states);
		}else {
			return new Result(false,StatusCode.EMPTYERROR,"无记录");
		}
	}
}
