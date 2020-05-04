package com.znsd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;
import com.znsd.service.QuestionService;

/**
 * 题库模块;控制器
 * 
 * @author baishui
 *
 */
@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/questionAdd")
	@ResponseBody
	public void subjectAdd(QuestionBean question, HttpServletResponse response,HttpServletRequest request) throws IOException {
		
		System.out.println(question.toString());
		int topicAddResult = questionService.topicAdd(question);
		if(topicAddResult > 0) {
			response.getWriter().print("增加成功");
		}else {
			response.getWriter().print("增加失败");
		}
	}
	
	@RequestMapping(value = "/questionData")
	@ResponseBody
	public void questionData() {
		
	}

	@RequestMapping(value = "/questionDel")
	public void subjectDel(@RequestParam("questions") String questions, HttpServletResponse response)
			throws IOException {
		String[] ids = questions.split(",");
		for (int i = 0; i < ids.length; i++) {
			QuestionBean bean = questionService.findQuestionsById(ids[i]);
			questionService.topicDel(ids[i]);
			if("1".equals(bean.getType())) {
				questionService.topicOptionsDel(ids[i]);
			}
		}
		response.getWriter().print("删除成功");
	}

	@RequestMapping(value = "/questionUpdate")
	public void subjectUpdate(QuestionBean questionBean, HttpServletResponse response) throws IOException {
		System.out.println("修改来了");
		System.out.println(questionBean);
		int topicUpdateResult = questionService.topicUpdate(questionBean);
		if(topicUpdateResult > 0) {
			response.getWriter().print("修改成功");
		}else {
			response.getWriter().print("修改失败");
		}
	}
	
	@RequestMapping("/conditionFindQuestion")
	@ResponseBody
	public Object conditionFindQuestion(QuestionBean questionBean , Integer page,  Integer rows) {
		System.out.println(questionBean);
		int begin = (page - 1) * rows;
		int end = rows;
		JSONObject json = new JSONObject();
		List<QuestionBean> list = questionService.conditionFindQuestions(questionBean, begin, end);
		int total = questionService.conditionFindCount(questionBean);
		json.put("rows", list);
		json.put("total", total);
		return json;
	}
}