package com.znsd.dao;

import java.util.*;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;

/**
 * 题库模块;持久层接口:QuestionDao
 * @author baishui
 *
 */
public interface QuestionDao {

	/**
	 * 
	 *试题添加
	 *@param：@param question
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月10日上午9:20:00
	 */
	int topicAdd(QuestionBean q);
	
	/**
	 * 试题选项添加
	 *
	 *@param：@param topicId
	 *@param：@param q
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月11日下午4:33:28
	 */
	int topicOptionsAdd(int topicId,QuestionBean q);
	
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
	
	/**
	 * 修改试题选项
	 *
	 *@param：@param q
	 *@param：@return
	 *@return：int
	 *@author：Liu
	 *2020年1月11日下午4:34:27
	 */
	int topicOptionsUpdate(QuestionBean q);
	
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
	 * 分页条件查询所有试题
	 *
	 *@param：@return
	 *@return：List<QuestionBean>
	 *@author：Liu
	 *2020年1月10日下午4:58:02
	 */
	List<QuestionBean> conditionFindQuestions(ConditionBean[] conditions,int begin,int end);
	
	/**
	 * 分页条件查询数量
	 *
	 *@param：@return
	 *@return：List<QuestionBean>
	 *@author：Liu
	 *2020年1月10日下午4:58:02
	 */
	int conditionFindCount(ConditionBean[] conditions);
	
}
