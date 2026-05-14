package com.cyn.udas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cyn.udas.mapper")
public class UdasApplication {

    public static void main(String[] args) {
        SpringApplication.run(UdasApplication.class, args);
    }

}
