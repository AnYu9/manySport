package com.znsd.service;

import java.util.List;

import com.znsd.bean.ErrorBean;

/**
 * 错误反馈;业务层接口：ErrorService
 * @author baishui
 *
 */
public interface ErrorService {
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
