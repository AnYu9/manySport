package com.znsd.controller;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Decoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.znsd.annotation.LogCutional;
import com.znsd.bean.UserBean;
import com.znsd.service.UserService;

/**
 * 用户模块;控制器
 * @author baishui
 *
 */

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/attr/headImg",method=RequestMethod.GET)
	@ResponseBody
	public String getUserHeadImg(String userName) {
		return userService.loadUserHeadImg(userName);
	}

	@RequestMapping(value="/user/attr/headImg",method=RequestMethod.PUT)
	@ResponseBody
	public String setUserHeadImg(String userId,String imgFileData,String imgType,HttpServletRequest request) {

		Decoder decode = Base64.getDecoder();
		
		byte[] byteImg = decode.decode(imgFileData);// 把base64转成字节码

		String realPath = request.getSession().getServletContext().getRealPath("");
		
		String fileName=realPath+"img/headImg/"+userId+"."+imgType;
		
		if(userService.setUserHeadImg(userId,byteImg,fileName)) {
			return "true";
		}
		
		return null;
	}
	

	@RequestMapping("/user/Login")
	@ResponseBody
	public String loginUser(String userName,String password,HttpServletRequest request,HttpServletResponse response) {
		UserBean user=userService.loginUser(userName,password);
		String message=null;
		if(user!=null) {
			request.getSession().setAttribute("user", user);
			if(user.getRoleId()==1) {
				message="examWeb/index.jsp";
			}else if(user.getRoleId()==2) {
				message="menu/main.jsp";
			}else if(user.getRoleId()==3) {
				message="menu/main.jsp";
			}
		}
		if(user.getLoginState().equals("N")) {
			message="userDisable";
		}
		return message;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody
	public Object findUser(UserBean condition) {
		List<UserBean> list=userService.findUser(condition);
		int total = userService.total(condition);
		JSONObject json = new JSONObject();
		json.put("rows", list);
		json.put("total", total);
		return json;
	}
	
	@RequestMapping(value="/user/{userId}",method=RequestMethod.GET)
	@ResponseBody
	public UserBean findUserById(@PathVariable String userId) {
		UserBean user=userService.findUserById(userId);
		return user;
	}

	@LogCutional("添加用户")
	@RequestMapping(value="/user",method=RequestMethod.POST)
	@ResponseBody
	public String addUser(UserBean bean) {
		if(userService.addUser(bean)) {
			return "true";
		}
		return null;
	}

	@LogCutional("修改用户信息")
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	@ResponseBody
	public String updateUser(UserBean bean) {
		if(userService.updateUser(bean)) {
			return "true";
		}
		return null;
	}

	@LogCutional("删除用户")
	@RequestMapping(value="/user",method=RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(String[] userIds) {
		System.out.println(Arrays.toString(userIds));
		int executedCount=userService.removeUser(userIds);
		if(executedCount==userIds.length) {
			return "true";
		}else if(executedCount>0) {
			return executedCount+"";
		}
		return null;
	}
	
	@RequestMapping(value="/system/loginUser",method=RequestMethod.GET)
	@ResponseBody
	public Object getLoginUser(HttpServletRequest request) {
		
		Object userObj=request.getSession().getAttribute("user");
		if(userObj==null) {
			return null;
		}
		String userId=((UserBean)userObj).getUserId();
		return userService.findUserById(userId);
	}
	
	@RequestMapping(value="/system/logoutUser",method=RequestMethod.GET)
	public Object logoutUser(HttpServletRequest request) {
		request.getSession().setAttribute("user",null);
		
		return "redirect: ../login.html";
	}
	
	@RequestMapping(value="/user/attr/total",method=RequestMethod.GET)
	@ResponseBody
	public Integer findUserTotal(UserBean condition) {
		int total = userService.total(condition);
		return total;
	}
}
