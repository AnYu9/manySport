package com.znsd.service;

import java.util.List;
import java.util.Map;

import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;
import com.znsd.bean.UserBean;

/**
 * 题库模块;业务层接口:QuestionService
 * @author baishi
 *
 */
public interface QuestionService {
	/**
	 * 
	 *试题添加
	 *@param：@param question
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月10日上午9:20:00
	 */
	int topicAdd(QuestionBean question);
	
	/**
	 * 
	 *试题删除
	 *@param：@param question
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月10日上午9:20:00
	 */
	int topicDel(String questionId);
	
	/**
	 * 删除试题选项
	 *
	 *@param：@param questionId
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月10日下午7:02:51
	 */
	int topicOptionsDel(String questionId);
	
	/**
	 * 修改试题
	 *
	 *@param：@param q
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月11日下午4:34:27
	 */
	int topicUpdate(QuestionBean q);
	
	Map<String,Object> findQuestions();
	
	/**
	 * 查询所有试题
	 *
	 *@param：@return
	 *@return：List<QuestionBean>
	 *@author：Liu
	 *2020年1月10日下午4:58:02
	 */
	List<QuestionBean> findAllQuestions();
	
	
	/**
	 * 查询所有试题数量
	 *
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月10日下午4:58:42
	 */
	int findAllQuestionsCount();
	
	/**
	 * 根据试题Id查询试题
	 *
	 *@param：@return
	 *@return：List<QuestionBean>
	 *@author：Liu
	 *2020年1月10日下午4:58:02
	 */
	QuestionBean findQuestionsById(String qId);
	
	/**
	 * 分页条件查询所有试题
	 *
	 *@param：@return
	 *@return：List<QuestionBean>
	 *@author：Liu
	 *2020年1月10日下午4:58:02
	 */
	List<QuestionBean> conditionFindQuestions(QuestionBean condition,int begin,int end);
	
	/**
	 * 分页条件查询数量
	 *
	 *@param：@param condition
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月13日下午10:30:40
	 */
	int conditionFindCount(QuestionBean condition);
}
