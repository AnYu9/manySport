package com.znsd.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.bean.AnswerBean;
import com.znsd.bean.TopicoptionsBean;
import com.znsd.dao.ExercisesDao;
import com.znsd.service.ExercisesService;

@Service
public class ExercisesServiceImpl implements ExercisesService {
	@Autowired
	ExercisesDao exercisesDao;

	@Override
	public List<AnswerBean> QueryExercisesService(String difficulty, String course) throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = exercisesDao.QueryExercisesDao(difficulty, course);
		return answerList;
	}

	@Override
	public String QuerySubjectService(Integer subjectId) throws ClassNotFoundException, SQLException {
		String subjectName = exercisesDao.QuerySubjectDao(subjectId);
		return subjectName;
	}

	@Override
	public String QueryAnswerService(List<Integer> topId) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public List<TopicoptionsBean> QueryTopicoptionsService(List<Integer> topIdList)
			throws ClassNotFoundException, SQLException {
		List<TopicoptionsBean> topicoptionsList = exercisesDao.QueryTopicoptionsDao(topIdList);
		return topicoptionsList;
	}

	@Override
	public List<AnswerBean> QueryExercisesTypeXuanService(List<Integer> topIdList)
			throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = exercisesDao.QueryExercisesTypeXuan(topIdList);
		return answerList;
	}

	@Override
	public List<AnswerBean> QueryExercisesTypeTianService(List<Integer> topIdList)
			throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = exercisesDao.QueryExercisesTypeTian(topIdList);
		return answerList;
	}
	
	@Override
	public List<AnswerBean> QueryExercisesTypeWenService(List<Integer> topIdList)
			throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = exercisesDao.QueryExercisesTypeWen(topIdList);
		return answerList;
	}

}
