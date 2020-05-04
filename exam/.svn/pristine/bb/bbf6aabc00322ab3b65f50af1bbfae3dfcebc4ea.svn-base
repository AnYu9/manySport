package com.znsd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.RecordsBean;
import com.znsd.dao.RecordsDao;

@Repository
public class RecordsDaoImp implements RecordsDao{
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public boolean save(RecordsBean record) {
		String sql = "insert into performance (userId,score,paperId,testTime) values (?,?,?,now())";
		return jdbc.update(sql,record.getUserId(),record.getScore(),record.getPaperId())>0?true:false;
	}
	
	public List<RecordsBean> queryAll(int start,int end){
		String sql = "SELECT performance.*,paper.`paperName` FROM performance,paper WHERE performance.`paperId`=paper.`paperId` limit ?,?";
		return jdbc.query(sql, new BeanPropertyRowMapper<RecordsBean>(RecordsBean.class),start,end);
	}

	@Override
	public List<RecordsBean> queryByuserId(String userId) {
		String sql = "SELECT performance.*,paper.`paperName` FROM performance,paper WHERE performance.`paperId`=paper.`paperId` AND userId=?";
		List<RecordsBean> record = jdbc.query(sql, new BeanPropertyRowMapper<RecordsBean>(RecordsBean.class),userId);
		return record;
	}
	@Override
	public List<RecordsBean> conditionFind(ConditionBean[] conditions) {
		String sql="select performance.*,paper.`paperName` FROM performance,paper WHERE performance.`paperId`=paper.`paperId` ";
		sql+=ConditionBean.getCondtionsSql(conditions,false);
		return jdbc.query(sql,new BeanPropertyRowMapper<RecordsBean>(RecordsBean.class), ConditionBean.getCondtionsValues(conditions));
	}
}
