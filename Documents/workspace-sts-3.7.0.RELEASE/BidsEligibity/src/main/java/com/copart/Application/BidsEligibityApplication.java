package com.copart.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class BidsEligibityApplication {

    public static void main(String[] args) {
        SpringApplication.run(BidsEligibityApplication.class, args);
    }
}
