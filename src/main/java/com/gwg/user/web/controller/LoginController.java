package com.gwg.user.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gwg.user.dto.UserDto;

/**
 * 自Spring4.3开始推荐使用注解来解决一个类中多个方法
 */
@Controller
@RequestMapping("/user")
public class LoginController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 在这里为了简单起见，内存数据库
	 */
	private Map<String, UserDto> userDB = new HashMap<String, UserDto>(); 
	
	{
		UserDto user = new UserDto();
		user.setAccount("13817191469");
		user.setPassword("111111");
		userDB.put("13817191469", user);
	}

	
	
	/**
	 * 
	 */
	@RequestMapping(value = "login", method=RequestMethod.GET)
	public  String login(@RequestBody UserDto userDto){
		UserDto entity = userDB.get(userDto.getAccount());
		
		if(entity == null || !entity.getPassword().equals(userDto.getPassword())){
			LOG.info("登录失败");
			return "login";
		}
		
		LOG.info("登录成功");
		return "index";
	}

}
