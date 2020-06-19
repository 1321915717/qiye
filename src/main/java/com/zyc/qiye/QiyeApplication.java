package com.zyc.qiye;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyc.qiye.mapper")
public class QiyeApplication {

    public static void main(String[] args) {
        SpringApplication.run(QiyeApplication.class, args);
    }

}
