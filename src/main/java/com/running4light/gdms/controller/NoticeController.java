package com.running4light.gdms.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Notice;
import com.running4light.gdms.pojo.PageResult;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@ResponseBody
	@RequestMapping(value = "get/{receiver}/{index}/{size}",method = RequestMethod.GET)
	public PageResult<Notice> getPage(@PathVariable("receiver") Integer receiver,@PathVariable("index") Integer index,@PathVariable("size") Integer size) {
		List<Notice> notices = noticeService.selectPage(receiver,index*size,size);
		Integer count = noticeService.selectCount(receiver, index, size);
		Integer total = count%size==0?count/size:(count/size+1);
		return new PageResult<Notice>(total,notices);
	}
	@ResponseBody
	@RequestMapping(value = "get",method = RequestMethod.GET)
	public Result get() {
		List<Notice> notices = noticeService.selectAll(null);
		if(notices.size()>0)
			return new Result(true,StatusCode.OK,"操作成功",notices);
		else
			return new Result(true,StatusCode.EMPTYERROR,"没有任何通知");
	}
	@ResponseBody
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public Result delete(Integer id) {
		Integer result = noticeService.deleteByPrimaryKey(id);
		if(result>0)
			return new Result(true,StatusCode.OK,"删除成功");
		else
			return new Result(false,StatusCode.REMOTEERROR,"服务器错误");
	}
	@ResponseBody
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public Result add(Short receiver,String content) {
		Date now = new Date(new java.util.Date().getTime());
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(now);
		Date date = null;
		try {
			date = sdf.parse(time);
			System.out.println(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		Notice notice = new Notice(content,now,"manager",new Short("1"),receiver);
		//先测试  publilsher和deptid拟从session中取
		int result = noticeService.insert(notice);
		if(result>0)
			return new Result(true,StatusCode.OK,"添加成功");
		else
			return new Result(false,StatusCode.ERROR,"添加失败");
	}
	
	@ResponseBody
	@RequestMapping(value = "getNew",method = RequestMethod.POST)
	public Result getNewNotice(String uid,Integer count) {
		List<Notice> notices = noticeService.getNew(uid,count);
		if(notices.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",notices);
		else
			return new Result(true,StatusCode.EMPTYERROR,"没有新通知",notices);
	}
	
}
