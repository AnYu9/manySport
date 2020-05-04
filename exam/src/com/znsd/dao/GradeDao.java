package com.znsd.dao;

import java.util.List;

import com.znsd.bean.GradeBean;

/**
 * 班级模块;持久层接口:GradeDao
 * @author baishui
 *
 */
public interface GradeDao {
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
	public List<GradeBean> QueryAll(int start,int end);
	/**
	 * -获取class表数据总数
	 * @return total
	 */
	public int total();
	/**
	 * -根据id删除班级
	 * @param grade
	 * @return boolean
	 */
	public boolean remove(int classId);
	/**
	 * -批量删除
	 * @param list
	 * @return boolean
	 */
	public boolean removeSelect(Integer[] classIds);
	/**
	 * -修改
	 * @param grade
	 * @return boolean
	 */
	public boolean update(GradeBean grade);
}
