package com.demo.common;

import com.demo.route.AdminRoute;
import com.demo.route.FrontRoute;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.template.Engine;

/**
 * @author Chen
 * @created 2019-09-12-21:13.
 */
public class AppConfig extends JFinalConfig {
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
    }

    public void configRoute(Routes routes) {
        routes.add(new AdminRoute());//后端路由
        routes.add(new FrontRoute());//前端路由
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

    @Override
    public void afterJFinalStart() {
        System.out.println("afterJFinalStart............可以用来启动任务，相当于回调");
    }
}
