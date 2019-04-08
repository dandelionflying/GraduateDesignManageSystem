package com.running4light.gdms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.TopicService;

@Controller
@RequestMapping(value = "topic")
public class TopicController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TopicService topicService;
	
	/**
	 * 根据关键词搜索课题
	 * @param key
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="searchTopic.action")
	public List<Topic> searchTopicByKey(@RequestParam("keyWord")String key){
		if(!topicService.searchKeyByName(key)) {
			topicService.addHotKey(key);
		}else {
			topicService.modifyHotKey(key);
		}
		List<Topic> list = topicService.searchTopicByKey(key);
		return list;
	}
	/**
	 * 获取热搜
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="hotkey.action")
	public List<String> getTop10HotKeys(){
		return topicService.getTop10HotKeys(); 
	}
	/**
	 * 根据审核状态获取课题 0:未审核 1：已驳回 2：已通过（该状态下的课题学生才可见）
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTopics",method = RequestMethod.GET)
	public Map<String, Object> getTopicsByTag(@RequestParam("tag") Integer tag,@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		Map<String,Object> map = new HashMap<>();
		List<Topic> topics = topicService.queryPageByTag(tag,index,page);
		Integer count = topicService.countTopicByTag(tag);
		map.put("index", index);
		map.put("pages", count%page==0?count/page:count/page+1);
		map.put("result", topics);
		return map;
		
	}
	/**
	 * 修改课题状态
	 * @param id
	 * @param tag
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "changeTopicState",method = RequestMethod.POST)
	public String changeTopicState(int id, int tag) {
		int result = topicService.updateTagById(id, tag);
		return result>0?"操作成功":"出现错误";
	}
	/**
	 * 获取课题分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTopicClassifyName",method = RequestMethod.GET)
	public List<String> getTopicClassifyName(){
		return topicService.getName();
	}
	/**
	 * 根据tag、关键词、课题类型搜索
	 * @param tag
	 * @param key
	 * @param classify
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "searchTopic",method = RequestMethod.POST)
	public Map<String,Object> searchTopic(int tag,String key,String classify,Integer index,Integer page){
		Map<String,Object> map = new HashMap<>();
		map.put("index", index);
		List<Topic> list = null;
		Integer count = null;
		if(classify.equals("全部")) {
			list = topicService.queryPageByTagAndName(tag, key,index*page,page);
			count = topicService.countTopicByTagAndName(tag, key);
		}
		else {
			list = topicService.queryPageByTagAndNameAndType(tag, key,classify,index*page,page);
			count = topicService.countTopicByTagAndNameAndKey(tag, key, classify);
		}
		map.put("pages", count%page==0?count/page:count/page+1);
		map.put("result", list);
		return map;
	}
	
}
