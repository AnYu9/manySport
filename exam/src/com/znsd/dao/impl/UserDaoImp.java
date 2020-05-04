package com.znsd.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.UserBean;
import com.znsd.dao.UserDao;


/**
 * 用户模块;持久层实现类:UserDaoImp
 * @author baishui
 *
 */
@Repository
public class UserDaoImp implements UserDao{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public String loadUserHeadImg(String userName) {
		String sql="select headImg from user where userId = ? or email = ?";
		SqlRowSet row=template.queryForRowSet(sql, userName,userName);
		if(row.next()) {
			return row.getString("headImg");
		}
		return null;
	}

	@Override
	public UserBean loginUser(String userName, String password) {
		String sql="select * from user where password=?  and userId = ? or email = ? ";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class), password,userName,userName);
	}

	@Override
	public List<UserBean> conditionFind(ConditionBean[] conditions) {
		String sql="select * from user";
		sql+=ConditionBean.getCondtionsSql(conditions,true);
		return template.query(sql,new BeanPropertyRowMapper<UserBean>(UserBean.class), ConditionBean.getCondtionsValues(conditions));
	}

	@Override
	public boolean addUser(UserBean bean) {
		String sql="insert into user(userId,userName,password,email,sex,age,roleId,loginState,integral) values(?,?,?,?,?,?,1,'N',0)";
		return template.update(sql, bean.getUserId(),bean.getUserName(),bean.getPassWord(),bean.getEmail(),bean.getSex(),bean.getAge())>0;
	}

	@Override
	public boolean conditionUpdateUser(ConditionBean[] setConditions,ConditionBean... whereConditions) {
		String sql="update user";
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

		return template.update(sql, allValues)>0;
	}

	@Override
	public int conditionRemoveUser(ConditionBean condition) {
		String sql="delete from user where";
		sql+=condition.getName();
		return template.update(sql, condition.getValue());
	}

	@Override
	public UserBean findUserById(String userId) {
		String sql="select * from user where userId = ?";
		return template.queryForObject(sql, new BeanPropertyRowMapper<UserBean>(UserBean.class), userId);
	}

	@Override
	public int total(ConditionBean[] conditions) {
		String sql="select COUNT(userId) from user";
		sql+=ConditionBean.getCondtionsSql(conditions,true);
		SqlRowSet row=template.queryForRowSet(sql, ConditionBean.getCondtionsValues(conditions));
		if(row.next()) {
			return row.getInt(1);
		}
		return 0;
	}
	
}
