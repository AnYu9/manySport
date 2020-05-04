package com.znsd.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor{
	/**
	 * 渲染页面完成之后调用
	 * 使用场景：做一些销毁工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
	}
	/**
	 * 调用目标方法之后，在渲染页面之前调用
	 * 使用场景：
	 * 1.需要改变request对象中的值
	 * 2.需要修改modelAndView中的值
	 * 3.修改转向的视图
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
	}
	/**
	 * 进入目标方法之前调用
	 * 返回true：则继续调用后续的拦截器和目标方法
	 * 返回false：则不会调用后续的拦截器和目标方法
	 * 使用场景：权限控制、日志处理、事务...
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		
		arg0.setCharacterEncoding("utf-8");
		arg1.setCharacterEncoding("utf-8");
		return true;
	}

}
