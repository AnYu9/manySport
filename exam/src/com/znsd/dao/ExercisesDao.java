package com.znsd.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.znsd.bean.AnswerBean;
import com.znsd.bean.TopicoptionsBean;

//测试题
public interface ExercisesDao {
	/**
	 * 获取测试题
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesDao(String difficulty, String course) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据题目ID找到对应的选择题
	 * @param topList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesTypeXuan(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据题目ID找到对应的填空题
	 * @param topList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesTypeTian(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据题目ID找到对应的问答题
	 * @param topList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<AnswerBean> QueryExercisesTypeWen(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据科目ID查询科目名称
	 * @param subjectId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	String QuerySubjectDao(Integer subjectId) throws ClassNotFoundException, SQLException;
	
	/**
	 * 获取测试题答案
	 * @param topId
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	String QueryAnswerDao(List<Integer> topId) throws ClassNotFoundException, SQLException;
	
	/**
	 * 根据测试题ID获取测试题选项
	 * @param topIdList
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	List<TopicoptionsBean> QueryTopicoptionsDao(List<Integer> topIdList) throws ClassNotFoundException, SQLException;
}

