package com.lc.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Administrator on 2016/9/6.
 */
@SpringBootApplication
@EnableScheduling
public class Application {
    public static void main(String[]args){
        SpringApplication.run(Application.class,args);
    }
}
