package com.znsd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.znsd.bean.ErrorBean;
import com.znsd.dao.ErrorDao;


/**
 * 错误反馈;持久层实现类：ErrorDaoImp
 * @author baishui
 *
 */
@Component
public class ErrorDaoImp implements ErrorDao{

	@Autowired
	JdbcTemplate jdbc;
	@Override
	public boolean save(ErrorBean error) {
		String sql = "insert into error (errordes,userId,topicId,paperId) values (?,?,?,?)";
		return jdbc.update(sql,error.getErrordes(),error.getUserId(),error.getTopicId(),error.getPaperId())>0?true:false;
	}

	@Override
	public List<ErrorBean> queryAll(int start,int end) {
		String sql = "select * from error limit ?,?";
		List<ErrorBean> list = jdbc.query(sql, new BeanPropertyRowMapper<ErrorBean>(ErrorBean.class),start,end);
		return list;
	}

	@Override
	public boolean updateStatus(Integer errorId) {
		String sql = "UPDATE error SET `status`='已处理' WHERE errorId=?";
		return jdbc.update(sql, errorId)>0?true:false;
	}

	@Override
	public int total() {
		String sql = "SELECT COUNT(*) FROM error";
		return jdbc.queryForObject(sql, Integer.class);
	}
}
