package com.znsd.service;

import java.util.List;

import com.znsd.bean.LogBean;

/**
 * 系统日志;业务层接口:LogService
 * @author baishui
 * 
 *
 */
public interface LogService {
	/**
	 * -增加日志
	 * @param log
	 * @return boolean
	 */
	public boolean save(String userId,String exucuteName,boolean executedResult);
	/**
	 * -查询所有日志
	 * @param Start
	 * @param end
	 * @return List<LogBean>
	 */
	public List<LogBean> queryAll(int Start,int end);
	/**
	 * 
	 * @return int
	 */
	public int total();
	
}
