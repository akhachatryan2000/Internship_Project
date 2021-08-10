package com.margin.listener;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

    public static final String WELCOME_TEXT = "Welcome to Java internship . I hope this will be a great journey for you.";

    @EventListener(ContextRefreshedEvent.class)
    public void onContextRefreshedEvent() {
    }
}
