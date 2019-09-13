package com.demo.service;

import com.demo.interceptor.InjectorInterceptor;
import com.jfinal.aop.Before;

public class ServiceImpl {

	@Before(InjectorInterceptor.class)	
	public void testInject() {
		System.out.println("testInject");

	}

	public void common() {
		System.out.println("common");
	}
}
