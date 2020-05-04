package com.znsd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.ConditionSqlMapper;
import com.znsd.bean.RecordsBean;
import com.znsd.bean.UserBean;
import com.znsd.dao.impl.RecordsDaoImp;
import com.znsd.service.RecordsService;
import com.znsd.util.ConditionSqlMapperFactory;

@Service
public class RecordsServiceImp implements RecordsService{

	@Autowired
	RecordsDaoImp dao;
	@Override
	public boolean save(RecordsBean record) {
		return dao.save(record);
	}
	@Override
	public List<RecordsBean> queryAll(int start,int end) {
		return dao.queryAll(start, end);
	}
	@Override
	public List<RecordsBean> queryByuserId(String userId) {
		return dao.queryByuserId(userId);
	}
	@Override
	public List<RecordsBean> findUser(RecordsBean condition) {
		try {
			ConditionSqlMapper[] mapper=new ConditionSqlMapper[] {ConditionSqlMapperFactory.likeMapper("userId")};
			ConditionBean[] conditions=ConditionBean.beanToConditions(condition,mapper);
			return dao.conditionFind(conditions);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
