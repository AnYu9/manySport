package com.znsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.znsd.annotation.LogCutional;
import com.znsd.bean.GradeBean;
import com.znsd.service.impl.GradeServiceImp;

@Controller
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private GradeServiceImp service;
	
	@LogCutional("班级添加")
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public String save(GradeBean grade) {
		service.save(grade);
		return "grade.jsp";
	}
	
	@RequestMapping(value = "/queryAll",method = RequestMethod.POST)
	@ResponseBody
	public String queryAll(@RequestParam("page") int page,@RequestParam("rows") int rows) {
		int total = service.total();
		JSONObject json = new JSONObject();
		json.put("rows", service.QueryAll((page-1)*rows,rows));
		json.put("total", total);
		return json.toJSONString();
	}
	@LogCutional("班级删除")
	@RequestMapping(value = "/remove",method = RequestMethod.POST)
	@ResponseBody
	public String remove(String classIds) {
		String[] idsStr = classIds.split(",");
		Integer[] ids = new Integer[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i] = Integer.parseInt(idsStr[i]);
		}
		service.remove(ids);
		return "grade.jsp";
	}
	@LogCutional("班级修改")
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public String update(GradeBean grade) {
		service.update(grade);
		return "grade.jsp";
	}
}
