package com.znsd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.bean.GradeBean;
import com.znsd.dao.impl.GradeDaoImp;
import com.znsd.service.GradeService;

/**
 * 班级模块;业务层实现类:GradeServiceImp
 * @author baishui
 *
 */

@Service
public class GradeServiceImp implements GradeService{
	@Autowired
	private GradeDaoImp dao;

	@Override
	public boolean save(GradeBean grade) {
		return dao.save(grade);
	}

	@Override
	public List<GradeBean> QueryAll(int start, int end) {
		return dao.QueryAll(start,end);
	}

	@Override
	public int total() {
		return dao.total();
	}

	@Override
	public boolean remove(Integer[] classIds) {
		return dao.removeSelect(classIds);
	}

	@Override
	public boolean update(GradeBean grade) {
		return dao.update(grade);
	}
	
}
