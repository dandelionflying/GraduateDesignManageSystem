package com.running4light.gdms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.pojo.St;
import com.running4light.gdms.service.StService;

@Controller
@RequestMapping(value = "st")
public class StController {

	@Autowired
	private StService stService;
	@ResponseBody
	@RequestMapping(value = "getall",method = RequestMethod.GET)
	public Map<String,Object> getAll(@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		Map<String,Object> map = new HashMap<>();
		Integer count = stService.countst();
		map.put("index", index);
		map.put("pages", count%page==0?count/page:count/page+1);
		map.put("result", stService.queryPage(index,page));
		return map;
	}
	/**
	 * 获取所有课题类型
	 * @param key
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "searchst",method = RequestMethod.POST)
	public List<St> getStBySid(String key){
		return stService.queryBySid(key);
	}
	@ResponseBody
	@RequestMapping(value = "getByUid",method=RequestMethod.GET)
	public Result getByUid(@RequestParam("uid") String uid) {
		St st = stService.queryBySid(uid).get(0);
		if(st!=null)
			return new Result(true,StatusCode.OK,"查询成功",st);
		else
			return new Result(false,StatusCode.ERROR,"没有该选课记录");
	}
	
	@ResponseBody
	@RequestMapping(value = "getSids",method = RequestMethod.GET)
	public Result getSIDByTeacherName(@RequestParam("teacherName") String teacherName) {
		List<String> ids = stService.queryUidByTeachername(teacherName);
		if(ids.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",ids);
		else
			return new Result(false,StatusCode.EMPTYERROR,"无记录",ids);
		
	}
	@ResponseBody
	@RequestMapping(value = "count",method = RequestMethod.GET)
	public Result countAll() {
		Integer count = stService.countst();
		if(count>0)
			return new Result(true,StatusCode.OK,"查询成功",count);
		else
			return new Result(false,StatusCode.EMPTYERROR,"没有记录");
			
	}
}
