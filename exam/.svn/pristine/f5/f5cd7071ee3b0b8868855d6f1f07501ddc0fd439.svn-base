package com.znsd.dao;

import java.util.List;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.RecordsBean;

public interface RecordsDao {
	/**
	 * 
	 * @param record
	 * @return boolean
	 */
	public boolean save(RecordsBean record);
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @return List<RecordsBean>
	 */
	public List<RecordsBean> queryAll(int start,int end);
	/**
	 * 
	 * @param userId
	 * @return RecordsBean
	 */
	public List<RecordsBean> queryByuserId(String userId);
	
	public List<RecordsBean> conditionFind(ConditionBean[] conditions);
}
