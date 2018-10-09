package com.gwg.user.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 1.@EnableWebMvc启用Springmvc
 * 2.配置Springmvc, 继承WebMvcConfigurerAdapter采用JavaBean形式实现个性化配置定制。
 * WebMvcConfigureAdapter该抽象类里面其实没有任何的方法实现，只是空实现了接口WebMvcConfigurer内的全部方法，并没有给出任何的业务
 * 逻辑处理
 *
 * Springboot在使用swagger2的时候，如果使用了@EnableWebMvc配置，就相当于使用了WebMvcConfigurationSupport来配置Springmvc，
 * 而不是使用Springboot提供的自动配置来配置Springmvc的，两者的配置是有区别的。
 * Springboot的自动配置mvc的配置具体见spring-boot-autoconfigure-1.5.3.RELEASE.jar中WEB自动配置的源码(主要是WebMvcAutoConfiguration和ResourceProperties)
 *
 * **************使用Springboot web自动配置的资源映射满足了swagger2的资源映射配置*****************************************
 * 使用Springboot的web自动配置项，已经提供了
 * 把类路径下的/static、/public、/resources和/META-INF/resources文件夹的静态文件直接映射为/**,
 * webjar就是将我们常用的脚本框架封装在jar包中的jar包，把webjar的/META-INF/resources/webjars/下的静态文件映射为/webjar/
 * 因此如果没配置@EnableWebMvc注解就不用再配置资源映射了
 * 参考：https://blog.csdn.net/zxzzxzzxz123/article/details/70238626
 * *******************************************************************
 *
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //WebMvcConfigurationSupport
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
