package com.znsd.dao;

import java.util.List;

import com.znsd.bean.ErrorBean;

/**
 * 错误反馈;持久层接口：ErrorDao
 * @author baishui
 *
 */
public interface ErrorDao {
	/**
	 * -添加
	 * @param error
	 * @return boolean
	 */
	public boolean save(ErrorBean error);
	/**
	 * -查询
	 * @param start
	 * @param end
	 * @return List<ErrorBean>
	 */
	public List<ErrorBean> queryAll(int start,int end);

	/**
	 * 
	 * @param errorId
	 * @return boolean
	 */
	public boolean updateStatus(Integer errorId);
	/**
	 * 
	 * @return int
	 */
	public int total();
}
