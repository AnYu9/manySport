package com.znsd.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.znsd.bean.ConditionBean;
import com.znsd.bean.QuestionBean;
import com.znsd.dao.QuestionDao;


/**
 * 题库模块;持久层实现类:QuestionDaoImp
 * @author baishui
 *
 */
@Repository
public class QuestionDaoImp implements QuestionDao{

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int topicAdd(QuestionBean q) {
		//String sql = "insert into topic(title,result,subjectId,difficulty,type,score) values(?,?,?,?,?,?)";
		String sql = "insert into topic(title,result,subjectName,difficulty,type,score) values('"+q.getTitle()+"','"+q.getResult()+"',"+q.getSubjectName()+",'"+q.getDifficulty()+"',"+q.getType()+","+q.getScore()+")";
		//int result = jt.update(sql, q.getTitle(),q.getResult(),q.getSubjectName(),q.getDifficulty(),q.getType(),q.getScore());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jt.update(new PreparedStatementCreator() {
			@Override
			public java.sql.PreparedStatement createPreparedStatement(java.sql.Connection arg0) throws SQLException {
				PreparedStatement ps = arg0.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, keyHolder);
		System.out.println("新增加的primarykey："+keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}
	
	public int topicOptionsAdd(int topicId,QuestionBean q) {
		String sql = "insert into topicoptions(topId,a,b,c,d) values(?,?,?,?,?)";
		int result = jt.update(sql, topicId,q.getA(),q.getB(),q.getC(),q.getD());
		return result;
	}
	
	@Override
	public int topicDel(String qId) {
		String sql = "DELETE FROM topic WHERE topId=?";
		int result = jt.update(sql, qId);
		return result;
	}

	@Override
	public int topicOptionsDel(String qId) {
		String sql = "DELETE FROM topicoptions WHERE topId=?";
		int result = jt.update(sql, qId);
		return result;
	}
	
	@Override
	public List<QuestionBean> findAllQuestions() {
		String sql="SELECT * FROM(SELECT topic.`topId`,topic.`title`,topic.`result`,`subject`.`subjectName`,topic.`difficulty`,topictype.`type`,topic.`score`,t.a,t.b,t.c,t.d FROM topic LEFT JOIN topictype ON topic.`type`=topictype.`typeId` LEFT JOIN `subject` ON topic.`subjectName`=`subject`.`subjectId` LEFT JOIN topicoptions t ON topic.topId=t.`topId` ) t";
		List<QuestionBean> list = jt.query(sql, new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class));
		return list;
	}

	@Override
	public int findAllQuestionsCount() {
		String sql = "SELECT COUNT(*) FROM topic";
		int count = jt.queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public int topicUpdate(QuestionBean q) {
		String typeId = findTypeId(q.getType());
		String subjectId = findSubjectId(q.getSubjectName());
		String sql="UPDATE topic SET title=?,result=?,subjectName=?,difficulty=?,`type`=?,explanation=?,score=? WHERE topId=?";
		int updateResult = jt.update(sql,q.getTitle(),q.getResult(),subjectId,q.getDifficulty(),typeId,q.getExplanation(),q.getScore(),q.gettopId());
		return updateResult;
	}
	
	private String findTypeId(String type) {
		String sql = "SELECT `typeId` FROM topictype WHERE TYPE=?";
		String id = "";
		id = jt.queryForObject(sql, String.class,type);
		return id;
	}
	
	private String findSubjectId(String subjectName) {
		String sql = "SELECT subjectId FROM SUBJECT WHERE subjectName=?";
		String id = "";
		id = jt.queryForObject(sql, String.class,subjectName);
		return id;
	}

	@Override
	public int topicOptionsUpdate(QuestionBean q) {
		String sql = "UPDATE topicoptions SET a=?,b=?,c=?,d=? WHERE topId=?";
		int updateResult = jt.update(sql,q.getA(),q.getB(),q.getC(),q.getD(),q.gettopId());
		return updateResult;
	}
	
	@Override
	public List<QuestionBean> conditionFindQuestions(ConditionBean[] conditions,int begin, int end) {
		String sql="SELECT * FROM(SELECT topic.`topId`,topic.`title`,topic.`result`,`subject`.`subjectName`,topic.`difficulty`,topictype.`type`,topic.`score`,t.a,t.b,t.c,t.d FROM topic LEFT JOIN topictype ON topic.`type`=topictype.`typeId` LEFT JOIN `subject` ON topic.`subjectName`=`subject`.`subjectId` LEFT JOIN topicoptions t ON topic.topId=t.`topId`) t";
		sql+=ConditionBean.getCondtionsSql(conditions,true);
		sql+=" limit ?,?";
		Object[] condtionsValues=ConditionBean.getCondtionsValues(conditions);
		Object[] allValues=new Object[condtionsValues.length+2];
		for(int i=0;i<condtionsValues.length;i++) {
			allValues[i]=condtionsValues[i];
		}
		allValues[allValues.length-2]=begin;
		allValues[allValues.length-1]=end;
		/*System.out.println(sql);
		for(int i = 0;i<allValues.length;i++) {
			System.out.println(allValues[i]);
		}*/
		List<QuestionBean> list = jt.query(sql, new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class), allValues);
		return list;
	}

	@Override
	public int conditionFindCount(ConditionBean[] conditions) {
		String sql="SELECT COUNT(1) FROM(SELECT topic.`topId`,topic.`title`,topic.`result`,`subject`.`subjectName`,topic.`difficulty`,topictype.`type`,topic.`score`,t.a,t.b,t.c,t.d FROM topic LEFT JOIN topictype ON topic.`type`=topictype.`typeId` LEFT JOIN `subject` ON topic.`subjectName`=`subject`.`subjectId` LEFT JOIN topicoptions t ON topic.topId=t.`topId`) t";
		sql+=ConditionBean.getCondtionsSql(conditions,true);
		Object[] condtionsValues=ConditionBean.getCondtionsValues(conditions);
		Integer count = jt.queryForObject(sql, Integer.class, condtionsValues);
		return count;
	}
	
}