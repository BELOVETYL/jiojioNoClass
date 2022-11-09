package com.xl.jiojionoclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JiojioNoClassApplication {
    public static void main(String[] args) {
        SpringApplication.run(JiojioNoClassApplication.class, args);
    }
}
