package com.znsd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.znsd.service.LogService;

@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	private LogService service;
	
	@RequestMapping("/queryAll")
	@ResponseBody
	public String queryAll(@RequestParam("page") int page,@RequestParam("rows") int rows) {
		JSONObject json = new JSONObject();
		json.put("rows", service.queryAll((page-1)*rows,rows));
		json.put("total", service.total());
		return json.toJSONString();
	}
	
	
}
