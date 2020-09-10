package com.listener.runner;

import com.alibaba.fastjson.JSONArray;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * CommandLineRunner实现应用启动后初始化操作
 */
@Component
public class CommandLineRunnerDemo implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Object o = JSONArray.toJSON(args);
        System.out.println("CommandLineRunnerDemo=>run()这个是测试CommandLineRunner接口 :" + o);
    }
}
