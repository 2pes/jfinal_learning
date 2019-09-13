package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class GlobalInterceptor implements Interceptor {

	public void intercept(Invocation invocation) {
		System.out.println("Global Interceptor...");
		invocation.invoke();
	}
	
}
