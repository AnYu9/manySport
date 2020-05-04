package com.znsd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.bean.ErrorBean;
import com.znsd.dao.impl.ErrorDaoImp;
import com.znsd.service.ErrorService;



/**
 * 错误反馈;业务层实现类：ErrorServiceImp
 * @author baishui
 *
 */
@Service
public class ErrorServiceImp implements ErrorService{

	@Autowired
	ErrorDaoImp dao;
	
	@Override
	public boolean save(ErrorBean error) {
		return dao.save(error);
	}

	@Override
	public List<ErrorBean> queryAll(int start, int end) {
		return dao.queryAll(start, end);
	}

	@Override
	public boolean updateStatus(Integer errorId) {
		return dao.updateStatus(errorId);
	}

	@Override
	public int total() {
		return dao.total();
	}

}
