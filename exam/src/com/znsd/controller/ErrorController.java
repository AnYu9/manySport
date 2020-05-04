package com.znsd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.znsd.bean.ErrorBean;
import com.znsd.service.impl.ErrorServiceImp;

/**
 * 错误反馈;控制器
 * @author baishui
 *
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
	
	@Autowired
	ErrorServiceImp service;
	
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	@ResponseBody
	public ErrorBean save(ErrorBean error) {
		service.save(error);
		return error;
	}
	@RequestMapping(value = "/queryAll",method = RequestMethod.POST)
	@ResponseBody
	public String queryAll(@RequestParam("page") int page,@RequestParam("rows") int rows){
		int total = service.total();
		JSONObject json = new JSONObject();
		json.put("total", total);
		json.put("rows", service.queryAll((page-1)*rows,rows));
		return json.toJSONString();
	}

	@RequestMapping(value = "/updateStatus",method = RequestMethod.POST)
	@ResponseBody
	public String updateStatus(String errorIds) {
		String[] idsStr = errorIds.split(",");
		Integer[] ids =new Integer[idsStr.length];
		for (int i = 0; i < idsStr.length; i++) {
			ids[i] = Integer.parseInt(idsStr[i]);
			service.updateStatus(ids[i]);
		}
		return "error.jsp";
	}
}
