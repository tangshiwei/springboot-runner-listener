package com.listener.runner;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationContextInitializerDemo implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializerDemo=>initialize():上下文初始化器" + configurableApplicationContext.getId());
    }
}
