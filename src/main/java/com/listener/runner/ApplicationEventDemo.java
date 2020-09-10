package com.listener.runner;

import org.springframework.context.ApplicationEvent;

public class ApplicationEventDemo extends ApplicationEvent {
    public ApplicationEventDemo(Object source) {
        super(source);
    }
}
