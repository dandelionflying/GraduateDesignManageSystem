package gdms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import gdms.model.Topic;
import gdms.service.TopicService;

@Controller
public class TopicController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value="/topicmanage")
	public String getAlltopic(Model model) {
		List<Topic> topics = topicService.getAllTopics();
		List<Topic> myTopics = topicService.getMyTopic("陈露露");
		if(topics!=null) {
			model.addAttribute("topics", topics);
			model.addAttribute("myTopics", myTopics);
		}
		
		return "teacher/topicmanage";
	}
	@RequestMapping(value="topicContent.action")
	@ResponseBody
	public String topicContent(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		return topicService.getContent(request.getParameter("topicId"));
	}
	@RequestMapping(value="addNewTopic.action",method=RequestMethod.POST)
	public String addNewTopic(@ModelAttribute Topic topic,Model model) {
		topicService.addTopic(topic);
		return "teacher/topicmanage";
	}
	@ResponseBody
	@RequestMapping(value="searchTopic.action")
	public List<Topic> searchTopicByKey(@RequestParam("keyWord")String key){
		
		List<Topic> list = topicService.searchTopicByKey(key);
		return list;
		
	}
}
