package com.znsd.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.znsd.bean.AnswerBean;
import com.znsd.bean.TopicoptionsBean;
import com.znsd.dao.ExercisesDao;

//测试题实现类
@Component
public class ExercisesDaoImpl implements ExercisesDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<AnswerBean> QueryExercisesDao(String difficulty, String course) throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM topic top WHERE top.subjectName = \r\n" + 
				"(\r\n" + 
				"	SELECT sub.`subjectId` FROM SUBJECT sub WHERE sub.subjectName=? \r\n" + 
				") \r\n" + 
				"AND top.difficulty = ?";
		List<AnswerBean> answerList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AnswerBean.class), new Object[] {course,difficulty});
		return answerList;
	}

	@Override
	public List<AnswerBean> QueryExercisesTypeXuan(List<Integer> topIdList) throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = new ArrayList<AnswerBean>();
		for(int i = 0; i<topIdList.size(); i++) {
			String sql = "select * from topic where topId = ? and type=1";//1：选择题
			List<AnswerBean> answerBean = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AnswerBean.class), topIdList.get(i));
			if (answerBean.toString().equals("[]")) {
				
			}else {
				answerList.add(answerBean.get(0));
			}
		}
		return answerList;
	}

	@Override
	public List<AnswerBean> QueryExercisesTypeTian(List<Integer> topIdList) throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = new ArrayList<AnswerBean>();
		for(int i = 0; i<topIdList.size(); i++) {
			String sql = "select * from topic where topId = ? and type=2";//2：填空题
			List<AnswerBean> answerBean = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AnswerBean.class), topIdList.get(i));
			if (answerBean.toString().equals("[]")) {
				
			}else {
				answerList.add(answerBean.get(0));
			}
		}
		return answerList;
	}
	
	@Override
	public List<AnswerBean> QueryExercisesTypeWen(List<Integer> topIdList) throws ClassNotFoundException, SQLException {
		List<AnswerBean> answerList = new ArrayList<AnswerBean>();
		for(int i = 0; i<topIdList.size(); i++) {
			String sql = "select * from topic where topId = ? and type=3";//3：问答题
			List<AnswerBean> answerBean = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AnswerBean.class), topIdList.get(i));
			if (answerBean.toString().equals("[]")) {
				
			}else {
				answerList.add(answerBean.get(0));
			}
		}
		return answerList;
	}
	
	@Override
	public String QuerySubjectDao(Integer subjectId) throws ClassNotFoundException, SQLException {
		String sql = "select subjectName from subject where subjectId=?";
		String subjectName = jdbcTemplate.queryForObject(sql, String.class, subjectId);
		return subjectName;
	}

	@Override
	public String QueryAnswerDao(List<Integer> topIdList) throws ClassNotFoundException, SQLException {
		
		return null;
	}

	@Override
	public List<TopicoptionsBean> QueryTopicoptionsDao(List<Integer> topIdList)
			throws ClassNotFoundException, SQLException {
		List<TopicoptionsBean> topicoptionsList = new ArrayList<TopicoptionsBean>();
			for(int x = 0; x<topIdList.size(); x++) {
				String sql = "select * from topicoptions where topId=?";
				List<TopicoptionsBean> topList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(TopicoptionsBean.class),topIdList.get(x));
				if (topList.toString().equals("[]")) {
					
				}else {
					topicoptionsList.add(topList.get(0));
				}
			}
			return topicoptionsList;
	}
}
