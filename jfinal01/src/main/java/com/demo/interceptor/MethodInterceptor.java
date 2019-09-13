package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodInterceptor implements Interceptor {

	public void intercept(Invocation invocation) {
		System.out.println("Method Interceptor...");
		invocation.invoke();
	}

}
