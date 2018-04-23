package com.gwg.user.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 自Spring4.3开始推荐使用注解来解决一个类中多个方法
 * 添加初始化登录，首页页面转发配置
 */
@Controller
@RequestMapping("/user")
public class IndexController {
	
	/**
	 * 初始化登录页面
	 */
	@RequestMapping(value="/login_view", method=RequestMethod.GET)
	public String login_view(){
	    return "login";	
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	

}
