package com.znsd.service;

import java.util.List;

import com.znsd.bean.SubjectBean;

/**
 * 科目模块;业务层接口:SubjectService
 * 
 * @author baishui
 *
 */
public interface SubjectService {

	/**
	 * 
	 * 科目增加
	 * 
	 * @param：@param subject
	 * @return：void
	 * @author：Liu 2020年1月9日上午10:36:36
	 */
	int subjectAdd(SubjectBean subject);

	/**
	 * 科目删除
	 *
	 * @param：@param subjectId
	 * @return：void
	 * @author：Liu 2020年1月9日上午10:37:16
	 */
	int subjectDel(String subjectId);

	/**
	 * 科目修改
	 *
	 * @param：@param subject
	 * @return：void
	 * @author：Liu 2020年1月9日上午10:38:08
	 */
	int subjectUpdate(SubjectBean subject);

	/**
	 * 分页查询所有科目
	 *
	 * @param：@return
	 * @return：List<SubjectBean>
	 * @author：Liu 2020年1月9日上午10:38:52
	 */
	List<SubjectBean> findSubject(int begin, int end);

	/**
	 * 查询所有科目
	 *
	 * @param：@return
	 * @return：List<SubjectBean>
	 * @author：Liu 2020年1月9日上午10:38:52
	 */
	List<SubjectBean> findSubject();

	/**
	 * 按id查询科目
	 */
	SubjectBean findSubjectById(String subjectId);

	/**
	 * 按科目名查询科目
	 *
	 * @param：@param subjectName
	 * @param：@return
	 * @return：SubjectBean
	 * @author：Liu 2020年1月9日上午10:52:25
	 */
	SubjectBean findSubjectByName(String subjectName);

	/*
	 * 按科目名模糊查询科目
	 *
	 * @param：@param subjectName
	 * 
	 * @param：@return
	 * 
	 * @return：SubjectBean
	 * 
	 * @author：Liu 2020年1月9日上午10:52:25
	 */
	List<SubjectBean> findSubjectLikeName(String subjectName);

	/**
	 * 查询所有科目数量
	 *
	 * @param：@return
	 * @return：int
	 * @author：Liu 2020年1月9日下午5:08:48
	 */
	int findSubjectAllCount();
}
