package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ClassInterceptor implements Interceptor {

	public void intercept(Invocation invocation) {
		System.out.println("Class Interceptor...");
		invocation.invoke();
	}
	
}
