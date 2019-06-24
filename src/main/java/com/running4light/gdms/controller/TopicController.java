package com.running4light.gdms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.SessionValue;
import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.PageResult;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.pojo.Topic;
import com.running4light.gdms.service.TopicService;

@Controller
@RequestMapping(value = "topic")
public class TopicController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TopicService topicService;
	
	@ResponseBody
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public Result delete(String topicId) {
		Integer result = topicService.deleteByPrimaryKey(topicId);
		logger.debug("===== 删除操作返回结果 ====="+result);
		if(result>0) {
			return new Result(true,StatusCode.OK,"撤销成功");
		}else {
			return new Result(false,StatusCode.REMOTEERROR,"操作失败");
		}
	}
	/**
	 * 根据关键词搜索课题
	 * @param key
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="searchTopic",method = RequestMethod.GET)
	public PageResult<Topic> searchTopicByKey(@RequestParam("tag") Integer tag,@RequestParam("keyWord")String key,@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		if(!topicService.searchKeyByName(key)) {
			topicService.addHotKey(key);
		}else {
			topicService.modifyHotKey(key);
		}
		List<Topic> list = topicService.searchTopicByKey(key,tag,index,page);
		Integer count = topicService.countTopicByKey(key,tag);
		Integer total = count%page==0?count/page:count/page+1;
		
		return new PageResult<Topic>(total,list);
	}
	/**
	 * 获取热搜
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="hotkey.action",method = RequestMethod.GET)
	public Result getTop10HotKeys(@RequestParam("temp") String temp){
		List<String> list = topicService.getTop10HotKeys();
		if(list!=null)
			return new Result(true,StatusCode.OK,"查询成功",list);
		else
			return new Result(false,StatusCode.ERROR,"查询失败");
	}
	/**
	 * 根据审核状态获取课题 0:未审核 1：已驳回 2：已通过（该状态下的课题学生才可见）
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getTopics",method = RequestMethod.GET)
	public PageResult<Topic> getTopicsByTag(@RequestParam("tag") Integer tag,@RequestParam("index") Integer index,@RequestParam("page") Integer page){
		List<Topic> topics = topicService.queryPageByTag(tag,index,page);
		Integer count = topicService.countTopicByTag(tag);
		Integer pages = count%page==0?count/page:count/page+1;
		return new PageResult<Topic>(pages,topics);
		
	}
	@ResponseBody
	@RequestMapping(value = "countTopicByTag")
	public Result countTopicByTag(@RequestParam("tag")Integer tag) {
		Integer count = topicService.countTopicByTag(tag);
		return new Result(true,StatusCode.OK,"查询成功",count);
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
	
	@ResponseBody
	@RequestMapping(value = "passAll",method = RequestMethod.POST)
	public Result changeTopicStates() {
		int result = topicService.updateByTag(2);
		if(result>0)
			return new Result(true,StatusCode.OK,"修改成功");
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
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
	public PageResult<Topic> searchTopic(int tag,String key,String classify,Integer index,Integer page){
		List<Topic> list = null;
		Integer count = null;
		if(classify.equals("全部")) {
			list = topicService.queryPageByTagAndName(tag, key,index,page);
			count = topicService.countTopicByTagAndName(tag, key);
		}
		else {
			list = topicService.queryPageByTagAndNameAndType(tag, key,classify,index,page);
			count = topicService.countTopicByTagAndNameAndKey(tag, key, classify);
		}
		Integer pages = count%page==0?count/page:count/page+1;
		return new PageResult<Topic>(pages,list);
	}
	@ResponseBody
	@RequestMapping(value = "getContent")
	public Result getContent(String id) {
		String content = topicService.getContent(id);
		if(content!=null) {
			return new Result(true,StatusCode.OK,"查询成功",content);
		}else {
			return new Result(false,StatusCode.ERROR,"操作失败");
		}
	}
	@ResponseBody
	@RequestMapping(value = "getByUid",method = RequestMethod.GET)
	public Result getByUid(@RequestParam("uid")String uid) {
		Topic topic = topicService.queryTopicByStudentId(uid);
		if(topic!=null)
			return new Result(true,StatusCode.OK,"查询成功",topic);
		else
			return new Result(false,StatusCode.ERROR,"无记录");
	}
	
	@ResponseBody
	@RequestMapping(value = "getbyteacher",method = RequestMethod.GET)
	public PageResult<Topic> getByTeacher(HttpSession session,@RequestParam("index") Integer index,@RequestParam("page") Integer page) {
		SessionValue values = (SessionValue) session.getAttribute(WebWords.TEACHERSESSION);
		logger.debug(values.toString());
		String teachername = values.getUsername();
		List<Topic> topics = topicService.quetyPageMyTeacherName(index,page,teachername);
		Integer count = topicService.countTopicByTeacherName(teachername);
		Integer pages = count%page==0?count/page:count/page+1;
		if(topics.size()>0)
			return new PageResult<Topic>(pages,topics);
		else
			return new PageResult<Topic>(0,null);
	}
	
}
