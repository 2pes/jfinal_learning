package com.demo.route;

import com.demo.controller.IndexController;
import com.demo.interceptor.AdminRouteInterceptor;
import com.jfinal.config.Routes;

/**
 * @author Chen
 * @created 2019-09-12-23:51.
 */
public class AdminRoute extends Routes {
    public void config() {
        setBaseViewPath("/WEB-INF");
        addInterceptor(new AdminRouteInterceptor());
        add("/admin", IndexController.class);

    }
}
