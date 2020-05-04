package com.znsd.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.PaperBean;
import com.znsd.bean.QuestionBean;
import com.znsd.bean.TopicType;
import com.znsd.dao.PaperDao;


/**
 * 璇曞嵎妯″潡;鎸佷箙灞傚疄鐜扮被:PaperDaoImp
 * @author baishui
 *
 */
@Repository
public class PaperDaoImp implements PaperDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public PaperBean findPaperById(String id) {
		PaperBean bean = null;
		String sql = "select paperId,paperName,userName,TestEnd,subject.subjectName,Anwer,TestDate,testSource FROM paper,subject where paper.subjectName = subject.subjectId AND paperId = ?";
		bean = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(PaperBean.class),id);
		return bean;
	}

	@Override
	public int remove(String id) {
		String sql = "DELETE FROM paper WHERE paperId=?";
		return jdbcTemplate.update(sql,id);
	}

	@Override
	public Integer total(ConditionBean[] conditions) {
		String sql = "SELECT COUNT(1) FROM (SELECT p.`paperId`,p.`paperName`,p.`userName`,p.`Testend`,p.`Anwer`,`subject`.`subjectName`,p.`Testdate`,p.`testSource` FROM paper p,`subject` WHERE p.`subjectName`=`subject`.`subjectId`) t";
		sql+=ConditionBean.getCondtionsSql(conditions,true);
		Object[] conditionsValues=ConditionBean.getCondtionsValues(conditions);
		Integer total = jdbcTemplate.queryForObject(sql, Integer.class,conditionsValues);
		return total;
	}

	@Override
	public Map<String, List<QuestionBean>> assemble(Integer id) {
		Map<String, List<QuestionBean>> map= new LinkedHashMap<>();
		String sql = "SELECT Anwer FROM paper where paperId=?";
		String tmId = jdbcTemplate.queryForObject(sql, String.class,id);
		System.out.println("试题Id："+tmId);
		String[] tmIds = tmId.split(",");
		List<QuestionBean> temp = new ArrayList<>();
		for (int i = 0; i < tmIds.length; i++) {
			temp.add(problemById(Integer.parseInt(tmIds[i])));
		}
		for (QuestionBean questionBean : temp) {
			String type=questionBean.getType();
			for (String key:map.keySet()) {
				if(key.equals(type)) {
					break;
				}
			}
			map.put(type,new ArrayList<QuestionBean>());
			
		}
		for (QuestionBean questionBean : temp) {
			String type=questionBean.getType();
			for (String key:map.keySet()) {
				if(key.equals(type)) {
					map.get(key).add(questionBean);
				}
			}
		}
		
		return map;
	}
	
	public QuestionBean problemById(Integer id){
		String sql = "SELECT * FROM(SELECT topic.`topId`,topic.`title`,topic.`result`,`subject`.`subjectName`,topic.`difficulty`,topictype.`type`,topic.`score`,t.a,t.b,t.c,t.d FROM topic LEFT JOIN topictype ON topic.`type`=topictype.`typeId` LEFT JOIN `subject` ON topic.`subjectName`=`subject`.`subjectId` LEFT JOIN topicoptions t ON topic.topId=t.`topId`) t WHERE t.topId=?";
		QuestionBean bean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<QuestionBean>(QuestionBean.class),id);
		return bean;
	}

	@Override
	public List<PaperBean> limitQueryAllPaper(ConditionBean[] conditions,int start, int end) {
		List<PaperBean> list = new ArrayList<PaperBean>();
		String sql = "SELECT * FROM (SELECT p.`paperId`,p.`paperName`,p.`userName`,p.`Testend`,p.`Anwer`,`subject`.`subjectName`,p.`Testdate`,p.`testSource` FROM paper p,`subject` WHERE p.`subjectName`=`subject`.`subjectId`) t";
		sql+=ConditionBean.getCondtionsSql(conditions,true);
		sql+=" limit ?,?";
		Object[] conditionsValues=ConditionBean.getCondtionsValues(conditions);
		Object[] allValues=new Object[conditionsValues.length+2];
		for(int i=0;i<conditionsValues.length;i++) {
			allValues[i]=conditionsValues[i];
		}
		allValues[allValues.length-2]=start;
		allValues[allValues.length-1]=end;
		
		System.out.println(sql);
		for(int i = 0;i<allValues.length;i++) {
			System.out.println("条件"+i+"："+allValues[i]);
		}
		
		list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PaperBean>(PaperBean.class),allValues);
		for (PaperBean paperBean : list) {
			//System.out.println(paperBean);
		}
		return list;
	}

	@Override
	public List<TopicType> findTopicTypes() {
		String sql ="SELECT * FROM topictype";
		List<TopicType> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<TopicType>(TopicType.class));
		return list;
	}

	@Override
	public int paperAdd(PaperBean bean) {
		String sql = "INSERT INTO paper(paperName,userName,testend,subjectName,anwer,Testdate,testSource) VALUES(?,?,?,?,?,?,?)";
		int result = jdbcTemplate.update(sql,bean.getPaperName(),bean.getuserName(),bean.getTestEnd(),bean.getSubjectName(),bean.getAnwer(),bean.getTestdate(),bean.getTestSource());
		return result;
	}

	@Override
	public List<PaperBean> findAllQuestion() {
		String sql = "select * from paper";
		List<PaperBean> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<PaperBean>(PaperBean.class));
		return list;
	}

	@Override
	public int paperUpdate(ConditionBean[] setConditions,ConditionBean... whereConditions) {
		String sql ="update paper";
		sql+=ConditionBean.getCondtionsUpdateSql(setConditions,true);
		sql+=ConditionBean.getCondtionsSql(whereConditions,true);
		Object[] setValues=ConditionBean.getCondtionsValues(setConditions);
		Object[] whereValues=ConditionBean.getCondtionsValues(whereConditions);
		Object[] allValues=new Object[setValues.length+whereValues.length];
		
		for(int i=0;i<setValues.length;i++) {
			allValues[i]=setValues[i];
		}
		for(int i=setValues.length;i<allValues.length;i++) {
			allValues[i]=whereValues[i-setValues.length];
		}
		return jdbcTemplate.update(sql,allValues);
	}
}
