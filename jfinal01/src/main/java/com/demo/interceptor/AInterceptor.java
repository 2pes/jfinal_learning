package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AInterceptor implements Interceptor {

	public void intercept(Invocation invocation) {
		System.out.println("A intercept...");
		invocation.invoke();
	}

}
