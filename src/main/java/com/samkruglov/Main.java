package com.samkruglov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@EntityScan(basePackageClasses = User.class)
//@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Main {
    
    public static void main(String[] args) {
        
        SpringApplication.run(Main.class, args);
    }
}
