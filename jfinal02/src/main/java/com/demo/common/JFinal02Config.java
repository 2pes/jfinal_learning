package com.demo.common;

import com.demo.controller.HelloController;
import com.jfinal.config.*;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

/**
 * @author Chen
 * @created 2019-09-14-18:31.
 */
public class JFinal02Config extends JFinalConfig {
    public static Prop p;

    // 先加载开发环境配置，再追加生产环境的少量配置覆盖掉开发环境配置
    static void loadConfig() {
        if (p == null) {
            p = PropKit.use("config-dev.txt").appendIfExists("config-pro.txt");
        }
    }

    public void configConstant(Constants me) {
        me.setDevMode(p.getBoolean("devMode", false));
        me.setJsonFactory(MixedJsonFactory.me());

        me.setBaseDownloadPath(PathKit.getWebRootPath());
        me.setJsonDatePattern("yyyy-MM-dd HH:mm:ss");

    }

    public void configRoute(Routes me) {

        me.add("/hello", HelloController.class);
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

