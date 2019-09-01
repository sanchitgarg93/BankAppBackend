package com.myapp.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Component
public class InterceptorAppConfig extends WebMvcConfigurerAdapter {

	@Autowired
	PreHandler preHandler;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(preHandler);
	}

}
