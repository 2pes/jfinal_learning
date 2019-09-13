package com.demo.common;

import com.demo.interceptor.GlobalInterceptor;
import com.demo.model.Blog;
import com.demo.route.AdminRoute;
import com.demo.route.FrontRoute;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

/**
 * @author Chen
 * @created 2019-09-12-21:13.
 */
public class AppConfig extends JFinalConfig {
	public void configConstant(Constants constants) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("a_little_config.txt");
		constants.setDevMode(PropKit.getBoolean("devMode", false));
	}

	public void configRoute(Routes routes) {
		// routes.add("/", IndexController.class);
		// routes.add("/", IndexController.class, "/abc");
		// routes.add("/blog", BlogController.class, "/blog");
		// routes.add("/user", UserController.class, "/user");
		routes.add(new AdminRoute());// 后端路由
		routes.add(new FrontRoute());// 前端路由
	}

	public void configEngine(Engine engine) {

	}

	public void configPlugin(Plugins plugins) {
		// 配置 druid 数据库连接池插件
		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"),
				PropKit.get("password").trim());
		plugins.add(druidPlugin);

		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		arp.setBaseSqlTemplatePath(PathKit.getWebRootPath() + "/WEB-INF");
		arp.addSqlTemplate("sql/demo.sql");
		arp.addMapping("blog", Blog.class);
		plugins.add(arp);
	}

	public void configInterceptor(Interceptors interceptors) {
		interceptors.add(new GlobalInterceptor());
		// interceptors.addGlobalServiceInterceptor(new
		// InjectInterceptor());//给所有的Service添加拦截器
	}

	public void configHandler(Handlers handlers) {
		// 创建上下文
		handlers.add(new ContextPathHandler("ctx"));
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

	@Override
	public void afterJFinalStart() {
		System.out.println("afterJFinalStart............可以用来启动任务，相当于回调");
	}

	@Override
	public void beforeJFinalStop() {
		super.beforeJFinalStop();
		System.out.println("beforeJFinalStop...");
	}
}
