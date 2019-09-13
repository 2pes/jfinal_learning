package com.demo.controller;

import com.demo.service.ServiceImpl;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;

/**
 * @author Chen
 * @created 2019-09-12-21:23.
 */
public class IndexController extends Controller {

	/**
	 * action定义的模板，必须是public和void类型
	 */
	public void index() {
		String msg = getPara("msg", "DefaultMsg");
		String[] v = getParaValues("test"); // checkbox
		setAttr("msg", "HELLO, JFINAL3.0---->" + msg);
		// getModel(Blog.class); //getModel用法
		renderTemplate("index.html"); // 声明渲染到index.html
	}

	private void testInjectMethod() {
		ServiceImpl service = Duang.duang(ServiceImpl.class);
		service.testInject();
		service.common();
		renderTemplate("index.html");
	}

}
