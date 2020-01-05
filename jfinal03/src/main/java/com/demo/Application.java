package com.demo;

import com.demo.config.MainConfig;
import com.jfinal.server.undertow.UndertowServer;

public class Application {
    public static void main(String[] args) {
        UndertowServer.start(MainConfig.class, 80, true);
//        JFinal.start("jfinal03/src/main/webapp", 80, "/", 5);
    }
}
