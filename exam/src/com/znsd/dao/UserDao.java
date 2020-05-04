package com.znsd.dao;

import java.util.List;

import com.znsd.bean.ConditionBean;
import com.znsd.bean.UserBean;

/**
 * 用户模块;持久层接口:UserDao
 * @author Administrator
 *
 */
public interface UserDao {

	public String loadUserHeadImg(String userName);

	public UserBean loginUser(String userName, String password);

	public List<UserBean> conditionFind(ConditionBean[] conditions);

	public boolean addUser(UserBean bean);

	public boolean conditionUpdateUser(ConditionBean[] setConditions,ConditionBean... whereConditions);

	public int conditionRemoveUser(ConditionBean condition);

	public UserBean findUserById(String userId);

	public int total(ConditionBean[] conditions);
	
}
