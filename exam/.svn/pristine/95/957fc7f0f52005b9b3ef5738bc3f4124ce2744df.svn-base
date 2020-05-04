package com.znsd.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.ConditionSqlMapper;
import com.znsd.bean.QuestionBean;
import com.znsd.dao.QuestionDao;
import com.znsd.service.QuestionService;
import com.znsd.util.ConditionSqlMapperFactory;


/**
 * 试卷模块;业务层实现类:QuestionServiceImp
 * @author baishui
 *
 */
@Service
public class QuestionServiceImp implements QuestionService{

	@Resource
	private QuestionDao questionDao;
	
	@Override
	public int topicAdd(QuestionBean q) {
		int primarykey = questionDao.topicAdd(q);
		int length=q.getA().length()+q.getB().length()+q.getC().length()+q.getD().length();
		if(length>1) {
			System.out.println("选项有内容...");
			questionDao.topicOptionsAdd(primarykey, q);
		}
		return primarykey;
	}

	@Override
	public Map<String, Object> findQuestions() {
		
		return null;
	}


	@Override
	public int findAllQuestionsCount() {
		return questionDao.findAllQuestionsCount();
	}

	@Override
	public List<QuestionBean> findAllQuestions() {
		return questionDao.findAllQuestions();
	}

	@Override
	public List<QuestionBean> conditionFindQuestions(QuestionBean condition,int begin, int end) {
		try {
		ConditionSqlMapper[] mapper=new ConditionSqlMapper[] {ConditionSqlMapperFactory.likeMapper("title")};
		ConditionBean[] conditions=ConditionBean.beanToConditions(condition,mapper);
		return questionDao.conditionFindQuestions(conditions,begin, end);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public QuestionBean findQuestionsById(String qId) {
		QuestionBean bean = null;
		List<QuestionBean> list = findAllQuestions();
		for (QuestionBean questionBean : list) {
			if(Integer.parseInt(qId)==(questionBean.gettopId())) {
				bean=questionBean;
			}
		}
		return bean;
	}

	@Override
	public int topicDel(String questionId) {
		return questionDao.topicDel(questionId);
	}

	@Override
	public int topicOptionsDel(String questionId) {
		return questionDao.topicOptionsDel(questionId);
	}

	@Override
	public int topicUpdate(QuestionBean q) {
		int result = questionDao.topicUpdate(q);
		int length=q.getA().length()+q.getB().length()+q.getC().length()+q.getD().length();
		if(length>1) {
			System.out.println("选项有内容...");
			questionDao.topicOptionsUpdate(q);
		}
		return result;
	}


	@Override
	public int conditionFindCount(QuestionBean condition) {
		try {
			ConditionSqlMapper[] mapper=new ConditionSqlMapper[] {ConditionSqlMapperFactory.likeMapper("title")};
			ConditionBean[] conditions=ConditionBean.beanToConditions(condition,mapper);
			return questionDao.conditionFindCount(conditions);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

	
}
