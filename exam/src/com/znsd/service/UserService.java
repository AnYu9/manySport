package com.znsd.service;

import java.util.List;

import com.znsd.bean.UserBean;

public interface UserService {

	public String loadUserHeadImg(String userName);

	public UserBean loginUser(String userName, String password);

	public List<UserBean> findUser(UserBean condition);

	public boolean addUser(UserBean bean);

	public boolean updateUser(UserBean bean);

	public int removeUser(String[] values);

	public UserBean findUserById(String userId);

	public boolean setUserHeadImg(String userId, byte[] byteImg, String fileName);

	public int total(UserBean condition);

}
