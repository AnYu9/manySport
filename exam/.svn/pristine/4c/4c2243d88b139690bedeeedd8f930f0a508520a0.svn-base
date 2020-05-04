package com.znsd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.znsd.bean.PaperBean;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.RecordsBean;
import com.znsd.bean.TopicType;
import com.znsd.bean.UserBean;
import com.znsd.service.PaperService;
import com.znsd.service.QuestionService;
import com.znsd.service.RecordsService;

/**
 * 试卷模块;
 * 
 * @author baishui
 *
 */
@Controller
@RequestMapping("/paper")
public class PaperController {

	@Autowired
	PaperService paperService;
	@Autowired
	QuestionService questionService;
	@Autowired
	RecordsService recordsService;

	@RequestMapping("/paperAdd")
	@ResponseBody
	public String paperAdd(PaperBean paperBean, HttpServletRequest request) {
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		// paperBean.setuserName(user.getUserId());
		paperBean.setuserName("giao1232323");
		PaperBean isPaper = paperService.findPaperByName(paperBean.getPaperName());
		if (isPaper == null) {
			int addResult = paperService.paperAdd(paperBean);
			if (addResult > 0) {
				return "新增成功";
			} else {
				return "新增失败";
			}
		} else {
			return "新增失败，试卷名重复";
		}
	}
	
	@RequestMapping("/paperUpdate")
	public String paperUpdate(PaperBean paperBean) {
		String black = "";
		int updateResult = paperService.paperUpdate(paperBean);
		if(updateResult > 0) {
			black="修改成功";
			return black;
		}else {
			black="修改失败";
		}
		return black;
	}

	@RequestMapping("/findById")
	public ModelAndView findPaperById(String id) {
		ModelAndView mav = new ModelAndView();
		PaperBean paper = paperService.findPaperById(id);
		mav.addObject("paper",paper);
		mav.setViewName("../examWeb/paper.jsp");
		return mav;
	}

	@RequestMapping("/queryAll")
	@ResponseBody
	public JSONObject queryAll(PaperBean bean, int page, int rows) {
		System.out.println("条件bean："+bean);
		int begin = (page - 1) * rows;
		int end = rows;

		List<PaperBean> list = paperService.limitQueryAllPaper(bean,begin, end);
		int total = paperService.total(bean);
		JSONObject json = new JSONObject();
		json.put("rows", list);
		json.put("total", total);
		return json;
	}

	@RequestMapping("/paperScore")
	@ResponseBody
	public void score(@RequestParam("answer") String answer,@RequestParam("paperId") String id,@RequestParam String time,@RequestParam("paperName") String name,HttpSession session) {
		JSONArray array=JSON.parseArray(answer);
		List<QuestionBean> list = new ArrayList<>();//用户提交的答案
		List<QuestionBean> tmList = new ArrayList<>();//正确答案
		for(int i=0;i<array.size();i++) {
			list.add(JSON.parseArray(answer).getObject(i, QuestionBean.class));
		}
		PaperBean paper = paperService.findPaperById(id);
		String[] anwer = paper.getAnwer().toString().split(",");
		for(String ids : anwer) {
			tmList.add(questionService.findQuestionsById(ids));
		}
		RecordsBean record = new RecordsBean();
		record.setPaperId(Integer.parseInt(id));
		record.setPaperName(name);
		record.setScore(correctingExam(list,tmList));
		record.setTestTime(time);
		UserBean user = (UserBean)session.getAttribute("user");
		record.setUserId(user.getUserId());
		recordsService.save(record);
		session.setAttribute("record",record);
	}
	
	public Double correctingExam(List<QuestionBean> self,List<QuestionBean> target) {
		Double score = new Double(0);
		for(int i=0;i<target.size();i++) {
			for(int j=0;j<self.size();j++) {
				if(target.get(i).gettopId()==self.get(j).gettopId()) {
					if(target.get(i).getResult().equalsIgnoreCase(self.get(j).getResult())) {
						score+=target.get(i).getScore();
						break;
					}
				}
			}
		}
		return score;
	}
	
	@RequestMapping("/paperDel")
	@ResponseBody
	public String remove(@RequestParam("paperIds") String id) {
		String[] ids = id.split(",");
		for (int i = 0; i < ids.length; i++) {
			paperService.remove(ids[i]);
		}

		return "删除成功";
	}

	@RequestMapping("/querymap")
	@ResponseBody
	public Map<String, List<QuestionBean>> querymap(@RequestParam("paperId") Integer id) {
		System.out.println("id："+id);
		return rolls(paperService.assemble(id));
	}

	/**
	 * 将题目打乱顺序
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, List<QuestionBean>> rolls(Map<String, List<QuestionBean>> map) {
		for (String key : map.keySet()) {
			int size = map.get(key).size();
			Random random = new Random();
			for (int i = 0; i < size; i++) {
				// 获取随机位置
				int randomPos = random.nextInt(size);
				// 当前题目与随机题目交换
				QuestionBean temp = map.get(key).get(i);
				map.get(key).set(i, map.get(key).get(randomPos));
				map.get(key).set(randomPos, temp);
			}
		}
		return map;
	}

	@RequestMapping("/findTopicType")
	@ResponseBody
	public List<TopicType> findTopicType() {
		List<TopicType> topicTypes = paperService.findTopicTypes();
		return topicTypes;
	}
	
	@RequestMapping("/getPaperCount")
	@ResponseBody
	public Integer getPaperCount() {
		Integer total = paperService.total(null);
		return total;
	}
}
