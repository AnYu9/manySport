package com.znsd.controller;

import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.znsd.bean.SubjectBean;
import com.znsd.service.SubjectService;

/**
 * 科目模块;控制器
 * 
 * @author baishui
 *
 */
@Controller
public class SubjectController {

	@Resource
	private SubjectService subjectService;

	@RequestMapping(value = "/subjectAdd")
	@ResponseBody
	public void subjectAdd(SubjectBean subject,HttpServletResponse response) throws IOException {
		System.out.println("add..." + subject.getSubjectName());
		SubjectBean subjectResult = subjectService.findSubjectByName(subject.getSubjectName());
		if (subjectResult == null) {
			int addResult = subjectService.subjectAdd(subject);
			if (addResult > 0) {
				response.getWriter().print("添加成功");
			} else {
				response.getWriter().print("添加失败");
			}
		} else {
			response.getWriter().print("科目名已存在");
		}
	}

	@RequestMapping(value = "/subjectDel")
	public void subjectDel(@RequestParam("subjectIds") String subjects,HttpServletResponse response) throws IOException {
		String[] ids = subjects.split(",");
		for (int i = 0; i < ids.length; i++) {
			subjectService.subjectDel(ids[i]);
		}
		response.getWriter().print("删除成功");
	}
	
	@RequestMapping(value = "/subjectUpdate")
	public void subjectUpdate(SubjectBean subject,HttpServletResponse response) throws IOException {
		int result = subjectService.subjectUpdate(subject);
		System.out.println(subject.toString());
		if(result>0) {
			response.getWriter().print("修改成功");
		}else {
			response.getWriter().print("删除失败");
		}
		
	}

	@RequestMapping(value = "/findSubject")
	@ResponseBody
	public Object findSubject(String subjectName, @RequestParam("page") int page, @RequestParam("rows") int rows) {
		int begin = (page - 1) * rows;
		int end = rows;

		JSONObject json = new JSONObject();
		List<SubjectBean> list = new ArrayList<>();
		if (subjectName == null) {
			list = subjectService.findSubject(begin, end);
		} else {
			List<SubjectBean> findSubject = subjectService.findSubject(begin, end);
			for (int i = 0; i < findSubject.size(); i++) {
				if (findSubject.get(i).getSubjectName().contains(subjectName)) {
					list.add(findSubject.get(i));
				}
			}
		}
		json.put("rows", list);
		json.put("total", subjectService.findSubjectAllCount());
		return json;
	}
	
	@RequestMapping(value = "/findAllSubject")
	@ResponseBody
	public Object findSubject() {
		List<SubjectBean> list = subjectService.findSubject();
		return list;
	}

}
