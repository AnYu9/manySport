package com.znsd.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.znsd.annotation.LogCutional;
import com.znsd.bean.ConditionBean;
import com.znsd.bean.ConditionSqlMapper;
import com.znsd.bean.UserBean;
import com.znsd.dao.UserDao;
import com.znsd.service.UserService;
import com.znsd.util.ConditionSqlMapperFactory;


/**
 * 用户模块;业务层实现类:UserServiceImp
 * @author baishui
 *
 */
@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public String loadUserHeadImg(String userName) {
		return userDao.loadUserHeadImg(userName);
	}

	@Override
	public UserBean loginUser(String userName, String password) {
		UserBean user=null;
		try {
			user=userDao.loginUser(userName,password);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}

	@Override
	public List<UserBean> findUser(UserBean condition) {
		try {
			ConditionSqlMapper mapper=ConditionSqlMapperFactory.likeMapper("userId");
			ConditionBean[] conditions=ConditionBean.beanToConditions(condition,new ConditionSqlMapper[] {mapper});
			return userDao.conditionFind(conditions);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(UserBean bean) {
		return userDao.addUser(bean);
	}

	@Override
	public boolean updateUser(UserBean bean) {
		try {
			ConditionBean[] setConditions=ConditionBean.beanToConditions(bean,null,"userId");
			String sqlMapper=ConditionSqlMapperFactory.equalsMapper("userId").getConditionSql();
			ConditionBean userIdCondition= new ConditionBean(sqlMapper,new Object[] {bean.getUserId()});
			return userDao.conditionUpdateUser(setConditions,userIdCondition);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int removeUser(String[] values) {
		try {
			String sqlMapper = ConditionSqlMapperFactory.inMapper("userId", values.length).getConditionSql();
			ConditionBean condition=new ConditionBean(sqlMapper,values);
			return userDao.conditionRemoveUser(condition);
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public UserBean findUserById(String userId) {
		
		return userDao.findUserById(userId);
	}

	@Override
	public boolean setUserHeadImg(String userId, byte[] imgFileData, String fileName) {
		File file=new File(fileName);
		try {
			if(file.exists()) {
				file.delete();
			}
			file.createNewFile();
			OutputStream out=new FileOutputStream(file);
			out.write(imgFileData);
			out.flush();
			out.close();
			
			UserBean user=new UserBean();
			user.setUserId(userId);
			user.setHeadImg(fileName.substring(fileName.lastIndexOf("/")+1));
			return this.updateUser(user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int total(UserBean condition) {
		ConditionSqlMapper mapper=ConditionSqlMapperFactory.likeMapper("userId");
		ConditionBean[] conditions;
		try {
			conditions = ConditionBean.beanToConditions(condition,new ConditionSqlMapper[] {mapper});
			return userDao.total(conditions);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
