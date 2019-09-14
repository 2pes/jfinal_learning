package com.demo.generator;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

import javax.sql.DataSource;

public class ModelGenerator {

    // base model 所使用的包名
    private final static String baseModelPkg = "com.demo.common.model.base";
    // base model 文件保存路径
    private final static String baseModelDir = PathKit.getWebRootPath() + "/src/main/java/com/demo/common/model/base";

    // model 所使用的包名
    private final static String modelPkg = "com.demo.common.model";
    // model 文件保存路径
    private final static String modelDir = baseModelDir + "/..";

    private static DataSource getDataSource() {
        PropKit.use("config-dev.txt");
        DruidPlugin dp = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password"));
        dp.start();
        return dp.getDataSource();
    }

    public static void main(String[] args) {
        Generator generator = new Generator(getDataSource(), baseModelPkg, baseModelDir, modelPkg, modelDir);
        generator.generate();
    }
}
