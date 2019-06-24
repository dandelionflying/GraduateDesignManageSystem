package com.running4light.gdms.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;
import com.mchange.lang.StringUtils;
import com.running4light.gdms.common.SessionValue;
import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.common.WebWords;
import com.running4light.gdms.pojo.Docs;
import com.running4light.gdms.pojo.PageResult;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.pojo.Student;
import com.running4light.gdms.service.DocService;
import com.running4light.gdms.service.FileclassifyService;
@Controller
@RequestMapping("docs")
public class DocsController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FileclassifyService fileclassifyService;
	@Autowired
	private DocService docService;
	/**
	 * 获取待审核文档数量（主要是教务管理员管理查重报告和答辩申请表）
	 * @param classifys
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "countByClassifys",method = RequestMethod.GET)
	public Result countByClassifys(@RequestParam("classifys") String[] classifys) {
		Integer count = docService.countByClassifys(classifys);
		return new Result(true,StatusCode.OK,"查询成功",count);
	}
	
	/**
	 * 分页分局分类获取学生文档（主要是教务管理员管理查重报告和答辩申请表）
	 * @param classifys
	 * @param index
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getByClassifys",method = RequestMethod.GET)
	public PageResult<Docs> getByClassify(@RequestParam("classifys") String[] classifys,@RequestParam("index")Integer index,@RequestParam("page")Integer page) {
		List<Docs> docs = docService.selectByClassifys(classifys,index*page,page);
		Integer count = docService.countByClassifys(classifys);
		Integer pages = count%page==0?count/page:count/page+1;
		return new PageResult<Docs>(pages,docs);
	}
	
	/**
	 * 分页获取全部学生文档信息
	 * @param index
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get",method = RequestMethod.GET)
	public PageResult<Docs> getPage(@RequestParam("index")Integer index,@RequestParam("page")Integer page) {
		List<Docs> docs = docService.selectAllPage(index*page,page);
		Integer pages = docService.selectCount()%page ==0 ? docService.selectCount()/page:docService.selectCount()/page+1;
		return new PageResult<Docs>(pages,docs);
	}
	/**
	 * 根据学号和类别获取文档信息
	 * @param uid
	 * @param classify
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getone",method = RequestMethod.GET)
	public Result getOneDoc(@RequestParam("id") String uid,@RequestParam("classify") Integer classify) {
		Docs doc = docService.getByUidAndClassify(uid,classify);
		String classify2 = fileclassifyService.queryNameById(classify);
		if(doc!=null)
			return new Result(true,StatusCode.OK,"查询成功",doc);
		else
			return new Result(false,StatusCode.ERROR,"没有文件",classify2);
	
	}
	/**
	 * 获取指导教师对应学生的文档信息
	 * @param teachername
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getwithteacher",method = RequestMethod.GET)
	public Result getwithteacher(@RequestParam("teachername")String teachername) {
		List<Docs> docs = docService.getWithTeachername(teachername);
		if(docs.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",docs);
		else
			return new Result(false,StatusCode.EMPTYERROR,"没有文件记录");
		
	}
	/**
	 * 获取评阅教师对应班级学生的文档信息
	 * @param teachername
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getwithteacher2",method = RequestMethod.GET)
	public Result getwithteacher2(@RequestParam("uid")String uid) {
		List<Docs> docs = docService.getWithTeacherAndClass(uid);
		if(docs.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",docs);
		else
			return new Result(false,StatusCode.EMPTYERROR,"没有文件记录");
		
	}
	@ResponseBody
	@RequestMapping(value = "searchdoc",method = RequestMethod.POST)
	public Result searchDoc(String[] classify,String[] uids) {
		logger.debug(classify[0]);
		logger.debug(uids[0]);
		List<Docs> docs = docService.selectByUidAndClassify(classify, uids);
		if(docs.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",docs);
		else
			return new Result(false,StatusCode.EMPTYERROR,"无记录",docs);
	}
	@ResponseBody
	@RequestMapping(value = "searchdocbyclassify",method = RequestMethod.POST)
	public Result searchDoc(HttpSession session,String[] classify) {
		SessionValue sessionValue =  (SessionValue)session.getAttribute(WebWords.TEACHERSESSION);
		String uid = sessionValue.getId();
		logger.debug(classify[0]);
		List<Docs> docs = docService.selectByClassify(uid,classify);
		if(docs.size()>0)
			return new Result(true,StatusCode.OK,"查询成功",docs);
		else
			return new Result(false,StatusCode.EMPTYERROR,"无记录",docs);
	}
	/**
	 * 根据文档id下载文档
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "download",method = RequestMethod.GET)
	public ResponseEntity<byte[]> download (@RequestParam("id") Integer id){
		Docs docs =  docService.selectByPrimaryKey(id);
		ResponseEntity<byte[]> responseEntity = null;
		if(docs!=null) {
			String url = docs.getDocUrl();
			StringTokenizer stringToken = null;
			String fileName = null;
			try {
				stringToken = new StringTokenizer(url, "\\");
				while (stringToken.hasMoreTokens()) {
					fileName = stringToken.nextToken();
				}
				File file = new File(url);
				HttpHeaders header = new HttpHeaders();
				String downloadFileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
				header.setContentDispositionFormData("attachment", downloadFileName);
				header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				responseEntity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),header,HttpStatus.CREATED);
				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseEntity;
	}
}
