package com.example.do_it_academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DoItAcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoItAcademyApplication.class, args);
    }

}
