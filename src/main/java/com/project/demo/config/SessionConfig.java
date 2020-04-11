package com.project.demo.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@WebListener
public class SessionConfig implements HttpSessionListener {

    private final AtomicInteger counter;

    public SessionConfig() {
        super();
        counter = new AtomicInteger();
    }

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {

        log.info("New session is created :: {}, total :: {}", sessionEvent.getSession().getId(), counter.get());
        counter.incrementAndGet();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        counter.decrementAndGet();
        log.info("Session destroyed :: {}, total :: {}", sessionEvent.getSession().getId(), counter.get());
    }
}