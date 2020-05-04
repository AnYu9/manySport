package com.znsd.service;

import java.util.List;

import com.znsd.bean.GradeBean;

public interface GradeService {
	/**
	 * -班级增加
	 * @param grade
	 * @return boolean
	 */
	public boolean save(GradeBean grade);
	
	/**
	 * -班级查询
	 * @param start
	 * @param end
	 * @return	List<GradeBean>
	 */
	public List<GradeBean> QueryAll(int start, int end);
	
	public int total();
	/**
	 * -批量删除
	 * @param list
	 * @return boolean
	 */
	public boolean remove(Integer[] classIds);
	
	/**
	 * -修改
	 * @param grade
	 * @return boolean
	 */
	public boolean update(GradeBean grade);
}
