package com.asyncq.springboot.logging.controller;

import java.sql.Timestamp;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/{name}")
    public String getWelcomeMessage(@PathVariable("name") String name) throws InterruptedException {
        logger.trace("received request for welcome/name with %s.".formatted(name));
        long start = System.currentTimeMillis();
        Thread.sleep(10); // time spent in logic execution
        long end = System.currentTimeMillis();
        logger.info("Spent %d ms in execution".formatted(end - start));
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("debug");
        return "Welcome to Spring Boot, %s".formatted(name);
    }

    @GetMapping("/log")
    public void getLogged(){
        logger.trace("trace");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        logger.debug("debug");
    }

}
