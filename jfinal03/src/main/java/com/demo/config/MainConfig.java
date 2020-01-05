package com.demo.config;

import com.demo.controller.HelloController;
import com.demo.controller.PhotoController;
import com.jfinal.config.*;
import com.jfinal.template.Engine;

public class MainConfig extends JFinalConfig {

    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    public void configRoute(Routes me) {
        me.add("/", HelloController.class);
        me.add("/photo", PhotoController.class);
    }

    public void configEngine(Engine me) {
    }

    public void configPlugin(Plugins me) {
    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }
}