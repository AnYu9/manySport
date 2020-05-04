package com.znsd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.znsd.bean.RecordsBean;
import com.znsd.service.ISendWechatMsg;
import com.znsd.service.impl.RecordsServiceImp;

@Controller
@RequestMapping("/records")
public class RecordsController {
	@Autowired
	RecordsServiceImp service;
	@Autowired
	ISendWechatMsg sendMsg;
	
	@RequestMapping(value = "/queryAll",method = RequestMethod.POST)
	@ResponseBody
	public List<RecordsBean> queryAll() {
		return service.queryAll(0, 10);
	}
	
	@RequestMapping(value = "/queryByuserId",method = RequestMethod.GET)
	@ResponseBody
	public List<RecordsBean> queryByuserId(String userId) {
		return service.queryByuserId(userId);
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	@ResponseBody
	public RecordsBean save(RecordsBean record) {
		service.save(record);
		return record;
	}
	
	@RequestMapping("/findQuery")
	@ResponseBody
	public List<RecordsBean> findQuery(RecordsBean condition){
		List<RecordsBean> list = service.findUser(condition);
		return list;
	}
	
	@RequestMapping("/sendMessage")
	@ResponseBody
	public String send(@RequestParam("paperName") String pName,@RequestParam("userName") String id,@RequestParam("score") Integer score,@RequestParam("des") String des) throws Exception {
		String content = "第一名"+score+id;
		if(content.length()<29) {
			return sendMsg.sendMsg(pName, content, des);
		}
		return "";
	}
}
