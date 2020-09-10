package com.listener.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * <pre>
 * SpringApplicationRunListener
 * 接口的作用主要就是在Spring Boot启动初始化的过程中
 * 可以通过SpringApplicationRunListener接口回调来让用户在启动的各个流程中可以加入自己的逻辑。
 *
 * Spring Boot启动过程的关键事件（按照触发顺序）包括：
 *
 *     开始启动
 *     Environment构建完成
 *     ApplicationContext构建完成
 *     ApplicationContext完成加载
 *     ApplicationContext完成刷新并启动
 *     启动完成
 *     启动失败
 * </pre>
 */

//在Spring中也有一种类似与Java SPI的加载机制。它在META-INF/spring.factories文件中配置接口的实现类名称，然后在程序中读取这些配置文件并实例化。
//这种自定义的SPI机制是Spring Boot Starter实现的基础。

//我们可能需要实现一些SDK或者Spring Boot Starter给被人使用时，
//我们就可以使用Factories机制。Factories机制可以让SDK或者Starter的使用只需要很少或者不需要进行配置，只需要在服务中引入我们的jar包即可。


public class SpringApplicationRunListenerDemo implements SpringApplicationRunListener {

    // 注意要加上这个构造器，两个参数都不能少，否则启动会报错，报错的详情可以看这个类的最下面
    public SpringApplicationRunListenerDemo(SpringApplication application, String[] args) {
        System.out.println("SpringApplicationRunListenerDemo=>构造函数");
    }

    // 在run()方法开始执行时，该方法就立即被调用，可用于在初始化最早期时做一些工作
    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListenerDemo=>starting(): 程序开始启动");
    }

    // 当environment构建完成，ApplicationContext创建之前，该方法被调用
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("SpringApplicationRunListenerDemo=>environmentPrepared(): environment构建完成");
    }

    // 当ApplicationContext构建完成时，该方法被调用
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListenerDemo=>contextPrepared(): ApplicationContext构建完成时");
    }

    // 在ApplicationContext完成加载，但没有被刷新前，该方法被调用
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListenerDemo=>contextLoaded(): ApplicationContext完成加载，但没有被刷新前");
    }

    // 在ApplicationContext刷新并启动后，CommandLineRunners和ApplicationRunner未被调用前，该方法被调用
    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListenerDemo=>started(): CommandLineRunners和ApplicationRunner未被调用前");
    }

    // 在run()方法执行完成前该方法被调用
    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListenerDemo=>running(): run()方法执行完成前该方法被调用");
    }

    // 当应用运行出错时该方法被调用
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("SpringApplicationRunListenerDemo=>failed(): 当应用运行出错时该方法被调用");
    }
}
