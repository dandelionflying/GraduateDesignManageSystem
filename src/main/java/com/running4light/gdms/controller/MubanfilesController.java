package com.running4light.gdms.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.running4light.gdms.common.StatusCode;
import com.running4light.gdms.pojo.Mubanfiles;
import com.running4light.gdms.pojo.PageResult;
import com.running4light.gdms.pojo.Result;
import com.running4light.gdms.service.MubanfilesService;

@Controller
@RequestMapping(value = "mubanfile")
public class MubanfilesController {
	@Autowired
	private MubanfilesService mubanfilesService;
	
	/**
	 * 根据id下载文件
	 * @param docId
	 * @return
	 */
	@RequestMapping(value = "getById",method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@RequestParam("id") Integer docId) {
		String url = null;
		StringTokenizer stringToken = null;
		String fileName = null;
		ResponseEntity<byte[]> responseEntity = null;
		try {
			Mubanfiles mubanfiles = mubanfilesService.selectByPrimaryKey(docId);
			url = mubanfiles.getUrl();
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
		return responseEntity;
	}
	/**
	 * 获取模板文件列表（分页）
	 * @param index
	 * @param size
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getOfStudent", method = RequestMethod.GET)
	public PageResult<Mubanfiles> getAllMubanFile(@RequestParam("index") Integer index,@RequestParam("size") Integer size) {
		List<Mubanfiles> list = mubanfilesService.selectPage(index*size,size,1);
		Integer total = mubanfilesService.countSelectAll(1);
		int pages = total%size==0?total/size:total/size+1;
		if(list!=null)
			return new PageResult<Mubanfiles>(pages,list);
		else
			return new PageResult<Mubanfiles>(0,null);
	}
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "deletemore",method = RequestMethod.GET)
	public Result deleteItems(@RequestParam("ids")Integer[] ids) {
		
		if(mubanfilesService.deleteItems(ids))
			return new Result(true,StatusCode.OK,"删除成功");
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
	}
	/**
	 * 单个删除
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete",method = RequestMethod.POST)
	public Result deleteMubanFile(Integer id) {
		System.out.println(id);
		if(mubanfilesService.deleteByPrimaryKey(id)==true) {
			return new Result(true,StatusCode.OK,"删除成功");
		}
		else
			return new Result(false,StatusCode.ERROR,"操作失败");
	}
}
