package com.gwg.user.configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gwg.user.web.filter.SessionInterceptor;

/**
 * 继承WebMvcConfigurerAdapter采用JavaBean形式实现个性化配置定制。
 * WebMvcConfigureAdapter该抽象类里面其实没有任何的方法实现，只是空实现了接口WebMvcConfigurer内的全部方法，并没有给出任何的业务
 * 逻辑处理
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	

    /**
     * 拦截器配置
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	/**
    	 * addPathPatterns方法用于设置拦截器的过滤路径规则
    	 */
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**");
    }
}
