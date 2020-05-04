package com.znsd.dao;

import java.util.List;

import com.znsd.bean.LogBean;

/**
 * 系统日志;持久层接口:LogDao
 * @author baishui
 *
 */
public interface LogDao {
	/**
	 * -增加日志
	 * @param log
	 * @return boolean
	 */
	public boolean save(LogBean log);
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
