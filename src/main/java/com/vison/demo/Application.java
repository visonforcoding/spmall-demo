package com.vison.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class Application {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(Application.class, args);
        log.info(String.format("spring version is : %s",SpringVersion.getVersion()));
    }

}
