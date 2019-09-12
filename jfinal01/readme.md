JFinal从入门到入魔教程

# Jfinal3.0系列教程
## 第一讲 环境和helloworld
### 使用Eclipse+Maven构建JFinal的HelloWorld项目步骤：
- 配置MAVEN
- 安装eclipse Maven插件
- 设置eclipse Maven插件的相关配置
- pom.xml中填写JFinal的相关依赖描述，并且等待依赖包下载完成
- 创建MyConfig配置类
- web.xml中进行JFinal配置
- 建立Controller，并且继承JFinal的Controller
- 建立Route映射
- 编写JFinal的Jetty启动方法，并且启动项目
- 浏览器输入访问地址，看结果

## 第二讲 JFinalConfig
- 此方法用来配置`JFinal`常量 值，如开发模式常量 值，如开发模式`devMode`的配置 ，如下代码配置了运行在开发模式       
    ```java
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }
    ```
- `PropKit`工具类用来操作外部配置文件。PropKit可以极度方便地在系统任意时空使用，如下     
    ```java
    public void configConstant(Constants me) {
        // 第一次使用use加载的配置将成为主配置，可以通过PropKit.get(...)直接取值
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode"));
    }
    ```

## 第三讲 路由
能区分下面两行的区别
```java

add("/blog", BlogController.class);
add("/blog", BlogController.class,"/blog");
```

### 路由分包
1. JFinal路由还可以进行拆分配置，这对大规模团队开发特别有用，以下是代码示例 ：    
    ```java
    public void configRoute(Routes me) {
        me.add(new FrontRoutes()); // 前端路由
        me.add(new AdminRoutes()); // 后端路由
    }
    ......
    public class FrontRoutes extends Routes {
        public void config() {
        setBaseViewPath("/view/front");
        add("/", IndexController.class);
        add("/blog", BlogController.class);
        }
    }
    
    ......
    public class AdminRoutes extends Routes {
        public void config() {
        setBaseViewPath("/view/admin");
        addInterceptor(new AdminInterceptor());
        add("/admin", AdminController.class);
        add("/admin/user", UserController.class);
        }
    }
    ```

2. 路由级别的拦截器     
    - 实现`Interceptor`
    - 执行`invocation.invoke();`


## 第十四讲.AOP简述
### Interceptor的分类
- Method Interceptor 方法级别
- Class Interceptor 类级别 当前类中的所有方法都有效
- Router Interceptor 路由级别 当前路由中所有方法都有效
- Global Interceptor 全局拦截 web请求所有的请求方法进行拦截
- Inject Interceptor 业务注入拦截器 对指定需要被注入的方法有效，可以是整个业务类，也可以某个方法

拦截器栈 多个Interceptor进行组合形成的拦截器栈

注解：
Before 添加拦截
Clear  清除拦截

## 第20讲.Interceptor总结	
### 拦截器的优先级
1、Global
2、Inject（InjectInterceptor RouteInterceptor）
3、Class
4、Method