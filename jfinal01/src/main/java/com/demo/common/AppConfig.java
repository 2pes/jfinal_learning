package com.demo.common;

import com.demo.controller.IndexController;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

/**
 * @author Chen
 * @created 2019-09-12-21:13.
 */
public class AppConfig extends JFinalConfig {
	public void configConstant(Constants constants) {

	}

	public void configRoute(Routes routes) {
		routes.add("/", IndexController.class);
	}

	public void configEngine(Engine engine) {

	}

	public void configPlugin(Plugins plugins) {

	}

	public void configInterceptor(Interceptors interceptors) {

	}

	public void configHandler(Handlers handlers) {

	}

	public static void main(String[] args) {
		/**
		 * 特别注意：Eclipse 之下建议的启动方式
		 */
		// JFinal.start("src/main/webapp", 80, "/", 5);

		/**
		 * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
		 */
		JFinal.start("src/main/webapp", 80, "/");
	}
}
