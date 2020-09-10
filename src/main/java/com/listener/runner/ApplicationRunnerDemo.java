package com.listener.runner;

import com.alibaba.fastjson.JSONArray;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunner实现应用启动后初始化操作
 */
@Component
public class ApplicationRunnerDemo implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Object o = JSONArray.toJSON(args);
        System.out.println("ApplicationRunnerDemo=>run():这个是测试ApplicationRunner接口 " + o);
    }
}
