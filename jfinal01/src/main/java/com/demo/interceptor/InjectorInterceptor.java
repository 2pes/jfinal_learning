package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class InjectorInterceptor implements Interceptor {

	public void intercept(Invocation arg0) {
		System.out.println("InjectorInterceptor..........");
		arg0.invoke();
	}

}
