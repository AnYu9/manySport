package com.znsd.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.znsd.bean.AnswerBean;
import com.znsd.bean.TopicoptionsBean;

//测试题
public interface ExercisesService {
	/**
	 * 获取测试题目
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesService(String difficulty, String course) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据题目ID找到对应的选择题
	 * @param topList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesTypeXuanService(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据题目ID找到对应的填空题
	 * @param topList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesTypeTianService(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据题目ID找到对应的问答题
	 * @param topList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesTypeWenService(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据科目ID查询科目名称
	 * @param subjectId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	String QuerySubjectService(Integer subjectId) throws ClassNotFoundException, SQLException;
	
	/**
	 * 获取测试题答案
	 * @param topId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	String QueryAnswerService(List<Integer> topId) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据测试题ID获取测试题选项
	 * @param topIdList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<TopicoptionsBean> QueryTopicoptionsService(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
}
