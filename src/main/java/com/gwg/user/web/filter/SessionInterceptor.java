package com.gwg.user.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器：如果没有session状态直接跳转到/user/login_view地址也就是我们对应的login.jsp页面
 *
 */
public class SessionInterceptor implements HandlerInterceptor{
	
	private static final String SESSION_KEY_USER = "_session_user";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//登录不做拦截
		if(request.getRequestURI().equals("/user/login") || request.getRequestURI().equals("/user/login_view")){
			return true;
		}
		//验证session是否存在
		Object obj = request.getSession().getAttribute(SESSION_KEY_USER);
		if(obj == null){
			response.sendRedirect("/user/login_view");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
