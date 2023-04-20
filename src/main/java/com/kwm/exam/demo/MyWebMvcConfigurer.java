package com.kwm.exam.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kwm.exam.demo.interceptor.BeforeActionInterceptor;
import com.kwm.exam.demo.interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
	// BeforeActionInterceptor 불러오기
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;

	// 인터셉터 적용 역할
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/error")
				.excludePathPatterns("/resource/**");
		
		registry.addInterceptor(needLoginInterceptor)
				.addPathPatterns("/usr/article/write")
				.addPathPatterns("/usr/article/doWrite")
				.addPathPatterns("/usr/article/modify")
				.addPathPatterns("/usr/article/doModify")
				.addPathPatterns("/usr/article/doDelete");
	}
}
