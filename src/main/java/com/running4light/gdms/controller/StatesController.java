package com.running4light.gdms.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.pojo.States;
import com.running4light.gdms.service.StatesService;

@Controller
@RequestMapping("states")
public class StatesController {

	@Autowired
	private StatesService statesService;
	/*@ResponseBody
	@RequestMapping(value = "changeState",method = RequestMethod.POST)
	public String changeState(Map<String,Object> map) {//换成Map接收，没有接收到值 但能跳转了
		States states = new States();
		states.setId((Integer)map.get("id"));
		states.setState((String)map.get("state"));
		
		return String.valueOf(statesService.updateByPrimaryKey(states));
	}*/
	/*@ResponseBody
	@RequestMapping(value = "changeState",method = RequestMethod.PUT)
	public String changeState(@RequestParam("id") Integer id,@RequestParam("state") String state) {
		States states = new States();
		states.setId(id);
		states.setState(state);
		String result =String.valueOf(statesService.updateByPrimaryKey(states)); 
		return result;
	}*/
	@ResponseBody
	@RequestMapping(value = "changeState",method = RequestMethod.POST)
	public String changeState(Integer id,String state) {
		//forwad转发的话，参数会自动带上，再第目标controller方法上加上对应的参数名称就好了
		States states = new States();
		states.setId(id);
		states.setState(state);
		
		int result = statesService.updateByPrimaryKey(states); 
		if(result>0) {
			return "操作成功";
		}else {
			return "发生错误";
		}
	}
	
	@ResponseBody
	@RequestMapping(value= "getstates")
	public List<States> getstates(){
		return statesService.selectAll();
	}
}
