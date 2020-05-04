package com.znsd.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.specs2.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.znsd.bean.AnswerBean;
import com.znsd.bean.MessageBean;
import com.znsd.bean.TopicoptionsBean;
import com.znsd.service.ExercisesService;
import com.znsd.service.impl.ExercisesServiceImpl;

//测试题控制器
@Controller
@RequestMapping(value = "ExercisesController")
public class ExercisesController {
	@Autowired
	ExercisesService exercisesService;

	// 查询测试题
	@RequestMapping(value = "ExerRest/{difficulty}/{course}", method = RequestMethod.GET)
	@ResponseBody
	public List<MessageBean> QueryExercisesController(@PathVariable("difficulty") String difficulty, @PathVariable("course") String course, ModelMap map) {
		System.out.println("difficulty="+difficulty+"——course="+course);
		if (difficulty.equals("1")) {
			difficulty = "初级";
		}else if(difficulty.equals("2")) {
			difficulty = "中级";
		}else if (difficulty.equals("3")) {
			difficulty = "高级";
		}
		System.out.println("测试题目难度="+difficulty);
		//创建集合保存测试题对象数据
		List<MessageBean> messageList = new ArrayList<MessageBean>();
		//ModelAndView modelAndView = new ModelAndView("exercises");
		Map<Integer, String> exerMap = new HashMap<Integer, String>();
		// 获取题目难度等级 ： difficulty
		// 保存题目ID的集合
		List<Integer> topIdList = new ArrayList<Integer>();
		// 保存题目答案的集合
		ArrayList<String> resultList = new ArrayList<String>();
		ArrayList<String> resultList2 = new ArrayList<String>();
		// 保存题目说明的集合
		ArrayList<String> explanationList = new ArrayList<String>();
		ArrayList<String> explanationList2 = new ArrayList<String>();
		try {
			// 获取测试题目
			System.out.println("测试类型：" + course);
			List<AnswerBean> answerList = exercisesService.QueryExercisesService(difficulty, course);
			for (int i = 0; i < answerList.size(); i++) {
				// 保存题目ID
				topIdList.add(answerList.get(i).getTopId());
			}
			// 根据科目ID查询科目名称
			String subjectName = exercisesService.QuerySubjectService(answerList.get(0).getSubjectName());
			//根据找到的测试题目ID和需要的题目类型进行再一次筛选[选择题还是填空题]
			List<AnswerBean> answerList2 = exercisesService.QueryExercisesTypeXuanService(topIdList);
			List<AnswerBean> answerList3 = exercisesService.QueryExercisesTypeTianService(topIdList);
			List<AnswerBean> answerList4 = exercisesService.QueryExercisesTypeWenService(topIdList);
			if (difficulty.equals("初级")) {//初级显示选择题
				// 根据测试题ID获取测试题选项
				List<TopicoptionsBean> topicoptionsList = exercisesService.QueryTopicoptionsService(topIdList);
				if (answerList2.size()>5) { //将测试题目的数量控制在5个题
					for (int i = 0; i < 5; i++) {//选择题
						MessageBean messageBean = new MessageBean();
						messageBean.setKey((i+1)+"");
						messageBean.setValue(answerList.get(i).getTopId() + "@@" + answerList.get(i).getTitle() + "@@"
								+ topicoptionsList.get(i).getA() + "#" + topicoptionsList.get(i).getB() + "#"
								+ topicoptionsList.get(i).getC() + "#" + topicoptionsList.get(i).getD() + "@@"
								+ answerList.get(i).getResult() + "@@" + subjectName + "@@" + answerList.get(i).getDifficulty()
								+ "@@" + answerList.get(i).getExplanation());
						messageList.add(messageBean);
					}
				}else {
					for (int i = 0; i < answerList2.size(); i++) {//选择题
						MessageBean messageBean = new MessageBean();
						messageBean.setKey((i+1)+"");
						messageBean.setValue(answerList.get(i).getTopId() + "@@" + answerList.get(i).getTitle() + "@@"
								+ topicoptionsList.get(i).getA() + "#" + topicoptionsList.get(i).getB() + "#"
								+ topicoptionsList.get(i).getC() + "#" + topicoptionsList.get(i).getD() + "@@"
								+ answerList.get(i).getResult() + "@@" + subjectName + "@@" + answerList.get(i).getDifficulty()
								+ "@@" + answerList.get(i).getExplanation());
						messageList.add(messageBean);
					}
				}
			}else if (difficulty.equals("中级")) {//中级显示填空题
				exerMap = new HashMap<Integer, String>();
				if (answerList3.size()>5) {
					for (int i = 0; i < 5; i++) {//填空题
						MessageBean messageBean = new MessageBean();
						messageBean.setKey((i+1)+"");
						messageBean.setValue(answerList3.get(i).getTopId() + "@@" + answerList3.get(i).getTitle() + "@@"
										+ answerList3.get(i).getResult() + "@@" + subjectName + "@@"
										+ answerList3.get(i).getDifficulty() + "@@" + answerList3.get(i).getExplanation());
						messageList.add(messageBean);
					}
				}else {
					for (int i = 0; i < answerList3.size(); i++) {//填空题
						MessageBean messageBean = new MessageBean();
						messageBean.setKey((i+1)+"");
						messageBean.setValue(answerList3.get(i).getTopId() + "@@" + answerList3.get(i).getTitle() + "@@"
										+ answerList3.get(i).getResult() + "@@" + subjectName + "@@"
										+ answerList3.get(i).getDifficulty() + "@@" + answerList3.get(i).getExplanation());
						messageList.add(messageBean);
					}
				}
			}else if (difficulty.equals("高级")) { //高级问答题
				System.out.println("进来了问答题！！！");
				exerMap = new HashMap<Integer, String>();
				if (answerList4.size()>5) {
					for (int i = 0; i < 5; i++) {//问答题
						MessageBean messageBean = new MessageBean();
						messageBean.setKey((i+1)+"");
						messageBean.setValue(answerList4.get(i).getTopId() + "@@" + answerList4.get(i).getTitle() + "@@"
										+ answerList4.get(i).getResult() + "@@" + subjectName + "@@"
										+ answerList4.get(i).getDifficulty() + "@@" + answerList4.get(i).getExplanation());
						messageList.add(messageBean);
					}
				}else {
					for (int i = 0; i < answerList4.size(); i++) {//问答题
						MessageBean messageBean = new MessageBean();
						messageBean.setKey((i+1)+"");
						messageBean.setValue(answerList4.get(i).getTopId() + "@@" + answerList4.get(i).getTitle() + "@@"
										+ answerList4.get(i).getResult() + "@@" + subjectName + "@@"
										+ answerList4.get(i).getDifficulty() + "@@" + answerList4.get(i).getExplanation());
						messageList.add(messageBean);
					}
				}
			}
			
			for(int i = 0; i<answerList2.size(); i++) {
				// 保存题目答案
				resultList.add(answerList2.get(i).getResult());
				// 保存题目说明
				explanationList.add((answerList2.get(i).getExplanation()) + "##");
			}
			for(int i = 0; i<answerList3.size(); i++) {
				// 保存题目答案
				resultList2.add(answerList3.get(i).getResult());
				// 保存题目说明
				explanationList2.add((answerList3.get(i).getExplanation()) + "##");
			}
			for(int i = 0; i<answerList4.size(); i++) {
				// 保存题目答案
				resultList2.add(answerList4.get(i).getResult());
				// 保存题目说明
				explanationList2.add((answerList4.get(i).getExplanation()) + "##");
			}
			
			// 将题目答案放在request域中
			map.put("resultList", resultList);
			// 将题目说明放在request域中
			map.put("explanationList", explanationList);
			// 将测试科目放在request域中
			//map.put("course", course);
			// 返回测试题集合给前端显示
			//modelAndView.addObject("exerMap", exerMap);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageList;
	}
	
//	@RequestMapping(value = "ExerRest/{difficulty}/{course}", method = RequestMethod.GET)
//	@ResponseBody
//	public List<MessageBean> QueryExercisesControllera(@PathVariable("difficulty") String difficulty,
//			@PathVariable("course") String course, ModelMap map) {
//		if (difficulty.equals("2")) {
//			difficulty = "中级";
//		} else if (difficulty.equals("3")) {
//			difficulty = "高级";
//		}
//		ModelAndView modelAndView = new ModelAndView("exercises");
//		List<MessageBean> messageList = new ArrayList<MessageBean>();
//		// 获取题目难度等级 ： difficulty
//		// 保存题目ID的集合
//		List<Integer> topIdList = new ArrayList<Integer>();
//		// 保存题目答案的集合
//		ArrayList<String> resultList = new ArrayList<String>();
//		// 保存题目说明的集合
//		ArrayList<String> explanationList = new ArrayList<String>();
//		try {
//			// 获取测试题目
//			System.out.println("难度等级：" + difficulty);
//			System.out.println("测试类型：" + course);
//			List<AnswerBean> answerList = exercisesService.QueryExercisesService(difficulty, course);
//			for (int i = 0; i < answerList.size(); i++) {
//				// 保存题目ID
//				topIdList.add(answerList.get(i).getTopId());
//				// 保存题目答案
//				resultList.add(answerList.get(i).getResult());
//				// 保存题目说明
//				explanationList.add((answerList.get(i).getExplanation()) + "##");
//			}
//			// 根据科目ID查询科目名称
//			String subjectName = exercisesService.QuerySubjectService(answerList.get(0).getSubjectName());
//			// 根据测试题ID获取测试题选项
//			List<TopicoptionsBean> topicoptionsList = exercisesService.QueryTopicoptionsService(topIdList);
//			for (int i = 0; i < answerList.size(); i++) {
//				MessageBean messageBean = new MessageBean();
//				messageBean.setKey((i + 1) + "");
//				messageBean.setValue(answerList.get(i).getTopId() + "@@" + answerList.get(i).getTitle() + "@@"
//						+ topicoptionsList.get(i).getA() + "#" + topicoptionsList.get(i).getB() + "#"
//						+ topicoptionsList.get(i).getC() + "#" + topicoptionsList.get(i).getD() + "@@"
//						+ answerList.get(i).getResult() + "@@" + subjectName + "@@" + answerList.get(i).getDifficulty()
//						+ "@@" + answerList.get(i).getExplanation());
//				messageList.add(messageBean);
//			}
//			// 将题目答案放在request域中
//			map.put("resultList", resultList);
//			// 将题目说明放在request域中
//			map.put("explanationList", explanationList);
//			// 将测试科目放在request域中
//			map.put("course", course);
//			// 返回测试题集合给前端显示
//			modelAndView.addObject("messageList", messageList);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
