package com.znsd.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.bean.LogBean;
import com.znsd.dao.impl.LogDaoImp;
import com.znsd.service.LogService;


/**
 * 系统日志;业务层实现类:LogServiceImp
 * @author baishui
 *
 */
@Service
public class LogServiceImp implements LogService{
	@Autowired
	LogDaoImp dao;
	
	@Override
	public boolean save(String userId,String exucuteName,boolean executedResult) {
		StringBuilder logdes=new StringBuilder();
    	logdes.append("用户");
    	logdes.append(userId);
    	
    	logdes.append("在");
    	String date=new SimpleDateFormat("yyyy-mm-dd").format(new Date(System.currentTimeMillis()));
    	logdes.append(date);
    	
    	logdes.append("进行了{");
    	logdes.append(exucuteName);
    	logdes.append("}，并操作");
    	
    	if(executedResult) {
        	logdes.append("成功");
    	}else {
        	logdes.append("失败");
    	}
    	logdes.append("了");
    	
    	LogBean log = new LogBean();
    	log.setUserId(userId);
    	log.setLogdes(logdes.toString());
		return dao.save(log);
	}

	@Override
	public List<LogBean> queryAll(int start, int end) {
		return dao.queryAll(start, end);
	}

	@Override
	public int total() {
		return dao.total();
	}

}
