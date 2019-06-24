package com.running4light.gdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Grade;
import com.running4light.gdms.pojo.GradeResult;
import com.running4light.gdms.pojo.GradeResultEvaluation;
import com.running4light.gdms.pojo.PageResult;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.GradeService;

@Controller
@RequestMapping("grade")
public class GradeController {
	@Autowired
	private GradeService gradeService;
	/**
	 * 获取所有成绩
	 * @param index
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get",method = RequestMethod.GET)
	public PageResult<GradeResult> get(@RequestParam("index") Integer index, @RequestParam("page") Integer page) {
		List<GradeResult> grades = gradeService.selectPage(index,page);
		if(grades.size()>0) {
			Integer count = gradeService.countAll();
			Integer total = count%page==0?count/page:count/page+1;
			return new PageResult<GradeResult>(total,grades);
		}else {
			return new PageResult<GradeResult>(0,null);
		}
	}
	/**
	 * 根据指导老师获取成绩
	 * @param teacherName
	 * @param index
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getGradesByGuider",method = RequestMethod.GET)
	public PageResult<GradeResultEvaluation> getGradesByGuider(@RequestParam("teacherName")String teacherName,@RequestParam("index") Integer index, @RequestParam("page") Integer page){
		List<GradeResultEvaluation> grades = gradeService.selectPageByGuider(teacherName,index,page);
		if(grades.size()>0) {
			Integer count = gradeService.countPageByGuider(teacherName);
			Integer total = count%page==0?count/page:count/page+1;
			return new PageResult<GradeResultEvaluation>(total,grades);
		}else {
			return new PageResult<GradeResultEvaluation>(0,null);
		}
	}
	/**
	 * 根据评阅老师的班级获取
	 * @param uid
	 * @param index
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getGradesByClass",method = RequestMethod.GET)
	public PageResult<GradeResultEvaluation> getGradesByClass(@RequestParam("uid")String uid,@RequestParam("index") Integer index, @RequestParam("page") Integer page){
		List<GradeResultEvaluation> grades = gradeService.selectPageByClass(uid,index,page);
		if(grades.size()>0) {
			Integer count = gradeService.countPageByClass(uid);
			Integer total = count%page==0?count/page:count/page+1;
			return new PageResult<GradeResultEvaluation>(total,grades);
		}else {
			return new PageResult<GradeResultEvaluation>(0,null);
		}
	}
	/**
	 * 更新文献翻译和指导老师成绩
	 * @param id
	 * @param guider
	 * @param translate
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateGTGrade",method = RequestMethod.POST)
	public Result updateGTGrade(Short id,Integer guider,Integer translate) {
		Grade grades = new Grade();
		grades.setId(id);
		grades.setGuider(guider);
		grades.setTranslate(translate);
		Integer result = gradeService.updateByPrimaryKey(grades);
		if(result>0)
			return new Result(true,StatusCode.OK,"操作成功");
		else
			return new Result(false,StatusCode.ERROR,"服务器内部错误");
	}
	/**
	 * 更新评阅老师成绩
	 * @param id
	 * @param grade
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "updateEvaluation",method = RequestMethod.POST)
	public Result updateEvaluation(Short id,Integer grade) {
		Grade grades = new Grade();
		grades.setId(id);
		grades.setEvaluation(grade);
		Integer result = gradeService.updateByPrimaryKey(grades);
		if(result>0)
			return new Result(true,StatusCode.OK,"操作成功");
		else
			return new Result(false,StatusCode.ERROR,"服务器内部错误");
	}
}
