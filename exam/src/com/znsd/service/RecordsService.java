package com.znsd.service;

import java.util.List;

import com.znsd.bean.RecordsBean;
import com.znsd.bean.UserBean;

public interface RecordsService {
	public boolean save(RecordsBean record);
	
	public List<RecordsBean> queryAll(int start,int end);
	/**
	 * 
	 * @param userId
	 * @return RecordsBean
	 */
	public List<RecordsBean> queryByuserId(String userId);
	
	public List<RecordsBean> findUser(RecordsBean condition);
} 
