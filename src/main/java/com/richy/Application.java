package com.richy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author Richy
 * @date 2020/12/27/0027 17:55
 */
@SpringBootApplication
public class Application {

    private final static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logger.info(Application.class.getSimpleName() + " is success!");
    }
}
