package com.znsd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.znsd.bean.SubjectBean;
import com.znsd.dao.SubjectDao;
import com.znsd.service.SubjectService;


/**
 * 科目模块;业务层实现类:SubjecServiceImp
 * @author baishui
 *
 */
@Service
public class SubjecServiceImp implements SubjectService{
	
	@Resource
	private SubjectDao subjectDao;

	@Override
	public int subjectAdd(SubjectBean subject) {
		return subjectDao.subjectAdd(subject);
	}

	@Override
	public int subjectDel(String subjectId) {
		return subjectDao.subjectDel(subjectId);
	}

	@Override
	public int subjectUpdate(SubjectBean subject) {
		return subjectDao.subjectUpdate(subject);
	}

	@Override
	public List<SubjectBean> findSubject(int begin ,int end) {
		return subjectDao.findSubject(begin,end);
	}

	@Override
	public SubjectBean findSubjectById(String subjectId) {
		return subjectDao.findSubjectById(subjectId);
	}

	@Override
	public SubjectBean findSubjectByName(String subjectName) {
		return subjectDao.findSubjectByName(subjectName);
	}

	@Override
	public List<SubjectBean> findSubjectLikeName(String subjectName) {
		return subjectDao.findSubjectLikeName(subjectName);
	}

	@Override
	public int findSubjectAllCount() {
		return subjectDao.findSubjectAllCount();
	}

	@Override
	public List<SubjectBean> findSubject() {
		return subjectDao.findSubject();
	}

}
