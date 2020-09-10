package com.listener;

import com.alibaba.fastjson.JSONArray;
import com.listener.runner.ApplicationContextInitializerDemo;
import com.listener.runner.ApplicationEventDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationListenerApplication {

    public static void main(String[] args) {
        Object o = JSONArray.toJSON(args);
        System.out.println("SpringBootApplication=>main()启动前：" + o);
        //ConfigurableApplicationContext context = SpringApplication.run(ApplicationListenerApplication.class, args);

        //ApplicationContext上下文初始化
        SpringApplication application = new SpringApplication(ApplicationListenerApplication.class);
        application.addInitializers(new ApplicationContextInitializerDemo());
        ConfigurableApplicationContext context = application.run(args);

        System.out.println("SpringBootApplication=>main()启动后....");


        //发布事件
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationListenerApplication.class);
        ApplicationEventDemo event = new ApplicationEventDemo("发布事件源");
        context.publishEvent(event);


    }

}
