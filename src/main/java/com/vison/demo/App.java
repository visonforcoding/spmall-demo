package com.vison.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
public class App {

    public static ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);;

    public App() {
        log.info("app init..");
    }
}
