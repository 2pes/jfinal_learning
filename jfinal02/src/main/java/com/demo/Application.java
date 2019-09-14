package com.demo;

import com.demo.common.JFinal02Config;
import com.jfinal.server.undertow.UndertowServer;

/**
 * @author Chen
 * @created 2019-09-14-20:28.
 */
public class Application {
    public static void main(String[] args) {
        UndertowServer.start(JFinal02Config.class);
    }
}
