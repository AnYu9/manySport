package com.znsd.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.znsd.bean.LogBean;
import com.znsd.dao.LogDao;


/**
 * 系统日志;持久层实现类:LogDaoImp
 * @author baishui
 *
 */
@Repository
public class LogDaoImp implements LogDao{
	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public boolean save(LogBean log) {
		String sql = "INSERT INTO `log` (logdes,userId,logdate) VALUES (?,?,now())";
		return jdbc.update(sql,log.getLogdes(),log.getUserId())>0?true:false;
	}

	@Override
	public List<LogBean> queryAll(int start, int end) {
		String sql = "SELECT * FROM `log` limit ?,?";
		List<LogBean> list = jdbc.query(sql, new BeanPropertyRowMapper<LogBean>(LogBean.class),start,end);
		return list;
	}

	@Override
	public int total() {
		String sql = "SELECT COUNT(*) FROM `log`";
		return jdbc.queryForObject(sql, Integer.class);
	}
}
