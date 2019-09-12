package com.demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

/**
 * @author Chen
 * @created 2019-09-13-0:05.
 */
public class FrontRouteInterceptor implements Interceptor {
    public void intercept(Invocation invocation) {
        System.out.println("front interceptor........");
        invocation.invoke();//需要加这一步
    }
}
