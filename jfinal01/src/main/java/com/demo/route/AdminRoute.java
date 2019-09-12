package com.demo.route;

import com.demo.controller.IndexController;
import com.jfinal.config.Routes;

/**
 * @author Chen
 * @created 2019-09-12-23:51.
 */
public class AdminRoute extends Routes {
    public void config() {
        setBaseViewPath("/WEB-INF");
        //addInterceptor(new AdminInterceptor());
        add("/admin", IndexController.class);

    }
}
